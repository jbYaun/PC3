package com.examen.pc3.dao;

import com.examen.pc3.dto.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DaoImpl implements Dao{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Connection connection;

    private void obtenerConexion(){
        try {
            connection = jdbcTemplate.getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cerrarConexion(){
        try {
            connection.commit();
            connection.close();;
            connection=null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Empleado> obtenerEmpleados(){
        List<Empleado> lista = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT nombres_empleados, apellidos_empleados, codigo_departamento\n").
                append(" FROM empleado");
        obtenerConexion();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sb.toString());
            while (resultSet.next()){
                Empleado empleado = new Empleado();
                empleado.setNombres(resultSet.getString("nombres_empleados"));
                empleado.setApellidos(resultSet.getString("apellidos_empleados"));
                empleado.setCodigoDepartamento(resultSet.getString("codigo_departamento"));
                lista.add(empleado);
            }
            resultSet.close();
            statement.close();
            cerrarConexion();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return lista;
    }

}

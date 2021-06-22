package com.examen.pc3.servicio;

import com.examen.pc3.dao.Dao;
import com.examen.pc3.dto.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ServicioImpl implements Servicio{
    @Autowired
    private Dao dao;

    public List<Empleado> obtenerEmpleados() {
        List<Empleado> lista = new ArrayList<>();
        try {
            lista = dao.obtenerEmpleados();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}

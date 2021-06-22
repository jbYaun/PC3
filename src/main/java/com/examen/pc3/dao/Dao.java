package com.examen.pc3.dao;

import com.examen.pc3.dto.Empleado;

import java.sql.SQLException;
import java.util.List;

public interface Dao {
    public List<Empleado> obtenerEmpleados() throws SQLException;
}

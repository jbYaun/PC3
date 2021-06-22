package com.examen.pc3.dto.respuesta;

import com.examen.pc3.dto.Empleado;
import lombok.Data;

import java.util.List;

@Data
public class RespuestaEmpleado {
    private List<Empleado> Lista;
}

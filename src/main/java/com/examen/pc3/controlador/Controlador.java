package com.examen.pc3.controlador;

import com.examen.pc3.dto.respuesta.RespuestaEmpleado;
import com.examen.pc3.servicio.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {

    @Autowired
    private Servicio servicio;
    @RequestMapping(value = "/obtener-empleados",
            method = RequestMethod.POST,
            produces = "application/json;charset=utf-8",
            consumes = "application/json;charset=utf-8"
    )

    public @ResponseBody RespuestaEmpleado obtenerEmpleados(){
        RespuestaEmpleado respuestaEmpleado = new RespuestaEmpleado();
        respuestaEmpleado.setLista(servicio.obtenerEmpleados());
        return respuestaEmpleado;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otros;

import java.util.Date;

/**
 *
 * @author seba
 */
public class ResultadoConsultaSeguimiento {
    public Date fecha;
    public String descripcion;
    public String localidad;

    public ResultadoConsultaSeguimiento(Date fecha, String descripcion, String localidad) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.localidad = localidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    
    
}

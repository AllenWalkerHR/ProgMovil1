package com.example.azaa0.notas_fragments.model;

/**
 * Created by alcohonsilver on 27/10/16.
 */
public class NotaTarea {
    int id;
    String titulo;
    String descripcion;
    int tipo;
    String hora_fecha;

    public NotaTarea() {

    }


    public int getHora_fecha_vencimiento() {
        return hora_fecha_vencimiento;
    }

    public void setHora_fecha_vencimiento(int hora_fecha_vencimiento) {
        this.hora_fecha_vencimiento = hora_fecha_vencimiento;
    }

    private int hora_fecha_vencimiento;

    public NotaTarea(int id, String titulo, String descripcion,
                     int tipo, String hora_fecha, int hora_fecha_vencimiento) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.hora_fecha = hora_fecha;
        this.hora_fecha_vencimiento = hora_fecha_vencimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getHora_fecha() {
        return hora_fecha;
    }

    public void setHora_fecha(String hora_fecha) {
        this.hora_fecha = hora_fecha;
    }






}

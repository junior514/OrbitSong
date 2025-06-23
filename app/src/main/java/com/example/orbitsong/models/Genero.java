package com.example.orbitsong.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Genero implements Serializable {
    @SerializedName("id")
    private Long id;

    @SerializedName("nombre")
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

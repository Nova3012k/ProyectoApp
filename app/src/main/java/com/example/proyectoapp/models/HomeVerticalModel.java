package com.example.proyectoapp.models;

public class HomeVerticalModel {

    int imagen;
    String nombre;
    String temporizador;
    String rating;
    String precio;

    public HomeVerticalModel(int imagen, String nombre, String temporizador, String rating, String precio) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.temporizador = temporizador;
        this.rating = rating;
        this.precio = precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTemporizador() {
        return temporizador;
    }

    public void setTemporizador(String temporizador) {
        this.temporizador = temporizador;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}

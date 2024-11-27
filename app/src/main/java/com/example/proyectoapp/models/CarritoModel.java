package com.example.proyectoapp.models;

public class CarritoModel {

    int imagen;
    String nombre;
    String precio;
    String rating;

    public CarritoModel(int imagen, String nombre, String precio, String rating) {
        this.imagen = imagen;
        this.nombre= nombre;
        this.precio = precio;
        this.rating = rating;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

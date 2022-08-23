package com.antoniaggo.loginclients;

public class Usuario {
    private String nombre;
    private String telefono;
    private String email;
    private int Year, Month, Day;

    public Usuario(String nombre, String telefono, String email, int year, int month, int day) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        Year = year;
        Month = month;
        Day = day;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public int getMonth() {
        return Month;
    }

    public void setMonth(int month) {
        Month = month;
    }

    public int getDay() {
        return Day;
    }

    public void setDay(int day) {
        Day = day;
    }
}

package model;

public class Estudiante {

    private String nombre;
    private String email;
    private String rut;

    public Estudiante(String nombre, String email, String rut) {
        this.nombre = nombre;
        this.email = email;
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut){
        this.rut = rut;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + nombre + ", email=" + email + ", rut=" + rut + '}';
    }
}

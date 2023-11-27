package model;

import java.util.ArrayList;

public class Curso {
    private ArrayList<Estudiante> listaEstudiantes;

    public Curso() {
        this.listaEstudiantes = new ArrayList<>();
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public boolean existeEstudiante(String rut) {
        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.getRut().equals(rut)) {
                return true;
            }
        }
        return false;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        if (!existeEstudiante(estudiante.getRut())) {
            listaEstudiantes.add(estudiante);
        }
    }

    public Estudiante buscarEstudiante(String rut) {
        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.getRut().equals(rut)) {
                return estudiante;
            }
        }
        return null;
    }

    public void mostrarEstudiantes() {
        for (Estudiante estudiante : listaEstudiantes) {
            System.out.println(estudiante.toString());
        }
    }

    public void eliminarEstudiante(String rut) {
        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.getRut().equals(rut)) {
                listaEstudiantes.remove(estudiante);
                break;
            }
        }
    }
}
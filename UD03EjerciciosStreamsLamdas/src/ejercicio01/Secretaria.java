package ejercicio01;

import java.util.List;

public class Secretaria {
    private List<Alumno> listadoAlumnos;

    public Secretaria(List<Alumno> listadoAlumnos) {
        this.listadoAlumnos = listadoAlumnos;
    }

    public List<Alumno> getListadoAlumnos() {
        return listadoAlumnos;
    }

    public void setListadoAlumnos(List<Alumno> listadoAlumnos) {
        this.listadoAlumnos = listadoAlumnos;
    }

    @Override
    public String toString() {
        return "Secretaria{" +
                "listadoAlumnos=" + listadoAlumnos +
                '}';
    }


}

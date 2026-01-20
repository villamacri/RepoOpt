package ejercicio04;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Administracion {

    private List<Empleado> listado;

    public Administracion(List<Empleado> listado) {
        this.listado = listado;
    }

    public List<Empleado> getListado() {
        return listado;
    }

    public void setListado(List<Empleado> listado) {
        this.listado = listado;
    }

    @Override
    public String toString() {
        return "Administracion{" +
                "listado=" + listado +
                '}';
    }

    public void addEmpleado(Empleado e){
        listado.add(e);
    }

    public Optional<Empleado> getEmpleado(String nombre){
        Optional<Empleado>empleadoBuscado = listado.stream()
                .filter(e -> e.getNombre().equals(nombre))
                .collect(Collectors.toList()).stream().findAny()

        return empleadoBuscado;
    }

    public void getEmpleados(){

        mediaSalario=

        listado.stream()
                .filter(e -> e.isActivo() && e.getSalario()>mediaSalario)
    }
}

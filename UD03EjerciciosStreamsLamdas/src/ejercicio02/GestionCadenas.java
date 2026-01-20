package ejercicio02;

import java.util.List;

public class GestionCadenas {
    private List<String> listaCadenas;

    public GestionCadenas(List<String> listaCadenas) {
        this.listaCadenas = listaCadenas;
    }

    public List<String> getListaCadenas() {
        return listaCadenas;
    }

    public void setListaCadenas(List<String> listaCadenas) {
        this.listaCadenas = listaCadenas;
    }

    @Override
    public String toString() {
        return "GestionCadenas{" +
                "listaCadenas=" + listaCadenas +
                '}';
    }

    public void ordenarCadenas(){
        listaCadenas.stream()
                .sorted()
                .forEach(cadena -> System.out.printf("%s", cadena));
    }

    public boolean findByCadena(String buscada){
        return listaCadenas.stream()
                .anyMatch(n -> (n.equals(buscada)));
    }

    public void crearCadena(){
       
    }


}

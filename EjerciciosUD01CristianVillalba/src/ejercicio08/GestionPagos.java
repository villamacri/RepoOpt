package ejercicio08;

public class GestionPagos{

    private Plataform[]listado;

    public GestionPagos(Plataform[] listado) {
        this.listado = listado;
    }

    public Plataform[] getListado() {
        return listado;
    }

    public void setListado(Plataform[] listado) {
        this.listado = listado;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "GestionPagos{" +
                "listado=" + java.util.Arrays.toString(listado) +
                '}';
    }


}
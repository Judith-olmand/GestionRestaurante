public class Pedido {
    /**
     * Creamos un array para almacenar los platos
     *
     */
    private Plato[] platos;
    private int contador;
    final int capacidadMaxima = 10;



    public Pedido() {
        platos = new Plato[capacidadMaxima];
        contador = 0;
    }

    public boolean agregarPlato(Plato plato) {
        if (contador < cantidad) {
            platos[contador] = plato;
            contador++;
            return true;
        }
        return false;
    }

    public void mostrarPedido(){
        System.out.println("cantidad de platos" + contador);
        for (Plato plato : platos) {
            System.out.println(plato.toString());
        }
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public Plato[] getPlatos() {
        return platos;
    }

    public void setPlatos(Plato[] platos) {
        this.platos = platos;
    }
}

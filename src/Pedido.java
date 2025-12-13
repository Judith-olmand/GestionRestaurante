public class Pedido {
    /**
     * Creamos un array para almacenar los platos
     * un contador para saber cuantos llevamos almacenados
     * y una constante para limitar el tamaño del array
     */
    private Plato[] platos;
    private int contador;
    private static final int capacidadMaxima = 10;

    public int getContador() {
        return contador;
    }

    /**
     * Creo el array de tamaño fijo, y empieza en vacio (0)
     */
    public Pedido() {
        platos = new Plato[capacidadMaxima];
        contador = 0;
    }

    /**
     * creo un metodo para agregar platos con una excepción, compruebo si el array esta lleno y si lo está se lanza el mensaje
     * Si no se crea el siguiente plato en el siguiente hueco vacio del array y se suma 1 al contador.     *
     * @param plato
     * @throws Exception
     */
    public void agregarPlato(Plato plato) throws  Exception {
        if (contador >= capacidadMaxima) {
            throw new Exception("El pedido está lleno. No se pueden agregar más platos");
        }
        platos[contador] = plato;
        contador++;
        System.out.println("Plato " + plato.getNombre() + " agregado correctamente.");
    }

    /**
     * Creo un metodo para calcular el total del pedido
     * @return
     */
    public double calcularTotal() {
        double total = 0;
        if (contador == 0){
            System.out.println("El pedido está vacio.");
        }
        /**
         * Recorro solo las posiciones ocupadas.
         */
        for (int i = 0; i < contador; i++) {
            total = total + platos[i].calcularPrecio();
        }
        return total;
    }

    /**
     * Sobrecargo el metodo anterior que recibe por parametro la propina
     * @param propina
     * @return
     */
    public double calcularTotal(double propina) {
        if (propina < 0) {
            propina = 0;
        }
        /**
         * Llama al metodo anterior para calcular el total y despues suma la propina
         */
        double subtotal = calcularTotal();
        return subtotal + propina;
    }

    /**
     * Creo un metodo para mostrar el pedido
     */
    public void mostrarPedido(){
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║          RESUMEN DEL PEDIDO        ║");
        System.out.println("╚════════════════════════════════════╝");
        if (contador == 0){
            System.out.println("El pedido está vacío");
            return;
        }

        System.out.println("Cantidad de platos en el pedido: " + contador);
        for (int i = 0; i < contador; i++) {
            System.out.printf("El plato %s tiene un precio total de %.2f €.", platos[i].getNombre(), platos[i].calcularPrecio());
            System.out.println();
        }
        System.out.printf("Subtotal: %.2f", calcularTotal());
        System.out.println();
    }
}
import java.util.Scanner;

public class GestionRestaurante {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuántos platos quieres añadir?");
        int cantidad = sc.nextInt();
        sc.nextLine(); //Limpiar el buffer
        Plato[] platos = new Plato[cantidad];  //Array de Plato

        for (int i = 0; i < cantidad; i++) {
            System.out.println("PLATO NÚMERO " + (i + 1));
            System.out.println("Indique el tipo de plato:");
            System.out.println("1. Entrante.");
            System.out.println("2. Plato fuerte.");
            System.out.println("3. Postre");
            int tipo = sc.nextInt();
            sc.nextLine();
            System.out.println("Escribe el nombre del plato:");
            String nombre = sc.nextLine();
            System.out.println("Escribe el precio del plato:");
            double precio = sc.nextDouble();
            sc.nextLine();
            if (tipo == 1) {
                platos[i] = new Entrada(nombre, precio);
            } else if (tipo == 2) {
                platos[i] = new PlatoFuerte(nombre, precio);
            } else if (tipo == 3) {
                System.out.println("¿Tiene descuento?S/N");
                String descuento = sc.nextLine();
                if (descuento.toUpperCase().equals("S")) {
                    System.out.println("¿Cuánto descuento tiene?");
                    double porcentaje = sc.nextDouble();
                    platos[i] = new Postre(nombre, precio, porcentaje);
                } else {
                    platos[i] = new Postre(nombre, precio);
                }
            }

        }

        Pedido pedido = new Pedido(cantidad);
        for (Plato plato : platos) {
            pedido.agregarPlato(plato);
        }

        pedido.mostrarPedido();
    }
}






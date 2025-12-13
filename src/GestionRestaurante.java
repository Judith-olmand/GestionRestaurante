import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionRestaurante {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pedido pedido = new Pedido();

        Plato plato = null;
        String nombre = "";
        double precio = 0;

        int opcion = 0; //┓
                       // ╋━━━━━ Variables usadas para las opciones de los menús
        int tipo = 0;   //┛


        boolean opcionValida = false; //┓
        boolean numeroValido = false;// ╋━━━━━ Variables boolean usadas para la captura de errores de los menús
        boolean tipoValido = false;  // ┛


        boolean continuar = true;

        do {
            do {
                try {
                    System.out.println("╔════════════════════════════════════╗");
                    System.out.println("║           MENÚ PRINCIPAL           ║");
                    System.out.println("╠════════════════════════════════════╣");
                    System.out.println("¿Que desea hacer? Seleccione una opción.");
                    System.out.println("1. Agregar un plato al pedido.");
                    System.out.println("2. Mostrar el pedido actual.");
                    System.out.println("3. Mostrar el precio total sin propina.");
                    System.out.println("4. Añadir propina.");
                    System.out.println("0. Salir");
                    opcion = sc.nextInt();
                    sc.nextLine(); //Limpia el buffer
                    opcionValida = true;
                } catch (InputMismatchException e) { //captura el erro de meter texto en lugar de números
                    System.out.println("✘✘✘ Error, la opción no puede ser texto");
                    sc.nextLine(); //Limpia el buffer
                    opcionValida = false;
                }
            } while (!opcionValida);

            switch (opcion) {
                case 1:
                    do {
                        do {
                            try {
                                System.out.println("╔════════════════════════════════════╗");
                                System.out.println("║             MENÚ PLATOS            ║");
                                System.out.println("╠════════════════════════════════════╣");
                                System.out.println("¿Qué tipo de plato quiere agregar? Seleccione una opción.");
                                System.out.println("1. Entrante.");
                                System.out.println("2. Plato fuerte.");
                                System.out.println("3. Postre");
                                System.out.println("0. Salir");
                                tipo = sc.nextInt();
                                sc.nextLine();
                                tipoValido = true;
                            } catch (InputMismatchException e) { //captura el error de meter texto en lugar de números
                                System.out.println("✘✘✘ Error, la opción no puede ser texto");
                                sc.nextLine();
                                tipoValido = false;
                            }
                        } while (!tipoValido) ;

                        if (tipo == 1 || tipo == 2 || tipo == 3) {
                            System.out.println("Introduzca el nombre del plato.");
                            nombre = sc.nextLine();
                            do {
                                try {
                                    System.out.println("Introduzca el precio del plato.");
                                    precio = sc.nextDouble();
                                    sc.nextLine();
                                    numeroValido = true;
                                }catch (InputMismatchException e) { //captura el error de meter texto en lugar de números
                                    System.out.println("✘✘✘ Error, el precio no puede ser texto");
                                    sc.nextLine();
                                    numeroValido = false;
                                }
                            } while (!numeroValido) ;

                        }

                        switch (tipo) {
                            case 1:
                                try{
                                    plato = new Entrada(nombre, precio);
                                    System.out.println("Entrante creado con éxito.");
                                    pedido.agregarPlato(plato);
                                } catch (PrecioNoValido e) {
                                    System.out.println("✘✘✘ Error!!!" + e.getMessage());
                                } catch (Exception e) {
                                    System.out.println("✘✘✘ Error!!!" +  e.getMessage());
                                }
                                break;

                            case 2:
                                try{
                                    plato = new PlatoFuerte(nombre, precio);
                                    System.out.println("Plato fuerte creado con éxito.");
                                    pedido.agregarPlato(plato);
                                } catch (PrecioNoValido e) {
                                    System.out.println("✘✘✘ Error!!!" + e.getMessage());
                                } catch (Exception e) {
                                    System.out.println("✘✘✘ Error!!!" +  e.getMessage());
                                }
                                break;

                            case 3:
                                try{
                                    /**
                                     * El postre no le creo como Plato porque tiene una sobrecarga del metodo
                                     * calcularPrecio, y como Plato no se puede acceder a dicho metodo sobrecargado
                                     */
                                    Postre postre = new Postre(nombre, precio);
                                    System.out.println("Postre creado con éxito.");
                                    pedido.agregarPlato(postre);

                                    String respuesta;
                                    boolean respuestaValida = false;

                                    do {
                                        System.out.println("¿Posee algún descuento? (S/N)");
                                        respuesta = sc.nextLine();

                                        if (respuesta.equalsIgnoreCase("S")) {
                                            try {
                                                System.out.println("¿De cuánto es el descuento? Indique el número del porcentaje %.");
                                                int descuento = sc.nextInt();
                                                sc.nextLine(); //Limpia buffer

                                                if (descuento > 0 && descuento < 100) {
                                                    System.out.printf("Precio sin descuento %.2f €", postre.calcularPrecio());
                                                    System.out.println();
                                                    System.out.printf("Precio con descuento %.2f €", postre.calcularPrecio(descuento));
                                                    System.out.println();
                                                    System.out.println("(El descuento es solo para información, no se guarda)");
                                                    respuestaValida = true;
                                                } else {
                                                    System.out.println("Descuento no válido. Ha de ester entre 1 y 99.");
                                                    respuestaValida = false;
                                                }
                                            } catch (InputMismatchException e) {
                                                System.out.println("✘✘✘ Error, el descuento no puede ser texto");
                                                sc.nextLine();
                                                respuestaValida = false;
                                            }

                                        } else if (respuesta.equalsIgnoreCase("N")) {
                                            System.out.println("No se aplicará ningún descuento.");
                                            respuestaValida = true;
                                        } else {
                                            System.out.println("Por favor, indique S o N unicamente.");
                                            respuestaValida = false;
                                        }
                                    } while (!respuestaValida);

                                } catch (PrecioNoValido e) {
                                    System.out.println("✘✘✘ Error!!!" + e.getMessage());
                                } catch (Exception e) {
                                    System.out.println("✘✘✘ Error!!!" +  e.getMessage());
                                }
                                break;

                            case 0:
                                System.out.println("Eligió salir del menú.");
                                break;

                            default:
                                System.out.println("Introduzca una opción válida.");
                                break;
                        }
                    } while (tipo != 0);
                    break;
                //--------------------------------------------------------------------------------------
                case 2:
                    pedido.mostrarPedido();
                    break;
                //--------------------------------------------------------------------------------------
                case 3:
                    System.out.println("╔════════════════════════════════════╗");
                    System.out.println("║      TOTAL SIN PROPINA             ║");
                    System.out.println("╚════════════════════════════════════╝");
                    double subtotal = pedido.calcularTotal();  // Sin parámetro
                    System.out.println("Total a pagar: " + String.format("%.2f", subtotal) + "€\n");
                    break;
                //--------------------------------------------------------------------------------------
                case 4:
                    try {
                        System.out.println("╔════════════════════════════════════╗");
                        System.out.println("║      TOTAL CON PROPINA             ║");
                        System.out.println("╚════════════════════════════════════╝");

                        double sub = pedido.calcularTotal();  // Sin parámetro
                        System.out.println("Subtotal: " + String.format("%.2f", sub) + "€");

                        if (pedido.getContador() == 0){
                            System.out.println("No se pueden sumar propinas");
                        } else {
                            System.out.print("Propina a dejar (€): ");
                            double propina = sc.nextDouble();
                            sc.nextLine();  // Limpiar buffer

                            double total = pedido.calcularTotal(propina);  // Con parámetro

                            System.out.println("Propina:  " + String.format("%.2f", propina) + "€");
                            System.out.println("────────────────────────────────────");
                            System.out.println("TOTAL:    " + String.format("%.2f", total) + "€\n");
                        }

                    } catch (InputMismatchException e) {
                        System.out.println("✘✘✘ ERROR: La propina debe ser un número.");
                        sc.nextLine();  // Limpiar buffer
                    }
                    break;
                //--------------------------------------------------------------------------------------
                case 0:
                    System.out.println("Hasta pronto!! \u270C");
                    break;
                //--------------------------------------------------------------------------------------
                default:
                    System.out.println("Por favor, elija una opción válida.");
                    break;
            }
        } while (opcion != 0);
    }
}






import java.util.InputMismatchException;

public class Postre extends Plato{
    /**
     * Creo el constructor con el throws de la excepcion
     * @param nombre
     * @param precio
     * @throws PrecioNoValido
     */
    public Postre(String nombre, double precio) throws PrecioNoValido{
        super(nombre, precio);
    }

    /**
     * Sobrescribo el metodo para calcular el precio
     * @return
     */
    @Override
    public double calcularPrecio() {
        double precioFinal= getPrecioBase()*getIva();
        return precioFinal;
    }

    /**
     * Sobrecarga del metodo anterior para calcular el precio con descuento
     * se pasaria por parametro el descuento
     * @param descuento --> porcentaje de 1 a 100
     * @return
     */
    public double calcularPrecio(int descuento){
        if (descuento <= 0 || descuento > 100){
            descuento = 0;
        }
        return (getPrecioBase() * ((double)(100-descuento)/100.0)) * getIva(); //casting de int a double antes de realizar la division
    }

    /**
     * Para mostrar información
     * @return
     */
    @Override
    public String toString() {
        return "Postre{" + getNombre() + ", precio base: " + getPrecioBase() + "€, precio total: " + calcularPrecio() + "€}";

    }
}
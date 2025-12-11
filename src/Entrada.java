public class Entrada extends Plato{
    /**
     * Creo el constructor para Entrada y le añado el throws para que propague el error,
     * pues las excepciones no se lanzan automaticamente.
     * @param nombre
     * @param precio
     * @throws PrecioNoValido
     */
    public Entrada(String nombre, double precio) throws PrecioNoValido{
        super(nombre, precio);
    }

    /**
     * sobrescribo el metodo abstracto de Plato
     * @return
     */
    @Override
    public double calcularPrecio() {
        double precioFinal = getPrecioBase()*getIva(); //precio base * IVA
        return precioFinal;
    }

    /**
     * Para mostrar información
     * @return
     */
    @Override
    public String toString() {
        return "Entrada{" + getNombre() + ", precio base: " + getPrecioBase() + "€, precio total: " + calcularPrecio() + "€}";

    }
}

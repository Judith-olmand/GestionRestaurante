public class PlatoFuerte extends Plato{
    /**
     * Creo una constante para el recargo (+15%)
     */
    final double recargo = 1.15;

    /**
     * Creo el constructor con el throws de la excepcion
     * @param nombre
     * @param precio
     * @throws PrecioNoValido
     */
    public PlatoFuerte(String nombre, double precio) throws PrecioNoValido{
        super(nombre, precio);
    }

    /**
     * Creo el getter de la constante
     * @return
     */
    public double getRecargo() {
        return recargo;
    }

    /**
     * Sobrescribo el metodo abstracto de Plato
     * @return
     */
    @Override
    public double calcularPrecio() {
        double precioFinal = (getPrecioBase()* getRecargo())*getIva();
        return precioFinal;
    }

    /**
     * Para mostrar informacion
     * @return
     */
    @Override
    public String toString() {
        return "PlatoFuerte{" + getNombre() + ", precio base: " + getPrecioBase() + "€, precio total: " + calcularPrecio() + "€}";
    }
}
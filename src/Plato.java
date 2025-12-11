public abstract class Plato {
    /**
     * Creo atributos encapsulados (private)
     */
    final double iva = 1.21;
    private String nombre;
    private double precioBase;

    /**
     * Creo un constructor con validacion, para que propague el error del setter si lo hubiera.
     * Sin el throws aqui habria un error de compilacion.
     * No se usa try-catch porque crearia el objeto con datos incorrectos.
     * @param nombre
     * @param precio
     * @throws PrecioNoValido
     */
    public Plato(String nombre, double precio) throws PrecioNoValido{
        this.nombre = nombre;
        setPrecioBase(precio); //invoco al setter para que valide el precio
    }

    /**
     * Añado los getter y setter de los atributos
     * @return
     */
    public double getIva() {
        return iva;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecioBase() {
        return precioBase;
    }

    /**
     * Añado la excepción al setter, para que lo valide incluso
     * cuando queramos modificar el dato, y no solo al introducirlo
     * @param precio
     * @throws PrecioNoValido
     */
    public void setPrecioBase(double precio) throws PrecioNoValido{
        if (precio <= 0){
            throw new PrecioNoValido("El precio ha de ser mayor que 0. El precio introducido es " + precio);
        }
        this.precioBase = precio;
    }

    /**
     * Creo el metodo abstracto que devuelve un numero decimal
     */
    public abstract double calcularPrecio();
    public abstract double calcularPrecio(int descuento);
    /**
     * Añado el toString para mostrar la informacion
     * @return
     */
    @Override
    public String toString() {
        return "Plato{" +
                "iva=" + iva +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precioBase +
                '}';
    }
}

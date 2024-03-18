package models;

public class Carreras {
    
    private String nombre;

    public Carreras() {
    }

    public Carreras(String nombre) {
        this.nombre = nombre;
    }

    
    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the value of nombre
     *
     * @param nombre new value of nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Carreras{" + "nombre=" + nombre + '}';
    }

    
}

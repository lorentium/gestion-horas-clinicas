public class Persona {
    private String nombre;
    private String rut;
    private int edad;
    private int telefono;

    public Persona(String nombre, String rut, int edad, int telefono) {
        this.nombre = nombre;
        this.rut = rut;
        this.edad = edad;
        this.telefono = telefono;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public int getTelefono() { return telefono; }
    public void setTelefono(int telefono) { this.telefono = telefono; }

    @Override
    public String toString() {
        return nombre + " (RUT: " + rut + ", Edad: " + edad + ", Teléfono: " + telefono + ")";
    }
}


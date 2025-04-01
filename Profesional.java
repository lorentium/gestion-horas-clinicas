public class Profesional extends Persona {
    private String especializacion;

    public Profesional(String nombre, String rut, String especializacion, int edad, int telefono) {
        super(nombre, rut, edad, telefono);
        this.especializacion = especializacion;
    }

    public String getEspecializacion() { return especializacion; }
    public void setEspecializacion(String especializacion) { this.especializacion = especializacion; }

    @Override
    public String toString() {
        return super.toString() + " - Especialidad: " + especializacion;
    }
}


public class Profesional extends Persona {
    private String especializacion;
    private int experiencia;
    private boolean disponible;

    public Profesional(String nombre, String rut, String especializacion, int edad, int telefono, int experiencia, boolean disponible) {
        super(nombre, rut, edad, telefono);
        this.especializacion = especializacion;
        this.experiencia = experiencia;
        this.disponible = disponible;
    }

    public String getEspecializacion() { return especializacion; }
    public void setEspecializacion(String especializacion) { this.especializacion = especializacion; }

    @Override
    public String toString() {
        return super.toString() + ", especializacion: " + especializacion + ", experiencia: " + experiencia + " años, disponible: " + disponible;
    }
}


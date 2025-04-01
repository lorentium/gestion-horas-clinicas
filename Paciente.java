public class Paciente extends Persona {
    private String historialMedico;

    public Paciente(String nombre, String rut, int edad, int telefono, String historialMedico) {
        super(nombre, rut, edad, telefono);
        this.historialMedico = historialMedico;
    }

    // Getters y Setters
    public String getHistorialMedico() {
        return historialMedico;
    }

    @Override
    public String toString() {
        return super.toString() + ", Historial Médico: " + historialMedico;
    }
}
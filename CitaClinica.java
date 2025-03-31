public class CitaClinica {
    private Profesional profesional;
    private Paciente paciente;
    private Clinica clinica;
    private String fecha;
    private String motivo;

    @Override
    public String toString() {
        return "CitaClinica{" +
                "profesional=" + profesional +
                ", paciente=" + paciente +
                ", clinica=" + clinica +
                ", fecha='" + fecha + '\'' +
                ", motivo='" + motivo + '\'' +
                '}';
    }
}

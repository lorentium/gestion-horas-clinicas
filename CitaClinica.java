public class CitaClinica {
    private Profesional profesional;
    private Paciente paciente;
    private Clinica clinica;
    private String fecha;
    private String motivo;

    public CitaClinica(Profesional profesional, Paciente paciente, Clinica clinica, String fecha, String motivo) {
        this.profesional = profesional;
        this.paciente = paciente;
        this.clinica = clinica;
        this.fecha = fecha;
        this.motivo = motivo;
    }

    public String getRutPaciente() {
        return paciente.getRut();
    }

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

    public String getRutPaciente() {
        return paciente.getRut();
    }
}

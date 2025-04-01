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

    public Profesional getProfesional() {
        return profesional;
    }

    public String getFecha() {
        return fecha;
    }

    public String getRutPaciente() {
        return paciente.getRut();
    }

    public String getMotivo() {
        return motivo;
    }

    @Override
    public String toString() {
        return "Cita: "
                + fecha + " - "
                + motivo + "\n  Médico: "
                + profesional.getNombre() + "\n  Paciente: "
                + paciente.getNombre();
    }
}


import java.util.ArrayList;
import java.util.List;

class SistemaClinico {
    private List<Profesional> profesionales = new ArrayList<>();
    private List<Paciente> pacientes = new ArrayList<>();
    private List<CitaClinica> citas = new ArrayList<>();
    private Clinica clinica;

    public SistemaClinico(String nombreClinica, String direccionClinica, int telefonoClinica) {
        this.clinica = new Clinica(nombreClinica, direccionClinica, telefonoClinica);
    }

    public void agregarProfesional(Profesional profesional) {
        profesionales.add(profesional);
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void agendarCita(String rutProfesional, String rutPaciente, String fecha, String motivo) {
        Profesional profesional = profesionales.stream().filter(m -> m.getRut().equals(rutProfesional)).findFirst().orElse(null);
        Paciente paciente = pacientes.stream().filter(p -> p.getRut().equals(rutPaciente)).findFirst().orElse(null);
        if (profesional != null && paciente != null) {
            citas.add(new CitaClinica(profesional, paciente, clinica, fecha, motivo));
            System.out.println("Cita agendada con éxito.");
        } else {
            System.out.println("Error: Médico o paciente no encontrados.");
        }
    }

    public void mostrarCitas() {
        if (citas.isEmpty()) {
            System.out.println("No hay citas agendadas.");
        } else {
            citas.forEach(System.out::println);
        }
    }

    public void eliminarCita(String rutPaciente) {
        citas.removeIf(cita -> cita.getRutPaciente().equals(rutPaciente));
        System.out.println("Cita eliminada con éxito.");
    }
}

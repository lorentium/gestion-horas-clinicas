import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        Profesional profesional = profesionales.stream()
                .filter(p -> p.getRut().equals(rutProfesional))
                .findFirst()
                .orElse(null);

        Paciente paciente = pacientes.stream()
                .filter(p -> p.getRut().equals(rutPaciente))
                .findFirst()
                .orElse(null);

        if (profesional == null) {
            System.out.println("Error: Profesional no encontrado.");
            return;
        }

        if (paciente == null) {
            System.out.println("Error: Paciente no encontrado.");
            return;
        }


        boolean ocupado = citas.stream() //se toma en cuenta el dia, ya que no fue especificado por horas.
                .anyMatch(c -> c.getRutPaciente().equals(rutPaciente) && c.getFecha().equals(fecha));

        if (ocupado) {
            System.out.println("Error: El profesional ya tiene una cita agendada en esa fecha.");
            return;
        }


        citas.add(new CitaClinica(profesional, paciente, clinica, fecha, motivo));
        profesional.setDisponible(false);
        System.out.println("Cita agendada con éxito.");
    }

    public void mostrarCitas() {
        if (citas.isEmpty()) {
            System.out.println("No hay citas agendadas.");
        } else {
            citas.forEach(System.out::println);
        }
    }

    public void modificarProfesional(String rut, Scanner scanner) {
        for (Profesional p : profesionales) {
            if (p.getRut().equals(rut)) {
                System.out.print("Nuevo nombre: ");
                p.setNombre(scanner.nextLine());
                System.out.print("Nueva especialización: ");
                p.setEspecializacion(scanner.nextLine());
                System.out.print("Nueva edad: ");
                p.setEdad(scanner.nextInt());
                System.out.print("Nuevo teléfono: ");
                p.setTelefono(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Profesional actualizado con éxito.");
                return;
            }
        }
        System.out.println("Profesional no encontrado.");
    }

    public void modificarPaciente(String rut, Scanner scanner) {
        for (Paciente p : pacientes) {
            if (p.getRut().equals(rut)) {
                System.out.print("Nuevo nombre: ");
                p.setNombre(scanner.nextLine());
                System.out.print("Nueva edad: ");
                p.setEdad(scanner.nextInt());
                System.out.print("Nuevo teléfono: ");
                p.setTelefono(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Paciente actualizado con éxito.");
                return;
            }
        }
        System.out.println("Paciente no encontrado.");
    }
    public void eliminarProfesional(String rut) {
        if (profesionales.removeIf(p -> p.getRut().equals(rut))) {
            System.out.println("Profesional eliminado con éxito.");
        } else {
            System.out.println("Profesional no encontrado.");
        }
    }

    public void eliminarPaciente(String rut) {
        if (pacientes.removeIf(p -> p.getRut().equals(rut))) {
            System.out.println("Paciente eliminado con éxito.");
        } else {
            System.out.println("Paciente no encontrado.");
        }
    }

    public void eliminarCita(String rutPaciente, Scanner scanner) {
        List<CitaClinica> citasPaciente = citas.stream()
                .filter(c -> c.getRutPaciente().equals(rutPaciente))
                .toList();

        if (citasPaciente.isEmpty()) {
            System.out.println("El paciente no tiene citas agendadas.");
            return;
        }

        // Mostrar las citas del paciente
        System.out.println("Citas agendadas para el paciente:");
        for (CitaClinica cita : citasPaciente) {
            System.out.println("Fecha: " + cita.getFecha() + " | Profesional: " + cita.getProfesional().getNombre() + " | Motivo: " + cita.getMotivo());
        }


        System.out.print("Ingrese la fecha de la cita a eliminar: ");
        String fechaEliminar = scanner.nextLine();


        boolean citaEliminada = citas.removeIf(c -> c.getRutPaciente().equals(rutPaciente) && c.getFecha().equals(fechaEliminar));

        if (citaEliminada) {
            System.out.println("Cita eliminada con éxito.");


            Profesional profesional = profesionales.stream()
                    .filter(p -> citas.stream().anyMatch(c -> c.getProfesional().getRut().equals(p.getRut()) && c.getFecha().equals(fechaEliminar)))
                    .findFirst()
                    .orElse(null);

            if (profesional != null) {
                profesional.setDisponible(true);
            }
        } else {
            System.out.println("No se encontró una cita con la fecha ingresada.");
        }
    }



}

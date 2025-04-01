import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        SistemaClinico sistema = new SistemaClinico("Clinica Alemana","Senador Estébanez 645",452201201);

        while (true) {
            System.out.println("\n1. Agregar Profesional");
            System.out.println("2. Agregar Paciente");
            System.out.println("3. Modificar Profesional");
            System.out.println("4. Modificar Paciente");
            System.out.println("5. Agendar Cita");
            System.out.println("6. Listar Citas");
            System.out.println("7. Eliminar Cita");
            System.out.println("8. Eliminar Profesional");
            System.out.println("9. Eliminar Paciente");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombreP = leer.nextLine();
                    System.out.print("RUT: ");
                    String rutP = leer.nextLine();
                    System.out.print("Especialidad: ");
                    String especialidad = leer.nextLine();
                    System.out.print("Edad: ");
                    int edadP = leer.nextInt();
                    System.out.print("Teléfono: ");
                    int telefonoP = leer.nextInt();
                    System.out.print("Años de experiencia: ");
                    int experienciaP = leer.nextInt();
                    leer.nextLine();
                    sistema.agregarProfesional(new Profesional(nombreP, rutP, especialidad, edadP, telefonoP, experienciaP, true));
                    break;

                case 2:
                    System.out.print("Nombre: ");
                    String nombrePac = leer.nextLine();
                    System.out.print("RUT: ");
                    String rutPac = leer.nextLine();
                    System.out.print("Edad: ");
                    int edadPac = leer.nextInt();
                    System.out.print("Teléfono: ");
                    int telefonoPac = leer.nextInt();
                    leer.nextLine();
                    System.out.print("Historial Médico: ");
                    String historialPac = leer.nextLine();
                    sistema.agregarPaciente(new Paciente(nombrePac, rutPac, edadPac, telefonoPac, historialPac));
                    break;

                case 3:
                    System.out.print("Ingrese el RUT del profesional a modificar: ");
                    String rutModProf = leer.nextLine();
                    sistema.modificarProfesional(rutModProf, leer);
                    break;

                case 4:
                    System.out.print("Ingrese el RUT del paciente a modificar: ");
                    String rutModPac = leer.nextLine();
                    sistema.modificarPaciente(rutModPac, leer);
                    break;

                case 5:
                    System.out.print("Ingrese el RUT del Profesional: ");
                    String rutProf = leer.nextLine();
                    System.out.print("Ingrese el RUT del Paciente: ");
                    String rutPacCita = leer.nextLine();
                    System.out.print("Ingrese la fecha de la cita: ");
                    String fechaCita = leer.nextLine();
                    System.out.print("Motivo de la consulta: ");
                    String motivoCita = leer.nextLine();
                    sistema.agendarCita(rutProf, rutPacCita, fechaCita, motivoCita);
                    break;

                case 6:
                    sistema.mostrarCitas();
                    break;

                case 7:
                    System.out.print("Ingrese el RUT del paciente cuya cita desea eliminar: ");
                    String rutEliminarCita = leer.nextLine();
                    sistema.eliminarCita(rutEliminarCita, leer);
                    break;
                case 8:
                    System.out.print("Ingrese el RUT del Profesional a eliminar: ");
                    String rutEliminarProf = leer.nextLine();
                    sistema.eliminarProfesional(rutEliminarProf);
                    break;
                case 9:
                    System.out.print("Ingrese el RUT del Paciente a eliminar: ");
                    String rutEliminarPac = leer.nextLine();
                    sistema.eliminarPaciente(rutEliminarPac);
                    break;
                case 10:
                    System.out.println("Saliendo...");
                    leer.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }

    }

}


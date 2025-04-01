public class Main {
    public static void main(String[] args) {
        Profesional profesional = new Profesional("Miguel Inostroza","123245779","urologo",39,912435677);
        Paciente paciente = new Paciente("Felipe Delgado", "215003006",20,95618121);
        Clinica clinica = new Clinica("Clinica Alemana","Senador Estebanez 0101", 2123412);
        
        CitaClinica cita = new CitaClinica(profesional,paciente,clinica,"02 de abril", "sangre en la orina");
    }
}


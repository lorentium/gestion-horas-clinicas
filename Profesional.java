public class Profesional extends Persona {
    String nombre;
    String rut;
    String especializacion;
    int edad;
    int telefono;


    public Profesional(String nombre, String rut, String especializacion, int edad, int telefono) {
        this.nombre = nombre;
        this.rut = rut;
        this.especializacion = especializacion;
        this.edad = edad;
        this.telefono = telefono;
    }
}

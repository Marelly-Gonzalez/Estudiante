import java.util.Date;

public class Estudiante extends Persona {
    private String idAlumno;
    private double promCalif;
    private String carrera;
    private String gradoObtenido;
    private int anioGraduacionEsperado;

    public Estudiante(String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String idAlumno, String carrera, String gradoObtenido, int anioGraduacionEsperado) {
        super(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento);
        this.idAlumno = idAlumno;
        this.carrera = carrera;
        this.gradoObtenido = gradoObtenido;
        this.anioGraduacionEsperado = anioGraduacionEsperado;
        this.promCalif = 0.0;
    }

    public String getIdAlumno() {
        return idAlumno;
    }

    public double getPromCalif() {
        return promCalif;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getGradoObtenido() {
        return gradoObtenido;
    }

    public int getAnioGraduacionEsperado() {
        return anioGraduacionEsperado;
    }

    public void cambiarCarrera(String nuevaCarrera) {
        this.carrera = nuevaCarrera;
    }

    public double calcularPromedio(String[] calificaciones) {
        if (calificaciones == null || calificaciones.length == 0) {
            this.promCalif = 0.0;
            return 0.0;
        }

        double sumaPuntos = 0.0;
        for (String calif : calificaciones) {
            switch (calif.toUpperCase().trim()) {
                case "A":  sumaPuntos += 4.0;  break;
                case "A-": sumaPuntos += 3.67; break;
                case "B+": sumaPuntos += 3.33; break;
                case "B":  sumaPuntos += 3.0;  break;
                case "B-": sumaPuntos += 2.67; break;
                case "C+": sumaPuntos += 2.33; break;
                case "C":  sumaPuntos += 2.0;  break;
                case "D":  sumaPuntos += 1.0;  break;
                case "F":  sumaPuntos += 0.0;  break;
                case "a":  sumaPuntos += 4.0;  break;
                case "a-": sumaPuntos += 3.67; break;
                case "b+": sumaPuntos += 3.33; break;
                case "b":  sumaPuntos += 3.0;  break;
                case "b-": sumaPuntos += 2.67; break;
                case "c+": sumaPuntos += 2.33; break;
                case "c":  sumaPuntos += 2.0;  break;
                case "d":  sumaPuntos += 1.0;  break;
                case "f":  sumaPuntos += 0.0;  break;
                default:
                    System.out.println("Calificación no válida: " + calif + " (se tomará como 0)");
                    break;
            }
        }

        this.promCalif = sumaPuntos / calificaciones.length;
        return this.promCalif;
    }

    @Override
    public String toString() {
        return "--- DATOS DEL ESTUDIANTE ---\n" +
               "Nombre Completo: " + obtenerNombreCompleto() + "\n" +
               "ID Alumno: " + getIdAlumno() + "\n" +
               "Carrera: " + getCarrera() + "\n" +
               "Grado Obtenido: " + getGradoObtenido() + "\n" +
               "Año de Graduación Esperado: " + getAnioGraduacionEsperado() + "\n" +
               "Promedio de Calificaciones: " + String.format("%.2f", getPromCalif());
    }
}

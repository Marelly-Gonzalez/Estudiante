import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PruebaEstudiante {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("=== REGISTRO DE ESTUDIANTE ===");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Apellido Paterno: ");
        String apellidoPaterno = sc.nextLine();

        System.out.print("Apellido Materno: ");
        String apellidoMaterno = sc.nextLine();

        Date fechaNacimiento = null;
        while (fechaNacimiento == null) {
            System.out.print("Fecha de Nacimiento (DD/MM/AAAA): ");
            String fechaStr = sc.nextLine();
            try {
                fechaNacimiento = sdf.parse(fechaStr);
            } catch (ParseException e) {
                System.out.println("Formato de fecha inválido. Intenta de nuevo.");
            }
        }

        System.out.print("ID de Alumno: ");
        String id = sc.nextLine();

        System.out.print("Carrera: ");
        String carrera = sc.nextLine();

        System.out.print("Grado obtenido (Licenciatura, Master, Ph.D): ");
        String grado = sc.nextLine();

        System.out.print("Año de graduación esperado: ");
        int anio = sc.nextInt();
        sc.nextLine();

        Estudiante estudiante = new Estudiante(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, id, carrera, grado, anio);

        System.out.println("\n" + estudiante.toString());

        System.out.print("\nIngrese el número de calificaciones a registrar: ");
        int numCalificaciones = sc.nextInt();
        sc.nextLine();

        String[] calificaciones = new String[numCalificaciones];

        for (int i = 0; i < numCalificaciones; i++) {
            System.out.print("Ingrese calificación #" + (i + 1) + " (A, A-, B+, B, B-, C+, C, D, F): ");
            calificaciones[i] = sc.nextLine();
        }

        estudiante.calcularPromedio(calificaciones);

        System.out.println("\nPromedio calculado: " + String.format("%.2f", estudiante.getPromCalif()));

        System.out.print("\n¿Desea cambiar de carrera al estudiante? (si/no): ");
        String respuesta = sc.nextLine().trim().toLowerCase();

        if (respuesta.equals("si") || respuesta.equals("sí")) {
            System.out.print("Ingrese la nueva carrera: ");
            String nuevaCarrera = sc.nextLine();
            estudiante.cambiarCarrera(nuevaCarrera);
            System.out.println("\n¡Carrera actualizada con éxito!");
            System.out.println("Nueva carrera asignada: " + estudiante.getCarrera());
        } else {
            System.out.println("\nFin del programa.");
        }

        sc.close();
    }
}

public class LibroCalificaciones{
    
    private String nombreDelCurso, nombreDelProfesor;
    private int horasDelcurso;

    public LibroCalificaciones(){
        
    }

    public LibroCalificaciones (String nombre, String Profesor, int horas) {
        this.nombreDelCurso = nombre;
        this.nombreDelProfesor = Profesor;
        this.horasDelcurso = horas;
       
    }

    public void establecerParametrosDelCurso(String nombre, String Profesor, int horas){
        nombreDelCurso = nombre;
        nombreDelProfesor = Profesor;
        horasDelcurso = horas;
    }

    public String getNombreDelCurso(){
        return nombreDelCurso;
    }

    public String getNombreDelProfesor(){
        return nombreDelProfesor;
    }

    public int getHorasDelCurso(){
        return horasDelcurso;
    }

    public void mostrarMensaje(){
        System.out.printf("Bienvenido al libro calificaiones para \n%s\n" , 
         getNombreDelCurso());
        System.out.printf("El profesor asignado es:  %s\n" , getNombreDelProfesor());
        System.out.printf("Tienes &d horas a la semana: %s\n", getHorasDelCurso());
    }

}

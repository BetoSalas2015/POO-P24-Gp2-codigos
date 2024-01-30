
/**
 * Write a description of class EquipoFutbol here.
 * 
 * @author Roberto Salazar Marquez
 * @version 1.0
 */
public class EquipoFutbol
{
    // Variables de Instancia 
    private String nombre;
    private String entrenador;
    private String equipo[];

    /**
     * Constructor para objetos de la clase EquipoFutbol
     */
    public EquipoFutbol(String nombre, String entrenador)
    {
        this.nombre = new String(nombre);
        this.entrenador = new String(entrenador);
        equipo = new String[11];
    }
    
}


/**
 * Write a description of class Punto here.
 * 
 * @author Roberto Salazar Marquez
 * @version 1.0
 */
public class Punto<E>
{
    // Variables de Instancia 
    private E x;
    private E y;

    /**
     * Constructor para objetos de la clase Punto
     */
    public Punto(E x, E y) 
    {
        this.x = x;
        this.y = y;

    }
    
    public void setX(E x) {
        this.x = x;
    }
    
    public E getX() {
        return x;
    }
    
    public void setY( E y ) {
        this.y = y;
    }
    
    public E getY() {
        return y;
    }
    
    public static void main(String[] args) {
        Punto<Integer> puntoEntero = new Punto<Integer>(Integer.valueOf(1), 
                                                        Integer.valueOf(1));
                                                        
        Punto<Double> puntoDouble = new Punto<Double>(Double.valueOf(2.5), 
                                                      Double.valueOf(2.75));
        Punto<Integer> puntoInt = new Punto<Integer>(1,1);
                                                      
        System.out.println("(" + puntoEntero.getX().toString() + ","  
                                + puntoEntero.getY().toString() + ")");       
                                
        System.out.println("(" + puntoDouble.getX().toString() + ","  
                                + puntoDouble.getY().toString() + ")");                        
    }    
}

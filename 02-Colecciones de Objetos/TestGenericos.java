
/**
 * Write a description of class TestGenericos here.
 * 
 * @author Roberto Salazar Marquez
 * @version 1.0
 */
public class TestGenericos
{
    // Variables de Instancia 
    /**
     * Constructor para objetos de la clase TestGenericos
     */
    public TestGenericos()
    {
    }
    

    
    public static <E> void imprimeArreglo(E[] arrEntrada) {
        for(E elemento : arrEntrada)
            System.out.print( elemento + ", ");
        System.out.println();
    }
      
    public static void main(String[] args) {
        Double[] arrDouble = { 3.2,  2.3, 5.2, 7.4 };
        Integer[] arrInteger = { 0, 1, 2, 3 ,4 ,5, 6, 7 };
        Character []arrCharacter = { 'a', 'b', 'c', 'd' }; 
        Boolean arrBoolean[] = {true, true, false, true };
        imprimeArreglo(arrDouble);
        imprimeArreglo(arrInteger);
        imprimeArreglo(arrCharacter);
        imprimeArreglo(arrBoolean);
    }
}








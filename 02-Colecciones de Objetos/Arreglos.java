/**
 * 
 */

public class Arreglos {
    private int arreglo[], variableInt;
    private int []arreglo2, arreglo5;
    private int[] arreglo3, arreglo6 = {0, 1,2,3,4,5,610,34 };
    private int[][] matriz = { {1, 2, 3}, { 4 }, {5, 6, 7, 8}, {9, 10} };
    
    //  Constructor
    public Arreglos() {
        arreglo = new int[10];
        arreglo[2] = 10;
        arreglo5 = new int[15];
        for(int i = 0; i < arreglo5.length; i++) { 
            arreglo5[i] = i * 2;
        }
        
        variableInt = 20;
        
        cambiaVariable(variableInt);        // Paso de argumentos por valor. (copia)
        cambiaArreglo(arreglo5);            // PAso de Argumentos por Referencia (alias)
        
        
    }
    
    
    public void cambiaVariable(int var)  {
        var = 100;
    }
    
    public void cambiaArreglo(int arr[]) {
        for(int i = 0; i < arr.length; i++) { 
            arr[i] = 0;
        }
    }
    
    public static void main( String[] args) {
    
    }
    
}








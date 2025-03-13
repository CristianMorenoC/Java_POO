import java.util.Scanner;
import java.util.ArrayList;

/**
 * Programa que solicita al usuario un número entero positivo y
 * muestra la secuencia de números primos hasta ese número.
 */
public class NumerosPrimos {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== GENERADOR DE SECUENCIA DE NÚMEROS PRIMOS ===");
        
        try {
            // Solicitar número al usuario
            System.out.print("Ingrese un número entero positivo: ");
            int numero = scanner.nextInt();
            
            // Validar que el número sea positivo
            if (numero <= 0) {
                System.out.println("Error: Debe ingresar un número entero positivo.");
                scanner.close();
                return;
            }
            
            // Obtener y mostrar la secuencia de números primos
            ArrayList<Integer> primos = obtenerNumerosPrimosHasta(numero);
            
            // Mostrar resultados
            System.out.println("\nNúmeros primos hasta " + numero + ":");
            
            if (primos.isEmpty()) {
                System.out.println("No hay números primos menores o iguales a " + numero);
            } else {
                // Imprimir los números en una secuencia
                for (int i = 0; i < primos.size(); i++) {
                    System.out.print(primos.get(i));
                    // Agregar coma excepto después del último número
                    if (i < primos.size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println(); // Nueva línea al final
                
                // Mostrar cantidad de números primos encontrados
                System.out.println("\nSe encontraron " + primos.size() + " números primos.");
            }
            
        } catch (Exception e) {
            System.out.println("Error: Entrada inválida. Por favor ingrese un número entero.");
        } finally {
            scanner.close();
        }
    }
    
    /**
     * Determina si un número es primo.
     * Un número es primo si solo es divisible por 1 y por sí mismo.
     * 
     * @param numero El número a verificar
     * @return true si el número es primo, false en caso contrario
     */
    private static boolean esPrimo(int numero) {
        // Los números menores o iguales a 1 no son primos
        if (numero <= 1) {
            return false;
        }
        
        // 2 es el único número primo par
        if (numero == 2) {
            return true;
        }
        
        // Si es par y no es 2, no es primo
        if (numero % 2 == 0) {
            return false;
        }
        
        // Verificar divisibilidad solo para números impares hasta la raíz cuadrada
        int raizCuadrada = (int) Math.sqrt(numero);
        for (int i = 3; i <= raizCuadrada; i += 2) {
            if (numero % i == 0) {
                return false;
            }
        }
        
        // Si no se encontraron divisores, es primo
        return true;
    }
    
    /**
     * Obtiene la lista de números primos hasta un número dado.
     * 
     * @param limite El número hasta el cual se buscarán primos
     * @return ArrayList con los números primos encontrados
     */
    private static ArrayList<Integer> obtenerNumerosPrimosHasta(int limite) {
        ArrayList<Integer> primos = new ArrayList<>();
        
        // Utilizar un ciclo for para verificar cada número desde 2 hasta el límite
        for (int i = 2; i <= limite; i++) {
            if (esPrimo(i)) {
                primos.add(i);
            }
        }
        
        return primos;
    }
}

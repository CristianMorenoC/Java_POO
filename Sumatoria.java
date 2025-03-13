import java.util.Scanner;

/**
 * Programa que calcula la suma de los dígitos de un número entero
 * ingresado por el usuario utilizando un ciclo while.
 */
public class Sumatoria {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== SUMATORIA DE DÍGITOS DE UN NÚMERO ===");
        
        try {
            // Solicitar número al usuario
            System.out.print("Ingrese un número entero: ");
            long numero = scanner.nextLong();
            
            // Trabajar con el valor absoluto si es negativo
            if (numero < 0) {
                System.out.println("Se ha ingresado un número negativo. Se utilizará su valor absoluto.");
                numero = Math.abs(numero);
            }
            
            // Calcular la suma de los dígitos
            int suma = calcularSumaDigitos(numero);
            
            // Mostrar el proceso de descomposición
            System.out.println("\nProceso de descomposición:");
            mostrarDescomposicion(numero);
            
            // Mostrar el resultado
            System.out.println("\nLa suma de los dígitos de " + numero + " es: " + suma);
            
        } catch (Exception e) {
            System.out.println("Error: Entrada inválida. Por favor ingrese un número entero válido.");
        } finally {
            scanner.close();
        }
    }
    
    /**
     * Calcula la suma de los dígitos de un número utilizando un ciclo while.
     * 
     * @param numero El número entero cuyos dígitos se sumarán
     * @return La suma de los dígitos
     */
    private static int calcularSumaDigitos(long numero) {
        int suma = 0;
        
        // Ciclo while para extraer y sumar cada dígito
        while (numero > 0) {
            // Extraer el último dígito
            int digito = (int)(numero % 10);
            
            // Sumar el dígito al total
            suma += digito;
            
            // Eliminar el último dígito
            numero /= 10;
        }
        
        return suma;
    }
    
    /**
     * Muestra el proceso de descomposición del número en sus dígitos.
     * 
     * @param numero El número a descomponer
     */
    private static void mostrarDescomposicion(long numero) {
        // Si el número es 0, mostrar directamente
        if (numero == 0) {
            System.out.println("0 = 0");
            return;
        }
        
        // Almacenar los dígitos en un arreglo temporal
        int[] digitos = new int[19]; // long puede tener hasta 19 dígitos
        int contador = 0;
        
        // Extraer dígitos y almacenarlos
        long temp = numero;
        while (temp > 0) {
            digitos[contador++] = (int)(temp % 10);
            temp /= 10;
        }
        
        // Mostrar los dígitos en orden correcto con la operación de suma
        StringBuilder proceso = new StringBuilder();
        for (int i = contador - 1; i >= 0; i--) {
            proceso.append(digitos[i]);
            if (i > 0) {
                proceso.append(" + ");
            }
        }
        
        proceso.append(" = ").append(calcularSumaDigitos(numero));
        System.out.println(proceso.toString());
    }
}

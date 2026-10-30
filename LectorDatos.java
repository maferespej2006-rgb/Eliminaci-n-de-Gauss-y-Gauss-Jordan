import java.util.Scanner;

/**
 * Clase encargada de la lectura de datos del sistema
 */
public class LectorDatos {
    private Scanner entrada;

    public LectorDatos() {
        entrada = new Scanner(System.in);
    }

    // Lee una matriz aumentada de tamaño n x (n+1)
    public double[][] leerMatriz(int n) {
        double[][] matriz = new double[n][n + 1];
        
        System.out.println("Ingrese los coeficientes y términos independientes:");
        for (int i = 0; i < n; i++) {
            System.out.print("Fila " + (i + 1) + ": ");
            for (int j = 0; j <= n; j++) {
                matriz[i][j] = entrada.nextDouble();
            }
        }
        return matriz;
    }

    // Cierra el objeto Scanner
    public void cerrar() {
        entrada.close();
    }
}

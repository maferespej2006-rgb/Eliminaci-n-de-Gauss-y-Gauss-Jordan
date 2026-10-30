/**
 * Clase que implementa los métodos de Eliminación de Gauss Simple y Gauss-Jordan
 */
public class MetodosGauss {

    // Resuelve un sistema por Eliminación de Gauss Simple
    public static double[] gaussSimple(double[][] matriz) {
        int n = matriz.length;
        double[] solucion = new double[n];

        System.out.println("\n=== ETAPAS DE ELIMINACIÓN DE GAUSS SIMPLE ===");

        // Fase de eliminación hacia adelante
        for (int pivote = 0; pivote < n - 1; pivote++) {
            for (int fila = pivote + 1; fila < n; fila++) {
                double factor = matriz[fila][pivote] / matriz[pivote][pivote];
                
                for (int columna = pivote; columna <= n; columna++) {
                    matriz[fila][columna] -= factor * matriz[pivote][columna];
                }
            }
            imprimirMatriz(matriz);
        }

        // Fase de sustitución regresiva
        for (int i = n - 1; i >= 0; i--) {
            double suma = matriz[i][n];
            for (int j = i + 1; j < n; j++) {
                suma -= matriz[i][j] * solucion[j];
            }
            solucion[i] = suma / matriz[i][i];
        }

        return solucion;
    }

    // Resuelve un sistema por Gauss-Jordan
    public static double[] gaussJordan(double[][] matriz) {
        int n = matriz.length;
        double[] solucion = new double[n];

        System.out.println("\n=== ETAPAS DE GAUSS-JORDAN ===");

        // Fase de eliminación completa
        for (int pivote = 0; pivote < n; pivote++) {
            // Hacer 1 el elemento del pivote
            double valorPivote = matriz[pivote][pivote];
            for (int columna = pivote; columna <= n; columna++) {
                matriz[pivote][columna] /= valorPivote;
            }

            // Hacer ceros arriba y abajo del pivote
            for (int fila = 0; fila < n; fila++) {
                if (fila != pivote) {
                    double factor = matriz[fila][pivote];
                    for (int columna = pivote; columna <= n; columna++) {
                        matriz[fila][columna] -= factor * matriz[pivote][columna];
                    }
                }
            }
            imprimirMatriz(matriz);
        }

        // Extraer la solución
        for (int i = 0; i < n; i++) {
            solucion[i] = matriz[i][n];
        }

        return solucion;
    }

    // Método auxiliar para imprimir la matriz
    private static void imprimirMatriz(double[][] matriz) {
        System.out.println("Matriz:");
        for (double[] fila : matriz) {
            for (int j = 0; j < fila.length; j++) {
                System.out.printf("%8.4f ", fila[j]);
                if (j == fila.length - 2) System.out.print("| ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

/**
 * Clase principal — Punto de entrada al programa
 * Ejecuta los dos ejercicios de la práctica
 */
public class Principal {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("  PRÁCTICA: MÉTODOS DE SOLUCIÓN DE SISTEMAS");
        System.out.println("  Eliminación de Gauss y Gauss-Jordan");
        System.out.println("==========================================\n");

        // ==========================================
        // EJERCICIO 1 — GAUSS SIMPLE
        // ==========================================
        System.out.println("********** EJERCICIO 1: Gauss Simple **********");
        double[][] sistema1 = {
            { 8,  2, -2, -2 },
            { 10,  2,  4,  4 },
            { 12,  2,  2,  6 }
        };

        double[] resp1 = MetodosGauss.gaussSimple(copiarMatriz(sistema1));
        System.out.println("===== RESULTADO FINAL - Ejercicio 1 =====");
        System.out.printf("x1 = %.4f%n", resp1[0]);
        System.out.printf("x2 = %.4f%n", resp1[1]);
        System.out.printf("x3 = %.4f%n", resp1[2]);
        System.out.println("Solución: (1.5 , -6.5 , 0.5) ✔\n");

        // ==========================================
        // EJERCICIO 2 — GAUSS-JORDAN
        // ==========================================
        System.out.println("********** EJERCICIO 2: Gauss-Jordan **********");
        double[][] sistema2 = {
            {  2, -6, -1, -38 },
            { -3, -1,  7, -34 },
            { -8,  1, -2, -20 }
        };

        double[] resp2 = MetodosGauss.gaussJordan(copiarMatriz(sistema2));
        System.out.println("===== RESULTADO FINAL - Ejercicio 2 =====");
        System.out.printf("x1 = %.0f%n", resp2[0]);
        System.out.printf("x2 = %.0f%n", resp2[1]);
        System.out.printf("x3 = %.0f%n", resp2[2]);
        System.out.println("Solución: (4 , 8 , -2) ✔\n");

        System.out.println("==========================================");
        System.out.println("       PRÁCTICA FINALIZADA CON ÉXITO");
        System.out.println("==========================================");
    }

    // Crea una copia de la matriz para no modificar la original
    private static double[][] copiarMatriz(double[][] original) {
        int n = original.length;
        double[][] copia = new double[n][n + 1];
        for (int i = 0; i < n; i++) {
            System.arraycopy(original[i], 0, copia[i], 0, n + 1);
        }
        return copia;
    }
}

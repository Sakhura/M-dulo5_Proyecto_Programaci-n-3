/**
 * CSE 205 - Proyecto de Programación 3
 * Clase TestExpression: Pruebas unitarias para el evaluador de expresiones
 * 
 * Esta clase contiene pruebas para verificar que el evaluador funciona correctamente
 */
public class TestExpression {
    
    /**
     * Método main que ejecuta todas las pruebas
     */
    public static void main(String[] args) {
        System.out.println("=== PRUEBAS DEL EVALUADOR DE EXPRESIONES ===\n");
        
        Expression expr = new Expression();
        int passed = 0;
        int total = 0;
        
        // Prueba 1: Suma simple
        total++;
        System.out.println("Prueba 1: 3 + 5");
        if (testExpression(expr, "3 + 5", 8.0)) {
            passed++;
        }
        
        // Prueba 2: Resta simple
        total++;
        System.out.println("\nPrueba 2: 10 - 3");
        if (testExpression(expr, "10 - 3", 7.0)) {
            passed++;
        }
        
        // Prueba 3: Multiplicación simple
        total++;
        System.out.println("\nPrueba 3: 4 * 6");
        if (testExpression(expr, "4 * 6", 24.0)) {
            passed++;
        }
        
        // Prueba 4: División simple
        total++;
        System.out.println("\nPrueba 4: 20 / 4");
        if (testExpression(expr, "20 / 4", 5.0)) {
            passed++;
        }
        
        // Prueba 5: Precedencia de operadores
        total++;
        System.out.println("\nPrueba 5: 2 + 3 * 4");
        if (testExpression(expr, "2 + 3 * 4", 14.0)) {
            passed++;
        }
        
        // Prueba 6: Precedencia con división
        total++;
        System.out.println("\nPrueba 6: 20 / 4 + 3");
        if (testExpression(expr, "20 / 4 + 3", 8.0)) {
            passed++;
        }
        
        // Prueba 7: Expresión con paréntesis
        total++;
        System.out.println("\nPrueba 7: ( 2 + 3 ) * 4");
        if (testExpression(expr, "( 2 + 3 ) * 4", 20.0)) {
            passed++;
        }
        
        // Prueba 8: Expresión compleja
        total++;
        System.out.println("\nPrueba 8: 10 + 2 * ( 6 - 4 )");
        if (testExpression(expr, "10 + 2 * ( 6 - 4 )", 14.0)) {
            passed++;
        }
        
        // Prueba 9: Múltiples operaciones
        total++;
        System.out.println("\nPrueba 9: 100 / 10 + 50 - 20 * 2");
        if (testExpression(expr, "100 / 10 + 50 - 20 * 2", 20.0)) {
            passed++;
        }
        
        // Prueba 10: Paréntesis anidados
        total++;
        System.out.println("\nPrueba 10: ( ( 5 + 3 ) * 2 ) / 4");
        if (testExpression(expr, "( ( 5 + 3 ) * 2 ) / 4", 4.0)) {
            passed++;
        }
        
        // Prueba 11: Números decimales
        total++;
        System.out.println("\nPrueba 11: 3.5 + 2.5");
        if (testExpression(expr, "3.5 + 2.5", 6.0)) {
            passed++;
        }
        
        // Prueba 12: Expresión del ejemplo
        total++;
        System.out.println("\nPrueba 12: 1 + 2");
        if (testExpression(expr, "1 + 2", 3.0)) {
            passed++;
        }
        
        // Resumen de resultados
        System.out.println("\n========================================");
        System.out.println("RESULTADOS: " + passed + "/" + total + " pruebas pasadas");
        System.out.println("========================================");
        
        if (passed == total) {
            System.out.println("✓ ¡TODAS LAS PRUEBAS PASARON!");
        } else {
            System.out.println("✗ Algunas pruebas fallaron");
        }
    }
    
    /**
     * Prueba una expresión y verifica que el resultado sea el esperado
     * 
     * @param expr Objeto Expression para evaluar
     * @param expression Expresión a evaluar
     * @param expected Resultado esperado
     * @return true si la prueba pasa, false en caso contrario
     */
    private static boolean testExpression(Expression expr, String expression, double expected) {
        try {
            Double result = expr.evaluate(expression);
            
            // Compara con una pequeña tolerancia para errores de punto flotante
            boolean passed = Math.abs(result - expected) < 0.0001;
            
            if (passed) {
                System.out.println("  Resultado: " + result + " ✓ CORRECTO");
                return true;
            } else {
                System.out.println("  Resultado: " + result + " ✗ INCORRECTO");
                System.out.println("  Se esperaba: " + expected);
                return false;
            }
        } catch (Exception e) {
            System.out.println("  ✗ ERROR: " + e.getMessage());
            return false;
        }
    }
}

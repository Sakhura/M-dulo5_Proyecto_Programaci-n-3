/**
 * CSE 205 - Proyecto de Programación 3
 * Clase SubOperator: Implementa el operador de resta (-)
 * 
 * Ejemplo: 10 - 3 = 7
 */
public class SubOperator extends BinaryOperator {
    public SubOperator() {
    }
    
    /**
     * Implementa la operación de resta
     * 
     * @param pLhsOperand Operando izquierdo
     * @param pRhsOperand Operando derecho
     * @return La diferencia entre ambos operandos
     */
    @Override
    protected double binaryOperation(double pLhsOperand, double pRhsOperand) {
        return pLhsOperand - pRhsOperand;
    }
    
    /**
     * Precedencia del operador resta
     * + y - tienen precedencia 2 (menor que * y /)
     * 
     * @return 2
     */
    @Override
    public int precedence() {
        return 2;
    }
    
    /**
     * Representación en String del operador
     * 
     * @return "-"
     */
    @Override
    public String toString() {
        return "-";
    }
}

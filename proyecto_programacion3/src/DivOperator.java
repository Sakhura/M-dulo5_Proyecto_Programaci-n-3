/**
 * CSE 205 - Proyecto de Programación 3
 * Clase DivOperator: Implementa el operador de división (/)
 * 
 * Ejemplo: 12 / 3 = 4
 */
public class DivOperator extends BinaryOperator {
    
    /**
     * Constructor por defecto
     */
    public DivOperator() {
    }
    
    /**
     * Implementa la operación de división
     * 
     * @param pLhsOperand Operando izquierdo (dividendo)
     * @param pRhsOperand Operando derecho (divisor)
     * @return El cociente de la división
     */
    @Override
    protected double binaryOperation(double pLhsOperand, double pRhsOperand) {
        return pLhsOperand / pRhsOperand;
    }
    
    /**
     * Precedencia del operador división
     * * y / tienen precedencia 3 (mayor que + y -)
     * 
     * @return 3
     */
    @Override
    public int precedence() {
        return 3;
    }
    
    /**
     * Representación en String del operador
     * 
     * @return "/"
     */
    @Override
    public String toString() {
        return "/";
    }
}

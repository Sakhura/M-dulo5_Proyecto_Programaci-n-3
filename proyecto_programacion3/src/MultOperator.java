/**
 * CSE 205 - Proyecto de Programación 3
 * Clase MultOperator: Implementa el operador de multiplicación (*)
 * 
 * Ejemplo: 4 * 3 = 12
 */
public class MultOperator extends BinaryOperator {

      public MultOperator() {
    }
    
    /**
     * Implementa la operación de multiplicación
     * 
     * @param pLhsOperand Operando izquierdo
     * @param pRhsOperand Operando derecho
     * @return El producto de ambos operandos
     */
    @Override
    protected double binaryOperation(double pLhsOperand, double pRhsOperand) {
        return pLhsOperand * pRhsOperand;
    }
    
    /**
     * Precedencia del operador multiplicación
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
     * @return "*"
     */
    @Override
    public String toString() {
        return "*";
    }
}

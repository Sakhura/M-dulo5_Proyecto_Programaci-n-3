/**
 * CSE 205 - Proyecto de Programación 3
 * Clase AddOperator: Implementa el operador de suma (+)
 * 
 * Ejemplo: 3 + 5 = 8
 */
public class AddOperator extends BinaryOperator {
    
      public AddOperator() {
    }
    
    /**
     * Implementa la operación de suma
     * 
     * @param pLhsOperand Operando izquierdo
     * @param pRhsOperand Operando derecho
     * @return La suma de ambos operandos
     */
    @Override
    protected double binaryOperation(double pLhsOperand, double pRhsOperand) {
        return pLhsOperand + pRhsOperand;
    }
    
    /**
     * Precedencia del operador suma
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
     * @return "+"
     */
    @Override
    public String toString() {
        return "+";
    }
}

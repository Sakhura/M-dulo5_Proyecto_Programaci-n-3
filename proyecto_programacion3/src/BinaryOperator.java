/**
 * CSE 205 - Proyecto de Programación 3
 * Clase BinaryOperator: Clase abstracta para operadores binarios
 * 
 * Un operador binario requiere dos operandos: izquierdo y derecho
 * Ejemplo: En "3 + 5", el + es un operador binario
 */
public abstract class BinaryOperator extends Operator {
    
    public BinaryOperator() {
    }
    
    /**
     * Evalúa la operación binaria entre dos operandos
     * 
     * @param pLhsOperand Operando izquierdo (Left-Hand Side)
     * @param pRhsOperand Operando derecho (Right-Hand Side)
     * @return Nuevo Operand con el resultado de la operación
     */
    @Override
    public Operand evaluate(Operand pLhsOperand, Operand pRhsOperand) {
        // Extrae los valores de los operandos
        double leftValue = pLhsOperand.getValue();
        double rightValue = pRhsOperand.getValue();
        
        // Realiza la operación específica (definida en subclases)
        double result = binaryOperation(leftValue, rightValue);
        
        // Retorna el resultado como un nuevo Operand
        return new Operand(result);
    }
    
    /**
     * Método abstracto que implementa la operación específica
     * Cada subclase (AddOperator, SubOperator, etc.) lo implementa
     * 
     * @param pLhsOperand Valor del operando izquierdo
     * @param pRhsOperand Valor del operando derecho
     * @return Resultado de la operación
     */
    protected abstract double binaryOperation(double pLhsOperand, double pRhsOperand);
    
    /**
     * Los operadores binarios siempre tienen 2 operandos
     * 
     * @return 2
     */
    @Override
    public int operandCount() {
        return 2;
    }
}

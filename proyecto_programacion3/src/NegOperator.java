/**
 * CSE 205 - Proyecto de Programación 3
 * Clase NegOperator: Implementa el operador de negación unario (-)
 * 
 * Ejemplo: -5 convierte 5 en -5
 * Diferente del operador binario de resta
 */
public class NegOperator extends Operator {
        public NegOperator() {
    }
    
    /**
     * Evalúa la negación de un operando
     * 
     * @param pOperand El operando a negar
     * @param pUnused No se usa (operador unario solo necesita un operando)
     * @return Nuevo Operand con el valor negado
     */
    @Override
    public Operand evaluate(Operand pOperand, Operand pUnused) {
        return new Operand(-pOperand.getValue());
    }
    
    /**
     * Precedencia del operador negación
     * El operador unario tiene precedencia 4 (mayor que todos los binarios)
     * 
     * @return 4
     */
    @Override
    public int precedence() {
        return 4;
    }
    
    /**
     * Los operadores unarios tienen 1 operando
     * 
     * @return 1
     */
    @Override
    public int operandCount() {
        return 1;
    }
    
    /**
     * Representación en String del operador
     * 
     * @return "~" (usamos ~ para distinguirlo del - binario)
     */
    @Override
    public String toString() {
        return "~";
    }
}

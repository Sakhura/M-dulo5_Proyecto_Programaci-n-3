/**
 * CSE 205 - Proyecto de Programación 3
 * Clase Operator: Clase abstracta base para todos los operadores
 * 
 * Define la interfaz común para operadores binarios y unarios
 */
public abstract class Operator extends Token {

    public Operator() {
    }
    
    /**
     * Método abstracto que evalúa el operador
     * Los operadores binarios lo implementarán para dos operandos
     * Los operadores unarios lo implementarán para un operando
     * 
     * @param pLhsOperand Operando izquierdo (o único operando para unarios)
     * @param pRhsOperand Operando derecho (null para operadores unarios)
     * @return Resultado de la operación
     */
    public abstract Operand evaluate(Operand pLhsOperand, Operand pRhsOperand);
    
    /**
     * Un operador es un operador
     * 
     * @return true siempre
     */
    @Override
    public boolean isOperator() {
        return true;
    }
    
    /**
     * Devuelve la precedencia del operador
     * Necesario para el algoritmo de conversión infija a postfija
     * 
     * @return Nivel de precedencia (mayor número = mayor precedencia)
     */
    public abstract int precedence();
    
    /**
     * Método abstracto para obtener el número de operandos
     * 
     * @return 1 para operadores unarios, 2 para binarios
     */
    public abstract int operandCount();
}

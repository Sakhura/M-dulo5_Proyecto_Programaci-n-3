/**
 * CSE 205 - Proyecto de Programación 3
 * Clase Operand: Representa un operando (número) en una expresión
 * 
 * Ejemplo: En "3 + 5", tanto 3 como 5 son operandos
 */
public class Operand extends Token {
    
    private Double mValue;
    
    /**
     * Constructor que inicializa el operando con un valor double
     * 
     * @param pValue El valor numérico del operando
     */
    public Operand(Double pValue) {
        mValue = pValue;
    }
    
    /**
     * Constructor que inicializa el operando desde un String
     * 
     * @param pValue String que representa el número
     */
    public Operand(String pValue) {
        mValue = Double.parseDouble(pValue);
    }
    
    /**
     * Obtiene el valor del operando
     * 
     * @return El valor numérico
     */
    public Double getValue() {
        return mValue;
    }
    
    /**
     * Establece un nuevo valor para el operando
     * 
     * @param pValue El nuevo valor
     */
    public void setValue(Double pValue) {
        mValue = pValue;
    }
    
    /**
     * Un operando no es un operador
     * 
     * @return false siempre
     */
    @Override
    public boolean isOperator() {
        return false;
    }
    
    /**
     * Convierte el operando a String
     * 
     * @return Representación en String del valor
     */
    @Override
    public String toString() {
        return mValue.toString();
    }
}

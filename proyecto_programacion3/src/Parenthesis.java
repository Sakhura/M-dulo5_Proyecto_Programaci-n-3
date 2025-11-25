/**
 * CSE 205 - Proyecto de Programación 3
 * Clase Parenthesis: Representa un paréntesis en una expresión
 * 
 * Maneja tanto paréntesis de apertura '(' como de cierre ')'
 */
public class Parenthesis extends Token {
    
    private String mParenthesis;
    
    /**
     * Constructor que inicializa el paréntesis
     * 
     * @param pParenthesis El tipo de paréntesis: "(" o ")"
     */
    public Parenthesis(String pParenthesis) {
        mParenthesis = pParenthesis;
    }
    
    /**
     * Verifica si es un paréntesis de apertura
     * 
     * @return true si es '(', false en caso contrario
     */
    public boolean isLeftParen() {
        return mParenthesis.equals("(");
    }
    
    /**
     * Verifica si es un paréntesis de cierre
     * 
     * @return true si es ')', false en caso contrario
     */
    public boolean isRightParen() {
        return mParenthesis.equals(")");
    }
    
    /**
     * Un paréntesis no es un operador
     * 
     * @return false
     */
    @Override
    public boolean isOperator() {
        return false;
    }
    
    /**
     * Representación en String del paréntesis
     * 
     * @return "(" o ")"
     */
    @Override
    public String toString() {
        return mParenthesis;
    }
}

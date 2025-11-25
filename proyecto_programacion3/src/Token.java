/**
 * CSE 205 - Proyecto de Programación 3
 * Clase Token: Representa un token (elemento) en una expresión aritmética
 * 
 * Un token puede ser:
 * - Un operando (número)
 * - Un operador (+, -, *, /)
 * - Un paréntesis
 */
public abstract class Token {

    public Token() {
    }
    
    /**
     * Método abstracto que debe ser implementado por las subclases
     * para determinar si el token es un operador
     * 
     * @return true si es un operador, false en caso contrario
     */
    public abstract boolean isOperator();
    
    /**
     * Convierte el token a su representación en String
     * 
     * @return Representación en String del token
     */
    @Override
    public abstract String toString();
}

import java.util.ArrayList;

/**
 * CSE 205 - Proyecto de Programación 3
 * Clase Expression: Representa y evalúa una expresión aritmética
 * 
 * Utiliza el algoritmo de Shunting Yard para convertir notación infija a postfija
 * y luego evalúa la expresión postfija usando una pila
 */
public class Expression {
    
    /**
     * Constante para representar asociatividad izquierda
     */
    public static final int ASSOC_LEFT = 0;
    
    /**
     * Constante para representar asociatividad derecha
     */
    public static final int ASSOC_RIGHT = 1;
    
    /**
     * Constructor por defecto
     */
    public Expression() {
    }
    
    /**
     * Evalúa una expresión aritmética en notación infija
     * 
     * Algoritmo:
     * 1. Convierte la expresión infija (ej: "3 + 4 * 2") a tokens
     * 2. Convierte los tokens a notación postfija (ej: "3 4 2 * +")
     * 3. Evalúa la expresión postfija usando una pila
     * 
     * @param pExpr Expresión en notación infija (ej: "1 + 2 * 3")
     * @return El resultado de evaluar la expresión
     */
    public Double evaluate(String pExpr) {
        // Paso 1: Tokenizar la expresión
        ArrayList<Token> tokenList = tokenize(pExpr);
        
        // Paso 2: Convertir a notación postfija
        ArrayList<Token> postfixList = infixToPostfix(tokenList);
        
        // Paso 3: Evaluar la expresión postfija
        return evaluatePostfix(postfixList);
    }
    
    /**
     * Tokeniza una expresión, dividiéndola en tokens individuales
     * 
     * Ejemplo: "3 + 4 * 2" -> [Operand(3), AddOperator, Operand(4), MultOperator, Operand(2)]
     * 
     * @param pExpr Expresión en formato String
     * @return Lista de tokens
     */
    private ArrayList<Token> tokenize(String pExpr) {
        ArrayList<Token> tokenList = new ArrayList<>();
        
        // Divide la expresión por espacios
        String[] tokens = pExpr.trim().split("\\s+");
        
        // Procesa cada token
        for (String tokenStr : tokens) {
            if (tokenStr.isEmpty()) {
                continue;
            }
            
            Token token = createToken(tokenStr);
            tokenList.add(token);
        }
        
        return tokenList;
    }
    
    /**
     * Crea un token a partir de un String
     * 
     * @param pToken String que representa el token
     * @return Token correspondiente (Operand, Operator o Parenthesis)
     */
    private Token createToken(String pToken) {
        // Verifica si es un paréntesis
        if (pToken.equals("(") || pToken.equals(")")) {
            return new Parenthesis(pToken);
        }
        
        // Verifica si es un operador
        switch (pToken) {
            case "+":
                return new AddOperator();
            case "-":
                return new SubOperator();
            case "*":
                return new MultOperator();
            case "/":
                return new DivOperator();
            case "~":
                return new NegOperator();
        }
        
        // Si no es operador ni paréntesis, es un operando (número)
        return new Operand(pToken);
    }
    
    /**
     * Convierte una expresión infija a postfija usando el algoritmo Shunting Yard
     * 
     * Notación infija: 3 + 4 * 2 (operadores entre operandos)
     * Notación postfija: 3 4 2 * + (operadores después de operandos)
     * 
     * La notación postfija elimina la necesidad de paréntesis y precedencia
     * 
     * @param pTokenList Lista de tokens en notación infija
     * @return Lista de tokens en notación postfija
     */
    private ArrayList<Token> infixToPostfix(ArrayList<Token> pTokenList) {
        // Pila para operadores temporales
        Stack<Token> operatorStack = new Stack<>();
        
        // Lista de salida en notación postfija
        ArrayList<Token> postfixList = new ArrayList<>();
        
        // Procesa cada token
        for (Token token : pTokenList) {
            
            // Si es un operando, lo añade directamente a la salida
            if (!token.isOperator() && !(token instanceof Parenthesis)) {
                postfixList.add(token);
            }
            // Si es un paréntesis izquierdo, lo apila
            else if (token instanceof Parenthesis && ((Parenthesis) token).isLeftParen()) {
                operatorStack.push(token);
            }
            // Si es un paréntesis derecho
            else if (token instanceof Parenthesis && ((Parenthesis) token).isRightParen()) {
                // Desapila operadores hasta encontrar el paréntesis izquierdo
                while (!operatorStack.isEmpty() && 
                       !(operatorStack.peek() instanceof Parenthesis)) {
                    postfixList.add(operatorStack.pop());
                }
                // Elimina el paréntesis izquierdo
                if (!operatorStack.isEmpty()) {
                    operatorStack.pop();
                }
            }
            // Si es un operador
            else if (token.isOperator()) {
                Operator operator = (Operator) token;
                
                // Desapila operadores de mayor o igual precedencia
                while (!operatorStack.isEmpty() && 
                       operatorStack.peek().isOperator()) {
                    Operator topOperator = (Operator) operatorStack.peek();
                    
                    if (topOperator.precedence() >= operator.precedence()) {
                        postfixList.add(operatorStack.pop());
                    } else {
                        break;
                    }
                }
                
                // Apila el operador actual
                operatorStack.push(operator);
            }
        }
        
        // Desapila los operadores restantes
        while (!operatorStack.isEmpty()) {
            postfixList.add(operatorStack.pop());
        }
        
        return postfixList;
    }
    
    /**
     * Evalúa una expresión en notación postfija
     * 
     * Algoritmo:
     * - Si encuentra un operando, lo apila
     * - Si encuentra un operador:
     *   1. Desapila operando(s)
     *   2. Aplica la operación
     *   3. Apila el resultado
     * 
     * Ejemplo: [3, 4, 2, *, +]
     * 1. Apila 3, 4, 2
     * 2. Ve *, desapila 2 y 4, calcula 4*2=8, apila 8
     * 3. Ve +, desapila 8 y 3, calcula 3+8=11, apila 11
     * 4. Resultado final: 11
     * 
     * @param pPostfixList Lista de tokens en notación postfija
     * @return El resultado de evaluar la expresión
     */
    private Double evaluatePostfix(ArrayList<Token> pPostfixList) {
        // Pila para operandos
        Stack<Operand> operandStack = new Stack<>();
        
        // Procesa cada token
        for (Token token : pPostfixList) {
            
            // Si es un operando, lo apila
            if (!token.isOperator()) {
                operandStack.push((Operand) token);
            }
            // Si es un operador
            else {
                Operator operator = (Operator) token;
                
                // Desapila el número necesario de operandos
                Operand rightOperand = null;
                Operand leftOperand = null;
                
                if (operator.operandCount() == 2) {
                    // Operador binario: necesita 2 operandos
                    rightOperand = operandStack.pop();
                    leftOperand = operandStack.pop();
                } else {
                    // Operador unario: necesita 1 operando
                    leftOperand = operandStack.pop();
                }
                
                // Evalúa la operación
                Operand result = operator.evaluate(leftOperand, rightOperand);
                
                // Apila el resultado
                operandStack.push(result);
            }
        }
        
        // El resultado final es el único elemento en la pila
        return operandStack.pop().getValue();
    }
}

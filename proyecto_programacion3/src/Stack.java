import java.util.ArrayList;

/**
 * CSE 205 - Proyecto de Programación 3
 * Clase Stack: Implementa una pila (Stack) genérica usando ArrayList
 * 
 * Una pila es una estructura LIFO (Last In, First Out)
 * El último elemento en entrar es el primero en salir
 * 
 * @param <E> Tipo de elementos que almacena la pila
 */
public class Stack<E> {
    
    private ArrayList<E> mList;
    
    /**
     * Constructor que inicializa la pila vacía
     */
    public Stack() {
        mList = new ArrayList<>();
    }
    
    /**
     * Elimina y retorna el elemento en el tope de la pila
     * 
     * @return El elemento del tope
     * @throws RuntimeException si la pila está vacía
     */
    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack vacía - no se puede hacer pop");
        }
        // Elimina y retorna el último elemento
        return mList.remove(mList.size() - 1);
    }
    
    /**
     * Agrega un elemento al tope de la pila
     * 
     * @param pElement El elemento a agregar
     */
    public void push(E pElement) {
        mList.add(pElement);
    }
    
    /**
     * Retorna el elemento en el tope sin eliminarlo
     * 
     * @return El elemento del tope
     * @throws RuntimeException si la pila está vacía
     */
    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack vacía - no se puede hacer peek");
        }
        // Retorna el último elemento sin eliminarlo
        return mList.get(mList.size() - 1);
    }
    
    /**
     * Verifica si la pila está vacía
     * 
     * @return true si la pila está vacía, false en caso contrario
     */
    public boolean isEmpty() {
        return mList.isEmpty();
    }
    
    /**
     * Elimina todos los elementos de la pila
     */
    public void clear() {
        mList.clear();
    }
    
    /**
     * Retorna el número de elementos en la pila
     * 
     * @return Tamaño de la pila
     */
    public int size() {
        return mList.size();
    }
    
    /**
     * Representación en String de la pila
     * 
     * @return String con todos los elementos
     */
    @Override
    public String toString() {
        return mList.toString();
    }
}

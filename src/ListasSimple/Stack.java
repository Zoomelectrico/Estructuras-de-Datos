/**
 * @author José Roberto Quevedo Gabizón 
 */
package ListasSimple;

public class Stack <T> {
    private Node<T> head;

    private boolean isEmpty(){
        return this.head == null;
    }
    /**
     * Método push(): este método ingresa un elemento a la pila
     * @param dato el dato que se resea ingresar en la Lista
     */
    public void push(T dato) {
        Node<T> n = new Node<>(dato); // Creo el Node con el Dato que me pasaron
        if (isEmpty()) {
            this.head = n;
        } else {
            n.setNext(this.head);
            this.head = n;
        }
    }
    /**
     * Método pop(): este método elimina el 1er elemento de la pila
     * @return null si la no hay nada en la lista o el valor que se encuentre de primero en la lista
     */
    public T pop() {
        if (isEmpty()){
            return null;
        } else {
            Node<T> temp = this.head;
            this.head = temp.getNext();
            temp.setNext(null);
            return temp.getData();
        }
    }
    /**
     * Método peek(): este metodo regresa el 1er elemento de la pila, sin eliminar
     * @return null si la no hay nada en la lista o el valor que se encuentre de primero en la lista
     */
    public T peek() {
        if (isEmpty()){
            return null;
        } else {
            Node<T> temp = this.head;
            return temp.getData();
        }
    }
}

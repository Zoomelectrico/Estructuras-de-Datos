package ListasSimple;

public class Queue <T> {
    private Node<T> cabeza;

    private boolean estaVacia(){
        return this.cabeza == null;
    }
    /**
     * Método push(): este método ingresa un elemento a la pila
     * @param dato el dato que se resea ingresar en la Lista
     */
    public void push(T dato) {
        Node<T> n = new Node<>(dato); // Creo el Node con el Dato que me pasaron
        if (estaVacia()) {
            this.cabeza = n;
        } else {
            n.setNext(this.cabeza);
            this.cabeza = n;
        }
    }
    /**
     * Método pop(): este método elimina el 1er elemento de la pila
     * @return null si la no hay nada en la lista o el valor que se encuentre de primero en la lista
     */
    public T pop() {
        if (estaVacia()){
            return null;
        } else {
            Node<T> temp = this.cabeza;
            this.cabeza = temp.getNext();
            temp.setNext(null);
            return temp.getData();
        }
    }
    /**
     * Método peek(): este metodo regresa el 1er elemento de la pila, sin eliminar
     * @return null si la no hay nada en la lista o el valor que se encuentre de primero en la lista
     */
    public T peek() {
        if (estaVacia()){
            return null;
        } else {
            Node<T> temp = this.cabeza;
            return temp.getData();
        }
    }
}

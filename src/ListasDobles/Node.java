package ListasDobles;

public class Node <T> {
    private T dato;
    private Node<T> next;
    private Node<T> prev;

    public Node (T dato){
        this.dato = dato;
        this.next = null;
        this.prev = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
    
}
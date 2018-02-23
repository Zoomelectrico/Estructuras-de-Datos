/**
 * @author José Roberto Quevedo Gabizón 
 */
package ListasSimple;

public class Node <T> {
    private T data;
    private Node<T> next;

    public Node (T dato){
        this.data = dato;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T dato) {
        this.data = dato;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

}
package ListasDobles;

public class DoubleList<T> {
    private Node<T> head;
    private Node<T> tail;

    /**
     * Constructor
     */
    public DoubleList() {
    
    }
    /**
     * Constructor
     * @param n Node inicial
     */
    public DoubleList(Node<T> n) {
        this.head = this.tail = n;
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
    }
    private boolean isEmpty() {
        return this.head == null;
    }
    /**
     * método size(): el método regresa el tamaño de la lista
     * @return el tamaño de la lista
     */
    public int size() {
        if (isEmpty()) {
            return 0;
        } else {
            Node<T> aux = this.head;
            int i = 0;
            while (aux != null) {
                aux = aux.getNext();
                i++;
            }
            return i;
        }
    }
    /**
     * método addFirst(): este método permite ingresar un dato al inicio de la lista
     * @param dato
     */
    public void addFirst(T dato){
        Node<T> n = new Node<>(dato);
        if (isEmpty()) {
            this.head = this.tail = n;
            this.head.setNext(this.tail);
            this.tail.setPrev(this.head);
        } else {
            n.setNext(this.head);
            this.head.setPrev(n);
            this.head = n;
        }
    }
    /**
     * método addFinal(): este método permite ingresar un dato al final de la lista
     * @param dato
     */
    public void addFinal(T dato){
        Node<T> n = new Node<>(dato);
        if (isEmpty()) {
            this.head = this.tail = n;
            this.head.setNext(this.tail);
            this.tail.setPrev(this.head);
        } else {
            n.setPrev(this.tail);
            this.tail.setNext(n);
            this.tail = n;
        }
    }
    /**
     * Método add(): Este método ingresa un elemento en la posición i a las lista
     * @param dato el dato que desea agregar
     * @param i el índice en que se desea agregar el elemento
     */
    public void add (T dato, int i) {
        Node<T> n = new Node<>(dato);
        if (isEmpty() || i == 0) {
            this.addFirst(dato);
        } else if (i == this.size()-1) {
            this.addFinal(dato);
        } else if (i < 0) {
            this.add(dato, this.size()+i);
        } else if (i > this.size() ) {
            System.out.println("Error");
        } else {
            // TODO: Implementar
        }
    }
    /**
     * Método deleteFisrt(): elimina el primer elemento de la lista
     * @return null si la lista esta vacia o el dato que se encuentra en la primera posición
     */
    public T deleteFirst () {
        if (isEmpty()) {
            return null;
        } else {
            Node<T> temp = this.head;
            this.head = this.head.getNext();
            this.head.setPrev(null);
            temp.setNext(null);
            return temp.getDato();
        }
    }
    /**
     *
     * @return 
     */
    public T deleteLast () {
        if (isEmpty()) {
            return null;
        } else {
            Node<T> temp = this.tail;
            this.tail = this.tail.getPrev();
            this.tail.setNext(null);
            temp.setPrev(null);
            return temp.getDato();
        }
    }
    /**
     *
     * @param i
     * @return 
     */
    public T delete (int i) {
        if (isEmpty()) {
            return null;
        } else if (i == 0) {
            return this.deleteFirst();
        } else if (i == this.size()-1) {
            return this.deleteLast();
        } else if (i < 0) {
            return this.delete(this.size()+i);
        } else if (i > this.size() ) {
            System.out.println("Error");
            return null;
        } else {
            // TODO: Implementar
            return null; // Para que no de error
        } 
    }
}

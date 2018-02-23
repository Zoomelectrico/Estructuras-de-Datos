/**
 * @author José Roberto Quevedo Gabizón 
 */
package ListasSimple;

import java.util.Arrays;

public class List <T> {
    private Node<T> head;
    private Node<T> tail;

    // Constructores
    public List(){
        this.head = this.tail = null;
    }

    public List(Node<T> n){
        this.head = this.tail = n;
    }

    /**
     * Método isEmpty():
     * @return true si la lista esta vacia o false en caso contrario
     */
    private boolean isEmpty(){
        return this.head == null;
    }
    /**
     * Método Tamanaio:
     * @return el Tamaño de la Lista
     */
    public int size() {
        int i = 0;
        if (isEmpty()) {
            return 0;
        } else {
            Node<T> aux = this.head;
            while(aux != null){
                aux = aux.getNext();
                i++;
            }
            return i;
        }
    }
    /**
     * Método addFirst():
     * @param dato el dato que se resea ingresar en la Lista
     */
    public void addFirst(T dato) {
        Node<T> n = new Node<>(dato); // Creo el Node con el Dato que me pasaron
        if (isEmpty()) {
            this.head = n;
            this.tail = n;
            this.head.setNext(this.tail);
            this.tail.setNext(null);
        } else {
            n.setNext(this.head);
            this.head = n;
        }
    }
    /**
     * Método addLast():
     * @param dato: el dato a insertar
     */
    public void addLast(T dato) {
        Node<T> n = new Node<>(dato);
        if (isEmpty()) {
            this.head = n;
            this.tail = n;
            this.head.setNext(this.tail);
            this.tail.setNext(null);
        } else {
            this.tail.setNext(n);
            this.tail = n;
        }
    }
    /**
     * Método add():
     * @param dato: el dato a insertar
     * @param i
     */
    public void add(T dato, int i) {
        if (isEmpty() || i == 0) {
            this.addFirst(dato);
        } else if (i == this.size()-1) {
            this.addLast(dato);
        } else if (i < 0) {
            this.add(dato,this.size()+i);
        } else if (i > this.size()) {
            System.out.println("Error");
        } else {
            Node<T> n = new Node<>(dato);
            Node<T> aux = this.head;
            int count = 0;
            while (count < i-1) {
                aux = aux.getNext();
                count++;
            }
            n.setNext(aux.getNext());
            aux.setNext(n);
        }
    }
    /**
     * Método deleteFirst():
     * @return null si la no hay nada en la lista o el valor que se encuentre de primero en la lista
     */
    public T deleteFirst() {
        if (isEmpty()){
            return null;
        } else {
            Node<T> temp = this.head;
            this.head = this.head.getNext();
            temp.setNext(null);
            return temp.getData();
        }
    }
    /**
     * Método deleteLast():
     * @return null si la no hay nada en la lista o el valor que se encuentre al final
     */
    public T deleteLast() {
        if (isEmpty()) {
            return null;
        } else {
            Node<T> aux = this.head;
            while (aux.getNext().getNext() != null) {
                aux = aux.getNext();
            }
            Node<T> temp = aux.getNext();
            aux.setNext(null);
            this.tail = aux;
            temp.setNext(null);
            return temp.getData();
        }
    }
    /**
     * Método delete():
     * @param i la posicion en la que se desea eliminar
     * @return null si la lista esta vacia o el valor que se encuentra en la posición i
     */
    public T delete(int i) {
        if (isEmpty()) {
            return null;
        } else if (i == 0) {
            return this.deleteFirst();
        } else if (i == this.size()-1) {
            return this.deleteLast();
        } else if (i < 0) {
            return this.delete(this.size()+i);
        } else if (i > this.size()) {
            System.out.println("Error");
            return null;
        } else{
            Node<T> aux = this.head;
            int count = 0;
            while (count < i-1) {
                aux = aux.getNext();
            }
            Node<T> temp = aux.getNext();
            aux.setNext(temp.getNext());
            temp.setNext(null);
            return temp.getData();
        }
    }
    /**
     * Método ToArray():
     * @return un arreglo con los elementos que la lista contiene
     */
    public T[] toArray(){
        T[] arreglo = (T[]) new Arrays[this.size()];
        Node<T> aux = this.head;
        for (int i = 0; i < arreglo.length ; i++) {
            arreglo[i] = aux.getData();
            aux = aux.getNext();
        }
        return arreglo;
    }
    /**
     * Método imprimir(): Imprime la lista por consola
     */
    public void print(){
        if (isEmpty()) {
            System.out.println("Vacia");
        } else {
            Node<T> aux = this.head;
            while (aux != null) {
                System.out.println(aux.getData());
                aux = aux.getNext();
            }
        }
    }
}


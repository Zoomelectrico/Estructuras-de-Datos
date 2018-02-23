/**
 * @author José Roberto Quevedo Gabizón 
 */
package ListasSimple;

public class CircularList<T> { // <T>: Es un tipo de dato genérico, es decir, puedo meter int, float o un objeto  
    private Node<T> cabeza;
    private Node<T> cola;

    /**
     * Metodo contructor, genera un lista vacia
     */
    public CircularList(){
        this.cabeza = this.cola = null;
    }
    /**
     * Metodo contructor, genera un lista vacia
     * @param dato primer elemento de la lista
     */
    public CircularList(T dato){
        Node<T> n = new Node<>(dato);
        this.cabeza = this.cola = n;
        this.cabeza.setNext(this.cola);
        this.cola.setNext(this.cabeza);
    }

    private boolean isEmpty(){
        return this.cabeza == null;
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
            Node<T> aux = this.cabeza;
            // Dada la condicion de parada necesito usar un ciclo do - while
            do {
                aux = aux.getNext();
                i++;
            } while(aux != this.cabeza);
            return i;
        }
    }
    /**
     * Método addFirst(): este método permite ingresar un elemento de 1ro en la lista
     * @param dato el dato que se resea ingresar en la Lista
     */
    public void addFirst(T dato) {
        Node<T> n = new Node<>(dato); // Creo el Node con el Dato que me pasaron
        if (isEmpty()) { 
            // Si esta vacia la cola y la cabeza son la misma y ambas se apuntan entre si
            this.cabeza = this.cola = n;
            this.cabeza.setNext(this.cola);
            this.cola.setNext(this.cabeza);
        } else {
            // Si algo en la lista apunta el nuevo Node a la cabeza y 
            //la cola al nuevo Node y cambia la cabeza al nuevo Node
            n.setNext(this.cabeza);
            this.cola.setNext(n);
            this.cabeza = n;
        }
    }
    /**
     * Método addFinal():este método permite inserta un elemento al final de la lista
     * @param dato: el dato a insertar
     */
    public void addFinal(T dato) {
        Node<T> n = new Node<>(dato); // Creo el nuevo Node
        if (isEmpty()) { //Misma historia que arriba
            this.cabeza = this.cola = n;
            this.cabeza.setNext(this.cola);
            this.cola.setNext(this.cabeza);
        } else {
            // misma historia que el de arriba, solo que en vez de mover la cabeza muevo la cola
            n.setNext(this.cabeza);
            this.cola.setNext(n);
            this.cola = n;
        }
    }
    /**
     * Método add(): Este método me permite ingresar un dato en una posición i de la lista
     * @param dato: el dato a insertar
     * @param i el indice o posición en la que deseo ingresar el dato
     */
    public void add(T dato, int i) {
        if (isEmpty() || i == 0) { // Don't Repeat yourself
            this.addFirst(dato);
        } else if (i == this.size()-1) { // Don't Repeat yourself
            this.addFinal(dato);
        } else if (i < 0) {
            // Si el indice que me envian es negativo considero a la cola de la cola
            // como la posición -1 y hago mi procedimiento
            this.add(dato,this.size()+i); 
        } else if (i > this.size()) { 
            // Si me piden algo mayor a lo disponible doy error
            System.out.println("Error");
        } else {
            // Creo el Node para hacer la inserción
            Node<T> n = new Node<>(dato);
            // Aqui debo pararme en una posicion antes a la que quiero ingresar el Node
            // poner al Node nuevo a apuntar el proximo del auxiliar y luego
            // poner al auxiliar a apuntar al nuevo Node
            Node<T> aux = this.cabeza; 
            int count = 0;
            while (count < i-1) {
                aux = aux.getNext();
            }
            n.setNext(aux.getNext());
            aux.setNext(n);
        }
    }
    /**
     * Método deleteFirst(): este método me permite eliminar el 1er elemento de la lista
     * @return null si la no hay nada en la lista o el valor que se encuentre de primero en la lista
     */
    public T deleteFirst() {
        if (isEmpty()){
            return null;
        } else {
            // Copio el Node a eliminar
            Node<T> temp = this.cabeza;
            // muevo a la cabeza (el apuntador)
            this.cabeza = this.cabeza.getNext();
            // muevo la cola
            this.cola.setNext(this.cabeza);
            // limpio el Node
            temp.setNext(null);
            // regreso el dato
            return temp.getData();
        }
    }
    /**
     * Método deleteLast():  este método me permite eliminar el último elemento de la lista
     * @return null si la no hay nada en la lista o el valor que se encuentre al final
     */
    public T deleteLast() {
        if (isEmpty()) {
            return null;
        } else {
            Node<T> aux = this.cabeza;
            // recorro hasta legar a la penultima posicion
            while (aux.getNext().getNext() != this.cabeza) {
                aux = aux.getNext();
            }
            // me copio el Node
            Node<T> temp = aux.getNext();
            // cambio el apuntador
            aux.setNext(this.cabeza);
            // cambio la cola
            this.cola = aux;
            // limpio el Node a eliminar
            temp.setNext(null);
            // regreso el dato
            return temp.getData();
        }
    }
    /**
     * Método delete(): este metodo elimina un Node en una posicion i dada
     * @param i la posicion en la que se desea eliminar
     * @return null si la lista esta vacia o el valor que se encuentra en la posición i
     */
    public T delete(int i) {
        if (isEmpty()) { // DON'T REPEAT YOURSELF
            return null;
        } else if (i == 0) { // DON'T REPEAT YOURSELF
            return this.deleteFirst();
        } else if (i == this.size()-1) { // DON'T REPEAT YOURSELF
            return this.deleteLast();
        } else if (i < 0) { // Recoremos la lista al reves 
            return this.delete(this.size()+i);
        } else if (i > this.size()) { // No puedo eliminar algo que no existe
            System.out.println("Error");
            return null;
        } else {
            Node<T> aux = this.cabeza;
            int count = 0;
            // Me quiero parar en la posicion anterior para eliminar
            while (count < i-1) {
                aux = aux.getNext();
            }
            // Me copio el Node que quiero eliminar
            Node<T> temp = aux.getNext();
            // muevo mis apuntadores
            aux.setNext(temp.getNext());
            // limpio el Node
            temp.setNext(null);
            // regreso el valor
            return temp.getData();
        }
    }
    
}

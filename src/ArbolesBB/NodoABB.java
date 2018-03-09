package arbolesBB;

public class NodoABB {

    private int data;
    private NodoABB hijoIzq;
    private NodoABB hijoDer;

    public NodoABB(int dato) {
        this.data = dato;
        this.hijoIzq = null;
        this.hijoDer = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int dato) {
        this.data = dato;
    }

    public NodoABB getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(NodoABB hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public NodoABB getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(NodoABB hijoDer) {
        this.hijoDer = hijoDer;
    }

    /**
     * EsHoja Verifica si un nodo es hoja
     *
     * @return
     */
    public boolean EsHoja() {
        return (hijoIzq == null && hijoDer == null);
    }

    /**
     * ImprimerNodo Imprime el contenido del nodo
     */
    public void ImprimeNodo() {
        System.out.println(data);
    }

}

package arbolesBB;

public class ArbolBB {

    private NodoABB raiz;

    public ArbolBB() {
        raiz = null;
    }

    /**
     * Constructor CArbolB
     * @param nodo
     */
    public ArbolBB(NodoABB nodo) {
        raiz = nodo;
    }

    /**
     * Método getRaiz(): Devuelve la raiz del arbol
     * @return
     */
    public NodoABB getRaiz() {
        return raiz;
    }
    
    /**
     *
     * @param r
     * @param a
     */
    public void Insertar(NodoABB r, NodoABB a) {
        if (r == null) {
            raiz = a;
        } else {
            if (a.getData() < r.getData()) {
                if (r.getHijoIzq() == null) {
                    r.setHijoIzq(a);
                } else {
                    Insertar(r.getHijoIzq(), a);
                }
            } else if ((a.getData() > r.getData())) {
                if (r.getHijoDer() == null) {
                    r.setHijoDer(a);
                } else {
                    Insertar(r.getHijoDer(), a);
                }
            }
        }
    }
    
    /**
     * Método contarHojas(): Este método cuenta la cantidad de hojas que tiene un arbol
     * @param aux raiz del arbol
     * @return 0 si esta vacio, o el numero de hojas del arbol
     */
    public int ContarHojas(NodoABB aux) {
        if (aux != null) {
            if (aux.EsHoja()) {
                return 1;
            } else {
                return (ContarHojas(aux.getHijoIzq()) + ContarHojas(aux.getHijoDer()));
            }
        } else {
            return 0;
        }
    }
    
    /**
     * Método buscar():
     * @param aux
     * @param data
     * @return 
     */
    public NodoABB buscar(NodoABB aux, int data) {
        if (aux != null) {
            if (aux.getData() == data) {
                return aux;
            } else if (data < aux.getData()) {
                return buscar(aux.getHijoIzq(), data);
            } else {
                return buscar(aux.getHijoDer(), data);
            }
        } else {
            return null;
        }
    }

    /**
     *
     * @param aux
     * @param data
     * @param nivel
     * @return 
     */
    public int Nivel(NodoABB aux, int data, int nivel) {
        if (aux != null) {
            if (aux.getData() == data) {
                return nivel;
            } else if (data < aux.getData()) {
                return Nivel(aux.getHijoIzq(), data, nivel + 1);
            } else {
                return Nivel(aux.getHijoDer(), data, nivel + 1);
            }
        } else {
            return -1;
        }
    }
    
    /**
     *
     * @param aux
     * @param num
     * @return 
     */
    public int Altura(NodoABB aux, int num) {
        if (aux.EsHoja()) {//condicion de parada, si estoy en hoja retorno num
            return num;
        } else if (aux.getHijoIzq() != null && aux.getHijoDer() != null) {
            return (Mayor(Altura(aux.getHijoIzq(), num + 1), Altura(aux.getHijoDer(), num + 1)));
        } else if (aux.getHijoIzq() != null) {   //cuando el nodo solo tiene hijo izq
            return (Altura(aux.getHijoIzq(), num + 1));
        } else//cuando el nodo solo tiene hijo der
        {
            return (Altura(aux.getHijoDer(), num + 1));
        }
    }
    
    /**
     * 
     * @param n
     * @param  n2
     * @return 
     */
    private int Mayor(int n, int n2) {
        if (n > n2) {
            return n;
        } else {
            return n2;
        }
    }
    
    /**
     *
     * @param aux
     * @param data
     * @return 
     */
    public boolean EstaAB(NodoABB aux, int data) {
        if (aux != null) {
            if (aux.getData() == data) {
                return true;
            } else {
                return (EstaAB(aux.getHijoIzq(), data) || EstaAB(aux.getHijoDer(), data));
            }

        } else {
            return false;
        }
    }

    /**
     *
     * @param aux
     * @param n
     * @return 
     */
    public boolean Esta(NodoABB aux, NodoABB n) {
        if (aux != null) {
            if (aux.getData() == n.getData()) {
                return true;
            } else {
                return (Esta(aux.getHijoIzq(), n) || Esta(aux.getHijoDer(), n));
            }
        } else {
            return false;
        }
    }
    
    /**
     * ImprimeArbol metodo para imprimir el arbol
     * @param r
     */
    public void enOrden(NodoABB r) {
        if (r != null) {
            enOrden(r.getHijoIzq());
            r.ImprimeNodo();
            enOrden(r.getHijoDer());
        }
    }
    
    public void preOrden(NodoABB r) {
        if (r != null) {
            r.ImprimeNodo();
            preOrden(r.getHijoIzq());
            preOrden(r.getHijoDer());
        }
    }
    
    public void postOrden(NodoABB r) {
        if (r != null) {
            postOrden(r.getHijoIzq());
            postOrden(r.getHijoDer());
            r.ImprimeNodo();
        }
    }
    
    /**
     * ========================================================================
     * METODOS ADICIONALES, ALGUNOS SON EJERCICIOS DE LAS GUÍA
     * ========================================================================
     */
    
    public void Podar(NodoABB aux, int data) {
        if (aux != null) {
            if (aux.getData() == data) {
                if ((aux.getHijoIzq() != null) && (aux.getHijoDer() != null)) {
                    if (aux.getHijoIzq().EsHoja() && aux.getHijoDer().EsHoja()) {
                        aux.setHijoIzq(null);
                        aux.setHijoDer(null);
                    }
                } else if (aux.getData() % 2 == 0) {
                    if (aux.getHijoIzq() != null) {
                        if (aux.getHijoIzq().EsHoja()) {
                            aux.setHijoIzq(null);
                        }
                    }
                } else if (aux.getData() % 2 != 0) {
                    if (aux.getHijoDer() != null) {
                        if (aux.getHijoDer().EsHoja()) {
                            aux.setHijoDer(null);
                        }
                    }
                }
            } else {
                Podar(aux.getHijoIzq(), data);
            }
            Podar(aux.getHijoDer(), data);
        }
    }

    public int SumarNodos(NodoABB aux) {
        if (aux != null) {
            return (aux.getData() + SumarNodos(aux.getHijoIzq()) + SumarNodos(aux.getHijoDer()));
        } else {
            return 0;
        }
    }

    public int contar(NodoABB aux) {
        if (aux != null) {
            return (1 + contar(aux.getHijoIzq()) + contar(aux.getHijoDer()));
        } else {
            return 0;
        }
    }

    
    /**
     * ========================================================================
     * METODOS DE BORRADOS, ESTOS ALEJANDRO NO LOS EVALUA 
     * ========================================================================
     */
    
    /**
     * SuprimeIzq Metodo para borrar el hijo izquerdo del nodo p
     *
     * @param p
     * @return
     */
    public NodoABB SuprimeIzq(NodoABB p) {
        if (p.getHijoIzq() != null) {
            NodoABB aux = p.getHijoIzq();
            p.setHijoIzq(null);
            if (aux.getHijoIzq() != null && aux.getHijoDer() != null) {
                NodoABB aux2 = aux.getHijoIzq();
                p.setHijoIzq(aux.getHijoIzq());
                while (aux2.getHijoDer() != null) {
                    aux2 = aux2.getHijoDer();
                }
                aux2.setHijoDer(aux.getHijoDer());
            } else if (aux.getHijoIzq() != null) {
                p.setHijoIzq(aux.getHijoIzq());
            } else if (aux.getHijoDer() != null) {
                p.setHijoIzq(aux.getHijoDer());
            }
            return aux;
        }
        return null;

    }


    public NodoABB suprimirRaiz() {
        NodoABB aux = raiz;
        raiz = null;
        if (aux.getHijoIzq() != null && aux.getHijoDer() != null) {
            raiz = aux.getHijoDer();
            NodoABB aux2 = aux.getHijoDer();
            while (aux2.getHijoIzq() != null) {
                aux2 = aux2.getHijoIzq();
            }
            aux2.setHijoIzq(aux.getHijoIzq());
            return aux;
        } else if (aux.getHijoIzq() != null) {
            raiz = aux.getHijoIzq();
            return aux;
        } else if (aux.getHijoDer() != null) {
            raiz = aux.getHijoDer();
            return aux;
        }
        return null;
    }

    public NodoABB eliminarunnodo(NodoABB p, int data) {
        if (raiz != null && raiz.getData() == data) {
            return suprimirRaiz();
        } else if (p.getHijoIzq() != null && p.getHijoIzq().getData() == data) {
            return SuprimeIzq(p);
        } else if (p.getHijoDer() != null && p.getHijoDer().getData() == data) {
            return SuprimeDer(p);
        }
        return null;
    }

    public NodoABB SuprimeDer(NodoABB p) {
        if (p.getHijoDer() != null) {
            NodoABB aux = p.getHijoDer();
            p.setHijoDer(null);

            if (aux.getHijoIzq() != null && aux.getHijoDer() != null) {
                NodoABB aux2 = aux.getHijoDer();
                p.setHijoDer(aux.getHijoDer());
                while (aux2.getHijoIzq() != null) {
                    aux2 = aux2.getHijoIzq();
                }
                aux2.setHijoIzq(aux.getHijoIzq());
            } else if (aux.getHijoIzq() != null) {
                p.setHijoDer(aux.getHijoIzq());
            } else if (aux.getHijoDer() != null) {
                p.setHijoDer(aux.getHijoDer());
            }
            return aux;
        }
        return null;
    }
}

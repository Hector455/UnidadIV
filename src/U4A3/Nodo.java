package U4A3;

public class Nodo {

    String palabra;
    Nodo hijoIzquierdo;
    Nodo hijoDerecho;

    /**
     * Constructor que crea un nuevo nodo del arbol.
     * @param palabra palabra que se guarda en el nodo
     */
    public Nodo(String palabra) {
        this.palabra = palabra;
    }
}
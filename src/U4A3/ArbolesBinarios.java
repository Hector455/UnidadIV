package U4A3;

public class ArbolesBinarios {

    Nodo raiz;

    /**
     * Metodo que me permite agregar una palabra al arbol.
     * Si el arbol esta vacio, esta palabra se vuelve la raiz.
     * @param palabra palabra que se va a insertar
     */
    public void agregar(String palabra) {
        Nodo nuevo = new Nodo(palabra);

        if (raiz == null) {
            raiz = nuevo;
        } else {
            agregarNodo(raiz, nuevo);
        }
    }

    /**
     * Metodo que decide si el nuevo nodo va a la izquierda o derecha
     * de acuerdo al orden alfabetico.
     * @param actual nodo que se esta evaluando
     * @param nuevo nodo nuevo que se va insertar
     */
    private void agregarNodo(Nodo actual, Nodo nuevo) {

        if (nuevo.palabra.compareToIgnoreCase(actual.palabra) < 0) {

            if (actual.hijoIzquierdo == null)
                actual.hijoIzquierdo = nuevo;
            else
                agregarNodo(actual.hijoIzquierdo, nuevo);

        } else {

            if (actual.hijoDerecho == null)
                actual.hijoDerecho = nuevo;
            else
                agregarNodo(actual.hijoDerecho, nuevo);
        }
    }

    /**
     * Metodo que busca la palabra usando los tres recorridos
     * y muestra cual fue el mas rapido.
     * @param palabra palabra que se busca en el arbol
     */
    public void buscarMasRapido(String palabra) {

        if (raiz == null) {
            System.out.println("El arbol esta vacio.");
            return;
        }

        int pasosPre = buscarPreorden(raiz, palabra, 0);
        int pasosIn = buscarInorden(raiz, palabra, 0);
        int pasosPost = buscarPostorden(raiz, palabra, 0);

        if (pasosPre == -1 && pasosIn == -1 && pasosPost == -1) {
            System.out.println("La palabra no esta en el arbol.");
            return;
        }

        System.out.println("\nPasos:");
        System.out.println("Preorden = " + pasosPre);
        System.out.println("Inorden  = " + pasosIn);
        System.out.println("Postorden= " + pasosPost);

        int menor = menorValor(pasosPre, pasosIn, pasosPost);

        System.out.print("\nEl recorrido mas rapido fue: ");
        if (menor == pasosPre) System.out.println("PREORDEN");
        else if (menor == pasosIn) System.out.println("INORDEN");
        else System.out.println("POSTORDEN");
    }

    /**
     * Metodo que imprime el recorrido Preorden del arbol.
     */
    public void mostrarPreorden() {
        preorden(raiz);
    }

    private void preorden(Nodo n) {
        if (n != null) {
            System.out.println("Palabra: " + n.palabra);
            preorden(n.hijoIzquierdo);
            preorden(n.hijoDerecho);
        }
    }

    /**
     * Metodo que imprime el recorrido Inorden del arbol.
     */
    public void mostrarInorden() {
        inorden(raiz);
    }

    private void inorden(Nodo n) {
        if (n != null) {
            inorden(n.hijoIzquierdo);
            System.out.println("Palabra: " + n.palabra);
            inorden(n.hijoDerecho);
        }
    }

    /**
     * Metodo que imprime el recorrido Postorden del arbol.
     */
    public void mostrarPostorden() {
        postorden(raiz);
    }

    private void postorden(Nodo n) {
        if (n != null) {
            postorden(n.hijoIzquierdo);
            postorden(n.hijoDerecho);
            System.out.println("Palabra: " + n.palabra);
        }
    }

    /**
     * Metodo de busqueda con recorrido Preorden.
     * @param n nodo actual
     * @param palabra palabra a buscar
     * @param pasos contador de pasos
     * @return numero de pasos o -1 si no se encuentra
     */
    private int buscarPreorden(Nodo n, String palabra, int pasos) {
        if (n == null) return -1;

        pasos++;

        if (n.palabra.equalsIgnoreCase(palabra)) return pasos;

        int iz = buscarPreorden(n.hijoIzquierdo, palabra, pasos);
        if (iz != -1) return iz;

        return buscarPreorden(n.hijoDerecho, palabra, pasos);
    }

    /**
     * Metodo de busqueda con recorrido Inorden.
     * @param n nodo actual
     * @param palabra palabra a buscar
     * @param pasos contador de pasos
     * @return numero de pasos o -1 si no se encuentra
     */
    private int buscarInorden(Nodo n, String palabra, int pasos) {
        if (n == null) return -1;

        int iz = buscarInorden(n.hijoIzquierdo, palabra, pasos);
        if (iz != -1) return iz;

        pasos++;

        if (n.palabra.equalsIgnoreCase(palabra)) return pasos;

        return buscarInorden(n.hijoDerecho, palabra, pasos);
    }

    /**
     * Metodo de busqueda usando recorrido Postorden.
     * @param n nodo actual
     * @param palabra palabra que se busca
     * @param pasos contador de pasos
     * @return numero de pasos o -1 si no se encuentra
     */
    private int buscarPostorden(Nodo n, String palabra, int pasos) {
        if (n == null) return -1;

        int iz = buscarPostorden(n.hijoIzquierdo, palabra, pasos);
        if (iz != -1) return iz;

        int der = buscarPostorden(n.hijoDerecho, palabra, pasos);
        if (der != -1) return der;

        pasos++;

        if (n.palabra.equalsIgnoreCase(palabra)) return pasos;

        return -1;
    }

    /**
     * Metodo que encuentra el numero menor de pasos entre 3 valores.
     * @param a pasos en Preorden
     * @param b pasos en Inorden
     * @param c pasos en Postorden
     * @return el menor valor diferente de -1
     */
    private int menorValor(int a, int b, int c) {
        int min = Integer.MAX_VALUE;
        if (a != -1 && a < min) min = a;
        if (b != -1 && b < min) min = b;
        if (c != -1 && c < min) min = c;
        return min;
    }
}
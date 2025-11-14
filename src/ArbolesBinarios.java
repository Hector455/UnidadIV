/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *Clase que me permite trabajar con las operaciones de arboles
 * @author LENOVO
 */
public class ArbolesBinarios {
    /**
     * metodo que me permite agregar un nuevo nodo a la estructura d eun arbol
     * @param raiz nodo a evaluar 
     * @param nuevo nuevo nodo
     */
    public static void AgregarNuevoNodo(Nodo raiz, Nodo nuevo){
        if (raiz.numero<nuevo.numero){
            // me voy a la derecha
           if(raiz.hijoDerecho==null){ 
            raiz.hijoDerecho= nuevo;
          }else {
               AgregarNuevoNodo(raiz.hijoDerecho,nuevo);
                       
           }   
        }
        else {
            // me voy a la izquierda
            if (raiz.hijoIzquierdo==null){
            raiz.hijoIzquierdo=nuevo; // esta libre 
          } else {
                AgregarNuevoNodo(raiz.hijoIzquierdo,nuevo);
            }
        }
    }
    
    public static void main(String[] args) {
        
    }
    
}

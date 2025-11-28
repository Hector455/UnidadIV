
import java.util.Scanner;

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
    /**
     * realiza recorrido en preorden
     * @param inicia donde inicia la raiz
     */
    public static void preorden(Nodo inicia){
        if (inicia!=null){
            System.out.println("Valor "+inicia.numero);
            preorden(inicia.hijoIzquierdo);
            preorden(inicia.hijoDerecho);
        }
    }
      public static void inorden(Nodo inicia){
        if (inicia!=null){
            
            preorden(inicia.hijoIzquierdo);
            System.out.println("Valor "+inicia.numero);
            preorden(inicia.hijoDerecho);
        }
      }
      public static void porstorden(Nodo inicia){
        if (inicia!=null){
            
            preorden(inicia.hijoIzquierdo);
         
            preorden(inicia.hijoDerecho);
             System.out.println("Valor "+inicia.numero);
        }
      }
     
    public static void main(String[] args) {
        Scanner leer =new Scanner(System.in);
        int op=0;
        System.out.println("Programa de arbol");
        Nodo raiz=null;
        while(op!=5){
            System.out.println("1) agregrar");
            System.out.println("2) Preorden");
            System.out.println("3) Inorden");
            System.out.println("4) Postorden");
            System.out.println("5) salir");
            op=Integer.parseInt(leer.nextLine());
            switch(op){
                case 1:
                    System.out.println("Dame un valor");
                    int valor = Integer.parseInt(leer.nextLine());
                    Nodo nuevo=new Nodo();
                    nuevo.numero=valor;
                    if (raiz==null)// valido que sea el primer numero
                        raiz=nuevo;
                    else AgregarNuevoNodo(raiz,nuevo);
                    break;
                case 2:
                    System.out.println("preorden ");
                    preorden(raiz);
                    break;
                case 3:
                    System.out.println("inorden");
                    inorden(raiz);
                    break;
                case 4:
                    System.out.println("postorden");
                    porstorden(raiz);
            }
        }
    }
    
}

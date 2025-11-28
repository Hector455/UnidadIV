package U4A3;

import java.util.Scanner;

public class AplicacionesConArboles {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        int op = 0;

        ArbolesBinarios arbol = new ArbolesBinarios();

        while (op != 6) {

            System.out.println(" MENU DE ARBOLES ");
            System.out.println("1) Agregar palabra al arbol");
            System.out.println("2) Buscar palabra y ver el recorrido mas rapido");
            System.out.println("3) Mostrar recorrido Preorden");
            System.out.println("4) Mostrar recorrido Inorden");
            System.out.println("5) Mostrar recorrido Postorden");
            System.out.println("6) Salir");
            System.out.print("Elige una opcion: ");

            op = Integer.parseInt(leer.nextLine());

            switch (op) {

                case 1:
                    System.out.print("Ingresa una palabra: ");
                    String palabra = leer.nextLine();
                    arbol.agregar(palabra);
                    System.out.println("Palabra agregada correctamente.");
                    break;

                case 2:
                    System.out.print("Ingresa la palabra a buscar: ");
                    String buscar = leer.nextLine();
                    arbol.buscarMasRapido(buscar);
                    break;

                case 3:
                    System.out.println("\n--- PREORDEN ---");
                    arbol.mostrarPreorden();
                    break;

                case 4:
                    System.out.println("\n--- INORDEN ---");
                    arbol.mostrarInorden();
                    break;

                case 5:
                    System.out.println("\n--- POSTORDEN ---");
                    arbol.mostrarPostorden();
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }
}
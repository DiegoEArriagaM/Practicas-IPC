/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg1.lab.ipc1;



import java.util.Scanner;

/**
 *
 * @author Diego
 */
public class Practica1LabIPC1 {

    /**
     * @param args the command line arguments
     */
    static encriptador opcion1=new encriptador();
    static desencriptador opcion2=new desencriptador();
    static Ataque_Texto opcion3= new Ataque_Texto();
    static reportes opcion4=new reportes();
    static Scanner sc=new Scanner(System.in);
    static String op;
    
    //Colores de texto
       static String verde="\033[32m";
       static String cyan="\033[36m"; 
       static String negro="\033[30m";
       static String rojo="\033[31m";
       static String amar="\033[33m";
        //----------------------
    public static void main(String[] args) {
        int cont=1;
        while(cont>0){
            System.out.println("=================MENU====================");
            System.out.println("|"+verde+" 1."+negro+" Encriptar                           |");
            System.out.println("|"+verde+" 2."+negro+" Desencriptar                        |");
            System.out.println("|"+verde+" 3."+cyan+" Ataque"+negro+" con texto plano              |");
            System.out.println("|"+verde+" 4."+cyan+" Generar"+negro+" Reportes                    |");
            System.out.println("|"+verde+" 5."+rojo+" Finalizar"+negro+" Proyecto                  |");
            System.out.println("=========================================");
            System.out.print("Ingrese el número de acción que quiere realizar: ");
            op=sc.nextLine();System.out.println();
            
            switch(op){
                    case "1":
                        opcion1.menu();
                        break;
                    case "2":
                        opcion2.menu();
                        break;
                    case "3":
                        opcion3.menu();
                        break;
                    case "4":
                        opcion4.menu();
                        break;
                    case "5":
                        cont--;
                        break;
                    default:
                        System.out.println(rojo+"ERROR. Ingrese un numero de opción adecuado."+negro);
                        break;
            }
        }
    }
}

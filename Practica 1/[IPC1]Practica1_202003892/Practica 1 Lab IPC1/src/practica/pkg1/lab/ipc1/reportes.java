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

public class reportes {
static reporte_encriptacion RC=new reporte_encriptacion();
static reporte_desencriptado DRC=new reporte_desencriptado();
static reporte_Ataque AC=new reporte_Ataque();

 //Colores de texto
       static String verde="\033[32m";
       static String cyan="\033[36m"; 
       static String negro="\033[30m";
       static String rojo="\033[31m";
       static String amar="\033[33m";
//-----------------------------
       static Scanner sc=new Scanner(System.in);
       static String op;
       
    public static void menu(){
        int cont=1;
        while(cont>0){
            System.out.println("================"+verde+"Menu "+cyan+"Reporte"+negro+"===============");
            System.out.println("|"+amar+" 1."+verde+" Reporte "+negro+"del Encriptado               |");
            System.out.println("|"+amar+" 2."+verde+" Reporte "+negro+"del Desencriptado            |");
            System.out.println("|"+amar+" 3."+verde+" Reporte "+negro+"Ataque con texto claro       |");
            System.out.println("|"+amar+" 4."+cyan+" Regreso"+negro+" al Menú Principal            |");
            System.out.println("===========================================");
            System.out.print("Ingrese el número de acción que quiere realizar: ");
            op=sc.nextLine();System.out.println();
            
            switch(op){
                case "1":
                    RC.reporte();
                    break;
                case "2":
                    DRC.reporte();
                    break;
                case "3":
                    AC.reporte();
                    break;
                case "4":
                    cont--;
                    break;
                default:
                        System.out.println(rojo+"ERROR. Asegurese que el dígito ingresado sea 1, 2, 3 o 4"+negro);
                        break;
            }
        }
    }
}

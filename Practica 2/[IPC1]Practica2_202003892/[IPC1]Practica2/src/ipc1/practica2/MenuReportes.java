/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipc1.practica2;

import java.util.Scanner;

/**
 *
 * @author Diego
 */
public class MenuReportes {
    static    ReporteEntrenadores opcion10_1=new ReporteEntrenadores();
    static    ReporteSalvajes opcion10_2=new ReporteSalvajes();
    static    ReporteComidas opcion10_3=new ReporteComidas();
    static    ReportesPeleas opcion10_4=new ReportesPeleas();
    static    TopAtaque opcion10_5=new TopAtaque();
    static    TopSalud opcion10_6=new TopSalud();
    //Se crean variables que se encargaran de reconocer la información que ingrese el usuario
    static    Scanner sc=new Scanner(System.in);
    static    String op;
    /**Se genera el menú con las opciones de reportes*/
        public static void menuReportes(){
        //Inicio del ciclo del menú principal.
        int cont=1;
        while (cont>0){
            //Se imprime el menú
            System.out.print("========Menu de Reportes=========\n"
                        + "|1.Reporte de entrenadores\t|\n"
                        + "|2.Reporte de pokemons salvajes\t|\n"
                        + "|3.Reporte de Comidas\t\t|\n"
                        + "|4.Reporte de Peleas\t\t|\n"
                        + "|5.Top 5 de Puntos de Ataque\t|\n"
                        + "|6.Top 5 de Salud\t\t|\n"
                        + "|7.Salir al menu principal\t|\n"
                        + "=================================\n");
            //Instrucción al usuario
            System.out.print("Ingrese el numero de opción que quiere realizar: ");
            op=sc.nextLine();
            //Se deja un espacio considerable entre el menú y la acción seleccionada.
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            //Se manda a llamar el metodo seleccionado por el usuario
            switch(op){
                case "1":
                    opcion10_1.reporte();
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    break;
                case "2":
                    opcion10_2.reportes();
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    break;
                case "3":
                    opcion10_3.reporte();
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    break;
                case "4":
                    opcion10_4.reportes();
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    break;
                case "5":
                    opcion10_5.reporte();
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    break;
                case "6":
                    opcion10_6.reporte();
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    break;
                case "7":
                    //Se termina el ciclo que genera el menu.
                    cont--;
                    break;
                default:
                    System.err.println("Ingrese un número apropiado");
                    break;
            }
        }
    }
}

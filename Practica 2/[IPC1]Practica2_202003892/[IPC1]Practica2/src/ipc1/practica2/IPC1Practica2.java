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
public class IPC1Practica2 {

    /**
     * @param args the command line arguments
     */   
     
    /**Metodo del menú principal*/
    public static void main(String[] args) {
    //Se mandan a llamar todos los metodos que realizan todas las actividades del porgrama.
        Guardar guardar=new Guardar();
        CargarArchivos carga=new CargarArchivos();
        CargaPokemon opcion1=new CargaPokemon();
        CargaEntrenador opcion2=new CargaEntrenador();
        CargaPokeballs opcion3=new CargaPokeballs();
        CargaGimnasios opcion4=new CargaGimnasios();
        CargaAlimentos opcion5=new CargaAlimentos();
        AsignarPokemons opcion6=new AsignarPokemons();
        AsignarPokeball opcion7=new  AsignarPokeball();
        AsignarAlimentos opcion8=new AsignarAlimentos();
        AsignarPelea opcion9=new AsignarPelea();
        MenuReportes opcion10=new MenuReportes();
    //Se crean variables que se encargaran de reconocer la información que ingrese el usuario
        Scanner sc=new Scanner(System.in);
        String op;
        //Opcion de Cargar archivos previos
        System.out.print("Desea Cargar archivos anteriores?(S/N):");
        //Elección del usuario
            op=sc.nextLine();
            if (op.equalsIgnoreCase("S")) {
                carga.carga();
            }
        
        //Inicio del ciclo del menú principal.
        int cont=1;
        while (cont>0){
            //Se imprime el menú
            System.out.print("=========Menu de Inicio==========\n"
                        + "|1.Carga de Pokemons\t\t|\n"
                        + "|2.Carga de Entrenadores\t|\n"
                        + "|3.Carga de Poke balls\t\t|\n"
                        + "|4.Carga de Gimnasios\t\t|\n"
                        + "|5.Carga de Alimentos\t\t|\n"
                        + "|6.Asignar Pokemons\t\t|\n"
                        + "|7.Asignar Pokeballs\t\t|\n"
                        + "|8.Asignar Actividad de Comida\t|\n"
                        + "|9.Asignar Actividad de Pelea\t|\n"
                        + "|10.Reportes\t\t\t|\n"
                        + "|11.Guardar Archivos\t\t|\n"
                        + "|12.Salir del Programa\t\t|\n"
                        + "=================================\n");
            //Instrucción al usuario
            System.out.print("Ingrese el numero de opción que quiere realizar: ");
            op=sc.nextLine();
            //Se deja un espacio considerable entre el menú y la acción seleccionada.
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            //Se manda a llamar el metodo seleccionado por el usuario
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
                    opcion5.menu();
                    break;
                case "6":
                    opcion6.menu();
                    break;
                case "7":
                    opcion7.menu();
                    break;
                case "8":
                    opcion8.menu();
                    break;
                case "9":
                    opcion9.menu();
                    break;
                case "10":
                    opcion10.menuReportes();
                    break;
                case "11":
                    guardar.guardar();
                    break;
                case "12":
                    //Se termina el ciclo que genera el menu.
                    cont--;
                    break;
                    //Mensaje en caso de que el usuario no haya ingresado un valor adecuado.
                default:
                    System.err.println("Asegurese que ingreso un número valido");
                    break;
            }
        }
        
         
    }
}

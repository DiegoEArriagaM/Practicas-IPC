/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipc1.practica2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Diego
 */ 
public class CargaPokemon implements Serializable{
    //Se crean los arreglos que almacenaran los datos de la tabla.
    static int Id[]=new int[150],ingresados=0;
    static double Vida[]=new double[150], ptAt[]=new double[150];
    //Las variables que no son arreglos se encargan de almacenar lo que escribe el usuario.
    static String Titulo[]=new String[7],Tipo[]=new String[150], Nombre[]=new String[150],op,ruta;
    static boolean Capturado[]=new boolean[151], Estado[]=new boolean[151];
    //Variable para leer lo que escribe el usuario.
    static Scanner sc=new Scanner(System.in);
    
    static void menu(){
        try {
            //Inicio del ciclo del menú principal.
            int cont=1;
            while (cont>0){
                //Se imprime el menú
                System.out.println("=================================\n"
                        + "|1.Carga Listado de Pokemons\t|\n"
                        + "|2.Salir al Menu Principal\t|\n"
                        + "=================================");
                //Instrucción al usuario
                System.out.print("Ingrese el numero de opción que quiere realizar: ");
                /**Se almacena lo que escriba el usuario*/
                op=sc.nextLine();
                System.out.println();
                
                switch(op){
                    case"1":
                        //Instrucción al usuario
                        System.out.print("Ingrese la ruta del archivo que poseea la lista de Pokemons: ");
                        System.out.println("Ejemplo: C:\\Users\\Diego\\Desktop\\ListadoPokemons.csv");
                        //Se almacena la ruta que ingreso el usuario.
                        ruta=sc.nextLine();
                        //Se deja un espacio considerable entre el menú y la acción seleccionada.
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        //Se manda a llamar el metodo seleccionado por el usuario
                        carga(ruta);
                        break;
                    case"2":
                        //Se termina el ciclo que genera el menu.
                        cont--;
                        break;    
                    default:
                    //Mensaje en caso de que el usuario no haya ingresado un valor adecuado.
                        System.err.println("Asegurese de ingresar un numero valido");
                }
            }
        } catch (Exception e) {
            //Mensaje en caso de que el usuario no haya ingresado un valor adecuado.
            System.err.println("Error al cargar el archivo. Asegurese a que ingreso la\n"
                            + "ruta correcta o que el documento no tenga mas de 150\n"
                            + "entrenadores.");
        }
    }
    /**Metodo que se encarga de almacenar la información que ingreso el usuario en los 
       arreglos creados anteriormente*/
    static void carga(String r){
        /**Se reinician los arreglos, para que se pudieran llenar de nuevo*/
        Id=new int[150];Vida=new double[150];ptAt=new double[150];
        Titulo=new String[7];Tipo=new String[150]; Nombre=new String[150];
        Capturado=new boolean[151];Estado=new boolean[151];
        /**Se reinicia la variable que indica la cantidad de pokemons que ingreso el
         usuario*/
        ingresados=0;
        
        try {
            /**Se guarda el archivo que indico el usario y se le prepara para que
             pueda leerse*/
            File archivo=new File(r);
            FileReader archivoG=new FileReader(archivo);
            BufferedReader lectura=new BufferedReader(archivoG);
            /**Se lee la primera linea del documento*/
            String codigo=lectura.readLine(),
                    /**Se crea un arreglo que divira los apartados en cada linea.*/
                    divisor[]=new String[7];
            /**Se almacenan los titulos de cada columna*/
            Titulo=codigo.split("\\s*,\\s*");
            
            /**Se comienza un ciclo que se repetira hasta que el documento se 
             encuentre completamente vacío*/
            int a=0;
            while ((codigo=lectura.readLine())!=null) {
                /**Se divira la línea en diferentes apartados*/
                divisor=codigo.split("\\s*,\\s*");
                /**Se asigna el valor del arreglo divisor en el arreglo respectivo
                 cambiando el tipo de variable cuando sea necesario*/
                Id[a]=Integer.parseInt(divisor[0]);
                Tipo[a]=divisor[1];
                Nombre[a]=divisor[2];
                Vida[a]=Double.parseDouble(divisor[3]);
                ptAt[a]=Double.parseDouble(divisor[4]);
                /**En caso de los arreglos tipo Booleano se determina si almacena
                 un valor true o false*/
                if(divisor[5].equalsIgnoreCase("Capturado")) {
                    Capturado[a]=true; 
                }else{Capturado[a]=false;}
                
                if(divisor[6].equalsIgnoreCase("Vivo")) {
                    Estado[a]=true;
                }else{Estado[a]=false;}
                /**Se aumenta el contador para determinar la posición del siguiente
                 pokemon del listado*/
                a++;
                /**Se aumenta en 1 el contador de la cantidad de pokemons ingresados*/
                ingresados++;
            }   
            /**Se cierra la lectura del documento*/
            lectura.close();   
            /**Se cierra el documento*/
            archivoG.close();
            //Se imprime lo que almaceno el programa
            System.out.println(Titulo[0]+"\t"+Titulo[1]+"\t\t"+Titulo[2]+"\t\t"+Titulo[3]
                    +"\t\t"+Titulo[4]+"\t\t"+Titulo[5]+"\t\t"+Titulo[6]);
            int e=0;
            while(e<ingresados){
                String capturado,estado;
                if (Capturado[e]==true) {
                    capturado="Capturado";
                }else{capturado="Salvaje";}
                if (Estado[e]==true) {
                    estado="Vivo";
                }else{estado="Muerto";}
                System.out.println(Id[e]+"\t"+Tipo[e]+"\t\t"+Nombre[e]+"\t\t"+Vida[e]
                +"\t\t"+ptAt[e]+"\t\t"+capturado+"\t\t"+estado);
                e++;
            }
        } catch (Exception e) {
            System.err.println("Error al cargar el archivo. Asegurese a que ingreso la\n"
                            + "ruta correcta o que el documento no tenga mas de 150\n"
                            + "Pokemons.");
        }
    }
}

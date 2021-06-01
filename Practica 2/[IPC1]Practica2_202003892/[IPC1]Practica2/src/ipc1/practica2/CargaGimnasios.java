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
public class CargaGimnasios implements Serializable{
    //Se crean los arreglos que almacenaran los datos de la tabla.
    static int Id[]=new int[25],ingresados=0;
    //Las variables que no son arreglos se encargan de almacenar lo que escribe el usuario.
    static String Titulo[]=new String[2],Lugar[]=new String[25],op,ruta;
    //Variable para leer lo que escribe el usuario.
    static Scanner sc=new Scanner(System.in);
    
    static void menu(){
        try {
            //Inicio del ciclo del menú principal.
            int cont=1;
            while (cont>0){
                //Se imprime el menú
                System.out.println("=================================\n"
                        + "|1.Carga Listado de Gimnasios\t|\n"
                        + "|2.Salir al Menu Principal\t|\n"
                        + "=================================");
                //Instrucción al usuario
                System.out.print("Ingrese el numero de opción que quiere realizar: ");
                op=sc.nextLine();
                System.out.println();
                
                switch(op){
                    case"1":
                        //Instrucción al usuario
                        System.out.print("Ingrese la ruta del archivo que poseea la lista de Gimnasios: ");
                        System.out.println("Ejemplo: C:\\Users\\Diego\\Desktop\\ListadoGimnasios.csv");
                        //Se almacena la ruta que ingreso el usuario.
                        ruta=sc.nextLine();
                        System.out.println();
                        /**Se reinicia la variable que indica la cantidad de pokemons que ingreso el
                         usuario*/
                        ingresados=0;
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        //Se manda a llamar el metodo seleccionado por el usuario
                        carga(ruta);
                        break;
                    case"2":
                        //Se termina el ciclo que genera el menu.
                        cont--;
                        break;    
                    default:
                        System.err.println("Asegurese de ingresar un numero valido");
                }
            }
        } catch (Exception e) {
            System.err.println("Asegurese de ingresar un numero valido");
        }
    }
    
    static  void carga(String r){
         /**Se reinicia los arreglos que almacenaran la información de la tabla*/
         Id=new int[25];Titulo=new String[2];Lugar=new String[25];
         
        try {
            /**Se guarda el archivo que indico el usario y se le prepara para que
             pueda leerse*/
            File archivo=new File(r);
            FileReader archivoG=new FileReader(archivo);
            BufferedReader lectura=new BufferedReader(archivoG);
            /**Se lee la primera linea del documento*/
            String codigo=lectura.readLine(),
                    /**Se crea un arreglo que divira los apartados en cada linea.*/
                   divisor[]=new String[2];
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
                Lugar[a]=divisor[1];
                /**Se aumenta el contador para determinar la posición del siguiente
                 pokemon del listado*/
                a++;
                /**Se aumenta en 1 el contador de la cantidad de pokemons ingresados*/
                ingresados++;
            }   
            /**Se cierra la lectura del documento*/
            lectura.close();   
            /**Se cierra la lectura del documento*/
            archivoG.close();
            //Se imprime lo que almaceno el programa
            System.out.println(Titulo[0]+"\t"+Titulo[1]);
            int e=0;
            while(e<ingresados){
                System.out.println(Id[e]+"\t"+Lugar[e]);
                e++;
            }
        } catch (Exception e) {
            System.err.println("Error al cargar el archivo. Asegurese a que ingreso la\n"
                            + "ruta correcta o que el documento no tenga mas de 25\n"
                            + "gimnasios.");
        }
    }
    
}

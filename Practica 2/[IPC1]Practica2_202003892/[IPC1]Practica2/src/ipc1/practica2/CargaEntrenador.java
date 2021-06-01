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
public class CargaEntrenador implements Serializable{
    //Se crean los arreglos que almacenaran los datos de la tabla.
    static int Id[]=new int[25],ingresados=0;
    //Las variables que no son arreglos se encargan de almacenar lo que escribe el usuario.
    static String Titulo[]=new String[2],Nombre[]=new String[25],op,ruta;
    //Variable para leer lo que escribe el usuario.
    static Scanner sc=new Scanner(System.in);
    
    static void menu(){
        try {
            //Inicio del ciclo del menú principal.
            int cont=1;
            while (cont>0){
                System.out.println("=================================\n"
                        + "|1.Carga Listado de Entrenadores|\n"
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
                        System.out.print("Ingrese la ruta del archivo que poseea la lista de Entrenadores: ");
                        System.out.println("Ejemplo: C:\\Users\\Diego\\Desktop\\ListadoEntrenadores.csv");
                        //Se almacena la ruta que ingreso el usuario.
                        ruta=sc.nextLine();
                        System.out.println();
                        ingresados=0;
                        //Se deja un espacio considerable entre el menú y la acción seleccionada.
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        carga(ruta);
                        break;
                    case"2":
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
    
    /**Metodo que se encarga de almacenar la información que ingreso el usuario en los 
       arreglos creados anteriormente*/
    static void carga(String r){
        /**Se reinician los arreglos, para que se pudieran llenar de nuevo*/
        Id=new int[25];Titulo=new String[2];Nombre=new String[25];
        
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
            
            /**Se asigna el valor del arreglo divisor en el arreglo respectivo
                 cambiando el tipo de variable cuando sea necesario*/
            int a=0;
            while ((codigo=lectura.readLine())!=null) {
                divisor=codigo.split("\\s*,\\s*");
                Id[a]=Integer.parseInt(divisor[0]);
                Nombre[a]=divisor[1];
                a++;
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
                System.out.println(Id[e]+"\t"+Nombre[e]);
                e++;
            }
        } catch (Exception e) {
            System.err.println("Error al cargar el archivo. Asegurese a que ingreso la\n"
                            + "ruta correcta o que el documento no tenga mas de 25\n"
                            + "entrenadores.");
        }
    }
}

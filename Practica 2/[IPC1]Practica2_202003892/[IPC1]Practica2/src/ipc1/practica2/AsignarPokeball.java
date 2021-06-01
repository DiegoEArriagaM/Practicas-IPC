/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipc1.practica2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 *
 * @author Diego
 */
public class AsignarPokeball {
    //Se mandan a llamar las clases necesarias para unir los datos.
    static CargaEntrenador entrenador=new CargaEntrenador();
    static CargaPokeballs pokeball=new CargaPokeballs();
    /**Se crean los arreglos que almacenaran los datos de la tabla, tambien se crearon arreglos
     auxiliares para contar la cantidad de pokebolas de cada entrenador*/
    static int IdEnt[]=new int[25],AUXIdEnt[]=new int[25],ContBall[]=new int[150],IdBall[]=new int[150],
            ingresados=0,ingresados2=0;
    //Las variables que no son arreglos se encargan de almacenar lo que escribe el usuario.
    static String Titulo[]=new String[2],op,ruta;
    // para leer lo que escribe el usuario.
    static Scanner sc=new Scanner(System.in);
    
    static void menu(){
        try {
            //Inicio del ciclo del menú principal.
            int cont=1;
            while (cont>0){
                System.out.println("=========================================\n"
                        + "|1.Asignar Pokeballs a Entrenadores\t|\n"
                        + "|2.Salir al Menu Principal\t\t|\n"
                        + "=========================================");
                //Instrucción al usuario
                System.out.print("Ingrese el numero de opción que quiere realizar: ");
                /**Se almacena lo que escriba el usuario*/
                op=sc.nextLine();
                System.out.println();
                
                switch(op){
                    case"1":
                        //Instrucción al usuario
                        System.out.print("Ingrese la ruta del archivo que poseea cómo se asignaran los pokemons: ");
                        System.out.println("Ejemplo: C:\\Users\\Diego\\Desktop\\AsignarPokeballs.csv");
                        //Se almacena la ruta que ingreso el usuario.
                        ruta=sc.nextLine();
                        System.out.println();
                        /**Se reinicia la variable que indica la cantidad de pokemons que ingreso el
                         usuario*/
                        ingresados=0;
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        //Se manda a llamar el metodo seleccionado por el usuario
                        asignar(ruta);
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
            System.err.println("Asegurese de ingresar un número valido.");
        }
    }
    
    /**Metodo que se encarga de relacionar la información almacena de los pokemons
     con la información de las pokeballs*/
    static void asignar(String r){
        try {
            /**Se reinician los arreglos, para que se pudieran llenar de nuevo*/
            IdEnt=new int[25];ContBall=new int[150];AUXIdEnt=new int[25];ContBall=new int[150];
            IdBall=new int[150];
            /**Se reinicia la variable que indica la cantidad de pokemons que ingreso el
            usuario*/
            ingresados=0;ingresados2=0;
            
            
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
                
                int d=Integer.parseInt(divisor[0]);
                int b=0;
                /**Se esteblece si el entrenador que se posee actualmente ya se había
                 analizado anteriormente*/
                while(b<25){
                    if (d==IdEnt[b]) {
                        break;
                    }
                    b++;
                }
                /**Si el entrenador es nuevo se guardara en el arreglo*/
                if(b==25){
                    IdEnt[ingresados]=d;
                    b=ingresados;
                    /**Se desplaza la casilla en que se debe agregar al nuevo entrenador 
                     *que se encuentre*/
                    ingresados++;
                }
                /**Se aumenta el contador de pokeballs del entranor actual*/
                ContBall[b]++;
                
                if(ContBall[b]>5){
                    System.err.println("En el archivo que subio uno o mas entrenadores tiene mas de"
                            + " 5 pokeballs asignadas");
                    break;
                }
                /**Se asigna el valor del arreglo divisor en el arreglo respectivo
                 cambiando el tipo de variable cuando sea necesario*/
                AUXIdEnt[a]=Integer.parseInt(divisor[0]);
                IdBall[a]=Integer.parseInt(divisor[1]);
                
                /**Se aumenta el contador para determinar la posición del siguiente
                 pokemon del listado*/
                ingresados2++;
                a++;
            }
            
        } catch (Exception e) {
            System.err.println("Error asegurese de ingresar una ruta correcta.");
        }
    }
    
}

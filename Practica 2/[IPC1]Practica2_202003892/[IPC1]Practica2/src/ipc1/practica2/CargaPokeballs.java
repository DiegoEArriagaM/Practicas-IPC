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
public class CargaPokeballs implements Serializable{
    //Se crean los arreglos que almacenaran los datos de la tabla.
    static int Id[]=new int[150],ContadorTipos=0,ingresados=0;
    //Las variables que no son arreglos se encargan de almacenar lo que escribe el usuario.
    static String Titulo[]=new String[2],CTipo[]=new String[4],Tipo[]=new String[150],op,ruta;
    //Variable para leer lo que escribe el usuario.
    static Scanner sc=new Scanner(System.in);
    
    static void menu(){
        try {
            //Inicio del ciclo del menú principal.
            int cont=1;
            while (cont>0){
                //Se imprime el menú
                System.out.println("=================================\n"
                        + "|1.Carga Listado de Poke Balls\t|\n"
                        + "|2.Salir al Menu Principal\t|\n"
                        + "=================================");
                //Instrucción al usuario
                System.out.print("Ingrese el numero de opción que quiere realizar: ");
                /**Se almacena la información que escribe el usuario*/
                op=sc.nextLine();
                System.out.println();
                
                switch(op){
                    case"1":
                        //Instrucción al usuario
                        System.out.print("Ingrese la ruta del archivo que poseea la lista de Entrenadores: ");
                        System.out.println("Ejemplo: C:\\Users\\Diego\\Desktop\\ListadoPokeballs.csv");
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
    
    static void carga(String r){
        /**Se reinicia los arreglos que almacenaran la información de la tabla y el contador
         de la cantidad de tipos de pokeballs permitada (CTIPO)*/
        Id=new int[150];Titulo=new String[2];CTipo=new String[4];Tipo=new String[150];
        
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
            
            /**Se inician los contadores que se utilizaran posteriormente.*/
            int a=0,d=0,c=0;
            /**Se comienza un ciclo que se repetira hasta que el documento se 
             encuentre completamente vacío*/
            while ((codigo=lectura.readLine())!=null) {
                /**Se divira la línea en diferentes apartados*/
                divisor=codigo.split("\\s*,\\s*");
                Id[a]=Integer.parseInt(divisor[0]);
                
                /**Sub logaritmo, que se encarga de aumentar el contador de tipos de
                 Pokeballs que tiene el documento, hasta que este alcance el limite
                 de 4*/
               int i=0,b=0;d=0;
               
               /**Si ya se llenaron todos los espacios del contador se analizara que
                 la lista no contenga mas de 4 tipos diferentes*/
                while (i<4 && c>3) {   
                    /**Se analiza 1 por 1 los espacios aumentando en 1 el contador b
                     siempre que no coincida con algun valor del arreglo. Si los valores
                     coiciden se dejara de analizar*/
                   if (divisor[1].equalsIgnoreCase(CTipo[i])) {
                       break;
                    }else{
                       b++;}
                   i++;
                }
               
                while(i<4){
                    /**Primero se analizan los cuatro espacios disponible, en caso de que
                     conicida con uno se dejara de buscara.*/
                    if (divisor[1].equalsIgnoreCase(CTipo[i])) {
                        break;
                    }else{d++;}
                    /**Si ya se revisaron los 4 espacios y no coincidio con ninguno y si
                     todavía hay espacios disponibles se llenara un casia con el nuevo
                     tipo.*/
                    if (c<4 && d>3) {
                        CTipo[c]=divisor[1];
                        c++;
                        break;
                    }
                    i++;
                }
                
                
                /**Si se analizaron los cuatro espacios y no coincidio con ninguno se detendra
                 el ingreso de la lista, porque significa que hay mas de cuatro tipos de pokeball*/
                if (b>=4) {
                    System.err.println("ERROR. En el archivo existen mas de cuatro tipos de PokeBalls");
                    break;
                }else{
                    /**En caso de que aun hayan espacios vacíos o sea un tipo ya existente se agregara
                     el tipo de pokeball en el arreglo.*/
                    Tipo[a]=divisor[1];
                }
                /**Se aumenta la posición en los arreglos*/
                a++;
                /**Se aumenta en 1 el contador de la cantidad de pokeballs ingresadas*/
                ingresados++;
            }   
            /**Se cierra la lectura del documento*/
            lectura.close();
            /**Se cierra el archivo*/
            archivoG.close();
            //Se imprime lo que almaceno el programa
            System.out.println(Titulo[0]+"\t"+Titulo[1]);
            int e=0;
            while(e<ingresados){
                System.out.println(Id[e]+"\t"+Tipo[e]);
                e++;
            }
        } catch (Exception e) {
            System.err.println("Error al cargar el archivo. Asegurese a que ingreso la\n"
                            + "ruta correcta o que el documento no tenga mas de 4\n"
                            + "tipo de pokeballs.");
        }
    }
}

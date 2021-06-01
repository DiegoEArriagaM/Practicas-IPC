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
public class AsignarPokemons {
    //Se mandan a llamar las clases necesarias para unir los datos.
    static CargaPokeballs pokeball=new CargaPokeballs();
    static CargaPokemon pokemon=new CargaPokemon();
    //Se crean los arreglos que almacenaran los datos de la tabla.
    static int IdMon[]=new int[150],IdBall[]=new int[150],ingresados=0;
    //Las variables que no son arreglos se encargan de almacenar lo que escribe el usuario.
    static String Titulo[]=new String[2],op,ruta;
    //Variable para leer lo que escribe el usuario.
    static Scanner sc=new Scanner(System.in);
    
    static void menu(){
        try {
            //Inicio del ciclo del menú principal.
            int cont=1;
            while (cont>0){
                //Se imprime el menú
                System.out.println("=========================================\n"
                        + "|1.Asignar Pokemons a las Pokeballs\t|\n"
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
                        System.out.println("Ejemplo: C:\\Users\\Diego\\Desktop\\AsignarPokemons.csv");
                        //Se almacena la ruta que ingreso el usuario.
                        ruta=sc.nextLine();
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
        /**Se reinician los arreglos, para que se pudieran llenar de nuevo*/
        IdMon=new int[150];IdBall=new int[150];
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
                IdBall[a]=Integer.parseInt(divisor[0]);
                IdMon[a]=Integer.parseInt(divisor[1]);
                
                /**Ciclo que se encarga de revisar todos los pokemons emparejados,
                 y pasarlos de estado salvaje a capturado*/
                for (int i = 0; i < 150; i++) {
                    if (IdMon[a]==pokemon.Id[i]) {
                        pokemon.Capturado[i]=true;
                    }
                }
                /**Se aumenta el contador para determinar la posición del siguiente
                 pokemon del listado*/
                a++;
                /**Se aumenta en 1 el contador de la cantidad de pokemons ingresados*/
                ingresados++;
            }
            /**Se manda a llamar al metodo que se encarga de rescribir el documento
             con los pokemons que indico el usuario, para guardar los cambios*/
            rescribir();
            /**Se cierra la lectura del documento*/
            lectura.close();
            /**Se cierra la lectura del documento*/
            archivoG.close();
        } catch (Exception e) {
            System.err.println("Error asegurese de ingresar una ruta correcta.");
        }
    }
    
    
    static void rescribir(){
        try {
            /**Se crea un archivo nuevo, que tendra como ruta la misma ingresada por el usuario
             anteriormente, para que este documento sea cambiado por el nuevo documento*/
            File f=new File(pokemon.ruta);
            /**Se prepara el documente para poder escribir en el*/
            FileWriter w=new FileWriter(f);
            BufferedWriter bw=new BufferedWriter(w);
            PrintWriter pw=new PrintWriter(bw);
            
            /**Primero se escribe los titulos de las columnas*/
            pw.write(pokemon.Titulo[0]+","+pokemon.Titulo[1]+","+pokemon.Titulo[2]
            +","+pokemon.Titulo[3]+","+pokemon.Titulo[4]+","+pokemon.Titulo[5]+","+pokemon.Titulo[6]+"\n");
            
            for (int i = 0; i < pokemon.ingresados; i++) {
                String capturado,estado;
                /**Se establece si el pokemon se encuentra capturado o salvaje*/
                if (pokemon.Capturado[i]==true) {
                    capturado="Capturado";
                }else{capturado="Salvaje";}
                /**Se establece si el pokemon se encuentra vivo o muerto*/
                if (pokemon.Estado[i]==true) {
                    estado="Vivo";
                }else{estado="Muerto";}
                
                /**Se rescriben los valores de las filas en el mismo orden en como se debio
                 encontrar el documento original*/
                pw.write(pokemon.Id[i]+","+pokemon.Tipo[i]+","+pokemon.Nombre[i]+","+pokemon.Vida[i]
                +","+pokemon.ptAt[i]+","+capturado+","+estado+"\n"); 
            }
            /**Se cierra la función que permitia escribir en el documento*/
            pw.close();
            /**Se cierra el documento*/
            bw.close();
            /**Se vuelven a ingresar el documento y sus valores actualizados en el sistema*/
            pokemon.carga(pokemon.ruta);
        } catch (Exception e) {
             System.out.println("Asegurese que ingreso pokemons y pokeballs anteriormente."+e);
        }
    }
}

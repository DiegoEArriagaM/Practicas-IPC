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
public class AsignarPelea {
    //Se mandan a llamar las clases necesarias para unir los datos.
    static CargaPokemon pokemon = new CargaPokemon();
    static CargaGimnasios gimnasio=new CargaGimnasios();
    //Se crean los arreglos que almacenaran los datos de la tabla.
    //Las variables que no son arreglos se encargan de almacenar lo que escribe el usuario.
    static String Titulo[]=new String[2],op,ruta,lugar,Listado[]=new String[200];
    //Controladores de los participantes de la pelea y de la cantidad de peleadas realizadas.
    static int Idgimnasio=0,Idpokemon1=0,Idpokemon2=0,ingresados=0,contLista=0,ganador=0;
    //Variable para leer lo que escribe el usuario.
    static Scanner sc=new Scanner(System.in);
    
    static  void menu(){
        try {
            //Inicio del ciclo del menú principal.
            int cont=1;
            while (cont>0){
                //Se imprime el menú
                System.out.println("=========================================\n"
                        + "|1.Asignar Actividad de pelea\t\t|\n"
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
                        System.out.println("Ejemplo: C:\\Users\\Diego\\Desktop\\AsignarPelea.csv");
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
     
    static  void asignar(String r){
         try {
        //Se reinician los controladores de los participantes.
         Idgimnasio=0;Idpokemon1=0;Idpokemon2=0;
         
        /**Se guarda el archivo que indico el usario y se le prepara para que
             pueda leerse*/    
        File archivo=new File(r);
        FileReader archivoG=new FileReader(archivo);
        BufferedReader lectura=new BufferedReader(archivoG);
        /**Se lee la primera linea del documento*/
        String codigo=lectura.readLine(),
                /**Se crea un arreglo que divira los apartados en cada linea.*/
                divisor[]=new String[3];
        /**Se almacenan los titulos de cada columna*/
        Titulo=codigo.split("\\s*,\\s*");
            
        /**Se reinician los controladores del las capacidades de los pokemons*/
        int d=0;double vida1=0,vida2=0,ataque1=0,ataque2=0;
            
            while ((codigo=lectura.readLine())!=null) {
                //Reiniciar variables
                int a=0,b=0,c=0,cont=0;String nombreG="";
                //Dividir el texto del archivo en un arreglo
                divisor=codigo.split(",");
                 
                //Asignar cada valor del arreglo a su respectiva variable
                Idgimnasio=Integer.parseInt(divisor[0]);
                Idpokemon1=Integer.parseInt(divisor[1]);
                Idpokemon2=Integer.parseInt(divisor[2]);
                 
                //Encontrar nombre del Gimnasio
                while (c<gimnasio.ingresados) {
                    if (Idgimnasio==gimnasio.Id[c]) {
                        nombreG=gimnasio.Lugar[c];
                        break;
                    }
                    c++;
                }
                 
                //Encontrar la vida de cada pokemon asignado
                while (a<pokemon.ingresados) {
                    if (Idpokemon1==pokemon.Id[a]) {
                        vida1=pokemon.Vida[a];
                        break;
                    }
                    a++;
                }
                while (b<pokemon.ingresados) {
                    if (Idpokemon2==pokemon.Id[b]) {
                        vida2=pokemon.Vida[b];
                        break;
                    }
                    b++;
                }
                 //Inicio de la pelea
                 while (cont<3) {
                     //Turno del Pokemon 1
                     vida2=vida2-pokemon.ptAt[a];
                     //Comprobar si el pokemon 2 murio durante el turno
                     if (vida2<=0) {
                         pokemon.Vida[a]=vida1;
                         vida2=0;
                         pokemon.Vida[b]=vida2;
                         pokemon.Estado[b]=false;
                         break;
                     }
                     //Turno del Pokemon 2
                     vida1=vida1-pokemon.ptAt[b];
                     //Comprobar si el pokemon 1 murio durante el turno
                     if (vida1<=0) {
                         vida1=0;
                         pokemon.Vida[a]=vida1;
                         pokemon.Estado[a]=false;
                         pokemon.Vida[b]=vida2;
                         break;
                     }
                     cont++;
                 }
                    pokemon.Vida[a]=vida1;
                    pokemon.Vida[b]=vida2;
                 //Indicar qué pokemon gano el combate
                 if (vida1>vida2) {
                    //Guardar el combate que se acaba de concretar.
                     Listado[ingresados]="El ganador de la pelea de "+pokemon.Nombre[a]+" vs "+ pokemon.Nombre[b]+
                             " es "+pokemon.Nombre[a]+" en el gimnasio "+nombreG;
                 }
                 if (vida2>vida1) {
                     //Guardar el combate que se acaba de concretar.
                     Listado[ingresados]="El ganador de la pelea de "+pokemon.Nombre[a]+" vs "+ pokemon.Nombre[b]+
                             " es "+pokemon.Nombre[b]+" en el gimnasio "+nombreG;
                 }
              ingresados++;   
             }
            /**Se cierra la lectura del documento*/
             lectura.close();
            /**Se cierra la lectura del documento*/
             archivoG.close();
             /**Se manda a llamar al metodo que se encarga de rescribir el documento
             con los pokemons que indico el usuario, para guardar los cambios*/
             reescribir();
             
         } catch (Exception e) {
            System.err.println("Error asegurese de ingresar una ruta correcta, que la tabla "
                    + "este bien destribuida o de haber ingresado un listado de pokemons y gimnasios"
                    + " anteriormente.");
         }
     }
     
    static  void reescribir(){
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
            System.err.println("Error asegurese de ingresar una ruta correcta, que la tabla "
                    + "este bien destribuida o de haber ingresado un listado de pokemons y gimnasios"
                    + " anteriormente.");
        }
    }
}

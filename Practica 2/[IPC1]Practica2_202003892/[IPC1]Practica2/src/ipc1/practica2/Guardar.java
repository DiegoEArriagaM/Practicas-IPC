/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipc1.practica2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

/**
 *
 * @author Diego
 */
public class Guardar {
   //Se mandan a llamar las clases necesarias para unir los datos.
    static CargaAlimentos alimentos;
    static CargaGimnasios gimnasio;
    static CargaEntrenador entrenador;
    static CargaPokeballs pokeball;
    static CargaPokemon pokemon;
     public Guardar(){
         alimentos=new CargaAlimentos();
         gimnasio=new CargaGimnasios();
         entrenador=new CargaEntrenador();
         pokeball=new CargaPokeballs();
         pokemon=new CargaPokemon();
     }
    //Metodo que se encarga de guardar los archivos
    public static void guardar() {
        try {
           //Crear archivos BIN
            ObjectOutputStream os1 = new ObjectOutputStream(new FileOutputStream("pokemons.bin"));
            os1.writeObject(pokemon);  // this es de tipo DatoUdp
            os1.close();
            ObjectOutputStream os2 = new ObjectOutputStream(new FileOutputStream("pokeballs.bin"));
            os2.writeObject(pokeball);  // this es de tipo DatoUdp
            os2.close(); 
            ObjectOutputStream os3 = new ObjectOutputStream(new FileOutputStream("entrenadores.bin"));
            os3.writeObject(entrenador);  // this es de tipo DatoUdp
            os3.close();
            ObjectOutputStream os4 = new ObjectOutputStream(new FileOutputStream("gimnasio.bin"));
            os4.writeObject(gimnasio);  // this es de tipo DatoUdp
            os4.close();
            ObjectOutputStream os5 = new ObjectOutputStream(new FileOutputStream("alimento.bin"));
            os5.writeObject(alimentos);  // this es de tipo DatoUdp
            os5.close();
            guardarpokemon();
            guardarentrenador();
            guardarpokeball();
            guardargimnasio();
            guardaralimento();
            System.out.println("Se guardaron los archivos correctamente.");
            
        } catch (Exception e) {
            System.err.println("No se pudieron guardar los archivos");
        }
    }
    static void guardarpokemon(){
        try {
            /**Se crea un archivo nuevo, que tendra como ruta la misma ingresada por el usuario
             anteriormente, para que este documento sea cambiado por el nuevo documento*/
            File f=new File("pokemon.csv");
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
        } catch (Exception e) {
             System.out.println("Asegurese que ingreso pokemons anteriormente."+e);
        }
    }
    static void guardarentrenador(){
        try {
            /**Se crea un archivo nuevo, que tendra como ruta la misma ingresada por el usuario
             anteriormente, para que este documento sea cambiado por el nuevo documento*/
            File f=new File("entrenador.csv");
            /**Se prepara el documente para poder escribir en el*/
            FileWriter w=new FileWriter(f);
            BufferedWriter bw=new BufferedWriter(w);
            PrintWriter pw=new PrintWriter(bw);
            
            /**Primero se escribe los titulos de las columnas*/
            pw.write(entrenador.Titulo[0]+","+entrenador.Titulo[1]+"\n");
            
            for (int i = 0; i < entrenador.ingresados; i++) {
                /**Se rescriben los valores de las filas en el mismo orden en como se debio
                 encontrar el documento original*/
                pw.write(entrenador.Id[i]+","+entrenador.Nombre[i]+"\n"); 
            }
            /**Se cierra la función que permitia escribir en el documento*/
            pw.close();
            /**Se cierra el documento*/
            bw.close();
        } catch (Exception e) {
             System.out.println("Asegurese que ingreso pokeballs anteriormente."+e);
        }
    }
    static void guardarpokeball(){
        try {
            /**Se crea un archivo nuevo, que tendra como ruta la misma ingresada por el usuario
             anteriormente, para que este documento sea cambiado por el nuevo documento*/
            File f=new File("pokeball.csv");
            /**Se prepara el documente para poder escribir en el*/
            FileWriter w=new FileWriter(f);
            BufferedWriter bw=new BufferedWriter(w);
            PrintWriter pw=new PrintWriter(bw);
            
            /**Primero se escribe los titulos de las columnas*/
            pw.write(pokeball.Titulo[0]+","+pokeball.Titulo[1]+"\n");
            
            for (int i = 0; i < pokeball.ingresados; i++) {
                /**Se rescriben los valores de las filas en el mismo orden en como se debio
                 encontrar el documento original*/
                pw.write(pokeball.Id[i]+","+pokeball.Tipo[i]+"\n"); 
            }
            /**Se cierra la función que permitia escribir en el documento*/
            pw.close();
            /**Se cierra el documento*/
            bw.close();
        } catch (Exception e) {
             System.out.println("Asegurese que ingreso pokeballs anteriormente."+e);
        }
    }
    static void guardargimnasio(){
        try {
            /**Se crea un archivo nuevo, que tendra como ruta la misma ingresada por el usuario
             anteriormente, para que este documento sea cambiado por el nuevo documento*/
            File f=new File("gimnasio.csv");
            /**Se prepara el documente para poder escribir en el*/
            FileWriter w=new FileWriter(f);
            BufferedWriter bw=new BufferedWriter(w);
            PrintWriter pw=new PrintWriter(bw);
            
            /**Primero se escribe los titulos de las columnas*/
            pw.write(gimnasio.Titulo[0]+","+gimnasio.Titulo[1]+"\n");
            
            for (int i = 0; i < gimnasio.ingresados; i++) {
                /**Se rescriben los valores de las filas en el mismo orden en como se debio
                 encontrar el documento original*/
                pw.write(gimnasio.Id[i]+","+gimnasio.Lugar[i]+"\n"); 
            }
            /**Se cierra la función que permitia escribir en el documento*/
            pw.close();
            /**Se cierra el documento*/
            bw.close();
        } catch (Exception e) {
             System.out.println("Asegurese que ingreso pokeballs anteriormente."+e);
        }
    }
    static void guardaralimento(){
        try {
            /**Se crea un archivo nuevo, que tendra como ruta la misma ingresada por el usuario
             anteriormente, para que este documento sea cambiado por el nuevo documento*/
            File f=new File("alimento.csv");
            /**Se prepara el documente para poder escribir en el*/
            FileWriter w=new FileWriter(f);
            BufferedWriter bw=new BufferedWriter(w);
            PrintWriter pw=new PrintWriter(bw);
            
            /**Primero se escribe los titulos de las columnas*/
            pw.write(alimentos.Titulo[0]+","+alimentos.Titulo[1]+","+alimentos.Titulo[2]+"\n");
            
            for (int i = 0; i < alimentos.ingresados; i++) {
                /**Se rescriben los valores de las filas en el mismo orden en como se debio
                 encontrar el documento original*/
                pw.write(alimentos.Id[i]+","+alimentos.Nombre[i]+","+alimentos.Vida[i]+"\n"); 
            }
            /**Se cierra la función que permitia escribir en el documento*/
            pw.close();
            /**Se cierra el documento*/
            bw.close();
        } catch (Exception e) {
             System.out.println("Asegurese que ingreso pokeballs anteriormente."+e);
        }
    }
}

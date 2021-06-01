/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipc1.practica2;

import java.awt.Desktop;
import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Diego
 */
public class ReporteEntrenadores {
    //Se mandan a llamar las clases necesarias para generar el reporte.
    static CargaEntrenador entrenador=new CargaEntrenador();
    static CargaPokeballs pokeball=new CargaPokeballs();
    static CargaPokemon pokemon=new CargaPokemon();
    static AsignarPokeball Apokeball=new AsignarPokeball();
    static AsignarPokemons Apokemon=new AsignarPokemons();
    /**Variable que sirve para obtener la fecha y hora en que se genera el reporte*/
    static Calendar fecha=new GregorianCalendar();
    /**Variable para manejar los datos que se obtengan de los diversos metodos*/
    static String I;
    
    /**Metodo que se encarga de generar el reporte.*/
    public static void reporte(){
        try {
            /**Variable necesaria para abrir el archivo creado*/
            Desktop pc=Desktop.getDesktop();
            /**Variables para escribir el documento*/
            File f=new File("Reporte_entrenadores.html");
            FileWriter w=new FileWriter(f);
            BufferedWriter bw=new BufferedWriter(w);
            PrintWriter pw=new PrintWriter(bw);
            
            /**Se inicia el documento HTML*/
            pw.write("<!DOCTYPE html>\n");
            pw.write("<html>\n");
            pw.write("<head>\n");
                pw.write("<title>Reporte de los Entrenadores</title>\n");
                pw.write("<style type=\"text/css\">\n" +
                          "body{\n" +
                                "background-color:rgba(224, 204, 72, 1);\n" +
                                "text-align: center;\n" +
                                "font-family:sans-serif;\n" +
                         "}\n"
                        + "table{\n" +
"			border: black 2px solid;\n" +
"			border-collapse: collapse;\n" +
"                       }\n"
                        + "#td1{\n" +
"                               border: black 2px solid;\n"
                        + "     background-color: skyblue;\n" +
"                               }\n" +
"                          #td2{\n" +
"                               border: black 2px solid;\n"
                        + "     background-color: white;\n" +
"                               }\n"
                        +"</style>");
                pw.write("<meta charset=\"utf-8\">");
            pw.write("</head>\n");
            /**Inicio del cuerpo*/
            pw.write("<body>\n");
            /**Título del reporte*/
                pw.write("<h1>Reporte de los entrenadores ingresados</h1>\n");
            /**Fecha en que se genero el reporte*/
                pw.write("<h3>Documento Creado el "+fecha.get(Calendar.DAY_OF_MONTH)+
                        "/"+((int)fecha.get(Calendar.MONTH)+1)+"/"+fecha.get(Calendar.YEAR)+" a las "
                        +fecha.get(Calendar.HOUR)+":"+fecha.get(Calendar.MINUTE)+":"+fecha.get(Calendar.SECOND)+"</h3>\n");
                  
                for (int i = 0; i < entrenador.ingresados; i++) {
                    pw.write("<p>Entrenador "+entrenador.Nombre[i]+"</p>");
                        //Se determina el entrenador en el metodo de Asignar Pokeball
                        int a=0;
                        while(a<Apokeball.ingresados){
                            if(entrenador.Id[i]==Apokeball.IdEnt[a]){break;}
                            a++;
                        }
                    pw.write("<p>Posee "+Apokeball.ContBall[a]+" pokeballs. Sus pokemones son:</p>\n");
                    pw.write("<table align=\"center\">\n");
                    //Se imprime los títulos
                        pw.write("<tr>\n");
                            pw.write("<td id=\"td1\">ID Pokeball</td>\n");
                            pw.write("<td id=\"td1\">Tipo Pokeball</td>\n");
                            pw.write("<td id=\"td1\">ID Pokemon</td>\n");
                            pw.write("<td id=\"td1\">Pokemon</td>\n");
                            pw.write("<td id=\"td1\">Vida</td>\n");
                            pw.write("<td id=\"td1\">Estado</td>\n");
                        pw.write("</tr>\n");
                       
                        for (int j = 0; j < Apokeball.ingresados2; j++) {
                        pw.write("<tr>\n");
                        //Se establece la fila correcta de acuerdo al entrenador actual
                            if (Apokeball.AUXIdEnt[j]==entrenador.Id[i]) {
                                //Se establece el Id de la pokeball
                                pw.write("<td id=\"td2\">"+Apokeball.IdBall[j]+"</td>\n");
                                //Se establce el tipo de pokeball que almacena el pokemon
                                int b=0;
                                while(b<pokeball.ingresados){
                                    if (pokeball.Id[b]==Apokeball.IdBall[j]) {
                                      pw.write("<td id=\"td2\">"+pokeball.Tipo[b]+"</td>\n");
                                      break;
                                    }
                                    b++;
                                }
                                //Se establce el Id del pokemon
                                int c=0;
                                while (c<Apokemon.ingresados) {
                                    if (Apokemon.IdBall[c]==Apokeball.IdBall[j]) {
                                        pw.write("<td id=\"td2\">"+Apokemon.IdMon[c]+"</td>\n"); 
                                        break;
                                    }
                                    c++;
                                }
                                //Se establce el nombre, vida y estado del pokemon
                                int d=0;
                                while (d<pokemon.ingresados) {
                                    if (pokemon.Id[d]==Apokemon.IdMon[c]) {
                                        pw.write("<td id=\"td2\">"+pokemon.Nombre[d]+"</td>\n"); 
                                        pw.write("<td id=\"td2\">"+pokemon.Vida[d]+"</td>\n"); 
                                        String estado="";
                                        if (pokemon.Estado[d]==true) {
                                            estado="Vivo";
                                        }else{estado="Muerto";} 
                                        pw.write("<td id=\"td2\">"+estado+"</td>\n"); 
                                        break;
                                    }
                                    d++;
                                }
                            }
                        pw.write("</tr>\n");    
                        }
                        
                    pw.write("</table><br>\n");
                }
  
            pw.write("</body>\n");
            pw.write("</html>\n");
            /**Se finaliza el documento HTML*/
        /**Se cierra la capacidad de escribir en el documento*/    
        pw.close();
        /**Se cierra el documento en el programa*/
        bw.close();
        /**Se abre el documento recien creado y guardado*/
        pc.open(f);
        } catch (Exception e) {
            System.err.println("Asegurese de haber realizado las actividades previas "
                    + "relacionadas");
        }
    }
}

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
public class TopSalud {
    //Se mandan a llamar las clases necesarias para generar el reporte.
    static CargaAlimentos alimentos=new CargaAlimentos();
    /**Variable que sirve para obtener la fecha y hora en que se genera el reporte*/
    static Calendar fecha=new GregorianCalendar();
    /**Variable para manejar los datos que se obtengan de los diversos metodos*/
    static String I;
    static double[] top;
    static int[] id;
    
    //Reorganizar los pokemons segun sus puntos de ataque
    static void reorganizar(){
        top=new double[alimentos.ingresados];
        id=new int[alimentos.ingresados];
        for (int i = 0; i < alimentos.ingresados; i++) {
            top[i]=alimentos.Vida[i];
            id[i]=alimentos.Id[i];
        }
        //Algoritmo burbuja
        for (int i = 0; i < top.length; i++) {
            for (int j = 0; j < (top.length-i-1); j++) {
                if (top[j]<top[j+1]) {
                    double menor=top[j+1];
                    int id1=id[j+1];
                    top[j+1]=top[j];
                    id[j+1]=id[j];
                    top[j]=menor;
                    id[j]=id1;
                }
            }
        }
    }
    
     void reporte(){
        reorganizar();
        try {
            /**Variable necesaria para abrir el archivo creado*/
            Desktop pc=Desktop.getDesktop();
            /**Variables para escribir el documento*/
            File f=new File("Reporte_topAtaque.html");
            FileWriter w=new FileWriter(f);
            BufferedWriter bw=new BufferedWriter(w);
            PrintWriter pw=new PrintWriter(bw);
            
             /**Se inicia el documento HTML*/
            pw.write("<!DOCTYPE html>\n");
            pw.write("<html>\n");
            pw.write("<head>\n");
                pw.write("<title>Top 5 Alimentos con mas Vida</title>\n");
                pw.write("<style type=\"text/css\">\n" +
                          "body{\n" +
                                "background-color:rgba(152, 239, 118, 1);\n" +
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
                pw.write("<h1>Reporte de los 5 Alimentos que mas vida recuperan</h1>\n");
            /**Fecha en que se genero el reporte*/
                pw.write("<h3>Documento Creado el "+fecha.get(Calendar.DAY_OF_MONTH)+
                        "/"+((int)fecha.get(Calendar.MONTH)+1)+"/"+fecha.get(Calendar.YEAR)+" a las "
                        +fecha.get(Calendar.HOUR)+":"+fecha.get(Calendar.MINUTE)+":"+fecha.get(Calendar.SECOND)+"</h3>\n");
                
                pw.write("<table align=\"center\">\n");
                    //Se escriben los títulos de las columnas
                    pw.write("<tr>\n");
                        pw.write("<td id=\"td1\">"+alimentos.Titulo[0]+"</td>\n");
                        pw.write("<td id=\"td1\">"+alimentos.Titulo[1]+"</td>\n");
                        pw.write("<td id=\"td1\">"+alimentos.Titulo[2]+"</td>\n");
                    pw.write("</tr>\n");
                    //Se escriben los 5 top
                    for (int i = 0; i < 5; i++) {
                        pw.write("<tr>\n");
                            int b=0;
                            while(b<alimentos.ingresados){
                                if (alimentos.Id[b]==id[i]) {
                                   pw.write("<td id=\"td2\">"+alimentos.Id[b]+"</td>\n");
                                   pw.write("<td id=\"td2\">"+alimentos.Nombre[b]+"</td>\n");
                                   pw.write("<td id=\"td2\">"+alimentos.Vida[b]+"</td>\n");
                                }
                                b++;
                            }
                        pw.write("</tr>\n");
                    }
                pw.write("</table><br>\n");
                
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

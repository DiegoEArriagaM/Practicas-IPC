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
public class ReporteComidas {
    //Se mandan a llamar las clases necesarias para generar el reporte.
    static AsignarAlimentos alimentos=new AsignarAlimentos();
    /**Variable que sirve para obtener la fecha y hora en que se genera el reporte*/
    static Calendar fecha=new GregorianCalendar();
    /**Variable para manejar los datos que se obtengan de los diversos metodos*/
    static String I;
    
    public static void reporte(){
        try {
            /**Variable necesaria para abrir el archivo creado*/
            Desktop pc=Desktop.getDesktop();
            /**Variables para escribir el documento*/
            File f=new File("Reporte_comida.html");
            FileWriter w=new FileWriter(f);
            BufferedWriter bw=new BufferedWriter(w);
            PrintWriter pw=new PrintWriter(bw);
            
            /**Se inicia el documento HTML*/
            pw.write("<!DOCTYPE html>\n");
            pw.write("<html>\n");
            pw.write("<head>\n");
                pw.write("<title>Reporte de las Comidas Asignadas</title>\n");
                pw.write("<style type=\"text/css\">\n" +
                          "body{\n" +
                                "background-color:rgba(250, 207, 133, 1);\n" +
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
                pw.write("<h1>Reporte de las Comidas Asignadas</h1>\n");
            /**Fecha en que se genero el reporte*/
                pw.write("<h3>Documento Creado el "+fecha.get(Calendar.DAY_OF_MONTH)+
                        "/"+((int)fecha.get(Calendar.MONTH)+1)+"/"+fecha.get(Calendar.YEAR)+" a las "
                        +fecha.get(Calendar.HOUR)+":"+fecha.get(Calendar.MINUTE)+":"+fecha.get(Calendar.SECOND)+"</h3>\n");
                
                pw.write("<table align=\"center\">\n");
                    pw.write("<tr>\n");
                    //Se escriben los títulos
                        pw.write("<td id=\"td1\">No.</td>\n");
                        pw.write("<td id=\"td1\">Actividad de comida</td>\n");
                    pw.write("</tr>\n");
                    
                    //Se escriben todas las actividades
                    for (int i = 0; i < alimentos.ingresados; i++) {
                    pw.write("<tr>\n");
                        pw.write("<td id=\"td2\">"+(i+1)+"</td>\n");
                        pw.write("<td id=\"td2\">"+alimentos.Listado[i]+"</td>\n");
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

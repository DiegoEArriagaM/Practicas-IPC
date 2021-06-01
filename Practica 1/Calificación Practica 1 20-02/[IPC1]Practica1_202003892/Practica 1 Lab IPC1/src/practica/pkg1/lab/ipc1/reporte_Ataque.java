/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg1.lab.ipc1;

import java.awt.Desktop;
import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 *
 * @author Diego
 */
public class reporte_Ataque {
    static Ataque_Texto info=new Ataque_Texto();
    static Calendar fecha=new GregorianCalendar();
    static String I;
    
    //Colores de texto
       static String verde="\033[32m";
       static String cyan="\033[36m"; 
       static String negro="\033[30m";
       static String rojo="\033[31m";
       static String amar="\033[33m";
    //-----------------------------
    
    public static void reporte(){
        try {
            Desktop pc=Desktop.getDesktop();
            File f=new File("Reporte_ataque.html");
            FileWriter w=new FileWriter(f);
            BufferedWriter bw=new BufferedWriter(w);
            PrintWriter pw=new PrintWriter(bw);
            
            pw.write("<!DOCTYPE html>\n");
        pw.write("<html>\n");
            pw.write("<head>\n");
                pw.write("<title>"); pw.write("Reporte del Proceso de Ataque de Texto Plano"); pw.write("</title>");
                pw.write("\n<meta charset=\"utf-8\"/>\n");
            pw.write("</head>\n");
            pw.write("<body style =\"text-align: center;\">\n");
                pw.write("<h1 style=\"color:blue;\">Reporte del Proceso de Ataque de Texto Plano</h1>\n");
                pw.write("<h3>Documento Creado el "+fecha.get(Calendar.DAY_OF_MONTH)+
                        "/"+((int)fecha.get(Calendar.MONTH)+1)+"/"+fecha.get(Calendar.YEAR)+" a las "
                        +fecha.get(Calendar.HOUR)+":"+fecha.get(Calendar.MINUTE)+":"+fecha.get(Calendar.SECOND)+"</h3>\n");
                pw.write("<h4>(1) Ingreso de texto con el mensaje original convertido en Matriz</h4>\n");
                pw.write("<p>Documento ingresado por el usuario: "+info.doc1+"\n");
                pw.write("<p>La matriz obtenida por el programa: "+"\n");
                pw.write("<table align=\"center\" border=\"1 solid\">\n");
                for (int a = 0; a < info.filas; a++) {
                    pw.write("<tr>\n");
                    for (int b = 0; b < 3; b++) {
                        I=(int)(info.M1[a][b])+"";
                        pw.write("<td>"+I+"</td>\n"); 
                    }
                    pw.write("</tr>\n");
                }
                pw.write("</table>\n");
                pw.write("<h4>(2) Ingreso de texto con el mensaje original cifrado convertido en Matriz</h4>\n");
                pw.write("<p>Documento ingresado por el usuario: "+info.doc2+"\n");
                pw.write("<p>La matriz obtenida por el programa: "+"\n");
                pw.write("<table align=\"center\" border=\"1 solid\">\n");
                for (int a = 0; a < info.filas; a++) {
                    pw.write("<tr>\n");
                    for (int b = 0; b < 3; b++) {
                        I=(int)(info.M2[a][b])+"";
                        pw.write("<td>"+I+"</td>\n"); 
                    }
                    pw.write("</tr>\n");
                }
                pw.write("</table>\n");
                pw.write("<h4>(3) Matriz resultante</h4>\n");
                pw.write("<table align=\"center\" border=\"1 solid\">\n");
                for (int a = 0; a < info.filas; a++) {
                    pw.write("<tr>\n");
                    for (int b = 0; b < 3; b++) {
                        I=(int)(info.M1[a][b])+"";
                        pw.write("<td>"+I+"</td>\n"); 
                    }
                    pw.write("<td>:</td>\n");
                    for (int b = 0; b < 3; b++) {
                        I=(int)(info.M2[a][b])+"";
                        pw.write("<td>"+I+"</td>\n"); 
                    }
                    pw.write("</tr>\n");
                }
                pw.write("</table>\n");
                
                pw.write("<h4>(4) Primera operación realizada en la matriz</h4>\n");
                pw.write("<p>Fila #"+(info.a1+1)+" = (Fila #"+(info.a1+1)+"*"+info.c1+")modulo27</p></br>\n");
                for (int i = 0; i < info.a1; i++) {
                    pw.write("<p>Fila #"+(i+1)+" = (Fila #"+(i+1)+"- "+info.d1[i]+"*Fila #"+(info.a1+1)+")modulo27</p>\n");
                    }
                for (int i = (info.a1+1); i < info.filas; i++) {
                    pw.write("<p>Fila #"+(i+1)+" = (Fila #"+(i+1)+"- ("+info.d1[i]+"*Fila #"+(info.a1+1)+"))modulo27</p>\n");
                    }pw.write("</br>\n");
                    
                pw.write("<h4>(5) Segunda operación realizada en la matriz</h4>\n");
                pw.write("<p>Fila #"+(info.a2+1)+" = (Fila #"+(info.a2+1)+"*"+info.c2+")modulo27</p></br>\n");
                for (int i =0; i < info.a2; i++) {
                    pw.write("<p>Fila #"+(i+1)+" = (Fila #"+(i+1)+"- "+info.d2[i]+"*Fila #"+(info.a2+1)+")modulo27</p>\n");
                    }
                for (int i = (info.a2+1); i < info.filas; i++) {
                    pw.write("<p>Fila #"+(i+1)+" = (Fila #"+(i+1)+"- ("+info.d2[i]+"*Fila #"+(info.a2+1)+"))modulo27</p>\n");
                    }pw.write("</br>\n");
                    
                pw.write("<h4>(6) Tercera operación realizada en la matriz</h4>\n");
                pw.write("<p>Fila #"+(info.a3+1)+" = (Fila #"+(info.a3+1)+"*"+info.c3+")modulo27</p></br>\n");
                for (int i = 0; i < info.a3; i++) {
                    pw.write("<p>Fila #"+(i+1)+" = (Fila #"+(i+1)+"- "+info.d3[i]+"*Fila #"+(info.a3+1)+")modulo27</p>\n");
                    }
                for (int i = (info.a3+1); i < info.filas; i++) {
                    pw.write("<p>Fila #"+(i+1)+" = (Fila #"+(i+1)+"- ("+info.d3[i]+"*Fila #"+(info.a3+1)+"))modulo27</p>\n");
                    }pw.write("</br>\n");
                
                pw.write("<h4>(7) Matriz tras las operaciones</h4>\n");
                pw.write("<table align=\"center\" border=\"1 solid\">\n");
                    for (int i = 0; i < info.filas; i++) {
                        pw.write("<tr>\n");
                        for (int j = 0; j < 3; j++) {
                            I=(int)(info.MT[i][j])+"";
                            pw.write("<td>");
                            pw.write(I);
                            pw.write("</td>\n");
                        }
                        pw.write("<td>:</td>\n");
                        for (int j = 3; j < 6; j++) {
                            I=(int)(info.MT[i][j])+"";
                            pw.write("<td>");
                            pw.write(I);
                            pw.write("</td>\n");
                        }
                        pw.write("</tr>\n");
                    }
                pw.write("</table>\n");
                
               pw.write("<h4>(8)Matriz Resultaten tras reducir el lado derecho de la matriz calculada</h4>\n");
                pw.write("<table align=\"center\" border=\"1 solid\">\n");
                for (int i = 0; i < 3; i++) {
                    pw.write("<tr>\n");
                    for (int j = 0; j < 3; j++) {
                        pw.write("<td>");
                        I=info.MF2[i][j]+"";
                        pw.write(I);
                        pw.write("</td>\n");
                    }
                    pw.write("</tr>\n");
                }
                pw.write("</table>\n");
                
                pw.write("<h4>(9)Matriz Clave A</h4>\n");
                pw.write("<table align=\"center\" border=\"1 solid\">\n");
                for (int i = 0; i < 3; i++) {
                    pw.write("<tr>\n");
                    for (int j = 0; j < 3; j++) {
                        pw.write("<td>");
                        I=info.MF1[i][j]+"";
                        pw.write(I);
                        pw.write("</td>\n");
                    }
                    pw.write("</tr>\n");
                }
                pw.write("</table>\n");
               
            pw.write("</body>\n");
        pw.write("</html>");
            
        pw.close();
        bw.close();
        pc.open(f);
        
        } catch (Exception e) {
            System.out.println(rojo+"Error al generar el reporte. Asegurese haber realizado el proceso anteriormente"+negro);
        }
    }
    
}

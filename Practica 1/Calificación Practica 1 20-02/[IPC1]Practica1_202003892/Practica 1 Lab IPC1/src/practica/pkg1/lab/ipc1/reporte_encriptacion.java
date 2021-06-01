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

public class reporte_encriptacion {
    
    static encriptador info=new encriptador();
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
        try{
        Desktop pc=Desktop.getDesktop();
        File f=new File("Reporte_encriptacion.html");
        FileWriter w=new FileWriter(f);
        BufferedWriter bw=new BufferedWriter(w);
        PrintWriter pw=new PrintWriter(bw);
        
        
        pw.write("<!DOCTYPE html>\n");
        pw.write("<html>\n");
            pw.write("<head>\n");
                pw.write("<title>"); pw.write("Reporte del Proceso de Encriptación"); pw.write("</title>\n");
                pw.write("<meta charset=\"utf-8\"/>\n");
            pw.write("</head>\n");
            pw.write("<body style =\"text-align: center;\">\n");
                pw.write("<h1 style=\"color:blue;\">Reporte del Proceso de Encriptación</h1>\n");
                pw.write("<h3>Documento Creado el "+fecha.get(Calendar.DAY_OF_MONTH)+
                        "/"+((int)fecha.get(Calendar.MONTH)+1)+"/"+fecha.get(Calendar.YEAR)+" a las "
                        +fecha.get(Calendar.HOUR)+":"+fecha.get(Calendar.MINUTE)+":"+fecha.get(Calendar.SECOND)+"</h3>");
                pw.write("\n<h4>(1) Ingreso del mensaje a Encriptar</h4>\n");
                pw.write("<p>El mensaje ingresado por el usuario es: ");
                    for (int i = 0; i < info.mb; i++) {I=info.caracterS[i];pw.write(I+"");}
                pw.write("</p>\n");
                pw.write("<h4>(2) Conversión de letras a números</h4>\n");
                pw.write("<p>");
                for (int i = 0; i < info.mb; i++) {
                    I=info.caracterS[i];
                    pw.write("->"+I+" = ");
                    I=info.caracterI[i]+"";
                    pw.write(I+"<br>");
                }
                pw.write("</p>\n");
                pw.write("<h4>(3) Pasar los numeros a la matriz M</h4>\n");
                pw.write("<table  align=\"center\" border=\"black 2px solid\">\n");
                for (int a = 0; a < 3; a++) {
                    pw.write("<tr>\n");
                    for (int b = 0; b < info.colum; b++) {
                        pw.write("<td>");
                            I=info.M[a][b]+"";
                            pw.write(I);
                        pw.write("</td>\n");
                    }
                    pw.write("</tr>\n");
                }
                pw.write("</table>\n");
                pw.write("<h4>(4) Ingresar valores a la matriz A</h4>\n");
                pw.write("<h5>Valores ingresados por el usuario:</h5>\n");
                pw.write("<table  align=\"center\" border=\"black 2px solid\">\n");
                for (int a = 0; a < 3; a++) {
                    pw.write("<tr>\n");
                    for (int b = 0; b < 3; b++) {
                        pw.write("<td>\n");
                            I=info.A[a][b]+"";
                            pw.write(I);
                        pw.write("</td>\n");
                    }
                    pw.write("</tr>\n");
                }
                pw.write("</table>\n");
                pw.write("<h4>(5) Ingresar valores a la matriz B</h4>\n");
                pw.write("<h5>Valores ingresados por el usuario:</h5>\n");
                pw.write("<table  align=\"center\" border=\"black 2px solid\">\n");
                for (int a = 0; a < 3; a++) {
                    pw.write("<tr>\n");
                    for (int b = 0; b < info.colum; b++) {
                        pw.write("<td>\n");
                            I=info.B[a][b]+"";
                            pw.write(I);
                        pw.write("</td>\n");
                    }
                    pw.write("</tr>\n");
                }
                pw.write("</table>\n");
                pw.write("<h4>(6) Operación A*M</h4>\n");
                int Ab=0,Ma,Mb=0;
                for (int a = 0; a < 3; a++) {
                    for (int b = 0; b < info.colum; b++) {
                     Ma=0;
                         pw.write("->Ri["+(a+1)+"]["+(b+1)+"] = ("+info.A[a][Ab]+"*"+info.M[Ma][Mb]+")"
                             + " + ("+info.A[a][Ab+1]+"*"+info.M[Ma+1][Mb]+") + ("
                             + info.A[a][Ab+2]+"*"+info.M[Ma+2][Mb]+") = "+info.Ri[a][b]+"</br>\n");
                     Mb++; }
                    Mb=0;}
                pw.write("<h4>(7) Operación (A*M)+ B</h4>\n");
                for (int a = 0; a < 3; a++) {
                    for (int b = 0; b < info.colum; b++) {
                        pw.write("->C["+(a+1)+"]["+(b+1)+"] = "+info.Ri[a][b]+"+"+info.B[a][b]+" = "
                                +info.Rf[a][b]+"</br>\n");
                    }
                }
                pw.write("<h4>(8) Resultado del proceso de Encriptación</h4>\n");
                pw.write("<p>Mensaje cifrado: ");
                for (int b = 0; b < info.colum; b++) {
                    for (int a = 0; a < 3; a++) {
                            pw.write(info.Rf[a][b]+" ");
                    }
                }
                pw.write("</p>\n");
                pw.write("<table  align=\"center\" border=\"black 2px solid\">\n");
                for (int a = 0; a < 3; a++) {
                    pw.write("<tr>\n");
                    for (int b = 0; b < info.colum; b++) {
                        pw.write("<td>\n");
                            I=info.Rf[a][b]+"";
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
        }catch(Exception e){
            System.out.println(rojo+"Error al generar el reporte. Asegurese haber realizado el proceso anteriormente"+negro);
        }
    }
    
}

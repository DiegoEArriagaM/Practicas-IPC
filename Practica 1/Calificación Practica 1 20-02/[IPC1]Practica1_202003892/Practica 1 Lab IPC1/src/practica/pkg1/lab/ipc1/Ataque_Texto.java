/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg1.lab.ipc1;

import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Diego
 */
public class Ataque_Texto {
   //Colores de texto
       static String verde="\033[32m";
       static String cyan="\033[36m"; 
       static String negro="\033[30m";
       static String rojo="\033[31m";
       static String amar="\033[33m";
        //----------------------
       
    static Scanner sc=new Scanner(System.in);
    static String op,doc1,doc2;
    static int filas=0;
    static double M1[][],M2[][],MT[][],MC1[][],MC2[][],Cam;
    static int MF1[][]=new int[3][3],MF2[][]=new int[3][3];
    static String mensaje[];
    
    static void menu() {
        int cont=1;
        while(cont>0){
            System.out.println("==========="+verde+"Ataque "+negro+"con texto "+cyan+"Plano"+negro+"==========");
            System.out.println("|"+amar+" 1."+verde+" Ingresar Matriz "+negro+"mensaje original      |");
            System.out.println("|"+amar+" 2."+verde+" Ingresar Matriz "+negro+"mensaje cifrado       |");
            System.out.println("|"+amar+" 3."+verde+" Obtener "+negro+"Clave                         |");
            System.out.println("|"+amar+" 4."+cyan+" Regresar"+negro+" al Menú Principal            |");
            System.out.println("===========================================");
            System.out.print("Ingrese el número de acción que quiere realizar: ");
            op=sc.nextLine();System.out.println();
            
            switch(op){
                case "1":
                    matrizO();
                    break;
                case "2":
                    matrizC();
                    break;
                case "3":
                    clave();
                    break;
                case "4":
                    cont--;
                    break;
                default:
                        System.out.println(rojo+"ERROR. Asegurese que el dígito ingresado sea 1, 2, 3 o 4"+negro);
                        break;
            }
        }
    }
    
    static void matrizO(){
        try {
            filas=0;
            System.out.println("Ingrese la ruta en la que se encuentra el archivo .txt");
            System.out.println(verde+"Ejemplo: C:\\Users\\Diego\\Desktop\\Mensaje_Prueba.txt"+negro);
            
            doc1=sc.nextLine();
            File archivo=new File(doc1);
            FileReader archivoG=new FileReader(archivo);
            BufferedReader lectura=new BufferedReader(archivoG);
            String codigo;
            
            while ((codigo=lectura.readLine())!=null) {
                mensaje=codigo.split(",");
                filas++;
            }
            
            M1=new double[filas][3];M2=new double[filas][3];MT=new double[filas][6];
            MC1=new double[filas][3];MC2=new double[filas][3];
            int c=0,d=0;
            FileReader archivoG2=new FileReader(archivo);
            BufferedReader lectura2=new BufferedReader(archivoG2);
            while ((codigo=lectura2.readLine())!=null && c<filas) { 
                mensaje=codigo.split(",");
                for (int b = 0; b < 3; b++) {
                    M1[c][b]=Integer.parseInt(mensaje[b]);
                    MT[c][b]=Integer.parseInt(mensaje[b]);
                }
                c++;
            }
            
            System.out.println("=======Matriz del mensaje"+cyan+" original"+negro+"===============");
            System.out.println("-------------------------------------------------");
            for (int a = 0; a < filas; a++) {
                for (int b = 0; b < 3; b++) {
                    System.out.print("|\t"+M1[a][b]+"\t");
                }
                System.out.println("|\n"+"-------------------------------------------------");
            }
            
            System.out.println("==================================Matriz"+cyan+" total"+negro+"==================================================");
            System.out.println("--------------------------------------------------------------------------------------------------");
            for (int a = 0; a < filas; a++) {
                for (int b = 0; b < 3; b++) {
                    System.out.print("|\t"+MT[a][b]+"\t");
                }
                System.out.print(":");
                for (int b = 3; b < 6; b++) {
                    System.out.print("\t"+MT[a][b]+"\t|");
                }
                System.out.println("\n"+"--------------------------------------------------------------------------------------------------");
            }
        } catch (Exception e) {
            System.out.println(rojo+"ERROR al subir el documento con el mensaje original"+negro);
        }
    }
    
    static void matrizC(){
        try {
            System.out.println("Ingrese la ruta en la que se encuentra el archivo .txt");
            System.out.println(verde+"Ejemplo: C:\\Users\\Diego\\Desktop\\Mensaje_Prueba_Cifrado.txt"+negro);
            
            doc2=sc.nextLine();
            File archivo=new File(doc2);
            FileReader archivoG2=new FileReader(archivo);
            BufferedReader lectura2=new BufferedReader(archivoG2);
            String codigo;
            int c=0,d=3;
            while ((codigo=lectura2.readLine())!=null && c<filas) {                
                mensaje=codigo.split(",");
                d=3;
                for (int b = 0; b < 3; b++) {
                    M2[c][b]=Integer.parseInt(mensaje[b]);
                    MT[c][d]=Integer.parseInt(mensaje[b]);
                    d++;
                }
                c++;
            }
            
            System.out.println("=======Matriz del mensaje"+cyan+" cifrado"+negro+"===============");
            System.out.println("-------------------------------------------------");
            for (int a = 0; a < filas; a++) {
                for (int b = 0; b < 3; b++) {
                    System.out.print("|\t"+M2[a][b]+"\t");
                }
                System.out.println("|\n"+"-------------------------------------------------");
            }
            
            System.out.println("==================================Matriz"+cyan+" total"+negro+"==================================================");
            System.out.println("--------------------------------------------------------------------------------------------------");
            for (int a = 0; a < filas; a++) {
                for (int b = 0; b < 3; b++) {
                    System.out.print("|\t"+MT[a][b]+"\t");
                }
                System.out.print(":");
                for (int b = 3; b < 6; b++) {
                    System.out.print("\t"+MT[a][b]+"\t|");
                }
                System.out.println("\n"+"--------------------------------------------------------------------------------------------------");
            }
            
        } catch (Exception e) {
            System.out.println(rojo+"ERROR al subir el documento con el mensaje original"+negro);
        }
    }
    
    static int d1[],d2[],d3[];
    static int a1=0,a2=0,a3=0,b1=0,b2=0,b3=0,c1=0,c2=0,c3=0;
    
    static void clave() {
        a1=0;a2=0;a3=0;b1=0;b2=0;b3=0;c1=0;c2=0;c3=0;
        d1=new int[filas];d2=new int[filas];d3=new int[filas];
        try {
            int con=0;
            //En primera columna
            while (con<1) {
                if (a1>=filas || a2>=filas) {break;}
                //Caso en que no exista modulo inverso
                if (moduloinverso((int)MT[a1][b1])==0) {
                    a1=a1+1;
                }else{
                    c1=moduloinverso((int)MT[a1][b1]);
                    for (int j = 0; j < 6; j++) {
                        MT[a1][j]=(double)modulo((int)(MT[a1][j]*c1));
                    }
                    for (int i = 0; i < filas; i++) {
                        d1[i]=(int)MT[i][0];
                    }
                    for (int i = a1+1; i < filas; i++) {
                        for (int j = b1; j < 6; j++) {
                            MT[i][j]=(double)modulo((int)(MT[i][j]-(d1[i]*MT[a1][j])));
                        }
                    }
                    for (int i = a1-1; i > -1; i--) {
                        for (int j = b1; j < 6; j++) {
                            MT[i][j]=(double)modulo((int)(MT[i][j]-(d1[i]*MT[a1][j])));
                        }
                    }
                    con++;
                }
            }
            con=0;
            
            //En segunda columna
            b2=1;a2=a1+1;
            while (con<1) {
                if (a1>=filas || a2>=filas) {break;}
                //Caso en que no exista modulo inverso
                if (moduloinverso((int)MT[a2][b2])==0) {
                    a2=a2+1;
                }else{
                    c2=moduloinverso((int)MT[a2][b2]);
                    for (int j = b2; j < 6; j++) {
                        MT[a2][j]=(double)modulo((int)(MT[a2][j]*c2));
                    }
                    for (int i = 0; i < filas; i++) {
                        d2[i]=(int)MT[i][1];
                    }
                    for (int i = a2+1; i < filas; i++) {
                        for (int j = b2; j < 6; j++) {
                            MT[i][j]=(double)modulo((int)(MT[i][j]-(d2[i]*MT[a2][j])));
                        }
                    }
                    for (int i = a2-1; i > -1; i--) {
                        for (int j = b2; j < 6; j++) {
                            MT[i][j]=(double)modulo((int)(MT[i][j]-(d2[i]*MT[a2][j])));
                        }
                    }
                    con++;
                }
            }
            con=0;
            
            //En Tercera columna
            b3=2;a3=a2+1;
            while (con<1) {
                if (a1>=filas || a2>=filas) {break;}
                //Caso en que no exista modulo inverso
                if (moduloinverso((int)MT[a3][b3])==0) {
                    a3=a3+1;
                }else{
                    c3=moduloinverso((int)MT[a3][b3]);
                    for (int j = b3; j < 6; j++) {
                        MT[a3][j]=(double)modulo((int)(MT[a3][j]*c3));
                    }
                    for (int i = 0; i < filas; i++) {
                        d3[i]=(int)MT[i][b3];
                    }
                    for (int i = a3+1; i < filas; i++) {
                        for (int j = b3; j < 6; j++) {
                            MT[i][j]=(double)modulo((int)(MT[i][j]-(d3[i]*MT[a3][j])));
                        }
                    }
                    for (int i = a3-1; i > -1; i--) {
                        for (int j = b3; j < 6; j++) {
                            MT[i][j]=(double)modulo((int)(MT[i][j]-(d3[i]*MT[a3][j])));
                        }
                    }
                    con++;
                }
            }
            
            if (a1>=filas || a2>=filas) {
                for (int i = 0; i < 3; i++) {
                    Cam=M1[0][i];
                    M1[0][i]=M1[1][i];
                    M1[1][i]=Cam;
                    
                    Cam=M1[1][i];
                    M1[1][i]=M1[filas-1][i];
                    M1[filas-1][i]=Cam;
                    
                    Cam=M1[filas-1][i];
                    M1[filas-1][i]=M1[(int)(filas/2)][i];
                    M1[(int)(filas/2)][i]=Cam;
                }
                
                for (int i = 0; i < 3; i++) {
                    Cam=M2[0][i];
                    M2[0][i]=M2[1][i];
                    M2[1][i]=Cam;
                    
                    Cam=M2[1][i];
                    M2[1][i]=M2[filas-1][i];
                    M2[filas-1][i]=Cam;
                    
                    Cam=M2[filas-1][i];
                    M2[filas-1][i]=M2[(int)(filas/2)][i];
                    M2[(int)(filas/2)][i]=Cam;
                }
                
                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < 3; j++) {
                        MT[i][j]=M1[i][j];
                    }
                    int d=0;
                    for (int j = 3; j < 6; j++) {
                        MT[i][j]=M2[i][d];
                        d++;
                        }
                }
            }
            
            con=0;
            int co1=0,co2=0,a4=0,b4=0,b5=3;
            while(con<1){
                if (a1>=filas || a2>=filas) {break;}
                for (int i = 0; i < filas; i++) {
                    if (co2==3) {break; }
                    for (int j = 3; j < 6; j++) {
                        if (MT[i][j]==0) {co1++;}
                    }
                        if (co1==3) {co1=0;}else{
                            while(a4<3){
                                co1=0;
                                MF1[a4][b4]=(int)MT[i][b5];
                                a4++;
                                b5++;
                            }
                            co2++;
                            a4=0;b5=3;b4++;
                        }
                }
                con++;
            }
            
            if (a1>=filas || a2>=filas) {
                    System.out.println(verde+"Vuelva ingresar el número 3 en la consola"+negro);
            }else{
                for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    MF2[i][j]=MF1[j][i];
                }
            }
            
            System.out.println("Matriz Clave "+verde+"A"+negro+"===================================");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print("|\t"+MF1[i][j]+"\t");
                }
                System.out.print("|\n");
            }
            }
        } catch (Exception e) {
            System.out.println(rojo+"Error al calcular la clave"+negro+e);
        }
    }
    
    static int modulo(int a){
        int mod=a%27;
        if (mod<0) {
            mod=mod+27;
        }
        return mod;
    }
    static int moduloinverso(int n){;
                        int mod=27,a=0,b=0,a2 = 1, a1 = 0, b2 = 0, b1 = 1,inv=0;
                        int q = 0, r = 0;
                        double div=mod;
                        
                        while(div>0){
                            q = (int)Math.floor(n/div);
                            r = (int)(n%div);
                            a = (int)(a2-q*a1);
                            b = (int)(b2 - q*b1);
                            n =(int) div;
                            div = r;
                            a2 = a1;
                            a1 = a;
                            b2 = b1;
                            b1 = b;
                        }
                        if(n>1){
                            return 0;
                        }else{
                        if (a2<0) {
                            inv=(int)(a2+mod);
                        }else{
                            inv=(int)(a2);
                        }
                        }
        
        return inv;
    }
}
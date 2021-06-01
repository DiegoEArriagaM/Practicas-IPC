/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg1.lab.ipc1;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Diego
 */
public class desencriptador {
    //Colores de texto
       static String verde="\033[32m";
       static String cyan="\033[36m"; 
       static String negro="\033[30m";
       static String rojo="\033[31m";
       static String amar="\033[33m";
        //----------------------
       
    static Scanner sc=new Scanner(System.in);
    static String op,mensaje[], Mf[][];
    static double mb, M2[][], A2[][]=new double[3][3],Ai[][]=new double[3][3], 
            B2[][],Ri[][], Rf2[][];
    public static int colum;
       
    public static void menu(){
        int cont=1;
        while(cont>0){
            System.out.println("============="+verde+"Menu "+cyan+"Desrncriptar"+negro+"=============");
            System.out.println("|"+amar+" 1."+verde+" Ingreso "+negro+"Mensaje Cifrado               |");
            System.out.println("|"+amar+" 2."+verde+" Ingreso Matriz Clave "+negro+"A                |");
            System.out.println("|"+amar+" 3."+verde+" Ingreso Matriz Clave "+negro+"B                |");
            System.out.println("|"+amar+" 4."+negro+" Desencriptar                          |");
            System.out.println("|"+amar+" 5."+cyan+" Regresar"+negro+" al Menú Principal            |");
            System.out.println("===========================================");
            System.out.print("Ingrese el número de acción que quiere realizar: ");
            op=sc.nextLine();System.out.println();
            
            switch(op){
                case "1":
                    mensaje();
                    break;
                case "2":
                    claveA();
                    break;
                case "3":
                    claveB();
                    break;
                case "4":
                    desencriptar();
                    break;
                case "5":
                    cont--;
                    break;
                default:
                        System.out.println(rojo+"ERROR. Asegurese que el dígito ingresado sea 1, 2, 3 o 4"+negro);
                        break;
            }
    }
  }
    
    public static void mensaje(){
        try{
        System.out.println(verde+"Ingrese"+negro+" el mensaje cifrado. "+cyan+"Separe "+negro
                + "los números con un espacio en "+cyan+"blanco"+negro+":");
        op=sc.nextLine();
        mensaje=op.split(" ");
        mb=mensaje.length;
        colum=(int)Math.ceil(mb/3);
        M2=new double[3][colum];
        
        int c=0;
        for (int b = 0; b < colum; b++) {
            for (int a = 0; a < 3; a++) {
                M2[a][b]=Double.parseDouble(mensaje[c]);
                c++;
                if (c==mb) {break;}
            }
                if (c==mb) {break;}
        }
        
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < colum; b++) {
                System.out.print("|\t"+M2[a][b]+"\t");
            }
            System.out.print("|"+"\n");
        }
        }catch(Exception e){
            System.out.println(rojo+"Asegurese de ingresar numeros enteros"+negro);
        }
    }
    
    public static void claveA(){
        try{
        for (int a = 0; a < 3; a++) {
                for (int b = 0; b < 3; b++) {
                    A2[a][b]=27;
                }
            }
       System.out.println("Ingrese la ruta en la que se encuentra el archivo .txt");
        System.out.println(verde+"Ejemplo: C:\\Users\\Diego\\Desktop\\Clave_A.txt"+negro);
        File archivo=new File(sc.nextLine());
        FileReader archivoG=new FileReader(archivo);
        BufferedReader lectura=new BufferedReader(archivoG);
        String codigo;
        String[] mensaje=new String[9];
        int c=0;
            while ((codigo=lectura.readLine())!=null) {                
                mensaje=codigo.split(",");
                for (int b = 0; b < 3; b++) {
                    A2[c][b]=Integer.parseInt(mensaje[b]);
                }
                c++;
            }
        System.out.println("Matriz "+verde+"A"+negro);
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                System.out.print("|\t"+A2[a][b]+"\t");
            }
            System.out.print("|"+"\n");
        }
        System.out.print("\n");
        inversa();
        }catch(Exception e){
            System.out.println(rojo+"Asegurese de ingresar un valor numerico entero en la matriz A"+negro);
        }
    }
    
    public static void claveB(){
        try{
        B2=new double[3][colum];
            for (int a = 0; a < 3; a++) {
                for (int b = 0; b < colum; b++) {
                    B2[a][b]=27;
                }
            }
        System.out.println("Ingrese la ruta en la que se encuentra el archivo .txt");
        System.out.println(verde+"Ejemplo: C:\\Users\\Diego\\Desktop\\Clave_B.txt"+negro);
        System.out.println("Asegurese que la cantidad de numeros que tiene el archivo no sea menor de "+(int)mb+".\n"
                + "En caso de que no sea así es probable que exista problemas al momento de\n"
                + "encriptar el mensaje");
        
        File archivo=new File(sc.nextLine());
        FileReader archivoG=new FileReader(archivo);
        BufferedReader lectura=new BufferedReader(archivoG);
        String codigo; 
        String[] mensaje=new String[(int)mb];
        int c=0;
            while ((codigo=lectura.readLine())!=null) {                
                mensaje=codigo.split(",");
                for (int b = 0; b < colum; b++) {
                    B2[c][b]=Integer.parseInt(mensaje[b]);
                }
                c++;
            }
        System.out.println("Matriz "+verde+"B"+negro);
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < colum; b++) {
                System.out.print("|\t"+B2[a][b]+"\t");
            }
                System.out.print("|\n");
        }
        }catch(Exception e){
            System.out.println(rojo+"Asegurese de ingresar un valor numerico entero en la matriz B"+negro);
        }
    }
    
    public static void inversa(){
        try {
        double detA2=1/(((A2[0][0]*A2[1][1]*A2[2][2])+(A2[1][0]*A2[2][1]*A2[0][2])+(A2[2][0]*A2[0][1]*A2[1][2]))
                -((A2[0][2]*A2[1][1]*A2[2][0])+(A2[1][2]*A2[2][1]*A2[0][0])+(A2[2][2]*A2[0][1]*A2[1][0])));
        
         Ai[0][0]=detA2*((A2[1][1]*A2[2][2])-(A2[1][2]*A2[2][1]));
         Ai[0][1]=detA2*((A2[0][2]*A2[2][1])-(A2[0][1]*A2[2][2]));
         Ai[0][2]=detA2*((A2[0][1]*A2[1][2])-(A2[0][2]*A2[1][1]));
         Ai[1][0]=detA2*((A2[1][2]*A2[2][0])-(A2[1][0]*A2[2][2]));
         Ai[1][1]=detA2*((A2[0][0]*A2[2][2])-(A2[0][2]*A2[2][0]));
         Ai[1][2]=detA2*((A2[0][2]*A2[1][0])-(A2[0][0]*A2[1][2]));
         Ai[2][0]=detA2*((A2[1][0]*A2[2][1])-(A2[1][1]*A2[2][0]));
         Ai[2][1]=detA2*((A2[0][1]*A2[2][0])-(A2[0][0]*A2[2][1]));
         Ai[2][2]=detA2*((A2[0][0]*A2[1][1])-(A2[0][1]*A2[1][0]));
         
         System.out.println("Matriz Inversa "+verde+"A"+negro);
             for (int a = 0; a < 3; a++) {
                for (int b = 0; b < 3; b++) {
                 System.out.print("|\t"+Ai[a][b]+"\t");
                }
                System.out.print("|"+"\n");
            }
        } catch (Exception e) {
            System.out.println(rojo+"ERROR al calcular la inversa");
        }
        }
    
    public static void desencriptar(){
        try {
         Ri=new double[3][colum];
         int Ab=0,Ma,Mb=0;
         
         //M-B
         for (int a = 0; a < 3; a++) {
            for (int b = 0; b < colum; b++) {
                Ri[a][b]=M2[a][b]-B2[a][b];
            }
        }
         //Ai*(M-B)
         Rf2=new double[3][colum];
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < colum; b++) {
                Ma=0;
                Rf2[a][b]=Math.round((Ai[a][Ab]*Ri[Ma][Mb])+(Ai[a][Ab+1]*Ri[Ma+1][Mb])+(Ai[a][Ab+2]*Ri[Ma+2][Mb]));
                Mb++;
            }
            Mb=0;
        }
        
        Mf=new String[3][colum];
        
        for (int b = 0; b< colum; b++) {
            for (int a = 0; a < 3; a++) {
                if (Rf2[a][b]==0) {Mf[a][b]="A";}
                else if (Rf2[a][b]==1) {Mf[a][b]="B";}
                else if (Rf2[a][b]==2) {Mf[a][b]="C";}
                else if (Rf2[a][b]==3) {Mf[a][b]="D";}
                else if (Rf2[a][b]==4) {Mf[a][b]="E";}
                else if (Rf2[a][b]==5) {Mf[a][b]="F";}
                else if (Rf2[a][b]==6) {Mf[a][b]="G";}
                else if (Rf2[a][b]==7) {Mf[a][b]="H";}
                else if (Rf2[a][b]==8) {Mf[a][b]="I";}
                else if (Rf2[a][b]==9) {Mf[a][b]="J";}
                else if (Rf2[a][b]==10) {Mf[a][b]="K";}
                else if (Rf2[a][b]==11) {Mf[a][b]="L";}
                else if (Rf2[a][b]==12) {Mf[a][b]="M";}
                else if (Rf2[a][b]==13) {Mf[a][b]="N";}
                else if (Rf2[a][b]==14) {Mf[a][b]="Ñ";}
                else if (Rf2[a][b]==15) {Mf[a][b]="O";}
                else if (Rf2[a][b]==16) {Mf[a][b]="P";}
                else if (Rf2[a][b]==17) {Mf[a][b]="Q";}
                else if (Rf2[a][b]==18) {Mf[a][b]="R";}
                else if (Rf2[a][b]==19) {Mf[a][b]="S";}
                else if (Rf2[a][b]==20) {Mf[a][b]="T";}
                else if (Rf2[a][b]==21) {Mf[a][b]="U";}
                else if (Rf2[a][b]==22) {Mf[a][b]="V";}
                else if (Rf2[a][b]==23) {Mf[a][b]="W";}
                else if (Rf2[a][b]==24) {Mf[a][b]="X";}
                else if (Rf2[a][b]==25) {Mf[a][b]="Y";}
                else if (Rf2[a][b]==26) {Mf[a][b]="Z";}
                else{Mf[a][b]=" ";}
            }
        }
        
        System.out.println("============="+verde+"Menu "+cyan+"Desencriptar"+negro+"=============");
        System.out.println("| "+verde+"Mensaje Descifrado "+cyan+"es :"+negro+"                 |");
        for (int b = 0; b < colum; b++) {
            for (int a = 0; a < 3; a++) {
                System.out.print(Mf[a][b]);
            }
        }
        System.out.print("\n");
        } catch (Exception e) {
            System.out.println(rojo+"ERROR al desencriptar el mensaje");
        }
    }
}
    

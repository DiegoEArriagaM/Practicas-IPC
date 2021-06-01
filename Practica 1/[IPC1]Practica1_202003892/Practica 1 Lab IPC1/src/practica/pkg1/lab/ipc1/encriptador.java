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
public class encriptador {
    
//Colores de texto
       static String verde="\033[32m";
       static String cyan="\033[36m"; 
       static String negro="\033[30m";
       static String rojo="\033[31m";
       static String amar="\033[33m";
        //----------------------
    static Scanner sc=new Scanner(System.in);
    static String op;
    static String[] caracterS;
    static double mb;
    public static int colum,caracterI[],M[][], A[][]=new int[3][3], B[][],Ri[][], Rf[][];
    
    //Metodo principal de la clase
    public static void menu(){
        int cont=1;
        while(cont>0){
            System.out.println("=============="+verde+"Menu "+cyan+"Encriptar"+negro+"===============");
            System.out.println("|"+amar+" 1."+verde+" Ingreso "+negro+"Mensaje                       |");
            System.out.println("|"+amar+" 2."+verde+" Ingreso Matriz Clave "+negro+"A                |");
            System.out.println("|"+amar+" 3."+verde+" Ingreso Matriz Clave "+negro+"B                |");
            System.out.println("|"+amar+" 4."+negro+" Encriptar                             |");
            System.out.println("|"+amar+" 5."+cyan+" Regresar"+negro+" al Menú Principal            |");
            System.out.println("===========================================");
            System.out.print("Ingrese el número de acción que quiere realizar: ");
            op=sc.nextLine();System.out.println();
            
            switch(op){
                case "1":
                    matrizM();
                    break;
                    
                case "2":
                    claveA();
                    break;
                    
                case "3":
                    claveB();
                    break; 
                    
                case "4":
                    encriptar();
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
    //Creador de matriz M
    private static void matrizM(){
        try{
        System.out.print(verde+"Ingrese "+negro+"mensaje a encriptar (Sin tildes): ");
                    op=sc.nextLine();System.out.println();
                    mb=op.length();
                    colum=(int)Math.ceil(mb/3);
                    M=new int[3][colum];
                    caracterS=op.split("");
                    caracterI=new int[(int)mb];
                    int c=0,d=0;
                    
                    //Convertir cadena de caracteres en numeros
                    while(c<mb){
                        if (caracterS[c].equals("A") || caracterS[c].equals("a")) {caracterI[c]=0;}
                        else if (caracterS[c].equals("B") || caracterS[c].equals("b")) {caracterI[c]=1;}
                        else if (caracterS[c].equals("C") || caracterS[c].equals("c")) {caracterI[c]=2;}
                        else if (caracterS[c].equals("D") || caracterS[c].equals("d")) {caracterI[c]=3;}
                        else if (caracterS[c].equals("E") || caracterS[c].equals("e")) {caracterI[c]=4;}
                        else if (caracterS[c].equals("F") || caracterS[c].equals("f")) {caracterI[c]=5;}
                        else if (caracterS[c].equals("G") || caracterS[c].equals("g")) {caracterI[c]=6;}
                        else if (caracterS[c].equals("H") || caracterS[c].equals("h")) {caracterI[c]=7;}
                        else if (caracterS[c].equals("I") || caracterS[c].equals("i")) {caracterI[c]=8;}
                        else if (caracterS[c].equals("J") || caracterS[c].equals("j")) {caracterI[c]=9;}
                        else if (caracterS[c].equals("K") || caracterS[c].equals("k")) {caracterI[c]=10;}
                        else if (caracterS[c].equals("L") || caracterS[c].equals("l")) {caracterI[c]=11;}
                        else if (caracterS[c].equals("M") || caracterS[c].equals("m")) {caracterI[c]=12;}
                        else if (caracterS[c].equals("N") || caracterS[c].equals("n")) {caracterI[c]=13;}
                        else if (caracterS[c].equals("Ñ") || caracterS[c].equals("ñ")) {caracterI[c]=14;}
                        else if (caracterS[c].equals("O") || caracterS[c].equals("o")) {caracterI[c]=15;}
                        else if (caracterS[c].equals("P") || caracterS[c].equals("p")) {caracterI[c]=16;}
                        else if (caracterS[c].equals("Q") || caracterS[c].equals("q")) {caracterI[c]=17;}
                        else if (caracterS[c].equals("R") || caracterS[c].equals("r")) {caracterI[c]=18;}
                        else if (caracterS[c].equals("S") || caracterS[c].equals("s")) {caracterI[c]=19;}
                        else if (caracterS[c].equals("T") || caracterS[c].equals("t")) {caracterI[c]=20;}
                        else if (caracterS[c].equals("U") || caracterS[c].equals("u")) {caracterI[c]=21;}
                        else if (caracterS[c].equals("V") || caracterS[c].equals("v")) {caracterI[c]=22;}
                        else if (caracterS[c].equals("W") || caracterS[c].equals("w")) {caracterI[c]=23;}
                        else if (caracterS[c].equals("X") || caracterS[c].equals("x")) {caracterI[c]=24;}
                        else if (caracterS[c].equals("Y") || caracterS[c].equals("y")) {caracterI[c]=25;}
                        else if (caracterS[c].equals("Z") || caracterS[c].equals("z")) {caracterI[c]=26;}
                        else{caracterI[c]=27;}
                        c++;
                    }
                    //Poner a todos los arreglos de la matriz el mismo valor. 27
                    for (int b = 0; b < colum; b++) {
                        for (int a = 0; a < 3; a++) {
                            M[a][b]=27;
                        }
                    }
                    
                    //Pasar la los caracteres a la matriz M
                    for (int b = 0; b < colum; b++) {
                        for (int a = 0; a < 3; a++) {
                            M[a][b]=caracterI[d];
                            d++;
                            if(d==mb){break;}
                        }
                        if(d==mb){break;}
                    }
                    
                    System.out.println("El mensaje"+verde+" transformado"+negro+" es:");
                    for (int a = 0; a < 3; a++) {
                        for (int b = 0; b < colum; b++) {
                            System.out.print("|\t"+M[a][b]+"\t");
                        }
                        System.out.print("|\n");
                    }
                    System.out.println("\n");
        }catch(Exception e){
            System.out.println(rojo+e+negro);
        }
    }
    
    //Ingreso de la matriz Clave A y B
    private static void claveA(){
        for (int a = 0; a < 3; a++) {
                for (int b = 0; b < 3; b++) {
                    A[a][b]=27;
                }
            }
        try{
        System.out.println("Ingrese la ruta en la que se encuentra el archivo .txt");
        System.out.println(verde+"Ejemplo: C:\\Users\\Diego\\Desktop\\Clave_A.txt"+negro);
        File archivo=new File(sc.nextLine());
        FileReader archivoG=new FileReader(archivo);
        BufferedReader lectura=new BufferedReader(archivoG);
        String codigo;
        String[] mensaje;
        int c=0;
            while ((codigo=lectura.readLine())!=null) {                
                mensaje=codigo.split(",");
                for (int b = 0; b < 3; b++) {
                    A[c][b]=Integer.parseInt(mensaje[b]);
                }
                c++;
            }
        System.out.println("Matriz "+verde+"A"+negro);
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                System.out.print("|\t"+A[a][b]+"\t");
            }
                System.out.print("|\n");
        }
        System.out.print("|\n");
        }catch(Exception e){
            System.out.println(rojo+"ERROR al ingresar el archivo"+negro);
        }
    }
    
    private static void claveB(){
        B=new int[3][colum];
            for (int a = 0; a < 3; a++) {
                for (int b = 0; b < colum; b++) {
                    B[a][b]=27;
                }
            }
        try{
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
                    B[c][b]=Integer.parseInt(mensaje[b]);
                }
                c++;
            }
        System.out.println("Matriz "+verde+"B"+negro);
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < colum; b++) {
                System.out.print("|\t"+B[a][b]+"\t");
            }
                System.out.print("|\n");
        }
        }catch(Exception e){
            System.out.println(rojo+"ERROR al ingresar el archivo"+negro);
        }
    }
    
    //Encriptar
    private static void encriptar(){
        try {
        Ri=new int[3][colum];int Ab=0,Ma,Mb=0;
        Rf=new int[3][colum];
        //A*M
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < colum; b++) {
                Ma=0;
                Ri[a][b]=(A[a][Ab]*M[Ma][Mb])+(A[a][Ab+1]*M[Ma+1][Mb])+(A[a][Ab+2]*M[Ma+2][Mb]);
                Mb++;
            }
            Mb=0;
        }
        
        //A*M + B
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < colum; b++) {
                Rf[a][b]=Ri[a][b]+B[a][b];
            }
        }
        
        System.out.println("=============="+verde+"Menu "+cyan+"Encriptar"+negro+"===============");
        System.out.println("| "+verde+"Mensaje Cifrado "+cyan+"es :"+negro+"                    |");
        for (int b = 0; b < colum; b++) {
            for (int a = 0; a < 3; a++) {
                System.out.print(" "+Rf[a][b]+" ");
            }
        }
        System.out.println("\n"+"| "+verde+"Matriz del Mensaje Cifrado "+cyan+"es :"+negro+"         |");
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < colum; b++) {
                System.out.print("|\t"+Rf[a][b]+"\t");
            }
            System.out.print("|\n");
        }
        System.out.println(negro+"==========================================="+"\n");
     
            
        } catch (Exception e) {
            System.out.println(rojo+"ERROR al incriptar"+negro);
        }   
    }
}

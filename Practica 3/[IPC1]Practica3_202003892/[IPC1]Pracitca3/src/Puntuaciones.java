import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Puntuaciones implements Serializable{
    //Se crean las variables que serviran para guardar los puntajes
    static int cont=0,puntuacion[]=new int[cont];
    static String apodo[]=new String[cont];
    //Constructor
    public Puntuaciones() {
    }
    
    //Metodo que se encarga de 
    public void nuevopuntaje(String nombre,int pt){
        if (cont==0) {
            cont++;
            puntuacion=new int[cont];
            apodo=new String[cont];
            puntuacion[cont-1]=pt;
            apodo[cont-1]=nombre;
        }else{
            //Se guardan los valores antiguos
            String ap[]=apodo;
            int puntu[]=puntuacion,con=cont;
            //Se actualizan los arreglos
            cont++;
            puntuacion=new int[cont];
            apodo=new String[cont];
            for (int i = 0; i < con; i++) {
                apodo[i]=ap[i];
                puntuacion[i]=puntu[i];
            }
            apodo[con]=nombre;
            puntuacion[con]=pt;
        }
    }
    
    
    //Getters y Setters

    public static int getCont() {
        return cont;
    }

    public static int[] getPuntuacion() {
        return puntuacion;
    }

    public static String[] getApodo() {
        return apodo;
    }

    public static void setCont(int cont) {
        Puntuaciones.cont = cont;
    }

    public static void setPuntuacion(int[] puntuacion) {
        Puntuaciones.puntuacion = puntuacion;
    }

    public static void setAcronimo(String[] apodo) {
        Puntuaciones.apodo = apodo;
    }
    
}

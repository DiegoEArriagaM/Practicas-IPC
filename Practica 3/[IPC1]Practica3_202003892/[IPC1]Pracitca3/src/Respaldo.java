import java.io.Serializable;


public class Respaldo implements Serializable{
    //Se llama a la clase con las puntuaciones
    Puntuaciones puntuaciones=new Puntuaciones();
    //Se crean las variables que serviran para guardar los puntajes
    private int cont=0,puntuacion[]=new int[cont];
    private String apodo[]=new String[cont];
    
    //Constructor
    public Respaldo() {
        this.cont=puntuaciones.cont;
        this.puntuacion=puntuaciones.puntuacion;
        this.apodo=puntuaciones.apodo;
    }
    
    //Getters

    public int getCont() {
        return cont;
    }

    public int[] getPuntuacion() {
        return puntuacion;
    }

    public String[] getApodo() {
        return apodo;
    }
    
}

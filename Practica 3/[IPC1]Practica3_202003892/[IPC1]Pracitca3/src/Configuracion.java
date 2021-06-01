
public class Configuracion {
    
    static  int tiempo=90,movimiento=10,frecuencia=10000, puntos=0,derrotatipo1=0,
            derrotatipo2=0,derrotatipo3=0;
    //Para determinar si los objetos aparezcan o no
    static boolean mastiempo=false,ptextras=false,masvelocidad=false,menostiempo=false,
                    penalizacion=false,congelacion=false,derota=false;
    
    public Configuracion() {
    }
    
    //Setters
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public static void setMovimiento(int movimiento) {
        Configuracion.movimiento = movimiento;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }
  
}

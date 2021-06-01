import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MovimientoNave extends JFrame implements Runnable{
    //Se importa la clase con la configuración del juego
     Configuracion config=new Configuracion();
    //Label que guarda la imagen del juego
    JLabel lnave=new JLabel();
    //Variable de la posición en y de la nave
    static int y=280;
    double movimiento=config.movimiento;
    boolean a=true;
    
    
    //Metodo para crear la nave en java
    @Override
    public void run() {
        while(a){
            lnave.setBounds(10,y, 45,45);
            ImageIcon img=new ImageIcon("nave.png");
            Icon icono1=new  ImageIcon(img.getImage().getScaledInstance(lnave.getWidth(), lnave.getHeight(), Image.SCALE_DEFAULT));
            lnave.setIcon(icono1);
        }
    }
    //Metodo en caso que el jugador pierda
    public void derrota(){
        lnave.setBounds(10,y, 45,45);
        ImageIcon img=new ImageIcon("explosion.png");
        Icon icono1=new  ImageIcon(img.getImage().getScaledInstance(lnave.getWidth(), lnave.getHeight(), Image.SCALE_DEFAULT));
        lnave.setIcon(icono1);
        
    }
    //Metodo para darle una configuración de posición al label
    public void setLnave(JLabel lnave) {
        this.lnave = lnave;
    }
    
    //Dar nuevo valor en y
    public void sumaY(int y) {
        this.y +=y;
    }
    
}

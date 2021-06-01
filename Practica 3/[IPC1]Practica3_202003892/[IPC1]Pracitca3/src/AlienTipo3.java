
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class AlienTipo3 extends JFrame implements Runnable{
    //Se importa la clase con la configuración del juego
    Configuracion config=new Configuracion();
    JLabel label=new JLabel();
    int posicionx=625,posiciony,movimiento=config.movimiento,
            desplazamientoy=21,vida=4,x=posicionx;
    @Override
    public void run() {
        x=posicionx;
         while (x>=55) {            
            //Se comprueba la vida del alien
            if (vida<=0) {
                config.puntos+=30;
                config.derrotatipo3++;
                break;
            }
            //Mover el label en y
            posiciony+=desplazamientoy;
            label.setBounds(x,posiciony, 45,45);
            ImageIcon img=new ImageIcon("alien3.png");
            Icon icono1=new  ImageIcon(img.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
            label.setIcon(icono1); 
            //Se cambia la direccion que se movera en y
            desplazamientoy*=-1;
            //Tiempo de espara antes de volver a moverse
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(AlienTipo3.class.getName()).log(Level.SEVERE, null, ex);
            }
            x-=movimiento;
        }
        //En caso de que derrotaran al alien
        if (vida<=0) {
            label.setBounds(x,posiciony, 45,45);
            ImageIcon img=new ImageIcon("explosion.png");
            Icon icono1=new  ImageIcon(img.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
            label.setIcon(icono1);
            try {
                //Tiempo de espera
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(AlienTipo2.class.getName()).log(Level.SEVERE, null, ex);
            }
            label.setBounds(1200,1200, 45,45); 
            label.setText("");
            label.setIcon(null);
        }
        //En caso de que el alien haya llegado al final
        if (x<=55) {
            config.derota=true;
        }
    }
    //Setters

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public void setPosicionx(int posicionx) {
        this.posicionx = posicionx;
    }

    public void setPosiciony(int posiciony) {
        this.posiciony = posiciony;
    }

    public void setMovimiento(int movimiento) {
        this.movimiento = movimiento;
    }
    
}

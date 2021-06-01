
import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego
 */
public class Juego extends javax.swing.JFrame {
    //Se llama al menu de inicio
    Menu_Principal menu=new Menu_Principal();
    //Se manda a llamar la clase con la configuración del juego y listado de puntaje
    Configuracion config=new Configuracion();
    Puntuaciones puntuaciones=new Puntuaciones();
    Respaldo respaldo=new Respaldo();
    //Se manda a llamar las clases que contienen los hilos necesarios
    MovimientoNave mn=new MovimientoNave();
    AlienTipo1 atipo1[]=new AlienTipo1[8];
    AlienTipo2 atipo2[]=new AlienTipo2[16];
    AlienTipo3 atipo3[]=new AlienTipo3[16];
    //Arreglos de hilos para los tipos de alien
    Thread htipo1[]=new Thread[8], htipo2[]=new Thread[16], htipo3[]=new Thread[16];
   
    
    //Variables que reciben el valor de la configuracion
    int frecuencia=config.frecuencia,puntos=config.puntos,movimiento=config.movimiento,
        movimientonave=config.movimiento,tiempo_ex;
    //Clase para la apararicion de objetos
    class Aparicion_Objetos implements Runnable{
        //Posiciones X y Y de los 6 objetos
        int x1,y1;
        int tiempo=config.tiempo;
        @Override
        public void run() {
            while (tiempo>0) {   
                //Variable para la aparición random de un objeto
                int c=(int)(Math.random()*(6-1+1)+1);
                //Condicional para que salga el que da mas tiempo
                if (config.mastiempo==true && c==1) {
                    //Se dan un valor random a la posicion inicial del obeto
                    x1=(int)(Math.random()*(900-300+1)+300);
                    y1=(int)(Math.random()*(515-50+1)+50);
                    //Movimiento del item
                    while (x1>-65) {                        
                        int a=Math.abs((x1+45)-55),
                        b=Math.abs((y1+45)-(mn.y+45));
                        if ((0 <= a && a< 45) && (0 <= b && b< 45)) {
                            tiempo+=10;
                            Litem.setIcon(null);
                            break;
                        }
                        //Se le da una posicion y una imagen al objeto
                        Litem.setBounds(x1,y1, 45,45);
                        ImageIcon img=new ImageIcon("mastiempo.png");
                        Icon icono1=new  ImageIcon(img.getImage().getScaledInstance(Litem.getWidth(), Litem.getHeight(), Image.SCALE_DEFAULT));
                        Litem.setIcon(icono1);
                        //Se mueve al objeto
                        x1-=movimiento;
                        //Se espera para que se vuelva a mover el objeto
                        try {                        
                            Thread.sleep(300);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    Litem.setIcon(null);
                    //Tiempo de espera para el siguiente item
                    try {
                        Thread.sleep(frecuencia);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                //Condicional para que salga el que da mas puntos
                if (config.ptextras==true && c==2) {
                    //Se dan un valor random a la posicion inicial del obeto
                    x1=(int)(Math.random()*(900-300+1)+300);
                    y1=(int)(Math.random()*(515-50+1)+50);
                    //Movimiento del item
                    while (x1>-65) {                        
                        int a=Math.abs((x1+45)-55),
                        b=Math.abs((y1+45)-(mn.y+45));
                        if ((0 <= a && a< 45) && (0 <= b && b< 45)) {
                            puntos+=10;
                            Litem.setIcon(null);
                            break;
                        }
                        //Se le da una posicion y una imagen al objeto
                        Litem.setBounds(x1,y1, 45,45);
                        ImageIcon img=new ImageIcon("maspuntos.png");
                        Icon icono1=new  ImageIcon(img.getImage().getScaledInstance(Litem.getWidth(), Litem.getHeight(), Image.SCALE_DEFAULT));
                        Litem.setIcon(icono1);
                        //Se mueve al objeto
                        x1-=movimiento;
                        //Se espera para que se vuelva a mover el objeto
                        try {                        
                            Thread.sleep(300);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    Litem.setIcon(null);
                    //Tiempo de espera para el siguiente item
                    try {
                        Thread.sleep(frecuencia);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                //Condicional para que salga el que aumenta la velocidad
                if (config.masvelocidad==true && c==3) {
                    //Se dan un valor random a la posicion inicial del obeto
                    x1=(int)(Math.random()*(900-300+1)+300);
                    y1=(int)(Math.random()*(515-50+1)+50);
                    //Movimiento del item
                    while (x1>-65) {                        
                        int a=Math.abs((x1+45)-55),
                        b=Math.abs((y1+45)-(mn.y+45));
                        if ((0 <= a && a< 45) && (0 <= b && b< 45)) {
                            movimientonave+=10;
                            Litem.setIcon(null);
                            break;
                        }
                        //Se le da una posicion y una imagen al objeto
                        Litem.setBounds(x1,y1, 45,45);
                        ImageIcon img=new ImageIcon("velocidad.png");
                        Icon icono1=new  ImageIcon(img.getImage().getScaledInstance(Litem.getWidth(), Litem.getHeight(), Image.SCALE_DEFAULT));
                        Litem.setIcon(icono1);
                        //Se mueve al objeto
                        x1-=movimiento;
                        //Se espera para que se vuelva a mover el objeto
                        try {                        
                            Thread.sleep(300);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    Litem.setIcon(null);
                    //Tiempo de espera para el siguiente item
                    try {
                        Thread.sleep(frecuencia);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                //Condicional para que salga el que reduzca el tiempo
                if (config.menostiempo==true && c==4) {
                    //Se dan un valor random a la posicion inicial del obeto
                    x1=(int)(Math.random()*(900-300+1)+300);
                    y1=(int)(Math.random()*(515-50+1)+50);
                    //Movimiento del item
                    while (x1>-65) {                        
                        int a=Math.abs((x1+45)-55),
                        b=Math.abs((y1+45)-(mn.y+45));
                        if ((0 <= a && a< 45) && (0 <= b && b< 45)) {
                            tiempo-=10;
                            Litem.setIcon(null);
                            break;
                        }
                        //Se le da una posicion y una imagen al objeto
                        Litem.setBounds(x1,y1, 45,45);
                        ImageIcon img=new ImageIcon("menostiempo.png");
                        Icon icono1=new  ImageIcon(img.getImage().getScaledInstance(Litem.getWidth(), Litem.getHeight(), Image.SCALE_DEFAULT));
                        Litem.setIcon(icono1);
                        //Se mueve al objeto
                        x1-=movimiento;
                        //Se espera para que se vuelva a mover el objeto
                        try {                        
                            Thread.sleep(300);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    Litem.setIcon(null);
                    //Tiempo de espera para el siguiente item
                    try {
                        Thread.sleep(frecuencia);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                //Condicional para que el que reduce los puntos
                if (config.penalizacion==true && c==5) {
                    //Se dan un valor random a la posicion inicial del obeto
                    x1=(int)(Math.random()*(900-300+1)+300);
                    y1=(int)(Math.random()*(515-50+1)+50);
                    //Movimiento del item
                    while (x1>-65) {                        
                        int a=Math.abs((x1+45)-55),
                        b=Math.abs((y1+45)-(mn.y+45));
                        //Condicion para ver si los labels se esta tocando
                        if ((0 <= a && a< 45) && (0 <= b && b< 45)) {
                            //Condicion para comprobar que los puntos no queden negativos
                            if (puntos>=10) {
                                puntos-=10; 
                            }else{puntos=0;}
                            Litem.setIcon(null);
                            break;
                        }
                        //Se le da una posicion y una imagen al objeto
                        Litem.setBounds(x1,y1, 45,45);
                        ImageIcon img=new ImageIcon("menospuntos.png");
                        Icon icono1=new  ImageIcon(img.getImage().getScaledInstance(Litem.getWidth(), Litem.getHeight(), Image.SCALE_DEFAULT));
                        Litem.setIcon(icono1);
                        //Se mueve al objeto
                        x1-=movimiento;
                        //Se espera para que se vuelva a mover el objeto
                        try {                        
                            Thread.sleep(300);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    Litem.setIcon(null);
                    //Tiempo de espera para el siguiente item
                    try {
                        Thread.sleep(frecuencia);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                //Condicional para que salga el que congela la nave
                if (config.congelacion==true && c==6) {
                    //Se dan un valor random a la posicion inicial del obeto
                    x1=(int)(Math.random()*(900-300+1)+300);
                    y1=(int)(Math.random()*(515-50+1)+50);
                    //Movimiento del item
                    while (x1>-65) {                        
                        int a=Math.abs((x1+45)-55),
                        b=Math.abs((y1+45)-(mn.y+45));
                        if ((0 <= a && a< 45) && (0 <= b && b< 45)) {
                            ImageIcon img=new ImageIcon("navecongelada.png");
                            Icon icono1=new  ImageIcon(img.getImage().getScaledInstance(labelNave.getWidth(), labelNave.getHeight(), Image.SCALE_DEFAULT));
                            labelNave.setIcon(icono1);
                            Litem.setIcon(null);
                            hilo1.stop();
                            break;
                        }
                        //Se le da una posicion y una imagen al objeto
                        Litem.setBounds(x1,y1, 45,45);
                        ImageIcon img=new ImageIcon("congelacion.png");
                        Icon icono1=new  ImageIcon(img.getImage().getScaledInstance(Litem.getWidth(), Litem.getHeight(), Image.SCALE_DEFAULT));
                        Litem.setIcon(icono1);
                        //Se mueve al objeto
                        x1-=movimiento;
                        //Se espera para que se vuelva a mover el objeto
                        try {                        
                            Thread.sleep(300);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    Litem.setIcon(null);
                    //Tiempo de espera para el siguiente item
                    try {
                        Thread.sleep(5000);
                        mn.setLnave(labelNave);
                        hilo1=new Thread(mn);
                        hilo1.start();
                        Thread.sleep(frecuencia-5000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
    Aparicion_Objetos items=new Aparicion_Objetos();
    
    //Clase para la función de reloj
    class Reloj implements Runnable{
        //Guardar la configuración del tiempo
        int tiempo;
        @Override
        public void run() {
            boolean a=true;
            while (a) {
                tiempo=items.tiempo;
                labelreloj.setText(tiempo+" s");
                tiempo_ex=this.tiempo;
                try {
                    Thread.sleep(1000);
                    items.tiempo+=-1;
                }catch (InterruptedException ex) {
                    Logger.getLogger(Reloj.class.getName()).log(Level.SEVERE, null, ex);
                }
                //En caso de que se acabe el tiempo
                if (tiempo<=0) {
                    a=false;
                }
                labelreloj.setText(tiempo+" s");
            }
            //Se detiene el hilo
            mn.a=false;
            //Se cambia el icono de la nave
            ImageIcon img=new ImageIcon("explosion.png");
            Icon icono1=new  ImageIcon(img.getImage().getScaledInstance(labelNave.getWidth(), labelNave.getHeight(), Image.SCALE_DEFAULT));
            labelNave.setIcon(icono1);
        
            hilo1.stop();
            hilo3.stop();
            hilo4.stop();
            hilo5.stop();
            for (int j = 0; j < 8; j++) {
                        htipo1[j].stop();
                    }
                    for (int j = 0; j < 16; j++) {
                        htipo2[j].stop();
                    }
                    for (int j = 0; j < 16; j++) {
                        htipo3[j].stop();
                    }
            //Se regresa al menú principal
            JOptionPane.showMessageDialog(null,"Se termino el tiempo");
            JOptionPane.showMessageDialog(null, "Su punttuacion es de "+puntos);
            String acronimo=JOptionPane.showInputDialog(null,"Escriba su nombre");
            puntuaciones.nuevopuntaje(acronimo, puntos);
            //Guardar el puntaje
            respaldo=new Respaldo();
            try {
            //Crear documento tipo binario
            ObjectOutputStream oos;
            oos=new ObjectOutputStream(new FileOutputStream("datos.bin"));
            //Se elige la clase que se transformara en el documento binario
            oos.writeObject(respaldo);
            oos.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            //Regresar al menu principal
            menu.setVisible(true);
            System.gc();
            dispose();
        }
    }
    Reloj reloj=new Reloj();
    
    //Disparo de la nave
    //Posiciones que saldra el disparo
    int posicionX,posicionY;
    class DisparoN implements Runnable{
        @Override
        public void run() {
            posicionX=55;posicionY=mn.y+18;
            boolean colision=false;
            //Características del label
            disparo.setText("");
            disparo.setBackground(Color.white);
            disparo.setOpaque(true);
            //Animación del disparo
            while(posicionX<=2000){
                //Comprobar si el disparo coincide con alguno de los aliens tipo 1
                for (int i = 0; i < 8; i++) {
                    //Se comprueba si el hilo del alien aun esta activo
                    if (htipo1[i].isAlive()==true) {
                        int a=Math.abs((atipo1[i].x+45)-(posicionX+15)),
                            b=Math.abs((atipo1[i].posiciony+45)-(posicionY+15));
                        if ((0<a && a<=44) && (0<b && b<44)) {
                            atipo1[i].vida--;
                            colision=true;
                            disparo.setOpaque(false);
                            break;
                        }  
                    }
                    
                }
                //Comprobar si el disparo coincide con alguno de los aliens tipo 2
                for (int i = 0; i < 16; i++) {
                    //Se comprueba si el hilo del alien aun esta activo
                    if (htipo2[i].isAlive()==true) {
                        int a=Math.abs((atipo2[i].x+45)-(posicionX+15)),
                        b=Math.abs((atipo2[i].posiciony+45)-(posicionY+15));
                        if ((0<a && a<44) && (0<b && b<44)) {
                            atipo2[i].vida--;
                            colision=true;
                            disparo.setOpaque(false);
                            break;
                        }
                    }
                    
                }
                //Comprobar si el disparo coincide con alguno de los aliens tipo 3
                for (int i = 0; i < 16; i++) {
                    //Se comprueba si el hilo del alien aun esta activo
                    if (htipo3[i].isAlive()==true) {
                        int a=Math.abs((atipo3[i].x+45)-(posicionX+15)),
                        b=Math.abs((atipo3[i].posiciony+45)-(posicionY+15));
                        if ((0<a && a<44) && (0<b && b<44)) {
                            atipo3[i].vida--;
                            colision=true;
                            disparo.setOpaque(false);
                            break;
                        }
                    }
                    
                }
                
                //Desplazamiento del disparo
                disparo.setBounds(posicionX, posicionY, 15, 15);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                }
                posicionX+=40;
                
                //En caso de que haya colisionado
                if (colision) {
                    break;
                }
            }
        }
        
    }
    //Se inicializa la clase DisparoN
    DisparoN disparoN=new DisparoN();
    
    //Metodo para actualizar los marcadores
    class Actu implements Runnable{

        @Override
        public void run() {
            boolean a=true;
            while(a){
                labelVelocidad.setText(movimiento+" Km/s");
                puntos=config.puntos;
                labelpuntos.setText(puntos+"");
                //Comprobar si los aliens ya llegaron a la tierra
                if (config.derota==true) {
                    //Se cierran los hilo
                    for (int i = 0; i < 8; i++) {
                       htipo1[i].stop();
                    }
                    for (int i = 0; i < 16; i++) {
                       htipo2[i].stop();
                    }
                    for (int i = 0; i < 16; i++) {
                       htipo3[i].stop();
                    }
                    hilo1.stop();
                    hilo2.stop();
                    hilo3.stop();
                    hilo4.stop();
                    
                    ImageIcon img=new ImageIcon("explosion.png");
                    Icon icono1=new  ImageIcon(img.getImage().getScaledInstance(labelNave.getWidth(), labelNave.getHeight(), Image.SCALE_DEFAULT));
                    labelNave.setIcon(icono1);
                    JOptionPane.showMessageDialog(null,"Los aliens llegaron a la tierra\n"
                                                + "FIN de la partida");
                    
                    JOptionPane.showMessageDialog(null, "Su punttuacion es de "+puntos);
                    String acronimo=JOptionPane.showInputDialog(null,"Escriba su nombre");
                    puntuaciones.nuevopuntaje(acronimo, puntos);
                    //Guardar el puntaje
                    respaldo=new Respaldo();
                    try {
                        //Crear documento tipo binario
                        ObjectOutputStream oos;
                        oos=new ObjectOutputStream(new FileOutputStream("datos.bin"));
                        //Se elige la clase que se transformara en el documento binario
                        oos.writeObject(respaldo);
                        oos.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    //Regresar al menu principal
                    a=false;
                    menu.setVisible(true);
                    dispose();
                }
                //Comprobar si ya se derrotaron a todos los enemigos tipo 1
                if (config.derrotatipo1==8) {
                    movimiento+=10;
                    //Dar mayor movimiento a todos los aliens tipo 2 y 3
                    for (int i = 0; i < 16; i++) {
                        atipo2[i].movimiento+=10;
                    }
                    for (int i = 0; i < 16; i++) {
                        atipo3[i].movimiento+=10;
                    }
                    config.derrotatipo1++;
                }
                //Comprobar si ya se derrotaron a todos los enemigos tipo 2
                if (config.derrotatipo2==16) {
                    movimiento+=15;
                    //Dar mayor movimiento a todos los aliens tipo 3
                    for (int i = 0; i < 16; i++) {
                        atipo3[i].movimiento+=15;
                    }
                    config.derrotatipo2++;
                }
                if (config.derrotatipo3==16) {
                    hilo1.stop();
                    hilo2.stop();
                    hilo3.stop();
                    hilo4.stop();
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Reloj reloj=new Reloj();
                    puntos+=tiempo_ex;
                    JOptionPane.showMessageDialog(null, "Gano la partida");
                    JOptionPane.showMessageDialog(null, "Su punttuacion es de "+puntos);
                    String acronimo=JOptionPane.showInputDialog(null,"Escriba su nombre");
                    puntuaciones.nuevopuntaje(acronimo, puntos);
                    //Guardar puntuacion
                    respaldo=new Respaldo();
                    try {
                        //Crear documento tipo binario
                        ObjectOutputStream oos;
                        oos=new ObjectOutputStream(new FileOutputStream("datos.bin"));
                        //Se elige la clase que se transformara en el documento binario
                        oos.writeObject(respaldo);
                        oos.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    //Regresar al menu principal
                    menu.setVisible(true);
                    dispose();
                    config.derrotatipo3++;
                    a=false;
                }
            }
        }
    
    }
    Actu actu=new Actu();
    
    //Hilos que se manejan
    Thread hilo1=new Thread(mn);
    Thread hilo2=new Thread(reloj);
    Thread hilo3=new Thread(disparoN);
    Thread hilo4=new Thread(items);
    Thread hilo5=new Thread(actu);
    
    
    public Juego() {
        initComponents();
        panelJuego.setLayout(null);
        //Se reinician los contadores necesarios
        config.derota=false;
        config.puntos=0;
        config.derrotatipo1=0;
        config.derrotatipo2=0;
        config.derrotatipo3=0;
        //Arreglos que almacenen los labels que corresponden a los aliens, dependiendo al tipo que petenezca
        JLabel tipos1[]={tipo1_1,tipo1_2,tipo1_3,tipo1_4,tipo1_5,tipo1_6,tipo1_7,tipo1_8},
                tipos2[]={tipo2_1,tipo2_2,tipo2_3,tipo2_4,tipo2_5,tipo2_6,tipo2_7,tipo2_8,
                        tipo2_9,tipo2_10,tipo2_11,tipo2_12,tipo2_13,tipo2_14,tipo2_15,tipo2_16},
                tipos3[]={tipo3_1,tipo3_2,tipo3_3,tipo3_4,tipo3_5,tipo3_6,tipo3_7,tipo3_8,
                        tipo3_9,tipo3_10,tipo3_11,tipo3_12,tipo3_13,tipo3_14,tipo3_15,tipo3_16};
        
        //Se llenan los labels para los aliens
        //Tipo 1
            //Posicion y de los aliens tipo 1
            int y=21;
        for (int i = 0; i < 8; i++) {
            //Se instancia la clase
            atipo1[i]=new AlienTipo1();
            atipo1[i].setLabel(
                    tipos1[i]);
            //Posicion y de inicio
            atipo1[i].setPosiciony(y);
            //Posicion que debe tener el siguiente alien
            y+=66;
            
        }
        //Tipo 2
            //Posicion y de los aliens tipo 2
            y=21;
        for (int i = 0; i < 8; i++) {
            //Se instancia la clase
            atipo2[i]=new AlienTipo2();
            atipo2[i].setLabel(
                    tipos2[i]);
            //Posicion X y Y de inicio
            atipo2[i].setPosicionx(1071);
            atipo2[i].setPosiciony(y);
            //Posicion que debe tener el siguiente alien
            y+=66;
        }
            y=21;
        for (int i = 8; i < 16; i++) {
            //Se instancia la clase
            atipo2[i]=new AlienTipo2();
            atipo2[i].setLabel(
                    tipos2[i]);
            //Posicion X y Y de inicio
            atipo2[i].setPosicionx(1128);
            atipo2[i].setPosiciony(y);
            //Posicion que debe tener el siguiente alien
            y+=66;
        }
        //Tipo 3
            //Posicion y de los aliens tipo 3
            y=21;
        for (int i = 0; i < 8; i++) {
            //Se instancia la clase
            atipo3[i]=new AlienTipo3();
            atipo3[i].setLabel(
                    tipos3[i]);
            //Posicion X y Y de inicio
            atipo3[i].setPosicionx(1185);
            atipo3[i].setPosiciony(y);
            //Posicion que debe tener el siguiente alien
            y+=66;
        }
            y=21;
        for (int i = 8; i < 16; i++) {
            //Se instancia la clase
            atipo3[i]=new AlienTipo3();
            atipo3[i].setLabel(
                    tipos3[i]);
            //Posicion X y Y de inicio
            atipo3[i].setPosicionx(1242);
            atipo3[i].setPosiciony(y);
            //Posicion que debe tener el siguiente alien
            y+=66;
        }
        //Se inician los hilos de los aliens
        //Tipo 1
        for (int i = 0; i < 8; i++) {
            htipo1[i]=new Thread(atipo1[i]);
            //Se inicia el hilo
            htipo1[i].start();
        }
        //Tipo 2
        for (int i = 0; i < 16; i++) {
            htipo2[i]=new Thread(atipo2[i]);
            //Se inicia el hilo
            htipo2[i].start();
        }
        //Tipo 3
        for (int i = 0; i < 16; i++) {
            htipo3[i]=new Thread(atipo3[i]);
            //Se inicia el hilo
            htipo3[i].start();
        }
        
        //Se crea el icono de los puntos
        ImageIcon img=new ImageIcon("coin.png");
        Icon icono1=new  ImageIcon(img.getImage().getScaledInstance(labelMoneda.getWidth(), labelMoneda.getHeight(), Image.SCALE_DEFAULT));
        labelMoneda.setIcon(icono1);
        //Se crea el icono del reloj
        img=new ImageIcon("reloj.png");
        icono1=new  ImageIcon(img.getImage().getScaledInstance(labelMoneda.getWidth(), labelMoneda.getHeight(), Image.SCALE_DEFAULT));
        labelReloj.setIcon(icono1);
        
       
       //Se dan las caracterízticas a los labels de los hilos externos
       mn.setLnave(labelNave);
       //Se inicia los hilos necesarios
       hilo1.start();
       hilo2.start();
       hilo4.start();
       hilo5.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelMoneda = new javax.swing.JLabel();
        labelReloj = new javax.swing.JLabel();
        labelreloj = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelVelocidad = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelpuntos = new javax.swing.JLabel();
        panelJuego = new javax.swing.JPanel();
        labelNave = new javax.swing.JLabel();
        disparo = new javax.swing.JLabel();
        Litem = new javax.swing.JLabel();
        tipo1_1 = new javax.swing.JLabel();
        tipo1_2 = new javax.swing.JLabel();
        tipo1_3 = new javax.swing.JLabel();
        tipo1_4 = new javax.swing.JLabel();
        tipo1_5 = new javax.swing.JLabel();
        tipo1_6 = new javax.swing.JLabel();
        tipo1_7 = new javax.swing.JLabel();
        tipo1_8 = new javax.swing.JLabel();
        tipo2_1 = new javax.swing.JLabel();
        tipo2_2 = new javax.swing.JLabel();
        tipo2_3 = new javax.swing.JLabel();
        tipo2_4 = new javax.swing.JLabel();
        tipo2_5 = new javax.swing.JLabel();
        tipo2_6 = new javax.swing.JLabel();
        tipo2_7 = new javax.swing.JLabel();
        tipo2_8 = new javax.swing.JLabel();
        tipo2_9 = new javax.swing.JLabel();
        tipo2_10 = new javax.swing.JLabel();
        tipo2_11 = new javax.swing.JLabel();
        tipo2_12 = new javax.swing.JLabel();
        tipo2_13 = new javax.swing.JLabel();
        tipo2_14 = new javax.swing.JLabel();
        tipo2_15 = new javax.swing.JLabel();
        tipo2_16 = new javax.swing.JLabel();
        tipo3_1 = new javax.swing.JLabel();
        tipo3_2 = new javax.swing.JLabel();
        tipo3_3 = new javax.swing.JLabel();
        tipo3_4 = new javax.swing.JLabel();
        tipo3_5 = new javax.swing.JLabel();
        tipo3_6 = new javax.swing.JLabel();
        tipo3_7 = new javax.swing.JLabel();
        tipo3_8 = new javax.swing.JLabel();
        tipo3_9 = new javax.swing.JLabel();
        tipo3_10 = new javax.swing.JLabel();
        tipo3_11 = new javax.swing.JLabel();
        tipo3_12 = new javax.swing.JLabel();
        tipo3_13 = new javax.swing.JLabel();
        tipo3_14 = new javax.swing.JLabel();
        tipo3_15 = new javax.swing.JLabel();
        tipo3_16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));

        labelMoneda.setText("jLabel1");

        labelReloj.setText("jLabel1");

        labelreloj.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelreloj.setForeground(new java.awt.Color(255, 255, 255));
        labelreloj.setText("jLabel1");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Velocidad");

        labelVelocidad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelVelocidad.setForeground(new java.awt.Color(255, 255, 255));
        labelVelocidad.setText("jLabel2");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Puntos");

        labelpuntos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelpuntos.setForeground(new java.awt.Color(255, 255, 255));
        labelpuntos.setText("jLabel3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelpuntos)
                .addGap(435, 435, 435)
                .addComponent(jLabel1)
                .addGap(76, 76, 76)
                .addComponent(labelVelocidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(labelreloj)
                .addGap(79, 79, 79))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(labelpuntos)
                    .addComponent(jLabel1)
                    .addComponent(labelVelocidad)
                    .addComponent(labelReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelreloj))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        labelMoneda.getAccessibleContext().setAccessibleName("");

        panelJuego.setBackground(new java.awt.Color(0, 0, 0));
        panelJuego.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panelJuegoKeyPressed(evt);
            }
        });

        labelNave.setForeground(new java.awt.Color(255, 255, 255));
        labelNave.setText("dsada");

        disparo.setBackground(new java.awt.Color(255, 255, 255));
        disparo.setText("jLabel3");

        Litem.setText("jLabel3");

        tipo1_1.setBackground(new java.awt.Color(0, 0, 0));
        tipo1_1.setForeground(new java.awt.Color(255, 255, 255));
        tipo1_1.setText("jLabel3");

        tipo1_2.setForeground(new java.awt.Color(255, 255, 255));
        tipo1_2.setText("jLabel3");

        tipo1_3.setForeground(new java.awt.Color(255, 255, 255));
        tipo1_3.setText("jLabel3");

        tipo1_4.setForeground(new java.awt.Color(255, 255, 255));
        tipo1_4.setText("jLabel3");

        tipo1_5.setForeground(new java.awt.Color(255, 255, 255));
        tipo1_5.setText("jLabel3");

        tipo1_6.setForeground(new java.awt.Color(255, 255, 255));
        tipo1_6.setText("jLabel3");

        tipo1_7.setForeground(new java.awt.Color(255, 255, 255));
        tipo1_7.setText("jLabel3");

        tipo1_8.setForeground(new java.awt.Color(255, 255, 255));
        tipo1_8.setText("jLabel3");

        tipo2_1.setBackground(new java.awt.Color(0, 0, 0));
        tipo2_1.setForeground(new java.awt.Color(255, 255, 255));
        tipo2_1.setText("jLabel3");

        tipo2_2.setBackground(new java.awt.Color(0, 0, 0));
        tipo2_2.setForeground(new java.awt.Color(255, 255, 255));
        tipo2_2.setText("jLabel3");

        tipo2_3.setBackground(new java.awt.Color(0, 0, 0));
        tipo2_3.setForeground(new java.awt.Color(255, 255, 255));
        tipo2_3.setText("jLabel3");

        tipo2_4.setBackground(new java.awt.Color(0, 0, 0));
        tipo2_4.setForeground(new java.awt.Color(255, 255, 255));
        tipo2_4.setText("jLabel3");

        tipo2_5.setBackground(new java.awt.Color(0, 0, 0));
        tipo2_5.setForeground(new java.awt.Color(255, 255, 255));
        tipo2_5.setText("jLabel3");

        tipo2_6.setBackground(new java.awt.Color(0, 0, 0));
        tipo2_6.setForeground(new java.awt.Color(255, 255, 255));
        tipo2_6.setText("jLabel3");

        tipo2_7.setBackground(new java.awt.Color(0, 0, 0));
        tipo2_7.setForeground(new java.awt.Color(255, 255, 255));
        tipo2_7.setText("jLabel3");

        tipo2_8.setBackground(new java.awt.Color(0, 0, 0));
        tipo2_8.setForeground(new java.awt.Color(255, 255, 255));
        tipo2_8.setText("jLabel3");

        tipo2_9.setBackground(new java.awt.Color(0, 0, 0));
        tipo2_9.setForeground(new java.awt.Color(255, 255, 255));
        tipo2_9.setText("jLabel3");

        tipo2_10.setBackground(new java.awt.Color(0, 0, 0));
        tipo2_10.setForeground(new java.awt.Color(255, 255, 255));
        tipo2_10.setText("jLabel3");

        tipo2_11.setBackground(new java.awt.Color(0, 0, 0));
        tipo2_11.setForeground(new java.awt.Color(255, 255, 255));
        tipo2_11.setText("jLabel3");

        tipo2_12.setBackground(new java.awt.Color(0, 0, 0));
        tipo2_12.setForeground(new java.awt.Color(255, 255, 255));
        tipo2_12.setText("jLabel3");

        tipo2_13.setBackground(new java.awt.Color(0, 0, 0));
        tipo2_13.setForeground(new java.awt.Color(255, 255, 255));
        tipo2_13.setText("jLabel3");

        tipo2_14.setBackground(new java.awt.Color(0, 0, 0));
        tipo2_14.setForeground(new java.awt.Color(255, 255, 255));
        tipo2_14.setText("jLabel3");

        tipo2_15.setBackground(new java.awt.Color(0, 0, 0));
        tipo2_15.setForeground(new java.awt.Color(255, 255, 255));
        tipo2_15.setText("jLabel3");

        tipo2_16.setBackground(new java.awt.Color(0, 0, 0));
        tipo2_16.setForeground(new java.awt.Color(255, 255, 255));
        tipo2_16.setText("jLabel3");

        tipo3_1.setBackground(new java.awt.Color(0, 0, 0));
        tipo3_1.setForeground(new java.awt.Color(255, 255, 255));
        tipo3_1.setText("jLabel3");

        tipo3_2.setBackground(new java.awt.Color(0, 0, 0));
        tipo3_2.setForeground(new java.awt.Color(255, 255, 255));
        tipo3_2.setText("jLabel3");

        tipo3_3.setBackground(new java.awt.Color(0, 0, 0));
        tipo3_3.setForeground(new java.awt.Color(255, 255, 255));
        tipo3_3.setText("jLabel3");

        tipo3_4.setBackground(new java.awt.Color(0, 0, 0));
        tipo3_4.setForeground(new java.awt.Color(255, 255, 255));
        tipo3_4.setText("jLabel3");

        tipo3_5.setBackground(new java.awt.Color(0, 0, 0));
        tipo3_5.setForeground(new java.awt.Color(255, 255, 255));
        tipo3_5.setText("jLabel3");

        tipo3_6.setBackground(new java.awt.Color(0, 0, 0));
        tipo3_6.setForeground(new java.awt.Color(255, 255, 255));
        tipo3_6.setText("jLabel3");

        tipo3_7.setBackground(new java.awt.Color(0, 0, 0));
        tipo3_7.setForeground(new java.awt.Color(255, 255, 255));
        tipo3_7.setText("jLabel3");

        tipo3_8.setBackground(new java.awt.Color(0, 0, 0));
        tipo3_8.setForeground(new java.awt.Color(255, 255, 255));
        tipo3_8.setText("jLabel3");

        tipo3_9.setBackground(new java.awt.Color(0, 0, 0));
        tipo3_9.setForeground(new java.awt.Color(255, 255, 255));
        tipo3_9.setText("jLabel3");

        tipo3_10.setBackground(new java.awt.Color(0, 0, 0));
        tipo3_10.setForeground(new java.awt.Color(255, 255, 255));
        tipo3_10.setText("jLabel3");

        tipo3_11.setBackground(new java.awt.Color(0, 0, 0));
        tipo3_11.setForeground(new java.awt.Color(255, 255, 255));
        tipo3_11.setText("jLabel3");

        tipo3_12.setBackground(new java.awt.Color(0, 0, 0));
        tipo3_12.setForeground(new java.awt.Color(255, 255, 255));
        tipo3_12.setText("jLabel3");

        tipo3_13.setBackground(new java.awt.Color(0, 0, 0));
        tipo3_13.setForeground(new java.awt.Color(255, 255, 255));
        tipo3_13.setText("jLabel3");

        tipo3_14.setBackground(new java.awt.Color(0, 0, 0));
        tipo3_14.setForeground(new java.awt.Color(255, 255, 255));
        tipo3_14.setText("jLabel3");

        tipo3_15.setBackground(new java.awt.Color(0, 0, 0));
        tipo3_15.setForeground(new java.awt.Color(255, 255, 255));
        tipo3_15.setText("jLabel3");

        tipo3_16.setBackground(new java.awt.Color(0, 0, 0));
        tipo3_16.setForeground(new java.awt.Color(255, 255, 255));
        tipo3_16.setText("jLabel3");

        javax.swing.GroupLayout panelJuegoLayout = new javax.swing.GroupLayout(panelJuego);
        panelJuego.setLayout(panelJuegoLayout);
        panelJuegoLayout.setHorizontalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJuegoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelJuegoLayout.createSequentialGroup()
                        .addComponent(labelNave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1014, Short.MAX_VALUE)
                        .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelJuegoLayout.createSequentialGroup()
                                .addComponent(tipo1_8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipo2_8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipo2_16, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelJuegoLayout.createSequentialGroup()
                                .addComponent(tipo1_7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipo2_7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipo2_15, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelJuegoLayout.createSequentialGroup()
                                .addComponent(tipo1_6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipo2_6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipo2_14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelJuegoLayout.createSequentialGroup()
                                .addComponent(tipo1_5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipo2_5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipo2_13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelJuegoLayout.createSequentialGroup()
                                .addComponent(tipo1_4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipo2_4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tipo2_12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelJuegoLayout.createSequentialGroup()
                                .addComponent(tipo1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipo2_3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipo2_11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelJuegoLayout.createSequentialGroup()
                                .addComponent(tipo1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipo2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipo2_10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelJuegoLayout.createSequentialGroup()
                                .addComponent(tipo1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipo2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipo2_9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelJuegoLayout.createSequentialGroup()
                                .addComponent(tipo3_8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipo3_16, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelJuegoLayout.createSequentialGroup()
                                .addComponent(tipo3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipo3_10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelJuegoLayout.createSequentialGroup()
                                .addComponent(tipo3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipo3_9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelJuegoLayout.createSequentialGroup()
                                .addComponent(tipo3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipo3_11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelJuegoLayout.createSequentialGroup()
                                .addComponent(tipo3_4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipo3_12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelJuegoLayout.createSequentialGroup()
                                .addComponent(tipo3_5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipo3_13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelJuegoLayout.createSequentialGroup()
                                .addComponent(tipo3_6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipo3_14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelJuegoLayout.createSequentialGroup()
                                .addComponent(tipo3_7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipo3_15, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23))
                    .addGroup(panelJuegoLayout.createSequentialGroup()
                        .addComponent(disparo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Litem)
                        .addContainerGap())))
        );
        panelJuegoLayout.setVerticalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJuegoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(disparo)
                    .addComponent(Litem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelNave)
                    .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tipo1_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tipo2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tipo2_9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tipo3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tipo3_9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipo1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo2_10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo3_10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipo1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo2_3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo2_11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo3_11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipo2_4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo1_4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo2_12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo3_4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo3_12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipo2_5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo1_5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo2_13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo3_5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo3_13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipo2_6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo1_6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo2_14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo3_6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo3_14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipo2_7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo1_7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo2_15, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo3_15, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo3_7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipo3_16, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo3_8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo2_16, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo2_8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo1_8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelJuegoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelJuegoKeyPressed
       
    }//GEN-LAST:event_panelJuegoKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        //En caso de que toque la tecla de arriba
        if (KeyEvent.VK_UP==evt.getKeyCode()) {
            //Primero se comprueba si ya se alcanzo el limite
            if (mn.y>25) {
                //Comprobando si la nave NO se encuentra congelada
                if (hilo1.isAlive()==true) {
                  mn.sumaY(-movimientonave);  
                }
            }
        }
        //En caso de que toque la tecla de abajo
        if (KeyEvent.VK_DOWN==evt.getKeyCode()) {
            //Primero se comprueba si ya se alcanzo el limite
            if (mn.y<515) {
                //Comprobando si la nave NO se encuentra congelada
                if (hilo1.isAlive()==true) {
                   mn.sumaY(movimientonave); 
                }
            }
        }
        //Disparo
        if (KeyEvent.VK_SPACE==evt.getKeyCode()) {
            //Comprobando si la nave NO se encuentra congelada
                if (hilo1.isAlive()==true) {
                    hilo3=new Thread(disparoN);
                    hilo3.start();
                }
        }
        //Menú de pausa
        if (KeyEvent.VK_ESCAPE==evt.getKeyCode()) {
            
            //Pausar arreglos
                hilo1.suspend();
                hilo2.suspend();
                hilo3.suspend();
                hilo4.suspend();
                hilo5.suspend();
                for (int i = 0; i < 8; i++) {
                    htipo1[i].suspend();
                }
                for (int i = 0; i < 16; i++) {
                    htipo2[i].suspend();
                }
                for (int i = 0; i < 16; i++) {
                    htipo3[i].suspend();
                }
            //Arreglo de opciones
            Object [] opciones={"Reanudar","Salir"};
            //Cuadro de dialogo
            int i=JOptionPane.showOptionDialog(this, "Pausa", "", JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            //Opción de reanudar
            if (i==0) {
                hilo1.resume();
                hilo2.resume();
                hilo3.resume();
                hilo4.resume();
                hilo5.resume();
                for (int j = 0; j < 8; j++) {
                    htipo1[j].resume();
                }
                for (int j = 0; j < 16; j++) {
                    htipo2[i].resume();
                }
                for (int j = 0; j < 16; j++) {
                    htipo3[i].resume();
                }
            }
            //opcion de salir
            if (i==1) {
                menu.setVisible(true);
                //Se paran los hilos
                hilo1.stop();
                hilo2.stop();
                hilo3.stop();
                hilo4.stop();
                hilo5.stop();
                for (int j = 0; j < 8; j++) {
                    htipo1[j].stop();
                }
                for (int j = 0; j < 16; j++) {
                    htipo2[j].stop();
                }
                for (int j = 0; j < 16; j++) {
                    htipo3[j].stop();
                }
                System.gc();
                dispose();
            }
            /*En caso que se salga del menu de pausa de cualquier otra manera que
                no sea tocando los botenes del mismo**/
            hilo1.resume();
            hilo2.resume();
            hilo3.resume();
            hilo4.resume();
            hilo5.resume();
            for (int j = 0; j < 8; j++) {
                    htipo1[j].resume();
            }
            for (int j = 0; j < 16; j++) {
                    htipo2[j].resume();
            }
            for (int j = 0; j < 16; j++) {
                    htipo3[j].resume();
            }
        }
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel Litem;
    private javax.swing.JLabel disparo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelMoneda;
    private javax.swing.JLabel labelNave;
    private javax.swing.JLabel labelReloj;
    private javax.swing.JLabel labelVelocidad;
    private javax.swing.JLabel labelpuntos;
    private javax.swing.JLabel labelreloj;
    private javax.swing.JPanel panelJuego;
    private javax.swing.JLabel tipo1_1;
    private javax.swing.JLabel tipo1_2;
    private javax.swing.JLabel tipo1_3;
    private javax.swing.JLabel tipo1_4;
    private javax.swing.JLabel tipo1_5;
    private javax.swing.JLabel tipo1_6;
    private javax.swing.JLabel tipo1_7;
    private javax.swing.JLabel tipo1_8;
    private javax.swing.JLabel tipo2_1;
    private javax.swing.JLabel tipo2_10;
    private javax.swing.JLabel tipo2_11;
    private javax.swing.JLabel tipo2_12;
    private javax.swing.JLabel tipo2_13;
    private javax.swing.JLabel tipo2_14;
    private javax.swing.JLabel tipo2_15;
    private javax.swing.JLabel tipo2_16;
    private javax.swing.JLabel tipo2_2;
    private javax.swing.JLabel tipo2_3;
    private javax.swing.JLabel tipo2_4;
    private javax.swing.JLabel tipo2_5;
    private javax.swing.JLabel tipo2_6;
    private javax.swing.JLabel tipo2_7;
    private javax.swing.JLabel tipo2_8;
    private javax.swing.JLabel tipo2_9;
    private javax.swing.JLabel tipo3_1;
    private javax.swing.JLabel tipo3_10;
    private javax.swing.JLabel tipo3_11;
    private javax.swing.JLabel tipo3_12;
    private javax.swing.JLabel tipo3_13;
    private javax.swing.JLabel tipo3_14;
    private javax.swing.JLabel tipo3_15;
    private javax.swing.JLabel tipo3_16;
    private javax.swing.JLabel tipo3_2;
    private javax.swing.JLabel tipo3_3;
    private javax.swing.JLabel tipo3_4;
    private javax.swing.JLabel tipo3_5;
    private javax.swing.JLabel tipo3_6;
    private javax.swing.JLabel tipo3_7;
    private javax.swing.JLabel tipo3_8;
    private javax.swing.JLabel tipo3_9;
    // End of variables declaration//GEN-END:variables
}

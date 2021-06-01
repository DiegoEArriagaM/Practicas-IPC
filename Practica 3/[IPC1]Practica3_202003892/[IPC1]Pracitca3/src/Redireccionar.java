public class Redireccionar {
    
    public Redireccionar(int a) {
        //Se abre el frame dependiendo la opción que elija el usuario
        switch(a){
            case 1:
                //Se llaman a la clase necesaria
                Juego juego=new Juego();
                juego.setVisible(true);
                break;
            case 2:
                //Se llaman a la clase necesaria
                Panel_Configuracion configuracion=new Panel_Configuracion();
                configuracion.setVisible(true);
                break;
            case 3:
                //Se llaman a la clase necesaria
                ListadoPuntajes pt=new ListadoPuntajes();
                pt.setVisible(true);
                break;
            default:
                break;
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipc1.practica2;

import java.io.FileInputStream;
import java.io.ObjectInputStream;



/**
 *
 * @author Diego
 */
public class CargarArchivos {
    //Se mandan a llamar las clases necesarias para unir los datos.
    static CargaAlimentos alimentos;
    static CargaGimnasios gimnasio;
    static CargaEntrenador entrenador;
    static CargaPokeballs pokeball;
    static CargaPokemon pokemon;
     public CargarArchivos(){
         alimentos=new CargaAlimentos();
         gimnasio=new CargaGimnasios();
         entrenador=new CargaEntrenador();
         pokeball=new CargaPokeballs();
         pokemon=new CargaPokemon();
     }
   //Metodo que se encarga de cargar los archivos creados 
    public static void carga(){
        try {
            ObjectInputStream o1 = new ObjectInputStream(new FileInputStream("pokemons.bin"));
                    pokemon = (CargaPokemon) o1.readObject();
            ObjectInputStream o2 = new ObjectInputStream(new FileInputStream("pokeballs.bin"));
                    pokeball = (CargaPokeballs) o2.readObject();
            ObjectInputStream o3 = new ObjectInputStream(new FileInputStream("entrenadores.bin"));
                    entrenador = (CargaEntrenador) o3.readObject();
            ObjectInputStream o4 = new ObjectInputStream(new FileInputStream("gimnasio.bin"));
                    gimnasio = (CargaGimnasios) o4.readObject();
            ObjectInputStream o5 = new ObjectInputStream(new FileInputStream("alimento.bin"));
                    alimentos = (CargaAlimentos) o5.readObject();
            pokemon.carga("pokemon.csv");
            entrenador.carga("entrenador.csv");
            pokeball.carga("pokeball.csv");
            gimnasio.carga("gimnasio.csv");
            alimentos.carga("alimento.csv");
            System.out.println("Se cargaron los archivos correctamente");
        } catch (Exception e) {
            System.err.println("No se encontraron Archivos anteriormente Guardados");
        }
       
    }
}

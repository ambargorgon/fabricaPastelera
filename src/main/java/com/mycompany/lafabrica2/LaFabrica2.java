package com.mycompany.lafabrica2;    
import Controlador.Controlador;
import Modelo.DatabaseConnector;


public class LaFabrica2 {
    public static void main(String[] args) {
        DatabaseConnector conector = new DatabaseConnector();
        conector.conectarBase();
        
        Controlador control = new Controlador();
        control.iniciar();
    }
}

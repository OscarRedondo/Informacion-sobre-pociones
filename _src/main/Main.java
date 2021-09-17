package main;


import vista.PocionesVista;
import vista.PresentacionVista;
import controlador.PocionesControlador;
import controlador.PresentacionControlador;
import modelo.Pociones;
import modelo.PocionesConsultas; 

public class Main {
	public static void main(String[] args) {
		PresentacionVista frmPresentacion = new PresentacionVista();
		PresentacionControlador ctrlPresentacion = new PresentacionControlador(frmPresentacion);
		
		ctrlPresentacion.iniciar();
		frmPresentacion.setVisible(true);
	}

}
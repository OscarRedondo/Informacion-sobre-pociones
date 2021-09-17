package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Pociones;
import modelo.PocionesConsultas;
import vista.PocionesVista;

import vista.PresentacionVista; 

public class PresentacionControlador implements ActionListener {	
	Pociones modPociones = new Pociones();
	PocionesConsultas modCPociones = new PocionesConsultas();
	PocionesVista frmPociones = new PocionesVista();
	PocionesControlador ctrlPociones = new PocionesControlador(modPociones, modCPociones, frmPociones);

	private PresentacionVista frmPresentacion;

	// CONSTRUCTOR

	public PresentacionControlador(PresentacionVista frmPresentacion) {
		this.frmPresentacion = frmPresentacion;
		this.frmPresentacion.btnIniciarPrograma.addActionListener(this);
	}

	// FIN CONSTUCTOR
	
	public void iniciar() {
		frmPresentacion.setTitle("Informaci\u00F3n sobre pociones");
		frmPresentacion.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == frmPresentacion.btnIniciarPrograma) {
			frmPresentacion.setVisible(false);

			ctrlPociones.iniciar();
			frmPociones.setVisible(true);
		}
	}
	
}

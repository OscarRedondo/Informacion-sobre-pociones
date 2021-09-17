package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.Conexion;
import modelo.Pociones;
import modelo.PocionesConsultas;
import vista.PocionesVista;

public class PocionesControlador implements ActionListener {
	private Pociones mod;
	private PocionesConsultas modC;
	private PocionesVista frm;
	
	// CONSTRUCTOR
	
	public PocionesControlador (Pociones mod, PocionesConsultas modC, PocionesVista frm) {
		this.mod = mod;
		this.modC = modC; 
		this.frm = frm;
		this.frm.btnAgregarPocion.addActionListener(this);
		this.frm.btnModificarPocion.addActionListener(this);
		this.frm.btnEliminarPocion.addActionListener(this);
		this.frm.btnBuscarPocion.addActionListener(this);
		this.frm.btnLimpiar.addActionListener(this);
	}
	
	// FIN CONSTRUCTOR
	
	public void iniciar() {
		frm.setTitle("Pociones");
		frm.setLocationRelativeTo(null);
	}
	
	private void limpiar() {
		frm.inputIdPocion.setText("");
		frm.inputNombrePocion.setText("");
		frm.inputLitrosPocion.setText("");
		frm.inputUsosPocion.setText("");
	}	
	
	public static void cargarTabla() {
		DefaultTableModel modeloTabla = (DefaultTableModel) PocionesVista.tablaPociones.getModel();
		modeloTabla.setRowCount(0);
		
		PreparedStatement ps;
		ResultSet rs;
		ResultSetMetaData rsmd;
		int columnas;
		
		// Determina el tamaño de las tablas		
		int[] anchos = {10, 50, 100, 30, 100};
		for(int i=0 ; i<PocionesVista.tablaPociones.getColumnCount() ; i++) {
			PocionesVista.tablaPociones.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
		}
		// FIN Determina el tamaño de las tablas
		
		System.out.println("Entra a cargarTabla");
		
		try {
			
			System.out.println("Intenta conectar con la base de datos");
			
			Connection con = Conexion.getConexion();
			ps = con.prepareStatement("SELECT id_pocion, nombre_pocion, litros_realizados_pocion, usos_pocion"
					+ " FROM pociones");
			rs = ps.executeQuery();
			rsmd = rs.getMetaData();
			columnas = rsmd.getColumnCount();
			
			while(rs.next()) {
				
				System.out.println("Entra al while");
				
				Object[] fila =  new Object[columnas];
				for(int indice=0 ; indice<columnas ; indice++) {
					fila[indice] = rs.getObject(indice + 1);
				}
				modeloTabla.addRow(fila);
			}
		}
		catch(SQLException e) {JOptionPane.showMessageDialog(null, e);}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == frm.btnAgregarPocion) {
			mod.setId_pocion(Integer.parseInt(frm.inputIdPocion.getText()));
			mod.setNombre_pocion(frm.inputNombrePocion.getText());
			mod.setLitros_realizados_pocion(Double.parseDouble(frm.inputLitrosPocion.getText()));
			mod.setUsos_pocion(Integer.parseInt(frm.inputUsosPocion.getText()));
			
			if(modC.agregar(mod)) {
				JOptionPane.showMessageDialog(null, "POCI\u00D3N AGREGADA.");
				limpiar();
				cargarTabla();
			}
			else {
				JOptionPane.showMessageDialog(null, "ERROR AL AGREGAR LA POCI\u00D3N.");
			}
		}
		
		if(e.getSource() == frm.btnModificarPocion) {
			mod.setId_pocion(Integer.parseInt(frm.inputIdPocion.getText()));
			mod.setNombre_pocion(frm.inputNombrePocion.getText());
			mod.setLitros_realizados_pocion(Double.parseDouble(frm.inputLitrosPocion.getText()));
			mod.setUsos_pocion(Integer.parseInt(frm.inputUsosPocion.getText()));
			
			if(modC.modificar(mod)) {
				JOptionPane.showMessageDialog(null, "POCI\u00D3N MODIFICADA.");
				limpiar();
				cargarTabla();
			}
			else {
				JOptionPane.showMessageDialog(null, "ERROR AL MODIFICAR LA POCI\u00D3N.");
			}
		}
		
		if(e.getSource() == frm.btnEliminarPocion) {
			mod.setId_pocion(Integer.parseInt(frm.inputIdPocion.getText()));
			mod.setNombre_pocion(frm.inputNombrePocion.getText());
			mod.setLitros_realizados_pocion(Double.parseDouble(frm.inputLitrosPocion.getText()));
			mod.setUsos_pocion(Integer.parseInt(frm.inputUsosPocion.getText()));
			
			if(modC.eliminar(mod)) {
				JOptionPane.showMessageDialog(null, "POCI\u00D3N ELIMINADA.");
				limpiar();
				cargarTabla();
			}
			else {
				JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR LA POCI\u00D3N.");
			}
		}
		
		if(e.getSource() == frm.btnBuscarPocion) {
			mod.setId_pocion(Integer.parseInt(frm.inputIdPocion.getText()));
			
			if(modC.buscar(mod)) {
				frm.inputIdPocion.setText(String.valueOf(mod.getId_pocion()));
				frm.inputNombrePocion.setText(mod.getNombre_pocion());
				frm.inputLitrosPocion.setText(String.valueOf(mod.getLitros_realizados_pocion()));
				frm.inputUsosPocion.setText(String.valueOf(mod.getUsos_pocion()));
			}
			else { JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR LA POCI\u00D3N."); }
		}
		
		if(e.getSource() == frm.btnLimpiar) {
			if(modC.limpiar()) {
				JOptionPane.showMessageDialog(null, "SElECCI\u00D3N LIMPIADA.");
				limpiar();
			}
			else { JOptionPane.showMessageDialog(null, "ERROR AL LIMPIAR LA SELECCI\u00D3N."); };
		}
		
	}
	
}
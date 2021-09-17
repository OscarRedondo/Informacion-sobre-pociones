package vista;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.PocionesControlador;
import modelo.Conexion;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PocionesVista extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	public JTextField inputLitrosPocion;
	public JTextField inputUsosPocion;
	public JTextField inputNombrePocion;
	public JTextField inputIdPocion;
	public static JTable tablaPociones;
	
	public JButton btnAgregarPocion;
	public JButton btnModificarPocion;
	public JButton btnEliminarPocion;
	public JButton btnBuscarPocion;
	public JButton btnLimpiar;	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PocionesVista frame = new PocionesVista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PocionesVista() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane panelPestanas = new JTabbedPane(JTabbedPane.TOP);
		panelPestanas.setBounds(0, 0, 794, 471);
		contentPane.add(panelPestanas);			
			JPanel p1 = new JPanel();
			panelPestanas.add("Pociones", p1);
			p1.setLayout(null);
			
				JLabel idPocion = new JLabel("ID:");
				idPocion.setBounds(10, 11, 113, 14);
				p1.add(idPocion);
				
				JLabel nombrePocion = new JLabel("Nombre:");
				nombrePocion.setBounds(10, 76, 113, 14);
				p1.add(nombrePocion);
				
				JLabel litrosPocion = new JLabel("Litros realizados:");
				litrosPocion.setBounds(10, 101, 113, 14);
				p1.add(litrosPocion);
				
				JLabel usosPocion = new JLabel("Veces utilizada:");
				usosPocion.setBounds(10, 126, 113, 14);
				p1.add(usosPocion);
				
				inputLitrosPocion = new JTextField();
				inputLitrosPocion.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						if(!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != '.'){
							e.consume();
						}						
						if(e.getKeyChar() == '.' && inputLitrosPocion.getText().contains(".")) {
							e.consume();
						}
					}
				});
				inputLitrosPocion.setBounds(133, 101, 158, 20);
				p1.add(inputLitrosPocion);
				inputLitrosPocion.setColumns(10);
				
				inputUsosPocion = new JTextField();
				inputUsosPocion.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char validar = e.getKeyChar();
				        if(Character.isLetter(validar) || (validar>=32 && validar<=47) || (validar>=58 && validar<=255)){
				            getToolkit().beep();
				            e.consume();
				        } 
					}
				});
				inputUsosPocion.setBounds(133, 126, 158, 20);
				p1.add(inputUsosPocion);
				inputUsosPocion.setColumns(10);
				
				inputNombrePocion = new JTextField();
				inputNombrePocion.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char validar = e.getKeyChar();
				        if(Character.isDigit(validar) || (validar>32 && validar<=64) || (validar>=91 && validar<=96) || (validar>=123 && validar<=129) || (validar>=131 && validar<=159) || (validar>=166 && validar<=208) || (validar>=210 && validar<=255)){
				            getToolkit().beep();
				            e.consume();
				        }
				        /* ADMITIR SOLO MAYUSCULAS
				        if (Character.isLowerCase(validar)) {
				            String cad = (""+validar).toUpperCase();
				            validar = cad.charAt(0);
				            e.setKeyChar(validar);
				        } */
					}
				});
				inputNombrePocion.setBounds(133, 76, 158, 20);
				p1.add(inputNombrePocion);
				inputNombrePocion.setColumns(10);
				
				inputIdPocion = new JTextField();
				inputIdPocion.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char validar = e.getKeyChar();
				        if(Character.isLetter(validar) || (validar>=32 && validar<=47) || (validar>=58 && validar<=255)){
				            getToolkit().beep();
				            e.consume();
				        } 
					}
				});
				inputIdPocion.setBounds(165, 8, 86, 20);
				p1.add(inputIdPocion);
				inputIdPocion.setColumns(10);
			
			btnBuscarPocion = new JButton("Buscar por ID");
			btnBuscarPocion.setBounds(147, 42, 125, 23);
			p1.add(btnBuscarPocion);
				
			btnAgregarPocion = new JButton("Agregar nueva poci\u00F3n");
			btnAgregarPocion.setBounds(62, 241, 177, 23);
			p1.add(btnAgregarPocion);

			btnModificarPocion = new JButton("Modificar poci\u00F3n");
			btnModificarPocion.setBounds(62, 275, 177, 23);
			p1.add(btnModificarPocion);

			btnEliminarPocion = new JButton("Eliminar poci\u00F3n");
			btnEliminarPocion.setBounds(62, 309, 177, 23);
			p1.add(btnEliminarPocion);
			
			btnLimpiar = new JButton("LIMPIAR SELECCI\u00D3N");
			btnLimpiar.setBounds(62, 157, 177, 23);
			p1.add(btnLimpiar);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(301, 11, 468, 411);
			p1.add(scrollPane_1);
			
			tablaPociones = new JTable();
			tablaPociones.setRowSelectionAllowed(true);

			// Actualizar información de los input al clickear sobre ellos. 
				// POR ALGÚN MOTIVO, FILA OBTIENE EL VALOR DE -1.
					// ESTO SUCEDE TOOAS LAS VECES.
					// SIGNIFICA QUE NO SE DETECTA LA SELECCION DE LA FILA. 
				
				tablaPociones.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						int fila = tablaPociones.getSelectedRow();
						if(fila != -1) {
							int id = Integer.parseInt(tablaPociones.getValueAt(fila, 0 ).toString());
							PreparedStatement ps;
							ResultSet rs;
							
							Connection con = Conexion.getConexion();
							ps = con.prepareStatement("SELECT id_pocion, nombre_pocion, litros_realizados_pocion, usos_pocion"
									+ " FROM pociones WHERE id_pocion=?");
							ps.setInt(1, id);
							rs = ps.executeQuery();
							
							while(rs.next()) {
								inputIdPocion.setText(rs.getString("id_pocion"));
								inputNombrePocion.setText(rs.getString("nombre_pocion"));
								inputLitrosPocion.setText(rs.getString("litros_realizados_pocion"));
								inputUsosPocion.setText(rs.getString("usos_pocion"));
							}
						}
					}
					catch(SQLException ex) {JOptionPane.showMessageDialog(null, e.toString());}
				}
			});
			
			// FIN Actualizar información de los input al clickear sobre ellos.
			
			scrollPane_1.setViewportView(tablaPociones);
			
			tablaPociones.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
				},
				new String[] {
					"ID", "Nombre", "Litros realizados", "Veces utilizada"
				}
			) {
				Class[] columnTypes = new Class[] {
					Integer.class, String.class, Double.class, Integer.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			
		PocionesControlador.cargarTabla();
	}	
}

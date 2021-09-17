package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import controlador.PresentacionControlador;

public class PresentacionVista extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;	
	public JButton btnIniciarPrograma;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PresentacionVista frame = new PresentacionVista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PresentacionVista() {
		setTitle("Informaci\u00F3n sobre pociones");
		setResizable(false);
		setLocationByPlatform(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// BOTON DE INICIO
		
		btnIniciarPrograma = new JButton("VER TABLAS");
		btnIniciarPrograma.setBounds(331, 314, 115, 23);
		contentPane.add(btnIniciarPrograma);
		
		/* Mostrar el nombre de las pociones en una ventana

		btnIniciarPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bases = "";				
				try {
					Statement sql = Conexion.getConexion().createStatement();					
					String consulta = "SELECT nombre_pocion FROM pociones";
					ResultSet resultado = sql.executeQuery(consulta);
					
					while(resultado.next()) {
						bases += resultado.getString(1) + "\n";
					}
					JOptionPane.showMessageDialog(null, bases);
				}
				catch(SQLException ex) {
					JOptionPane.showMessageDialog(null, ex.toString());
				}
			}
		}); */
		
				
		
		// FIN BOTON DE INICIO
			
		// TEXTO DE PRESENTACION
		
		JLabel titulo = new JLabel("INFORMACI\u00D3N SOBRE POCIONES");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(224, 85, 339, 44);
		contentPane.add(titulo);
		
		JLabel introduccion = new JLabel("<html><div style='text-align: center;'>"
				+ "Un CRUD desarrollado en Java que permite hacer un seguimiento a la informaci\u00F3n sobre "
				+ "<br/>las pociones que yacen en una base de datos escrita en SQL."
				+ "<br/><br/>Fue desarrollado en principio como una tarea grupal a entegar, pero ahora lo sigo mejorando por mi cuenta para practicar y aprender m\u00E1s."
				+ "</div><html>");
		introduccion.setHorizontalAlignment(SwingConstants.CENTER);
		introduccion.setBounds(128, 140, 517, 78);
		contentPane.add(introduccion);
		
		JLabel hechoPor = new JLabel("HECHO POR:");
		hechoPor.setFont(new Font("Tahoma", Font.BOLD, 13));
		hechoPor.setHorizontalAlignment(SwingConstants.CENTER);
		hechoPor.setBounds(332, 229, 115, 23);
		contentPane.add(hechoPor);
		
		JLabel creador_1 = new JLabel("Oscar Redondo");
		creador_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		creador_1.setHorizontalAlignment(SwingConstants.CENTER);
		creador_1.setBounds(316, 263, 150, 23);
		contentPane.add(creador_1);

		// FIN TEXTO DE PRESENTACION
	}
}

package gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JButton;




import entidades.Usuario;
import gui.Mantenimiento_Usuarios;
import controlador.ArrayUsuario;





import javax.swing.border.BevelBorder;



public class principalForm extends JFrame {
	ArrayUsuario a = new ArrayUsuario();
	private JPanel contentPane;
	
	gui.loginForm login = new gui.loginForm(); 
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principalForm frame = new principalForm();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public principalForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Creo el constructor del formulario login
		
		gui.loginForm login = new gui.loginForm();
		
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(44, 15, 265, 14);
		contentPane.add(lblUsuario);
		
		JButton btnCerrarSesin = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				principalForm.this.login.setVisible(true);
				principalForm.this.login.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnCerrarSesin.setBounds(540, 11, 122, 23);
		contentPane.add(btnCerrarSesin);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(44, 55, 600, 177);
		contentPane.add(panel);
		
		
		JMenuBar mnPrincipal = new JMenuBar();
		setJMenuBar(mnPrincipal);
		
		JMenu mnSistema = new JMenu("Sistema");
		mnPrincipal.add(mnSistema);
		
		JMenuItem mntmOpenSession = new JMenuItem("Iniciar sesi\u00F3n");
		mnSistema.add(mntmOpenSession);
		mntmOpenSession.setIcon(getIcon("login.png",null));
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		mnSistema.add(mntmSalir);	    
		
		mntmSalir.setIcon(getIcon("exit.png",null));
			
		JMenu mnMantenimiento = new JMenu("Mantenimiento");
		mnPrincipal.add(mnMantenimiento);
		
		JMenuItem mntmUser = new JMenuItem("Usuario");
		mntmUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mantenimiento_Usuarios frm1=new Mantenimiento_Usuarios();
				frm1.setVisible(true);
			}
		});
		mnMantenimiento.add(mntmUser);
		
		mntmUser.setIcon(getIcon("user.png",null));
		
		JMenuItem mntmArea = new JMenuItem("\u00C1rea");
		mnMantenimiento.add(mntmArea);
		mntmArea.setIcon(getIcon("house.png",null));
		
		JMenuItem mntmTipoIncidencia = new JMenuItem("Tipo de incidencia");
		mnMantenimiento.add(mntmTipoIncidencia);
		mntmTipoIncidencia.setIcon(getIcon("report_add.png", null));
		
		JMenuItem mntmTipoDocumento = new JMenuItem("Tipo de documento");
		mnMantenimiento.add(mntmTipoDocumento);
		mntmTipoDocumento.setIcon(getIcon("document.png",null));
		
		JMenuItem mntmEspecialista = new JMenuItem("Especialista");
		mnMantenimiento.add(mntmEspecialista);
		mntmEspecialista.setIcon(getIcon("new.png",null));
		
		JMenu mnIncidencia = new JMenu("Incidencia");
		mnPrincipal.add(mnIncidencia);
		
		JMenuItem mntmIngreso = new JMenuItem("Ingreso");
		mnIncidencia.add(mntmIngreso);
		
		JMenuItem mntmListado = new JMenuItem("Listado");
		mnIncidencia.add(mntmListado);
		
		JMenuItem mntmUpdate = new JMenuItem("Actualizaci\u00F3n");
		mnIncidencia.add(mntmUpdate);
		
		JMenu mnReportes = new JMenu("Reportes");
		mnPrincipal.add(mnReportes);
		
		JMenuItem mntmInciArea = new JMenuItem("Incidencias por Area");
		mnReportes.add(mntmInciArea);
		
		JMenuItem mntmInciTipo = new JMenuItem("Incidencia por tipo");
		mnReportes.add(mntmInciTipo);
		
		JMenuItem mntmInciFecha = new JMenuItem("Incidencia por rango de fecha");
		mnReportes.add(mntmInciFecha);
		
		JMenuItem mntmInciFalla = new JMenuItem("Incencias falladas");
		mnReportes.add(mntmInciFalla);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		mnPrincipal.add(mnAyuda);
		
		JMenuItem mntmAyuda = new JMenuItem("Acerca del programa");
		mnAyuda.add(mntmAyuda);
		mntmAyuda.setIcon(getIcon("help.png",null));
	}
	//Metodos para sacar las imagenes
	
		public ImageIcon getIcon (String icono, String size){
			size="16";
			java.net.URL imgUrl = getClass().getResource("img/"+size+"/" + icono);
			if(imgUrl!=null){
				ImageIcon imgIcon = new ImageIcon(imgUrl);
				return imgIcon;
			}else{
				System.out.println("Error no se encontro el archivo "+ icono);
			}
			return null;
		}
}

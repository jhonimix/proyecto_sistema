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

import javax.swing.border.BevelBorder;

public class principalForm extends JFrame implements ActionListener {	
	
	gui.loginForm login = new gui.loginForm();

	//DECLARAMOS GLOBALES LAS VARIABLES DEL FORMULARIO
	private JPanel contentPane;
	
	private JButton btnCerrarSesin;
	private JMenuBar mnPrincipal;
	
	/* MENU SISTEMA */
	private JMenu mnSistema;
	private JMenuItem mntmOpenSession;
	private JMenuItem mntmSalir;
	/* MENU MANTENIMIENTO */
	private JMenu mnMantenimiento;
	private JMenuItem mntmUser;
	private JMenuItem mntmArea;
	private JMenuItem mntmTipoIncidencia;
	private JMenuItem mntmTipoDocumento;
	private JMenuItem mntmEspecialista;
	/* MENU INCIDENCIA */
	private JMenu mnIncidencia;
	private JMenuItem mntmIngreso;
	private JMenuItem mntmListado;
	private JMenuItem mntmUpdate;
	/* MENU REPORTES */
	private JMenu mnReportes;
	private JMenuItem mntmInciArea;
	private JMenuItem mntmInciTipo;
	private JMenuItem mntmInciFecha;
	private JMenuItem mntmInciFalla;
	/* MENU AYUDA */
	private JMenu mnAyuda;
	private JMenuItem mntmAyuda;
	
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

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(44, 15, 265, 14);
		contentPane.add(lblUsuario);

		btnCerrarSesin = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesin.addActionListener(this);
		btnCerrarSesin.setBounds(540, 11, 122, 23);
		contentPane.add(btnCerrarSesin);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(44, 55, 600, 177);
		contentPane.add(panel);

		mnPrincipal = new JMenuBar();
		setJMenuBar(mnPrincipal);

		mnSistema = new JMenu("Sistema");
		mnPrincipal.add(mnSistema);

		mntmOpenSession = new JMenuItem("Iniciar sesi\u00F3n");
		mnSistema.add(mntmOpenSession);
		mntmOpenSession.setIcon(getIcon("login.png", null));

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);

		mnSistema.add(mntmSalir);

		mntmSalir.setIcon(getIcon("exit.png", null));

		mnMantenimiento = new JMenu("Mantenimiento");
		mnPrincipal.add(mnMantenimiento);

		mntmUser = new JMenuItem("Usuario");
		mntmUser.addActionListener(this);
		mnMantenimiento.add(mntmUser);

		mntmUser.setIcon(getIcon("user.png", null));

		mntmArea = new JMenuItem("\u00C1rea");
		mnMantenimiento.add(mntmArea);
		mntmArea.setIcon(getIcon("house.png", null));

		mntmTipoIncidencia = new JMenuItem("Tipo de incidencia");
		mnMantenimiento.add(mntmTipoIncidencia);
		mntmTipoIncidencia.setIcon(getIcon("report_add.png", null));

		mntmTipoDocumento = new JMenuItem("Tipo de documento");
		mntmTipoDocumento.addActionListener(this);
		mnMantenimiento.add(mntmTipoDocumento);
		mntmTipoDocumento.setIcon(getIcon("document.png", null));

		mntmEspecialista = new JMenuItem("Especialista");
		mnMantenimiento.add(mntmEspecialista);
		mntmEspecialista.setIcon(getIcon("new.png", null));

		mnIncidencia = new JMenu("Incidencia");
		mnPrincipal.add(mnIncidencia);

		mntmIngreso = new JMenuItem("Ingreso");
		mnIncidencia.add(mntmIngreso);

		mntmListado = new JMenuItem("Listado");
		mnIncidencia.add(mntmListado);

		mntmUpdate = new JMenuItem("Actualizaci\u00F3n");
		mnIncidencia.add(mntmUpdate);

		mnReportes = new JMenu("Reportes");
		mnPrincipal.add(mnReportes);

		mntmInciArea = new JMenuItem("Incidencias por Area");
		mnReportes.add(mntmInciArea);

		mntmInciTipo = new JMenuItem("Incidencia por tipo");
		mnReportes.add(mntmInciTipo);

		mntmInciFecha = new JMenuItem("Incidencia por rango de fecha");
		mnReportes.add(mntmInciFecha);

		mntmInciFalla = new JMenuItem("Incencias falladas");
		mnReportes.add(mntmInciFalla);

		mnAyuda = new JMenu("Ayuda");
		mnPrincipal.add(mnAyuda);

		mntmAyuda = new JMenuItem("Acerca del programa");
		mnAyuda.add(mntmAyuda);
		mntmAyuda.setIcon(getIcon("help.png", null));
	}

	// METODOS PARA SACAR LAS IMAGENES

	public ImageIcon getIcon(String icono, String size) {
		size = "16";
		java.net.URL imgUrl = getClass().getResource(
				"img/" + size + "/" + icono);
		if (imgUrl != null) {
			ImageIcon imgIcon = new ImageIcon(imgUrl);
			return imgIcon;
		} else {
			System.out.println("Error no se encontro el archivo " + icono);
		}
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		
		if(obj==btnCerrarSesin){
			principalForm.this.login.setVisible(true);
			principalForm.this.login.setLocationRelativeTo(null);
			dispose();	
		}
		
		else if(obj == mntmSalir){
			dispose();
		}
		
		else if(obj == mntmUser){
			MantenimientoUsuarios frm1 = new MantenimientoUsuarios();
			frm1.setVisible(true);
		}	
		else if (obj == mntmTipoDocumento) {
			MantenimientoDocumento frm2 = new MantenimientoDocumento();
			frm2.setVisible(true);
		}
		
	
	}
	
	
}

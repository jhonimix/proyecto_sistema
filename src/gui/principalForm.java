package gui;

import entidades.Usuario;
import gui.MantenimientoDocumento;
import gui.MantenimientoIncidencia;

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

import clases.imagenFondo;

import javax.swing.JButton;
import java.awt.Font;


public class principalForm extends JFrame implements ActionListener {	
	
	gui.loginForm login = new gui.loginForm();
	
	Usuario objUsu;

	//DECLARAMOS GLOBALES LAS VARIABLES DEL FORMULARIO
	private JPanel contentPane;
	
	private JButton btnCerrarSesin;
	private JMenuBar mnPrincipal;
	
	/* MENU SISTEMA */
	private JMenu mnSistema;
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
					ImageIcon icon = new ImageIcon(frame.getClass().getResource("img/fondo-principal.png"));
					imagenFondo fondo = new imagenFondo(icon.getImage(),750,500);
					frame.getContentPane().add(fondo);
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
		setResizable(false);
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 544);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/* JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(44, 15, 265, 14);
		contentPane.add(lblUsuario);*/

		/*btnCerrarSesin = new JButton("Cerrar Sesion");
		btnCerrarSesin.setBounds(540, 11, 122, 23);
		btnCerrarSesin.addActionListener(this);
		contentPane.add(btnCerrarSesin); */
		
		/* JSeparator separator = new JSeparator();
		separator.setBounds(44, 44, 618, 14);
		contentPane.add(separator);*/

		mnPrincipal = new JMenuBar();
		mnPrincipal.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		setJMenuBar(mnPrincipal);

		mnSistema = new JMenu("Sistema");
		mnPrincipal.add(mnSistema);

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

		mntmArea = new JMenuItem("Area");
		mntmArea.addActionListener(this);
		mnMantenimiento.add(mntmArea);
		mntmArea.setIcon(getIcon("house.png", null));

		mntmTipoIncidencia = new JMenuItem("Tipo de incidencia");
		mntmTipoIncidencia.addActionListener(this);
		mnMantenimiento.add(mntmTipoIncidencia);
		mntmTipoIncidencia.setIcon(getIcon("report_add.png", null));

		mntmTipoDocumento = new JMenuItem("Tipo de documento");
		mntmTipoDocumento.addActionListener(this);
		mnMantenimiento.add(mntmTipoDocumento);
		mntmTipoDocumento.setIcon(getIcon("document.png", null));

		mntmEspecialista = new JMenuItem("Especialista");
		mntmEspecialista.addActionListener(this);
		mnMantenimiento.add(mntmEspecialista);
		mntmEspecialista.setIcon(getIcon("new.png", null));

		mnIncidencia = new JMenu("Incidencia");
		mnPrincipal.add(mnIncidencia);

		mntmIngreso = new JMenuItem("Ingreso");
		mntmIngreso.addActionListener(this);
		mnIncidencia.add(mntmIngreso);

		mntmListado = new JMenuItem("Listado");
		mntmListado.addActionListener(this);
		mnIncidencia.add(mntmListado);

		mntmUpdate = new JMenuItem("Actualizaci\u00F3n");
		mntmUpdate.addActionListener(this);
		mnIncidencia.add(mntmUpdate);

		mnReportes = new JMenu("Reportes");
		mnPrincipal.add(mnReportes);

		mntmInciArea = new JMenuItem("Incidencias por Area");
		mnReportes.add(mntmInciArea);

		mntmInciTipo = new JMenuItem("GIncidencia por tipo");
		mnReportes.add(mntmInciTipo);

		mntmInciFecha = new JMenuItem("GIncidencia por rango de fecha");
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

	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		GIncidencia frmIncidencia;
		
		/*if(obj==btnCerrarSesin){
			dispose();	
		}*/
		
		if(obj == mntmSalir){
			principalForm.this.login.setVisible(true);
			principalForm.this.login.setLocationRelativeTo(null);
			dispose();
		}
		
		else if(obj == mntmUser){
			MantenimientoUsuarios frmUsuario = new MantenimientoUsuarios();
			frmUsuario.setVisible(true);
		}	
		else if(obj==mntmArea){
			
		}
		else if (obj == mntmTipoDocumento) {
			MantenimientoDocumento frmDocumento = new MantenimientoDocumento();
			frmDocumento.setVisible(true);
		}
		else if (obj == mntmTipoIncidencia) {
			MantenimientoIncidencia frmTipoIncidencia = new MantenimientoIncidencia();
			frmTipoIncidencia.setVisible(true);
		}
		else if (obj == mntmEspecialista) {
			MantenimientoEspecialista frmEspecialista = new MantenimientoEspecialista();
			frmEspecialista.setVisible(true);
		}
		else if (obj == mntmIngreso) {
			frmIncidencia = new GIncidencia();
			frmIncidencia.setVisible(true);
			frmIncidencia.panel.setVisible(true);
			frmIncidencia.btnRegistrar.setVisible(true);
			frmIncidencia.btnNuevo.setVisible(true);
			frmIncidencia.btnLimpiar.setVisible(true);
			frmIncidencia.Incidencia.setVisible(true);
			frmIncidencia.setCodUsu(objUsu.getCodUser());
		}
		else if (obj == mntmListado) {
			frmIncidencia = new GIncidencia();
			frmIncidencia.setVisible(true);
			frmIncidencia.setTitle("Listado de Incidencias Registradas");
			frmIncidencia.btnListado.setVisible(true);
			frmIncidencia.btnBuscar.setVisible(true);
			frmIncidencia.lblMensListado1.setVisible(true);
			frmIncidencia.lblMensListado2.setVisible(true);
			frmIncidencia.Listado.setVisible(true);
		}
		else if (obj == mntmUpdate) {
			frmIncidencia = new GIncidencia();
			frmIncidencia.setVisible(true);
			frmIncidencia.setTitle("Actualizar Incidencias Registradas");
			frmIncidencia.panel.setVisible(true);
			frmIncidencia.btnBuscar.setVisible(true);
			frmIncidencia.btnModificar.setVisible(true);
			frmIncidencia.btnLimpiar.setVisible(true);
			frmIncidencia.Incidencia.setVisible(true);
		}
	
	}
}

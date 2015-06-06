package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal frame = new principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar mnPrincipal = new JMenuBar();
		setJMenuBar(mnPrincipal);
		
		JMenu mnSistema = new JMenu("Sistema");
		mnPrincipal.add(mnSistema);
		
		JMenuItem mntmIniciarSesin = new JMenuItem("Iniciar sesi\u00F3n");
		mnSistema.add(mntmIniciarSesin);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		mnSistema.add(mntmSalir);
		
		JMenu mnMantenimiento = new JMenu("Mantenimiento");
		mnPrincipal.add(mnMantenimiento);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Usuario");
		mnMantenimiento.add(mntmNewMenuItem);
		
		JMenuItem mntmArea = new JMenuItem("\u00C1rea");
		mnMantenimiento.add(mntmArea);
		
		JMenuItem mntmTipoDeIncidencia = new JMenuItem("Tipo de incidencia");
		mnMantenimiento.add(mntmTipoDeIncidencia);
		
		JMenuItem mntmTipoDeDocumento = new JMenuItem("Tipo de documento");
		mnMantenimiento.add(mntmTipoDeDocumento);
		
		JMenuItem mntmEspecialista = new JMenuItem("Especialista");
		mnMantenimiento.add(mntmEspecialista);
		
		JMenu mnIncidencia = new JMenu("Incidencia");
		mnPrincipal.add(mnIncidencia);
		
		JMenuItem mntmIngreso = new JMenuItem("Ingreso");
		mnIncidencia.add(mntmIngreso);
		
		JMenuItem mntmListado = new JMenuItem("Listado");
		mnIncidencia.add(mntmListado);
		
		JMenuItem mntmActualizacin = new JMenuItem("Actualizaci\u00F3n");
		mnIncidencia.add(mntmActualizacin);
		
		JMenu mnReportes = new JMenu("Reportes");
		mnPrincipal.add(mnReportes);
		
		JMenuItem mntmBsquedaDeIncidencias = new JMenuItem("Incidencias por Area");
		mnReportes.add(mntmBsquedaDeIncidencias);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Incidencia por tipo");
		mnReportes.add(mntmNewMenuItem_1);
		
		JMenuItem mntmBusquedaDeIncidencia = new JMenuItem("Incidencia por rango de fecha");
		mnReportes.add(mntmBusquedaDeIncidencia);
		
		JMenuItem mntmIncenciasFalladas = new JMenuItem("Incencias falladas");
		mnReportes.add(mntmIncenciasFalladas);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		mnPrincipal.add(mnAyuda);
		
		JMenuItem mntmAyuda = new JMenuItem("Acerca del programa");
		mnAyuda.add(mntmAyuda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}

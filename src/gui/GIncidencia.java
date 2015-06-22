package gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JLabel;


import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import java.awt.Color;

import javax.swing.border.SoftBevelBorder;

import java.awt.SystemColor;

import javax.swing.JDialog;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import controlador.ArrayEspecialista;
import controlador.ArrayIncidencia;
import controlador.ArrayTipoIncidencia;
import controlador.ArrayUsuario;
import entidades.*;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GIncidencia extends JDialog implements ActionListener{	
	
	/*------------------------------
	 * DECLARAMOS VARIABLES GLOBALES
	 * -----------------------------*/
	ArrayIncidencia inc = new ArrayIncidencia();
	ArrayUsuario usuar = new ArrayUsuario();
	ArrayEspecialista espec = new ArrayEspecialista();
	ArrayTipoIncidencia tipo = new ArrayTipoIncidencia();
	
	/*-----------------------------------*/
	public JPanel panel;
	
	public JButton btnListado;
	public JButton btnLimpiar;
	public JButton btnModificar;
	public JButton btnRegistrar;
	public JButton btnBuscar;
	public JButton btnNuevo;
	public JButton btnLimpiar2;
	public JScrollPane Listado;
	public JScrollPane Incidencia;
	public JLabel lblMensListado1;
	public JLabel lblMensListado2;
	private JTextField txtCodigo;
	private JTextField txtCodUsu;
	private JTextField txtTiempoEstimado;
	private JTextField txtTiempoReal;
	private JTextField txtFecRegistro;
	private JTextField txtFecInicio;
	private JTextField txtFecFinal;
	private JTextArea txtIncidencia;
	private JTextArea txtDescripcion;
	private JTextArea txtObservacion;
	private JTextArea txtListado;
	private JComboBox cboTipoInc;
	private JComboBox cboEspecialista;
	private JComboBox cboEstado;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GIncidencia frame = new GIncidencia();
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
	public GIncidencia() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(GIncidencia.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));		
		setResizable(false);
		setTitle("  Ingresar Nueva GIncidencia");
		setBounds(100, 100, 887, 575);
		getContentPane().setLayout(null);
		
		lblMensListado2 = new JLabel("FEC ULTIMA:");
		lblMensListado2.setVisible(false);
		lblMensListado2.setBounds(349, 64, 163, 19);
		getContentPane().add(lblMensListado2);
		
		lblMensListado1 = new JLabel("EXISTEN:");
		lblMensListado1.setVisible(false);
		lblMensListado1.setBounds(10, 64, 163, 19);
		getContentPane().add(lblMensListado1);
				
		panel = new JPanel();
		panel.setVisible(false);
		panel.setBounds(10, 11, 319, 515);
		panel.setBackground(new Color(51, 102, 153));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(panel);
		panel.setLayout(null);

		btnListado = new JButton("LISTAR");
		btnListado.setVisible(false);
		btnListado.setBackground(SystemColor.controlShadow);
		btnListado.addActionListener(this);		
		btnListado.setIcon(new ImageIcon(GIncidencia.class.getResource("/com/sun/java/swing/plaf/motif/icons/Warn.gif")));
		
		Incidencia = new JScrollPane();
		Incidencia.setVisible(false);
		Incidencia.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Incidencia.setBounds(339, 103, 522, 423);
		getContentPane().add(Incidencia);
		
		txtIncidencia = new JTextArea();
		Incidencia.setViewportView(txtIncidencia);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.setVisible(false);
		btnNuevo.setIcon(new ImageIcon(GIncidencia.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")));
		btnNuevo.setBackground(SystemColor.controlShadow);
		btnNuevo.setBounds(339, 11, 228, 33);
		getContentPane().add(btnNuevo);
		
		btnNuevo.addActionListener(this);
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setVisible(false);
		btnLimpiar.setIcon(new ImageIcon(GIncidencia.class.getResource("/javax/swing/plaf/metal/icons/sortDown.png")));
		btnLimpiar.setBackground(SystemColor.controlShadow);
		btnLimpiar.setBounds(633, 11, 228, 33);
		getContentPane().add(btnLimpiar);
		btnLimpiar.addActionListener(this);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setVisible(false);
		btnRegistrar.setIcon(new ImageIcon(GIncidencia.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlayDisabled.png")));
		btnRegistrar.setBackground(SystemColor.controlShadow);
		btnRegistrar.setBounds(339, 55, 522, 37);
		getContentPane().add(btnRegistrar);
		btnRegistrar.addActionListener(this);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setVisible(false);
		btnBuscar.setBackground(SystemColor.controlShadow);
		btnBuscar.setIcon(new ImageIcon(GIncidencia.class.getResource("/com/sun/java/swing/plaf/windows/icons/Directory.gif")));
		btnBuscar.setBounds(339, 11, 228, 33);
		getContentPane().add(btnBuscar);
		btnBuscar.addActionListener(this);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setVisible(false);
		btnModificar.setIcon(new ImageIcon(GIncidencia.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-more-details.png")));
		btnModificar.setBackground(SystemColor.controlShadow);
		btnModificar.setBounds(339, 55, 522, 37);
		getContentPane().add(btnModificar);
		btnModificar.addActionListener(this);
		btnListado.setBounds(10, 11, 260, 37);
		getContentPane().add(btnListado);
		
		JLabel lblNewLabel = new JLabel("CODIGO DE USUARIO:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 36, 172, 14);
		panel.add(lblNewLabel);
		
		JLabel lblCodigo = new JLabel("CODIGO DE INCIDENCIA: ");
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setBounds(10, 11, 172, 14);
		panel.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBackground(SystemColor.controlShadow);
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(203, 9, 106, 17);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtCodUsu = new JTextField();
		txtCodUsu.setBackground(SystemColor.controlShadow);
		txtCodUsu.setEditable(false);
		txtCodUsu.setColumns(10);
		txtCodUsu.setBounds(203, 34, 106, 17);
		panel.add(txtCodUsu);
		
		JLabel lblCodigoDeEspecialista = new JLabel("CODIGO DE ESPECIALISTA:");
		lblCodigoDeEspecialista.setForeground(Color.WHITE);
		lblCodigoDeEspecialista.setBounds(10, 61, 172, 14);
		panel.add(lblCodigoDeEspecialista);
		
		JLabel lblCodigoDeTipo = new JLabel("CODIGO DE TIPO DE INCIDENCIA:");
		lblCodigoDeTipo.setForeground(Color.WHITE);
		lblCodigoDeTipo.setBounds(10, 86, 188, 14);
		panel.add(lblCodigoDeTipo);
		
		JLabel lblDescripcion = new JLabel("DESCRIPCION:");
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setBounds(10, 123, 110, 14);
		panel.add(lblDescripcion);
		
		JLabel lblComentariosObservaciones = new JLabel("COMENTARIOS / OBSERVACIONES:");
		lblComentariosObservaciones.setForeground(Color.WHITE);
		lblComentariosObservaciones.setBounds(10, 219, 188, 14);
		panel.add(lblComentariosObservaciones);
		
		JLabel lblTiempoEstimadoDe = new JLabel("TIEMPO ESTIMADO DE SOLUCION:");
		lblTiempoEstimadoDe.setForeground(Color.WHITE);
		lblTiempoEstimadoDe.setBounds(10, 341, 203, 14);
		panel.add(lblTiempoEstimadoDe);
		
		txtTiempoEstimado = new JTextField();
		txtTiempoEstimado.setColumns(10);
		txtTiempoEstimado.setBounds(215, 338, 94, 17);
		panel.add(txtTiempoEstimado);
		
		JLabel lblTiempoRealDe = new JLabel("TIEMPO REAL DE SOLUCION:");
		lblTiempoRealDe.setForeground(Color.WHITE);
		lblTiempoRealDe.setBounds(10, 369, 172, 14);
		panel.add(lblTiempoRealDe);
		
		txtTiempoReal = new JTextField();
		txtTiempoReal.setColumns(10);
		txtTiempoReal.setBounds(215, 366, 94, 17);
		panel.add(txtTiempoReal);
		
		JLabel lblFechaDeRegistro = new JLabel("FECHA DE REGISTRO:");
		lblFechaDeRegistro.setForeground(Color.WHITE);
		lblFechaDeRegistro.setBounds(10, 397, 172, 14);
		panel.add(lblFechaDeRegistro);
		
		txtFecRegistro = new JTextField();
		txtFecRegistro.setBackground(SystemColor.controlShadow);
		txtFecRegistro.setEditable(false);
		txtFecRegistro.setColumns(10);
		txtFecRegistro.setBounds(181, 394, 128, 17);
		panel.add(txtFecRegistro);
		
		JLabel lblFechaDeInicio = new JLabel("FECHA DE INICIO DE ATENCION:");
		lblFechaDeInicio.setForeground(Color.WHITE);
		lblFechaDeInicio.setBounds(10, 425, 188, 14);
		panel.add(lblFechaDeInicio);
		
		txtFecInicio = new JTextField();
		txtFecInicio.setColumns(10);
		txtFecInicio.setBounds(209, 422, 100, 17);
		panel.add(txtFecInicio);
		
		JLabel lblFechaDeFin = new JLabel("FECHA FINAL DE ATENCION:");
		lblFechaDeFin.setForeground(Color.WHITE);
		lblFechaDeFin.setBounds(10, 453, 172, 14);
		panel.add(lblFechaDeFin);
		
		txtFecFinal = new JTextField();
		txtFecFinal.setColumns(10);
		txtFecFinal.setBounds(209, 450, 100, 17);
		panel.add(txtFecFinal);
		
		JLabel lblEstado = new JLabel("ESTADO:");
		lblEstado.setForeground(Color.WHITE);
		lblEstado.setBounds(10, 481, 86, 14);
		panel.add(lblEstado);
		
		cboEstado = new JComboBox();
		cboEstado.setBackground(UIManager.getColor("Button.background"));
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"", "Registrada", "Iniciada", "Cancelada", "Cerrada"}));
		cboEstado.setBounds(137, 478, 172, 20);
		panel.add(cboEstado);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 111, 299, 7);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 326, 299, 14);
		panel.add(separator_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 139, 299, 69);
		panel.add(scrollPane_1);
		
		txtDescripcion = new JTextArea();
		scrollPane_1.setViewportView(txtDescripcion);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 235, 299, 69);
		panel.add(scrollPane_2);
		
		txtObservacion = new JTextArea();
		scrollPane_2.setViewportView(txtObservacion);
		
		cboEspecialista = new JComboBox();
		cboEspecialista.setBounds(203, 58, 106, 20);
		cboEspecialista.addItem("");
		panel.add(cboEspecialista);
		
		cboTipoInc = new JComboBox();
		cboTipoInc.setBounds(203, 83, 106, 20);
		cboTipoInc.addItem("");
		panel.add(cboTipoInc);
		
		btnLimpiar2 = new JButton("LIMPIAR");
		btnLimpiar2.setVisible(false);
		btnLimpiar2.addActionListener(this);
		btnLimpiar2.setIcon(new ImageIcon(GIncidencia.class.getResource("/javax/swing/plaf/metal/icons/sortDown.png")));
		btnLimpiar2.setBackground(SystemColor.controlShadow);
		btnLimpiar2.setBounds(307, 11, 260, 37);
		getContentPane().add(btnLimpiar2);
		
		Listado = new JScrollPane();
		Listado.setVisible(false);
		Listado.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Listado.setBounds(10, 103, 851, 423);
		getContentPane().add(Listado);
		
		txtListado = new JTextArea();
		Listado.setViewportView(txtListado);
		
		llenaCampos();
		
	}
	
	/*-------------------------
	 * METODOS DE ACCION	  * 
	 * -----------------------*/
	String ComboEstado(){
		if(getEstado()==0)		
			return "Registrada";
		else if (getEstado()==1) {
			return "Iniciada";
		}
		else if (getEstado()==2) {
			return "Cancelada";
		}
		else{
			return "Cerrada";
		}
	}
	
	void llenaCampos(){
		
		//COMBO CODIGO ESPECIALISTA
		ArrayList<Especialista> x1 = new ArrayList<Especialista>();
		x1 = espec.ListarEspecialista();
		
		int n[] = new int[espec.tamaño()];
		int indice = 0;

		for (Especialista a : x1) {
			n[indice] = a.getCodEsp();
			indice++;
		}

		for (int i = 0; i < espec.tamaño(); i++) {
			cboEspecialista.addItem(n[i]);
			//System.out.print(n[i]+"\n");
		}
		
		// COMBO CODIGO TIPO DE INCIDENCIA
		ArrayList<TipoIncidencia> x2 = new ArrayList<TipoIncidencia>();
		x2 = tipo.ListarTipoIncidencia();

		int n1[] = new int[espec.tamaño()];
		int indice1 = 0;

		for (TipoIncidencia a : x2) {
			n1[indice1] = a.getCodTipoInc();
			indice1++;
		}

		for (int i = 0; i < espec.tamaño(); i++) {
			cboTipoInc.addItem(n1[i]);
			// System.out.print(n[i]+"\n");
		}
		
		// LLENAMOS FECHA DE REGISTRO
		setFecRegistro(fechaActual());
	}
	
	public static String fechaActual(){
		Date fecha = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(fecha);
	}
	
	/*---------------------------
	 *  GET/SET DE EL PANEL
	 *---------------------------*/
	
	public int getCodigo() {
		return Integer.parseInt(txtCodigo.getText());
	}

	public void setCodigo(int txtCodInc) {
		this.txtCodigo.setText(""+txtCodInc);
	}

	public int getCodUsu() {
		return Integer.parseInt(txtCodUsu.getText());
	}

	public void setCodUsu(int txtCodUsu) {
		this.txtCodUsu.setText(""+txtCodUsu);
	}
	
	public String getCodEsp(){
		return cboEspecialista.getSelectedItem().toString();
	}
	
	public void setCodEsp(int pos){
		cboEspecialista.setSelectedIndex(pos);
	}
	
	public String getCodTipo(){
		return cboTipoInc.getSelectedItem().toString();
	}
	
	public void setCodTipo(int pos){
		cboTipoInc.setSelectedIndex(pos);
	}
	
	public int getTiempoEstimado() {
		return Integer.parseInt(txtTiempoEstimado.getText());
	}

	public void setTiempoEstimado(int txtTiempoEstimado) {
		this.txtTiempoEstimado.setText(""+txtTiempoEstimado);
	}

	public int getTiempoReal() {
		return Integer.parseInt(txtTiempoReal.getText());
	}

	public void setTiempoReal(int txtTiempoReal) {
		this.txtTiempoReal.setText(""+txtTiempoReal);
	}

	public String getFecRegistro() {
		return txtFecRegistro.getText();
	}

	public void setFecRegistro(String txtFecRegistro) {
		this.txtFecRegistro.setText(txtFecRegistro);
	}

	public String getFecInicio() {
		return txtFecInicio.getText();
	}

	public void setFecInicio(String txtFecInicio) {
		this.txtFecInicio.setText(txtFecInicio);
	}

	public String getFecFinal() {
		return txtFecFinal.getText();
	}

	public void setFecFinal(String txtFecFinal) {
		this.txtFecFinal.setText(txtFecFinal);
	}
	
	public int getEstado(){
		return cboEstado.getSelectedIndex();
	}
	
	public void setEstado(int pos){
		cboEstado.setSelectedIndex(pos);
	}
	
	/*---- GET/SET DE LOS TEXT AREAS ----*/
	
	public String getTxtIncidencia() {
		return txtIncidencia.getText();
	}

	public void setIncidencia(String txtIncidencia) {
		this.txtIncidencia.setText(txtIncidencia);
	}

	public String getDescripcion() {
		return txtDescripcion.getText();
	}

	public void setDescripcion(String txtDescripcion) {
		this.txtDescripcion.setText(txtDescripcion);
	}

	public String getObservacion() {
		return txtObservacion.getText();
	}

	public void setObservacion(String txtObservacion) {
		this.txtObservacion.setText(txtObservacion);
	}
	
	/*-----------------------
	 * ACTION EVENT
	 *-----------------------*/
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnNuevo){
			setCodigo(inc.GeneraCodigo());
		}
		if (e.getSource()==btnLimpiar) {
			
		}
		if (e.getSource()==btnBuscar) {
			
		}
		if (e.getSource()==btnRegistrar) {			
			registrar();
		}
		if (e.getSource()==btnModificar) {
			
		}
		if (e.getSource()==btnListado) {
			
		}
	}
	
	/*-----------------------------
	 * 	METODOS DE LOS BOTONES
	 * ---------------------------*/
	void registrar(){
		
	}
}

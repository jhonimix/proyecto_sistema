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
import javax.swing.JOptionPane;
import javax.swing.JViewport;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
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

import javax.swing.JTable;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GIncidencia extends JDialog implements ActionListener{	
	
	/*------------------------------
	 * DECLARAMOS VARIABLES GLOBALES
	 * -----------------------------*/
	ArrayIncidencia inc = new ArrayIncidencia();
	ArrayUsuario usuar = new ArrayUsuario();
	ArrayEspecialista espec = new ArrayEspecialista();
	ArrayTipoIncidencia tipo = new ArrayTipoIncidencia();
	
	DefaultTableModel tabla = new DefaultTableModel();
	
	/*-----------------------------------*/
	public JPanel panel;
	
	public JButton btnListado;
	public JButton btnLimpiar;
	public JButton btnModificar;
	public JButton btnRegistrar;
	public JButton btnBuscar;
	public JButton btnNuevo;
	public JButton btnLimpiar2;
	public JButton btnImprimir;
	public JScrollPane Incidencia;
	public JScrollPane Listado;
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
	private JComboBox cboTipoInc;
	private JComboBox cboEspecialista;
	private JComboBox cboEstado;
	private JTable TablaIncidencias;
	
	public void columnas() {
		tabla.addColumn("Codigo de Inc.");
		tabla.addColumn("Nombre de Usuario");
		tabla.addColumn("Nombre de Especialista");
		tabla.addColumn("Tipo de Incidencia");
		tabla.addColumn("Descripcion");
		tabla.addColumn("Comentarios u Observaciones");
		tabla.addColumn("Tiempo Estimado");
		tabla.addColumn("Tiempo Real");
		tabla.addColumn("Fecha de Registro");
		tabla.addColumn("Fecha de Inicio");
		tabla.addColumn("Fecha de Fin");
		tabla.addColumn("Estado de Incidencia");
		//MOSTRAMOS LOS CAMPOS EN TABLA
		TablaIncidencias.setModel(tabla);
	}

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
		lblMensListado2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMensListado2.setVisible(false);
		lblMensListado2.setBounds(349, 64, 163, 19);
		getContentPane().add(lblMensListado2);
		
		lblMensListado1 = new JLabel("");
		lblMensListado1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMensListado1.setBounds(10, 64, 319, 19);
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
		Incidencia.setBounds(339, 103, 522, 388);
		getContentPane().add(Incidencia);
		
		txtIncidencia = new JTextArea();
		txtIncidencia.setFont(new Font("Arial", Font.PLAIN, 17));
		txtIncidencia.setToolTipText("");
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
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCodigo.setBackground(SystemColor.controlShadow);
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(203, 9, 106, 17);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtCodUsu = new JTextField();
		txtCodUsu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCodUsu.setHorizontalAlignment(SwingConstants.RIGHT);
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
		lblComentariosObservaciones.setBounds(10, 183, 188, 14);
		panel.add(lblComentariosObservaciones);
		
		JLabel lblTiempoEstimadoDe = new JLabel("TIEMPO ESTIMADO DE SOLUCION:");
		lblTiempoEstimadoDe.setForeground(Color.WHITE);
		lblTiempoEstimadoDe.setBounds(10, 271, 203, 14);
		panel.add(lblTiempoEstimadoDe);
		
		txtTiempoEstimado = new JTextField();
		txtTiempoEstimado.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar()))
					e.consume();	
			}
		});
		txtTiempoEstimado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTiempoEstimado.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTiempoEstimado.setColumns(10);
		txtTiempoEstimado.setBounds(215, 268, 94, 17);
		panel.add(txtTiempoEstimado);
		
		JLabel lblTiempoRealDe = new JLabel("TIEMPO REAL DE SOLUCION:");
		lblTiempoRealDe.setForeground(Color.WHITE);
		lblTiempoRealDe.setBounds(10, 299, 172, 14);
		panel.add(lblTiempoRealDe);
		
		txtTiempoReal = new JTextField();
		txtTiempoReal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar()))
					e.consume();
			}
		});
		txtTiempoReal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTiempoReal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTiempoReal.setColumns(10);
		txtTiempoReal.setBounds(215, 296, 94, 17);
		panel.add(txtTiempoReal);
		
		JLabel lblFechaDeRegistro = new JLabel("FECHA DE REGISTRO:");
		lblFechaDeRegistro.setForeground(Color.WHITE);
		lblFechaDeRegistro.setBounds(10, 327, 172, 14);
		panel.add(lblFechaDeRegistro);
		
		txtFecRegistro = new JTextField();
		txtFecRegistro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtFecRegistro.setHorizontalAlignment(SwingConstants.RIGHT);
		txtFecRegistro.setBackground(SystemColor.controlShadow);
		txtFecRegistro.setEditable(false);
		txtFecRegistro.setColumns(10);
		txtFecRegistro.setBounds(181, 324, 128, 17);
		panel.add(txtFecRegistro);
		
		JLabel lblFechaDeInicio = new JLabel("FECHA DE INICIO DE ATENCION:");
		lblFechaDeInicio.setForeground(Color.WHITE);
		lblFechaDeInicio.setBounds(10, 355, 188, 14);
		panel.add(lblFechaDeInicio);
		
		txtFecInicio = new JTextField();
		txtFecInicio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar()) && e.getKeyChar()!='-')
					e.consume();
			}
		});
		txtFecInicio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtFecInicio.setHorizontalAlignment(SwingConstants.RIGHT);
		txtFecInicio.setColumns(10);
		txtFecInicio.setBounds(209, 352, 100, 17);
		panel.add(txtFecInicio);
		
		JLabel lblFechaDeFin = new JLabel("FECHA FINAL DE ATENCION:");
		lblFechaDeFin.setForeground(Color.WHITE);
		lblFechaDeFin.setBounds(10, 383, 172, 14);
		panel.add(lblFechaDeFin);
		
		txtFecFinal = new JTextField();
		txtFecFinal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar()) && e.getKeyChar()!='-')
					e.consume();
			}
		});
		txtFecFinal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtFecFinal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtFecFinal.setColumns(10);
		txtFecFinal.setBounds(209, 380, 100, 17);
		panel.add(txtFecFinal);
		
		JLabel lblEstado = new JLabel("ESTADO:");
		lblEstado.setForeground(Color.WHITE);
		lblEstado.setBounds(10, 411, 86, 14);
		panel.add(lblEstado);
		
		cboEstado = new JComboBox();
		cboEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboEstado.setBackground(UIManager.getColor("Button.background"));
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"", "Registrada", "Iniciada", "Cancelada", "Cerrada"}));
		cboEstado.setBounds(137, 408, 172, 20);
		panel.add(cboEstado);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 111, 299, 7);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 243, 299, 14);
		panel.add(separator_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 148, 299, 24);
		panel.add(scrollPane_1);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(!Character.isLetter(arg0.getKeyChar()) && arg0.getKeyChar()!=' '&& arg0.getKeyChar()!='.')
					arg0.consume();				
			}
		});
		txtDescripcion.setFont(new Font("Monospaced", Font.PLAIN, 14));
		scrollPane_1.setViewportView(txtDescripcion);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 208, 299, 24);
		panel.add(scrollPane_2);
		
		txtObservacion = new JTextArea();
		txtObservacion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isLetter(e.getKeyChar()) && e.getKeyChar()!=' '&& e.getKeyChar()!='.' && e.getKeyChar()!=',')
					e.consume();	
			}
		});
		txtObservacion.setFont(new Font("Monospaced", Font.PLAIN, 14));
		scrollPane_2.setViewportView(txtObservacion);
		
		cboEspecialista = new JComboBox();
		cboEspecialista.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboEspecialista.setBounds(203, 58, 106, 20);
		cboEspecialista.addItem("");
		panel.add(cboEspecialista);
		
		cboTipoInc = new JComboBox();
		cboTipoInc.setFont(new Font("Tahoma", Font.PLAIN, 13));
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
		
		btnImprimir = new JButton("IMPRIMIR");
		btnImprimir.addActionListener(this);
		btnImprimir.setIcon(new ImageIcon(GIncidencia.class.getResource("/sun/print/resources/orientLandscape.png")));
		btnImprimir.setBounds(633, 493, 228, 33);
		getContentPane().add(btnImprimir);

		Listado = new JScrollPane(TablaIncidencias);
		Listado.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JViewport viewport = new JViewport();
		Listado.setRowHeaderView(viewport);
		Listado.setVisible(false);
		Listado.setBounds(10, 99, 861, 347);
		getContentPane().add(Listado);
		
		TablaIncidencias = new JTable();
		TablaIncidencias.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TablaIncidencias.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		Listado.setViewportView(TablaIncidencias);
		columnas();
		tamañoColumnas();
		
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
		
		lblMensListado1.setText("INCIDENCIAS REGISTRADAS EN TOTAL: " + "\t" + inc.CantIncidencias());
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
	
	public int getCodEsp(){
		return Integer.parseInt(cboEspecialista.getSelectedItem().toString());
	}
	
	public void setCodEsp(int pos){
		cboEspecialista.setSelectedIndex(pos);
	}
	
	public int getCodTipo(){
		return Integer.parseInt(cboTipoInc.getSelectedItem().toString());
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

	public String getIncidencia(){
		return txtIncidencia.getText();
	}
	
	public void setIncidencia(String txtIncidencia) {
		this.txtIncidencia.append(txtIncidencia);
	}

	public String getDescripcion() {
		return txtDescripcion.getText();
	}

	public void setDescripcion(String txtDescripcion) {
		this.txtDescripcion.append(txtDescripcion);
	}

	public String getObservacion() {
		return txtObservacion.getText();
	}

	public void setObservacion(String txtObservacion) {
		this.txtObservacion.append(txtObservacion);
	}
	
	/*-----------------------
	 * ACTION EVENT
	 *-----------------------*/
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnNuevo){
			setCodigo(inc.GeneraCodigo());
			limpiar();
		}
		if (e.getSource()==btnLimpiar) {
			limpiar();
		}
		if (e.getSource()==btnBuscar) {
			int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de código"));
			if(codigo!=0){
				buscar(codigo);
			}
			else {
				return;
			}
		}
		if (e.getSource()==btnRegistrar) {
			registrar();
		}
		if (e.getSource()==btnModificar) {
			Incidencia x = inc.buscar(getCodigo());
			if(x == null){
				JOptionPane.showConfirmDialog(null, "El Codigo no existe...!!!");
			}else {
				x.setCodigo(getCodigo());
				x.setCodUsu(getCodUsu());
				x.setCodEsp(getCodEsp());
				x.setCodTipInc(getCodTipo());
				x.setDescripcion(getDescripcion());
				x.setComentarios(getObservacion());
				x.setTiempoEst(getTiempoEstimado());
				x.setTiempoReal(getTiempoReal());
				x.setFecRegistro(getFecRegistro());
				x.setFecInicio(getFecInicio());
				x.setFecFin(getFecFinal());
				x.setEstado(getEstado());
			}
		}
		if (e.getSource()==btnListado) {
			
		}
		if (e.getSource()==btnImprimir){
			JOptionPane.showConfirmDialog(null,getIncidencia(),"Sistema de Gestion de Incidencias",0);
		}
	}
	
	/*-----------------------------
	 * 	METODOS DE LOS BOTONES
	 * ---------------------------*/
	void registrar(){
		Incidencia x = inc.buscar(getCodigo());
		if(x==null){
			
			Incidencia objInc = new Incidencia(getCodigo(),getCodUsu(),getCodEsp(),getCodTipo(),getDescripcion(),
					   getObservacion(),getTiempoEstimado(),getTiempoReal(),getFecRegistro(),
					   getFecInicio(),getFecFinal(),getEstado());
			inc.adicionar(objInc);
			listar(objInc);
		}else {
			JOptionPane.showMessageDialog(null, "La incidencia ya está registrada...!! NJD");
		}
		
	}
	void buscar(int cod){
		Incidencia x = inc.buscar(cod);
		setCodigo(x.getCodigo());
		setCodUsu(x.getCodUsu());
		setCodEsp(x.getCodEsp());
		setCodTipo(x.getCodTipInc());
		setDescripcion(x.getDescripcion());
		setObservacion(x.getComentarios());
		setTiempoEstimado(x.getTiempoEst());
		setTiempoReal(x.getTiempoReal());
		setFecRegistro(x.getFecRegistro());
		setFecInicio(x.getFecInicio());
		setFecFinal(x.getFecFin());
		setEstado(x.getEstado());
	}
	
	void listado(){
		
	}
	
	void limpiar(){
		setCodEsp(0);
		setCodTipo(0);
		setDescripcion("");
		setObservacion("");
		setTiempoEstimado(0);
		setTiempoReal(0);
		setFecRegistro("");
		setFecInicio("");
		setFecFinal("");
		setEstado(0);
		setIncidencia("");
	}

	void tamañoColumnas() {
		DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
		modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);

		TableColumn a = TablaIncidencias.getColumn("Codigo de Inc.");
		a.setPreferredWidth(90);
		a.setCellRenderer(modelocentrar);
		TableColumn b = TablaIncidencias.getColumn("Nombre de Usuario");
		b.setPreferredWidth(170);
		b.setCellRenderer(modelocentrar);
		TableColumn c = TablaIncidencias.getColumn("Nombre de Especialista");
		c.setPreferredWidth(170);
		c.setCellRenderer(modelocentrar);
		TableColumn d = TablaIncidencias.getColumn("Tipo de Incidencia");
		d.setPreferredWidth(120);
		d.setCellRenderer(modelocentrar);
		TableColumn e = TablaIncidencias.getColumn("Descripcion");
		e.setPreferredWidth(300);
		e.setCellRenderer(modelocentrar);
		TableColumn f = TablaIncidencias.getColumn("Comentarios u Observaciones");
		f.setPreferredWidth(300);
		f.setCellRenderer(modelocentrar);
		TableColumn g = TablaIncidencias.getColumn("Tiempo Estimado");
		g.setPreferredWidth(110);
		g.setCellRenderer(modelocentrar);
		TableColumn h = TablaIncidencias.getColumn("Tiempo Real");
		h.setPreferredWidth(90);
		h.setCellRenderer(modelocentrar);
		TableColumn i = TablaIncidencias.getColumn("Fecha de Registro");
		i.setPreferredWidth(125);
		i.setCellRenderer(modelocentrar);
		TableColumn j = TablaIncidencias.getColumn("Fecha de Inicio");
		j.setPreferredWidth(125);
		j.setCellRenderer(modelocentrar);
		TableColumn k = TablaIncidencias.getColumn("Fecha de Fin");
		k.setPreferredWidth(125);
		k.setCellRenderer(modelocentrar);
		TableColumn l = TablaIncidencias.getColumn("Estado de Incidencia");
		l.setPreferredWidth(120);
		l.setCellRenderer(modelocentrar);
	}
	
	void listar(Incidencia z){
		imprimir("");
		imprimir("\t"+"   REGISTRO DE INCIDENCIAS");
		imprimir("");
		imprimir("INCIDENCIA NUMERO: " + "\t"+"\t"+ z.getCodigo());
		imprimir("CODIGO DE USUARIO: " + "\t"+"\t"+ z.getCodUsu());
		imprimir("CODIGO DE ESPECIALISTA: " + "\t"+ z.getCodEsp());
		imprimir("CODIGO DEL TIPO DE INCIDENCIA: " + "\t"+ z.getCodTipInc());
		imprimir("DESCRIPCION: " + "\t"+ "\t"+z.getDescripcion());
		imprimir("OBSERVACION / COMENTARIOS: " + "\t"+ z.getComentarios());
		imprimir("TIEMPO ESTIMADO DE SOLUCION: " + "\t"+ z.getTiempoEst());
		imprimir("TIEMPO REAL DE SOLUCION: " + "\t"+ z.getTiempoReal());
		imprimir("FECHA DE REGISTRO: " + "\t"+ "\t"+ z.getFecRegistro());
		imprimir("FECHA DE INICIO DE ATENCION: " + "\t"+ z.getFecInicio());
		imprimir("FECHA DE FINAL DE ATENCION: " + "\t"+ z.getFecFin());
		imprimir("ESTADO DE LA INCIDENCIA: " + "\t"+ z.getEstado());
	}
	
	void imprimir(String s){
		setIncidencia(s+"\n");
	}
}

package gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import entidades.Area;
import entidades.TipoDocumento;
import entidades.Usuario;
import clases.Estado;
import clases.ValidarEmail;
import controlador.ArrayArea;
import controlador.ArrayDocumento;
import controlador.ArrayUsuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Window.Type;
import java.awt.Toolkit;

public class MantenimientoUsuarios extends JDialog implements ActionListener, MouseListener, KeyListener{

	//DECLARAMOS VARIABLES GLOBALES
	ArrayUsuario a = new ArrayUsuario();
	ArrayArea b = new ArrayArea();
	ArrayDocumento c = new ArrayDocumento();
	
	DefaultTableModel tabla = new DefaultTableModel();
	Estado obje = new Estado();
	
	private JLabel lblCodigo;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblCodigoDoc;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtCodigo;
	private JLabel lblDocumentoDeIndentidad;
	private JLabel lblArea;
	private JLabel lblCorreo;
	private JLabel lblTelfono;
	private JTextField txtDocumento;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JLabel lblMantenimientoDeUsuarios;
	private JLabel lblFechaDeIngreso;
	private JLabel lblEstado;
	private JTextField txtFechaIng;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JButton btnNuevo;
	private JButton btnRegistrar;
	private JTable tablaUsuarios;
	private JLabel lblNewLabel;
	private JButton btnBuscar;
	private JComboBox<String> cboDocUsu,cboAreaUsu,cboStatusUsu;
	private JSeparator separator;
	private JLabel mensaje1;

	public void campos() {
		tabla.addColumn("Codigo");
		tabla.addColumn("Nombres");
		tabla.addColumn("Apellidos");
		tabla.addColumn("CodDoc");
		tabla.addColumn("Documento");
		tabla.addColumn("Area");
		tabla.addColumn("Correo");
		tabla.addColumn("Telefono");
		tabla.addColumn("Fecha");
		tabla.addColumn("Estado");
		//MOSTRAMOS LOS CAMPOS EN TABLA
		tablaUsuarios.setModel(tabla);
	}

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MantenimientoUsuarios dialog = new MantenimientoUsuarios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MantenimientoUsuarios() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MantenimientoUsuarios.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));
		setResizable(false);
		setType(Type.POPUP);
		setTitle("Mantenimiento de Usuario");

		setBounds(100, 100, 981, 711);
		getContentPane().setLayout(null);
		
		mensaje1 = new JLabel("Formato de Fecha \"dd-MM-yyyyy\"");
		mensaje1.setIcon(new ImageIcon(MantenimientoUsuarios.class.getResource("/com/sun/deploy/uitoolkit/impl/fx/ui/resources/image/graybox_error.png")));
		mensaje1.setForeground(Color.RED);
		mensaje1.setBounds(481, 216, 211, 25);
		getContentPane().add(mensaje1);
		mensaje1.setVisible(false);

		lblCodigo = new JLabel("Codigo de Usuario :");
		lblCodigo.setBounds(10, 90, 130, 25);
		getContentPane().add(lblCodigo);

		lblNombres = new JLabel("Nombres :");
		lblNombres.setBounds(10, 126, 130, 25);
		getContentPane().add(lblNombres);

		lblApellidos = new JLabel("Apellidos :");
		lblApellidos.setBounds(10, 162, 130, 25);
		getContentPane().add(lblApellidos);

		lblCodigoDoc = new JLabel("Codigo de Tipo Documento :");
		lblCodigoDoc.setBounds(10, 198, 157, 25);
		getContentPane().add(lblCodigoDoc);

		txtNombres = new JTextField();
		txtNombres.addKeyListener(this);
		txtNombres.setBounds(177, 126, 157, 25);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);

		txtApellidos = new JTextField();
		txtApellidos.addKeyListener(this);
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(177, 162, 157, 25);
		getContentPane().add(txtApellidos);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(178, 90, 50, 25);
		getContentPane().add(txtCodigo);

		lblDocumentoDeIndentidad = new JLabel("Documento de Indentidad :");
		lblDocumentoDeIndentidad.setBounds(10, 234, 168, 25);
		getContentPane().add(lblDocumentoDeIndentidad);

		lblArea = new JLabel("Area :");
		lblArea.setBounds(367, 90, 89, 25);
		getContentPane().add(lblArea);

		lblCorreo = new JLabel("Correo :");
		lblCorreo.setBounds(367, 126, 97, 25);
		getContentPane().add(lblCorreo);

		lblTelfono = new JLabel("Telefono :");
		lblTelfono.setBounds(367, 162, 97, 25);
		getContentPane().add(lblTelfono);

		txtDocumento = new JTextField();
		txtDocumento.addKeyListener(this);
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(177, 234, 120, 25);
		getContentPane().add(txtDocumento);

		txtCorreo = new JTextField();
		txtCorreo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				boolean status= ValidarEmail.validateEmail(txtCorreo.getText());
				if(status){
				}
				else{
					JOptionPane.showMessageDialog(null,"Correo Invalido");
					txtCorreo.requestFocus();
				}
			}
		});
		txtCorreo.addKeyListener(this);
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(483, 126, 195, 25);
		getContentPane().add(txtCorreo);

		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(this);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(483, 162, 97, 25);
		getContentPane().add(txtTelefono);

		lblMantenimientoDeUsuarios = new JLabel("MANTENIMIENTO DE USUARIOS");
		lblMantenimientoDeUsuarios.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMantenimientoDeUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoDeUsuarios.setBounds(10, 11, 948, 40);
		getContentPane().add(lblMantenimientoDeUsuarios);

		lblFechaDeIngreso = new JLabel("Fecha de Ingreso :");
		lblFechaDeIngreso.setBounds(367, 198, 114, 25);
		getContentPane().add(lblFechaDeIngreso);

		lblEstado = new JLabel("Estado :");
		lblEstado.setBounds(367, 234, 89, 25);
		getContentPane().add(lblEstado);

		txtFechaIng = new JTextField();
		txtFechaIng.addKeyListener(this);
		txtFechaIng.setColumns(10);
		txtFechaIng.setBounds(483, 198, 97, 25);
		getContentPane().add(txtFechaIng);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(208, 302, 89, 23);
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(406, 302, 89, 23);
		getContentPane().add(btnEliminar);

		scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		scrollPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setBounds(10, 359, 955, 271);
		getContentPane().add(scrollPane);

		tablaUsuarios = new JTable();
		tablaUsuarios.addMouseListener(this);
		scrollPane.setViewportView(tablaUsuarios);
		campos();
		mostrarUsuarios();

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(10, 302, 89, 23);
		getContentPane().add(btnNuevo);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(109, 302, 89, 23);
		getContentPane().add(btnRegistrar);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblNewLabel.setBounds(716, 95, 211, 214);
		getContentPane().add(lblNewLabel);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(307, 302, 89, 23);
		getContentPane().add(btnBuscar);

		cboAreaUsu = new JComboBox<String>();
		cboAreaUsu.setBounds(483, 92, 195, 20);
		cboAreaUsu.addItem("");
		getContentPane().add(cboAreaUsu);

		cboStatusUsu = new JComboBox<String>();
		cboStatusUsu.setBounds(483, 236, 140, 20);
		getContentPane().add(cboStatusUsu);

		cboDocUsu = new JComboBox<String>();
		cboDocUsu.setBounds(177, 200, 120, 20);
		cboDocUsu.addItem("");
		getContentPane().add(cboDocUsu);
		
		separator = new JSeparator();
		separator.setBounds(10, 62, 948, 7);
		getContentPane().add(separator);
		
		
		llenarCombos();

	}

	public ImageIcon getIcon(String icono, String size) {
		size = "16";
		java.net.URL imgUrl = getClass().getResource("img/" + size + "/" + icono);
		if(imgUrl != null){
			ImageIcon imgIcon = new ImageIcon(imgUrl);
			return imgIcon;
		} 
		else{
			System.out.println("Error no se encontro el archivo " + icono);
		}
		return null;
	}
	/* ---------------------
	
	* 	LLENAR COMBOS		*
	 
	------------------------*/
	private void llenarCombos() {
		// COMBO TIPO DE DOCUMENTO
		ArrayList<TipoDocumento> x1 = new ArrayList<TipoDocumento>();
		x1 = c.ListarDocumento();

		String n[] = new String[c.tamaño()];
		int indice = 0;

		for (TipoDocumento a : x1) {
			n[indice] = a.getAbrDoc();
			indice++;
		}

		for (int i = 0; i < c.tamaño(); i++) {
			cboDocUsu.addItem(n[i]);
			//System.out.print(n[i]+"\n");
		}

		// COMBO AREA
		ArrayList<Area> x2 = new ArrayList<Area>();
		x2 = b.ListarArea();

		String n2[] = new String[b.tamaño()];
		int indice2 = 0;

		for (Area b : x2) {
			n2[indice2] = b.getNameSmallArea();
			indice2++;
		}

		for (int i = 0; i < b.tamaño(); i++) {
			cboAreaUsu.addItem(n2[i]);
			// System.out.print(n2[i]+",");
		}

		// COMBO ESTADO
		cboStatusUsu.addItem(obje.getNombre0());
		cboStatusUsu.addItem(obje.getNombre1());
	}

	// METODOS

	int getCodigo() {
		return Integer.parseInt(txtCodigo.getText());
	}

	String getNombre() {
		return txtNombres.getText();
	}

	String getApellidos() {
		return txtApellidos.getText();
	}

	
	String getDocumento() {
		return txtDocumento.getText();
	}

	
	String getCorreo() {
		return txtCorreo.getText();
	}

	String getTelefono() {
		return txtTelefono.getText();
	}

	String getFechaIng() {
		return txtFechaIng.getText();
	}

	
	int getEstado() {		//COMBOBOX
		return cboStatusUsu.getSelectedIndex();
	}

	int getArea() {			//COMBOBOX
		return cboAreaUsu.getSelectedIndex();
	}
	
	int getCodDocum() {		//COMBOBOX
		return cboDocUsu.getSelectedIndex();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrar) {
			do_btnRegistrar_actionPerformed(e);
		}
		if (e.getSource() == btnNuevo) {
			do_btnNuevo_actionPerformed(e);
		}
	}

	//AL DAR CLIC EN UNA FILA MUESTRA LOS DATOS EN LOS TEXTBOX
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tablaUsuarios) {
			do_tabla_usuarios_mouseClicked(arg0);
		}
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}
	
	protected void do_tabla_usuarios_mouseClicked(MouseEvent arg0) {
		int fila = tablaUsuarios.getSelectedRow();		
		LlenarInputs(fila);
	}
	
	//ACCIONES DE LOS BOTONES
	
	protected void do_btnNuevo_actionPerformed(ActionEvent e) {
		txtCodigo.setText("" + a.GeneraCodigo());
		limpiar();				
	}

	protected void do_btnRegistrar_actionPerformed(ActionEvent e) {
		Usuario x = a.buscar(getCodigo());
		if (x == null) {
			x = new Usuario(getCodigo(), getNombre(), getApellidos(), getCodDocum(), getDocumento(), 
							getArea(), getCorreo(), getTelefono(), getFechaIng(), getEstado());
			a.adicionar(x);
		} else {
			JOptionPane.showMessageDialog(null, "El Usuario ya existe...!! NJD");
		}
		rellenarTabla();
		a.grabar();
		mostrarUsuarios();

	}

	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		Usuario u = a.buscar(getCodigo());
		if (u == null) {
			JOptionPane.showConfirmDialog(null, "El Codigo no existe...!!!");
		} else {
			u.setNameUser(getNombre());
			u.setLastnameUser(getApellidos());
			u.setCodDocUser(getCodDocum());
			u.setDniUser(getDocumento());
			u.setArea(getArea());
			u.setEmail(getCorreo());
			u.setFono(getTelefono());
			u.setFechaIngreso(getFechaIng());
			u.setStatus(getEstado());
			a.grabar();
			mostrarUsuarios();
		}
	}

	protected void do_btnEliminar_actionPerformed(ActionEvent e) {

		Usuario z = a.buscar(getCodigo());
		if (z == null) {
			JOptionPane.showMessageDialog(null, "El usuario no existe..!!");
		} else {
			a.eliminar(z);
			JOptionPane.showMessageDialog(null,	"La operación se realizo con éxtio");

		}
		a.grabar();
		mostrarUsuarios();

	}

	protected void do_btnBuscar_actionPerformed(ActionEvent e) {

		//MUESTRA VENTANA PARA COLOCAR EL CODIGO A BUSCAR
		int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de código"));
		
		//BUSCA EL OBJETO EN EL ARREGLO Y GUARDA LA INFORMACION EN EL OBJETO "x"
		Usuario x = a.buscar(codigo);

		if (x == null){
			JOptionPane.showMessageDialog(null, "El usuario no existe..!!");
			return;
		}
		else {
			
			//FILA ALMACENA EL CODIGO DEL OBJETO
			int fila = x.getCodUser();
			
			for(int i=0; i<=tabla.getRowCount();i++){
				if(tabla.getValueAt(i,0).equals(fila)){		
					LlenarInputs(i);
					break;
				}
			}
			
		}
		
	}
	//METODOS PARA EL FORMULARIO
	public void rellenarTabla() {		
		tabla.addRow(new Object[] { getCodigo(), getNombre(), getApellidos(), getCodDocum(), getDocumento(), 
									getArea(), getCorreo(), getTelefono(), getFechaIng(), getEstado() });
		tablaUsuarios.setModel(tabla);
	}

	public void mostrarUsuarios() {	
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		lista = a.ListarUsuario();
		tabla.setRowCount(0);
		//System.out.println(lista);
		for (Usuario x : lista) {
			tabla.addRow(new Object[] { x.getCodUser(), x.getNameUser(), x.getLastnameUser(),c.bnombre(x.getCodDocUser()), x.getDniUser(),
										b.bnombre(x.getArea()), x.getEmail(), x.getFono(), x.getFechaIngreso(),obje.bnombre(x.getStatus())});

		}
		tablaUsuarios.setModel(tabla);
	}
	//RELLENAR LOS INPUTS CON LOS DATOS DE CADA FINA DE LA TABLA
	public void LlenarInputs(int fila){		
		
		txtCodigo.setText(tabla.getValueAt(fila, 0).toString());
		Usuario x = a.buscar(Integer.parseInt(txtCodigo.getText()));
		
		txtNombres.setText(tabla.getValueAt(fila, 1).toString());
		txtApellidos.setText(tabla.getValueAt(fila, 2).toString());
		cboDocUsu.setSelectedIndex(x.getCodDocUser()); 					//COLUMNA 3
		txtDocumento.setText(tabla.getValueAt(fila, 4).toString());
		cboAreaUsu.setSelectedIndex(x.getArea());						//COLUMNA 5
		txtCorreo.setText(tabla.getValueAt(fila, 6).toString());
		txtTelefono.setText(tabla.getValueAt(fila, 7).toString());
		txtFechaIng.setText(tabla.getValueAt(fila, 8).toString());
		cboStatusUsu.setSelectedIndex(x.getStatus()); 					//COLUMNA 9
		
	}
	
	public void limpiar() {
		txtNombres.setText("");
		txtApellidos.setText("");
		txtDocumento.setText("");
		txtCorreo.setText("");
		txtFechaIng.setText("");
		txtTelefono.setText("");
		cboAreaUsu.setSelectedIndex(0);
		cboDocUsu.setSelectedIndex(0);
		cboStatusUsu.setSelectedIndex(0);
	}
	
	/*---------------
		VALIDACIONES
	*----------------*/
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}


	@Override
	public void keyReleased(KeyEvent e) {		
		// TODO Auto-generated method stub		
	}
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==txtNombres){			
			if(!Character.isLetter(e.getKeyChar()) && e.getKeyChar()!=' ' && e.getKeyChar()!='.'){			
				e.consume();		
			}			
			
		}
		else if (e.getSource()==txtApellidos) {
			if(!Character.isLetter(e.getKeyChar()) && e.getKeyChar()!=' ' && e.getKeyChar()!='.'){			
				e.consume();		
			}	
		}		
		else if (e.getSource()==txtDocumento) {
			if(!Character.isDigit(e.getKeyChar())){			
				e.consume();		
			}	
			if(txtDocumento.getText().length()==8){
				e.consume();
			}
		}
		else if (e.getSource()==txtCorreo) {
			if(!Character.isLetter(e.getKeyChar()) && e.getKeyChar()!='@' && e.getKeyChar()!='.' && !Character.isDigit(e.getKeyChar())){			
				e.consume();
			}	
		}
		else if (e.getSource()==txtTelefono) {
			if(!Character.isDigit(e.getKeyChar()) && e.getKeyChar()!='-'){			
				e.consume();		
			}	
		}
		else if (e.getSource()==txtFechaIng) {
			if(!Character.isDigit(e.getKeyChar()) && e.getKeyChar()!='-'){			
				e.consume();
			}			
			if(txtFechaIng.getText().length()==10){
				mensaje1.setVisible(true);
				e.consume();
			}
		}
		
		
	}
}

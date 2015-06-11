package gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import entidades.Usuario;
import controlador.ArrayUsuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;

public class Mantenimiento_Usuarios extends JDialog implements ActionListener, MouseListener {

	//DECLARAMOS VARIABLES GLOBALES
	ArrayUsuario a = new ArrayUsuario();
	DefaultTableModel tabla = new DefaultTableModel();
	
	private JLabel lblCodigo;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblCodigoDoc;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtCodDoc;
	private JTextField txtCodigo;
	private JLabel lblDocumentoDeIndentidad;
	private JLabel lblArea;
	private JLabel lblCorreo;
	private JLabel lblTelfono;
	private JTextField txtDocumento;
	private JTextField txtArea;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JLabel lblMantenimientoDeUsuarios;
	private JLabel lblFechaDeIngreso;
	private JLabel lblEstado;
	private JTextField txtFechaIng;
	private JTextField txtEstado;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel label;
	private JScrollPane scrollPane;
	private JButton btnNuevo;
	private JButton btnRegistrar;
	private JTable tabla_usuarios;
	private JLabel lblNewLabel;
	private JButton btnBuscar;
	private JComboBox cboDocUsu,cboAreaUsu,cboStatusUsu;

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
		tabla_usuarios.setModel(tabla);
	}

	public void llenar_tabla() {
		tabla.addRow(new Object[] { getCodigo(), getNombre(), getApellidos(), getCodDocum(), getDocumento(), 
									getArea(), getCorreo(), getTelefono(), getFechaIng(), getEstado() });
		tabla_usuarios.setModel(tabla);
	}

	public void mostrar_usuarios() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		lista = a.ListarUsuario();
		tabla.setRowCount(0);
		for (Usuario x : lista) {
			tabla.addRow(new Object[] { x.getCodUser(), x.getNameUser(), x.getLastnameUser(), x.getCodDocUser(), x.getDniUser(),
										x.getArea(), x.getEmail(), x.getFono(), x.getFechaIngreso(), x.getStatus() });

		}
		tabla_usuarios.setModel(tabla);
	}

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Mantenimiento_Usuarios dialog = new Mantenimiento_Usuarios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Mantenimiento_Usuarios() {

		setBounds(100, 100, 981, 711);
		getContentPane().setLayout(null);

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
		txtNombres.setBounds(177, 126, 157, 25);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);

		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(177, 162, 157, 25);
		getContentPane().add(txtApellidos);

		txtCodDoc = new JTextField();
		txtCodDoc.setColumns(10);
		txtCodDoc.setBounds(177, 198, 50, 25);
		getContentPane().add(txtCodDoc);

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
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(177, 234, 106, 25);
		getContentPane().add(txtDocumento);

		txtArea = new JTextField();
		txtArea.setColumns(10);
		txtArea.setBounds(483, 90, 48, 25);
		getContentPane().add(txtArea);

		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(483, 126, 195, 25);
		getContentPane().add(txtCorreo);

		txtTelefono = new JTextField();
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
		txtFechaIng.setColumns(10);
		txtFechaIng.setBounds(483, 198, 97, 25);
		getContentPane().add(txtFechaIng);

		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(483, 234, 48, 25);
		getContentPane().add(txtEstado);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(208, 302, 89, 23);
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(406, 302, 89, 23);
		getContentPane().add(btnEliminar);

		label = new JLabel(
		"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		label.setBounds(10, 54, 959, 25);
		getContentPane().add(label);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 359, 948, 271);
		getContentPane().add(scrollPane);

		tabla_usuarios = new JTable();
		tabla_usuarios.addMouseListener(this);
		scrollPane.setViewportView(tabla_usuarios);
		campos();
		mostrar_usuarios();

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

		cboAreaUsu = new JComboBox();
		cboAreaUsu.setBounds(541, 92, 137, 20);
		cboAreaUsu.addItem("");
		cboAreaUsu.addItem("SISTEMAS");
		cboAreaUsu.addItem("LOGISTICA");
		cboAreaUsu.addItem("RRHH");
		getContentPane().add(cboAreaUsu);

		cboStatusUsu = new JComboBox();
		cboStatusUsu.setBounds(541, 236, 137, 20);
		cboStatusUsu.addItem("ACTIVO");
		cboStatusUsu.addItem("INACTIVO");
		getContentPane().add(cboStatusUsu);

		cboDocUsu = new JComboBox();
		cboDocUsu.setBounds(237, 200, 97, 20);
		cboDocUsu.addItem("");
		cboDocUsu.addItem("DNI");
		cboDocUsu.addItem("LIBRETA MILITAR");
		cboDocUsu.addItem("PASAPORTE");
		getContentPane().add(cboDocUsu);

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

	/*int getCodDocum() {	//TEXTBOX
		return Integer.parseInt(txtCodDoc.getText());
	}*/

	String getDocumento() {
		return txtDocumento.getText();
	}

	/*int getArea() {		//TEXTBOX
		return Integer.parseInt(txtArea.getText());
	}*/

	String getCorreo() {
		return txtCorreo.getText();
	}

	String getTelefono() {
		return txtTelefono.getText();
	}

	String getFechaIng() {
		return txtFechaIng.getText();
	}

	/*int getEstado() {		//TEXTBOX
		return Integer.parseInt(txtEstado.getText());
	}*/
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

	protected void do_btnNuevo_actionPerformed(ActionEvent e) {
		txtCodigo.setText("" + a.GeneraCodigo());
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

	protected void do_btnRegistrar_actionPerformed(ActionEvent e) {
		Usuario x = a.buscar(getCodigo());
		if (x == null) {
			x = new Usuario(getCodigo(), getNombre(), getApellidos(), getCodDocum(), getDocumento(), 
							getArea(), getCorreo(), getTelefono(), getFechaIng(), getEstado());
			a.adicionar(x);
		} else {
			JOptionPane.showMessageDialog(null, "El Usuario ya existe...!! NJD");
		}
		llenar_tabla();
		a.grabar();
		mostrar_usuarios();

	}

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tabla_usuarios) {
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
	
	public void LlenarTextBox(int fila){
		
		txtCodigo.setText(tabla.getValueAt(fila, 0).toString());
		txtNombres.setText(tabla.getValueAt(fila, 1).toString());
		txtApellidos.setText(tabla.getValueAt(fila, 2).toString());
		txtCodDoc.setText(tabla.getValueAt(fila, 3).toString());
		txtDocumento.setText(tabla.getValueAt(fila, 4).toString());
		txtArea.setText(tabla.getValueAt(fila, 5).toString());
		txtCorreo.setText(tabla.getValueAt(fila, 6).toString());
		txtTelefono.setText(tabla.getValueAt(fila, 7).toString());
		txtFechaIng.setText(tabla.getValueAt(fila, 8).toString());
		txtEstado.setText(tabla.getValueAt(fila, 9).toString());
		
		cboStatusUsu.setSelectedIndex(Integer.parseInt(tabla.getValueAt(fila,9).toString()));
		cboAreaUsu.setSelectedIndex(Integer.parseInt(tabla.getValueAt(fila,5).toString()));
		cboDocUsu.setSelectedIndex(Integer.parseInt(tabla.getValueAt(fila,3).toString()));
	}

	protected void do_tabla_usuarios_mouseClicked(MouseEvent arg0) {
		int fila = tabla_usuarios.getSelectedRow();		
		LlenarTextBox(fila);
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
			mostrar_usuarios();
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
		mostrar_usuarios();

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
					LlenarTextBox(i);
					break;
				}
			}
			
		}
		
	}
	
	
	
	
	
	
}

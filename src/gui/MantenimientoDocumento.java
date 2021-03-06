package gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;











//IMPORTAMOS LAS DEPENDENCIAS
import entidades.TipoDocumento;
import controlador.ArrayDocumento;
import clases.Estado;
import clases.general;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

import java.awt.event.KeyAdapter;
import java.awt.Window.Type;
import java.awt.Toolkit;

public class MantenimientoDocumento extends JDialog implements ActionListener, MouseListener, KeyListener {

	/*------------------------------
	 * DECLARAMOS VARIABLES GLOBALES
	 * -----------------------------*/
	/*------------------------------*/
	
	ArrayDocumento c = new ArrayDocumento();
	general img = new general();
	
	DefaultTableModel tabla = new DefaultTableModel();
	Estado obje = new Estado();

	/*------------------------------*/
	private JTextField txtCodigo;
	private JTextField txtDescripcion;
	private JTextField txtAbrev;
	private JTable tablaDocumento;
	private JComboBox cboEstado;
	private JButton btnNuevo;
	private JButton btnRegistrar;
	private JButton btnModificar;
	private JButton btnBuscar;
	private JButton btnEliminar;
	
	public void campos() {
		tabla.addColumn("Codigo");
		tabla.addColumn("Descripcion");
		tabla.addColumn("Abreviatura");
		tabla.addColumn("Estado");
		//MOSTRAMOS LOS CAMPOS EN TABLA
		tablaDocumento.setModel(tabla);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MantenimientoDocumento dialog = new MantenimientoDocumento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	
	public MantenimientoDocumento() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MantenimientoDocumento.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));
		setResizable(false);
		setTitle("Mantenimiento de los Tipos de Documentos");
		setType(Type.POPUP);
		setBounds(100, 100, 553, 528);
		getContentPane().setLayout(null);
		
		JLabel lblMantenimientoTipoDe = new JLabel("");
		lblMantenimientoTipoDe.setIcon(img.getIcon("documentos.png", "fondos"));
		lblMantenimientoTipoDe.setBounds(0, 0, 547, 142);
		getContentPane().add(lblMantenimientoTipoDe);
		
		JLabel lblCodigo = new JLabel("Codigo :");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodigo.setBounds(20, 161, 94, 24);
		getContentPane().add(lblCodigo);
		
		JLabel lblNewLabel = new JLabel("Descripcion :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(20, 196, 94, 24);
		getContentPane().add(lblNewLabel);
		
		JLabel lblAbreviacion = new JLabel("Abreviacion :");
		lblAbreviacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAbreviacion.setBounds(20, 231, 94, 24);
		getContentPane().add(lblAbreviacion);
		
		JLabel lblEstado = new JLabel("Estado :");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstado.setBounds(20, 266, 94, 24);
		getContentPane().add(lblEstado);
		
		txtCodigo = new JTextField();
		txtCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(110, 165, 94, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.addKeyListener(this);
		txtDescripcion.setBounds(110, 199, 183, 20);
		getContentPane().add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		txtAbrev = new JTextField();
		txtAbrev.addKeyListener(this);
		txtAbrev.setBounds(110, 234, 127, 20);
		getContentPane().add(txtAbrev);
		txtAbrev.setColumns(10);
		
		cboEstado = new JComboBox();
		cboEstado.setBounds(110, 269, 127, 20);
		getContentPane().add(cboEstado);
		
		JScrollPane scrollPane = new JScrollPane(tablaDocumento);
		JViewport viewport = new JViewport();
		scrollPane.setRowHeaderView(viewport);
		scrollPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setBounds(10, 308, 526, 180);
		getContentPane().add(scrollPane);
		
		tablaDocumento = new JTable();
		tablaDocumento.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tablaDocumento.addMouseListener(this);
		scrollPane.setViewportView(tablaDocumento);
		campos();
		tama�oColumnas();
		mostrarDocumentos();
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(422, 172, 104, 31);
		btnNuevo.addActionListener(this);
		getContentPane().add(btnNuevo);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(308, 258, 104, 32);
		btnRegistrar.addActionListener(this);
		getContentPane().add(btnRegistrar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(422, 214, 104, 32);
		btnModificar.addActionListener(this);
		getContentPane().add(btnModificar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(308, 214, 104, 32);
		btnBuscar.addActionListener(this);
		getContentPane().add(btnBuscar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(422, 258, 104, 32);
		btnEliminar.addActionListener(this);
		getContentPane().add(btnEliminar);
		
		//COMBO ESTADO
		cboEstado.addItem(obje.getNombre0());
		cboEstado.addItem(obje.getNombre1());
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 151, 526, 8);
		getContentPane().add(separator);
	}

	/*-------------------------------------
	 * 		METODOS GET/SET DE LOS TEXTBOX
	 * -----------------------------------*/

	public int getCodigo() {
		return Integer.parseInt(txtCodigo.getText());
	}

	public void setCodigo(String txtString) {
		this.txtCodigo.setText("" + txtString);
	}

	public String getDescripcion() {
		return txtDescripcion.getText();
	}

	public void setDescripcion(String txtDescripcion) {
		this.txtDescripcion.setText(txtDescripcion);
	}

	public String getAbrev() {
		return txtAbrev.getText();
	}

	public void setAbrev(String txtAbrev) {
		this.txtAbrev.setText(txtAbrev);
	}

	public int getEstado() {
		return cboEstado.getSelectedIndex();
	}

	public void setEstado(int cboEstado) {
		this.cboEstado.setSelectedIndex(cboEstado);
	}

	/*----------------------------------
	 * 	VALIDACIONES PARA LOS TEXTBOX
	 * --------------------------------*/
	
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub		
	}

	
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub		
	}

	
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==txtDescripcion){
			if(!Character.isLetter(arg0.getKeyChar()) && arg0.getKeyChar()!=' ' && arg0.getKeyChar()!='.'){			
				arg0.consume();		
			}	
		}
		else if (arg0.getSource()==txtAbrev){
			if(!Character.isLetter(arg0.getKeyChar()) && arg0.getKeyChar()!=' ' && arg0.getKeyChar()!='.'){			
				arg0.consume();		
			}	
		}
	}
	
	/*----------------------------------
	 * 		ACCIONES PARA LA TABLA
	 * --------------------------------*/
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int fila = tablaDocumento.getSelectedRow();
		llenarInputs(fila);
	}

	
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub		
	}

	
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub		
	}

	
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub		
	}

	
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub		
	}
	
	/*----------------------------------
	 * 		ACCIONES PARA LOS BOTONES
	 * --------------------------------*/
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnRegistrar){
			if(getDescripcion().equals("") || getAbrev().equals("") || getEstado()==-1){
				JOptionPane.showMessageDialog(null,"Faltan Ingresar Datos ","System Error",0);
				return;
			}
			Registrar();
			limpiar();
		}
		else if(e.getSource()==btnModificar){
			if(getDescripcion().equals("") || getAbrev().equals("") || getEstado()==-1){
				JOptionPane.showMessageDialog(null,"Faltan Ingresar Datos ","System Error",0);
				return;
			}
			Modificar();
			limpiar();
		}
		else if(e.getSource()==btnBuscar){
			Buscar();
		}
		else if(e.getSource()==btnEliminar){
			Eliminar();
			limpiar();
		}
		else if(e.getSource()==btnNuevo){
			limpiar();
			setCodigo(""+c.GeneraCodigo());
		}
		
	}

	/*------------------------------------------------------------------------------
	*-------------------------------------------------------------------------------
	*-------------------------------------------------------------------------------*/
	
	public void Registrar(){
		TipoDocumento x = c.buscar(getCodigo());
		if (x == null) {
			x = new TipoDocumento(getCodigo(),getDescripcion(),getAbrev(), getEstado());
			c.adicionar(x);
		} else {
			JOptionPane.showMessageDialog(null, "El Documento ya existe...!! NJD");
		}
		llenarTabla();
		c.grabar();
		mostrarDocumentos();
	}
	
	public void Eliminar(){
		
		TipoDocumento x = c.buscar(getCodigo());
		if (x == null) {
			JOptionPane.showMessageDialog(null, "El usuario no existe..!!");
		} else {
			c.eliminar(x);
			JOptionPane.showMessageDialog(null,	"La operaci�n se realizo con �xtio");

		}
		c.grabar();
		mostrarDocumentos();
	}
	
	public void Modificar(){
		TipoDocumento u = c.buscar(getCodigo());
		if (u == null) {
			JOptionPane.showConfirmDialog(null, "El Codigo no existe...!!!");
		} else {
			u.setDesDoc(getDescripcion());
			u.setAbrDoc(getAbrev());
			u.setStatusDoc(getEstado());
			c.grabar();
			mostrarDocumentos();
		}
	}
	
	public void Buscar() {
		// MUESTRA VENTANA PARA COLOCAR EL CODIGO A BUSCAR		
		String rspt = JOptionPane.showInputDialog(null,"Ingrese el n�mero de c�digo");
		if(rspt.equals(""))return;
		int codigo = Integer.parseInt(rspt);
		// BUSCA EL OBJETO EN EL ARREGLO Y GUARDA LA INFORMACION EN EL OBJETO "x"
		TipoDocumento x = c.buscar(codigo);			
		
		if (x == null) {
			JOptionPane.showMessageDialog(null, "El usuario no existe..!!");
			return;
		} else {

			// FILA ALMACENA EL CODIGO DEL OBJETO
			int fila = x.getCodDoc();

			for (int i = 0; i <= tabla.getRowCount(); i++) {
				if (tabla.getValueAt(i, 0).equals(fila)) {
					llenarInputs(i);
					break;
				}
			}
		}
		
	}
	
	/*------------------------------------------------------------------------------
	*-------------------- METODOS PARA EL FORMULARIO---------------------------------
	*-------------------------------------------------------------------------------*/
	
	public void llenarTabla() {
		tabla.addRow(new Object[] { getCodigo(), getDescripcion(), getAbrev() , getEstado() });
		tablaDocumento.setModel(tabla);
	}
	
	public void mostrarDocumentos() {
		ArrayList<TipoDocumento> lista = new ArrayList<TipoDocumento>();
		lista = c.ListarDocumento();
		tabla.setRowCount(0);
		for (TipoDocumento x : lista) {
			tabla.addRow(new Object[] { x.getCodDoc(), x.getDesDoc(), x.getAbrDoc(),obje.bnombre(x.getStatusDoc()) });

		}
		tablaDocumento.setModel(tabla);
	}

	/*------------------------------------------------------------------------------
	*---------RELLENAR LOS INPUTS CON LOS DATOS DE CADA FINA DE LA TABLA------------
	*-------------------------------------------------------------------------------*/
	
	public void llenarInputs(int fila){
		setCodigo(tabla.getValueAt(fila, 0).toString());
		TipoDocumento x = c.buscar(getCodigo());
		
		setDescripcion(tabla.getValueAt(fila, 1).toString());
		setAbrev(tabla.getValueAt(fila, 2).toString());
		setEstado(x.getStatusDoc());
	}

	public void limpiar(){
		setDescripcion("");
		setAbrev("");
		setEstado(-1);
		setCodigo("");
	}
		
	void tama�oColumnas(){
		DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
		modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		TableColumn a = tablaDocumento.getColumn("Codigo");
		a.setPreferredWidth(50);
		a.setCellRenderer(modelocentrar);
		TableColumn b = tablaDocumento.getColumn("Descripcion");
		b.setPreferredWidth(220);
		TableColumn c = tablaDocumento.getColumn("Abreviatura");
		c.setPreferredWidth(150);
		TableColumn d = tablaDocumento.getColumn("Estado");
		d.setPreferredWidth(100);
		d.setCellRenderer(modelocentrar);
	}
}

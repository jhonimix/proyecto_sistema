package gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JTable;

import clases.Estado;
import controlador.ArrayArea;
import entidades.Area;

import java.awt.Toolkit;
import java.util.ArrayList;

public class MantenimientoArea extends JDialog implements ActionListener,MouseListener ,KeyListener{
	
	/*------------------------------
	 * DECLARAMOS VARIABLES GLOBALES
	 * -----------------------------*/
	/*------------------------------*/
	ArrayArea b = new ArrayArea();
	
	DefaultTableModel tabla = new DefaultTableModel();
	Estado obje = new Estado();
	
	/*------------------------------*/
	
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtDescripcion;
	private JTextField txtNomCorto;
	private JTextField txtNomLargo;
	private JTable TablaAreas;
	private JButton btnNuevo;
	private JButton btnRegistrar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JComboBox cboEstado;

	public void campos() {
		tabla.addColumn("Codigo");
		tabla.addColumn("Nombre");
		tabla.addColumn("Descripcion");
		tabla.addColumn("Nombre Corto");
		tabla.addColumn("Nombre Largo");
		tabla.addColumn("Estado");
		//MOSTRAMOS LOS CAMPOS EN TABLA
		TablaAreas.setModel(tabla);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MantenimientoArea dialog = new MantenimientoArea();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	
	public MantenimientoArea() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(MantenimientoArea.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));
		setResizable(false);		
		setTitle("Mantenimiento de Areas");
		setBounds(100, 100, 600, 645);
		getContentPane().setLayout(null);
		
		JLabel lblMantenimientoDeAreas = new JLabel("MANTENIMIENTO DE AREAS");
		lblMantenimientoDeAreas.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMantenimientoDeAreas.setBounds(143, 11, 355, 40);
		getContentPane().add(lblMantenimientoDeAreas);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 55, 561, 2);
		getContentPane().add(separator);
		
		JLabel lblCodigo = new JLabel("Codigo :");
		lblCodigo.setBounds(20, 68, 85, 22);
		getContentPane().add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(115, 68, 102, 20);
		getContentPane().add(txtCodigo);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setBounds(20, 101, 85, 22);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(this);
		txtNombre.setColumns(10);
		txtNombre.setBounds(115, 101, 278, 20);
		getContentPane().add(txtNombre);
		
		JLabel lblDescripcion = new JLabel("Descripcion :");
		lblDescripcion.setBounds(20, 134, 85, 31);
		getContentPane().add(lblDescripcion);
		
		txtDescripcion = new JTextField();
		txtDescripcion.addKeyListener(this);
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(115, 138, 278, 20);
		getContentPane().add(txtDescripcion);
		
		JLabel lblNombreCorto = new JLabel("Nombre Corto :");
		lblNombreCorto.setBounds(20, 176, 95, 22);
		getContentPane().add(lblNombreCorto);
		
		txtNomCorto = new JTextField();
		txtNomCorto.addKeyListener(this);
		txtNomCorto.setColumns(10);
		txtNomCorto.setBounds(115, 176, 112, 20);
		getContentPane().add(txtNomCorto);
		
		JLabel lblNombreLargo = new JLabel("Nombre Largo :");
		lblNombreLargo.setBounds(20, 209, 112, 31);
		getContentPane().add(lblNombreLargo);
		
		txtNomLargo = new JTextField();
		txtNomLargo.addKeyListener(this);
		txtNomLargo.setColumns(10);
		txtNomLargo.setBounds(115, 213, 278, 20);
		getContentPane().add(txtNomLargo);
		
		JLabel lblEstado = new JLabel("Estado :");
		lblEstado.setBounds(20, 244, 86, 31);
		getContentPane().add(lblEstado);
		
		cboEstado = new JComboBox();
		cboEstado.setBounds(115, 249, 149, 20);
		getContentPane().add(cboEstado);
		
		// COMBO ESTADO
		cboEstado.addItem(obje.getNombre0());
		cboEstado.addItem(obje.getNombre1());
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(20, 286, 89, 23);
		getContentPane().add(btnNuevo);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(123, 286, 112, 23);
		getContentPane().add(btnRegistrar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(245, 286, 113, 23);
		getContentPane().add(btnModificar);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(368, 286, 89, 23);
		getContentPane().add(btnBuscar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(467, 286, 89, 23);
		getContentPane().add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane(TablaAreas);
		JViewport viewport = new JViewport();
		scrollPane.setRowHeaderView(viewport);
		scrollPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setBounds(10, 320, 561, 257);
		getContentPane().add(scrollPane);
		
		TablaAreas = new JTable();
		TablaAreas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TablaAreas.addMouseListener(this);
		scrollPane.setViewportView(TablaAreas);
		campos();
		tamañoColumnas();
		mostrarAreas();
		
	}
	
	/*-------------------------------------
	 * 		METODOS GET/SET DE LOS TEXTBOX
	 * -----------------------------------*/
	
	public int getCodigo() {
		return Integer.parseInt(txtCodigo.getText());
	}

	public void setCodigo(String txtCodigo) {
		this.txtCodigo.setText(txtCodigo);
	}

	public String getNombre() {
		return txtNombre.getText();
	}

	public void setNombre(String txtNombre) {
		this.txtNombre.setText(txtNombre);
	}

	public String getDescripcion() {
		return txtDescripcion.getText();
	}

	public void setDescripcion(String txtDescripcion) {
		this.txtDescripcion.setText(txtDescripcion);
	}

	public String getNomCorto() {
		return txtNomCorto.getText();
	}

	public void setNomCorto(String txtNomCorto) {
		this.txtNomCorto.setText(txtNomCorto);
	}

	public String getNomLargo() {
		return txtNomLargo.getText();
	}

	public void setNomLargo(String txtNomLargo) {
		this.txtNomLargo.setText(txtNomLargo);
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
		if (e.getSource() == txtNombre) {
			if (!Character.isLetter(e.getKeyChar()) && e.getKeyChar() != ' '
					&& e.getKeyChar() != '.') {
				e.consume();
			}
		}
		if (e.getSource() == txtDescripcion) {
			if (!Character.isLetter(e.getKeyChar()) && !Character.isDigit(e.getKeyChar()) && e.getKeyChar() != ' '
					&& e.getKeyChar() != '.') {
				e.consume();
			}
		}
		if (e.getSource() == txtNomCorto) {
			if (!Character.isLetter(e.getKeyChar()) && e.getKeyChar() != ' '
					&& e.getKeyChar() != '.') {
				e.consume();
			}
		}
		if (e.getSource() == txtNomLargo) {
			if (!Character.isLetter(e.getKeyChar()) && e.getKeyChar() != ' '
					&& e.getKeyChar() != '.') {
				e.consume();
			}
		}
	}
	
	/*----------------------------------
	 * 		ACCIONES PARA LA TABLA
	 * --------------------------------*/	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int fila = TablaAreas.getSelectedRow();
		llenarInputs(fila);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}	
	
	/*----------------------------------
	 * 		ACCIONES PARA LOS BOTONES
	 * --------------------------------*/

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnRegistrar){
			if(getNombre().equals("") || getDescripcion().equals("") || getNomCorto().equals("") ||
			   getNomLargo().equals("") || getEstado()==-1){
				JOptionPane.showMessageDialog(null,"Faltan Ingresar Datos ","System Error",0);
				return;
			}
			Registrar();
			limpiar();
		}
		if(e.getSource()==btnModificar){
			if(getNombre().equals("") || getDescripcion().equals("") || getNomCorto().equals("") ||
					   getNomLargo().equals("") || getEstado()==-1){				
				JOptionPane.showMessageDialog(null,"Faltan Ingresar Datos ","System Error",0);
				return;
			}
			Modificar();
			limpiar();
		}
		if(e.getSource()==btnBuscar){
			Buscar();
		}
		if(e.getSource()==btnEliminar){
			Eliminar();
			limpiar();
		}
		if(e.getSource()==btnNuevo){
			limpiar();
			setCodigo(""+b.GeneraCodigo());
			
		}
	}
	
	/*------------------------------------------------------------------------------
	*-------------------------------------------------------------------------------
	*-------------------------------------------------------------------------------*/

	private void Registrar() {
		// TODO Auto-generated method stub
		Area x= b.buscar(getCodigo());
		if(x==null){
			x= new Area(getCodigo(), getNombre(), getDescripcion(), getNomCorto(), getNomLargo(), getEstado());
			b.adicionar(x);
		}
		else {
			JOptionPane.showMessageDialog(null, "El Area ya se encuentra registrado...!! NJD");			
		}
		llenarTabla();
		b.grabar();
		mostrarAreas();
	}

	private void Buscar() {
		
		String rspt = JOptionPane.showInputDialog(null,"Ingrese el número de código");
		if(rspt.equals(""))return;
		int codigo = Integer.parseInt(rspt);
		// BUSCA EL OBJETO EN EL ARREGLO Y GUARDA LA INFORMACION EN EL OBJETO "x"
		Area x = b.buscar(codigo);			
		
		if (x == null) {
			JOptionPane.showMessageDialog(null, "El usuario no existe..!!");
			return;
		} else {

			// FILA ALMACENA EL CODIGO DEL OBJETO
			int fila = x.getCodArea();

			for (int i = 0; i <= tabla.getRowCount(); i++) {
				if (tabla.getValueAt(i, 0).equals(fila)) {
					llenarInputs(i);
					break;
				}
			}
		}
	}
	
	private void Modificar() {
		// TODO Auto-generated method stub
		Area u = b.buscar(getCodigo());
		if (u == null) {
			JOptionPane.showConfirmDialog(null, "El Codigo no existe...!!!");
		} else {
			u.setNameArea(getNombre());
			u.setDescArea(getDescripcion());
			u.setNameSmallArea(getNomCorto());
			u.setNameLargeArea(getNomLargo());
			u.setStatus(getEstado());
			b.grabar();
			mostrarAreas();
		}
	}
	
	private void Eliminar() {
		// TODO Auto-generated method stub
		Area x = b.buscar(getCodigo());
		if (x == null) {
			JOptionPane.showMessageDialog(null, "El usuario no existe..!!");
		} else {
			b.eliminar(x);
			JOptionPane.showMessageDialog(null,	"La operación se realizo con éxtio");

		}
		b.grabar();
		mostrarAreas();
	}

	
	/*------------------------------------------------------------------------------
	*-------------------- METODOS PARA EL FORMULARIO---------------------------------
	*-------------------------------------------------------------------------------*/


	public void llenarTabla() {
		tabla.addRow(new Object[] { getCodigo(), getNombre(), getDescripcion(),
				getNomCorto(),getNomLargo(), getEstado() });
		TablaAreas.setModel(tabla);
	}

	public void mostrarAreas() {
		ArrayList<Area> lista = new ArrayList<Area>();
		lista = b.ListarArea();
		tabla.setRowCount(0);
		for (Area x : lista) {
			tabla.addRow(new Object[] { x.getCodArea(), x.getNameArea(),
					x.getDescArea(), x.getNameSmallArea(), x.getNameLargeArea(),obje.bnombre(x.getStatus()) });
		}
		TablaAreas.setModel(tabla);
	}
	
	/*------------------------------------------------------------------------------
	*---------RELLENAR LOS INPUTS CON LOS DATOS DE CADA FINA DE LA TABLA------------
	*-------------------------------------------------------------------------------*/
	
	public void llenarInputs(int fila) {
		setCodigo(tabla.getValueAt(fila, 0).toString());
		Area x = b.buscar(getCodigo());

		setNombre(tabla.getValueAt(fila, 1).toString());
		setDescripcion(tabla.getValueAt(fila, 2).toString());
		setNomCorto(tabla.getValueAt(fila, 3).toString());
		setNomLargo(tabla.getValueAt(fila, 4).toString());
		setEstado(x.getStatus());
	}

	public void limpiar() {
		setNombre("");
		setDescripcion("");
		setNomCorto("");
		setNomLargo("");
		setEstado(-1);
		setCodigo("");
	}
	
	void tamañoColumnas() {
		DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
		modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);

		TableColumn a = TablaAreas.getColumn("Codigo");
		a.setPreferredWidth(60);
		a.setCellRenderer(modelocentrar);
		TableColumn b = TablaAreas.getColumn("Nombre");
		b.setPreferredWidth(110);
		TableColumn c = TablaAreas.getColumn("Descripcion");
		c.setPreferredWidth(180);
		TableColumn d = TablaAreas.getColumn("Nombre Corto");
		d.setPreferredWidth(130);
		TableColumn e = TablaAreas.getColumn("Nombre Largo");
		e.setPreferredWidth(220);
		TableColumn f = TablaAreas.getColumn("Estado");
		f.setPreferredWidth(100);
		f.setCellRenderer(modelocentrar);
	}
}

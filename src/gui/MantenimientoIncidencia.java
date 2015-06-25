package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import clases.Estado;
import clases.general;
import controlador.ArrayTipoIncidencia;
import entidades.TipoIncidencia;

import javax.swing.JSeparator;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

import java.awt.event.KeyAdapter;
import java.awt.Window.Type;
import java.awt.Toolkit;

public class MantenimientoIncidencia extends JDialog implements ActionListener, MouseListener,KeyListener{
	
	/*------------------------------
	 * DECLARAMOS VARIABLES GLOBALES
	 * -----------------------------*/
	/*------------------------------*/
	
	ArrayTipoIncidencia e = new ArrayTipoIncidencia();
	general img = new general();
	
	DefaultTableModel tabla = new DefaultTableModel();	
	Estado obje = new Estado();

	/*------------------------------*/
	private JTextField txtCodigo;
	private JTextField txtDescripcion;
	private JTextField txtAbrev;
	private JTable tablaTipoIncidencia;
	private JComboBox cboEstado;
	private JButton btnNuevo;
	private JButton btnRegistrar;
	private JButton btnModificar;
	private JButton btnBuscar;
	private JButton btnEliminar;
	private JSeparator separator;
	
	public void campos() {
		tabla.addColumn("Codigo");
		tabla.addColumn("Descripcion");
		tabla.addColumn("Abreviatura");
		tabla.addColumn("Estado");
		//MOSTRAMOS LOS CAMPOS EN TABLA
		tablaTipoIncidencia.setModel(tabla);
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MantenimientoIncidencia dialog = new MantenimientoIncidencia();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MantenimientoIncidencia() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MantenimientoIncidencia.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));
		setResizable(false);
		setType(Type.POPUP);
		setTitle("Mantenimiento de los Tipos de Incidencias");
		setBounds(100, 100, 542, 522);
		getContentPane().setLayout(null);
		
		JLabel lblMantenimientoTipoDe = new JLabel("");
		lblMantenimientoTipoDe.setIcon(img.getIcon("incidencias.png", "fondos"));
		lblMantenimientoTipoDe.setBounds(0, 0, 536, 150);
		getContentPane().add(lblMantenimientoTipoDe);
		
		JLabel lblCodigo = new JLabel("Codigo :");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodigo.setBounds(20, 172, 84, 24);
		getContentPane().add(lblCodigo);
		
		JLabel lblNewLabel = new JLabel("Descripcion :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(20, 207, 84, 24);
		getContentPane().add(lblNewLabel);
		
		JLabel lblAbreviacion = new JLabel("Abreviacion :");
		lblAbreviacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAbreviacion.setBounds(20, 242, 84, 24);
		getContentPane().add(lblAbreviacion);
		
		JLabel lblEstado = new JLabel("Estado :");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstado.setBounds(247, 242, 94, 24);
		getContentPane().add(lblEstado);
		
		txtCodigo = new JTextField();
		txtCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(110, 175, 94, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.addKeyListener(this);
		txtDescripcion.setBounds(110, 207, 278, 20);
		getContentPane().add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		txtAbrev = new JTextField();
		txtAbrev.addKeyListener(this);
		txtAbrev.setBounds(110, 245, 127, 20);
		getContentPane().add(txtAbrev);
		txtAbrev.setColumns(10);
		
		cboEstado = new JComboBox();
		cboEstado.setBounds(309, 245, 127, 20);
		getContentPane().add(cboEstado);
		
		JScrollPane scrollPane = new JScrollPane(tablaTipoIncidencia);
		JViewport viewport = new JViewport();
		scrollPane.setRowHeaderView(viewport);
		scrollPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setBounds(10, 330, 516, 150);
		getContentPane().add(scrollPane);
		
		tablaTipoIncidencia = new JTable(tabla);
		tablaTipoIncidencia.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tablaTipoIncidencia.addMouseListener(this);
		scrollPane.setViewportView(tablaTipoIncidencia);
		campos();
		tamañoColumnas();
		mostrarTipoIncidencia();
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(11, 278, 84, 31);
		btnNuevo.addActionListener(this);
		getContentPane().add(btnNuevo);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(211, 277, 99, 32);
		btnRegistrar.addActionListener(this);
		getContentPane().add(btnRegistrar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(106, 277, 94, 32);
		btnModificar.addActionListener(this);
		getContentPane().add(btnModificar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(321, 277, 94, 32);
		btnBuscar.addActionListener(this);
		getContentPane().add(btnBuscar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(426, 277, 94, 32);
		btnEliminar.addActionListener(this);
		getContentPane().add(btnEliminar);
		
		separator = new JSeparator();
		separator.setBounds(10, 161, 516, 2);
		getContentPane().add(separator);
		
		//COMBO ESTADO
		cboEstado.addItem(obje.getNombre0());
		cboEstado.addItem(obje.getNombre1());
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
	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub		
	}


	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub		
	}


	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==txtDescripcion){
			if(!Character.isLetter(e.getKeyChar()) && e.getKeyChar()!=' ' && e.getKeyChar()!='.'){			
				e.consume();		
			}	
		}
		else if (e.getSource()==txtAbrev){
			if(!Character.isLetter(e.getKeyChar()) && e.getKeyChar()!=' ' && e.getKeyChar()!='.'){			
				e.consume();		
			}	
		}
	}
	
	/*----------------------------------
	 * 		ACCIONES PARA LA TABLA
	 * --------------------------------*/	
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int fila = tablaTipoIncidencia.getSelectedRow();
		llenarInputs(fila);
	}


	
	public void mouseEntered(MouseEvent e) {// TODO Auto-generated method stub		
	}


	
	public void mouseExited(MouseEvent e) {// TODO Auto-generated method stub		
	}


	
	public void mousePressed(MouseEvent e) {// TODO Auto-generated method stub		
	}


	
	public void mouseReleased(MouseEvent e) {// TODO Auto-generated method stub		
	}

	/*----------------------------------
	 * 		ACCIONES PARA LOS BOTONES
	 * --------------------------------*/
	
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		if (a.getSource() == btnRegistrar) {
			if(getDescripcion().equals("") || getAbrev().equals("") || getEstado()==-1){
				JOptionPane.showMessageDialog(null,"Faltan Ingresar Datos ","System Error",0);
				return;
			}
			Registrar();
			limpiar();
		} else if (a.getSource() == btnModificar) {
			if(getDescripcion().equals("") || getAbrev().equals("") || getEstado()==-1){
				JOptionPane.showMessageDialog(null,"Faltan Ingresar Datos ","System Error",0);
				return;
			}
			Modificar();
			limpiar();
		} else if (a.getSource() == btnBuscar) {
			Buscar();
		} else if (a.getSource() == btnEliminar) {
			Eliminar();
			limpiar();
		} else if (a.getSource() == btnNuevo) {
			limpiar();
			setCodigo("" + e.GeneraCodigo());
		}
	}
	
	/*------------------------------------------------------------------------------
	*-------------------------------------------------------------------------------
	*-------------------------------------------------------------------------------*/
	
	public void Registrar() {
		TipoIncidencia x = e.buscar(getCodigo());
		if (x == null) {
			x = new TipoIncidencia(getCodigo(), getDescripcion(), getAbrev(),
					getEstado());
			e.adicionar(x);
		} else {
			JOptionPane.showMessageDialog(null,
					"El Documento ya existe...!! NJD");
		}
		llenarTabla();
		e.grabar();
		mostrarTipoIncidencia();
	}

	public void Eliminar() {

		TipoIncidencia x = e.buscar(getCodigo());
		if (x == null) {
			JOptionPane.showMessageDialog(null, "El usuario no existe..!!");
		} else {
			e.eliminar(x);
			JOptionPane.showMessageDialog(null,
					"La operación se realizo con éxtio");

		}
		e.grabar();
		mostrarTipoIncidencia();
	}

	public void Modificar() {
		TipoIncidencia u = e.buscar(getCodigo());
		if (u == null) {
			JOptionPane.showConfirmDialog(null, "El Codigo no existe...!!!");
		} else {
			u.setDesTipoInc(getDescripcion());
			u.setAbTipoInc(getAbrev());
			u.setEstTipoInc(getEstado());
			e.grabar();
			mostrarTipoIncidencia();
		}
	}

	public void Buscar() {
		// MUESTRA VENTANA PARA COLOCAR EL CODIGO A BUSCAR
		String rspt = JOptionPane.showInputDialog(null,
				"Ingrese el número de código");
		if (rspt.equals(""))
			return;
		int codigo = Integer.parseInt(rspt);
		// BUSCA EL OBJETO EN EL ARREGLO Y GUARDA LA INFORMACION EN EL OBJETO
		// "x"
		TipoIncidencia x = e.buscar(codigo);

		if (x == null) {
			JOptionPane.showMessageDialog(null, "El usuario no existe..!!");
			return;
		} else {

			// FILA ALMACENA EL CODIGO DEL OBJETO
			int fila = x.getCodTipoInc();

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
		tabla.addRow(new Object[] { getCodigo(), getDescripcion(), getAbrev(),
				getEstado() });
		tablaTipoIncidencia.setModel(tabla);
	}

	public void mostrarTipoIncidencia() {
		ArrayList<TipoIncidencia> lista = new ArrayList<TipoIncidencia>();
		lista = e.ListarTipoIncidencia();
		tabla.setRowCount(0);
		for (TipoIncidencia x : lista) {
			tabla.addRow(new Object[] { x.getCodTipoInc(), x.getDesTipoInc(),
					x.getAbTipoInc(),obje.bnombre(x.getEstTipoInc()) });

		}
		tablaTipoIncidencia.setModel(tabla);
	}

	/*------------------------------------------------------------------------------
	*---------RELLENAR LOS INPUTS CON LOS DATOS DE CADA FINA DE LA TABLA------------
	*-------------------------------------------------------------------------------*/
	
	public void llenarInputs(int fila) {
		setCodigo(tabla.getValueAt(fila, 0).toString());
		TipoIncidencia x = e.buscar(getCodigo());
		
		setDescripcion(tabla.getValueAt(fila, 1).toString());
		setAbrev(tabla.getValueAt(fila, 2).toString());
		setEstado(x.getEstTipoInc());
	}

	public void limpiar() {
		setDescripcion("");
		setAbrev("");
		setEstado(-1);
		setCodigo("");
	}

	void tamañoColumnas(){
		DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
		modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);		
		
		TableColumn a = tablaTipoIncidencia.getColumn("Codigo");
		a.setPreferredWidth(50);
		a.setCellRenderer(modelocentrar);
		TableColumn b = tablaTipoIncidencia.getColumn("Descripcion");
		b.setPreferredWidth(250);
		TableColumn c = tablaTipoIncidencia.getColumn("Abreviatura");
		c.setPreferredWidth(150);
		TableColumn d = tablaTipoIncidencia.getColumn("Estado");
		d.setPreferredWidth(100);
		d.setCellRenderer(modelocentrar);
	}
}

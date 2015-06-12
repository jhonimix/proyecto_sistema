package gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;




//IMPORTAMOS LAS DEPENDENCIAS
import entidades.TipoDocumento;
import controlador.ArrayDocumento;
import clases.principalMetodos;

import javax.swing.DefaultComboBoxModel;

public class MantenimientoDocumento extends JDialog implements ActionListener, MouseListener {

	//DECLARAMOS ATRIBUTOS GLOBALES CREAMOS EL ARRAY
	ArrayDocumento c = new ArrayDocumento();
	DefaultTableModel tabla = new DefaultTableModel();
	
	private JTextField txtCodigo;
	private JTextField txtDescripcion;
	private JTextField txtAbrev;
	private JTable tablaDocumento;
	private JComboBox<String> cboEstado;
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
		setResizable(false);
		setBounds(100, 100, 542, 441);
		getContentPane().setLayout(null);
		
		JLabel lblMantenimientoTipoDe = new JLabel("MANTENIMIENTO TIPO DE DOCUMENTO");
		lblMantenimientoTipoDe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMantenimientoTipoDe.setBounds(114, 18, 340, 34);
		getContentPane().add(lblMantenimientoTipoDe);
		
		JLabel lblCodigo = new JLabel("Codigo :");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodigo.setBounds(10, 70, 94, 24);
		getContentPane().add(lblCodigo);
		
		JLabel lblNewLabel = new JLabel("Descripcion :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 105, 94, 24);
		getContentPane().add(lblNewLabel);
		
		JLabel lblAbreviacion = new JLabel("Abreviacion :");
		lblAbreviacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAbreviacion.setBounds(10, 140, 94, 32);
		getContentPane().add(lblAbreviacion);
		
		JLabel lblEstado = new JLabel("Estado :");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstado.setBounds(10, 183, 94, 34);
		getContentPane().add(lblEstado);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(100, 73, 94, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(100, 108, 278, 20);
		getContentPane().add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		txtAbrev = new JTextField();
		txtAbrev.setBounds(100, 147, 127, 20);
		getContentPane().add(txtAbrev);
		txtAbrev.setColumns(10);
		
		cboEstado = new JComboBox<String>();
		cboEstado.setBounds(100, 191, 127, 20);
		cboEstado.addItem("NO ACTIVO");
		cboEstado.addItem("ACTIVO");
		getContentPane().add(cboEstado);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 237, 506, 150);
		getContentPane().add(scrollPane);
		
		tablaDocumento = new JTable();
		tablaDocumento.addMouseListener(this);
		scrollPane.setViewportView(tablaDocumento);
		campos();
		mostrarDocumentos();
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(422, 63, 94, 31);
		btnNuevo.addActionListener(this);
		getContentPane().add(btnNuevo);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(298, 141, 104, 32);
		btnRegistrar.addActionListener(this);
		getContentPane().add(btnRegistrar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(412, 141, 104, 32);
		btnModificar.addActionListener(this);
		getContentPane().add(btnModificar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(298, 185, 104, 32);
		btnBuscar.addActionListener(this);
		getContentPane().add(btnBuscar);
		
		btnEliminar = new JButton("Eleminar");
		btnEliminar.setBounds(412, 185, 104, 32);
		btnEliminar.addActionListener(this);
		getContentPane().add(btnEliminar);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int fila = tablaDocumento.getSelectedRow();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		nuevo();
	}
	//METODOS PARA LOS INPUST DE LOS FORMULARIOS
	int getCodigo(){
		return Integer.parseInt(txtCodigo.getText());
	}
	//METODOS PARA EL FORMULARIO
	
	/* RELLENAR DATOS DE TABLA CON EL USUARIO NUEVO */
	public void rellenarTabla() {
		tabla.addRow(new Object[] { getCodigo(),  });
		tablaDocumento.setModel(tabla);
	}
	/*RELLENAR DATOS A LA TABLA CARGADO DEL ARRAY DE LA MEMORIA */
	public void mostrarDocumentos() {
		ArrayList<TipoDocumento> lista = new ArrayList<TipoDocumento>();
		lista = c.ListarDocumento();
		tabla.setRowCount(0);
		for (TipoDocumento x : lista) {
			tabla.addRow(new Object[] { x.getCodDoc(),x.getDesDoc(),x.getAbrDoc(),x.getStatusDoc()});

		}
		tablaDocumento.setModel(tabla);
	}
	//RELLENAR LOS INPUTS CON LOS DATOS DE CADA FINA DE LA TABLA
		public void llenarInputs(int fila){
			
			txtCodigo.setText(tabla.getValueAt(fila, 0).toString());
			txtDescripcion.setText(tabla.getValueAt(fila, 1).toString());
			txtAbrev.setText(tabla.getValueAt(fila, 2).toString());
			cboEstado.setSelectedIndex(Integer.parseInt(tabla.getValueAt(fila,3).toString()));
			
		}
		
		public void nuevo() {
			txtCodigo.setText("" + c.generarCodigo());
			txtDescripcion.setText("");
			txtAbrev.setText("");
			cboEstado.setSelectedIndex(0);
		}		
}

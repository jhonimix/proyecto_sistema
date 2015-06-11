package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ArrayDocumento;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MantenimientoDocumento extends JDialog implements ActionListener, MouseListener {

	//DECLARAMOS ATRIBUTOS GLOBALES
	ArrayDocumento c = new ArrayDocumento();
	DefaultTableModel tabla = new DefaultTableModel();
	
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
		setBounds(100, 100, 542, 550);
		getContentPane().setLayout(null);
		
		JLabel lblMantenimientoTipoDe = new JLabel("MANTENIMIENTO TIPO DE DOCUMENTO");
		lblMantenimientoTipoDe.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblMantenimientoTipoDe.setBounds(54, 11, 434, 48);
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
		
		cboEstado = new JComboBox();
		cboEstado.setBounds(100, 191, 127, 20);
		cboEstado.addItem("ACTIVO");
		cboEstado.addItem("INACTIVO");
		getContentPane().add(cboEstado);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 237, 506, 219);
		getContentPane().add(scrollPane);
		
		tablaDocumento = new JTable();
		tablaDocumento.addMouseListener(this);
		scrollPane.setViewportView(tablaDocumento);
		campos();
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.setBounds(422, 63, 94, 31);
		btnNuevo.addActionListener(this);
		getContentPane().add(btnNuevo);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setBounds(298, 141, 104, 32);
		btnRegistrar.addActionListener(this);
		getContentPane().add(btnRegistrar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(412, 141, 104, 32);
		btnModificar.addActionListener(this);
		getContentPane().add(btnModificar);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(298, 185, 104, 32);
		btnBuscar.addActionListener(this);
		getContentPane().add(btnBuscar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(412, 185, 104, 32);
		btnEliminar.addActionListener(this);
		getContentPane().add(btnEliminar);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
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
		
	}
}

package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controlador.ArrayTipoIncidencia;
import entidades.TipoIncidencia;
import javax.swing.JSeparator;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class MantenimientoIncidencia extends JDialog implements ActionListener, MouseListener{
	
	//DECLARAMOS ATRIBUTOS GLOBALES CREAMOS EL ARRAY		
	ArrayTipoIncidencia e = new ArrayTipoIncidencia();		
	DefaultTableModel tabla = new DefaultTableModel();
		
	private JTextField txtCodigo;
	private JTextField txtDescripcion;
	private JTextField txtAbrev;
	private JTable tablaTipoIncidencia;
	private JComboBox<String> cboEstado;
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
		setResizable(false);
		setBounds(100, 100, 542, 534);
		getContentPane().setLayout(null);
		
		JLabel lblMantenimientoTipoDe = new JLabel("MANTENIMIENTO TIPO DE INCIDENCIA");
		lblMantenimientoTipoDe.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblMantenimientoTipoDe.setBounds(84, 11, 393, 34);
		getContentPane().add(lblMantenimientoTipoDe);
		
		JLabel lblCodigo = new JLabel("Codigo :");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodigo.setBounds(10, 63, 94, 24);
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
		txtCodigo.setBounds(100, 66, 94, 20);
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
		scrollPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setBounds(10, 237, 516, 243);
		getContentPane().add(scrollPane);
		
		tablaTipoIncidencia = new JTable();
		tablaTipoIncidencia.addMouseListener(this);
		scrollPane.setViewportView(tablaTipoIncidencia);
		campos();
		mostrarTipoIncidencia();
		
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
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(412, 185, 104, 32);
		btnEliminar.addActionListener(this);
		getContentPane().add(btnEliminar);
		
		separator = new JSeparator();
		separator.setBounds(10, 43, 516, 2);
		getContentPane().add(separator);
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int fila = tablaTipoIncidencia.getSelectedRow();
		llenarInputs(fila);
	}


	@Override
	public void mouseEntered(MouseEvent e) {// TODO Auto-generated method stub		
	}


	@Override
	public void mouseExited(MouseEvent e) {// TODO Auto-generated method stub		
	}


	@Override
	public void mousePressed(MouseEvent e) {// TODO Auto-generated method stub		
	}


	@Override
	public void mouseReleased(MouseEvent e) {// TODO Auto-generated method stub		
	}


	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		if (a.getSource() == btnRegistrar) {
			Registrar();
			limpiar();
		} else if (a.getSource() == btnModificar) {
			Modificar();
			limpiar();
		} else if (a.getSource() == btnBuscar) {
			Buscar();
		} else if (a.getSource() == btnEliminar) {
			Eliminar();
			limpiar();
		} else if (a.getSource() == btnNuevo) {
			setCodigo("" + e.GeneraCodigo());
			limpiar();
		}
	}

	// METODOS PARA LOS INPUTS DE LOS FORMULARIOS

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

	// ------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------
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

	// METODOS PARA EL FORMULARIO

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
					x.getAbTipoInc(), x.getEstTipoInc() });

		}
		tablaTipoIncidencia.setModel(tabla);
	}

	// RELLENAR LOS INPUTS CON LOS DATOS DE CADA FINA DE LA TABLA
	public void llenarInputs(int fila) {
		setCodigo(tabla.getValueAt(fila, 0).toString());
		setDescripcion(tabla.getValueAt(fila, 1).toString());
		setAbrev(tabla.getValueAt(fila, 2).toString());
		setEstado(Integer.parseInt(tabla.getValueAt(fila, 3).toString()));
	}

	public void limpiar() {
		setDescripcion("");
		setAbrev("");
		setEstado(-1);
	}

}

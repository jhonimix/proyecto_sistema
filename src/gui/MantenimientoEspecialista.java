package gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JViewport;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JTable;

import clases.Estado;
import controlador.ArrayEspecialista;
import entidades.Especialista;

import java.util.ArrayList;

import javax.swing.JSeparator;
import javax.swing.border.SoftBevelBorder;

import java.awt.event.KeyAdapter;
import java.awt.Color;

import javax.swing.ImageIcon;

import java.awt.Window.Type;
import java.awt.Toolkit;

public class MantenimientoEspecialista extends JDialog implements ActionListener,MouseListener,KeyListener{
	
	//DECLARAMOS ATRIBUTOS GLOBALES CREAMOS EL ARRAY
	ArrayEspecialista d = new ArrayEspecialista();
	DefaultTableModel tabla = new DefaultTableModel();

	Estado obje = new Estado();
	
	private JTextField txtCodigo;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtEspecialidad;
	private JTextField txtAnexo;
	private JTextField txtFecha;
	private JTable TablaEspecialista;
	private JButton btnNuevo;
	private JButton btnRegistrar;
	private JButton btnModificar;
	private JButton btnBuscar;
	private JButton btnEliminar;
	private JComboBox cboEstado;
	private JSeparator separator;
	private JLabel mensaje1;
	private JLabel lblmensaje01;
	
	public void campos() {
		tabla.addColumn("Codigo");
		tabla.addColumn("Nombres");
		tabla.addColumn("Apellidos");
		tabla.addColumn("Especialidad");
		tabla.addColumn("Anexo");
		tabla.addColumn("Fecha de Ingreso");
		tabla.addColumn("Estado");
		//MOSTRAMOS LOS CAMPOS EN TABLA
		TablaEspecialista.setModel(tabla);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MantenimientoEspecialista dialog = new MantenimientoEspecialista();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MantenimientoEspecialista() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MantenimientoEspecialista.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));
		setResizable(false);
		setType(Type.POPUP);
		setTitle("Mantenimiento del Especialista");
		setBounds(100, 100, 597, 603);
		getContentPane().setLayout(null);
		
		mensaje1 = new JLabel("Formato de fecha \"dd-MM-yyyy\"");
		mensaje1.setForeground(Color.RED);
		mensaje1.setBounds(385, 196, 186, 31);
		mensaje1.setVisible(false);
		getContentPane().add(mensaje1);
		
		JLabel lblCodigo = new JLabel("Codigo :");
		lblCodigo.setBounds(26, 62, 64, 22);
		getContentPane().add(lblCodigo);
		
		JLabel lblNombres = new JLabel("Nombres :");
		lblNombres.setBounds(26, 108, 64, 22);
		getContentPane().add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos :");
		lblApellidos.setBounds(26, 141, 59, 31);
		getContentPane().add(lblApellidos);
		
		JLabel lblEspecialidad = new JLabel("Especialidad :");
		lblEspecialidad.setBounds(26, 183, 73, 22);
		getContentPane().add(lblEspecialidad);
		
		JLabel lblAnexo = new JLabel("Anexo :");
		lblAnexo.setBounds(26, 216, 64, 31);
		getContentPane().add(lblAnexo);
		
		JLabel lblFechaDeIngreso = new JLabel("Fecha de Ingreso: ");
		lblFechaDeIngreso.setBounds(289, 179, 113, 31);
		getContentPane().add(lblFechaDeIngreso);
		
		JLabel lblEstado = new JLabel("Estado :");
		lblEstado.setBounds(289, 216, 64, 31);
		getContentPane().add(lblEstado);
		
		JLabel lblMantenimientoEspecialista = new JLabel("MANTENIMIENTO ESPECIALISTAS");
		lblMantenimientoEspecialista.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMantenimientoEspecialista.setBounds(110, 0, 355, 40);
		getContentPane().add(lblMantenimientoEspecialista);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(22, 258, 89, 23);
		getContentPane().add(btnNuevo);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(125, 258, 112, 23);
		getContentPane().add(btnRegistrar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(247, 258, 113, 23);
		getContentPane().add(btnModificar);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(370, 258, 89, 23);
		getContentPane().add(btnBuscar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(469, 258, 89, 23);
		getContentPane().add(btnEliminar);
		
		txtCodigo = new JTextField();
		txtCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(100, 63, 102, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombres = new JTextField();
		txtNombres.addKeyListener(this);
		txtNombres.setColumns(10);
		txtNombres.setBounds(100, 109, 278, 20);
		getContentPane().add(txtNombres);
		
		txtApellidos = new JTextField();
		txtApellidos.addKeyListener(this);
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(100, 146, 278, 20);
		getContentPane().add(txtApellidos);
		
		txtEspecialidad = new JTextField();
		txtEspecialidad.addKeyListener(this);
		txtEspecialidad.setColumns(10);
		txtEspecialidad.setBounds(100, 184, 112, 20);
		getContentPane().add(txtEspecialidad);
		
		txtAnexo = new JTextField();
		txtAnexo.addKeyListener(this);
		txtAnexo.setColumns(10);
		txtAnexo.setBounds(100, 221, 112, 20);
		getContentPane().add(txtAnexo);
		
		txtFecha = new JTextField();
		txtFecha.addKeyListener(this);
		txtFecha.setColumns(10);
		txtFecha.setBounds(398, 184, 148, 20);
		getContentPane().add(txtFecha);
		
		JScrollPane scrollPane = new JScrollPane(TablaEspecialista);
		JViewport viewport = new JViewport();
		scrollPane.setRowHeaderView(viewport);
		scrollPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setBounds(10, 296, 561, 257);
		getContentPane().add(scrollPane);
		
		TablaEspecialista = new JTable();
		TablaEspecialista.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TablaEspecialista.addMouseListener(this);
		scrollPane.setViewportView(TablaEspecialista);
		campos();
		tamañoColumnas();
		mostrarEspecialista();
		
		cboEstado = new JComboBox();
		cboEstado.setBounds(398, 221, 149, 20);
		getContentPane().add(cboEstado);
		
		JLabel lblFoto = new JLabel("New label");
		lblFoto.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblFoto.setBounds(424, 49, 124, 128);
		getContentPane().add(lblFoto);
		
		separator = new JSeparator();
		separator.setBounds(10, 38, 561, 2);
		getContentPane().add(separator);
		
		lblmensaje01 = new JLabel("");
		lblmensaje01.setIcon(new ImageIcon("C:\\Users\\Dudu\\git\\proyecto_sistema\\bin\\gui\\img\\24\\icono_error.png"));
		lblmensaje01.setBounds(357, 196, 31, 31);
		lblmensaje01.setVisible(false);
		getContentPane().add(lblmensaje01);
		
		// COMBO ESTADO
		cboEstado.addItem(obje.getNombre0());
		cboEstado.addItem(obje.getNombre1());
	}

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

		if (e.getSource() == txtNombres) {
			if (!Character.isLetter(e.getKeyChar()) && e.getKeyChar() != ' ' && e.getKeyChar() != '.') {
				e.consume();
			}
		} else if (e.getSource() == txtApellidos) {
			if (!Character.isLetter(e.getKeyChar()) && e.getKeyChar() != ' ' && e.getKeyChar() != '.') {
				e.consume();
			}
		} else if (e.getSource() == txtEspecialidad) {
			if (!Character.isLetter(e.getKeyChar()) && e.getKeyChar() != ' ' && e.getKeyChar() != '.') {
				e.consume();
			}
		} else if (e.getSource() == txtAnexo) {
			if (!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != '*' || txtAnexo.getText().length()==7) {
				e.consume();
			}
		} else if (e.getSource() == txtFecha) {
			if (!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != '-') {
				e.consume();
			}
			if (txtFecha.getText().length() == 10) {
				mensaje1.setVisible(true);
				lblmensaje01.setVisible(true);
				e.consume();
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int fila = TablaEspecialista.getSelectedRow();
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
		if(e.getSource()==btnRegistrar){
			Registrar();
			limpiar();
		}
		else if(e.getSource()==btnModificar){
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
			setCodigo(""+d.GeneraCodigo());
			limpiar();
			mensaje1.setVisible(false);
			lblmensaje01.setVisible(false);
			
		}
	}

	// METODOS GET/SET DE LOS TXTBOX
	public int getCodigo() {
		return Integer.parseInt(txtCodigo.getText());
	}

	public void setCodigo(String txtCodigo) {
		this.txtCodigo.setText(""+txtCodigo);
	}

	public String getNombres() {
		return txtNombres.getText();
	}

	public void setNombres(String txtNombres) {
		this.txtNombres.setText(txtNombres);
	}

	public String getApellidos() {
		return txtApellidos.getText();
	}

	public void setApellidos(String txtApellidos) {
		this.txtApellidos.setText(txtApellidos);
	}

	public String getEspecialidad() {
		return txtEspecialidad.getText();
	}

	public void setEspecialidad(String txtEspecialidad) {
		this.txtEspecialidad.setText(txtEspecialidad);
	}

	public String getAnexo() {
		return txtAnexo.getText();
	}

	public void setAnexo(String txtAnexo) {
		this.txtAnexo.setText(txtAnexo);
	}

	public String getFecha() {
		return txtFecha.getText();
	}

	public void setFecha(String txtFecha) {
		this.txtFecha.setText(txtFecha);
	}

	public int getEstado() {
		return cboEstado.getSelectedIndex();
	}

	public void setEstado(int cboEstado) {
		this.cboEstado.setSelectedIndex(cboEstado);
	}
	
	//------------------------------------------------------------------------------
	//------------------------------------------------------------------------------
	public void Registrar(){
		Especialista x = d.buscar(getCodigo());
		if (x == null) {
			x = new Especialista(getCodigo(),getNombres(),getApellidos(),getEspecialidad(),getAnexo(),getFecha(),getEstado());
			d.adicionar(x);
		} else {
			JOptionPane.showMessageDialog(null, "El Documento ya existe...!! NJD");
		}
		llenarTabla();
		d.grabar();
		mostrarEspecialista();
	}
	
	public void Eliminar(){
		
		Especialista x = d.buscar(getCodigo());
		if (x == null) {
			JOptionPane.showMessageDialog(null, "El usuario no existe..!!");
		} else {
			d.eliminar(x);
			JOptionPane.showMessageDialog(null,	"La operación se realizo con éxtio");

		}
		d.grabar();
		mostrarEspecialista();
	}
	
	public void Modificar(){
		Especialista u = d.buscar(getCodigo());
		if (u == null) {
			JOptionPane.showConfirmDialog(null, "El Codigo no existe...!!!");
		} else {
			u.setNomEsp(getNombres());
			u.setApeEsp(getApellidos());
			u.setEspEsp(getEspecialidad());
			u.setAnexoEsp(getAnexo());
			u.setFecIngEsp(getFecha());
			u.setStatusEsp(getEstado());
			d.grabar();
			mostrarEspecialista();
		}
	}
	
	public void Buscar() {
		// MUESTRA VENTANA PARA COLOCAR EL CODIGO A BUSCAR		
		String rspt = JOptionPane.showInputDialog(null,"Ingrese el número de código");
		if(rspt.equals(""))return;
		int codigo = Integer.parseInt(rspt);
		// BUSCA EL OBJETO EN EL ARREGLO Y GUARDA LA INFORMACION EN EL OBJETO "x"
		Especialista x = d.buscar(codigo);			
		
		if (x == null) {
			JOptionPane.showMessageDialog(null, "El usuario no existe..!!");
			return;
		} else {

			// FILA ALMACENA EL CODIGO DEL OBJETO
			int fila = x.getCodEsp();

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
		tabla.addRow(new Object[] { getCodigo(), getNombres(), getApellidos(),
				getEspecialidad(), getAnexo(), getFecha(), getEstado() });
		TablaEspecialista.setModel(tabla);
	}

	public void mostrarEspecialista() {
		ArrayList<Especialista> lista = new ArrayList<Especialista>();
		lista = d.ListarEspecialista();
		tabla.setRowCount(0);
		for (Especialista x : lista) {
			tabla.addRow(new Object[] { x.getCodEsp(), x.getNomEsp(),
					x.getApeEsp(), x.getEspEsp(), x.getAnexoEsp(),
					x.getFecIngEsp(), obje.bnombre(x.getStatusEsp()) });

		}
		TablaEspecialista.setModel(tabla);
	}

	// RELLENAR LOS INPUTS CON LOS DATOS DE CADA FINA DE LA TABLA
	public void llenarInputs(int fila) {
		setCodigo(tabla.getValueAt(fila, 0).toString());
		Especialista x = d.buscar(getCodigo());

		setNombres(tabla.getValueAt(fila, 1).toString());
		setApellidos(tabla.getValueAt(fila, 2).toString());
		setEspecialidad(tabla.getValueAt(fila, 3).toString());
		setAnexo(tabla.getValueAt(fila, 4).toString());
		setFecha(tabla.getValueAt(fila, 5).toString());
		setEstado(x.getStatusEsp());
	}

	public void limpiar() {
		setNombres("");
		setApellidos("");
		setEspecialidad("");
		setAnexo("");
		setFecha("");
		setEstado(-1);
	}


	void tamañoColumnas() {
		DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
		modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);

		TableColumn a = TablaEspecialista.getColumn("Codigo");
		a.setPreferredWidth(50);
		a.setCellRenderer(modelocentrar);
		TableColumn b = TablaEspecialista.getColumn("Nombres");
		b.setPreferredWidth(120);
		b.setCellRenderer(modelocentrar);
		TableColumn c = TablaEspecialista.getColumn("Apellidos");
		c.setPreferredWidth(120);
		c.setCellRenderer(modelocentrar);
		TableColumn d = TablaEspecialista.getColumn("Especialidad");
		d.setPreferredWidth(200);
		d.setCellRenderer(modelocentrar);		
		TableColumn e = TablaEspecialista.getColumn("Anexo");
		e.setPreferredWidth(60);
		e.setCellRenderer(modelocentrar);
		TableColumn f = TablaEspecialista.getColumn("Fecha de Ingreso");
		f.setPreferredWidth(125);
		f.setCellRenderer(modelocentrar);
		TableColumn g = TablaEspecialista.getColumn("Estado");
		g.setPreferredWidth(100);
		g.setCellRenderer(modelocentrar);
	}
}

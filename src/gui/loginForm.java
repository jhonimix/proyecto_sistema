package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;





import clases.imagenFondo;
import controlador.ArrayUsuario;
import entidades.Usuario;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.SwingConstants;


public class loginForm extends JFrame {
	
	ArrayUsuario a = new ArrayUsuario();
	
	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField passUser;
	
	public String b ="admin";
	public String c ="1234";

	public Usuario xIngreso;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginForm frame = new loginForm();
					frame.setVisible(true);
					
					frame.setLocationRelativeTo(null);
					ImageIcon icon = new ImageIcon(frame.getClass().getResource("img/fondo-login.png"));
					imagenFondo imagenFondo = new imagenFondo(icon.getImage(),450,350);
					frame.getContentPane().add(imagenFondo);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public loginForm() {
		setName("LoginForm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ingreso al sistema");
		setResizable(false);
		contentPane = new JPanel();
		setBounds(100, 100, 450, 351);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setBounds(183, 146, 144, 29);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar al sistema");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = txtUser.getText();
		        String password = new String(passUser.getPassword());
		        
			        if(IngresoUsuario(username.toUpperCase(),password)){
						//lblSession.setText("Ingresaste");
						gui.principalForm nueva = new gui.principalForm();
						nueva.setVisible(true);
						nueva.setLocationRelativeTo(null);
						nueva.setTitle("Bienvenido al Menú Principal     "+ xIngreso.getNameUser()+" "+xIngreso.getLastnameUser());
						nueva.objUsu = xIngreso;
						ImageIcon icon = new ImageIcon(nueva.getClass().getResource("img/fondo-principal.png"));
						imagenFondo fondo = new imagenFondo(icon.getImage(),750,500);
						nueva.getContentPane().add(fondo);
						dispose();
					}
				
			}
		});
		btnIngresar.setBounds(127, 256, 200, 35);
		contentPane.add(btnIngresar);		
		
		passUser = new JPasswordField();
		passUser.setBounds(183, 204, 144, 28);
		contentPane.add(passUser);
		
		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBounds(95, 153, 78, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a :");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setBounds(95, 211, 78, 14);
		contentPane.add(lblContrasea);
		
		JLabel lblDesarrolladoPorEl = new JLabel("Desarrollado por el Equipo 7");
		lblDesarrolladoPorEl.setForeground(Color.WHITE);
		lblDesarrolladoPorEl.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDesarrolladoPorEl.setBounds(209, 302, 205, 14);
		contentPane.add(lblDesarrolladoPorEl);
		//listar();
	}	
	
	// METODO PARA INGRESAR CON EL NOMBRE DEL USUARIO Y LA CONTRASEÑA(DNI)
	public boolean IngresoUsuario(String user, String pass) {
		String msg;
		// if(b.compareTo(user)==0 && c.compareTo(pass)==0){
		// return true;
		// }

		// BUSCAMOS LOS ITEMS DE LOS USUARIOS QUE LOGEARON
		for (int i = 0; i < a.tamaño(); i++) {
			if ((a.obtener(i).getNameUser().toUpperCase().compareTo(user) == 0 && a
					.obtener(i).getDniUser().compareTo(pass) == 0)) {
				xIngreso = a.obtener(i);

				// VERIFICAMOS SI EL USUARIO ESTA ACTIVO
				if (xIngreso.getStatus() == 1) {
					return true;
				} else {
					// LE ENVIAMOS UN MENSAJE SI LO ESTA
					msg = "Tu usuario esta no activo";
					mensaje(msg);
					return false;
					// imprimir(text);
				}

			}
		}
		msg = "Usuario o contraseña incorrectos";
		mensaje(msg);
		return false;
	}

	void mensaje(String s) {
		JOptionPane.showMessageDialog(null, s);
	}

	void imprimir(String s) {
		System.out.println(s + "\n");
	}
}

package gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ArrayUsuario;
import entidades.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

import java.awt.Window.Type;
import java.awt.Frame;

import javax.swing.SwingConstants;

public class loginForm extends JFrame {
	ArrayUsuario a = new ArrayUsuario();
	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField passUser;

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
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(68, 78, 76, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(68, 129, 76, 14);
		contentPane.add(lblPassword);
		
		txtUser = new JTextField();
		txtUser.setBounds(154, 75, 140, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = txtUser.getText();
		        String password = new String(passUser.getPassword());
		        
			        if(IngresoUsuario(username,password)){
						//lblSession.setText("Ingresaste");
						gui.principalForm nueva = new gui.principalForm();
						nueva.setVisible(true);
						nueva.setLocationRelativeTo(null);
						dispose();
					}
				
			}
		});
		btnIngresar.setBounds(154, 167, 140, 35);
		contentPane.add(btnIngresar);
		
		
		
		passUser = new JPasswordField();
		passUser.setBounds(154, 126, 140, 20);
		contentPane.add(passUser);
		//listar();
	}
	void imprimir(String s){
		System.out.println( s + "\n");
	}
		
	void listar(){ 
		imprimir("--------------------------------------------------------");
		for(int i=0; i<a.tamaño(); i++){
			Usuario x=a.obtener(i);
			imprimir(x.getCodDocUser()+"\t\t" + 
			         x.getNameUser()+"\t\t"+
				     x.getLastnameUser()+"\t"+
			         x.getCodDocUser()+"\t"+
				     x.getDniUser()+"\t"+
			         x.getArea()+"\t"+
				     x.getEmail()+"\t"+
			         x.getFono()+"\t"+
				     x.getFechaIngreso()+"\t"+
			         //x.getPass()+"\t"+
				     x.getStatus()
				     );
		}
	}
	
	//Metodo para ingresar con el usuario email y pass
		public boolean IngresoUsuario(String user, String pass){
			String msg;
	        //buscamos los items de los usuarios email y pass
			for(int i = 0; i < a.tamaño() ; i++){				
				if(a.obtener(i).getEmail().compareTo(user) == 0 && a.obtener(i).getDniUser().compareTo(pass)==0){
					//Verificamos si el usuario no esta activo
					if(a.obtener(i).getStatus()==1){
						return true;
					}
					else{
						//Enviamos un mensaje
						msg="Tu usuario esta no activo";
						mensaje(msg);
						return false;
						//imprimir(text);
					}
					
				}
			}
			msg = "Usuario o contrase�a incorrectos";
			mensaje(msg);
			return false;
		}
		void mensaje(String s){
			JOptionPane.showMessageDialog(null,s);
		}
}

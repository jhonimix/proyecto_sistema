package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ArrayUsuario;
import entidades.Usuario;
import javax.swing.JSeparator;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class loginForm extends JFrame {
	ArrayUsuario a = new ArrayUsuario();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginForm frame = new loginForm();
					frame.setVisible(true);
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		textField = new JTextField();
		textField.setBounds(154, 75, 140, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(154, 126, 140, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(318, 74, 89, 23);
		contentPane.add(btnIngresar);
		
		JLabel lblSession = new JLabel("");
		lblSession.setBounds(123, 202, 238, 14);
		contentPane.add(lblSession);
		listar();
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
			         x.getPass()+"\t"+
				     x.getStatus()
				     );
		}
	}	
}

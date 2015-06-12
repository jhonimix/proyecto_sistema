package clases;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class principalMetodos {

	//METODO PARA CERRAR UNA VENTANA X
	public void cerrar(JDialog ventana){
		Object [] opciones = {"Aceptar", "Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(
				ventana,
				"Desea cerrar la aplicación",
				"Mensaje de confirmación",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				opciones,
				"Aceptar");
		if (eleccion == JOptionPane.YES_OPTION){
			//System.exit(0);
			dispose();
		}
	}

	private void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

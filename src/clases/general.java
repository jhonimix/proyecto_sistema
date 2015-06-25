package clases;

import javax.swing.ImageIcon;
import gui.principalForm;
public class general {


		public ImageIcon getIcon(String icono, String ubicacion) {
			java.net.URL imgUrl;
			if(ubicacion == null){
				imgUrl = principalForm.class.getResource("img/16/" + icono);
			}else{
				imgUrl = principalForm.class.getResource("img/" + ubicacion + "/" + icono);
			}
			
			if (imgUrl != null) {
				ImageIcon imgIcon = new ImageIcon(imgUrl);
				return imgIcon;
			} else {
				System.out.println("Error no se encontro el archivo " + icono);
			}
			return null;
		}

}

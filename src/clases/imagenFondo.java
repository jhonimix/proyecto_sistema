package clases;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
//Creamos una clase con una extension heredada de Jpanel
public class imagenFondo extends JPanel {
	private Image img;
	public imagenFondo(Image img, int ancho, int alto){
		this.img = img;
		Dimension tam = new Dimension(img.getHeight(null),img.getHeight(null));
		this.setPreferredSize(tam);
		this.setMinimumSize(tam);
		this.setMaximumSize(tam);
		this.setSize(450,300);
		this.setLayout(null);
	}
	protected void paintComponent(Graphics g){
		g.drawImage(img, 0,0,this);
	}
}

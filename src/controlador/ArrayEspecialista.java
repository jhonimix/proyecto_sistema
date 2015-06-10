package controlador;

import java.io.*;
import java.util.ArrayList;

import entidades.Especialista;

public class ArrayEspecialista {

	// CREAMOS EL ARRAY ESPECIALISTA
	private ArrayList<Especialista> esp;

	// CONSTRUCTOR DEL ARREGLO
	public ArrayEspecialista() {
		esp = new ArrayList<Especialista>();
		cargar();
	}

	// METODO QUE RETORNA LA CANTIDAD DE OBJETOS INGRESADOS
	public int tamaño() {
		return esp.size();
	}

	// METODO QUE RECIBA UN OBJETO DE LA CLASE ESPECIALISTA Y LO ADICIONE AL
	// ARREGLO DE OBJETOS "esp"
	public void adicionar(Especialista e) {
		esp.add(e);
	}

	// METODO QUE RECIBA UN OBJETO DE LA CLASE ESPECIALISTA Y ELIMINE EL OBJETO
	// DENTRO DEL ARREGLO "esp"
	public void eliminar(Especialista e) {
		esp.remove(e);
	}

	// METODO QUE RECIBA UNA POSICION Y RETORNE EL OBJETO QUE SE ENCUENTRA EN EL
	// ARREGLO "esp"
	public Especialista obtener(int pos) {
		return esp.get(pos);
	}

	// METODO QUE RECIBA UN CODIGO A BUSCAR Y RETORNE EL OBJETO QUE SE ENCUENTRA
	// EN EL ARREGLO "esp" CASO CONTRARIO RETORNE NULL
	public Especialista buscar(int cod) {
		for (Especialista x : esp) {
			if (x.getCodEsp() == cod)
				return x;
		}
		return null;
	}

	// GRABAR DE LA MEMORIA AL ARCHIVO DE TEXTO
	public void grabar() {

		try {

			PrintWriter pw = new PrintWriter(new FileWriter(
					"data/Especialista.txt"));
			String linea;
			for (Especialista d : esp) {
				// ALMACENAMOS LOS DATOS EN LINEA
				linea = d.getCodEsp() + "," + d.getNomEsp() + ","
						+ d.getApeEsp() + "," + d.getEspEsp() + ","
						+ d.getAnexoEsp() + "," + d.getFecIngEsp() + ","
						+ d.getEspEsp();
				// GRABAR LOS DATOS DE LA MEMORIA AL ARCHIVO "Especialista.txt"
				pw.println(linea);
			}
			// CERRAR EL ARCHIVO
			pw.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// GRABA DEL ARCHIVO DE TEXTO A LA MEMORIA(ARRAYLIST)
	public void cargar() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"data/Especialista.txt"));
			String linea;
			while ((linea = br.readLine()) != null) {
				// CREAR UN ARREGLO DEL TIPO STRING SEPARANDO LOS CAMPOS
				String row[] = linea.split(",");
				// CREAR EL OBJETO "d"
				Especialista d = new Especialista(Integer.parseInt(row[0]),
						row[1], row[2], row[3], row[4], row[5],
						Integer.parseInt(row[6]));
				// ENVIAR EL OBJETO "d" AL ARREGLO "esp"
				esp.add(d);
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
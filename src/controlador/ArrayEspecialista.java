package controlador;

import java.io.*;
import java.util.ArrayList;

import entidades.Especialista;

public class ArrayEspecialista {

	// CREAMOS EL ARRAY ESPECIALISTA
	private ArrayList<Especialista> esp;

	public ArrayList<Especialista> ListarEspecialista() {
		return esp;
	}

	// Constructor del Arreglo
	public ArrayEspecialista() {
		esp = new ArrayList<Especialista>();
		cargar();
	}

	// m�todo que retorna la cantidad de objetos ingresados
	public int tamaño() {
		return esp.size();
	}

	// m�todo que reciba un objeto de la clase Empleado y lo adicione al
	// Arreglo de objetos "emp"
	public void adicionar(Especialista e) {
		esp.add(e);
	}

	// m�todo que reciba un objeto de la clase Empleado y elimine el objeto
	// dentro del Arreglo "emp"
	public void eliminar(Especialista e) {
		esp.remove(e);
	}

	// m�todo que reciba una posici�n y retorne el objeto que se encuentra en
	// el Arreglo "emp"
	public Especialista obtener(int pos) {
		return esp.get(pos);
	}

	// m�todo que reciba un c�digo a buscar y retorne el objeto que se encuentra
	// en
	// el Arreglo "emp" caso contrario retorne null
	public Especialista buscar(int cod) {
		// usando for "foreach"
		for (Especialista x : esp) {
			if (x.getCodEsp() == cod)
				return x;
		}
		return null;
	}

	// Grabar de la memoria al archivo de texto
	public void grabar() {

		try {

			PrintWriter pw = new PrintWriter(new FileWriter("data/especialista.txt"));
			String linea;

			for (Especialista d : esp) {
				// la variable linea almacena el registro actual
				linea = d.getCodEsp() + "," + d.getNomEsp() + ","
						+ d.getApeEsp() + "," + d.getEspEsp() + ","
						+ d.getAnexoEsp() + "," + d.getFecIngEsp() + ","
						+ d.getStatusEsp();
				// grabar el registro actual en el archivo "especialista.txt"
				pw.println(linea);
			}

			// cerrar el archivo
			pw.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// graba del archivo de texto a la memoria(Arraylist)
	public void cargar() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"data/especialista.txt"));
			String linea;
			while ((linea = br.readLine()) != null) {
				// crear un arreglo del tipo string separando losca mpos
				String row[] = linea.split(",");
				// creamos el objeto
				Especialista d = new Especialista(Integer.parseInt(row[0]),
						row[1], row[2], row[3], row[4], row[5],
						Integer.parseInt(row[6]));
				// enviar objeto "d" al arreglo "esp"
				esp.add(d);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
package controlador;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import entidades.TipoDocumento;

public class ArrayDocumento {

	// CREAMOS EL ARRAY DOCUMENTO
	private ArrayList<TipoDocumento> doc;

	public ArrayList<TipoDocumento> ListarDocumento() {
		return doc;
	}

	// CONSTRUCTOR DEL ARREGLO
	public ArrayDocumento() {
		doc = new ArrayList<TipoDocumento>();
		cargar();
	}

	// METODO QUE DEVUELVE LA CANTIDAD DE DOCUMENTOS INGRESADOS 
	public int tamaño() {
		return doc.size();
	}

	// m�todo que reciba un objeto de la clase Empleado y lo adicione al
	// Arreglo de objetos "emp"
	public void adicionar(TipoDocumento e) {
		doc.add(e);
	}

	// m�todo que reciba un objeto de la clase Empleado y elimine el objeto
	// dentro del Arreglo "emp"
	public void eliminar(TipoDocumento e) {
		doc.remove(e);
	}

	// m�todo que reciba una posici�n y retorne el objeto que se encuentra en
	// el Arreglo "emp"
	public TipoDocumento obtener(int pos) {
		return doc.get(pos);
	}

	// m�todo que reciba un c�digo a buscar y retorne el objeto que se encuentra
	// en
	// el Arreglo "emp" caso contrario retorne null
	public TipoDocumento buscar(int cod) {
		// usando for "foreach"
		for (TipoDocumento x : doc) {
			if (x.getCodDoc() == cod)
				return x;
		}
		return null;
	}

	// Grabar de la memoria al archivo de texto
	public void grabar() {

		try {

			PrintWriter pw = new PrintWriter(
					new FileWriter("data/tipodocumento.txt"));
			String linea;

			for (TipoDocumento c : doc) {
				// la variable linea almacena el registro actual
				linea = c.getCodDoc() + "," + c.getDesDoc() + ","
						+ c.getAbrDoc() + "," + c.getStatusDoc();
				// grabar el registro actual en el archivo "tipodocumento.txt"
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
					"data/tipodocumento.txt"));
			String linea;
			while ((linea = br.readLine()) != null) {
				// crear un arreglo del tipo string separando losca mpos
				String row[] = linea.split(",");
				// creamos el objeto
				TipoDocumento c = new TipoDocumento(Integer.parseInt(row[0]),
						row[1], row[2], Integer.parseInt(row[3]));
				// enviar objeto "c" al arreglo "doc"
				doc.add(c);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
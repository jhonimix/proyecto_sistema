package controlador;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import entidades.TipoIncidencia;

public class ArrayTipoIncidencia {

	// CREAMOS EL ARRAY TIPO INCIDENCIA
	private ArrayList<TipoIncidencia> tipoInc;

	public ArrayList<TipoIncidencia> ListarTipoIncidencia() {
		return tipoInc;
	}

	// Constructor del Arreglo
	public ArrayTipoIncidencia() {
		tipoInc = new ArrayList<TipoIncidencia>();
		cargar();
	}

	// m�todo que retorna la cantidad de objetos ingresados
	public int tamaño() {
		return tipoInc.size();
	}

	// metodo que reciba un objeto de la clase Empleado y lo adicione al
	// Arreglo de objetos "emp"
	public void adicionar(TipoIncidencia e) {
		tipoInc.add(e);
	}

	// metodo que reciba un objeto de la clase Empleado y elimine el objeto
	// dentro del Arreglo "emp"
	public void eliminar(TipoIncidencia e) {
		tipoInc.remove(e);
	}

	// metodo que reciba una posición y retorne el objeto que se encuentra en
	// el Arreglo "emp"
	public TipoIncidencia obtener(int pos) {
		return tipoInc.get(pos);
	}

	// m�todo que reciba un c�digo a buscar y retorne el objeto que se encuentra
	// en
	// el Arreglo "emp" caso contrario retorne null
	public TipoIncidencia buscar(int cod) {
		// usando for "foreach"
		for (TipoIncidencia x : tipoInc) {
			if (x.getCodTipoInc() == cod)
				return x;
		}
		return null;
	}

	// Grabar de la memoria al archivo de texto
	public void grabar() {

		try {

			PrintWriter pw = new PrintWriter(new FileWriter(
					"data/tipoincidencia.txt"));
			String linea;

			for (TipoIncidencia e : tipoInc) {
				// la variable linea almacena el registro actual
				linea = e.getCodTipoInc() + "," + e.getDesTipoInc() + ","
						+ e.getAbTipoInc() + "," + e.getEstTipoInc();
				// grabar el registro actual en el archivo "tipoincidencia.txt"
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
					"data/tipoincidencia.txt"));
			String linea;
			while ((linea = br.readLine()) != null) {
				// crear un arreglo del tipo string separando losca mpos
				String row[] = linea.split(",");
				// creamos el objeto
				TipoIncidencia e = new TipoIncidencia(Integer.parseInt(row[0]),
						row[1], row[2], Integer.parseInt(row[3]));
				// enviar objeto "e" al arreglo "tipoInc"
				tipoInc.add(e);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

package controlador;

import java.io.*;
import java.util.ArrayList;

import entidades.Area;

public class ArrayArea {

	// CREAMOS EL ARRAY AREA
	private ArrayList<Area> are;

	public ArrayList<Area> ListarArea() {
		return are;
	}

	// CONSTRUCTOR DEL ARREGLO
	public ArrayArea() {
		are = new ArrayList<Area>();
		cargar();
	}

	// METODO QUE RETORNA LA CANTIDAD DE AREAS REGISTRADOS
	public int tamaño() {
		return are.size();
	}

	// método que reciba un objeto de la clase Empleado y lo adicione al
	// Arreglo de objetos "emp"
	public void adicionar(Area e) {
		are.add(e);
	}

	// método que reciba un objeto de la clase Empleado y elimine el objeto
	// dentro del Arreglo "emp"
	public void eliminar(Area e) {
		are.remove(e);
	}

	// método que reciba una posición y retorne el objeto que se encuentra en
	// el Arreglo "emp"
	public Area obtener(int pos) {
		return are.get(pos);
	}

	// método que reciba un código a buscar y retorne el objeto que se encuentra
	// en
	// el Arreglo "emp" caso contrario retorne null
	public Area buscar(int cod) {
		// usando for "foreach"
		for (Area x : are) {
			if (x.getCodArea() == cod)
				return x;
		}
		return null;
	}

	// GRABA DE LA MEMORIA AL ARCHIVO DE TEXTO
	public void grabar() {

		try {

			PrintWriter pw = new PrintWriter(new FileWriter("areas.txt"));
			String linea;

			for (Area b : are) {
				// la variable linea almacena el registro actual
				linea = b.getCodArea() + "," + b.getNameArea() + ","
						+ b.getDescArea() + "," + b.getNameSmallArea() + ","
						+ b.getNameLargeArea() + "," + b.getStatus();
				// grabar el registro actual en el archivo "areas.txt"
				pw.println(linea);
			}
			// cerrar el archivo
			pw.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// CARGA LOS ARCHIVOS DE TEXTO A LA MEMORIA
	public void cargar() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("areas.txt"));
			String linea;
			while ((linea = br.readLine()) != null) {
				// crear un arreglo del tipo string separando los campos
				String row[] = linea.split(",");
				// creamos el objeto
				Area b = new Area(Integer.parseInt(row[0]), row[1], row[2],
						row[3], row[4], Integer.parseInt(row[5]));
				// enviar objeto "b" al arreglo "are"
				are.add(b);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

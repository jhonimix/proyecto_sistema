package controlador;

import java.io.*;
import java.util.ArrayList;

import entidades.Area;

public class ArrayArea {

	//CREAMOS NUESTRA VARIABLE ARRAYLIST
	private ArrayList<Area> are;
	
	public ArrayList<Area> ListarArea() {
		return are;
	}

	//CONSTRUCTOR DEL ARREGLO
	public ArrayArea() {
		are = new ArrayList<Area>();
		cargar();
	}

	//METODO QUE RETORNA LA CANTIDAD DE AREAS REGISTRADOS
	public int tamaño() {
		return are.size();
	}

	//METODO QUE RECIBA UN OBJETO DE LA CLASE EMPLEADO Y LO ADICIONE AL ARREGLO DE OBJETOS "are"
	public void adicionar(Area e) {
		are.add(e);
	}

	//METODO QUE RECIBA UN OBJETO DE LA CLASE EMPLEADO Y LO ELIMINE DENTRO DEL ARREGLO "are"
	public void eliminar(Area e) {
		are.remove(e);
	}

	//METODO QUE RECIBA UNA POSICION Y RETORNE EL OBJETO QUE SE ENCUENTRA EN EL ARREGLO "are"
	public Area obtener(int pos) {
		return are.get(pos);
	}

	//METODO QUE RECIBA UN CODIGO A BUSCAR Y RETORNE EL OBJETO QUE SE ENCUENTRA EN EL ARREGLO "are" 
	//CASO CONTRARIO RETORNA NULL
	public Area buscar(int cod) {		
		for (Area x : are) {
			if (x.getCodArea() == cod)
				return x;
		}
		return null;
	}
	
	// //////////////////////////////
	// GENERAR CODIGO AUTOMATICO //
	// //////////////////////////////
	public int GeneraCodigo() {
		int cod = 0;

		if (tamaño() == 0) {
			cod = 1;
		} else {
			cod = are.get(tamaño() - 1).getCodArea() + 1;
		}
		return cod;

	}

	//GRABA DE LA MEMORIA AL ARCHIVO DE TEXTO
	public void grabar() {

		try {

			PrintWriter pw = new PrintWriter(new FileWriter("data/areas.txt"));
			String linea;

			for (Area b : are) {
				// LA VARIABLE LINEA ALMACENA EL REGISTRO ACTUAL
				linea = b.getCodArea() + "," + b.getNameArea() + ","
						+ b.getDescArea() + "," + b.getNameSmallArea() + ","
						+ b.getNameLargeArea() + "," + b.getStatus();
				// GRABAR EL REGISTRO ACTUAL EN EL ARCHIVO "areas.txt"
				pw.println(linea);
			}
			// CERRAR EL ARCHIVO
			pw.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	//CARGA LOS ARCHIVOS DE TEXTO A LA MEMORIA
	public void cargar() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/areas.txt"));
			String linea;
			while ((linea = br.readLine()) != null) {
				// CREAR UN ARREGLO DEL TIPO STRING SEPARANDO LOS CAMPOS
				String row[] = linea.split(",");
				// CREAMOS EL OBJETO
				Area b = new Area(Integer.parseInt(row[0]), row[1], row[2],
						row[3], row[4], Integer.parseInt(row[5]));
				// ENVIAR EL OBJETO "b" AL ARREGLO "are"
				are.add(b);
			}
			br.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

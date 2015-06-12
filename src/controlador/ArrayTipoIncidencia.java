package controlador;

import java.io.*;
import java.util.ArrayList;

import entidades.TipoIncidencia;

public class ArrayTipoIncidencia {

	// CREAMOS EL ARRAY TIPO INCIDENCIA
	private ArrayList<TipoIncidencia> tipoInc;

	public ArrayList<TipoIncidencia> ListarTipoIncidencia() {
		return tipoInc;
	}

	// CONSTRUCTOR DEL ARREGLO
	public ArrayTipoIncidencia() {
		tipoInc = new ArrayList<TipoIncidencia>();
		cargar();
	}

	// METODO QUE RETORNA LA CANTIDAD DE OBJETOS INGRESADOS
	public int tamaño() {
		return tipoInc.size();
	}

	// METODO QUE RECIBA UN OBJETO DE LA CLASE TIPOINCIDENCIA Y LO ADICIONE AL
	// ARREGLO DE OBJETOS "tipoInc"
	public void adicionar(TipoIncidencia e) {
		tipoInc.add(e);
	}

	// METODO QUE RECIBA UN OBJETO DE LA CLASE TIPOINCIDENCIA Y ELIMINE EL
	// OBJETO DENTRO DEL ARREGLO "tipoInc"
	public void eliminar(TipoIncidencia e) {
		tipoInc.remove(e);
	}

	// METODO QUE RECIBA UNA POSICION Y RETORNE EL OBJETO QUE SE ENCUENTRA EN
	// EL ARREGLO "tipoInc"
	public TipoIncidencia obtener(int pos) {
		return tipoInc.get(pos);
	}

	// METODO QUE RECIBA UN CODIGO A BUSCAR Y RETORNE EL OBJETO QUE SE ENCUENTRA
	// EN EL ARREGLO "tipoInc" CASO CONTRARIO RETORNE NULL
	public TipoIncidencia buscar(int cod) {
		for (TipoIncidencia x : tipoInc) {
			if (x.getCodTipoInc() == cod)
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
			cod = tipoInc.get(tamaño() - 1).getCodTipoInc() + 1;
		}
		return cod;

	}

	// GRABAR DE LA MEMORIA AL RCHIVO DE TEXTO
	public void grabar() {

		try {

			PrintWriter pw = new PrintWriter(new FileWriter(
					"data/tipoincidencia.txt"));
			String linea;

			for (TipoIncidencia e : tipoInc) {
				// LA VARIABLE LINEA ALMACENA EL REGISTRO ACTUAL
				linea = e.getCodTipoInc() + "," + e.getDesTipoInc() + ","
						+ e.getAbTipoInc() + "," + e.getEstTipoInc();
				// GRABAR EL REGISTRO ACTUAL EN EL ARCHIVO "tipoincidencia.txt"
				pw.println(linea);
			}

			// CERRAR EL ARCHIVO
			pw.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// CARGA DEL ARCHIVO DE TEXTO A LA MEMORIA(ARRAYLIST)
	public void cargar() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"data/tipoincidencia.txt"));
			String linea;
			while ((linea = br.readLine()) != null) {
				// CREAR UN ARREGLO DEL TIPO STRING SEPARANDO LOS CAMPOS
				String row[] = linea.split(",");
				// CREAMOS EL OBJETO "e"
				TipoIncidencia e = new TipoIncidencia(Integer.parseInt(row[0]),row[1], row[2],Integer.parseInt(row[3]));
				// ENVIAR EL OBJETO "e" AL ARREGLO "tipoInc"
				tipoInc.add(e);
			}

			br.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

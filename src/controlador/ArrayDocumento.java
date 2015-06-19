package controlador;

import entidades.Area;
import entidades.TipoDocumento;

import java.io.*;
import java.util.ArrayList;

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

	// METODO QUE RECIBA UN OBJETO DE LA CLASE TIPODOCUMENTO Y LO ADICIONE AL
	// ARREGLO "doc"
	public void adicionar(TipoDocumento e) {
		doc.add(e);
	}

	// METODO QUE RECIBA UN OBJETO DE LA CLASE TIPODOCUMENTO Y ELIMINE EL OBJETO
	// DENTRO DEL ARREGLO "doc"
	public void eliminar(TipoDocumento e) {
		doc.remove(e);
	}

	// METODO QUE RECIBA UNA POSICION Y RETORNE EL OBJETO QUE SE ENCUENTRA EN EL
	// ARREGLO "doc"
	public TipoDocumento obtener(int pos) {
		return doc.get(pos);
	}	
	
	// METODO QUE RECIBA UN CODIGO A BUSCAR Y RETORNE EL OBJETO QUE SE ENCUENTRA
	// DENTRO DEL ARREGLO "doc"
	// CASO CONTRARIO DEVUELVE NULL
	public TipoDocumento buscar(int cod) {
		for (TipoDocumento x : doc) {
			if (x.getCodDoc() == cod)
				return x;
		}
		return null;
	}
	
	//METODO QUE RECIBA UN CODIGO A BUSCAR Y RETORNE EL NOMBRE QUE SE ENCUENTRA EN EL ARREGLO "are" 
	//CASO CONTRARIO RETORNA NULL
		public String bnombre(int cod) {
			for (TipoDocumento x : doc) {
				if (x.getCodDoc() == cod)
					return x.getDesDoc();
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
			cod = doc.get(tamaño() - 1).getCodDoc() + 1;
		}
		return cod;

	}

	// GRABAR DE LA MEMORIA AL ARCHIVO DE TEXTO
	public void grabar() {

		try {

			PrintWriter pw = new PrintWriter(new FileWriter(
					"data/tipodocumento.txt"));
			String linea;

			for (TipoDocumento c : doc) {
				// LA VARIABLE LINEA ALMACENA EL REGISTRO ACTUAL
				linea = c.getCodDoc() + "," + c.getDesDoc() + ","
						+ c.getAbrDoc() + "," + c.getStatusDoc();
				// GRABAR EL REGISTRO ACTUAL EN EL ARCHIVO "tipodocumento.txt"
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
					"data/tipodocumento.txt"));
			String linea;
			while ((linea = br.readLine()) != null) {
				// CREAR UN ARREGLO DEL TIPO STRING SEPARANDO LOS CAMPOS
				String row[] = linea.split(",");
				// CREAMOS EL OBJETO "c"
				TipoDocumento c = new TipoDocumento(Integer.parseInt(row[0]),
						row[1], row[2], Integer.parseInt(row[3]));
				// ENVIAR EL OBJETO "c" AL ARREGLO "doc"
				doc.add(c);
			}
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
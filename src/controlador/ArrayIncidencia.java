package controlador;

import java.io.*;
import java.util.ArrayList;

import entidades.Incidencia;

public class ArrayIncidencia {
	
	//CREAMOS NUESTRA VARIABLE ARRAYLIST
	ArrayList<Incidencia> incidencia;
	
	//METODO CONSTRUCTOR
	public ArrayIncidencia() {
		incidencia = new ArrayList<Incidencia>();
		//cargarDatos();
	}
	
	/*------------------------------------
	 * METODOS PARA DAR MANTENIMIENTO AL ARREGLO
	 * -----------------------------------*/
	public void adicionar(Incidencia x) {
		incidencia.add(x);
	}

	public void eliminar(Incidencia x) {
		incidencia.remove(x);
	}

	public int tamaño() {
		return incidencia.size();
	}

	// METODO PARA BUSCAR LA POSICION DE LA INCIDENCIA
	public Incidencia obtener(int posicion) {
		return incidencia.get(posicion);
	}

	// METODO PARA BUSCAR TODOS LOS OBJETOS POR SU CODIGO
	public Incidencia buscar(int cod) {
		for (Incidencia x : incidencia) {
			if (x.getCodigo() == cod) {
				return x;
			}
		}
		return null;
	}

	// GENERAR CODIGO
	public int GeneraCodigo() {
		int cod = 0;

		if (tamaño() == 0) {
			cod = 1;
		} else {
			cod = incidencia.get(tamaño() - 1).getCodigo() + 1;
		}
		return cod;

	}
	
	// METODO PARA CARGAR LOS DATOS incidencia.txt

	public void cargarDatos() {
		try {
			FileReader fr = new FileReader("data/incidencia.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea = null;
			while ((linea = br.readLine()) != null) {
				String[] row = linea.split(",");
				Incidencia x = new Incidencia(Integer.parseInt(row[0]),
						Integer.parseInt(row[1]), Integer.parseInt(row[2]),
						Integer.parseInt(row[3]), row[4], row[5],
						Integer.parseInt(row[6]), Integer.parseInt(row[7]),
						row[8], row[9], row[10], Integer.parseInt(row[11]));
				incidencia.add(x);
			}
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// GRABAR EN UN ARCHIVO TXT
	
	public void grabar() {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("data/incidencia.txt"));
			String linea;
			for (Incidencia x : incidencia) {
				linea = x.getCodigo() + "," + x.getCodUsu() + ","
						+ x.getCodEsp() + "," + x.getCodTipInc() + ","
						+ x.getDescripcion() + "," + x.getComentarios() + ","
						+ x.getTiempoEst() + "," + x.getTiempoReal() + ","
						+ x.getFecRegistro() + "," + x.getFecInicio() + ","
						+ x.getFecFin() + "," + x.getEstado();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}

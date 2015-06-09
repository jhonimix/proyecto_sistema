package controlador;

import entidades.Usuario;

import java.io.*;
import java.util.ArrayList;

public class ArrayUsuario {

	// CREAMOS NUESTRA VARIABLE ARRAYLIST
	private ArrayList<Usuario> user;

	public ArrayList<Usuario> ListarUsuario() {
		return user;
	}

	// METODO CONSTRUCTOR
	public ArrayUsuario() {
		user = new ArrayList<Usuario>();
		cargarDatos();
	}

	// ---------------------------------------------------
	// METODOS PARA DAR MANTENIMIENTO AL ARRAYLIST |
	// ---------------------------------------------------
	public void adicionar(Usuario x) {
		user.add(x);
	}

	public void eliminar(Usuario x) {
		user.remove(x);
	}

	public int tamaño() {
		return user.size();
	}

	// METODO PARA BUSCAR LA POSICION DEL OBJETO USUARIO
	public Usuario obtener(int posicion) {
		return user.get(posicion);
	}

	// METODO PARA BUSCAR TODOS LOS OBJETOS POR SU CODIGO
	public Usuario buscar(int cod) {
		for (Usuario x : user) {
			if (x.getCodUser() == cod) {
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
			cod = user.get(tamaño() - 1).getCodUser() + 1;
		}
		return cod;

	}

	// METODO PARA CARGAR LOS DATOS usuarios.txt

	public void cargarDatos() {
		try {
			FileReader fr = new FileReader("usuarios.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea = null;
			while ((linea = br.readLine()) != null) {
				String[] row = linea.split(",");
				Usuario x = new Usuario(Integer.parseInt(row[0]), row[1],
						row[2], Integer.parseInt(row[3]), row[4],
						Integer.parseInt(row[5]), row[6], row[7], row[8],
						Integer.parseInt(row[9]));
				user.add(x);
			}
			fr.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	// GRABAR EN UN ARCHIVO TXT
	public void grabar() {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("usuarios.txt"));
			String linea;
			for (Usuario u : user) {
				// La variable linea almacena el registro actual
				linea = u.getCodUser() + "," + u.getNameUser() + ","
						+ u.getLastnameUser() + "," + u.getCodDocUser() + ","
						+ u.getDniUser() + "," + u.getArea() + ","
						+ u.getEmail() + "," + u.getFono() + ","
						+ u.getFechaIngreso() + "," + u.getStatus();
				// Grabar el registro actual en el archivo Empleado.txt
				pw.println(linea);
			}
			// Cerrar el archivo
			pw.close();
		} catch (Exception e) {
			// Mostrar el mensaje de error
			e.printStackTrace();
		}
	}
}

package controlador;
//Importamos la clase usuario
import entidades.usuario;

import java.io.BufferedReader;
import java.io.FileReader;
//importamos la utilidad de array list
import java.util.ArrayList;

public class ArrayUsuario {
	
	//Creamos nuestra variable arraylist
	private ArrayList<usuario> user;
	private BufferedReader br;
	
	//creamos los metodos del arrayList para el objeto Usuario
	public ArrayUsuario(){
		user = new ArrayList<usuario>();
	}
	public void adicionar(usuario x){
		user.add(x);
	}
	public void eliminar(usuario x){
		user.remove(x);
	}
	//Metodo para buscar la posicion del objeto usuario
	
	public usuario obtener(int posicion){
		return user.get(posicion);
	}
	
	//metodo para buscar todos los objetos por su codigo
	
	public usuario buscar(int cod){
		for(usuario x:user){
			if(x.getCodUser()==cod){
				return x;
			}
		}
		return null;
	}
	
	//metodo para obtener el tamaño del array usuario
	public int tamaño(){
		return user.size();
	}
	//metodo para cargar los datos del archivo usuarios.txt
	
	public void cargarDatos(){
		try {
			FileReader fr = new FileReader("usuarios.txt");
			br = new BufferedReader(fr);
			String linea = br.readLine();
			while(linea!=null){
				String[] row = linea.split(",");
				usuario x = new usuario(Integer.parseInt(row[0]),row[1],row[2],Integer.parseInt(row[3]),
						Integer.parseInt(row[4]),Integer.parseInt(row[5]),row[6],row[7],
						row[8],Integer.parseInt(row[9]),row[10]);
				user.add(x);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//public usuario(int codUser, String nameUser, String lastnameUser, int codDocUser,
		//int dniUser, int area, String email, String fono,
		//String fechaIngreso, int status) {
	}
}

package controlador;
//Importamos la clase usuario
import entidades.Usuario;

import java.io.*;
//importamos la utilidad de array list
import java.util.ArrayList;



public class ArrayUsuario {
	
	//Creamos nuestra variable arraylist
	private ArrayList<Usuario> user;
	
	
	public ArrayList<Usuario> ListarUsuario(){
		return user;
	}
	
	//creamos los metodos del arrayList para el objeto Usuario
	public ArrayUsuario(){
		user = new ArrayList<Usuario>();
		cargarDatos();
	}
	public void adicionar(Usuario x){
		user.add(x);
	}
	public void eliminar(Usuario x){
		user.remove(x);
	}
	//Metodo para buscar la posicion del objeto usuario
	
	public Usuario obtener(int posicion){
		return user.get(posicion);
	}
	
	//metodo para buscar todos los objetos por su codigo
	
	public Usuario buscar(int cod){
		for(Usuario x:user){
			if(x.getCodUser()==cod){
				return x;
			}
		}
		return null;
	}
	
	//GENERAR CODIGO
	public int GeneraCodigo(){
			int cod=0;
			
			if(tamaño()==0){
				cod=1;
			}else{
				cod=user.get(tamaño()-1).getCodUser()+1;
			}
			return cod;
			
	}
	
	//metodo para obtener el tamaño del array usuario
	public int tamaño(){
		return user.size();
	}
	//metodo para cargar los datos del archivo usuarios.txt
	
	public void cargarDatos(){
		try {
			FileReader fr = new FileReader("usuarios.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea = null;
			while((linea = br.readLine())!=null){
				String[] row = linea.split(",");
				Usuario x = new Usuario();
				x.setCodDocUser(Integer.parseInt(row[0].trim()));
				x.setNameUser(row[1].trim());
				x.setLastnameUser(row[2].trim());
				x.setCodDocUser(Integer.parseInt(row[3].trim()));
				x.setDniUser(row[4].trim());
				x.setArea(Integer.parseInt(row[5].trim()));
				x.setEmail(row[6].trim());
				x.setFono(row[7].trim());
				x.setFechaIngreso(row[8].trim());
				//x.setPass(row[9].trim());
				x.setStatus(Integer.parseInt(row[9].trim()));
				user.add(x);
			}
			fr.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	//GRABAR EN UN ARCHIVO TXT
			public void grabar() {

				try {
					PrintWriter pw = new PrintWriter(new FileWriter("usuarios.txt"));
					String linea;
					for (Usuario u : user) {
						// La variable linea almacena el registro actual
						linea = u.getCodUser() + "," + u.getNameUser()+","+u.getLastnameUser()+","+
						u.getCodDocUser()+","+u.getDniUser()+","+u.getArea()+","+
						u.getEmail()+","+u.getFono()+","+u.getFechaIngreso()+","+u.getStatus();
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

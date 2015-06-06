package controlador;
//Importamos la clase usuario
import entidades.usuario;
//importamos la utilidad de array list
import java.util.ArrayList;

public class ArrayUsuario {
	
	//Creamos nuestra variable arraylist
	private ArrayList<usuario> user;
	
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
	
}

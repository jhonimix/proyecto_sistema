package controlador;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import entidades.Especialista;

public class ArrayEspecialidad {	

	private ArrayList<Especialista> esp = new ArrayList<Especialista>();
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	//Constructor del Arreglo
	public ArrayEspecialidad(){
		
	}
	
	//método que retorna la cantidad de objetos ingresados
	public int tamaño(){
		return esp.size();
	}
	
	//método que reciba un objeto de la clase Empleado y lo adicione al
	//Arreglo de objetos "emp"
	public void adicionar(Especialista e){
		esp.add(e);
	}
	
	//método que reciba un objeto de la clase Empleado y elimine el objeto
	//dentro del Arreglo "emp"
	public void eliminar(Especialista e){
		esp.remove(e);
	}
	
	//método que reciba una posición y retorne el objeto que se encuentra en
	//el Arreglo "emp"
	public Especialista obtener(int pos){
		return esp.get(pos);
	}
	
	//método que reciba un código a buscar y retorne el objeto que se encuentra en
	//el Arreglo "emp" caso contrario retorne null
	public Especialista buscar(int cod){
		//usando for "foreach"
		for(Especialista x:esp){
			if(x.getCodEsp()==cod)
				return x;
		}
		return null;
	}
	//Grabar de la memoria al archivo de texto
			public void grabar(){
				
				try {

					PrintWriter pw = new PrintWriter(new FileWriter("Especialista.txt"));
					String linea;
					
					
					//cerrar el archivo
					pw.close();
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}

			//graba del archivo de texto a la memoria(Arraylist)
			public void cargar(){
				try {
					BufferedReader br = new BufferedReader(new FileReader("Especialista.txt"));
					String linea;			
					while((linea=br.readLine())!=null){
						//crear un arreglo del tipo string separando losca mpos
						String row[]= linea.split(",");
						//creamos el objeto
						
						//enviar objeto "" al arreglo ""
						
					}
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
}
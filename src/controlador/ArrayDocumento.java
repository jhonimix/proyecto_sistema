package controlador;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import entidades.TipoDocumento;

public class ArrayDocumento {

	private ArrayList<TipoDocumento> doc = new ArrayList<TipoDocumento>();

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	//Constructor del Arreglo
	public ArrayDocumento(){
		
	}
	
	//método que retorna la cantidad de objetos ingresados
	public int tamaño(){
		return doc.size();
	}
	
	//método que reciba un objeto de la clase Empleado y lo adicione al
	//Arreglo de objetos "emp"
	public void adicionar(TipoDocumento e){
		doc.add(e);
	}
	
	//método que reciba un objeto de la clase Empleado y elimine el objeto
	//dentro del Arreglo "emp"
	public void eliminar(TipoDocumento e){
		doc.remove(e);
	}
	
	//método que reciba una posición y retorne el objeto que se encuentra en
	//el Arreglo "emp"
	public TipoDocumento obtener(int pos){
		return doc.get(pos);
	}
	
	//método que reciba un código a buscar y retorne el objeto que se encuentra en
	//el Arreglo "emp" caso contrario retorne null
	public TipoDocumento buscar(int cod){
		//usando for "foreach"
		for(TipoDocumento x:doc){
			if(x.getCodDoc()==cod)
				return x;
		}
		return null;
	}
	//Grabar de la memoria al archivo de texto
			public void grabar(){
				
				try {

					FileReader fr = new FileReader("tipodocumento.txt");
					BufferedReader br = new BufferedReader(fr);
					String linea = null;
					while((linea = br.readLine())!=null){
						String[] row = linea.split(",");
						TipoDocumento x = new TipoDocumento();
						x.setCodDoc(Integer.parseInt(row[0]));
						x.setDesDoc(row[1]);
						//x.s
					
					}
					//cerrar el archivo
					fr.close();
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}

			//graba del archivo de texto a la memoria(Arraylist)
			public void cargar(){
				try {
					BufferedReader br = new BufferedReader(new FileReader("Documento.txt"));
					String linea;			
					while((linea=br.readLine())!=null){
						//crear un arreglo del tipo string separando losca mpos
						String row[]= linea.split(",");
						//creamos el objeto
						
						//enviar objeto "e" al arreglo "emp"
							
					}
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
}
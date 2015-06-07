package controlador;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import entidades.TipoIncidencia;

public class ArrayTipoIncidencia {
	
	
	private ArrayList<TipoIncidencia> tip_inci = new ArrayList<TipoIncidencia>();

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	//Constructor del Arreglo	
	public ArrayTipoIncidencia() {
	
	}	
		
	//método que retorna la cantidad de objetos ingresados
	public int tamaño(){
		return tip_inci.size();
	}
		
	//método que reciba un objeto de la clase Empleado y lo adicione al
	//Arreglo de objetos "emp"
	public void adicionar(TipoIncidencia e){
		tip_inci.add(e);
	}
	
	//método que reciba un objeto de la clase Empleado y elimine el objeto
	//dentro del Arreglo "emp"
	public void eliminar(TipoIncidencia e){
		tip_inci.remove(e);
	}
	
	//método que reciba una posición y retorne el objeto que se encuentra en
	//el Arreglo "emp"
	public TipoIncidencia obtener(int pos){
		return tip_inci.get(pos);
	}
	
	//método que reciba un código a buscar y retorne el objeto que se encuentra en
	//el Arreglo "emp" caso contrario retorne null
	public TipoIncidencia buscar(int cod){
		//usando for "foreach"
		for(TipoIncidencia x:tip_inci){
			if(x.getCodTipoInc()==cod)
				return x;
		}
		return null;
	}
	//Grabar de la memoria al archivo de texto
			public void grabar(){
				
				try {

					PrintWriter pw = new PrintWriter(new FileWriter("data/tipoincidencia.txt"));
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
					BufferedReader br = new BufferedReader(new FileReader("data/tipoincidencia.txt"));
					String linea;			
					while((linea=br.readLine())!=null){
						//crear un arreglo del tipo string separando losca mpos
						String row[]= linea.split(",");
						//creamos el objeto
						TipoIncidencia x=new TipoIncidencia();
						x.setCodTipoInc(Integer.parseInt(row[0]));
						x.setDesTipoInc(row[1]);
						x.setAbTipoInc(row[2]);
						x.setEstTipoInc(Integer.parseInt(row[3]));
						//enviar objeto "e" al arreglo "emp"
									
					}
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
}

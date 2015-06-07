package entidades;

public class TipoDocumento {
	
	//DECLARAMOS ATRIBUTOS
	private int codDoc;	//Autogenerado
	private String desDoc;
	private String abrDoc;
	private int statusDoc;	// 0 = No Activo
							// 1 = ACtivo
	
	//DECLARAMOS METODOS GET/SET
	
	public int getCodDoc() {
		return codDoc;
	}

	public void setCodDoc(int codDoc) {
		this.codDoc = codDoc;
	}

	public String getDesDoc() {
		return desDoc;
	}

	public void setDesDoc(String desDoc) {
		this.desDoc = desDoc;
	}

	public String getAbrDoc() {
		return abrDoc;
	}

	public void setAbrDoc(String abrDoc) {
		this.abrDoc = abrDoc;
	}

	public int getStatusDoc() {
		return statusDoc;
	}

	public void setStatusDoc(int statusDoc) {
		this.statusDoc = statusDoc;
	}
	
	//DECLARAMOS CONSTRUCTOR CON ATRIBUTOS
	public TipoDocumento(int codDoc, String desDoc, String abrDoc, int statusDoc) {
		super();
		this.codDoc = codDoc;
		this.desDoc = desDoc;
		this.abrDoc = abrDoc;
		this.statusDoc = statusDoc;
	}
	
	

	//DECLARAMOS CONSTRUCTOR SIN ATRIBUTOS
	public TipoDocumento() {
		super();
	}

	
	
}

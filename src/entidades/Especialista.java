package entidades;

public class Especialista {

	//DECLARAMOS ATRIBUTOS
	private int codEsp;			// Autogenerado
	private String nomEsp;
	private String apeEsp;
	private String espEsp;
	private String anexoEsp;
	private String fecIngEsp;		// DD/MM/AAAA
	private int statusEsp;			// 0 = No activo
									// 1 = Activo
	
	//DECLARAMOS METODOS GET/SET
	public int getCodEsp() {
		return codEsp;
	}

	public void setCodEsp(int codEsp) {
		this.codEsp = codEsp;
	}

	public String getNomEsp() {
		return nomEsp;
	}

	public void setNomEsp(String nomEsp) {
		this.nomEsp = nomEsp;
	}

	public String getApeEsp() {
		return apeEsp;
	}

	public void setApeEsp(String apeEsp) {
		this.apeEsp = apeEsp;
	}

	public String getEspEsp() {
		return espEsp;
	}

	public void setEspEsp(String espEsp) {
		this.espEsp = espEsp;
	}

	public String getAnexoEsp() {
		return anexoEsp;
	}

	public void setAnexoEsp(String anexoEsp) {
		this.anexoEsp = anexoEsp;
	}

	public String getFecIngEsp() {
		return fecIngEsp;
	}

	public void setFecIngEsp(String fecIngEsp) {
		this.fecIngEsp = fecIngEsp;
	}

	public int getStatusEsp() {
		return statusEsp;
	}

	public void setStatusEsp(int statusEsp) {
		this.statusEsp = statusEsp;
	}
	
	//DECLARAMOS CONSTRUCTOR CON ATRIBUTOS
	public Especialista(int codEsp, String nomEsp, String apeEsp,
			String espEsp, String anexoEsp, String fecIngEsp, int statusEsp) {
		super();
		this.codEsp = codEsp;
		this.nomEsp = nomEsp;
		this.apeEsp = apeEsp;
		this.espEsp = espEsp;
		this.anexoEsp = anexoEsp;
		this.fecIngEsp = fecIngEsp;
		this.statusEsp = statusEsp;
	}
	
	

	//DECLARAMOS CONSTRUCTOR SIN ATRIBUTOS
	public Especialista() {
		super();
	}
	
	
}
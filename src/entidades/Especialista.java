package entidades;

public class Especialista {

	//DECLARAMOS ATRIBUTOS
	private int cod_esp;			// Autogenerado
	private String nom_esp;
	private String ape_esp;
	private String esp_esp;
	private String ane_esp;
	private String fec_ing_esp;		// DD/MM/AAAA
	private int est_esp;			// 0 = No activo
									// 1 = Activo
	
	//DECLARAMOS METODOS GET/SET
	public int getCod_esp() {
		return cod_esp;
	}
	public void setCod_esp(int cod_esp) {
		this.cod_esp = cod_esp;
	}
	public String getNom_esp() {
		return nom_esp;
	}
	public void setNom_esp(String nom_esp) {
		this.nom_esp = nom_esp;
	}
	public String getApe_esp() {
		return ape_esp;
	}
	public void setApe_esp(String ape_esp) {
		this.ape_esp = ape_esp;
	}
	public String getEsp_esp() {
		return esp_esp;
	}
	public void setEsp_esp(String esp_esp) {
		this.esp_esp = esp_esp;
	}
	public String getAne_esp() {
		return ane_esp;
	}
	public void setAne_esp(String ane_esp) {
		this.ane_esp = ane_esp;
	}
	public String getFec_ing_esp() {
		return fec_ing_esp;
	}
	public void setFec_ing_esp(String fec_ing_esp) {
		this.fec_ing_esp = fec_ing_esp;
	}
	public int getEst_esp() {
		return est_esp;
	}
	public void setEst_esp(int est_esp) {
		this.est_esp = est_esp;
	}
	
	//DECLARAMOS CONSTRUCTOR CON ATRIBUTOS
	public Especialista(int cod_esp, String nom_esp, String ape_esp,
			String esp_esp, String ane_esp, String fec_ing_esp, int est_esp) {
		super();
		this.cod_esp = cod_esp;
		this.nom_esp = nom_esp;
		this.ape_esp = ape_esp;
		this.esp_esp = esp_esp;
		this.ane_esp = ane_esp;
		this.fec_ing_esp = fec_ing_esp;
		this.est_esp = est_esp;
	}
	
	//DECLARAMOS CONSTRUCTOR SIN ATRIBUTOS
	public Especialista() {
		super();
	}
	
}
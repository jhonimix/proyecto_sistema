package entidades;

public class TipoDocumento {
	
	//DECLARAMOS ATRIBUTOS
	private int cod_doc;	//Autogenerado
	private String des_doc;
	private String abr_doc;
	private int est_doc;	// 0 = No Activo
							// 1 = ACtivo
	
	//DECLARAMOS METODOS GET/SET
	public int getCod_doc() {
		return cod_doc;
	}
	public void setCod_doc(int cod_doc) {
		this.cod_doc = cod_doc;
	}
	public String getDes_doc() {
		return des_doc;
	}
	public void setDes_doc(String des_doc) {
		this.des_doc = des_doc;
	}
	public String getAbr_doc() {
		return abr_doc;
	}
	public void setAbr_doc(String abr_doc) {
		this.abr_doc = abr_doc;
	}
	public int getEst_doc() {
		return est_doc;
	}
	public void setEst_doc(int est_doc) {
		this.est_doc = est_doc;
	}
	
	//DECLARAMOS CONSTRUCTOR CON ATRIBUTOS
	public TipoDocumento(int cod_doc, String des_doc, String abr_doc,
			int est_doc) {
		super();
		this.cod_doc = cod_doc;
		this.des_doc = des_doc;
		this.abr_doc = abr_doc;
		this.est_doc = est_doc;
	}
	
	//DECLARAMOS CONSTRUCTOR SIN ATRIBUTOS
	public TipoDocumento() {
		super();
	}
	
}

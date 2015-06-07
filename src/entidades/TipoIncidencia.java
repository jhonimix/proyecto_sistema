package entidades;

public class TipoIncidencia {

	//DECLARAMOS ATRIBUTOS
	private int cod_tipo; 		// Autogenerado
	private String des_tipo;
	private String abr_tipo;
	private int est_tipo;		// 0 = No Activo
								// 1 = Activo
	
	//DECLARAMOS METODOS GET/SET
	public int getCod_tipo() {
		return cod_tipo;
	}
	public void setCod_tipo(int cod_tipo) {
		this.cod_tipo = cod_tipo;
	}
	public String getDes_tipo() {
		return des_tipo;
	}
	public void setDes_tipo(String des_tipo) {
		this.des_tipo = des_tipo;
	}
	public String getAbr_tipo() {
		return abr_tipo;
	}
	public void setAbr_tipo(String abr_tipo) {
		this.abr_tipo = abr_tipo;
	}
	public int getEst_tipo() {
		return est_tipo;
	}
	public void setEst_tipo(int est_tipo) {
		this.est_tipo = est_tipo;
	}
	
	//DECLARAMOS CONSTRUCTOR CON ATRIBUTOS
	public TipoIncidencia(int cod_tipo, String des_tipo, String abr_tipo,
			int est_tipo) {
		super();
		this.cod_tipo = cod_tipo;
		this.des_tipo = des_tipo;
		this.abr_tipo = abr_tipo;
		this.est_tipo = est_tipo;
	}
	
	//DECLARAMOS CONSTRUCTOR SIN ATRIBUTOS
	public TipoIncidencia() {
		super();
	}
	
}

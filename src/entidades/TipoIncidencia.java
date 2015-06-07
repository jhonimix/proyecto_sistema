package entidades;

public class TipoIncidencia {

	//DECLARAMOS ATRIBUTOS
	private int codTipoInc; 		// Autogenerado
	private String desTipoInc;
	private String abTipoInc;
	private int estTipoInc;		// 0 = No Activo
								// 1 = Activo
	
	//DECLARAMOS METODOS GET/SET
	public int getCodTipoInc() {
		return codTipoInc;
	}

	public void setCodTipoInc(int codTipoInc) {
		this.codTipoInc = codTipoInc;
	}

	public String getDesTipoInc() {
		return desTipoInc;
	}

	public void setDesTipoInc(String desTipoInc) {
		this.desTipoInc = desTipoInc;
	}

	public String getAbTipoInc() {
		return abTipoInc;
	}

	public void setAbTipoInc(String abTipoInc) {
		this.abTipoInc = abTipoInc;
	}

	public int getEstTipoInc() {
		return estTipoInc;
	}

	public void setEstTipoInc(int estTipoInc) {
		this.estTipoInc = estTipoInc;
	}
	
	//DECLARAMOS CONSTRUCTOR CON ATRIBUTOS
	public TipoIncidencia(int codTipoInc, String desTipoInc, String abTipoInc,
			int estTipoInc) {
		super();
		this.codTipoInc = codTipoInc;
		this.desTipoInc = desTipoInc;
		this.abTipoInc = abTipoInc;
		this.estTipoInc = estTipoInc;
	}
	
	

	//DECLARAMOS CONSTRUCTOR SIN ATRIBUTOS
	public TipoIncidencia() {
		super();
	}

	
	
}

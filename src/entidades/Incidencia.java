package entidades;

public class Incidencia {
	
	
	//VARIABLES GLOBALES DE LA INCIDENCIA
	private int codigo;
	private int codUsu;
	private int codEsp;
	private int codTipInc;
	private String descripcion;
	private String comentarios;
	private int tiempoEst;
	private int tiempoReal;
	private String fecRegistro;
	private String fecInicio;
	private String fecFin;
	private int estado;
	
	//METODOS GET/SET
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodUsu() {
		return codUsu;
	}
	public void setCodUsu(int codUsu) {
		this.codUsu = codUsu;
	}
	public int getCodEsp() {
		return codEsp;
	}
	public void setCodEsp(int codEsp) {
		this.codEsp = codEsp;
	}
	public int getCodTipInc() {
		return codTipInc;
	}
	public void setCodTipInc(int codTipInc) {
		this.codTipInc = codTipInc;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public int getTiempoEst() {
		return tiempoEst;
	}
	public void setTiempoEst(int tiempoEst) {
		this.tiempoEst = tiempoEst;
	}
	public int getTiempoReal() {
		return tiempoReal;
	}
	public void setTiempoReal(int tiempoReal) {
		this.tiempoReal = tiempoReal;
	}
	public String getFecRegistro() {
		return fecRegistro;
	}
	public void setFecRegistro(String fecRegistro) {
		this.fecRegistro = fecRegistro;
	}
	public String getFecInicio() {
		return fecInicio;
	}
	public void setFecInicio(String fecInicio) {
		this.fecInicio = fecInicio;
	}
	public String getFecFin() {
		return fecFin;
	}
	public void setFecFin(String fecFin) {
		this.fecFin = fecFin;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	//CONSTRUCTOR
	
	public Incidencia(int codigo, int codUsu, int codEsp, int codTipInc, String descripcion, String comentarios, int tiempoEst,
					  int tiempoReal, String fecRegistro, String fecInicio, String fecFin, int estado) {
		this.codigo = codigo;
		this.codUsu = codUsu;
		this.codEsp = codEsp;
		this.codTipInc = codTipInc;
		this.descripcion = descripcion;
		this.comentarios = comentarios;
		this.tiempoEst = tiempoEst;
		this.tiempoReal = tiempoReal;
		this.fecRegistro = fecRegistro;
		this.fecInicio = fecInicio;
		this.fecFin = fecFin;
		this.estado = estado;
	}
	
	
	
}

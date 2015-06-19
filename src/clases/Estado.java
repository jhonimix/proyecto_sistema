package clases;

public class Estado {
	
	private static int codigo0;
	private static int codigo1;	
	private static String nombre0;
	private static String nombre1;
		
	static{
		codigo0=0;
		codigo1=1;
		nombre0 = "NO ACTIVO";
		nombre1 = "ACTIVO";
	}

	public static int getCodigo0() {
		return codigo0;
	}

	public static int getCodigo1() {
		return codigo1;
	}

	public static String getNombre0() {
		return nombre0;
	}
	
	public static String getNombre1() {
		return nombre1;
	}
	
	public String bnombre(int codigo){
		if(codigo==0)
			return nombre0;
		else {
			return nombre1;
		}
	}
}

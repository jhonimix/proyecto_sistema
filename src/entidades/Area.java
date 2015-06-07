package entidades;

public class Area {
	private int codArea;
	private String nameArea;
	private String DescArea;
	private String nameSmallArea;
	private String nameLargeArea;
	private int status;
	
	
	
	public int getCodArea() {
		return codArea;
	}



	public void setCodArea(int codArea) {
		this.codArea = codArea;
	}



	public String getNameArea() {
		return nameArea;
	}



	public void setNameArea(String nameArea) {
		this.nameArea = nameArea;
	}



	public String getDescArea() {
		return DescArea;
	}



	public void setDescArea(String descArea) {
		DescArea = descArea;
	}



	public String getNameSmallArea() {
		return nameSmallArea;
	}



	public void setNameSmallArea(String nameSmallArea) {
		this.nameSmallArea = nameSmallArea;
	}



	public String getNameLargeArea() {
		return nameLargeArea;
	}



	public void setNameLargeArea(String nameLargeArea) {
		this.nameLargeArea = nameLargeArea;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	//Constructor del objeto Area
	public Area(int codArea, String nameArea, String descArea,
			String nameSmallArea, String nameLargeArea, int status) {
		
		this.codArea = codArea;
		this.nameArea = nameArea;
		DescArea = descArea;
		this.nameSmallArea = nameSmallArea;
		this.nameLargeArea = nameLargeArea;
		this.status = status;
	}
	
	
}

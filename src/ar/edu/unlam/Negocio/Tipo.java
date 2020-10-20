package ar.edu.unlam.Negocio;

public enum Tipo {
	LACTEOS("Lacteos", 01),
	BEBIDAS("Bebidas", 02),
	CARNES("Carnes",03),
	VERDURAS("Verduras",04),
	TECNOLOGIA("Tecnologia",05),
	CONGELADOS("Congelados",06);
	
	private String nombre;
	private Integer id;
	private Double descuento;
	
	
    Tipo(String nombre, Integer id) {
		this.nombre = nombre;
		this.id = id;
		this.descuento=0.0;
	}


	 public Double getDescuento() {
		return descuento;
	}


	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	
}

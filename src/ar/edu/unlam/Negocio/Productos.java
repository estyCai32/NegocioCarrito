package ar.edu.unlam.Negocio;

public class Productos {
	private Integer id;
	private String nombre;
	private Tipo tipo;
	private Double precio;
	private Double precioConDescuento;
	private Integer idCarrito;
	private static Integer idCarritoSiguiente=1;
	
	public Productos(Integer id, String nombre, Tipo tipo, Double precio) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
		this.idCarrito=idCarritoSiguiente;
		idCarritoSiguiente=idCarritoSiguiente+1;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getIdCarrito() {
		return idCarrito;
	}


	public Double getPrecioConDescuento() {
		return precioConDescuento;
	}


	public void setPrecioConDescuento(Double descuento) {
		precioConDescuento=0.0;
		Double totalDelDescuento=(((descuento*getPrecio())/100));
		
		precioConDescuento=getPrecio()-totalDelDescuento;
	
		this.precioConDescuento = precioConDescuento;
	}
	



	
	
	
	
	

}

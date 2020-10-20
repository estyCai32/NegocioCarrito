package ar.edu.unlam.Negocio;

import java.util.ArrayList;

public class Compras {
	private Integer id;
	private String nombreTitular;
	private ArrayList<Productos> carrito=new ArrayList<Productos>();
	private Double totalSINdesc=0.0;
	private Double total_A_PAGAR=0.0;
	
	
	public Compras() {
		
	}
	
	public Compras(Integer id, String nombreTitular) {
		this.id=id;
		this.nombreTitular=nombreTitular;
	}

	public Compras(Integer id, String nombreTitular, ArrayList<Productos> productosComprados) {
		super();
		this.id = id;
		this.nombreTitular = nombreTitular;
		this.carrito = productosComprados;
	}


	
//Getters and Setters	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreTitular() {
		return nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	public ArrayList<Productos> getProductosComprados() {
		return carrito;
	}

	public void setProductosComprados(ArrayList<Productos> productosComprados) {
		this.carrito = productosComprados;
	}

	public Double getTotalSINdesc() {
		return totalSINdesc;
	}

	public void setTotalSINdesc(Double totalSINdesc) {
		this.totalSINdesc = totalSINdesc;
	}

	public Double getTotal_A_PAGAR() {
		return total_A_PAGAR;
	}

	public void setTotal_A_PAGAR(Double total_A_PAGAR) {
		this.total_A_PAGAR = total_A_PAGAR;
	}
	
	
//MANEJO DE LA CLASE
	public Boolean agregarACarrito(Productos producto) {
		return this.carrito.add(producto);
	}
	
	public Boolean eliminarDeCarrito(Integer idCarrito) {
		Boolean seElimino=false;
		
		for (Productos productos : this.carrito) {
			if (productos.getIdCarrito().equals(idCarrito)) {
				this.carrito.remove(productos);
				seElimino=true;
			}		
		}
		return seElimino;
	}
	
	public String obtenerListaCompras() {
		String listaDeDetalle = "";
		Integer posicion=0;
		
		for (Productos p : this.carrito) {			
			
			listaDeDetalle+= posicion+"--"+p.getNombre()+"--"+p.getPrecio()+"$";			
			posicion++;
			listaDeDetalle+="\n";
		}
		listaDeDetalle+="\nPrecio Sin Descuento= " + calcularTotalSINDescuento();
		return listaDeDetalle;
	}

	
	public Double calcularTotalSINDescuento() {
		Double total=0.0;
		
		for (Productos p : this.carrito) {
			total+=p.getPrecio();
		}
		
		setTotalSINdesc(total);
		return total;
	}
	
	public Double calcularTotalConDescuento() {
		Double total=0.0;
		
		
		for (Productos p : this.carrito) {
			if (p.getPrecioConDescuento() == null) {
				total+=p.getPrecio();
			}else {
				total+=p.getPrecioConDescuento();
			}
		}
			
		return total;
	}
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compras other = (Compras) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
		
}

package ar.edu.unlam.Negocio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Negocio {
	private Integer idNegocio;
	private String nombre;
	private ArrayList<Productos> stockProductos=new ArrayList<Productos>();
	private HashSet<Tipo> tiposDeProductosEnDescuento=new HashSet<Tipo>();
	private HashSet<Compras> comprasDelDia=new HashSet<Compras>();
	
	
	public Negocio(Integer idNegocio, String nombre, ArrayList<Productos> stockProductos,
			HashSet<Tipo> tiposDeProductosEnDescuento, HashSet<Compras> comprasDelDia) {
		super();
		this.idNegocio = idNegocio;
		this.nombre = nombre;
		this.stockProductos = stockProductos;
		this.tiposDeProductosEnDescuento = tiposDeProductosEnDescuento;
		this.comprasDelDia = comprasDelDia;
	}
	
	public Negocio() {
		
	}
	
	
 //Getters & Setters
		
	public Integer getIdNegocio() {
		return idNegocio;
	}

	public void setIdNegocio(Integer idNegocio) {
		this.idNegocio = idNegocio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public HashSet<Compras> getComprasDelDia() {
		return comprasDelDia;
	}

	public void setComprasDelDia(HashSet<Compras> comprasDelDia) {
		this.comprasDelDia = comprasDelDia;
	}

	
	public HashSet<Tipo> getTiposDeProductosEnDescuento() {
		return tiposDeProductosEnDescuento;
	}

	
	public void setTiposDeProductosEnDescuento(HashSet<Tipo> tiposDeProductosEnDescuento) {
		this.tiposDeProductosEnDescuento = tiposDeProductosEnDescuento;
	}

	
	public ArrayList<Productos> getStockProductos() {
		return stockProductos;
	}

	
	public void setStockProductos(ArrayList<Productos> stockProductos) {
		this.stockProductos = stockProductos;
	}
	
	
//Manejo Stock del Negocio
	
	public Boolean agregarUnProductoAlInventario(Productos producto) {
		return this.stockProductos.add(producto);
	}
	
	public Boolean agregarVariosProductosAlInventario(List<Productos> producto) {
		return this.stockProductos.addAll(producto);
	}
 	
	
//COMPRAS
	public Boolean crearCompra(Compras compra) {
		return this.comprasDelDia.add(compra);
	}
	
	public Compras obtenerCompraXId(Integer id) {
		for (Compras compras : comprasDelDia) {
			if (compras.getId().equals(id)) {
				return compras;
			}
		}	
		return null;
	}
	
//APLICAR DESCUENTO
	public Double obtenerTotalConDescuento(Compras compra) {
		Double finalConDescuento=0.0;
		
		for (Productos c : compra.getProductosComprados()) {
			if (buscarSiTieneDescuento(c.getTipo())) {
				c.setPrecioConDescuento(c.getTipo().getDescuento());
			}
		}
		
		
		finalConDescuento=compra.calcularTotalConDescuento();
		
		return finalConDescuento;
	}
	
	private Boolean buscarSiTieneDescuento(Tipo tipo) {
			
		for (Tipo t : this.tiposDeProductosEnDescuento) {
			if (t.getId().equals(tipo.getId())) {
				return true;
			}
		}
		
		return false;
	}

	public Boolean agregarTipoADescuento(Tipo tipo, Double descuento) {
		tipo.setDescuento(descuento);
		return this.tiposDeProductosEnDescuento.add(tipo);  	
	}
	
	public String getFacturaConDescuento(Compras compra) {
		String factura=compra.obtenerListaCompras();
		
		factura+="\n TOTAL CON DESCUENTO=" + obtenerTotalConDescuento(compra);
		
		return factura;
	}
	

	
	
	
	
	
	
}

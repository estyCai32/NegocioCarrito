package ar.edu.unlam.Negocio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

public class NegocioTest {

//PRODUCTOS AL INVENTARIO	
	
	@Test
	public void cargarUNproductoAlStock() {	
	//Un Producto
	  Negocio dia=new Negocio();
	  ArrayList<Productos> stock=new ArrayList<Productos>();
	  dia.setStockProductos(stock);
	  	  
	  ArrayList<Productos> productosEsperados=new ArrayList<Productos>();
	  
	  Productos agua=new Productos(01, "Agua", Tipo.BEBIDAS, 75.0);
	  productosEsperados.add(agua);
	  
	  dia.agregarUnProductoAlInventario(agua);
	    
	  ArrayList<Productos> productosObtenidos=dia.getStockProductos();
	  
	  assertEquals(productosEsperados,productosObtenidos);  		
	}
	
	@Test
	public void cargarVariosProductosAlStock() {	
	//Varios Productos
	  Negocio dia=new Negocio();
	  ArrayList<Productos> stock=new ArrayList<Productos>();
	  dia.setStockProductos(stock);
	  
	  
	  
	  
	  ArrayList<Productos> productosEsperados=new ArrayList<Productos>();
	  
	  Productos agua=new Productos(01, "Agua", Tipo.BEBIDAS, 75.0);
	  Productos carne=new Productos(02, "Carne", Tipo.CARNES, 400.0);
	  productosEsperados.add(carne);
	  productosEsperados.add(agua);
	  
	  
	  
	  
	  dia.agregarVariosProductosAlInventario(productosEsperados); 
      ArrayList<Productos> productosObtenidos=dia.getStockProductos();
	  
	  assertEquals(productosEsperados,productosObtenidos);    
	}
	
	@Test
	public void cargarProductosRepetidos() {	
	//Varios Productos
	  Negocio dia=new Negocio();
	  ArrayList<Productos> stock=new ArrayList<Productos>();
	  dia.setStockProductos(stock);
	  

	  ArrayList<Productos> productosEsperados=new ArrayList<Productos>();
	  
	  Productos agua=new Productos(01, "Agua", Tipo.BEBIDAS, 75.0);
	  productosEsperados.add(agua);
	  productosEsperados.add(agua);
	  
	 	  
	  
	  dia.agregarVariosProductosAlInventario(productosEsperados); 
      ArrayList<Productos> productosObtenidos=dia.getStockProductos();
	  
	  assertEquals(productosEsperados,productosObtenidos);    
	}
	

//-----------COMPRAS----------
	@Test
	public void crearCompra() {
		Negocio dia=new Negocio();
		Compras compra=new Compras(01,"Esteban Barone");
		
		Productos agua=new Productos(01, "Agua", Tipo.BEBIDAS, 75.0);
	    Productos carne=new Productos(02, "Carne", Tipo.CARNES, 400.0);
	   
	    compra.agregarACarrito(agua);
		compra.agregarACarrito(carne);
		
		dia.crearCompra(compra);
		
		Compras compraObtenida=dia.obtenerCompraXId(01);
		Integer esperado= 2;
		
		assertEquals(esperado, compraObtenida.getProductosComprados().size(),0.0);
		
	}
	
	@Test
	public void calcularConDescuentosDelDia() {
//CREACION NEGOCIO		
		Negocio dia=new Negocio();
		
//CREACION COMPRA			
        Compras compra=new Compras(01,"Esteban Barone");
		Productos agua=new Productos(01, "Agua", Tipo.BEBIDAS, 75.0);
	    Productos carne=new Productos(02, "Carne", Tipo.CARNES, 400.0);	   
	    compra.agregarACarrito(agua);
		compra.agregarACarrito(carne);		
		dia.crearCompra(compra);
		
//CREACION TIPOS DE DESCUENTOS DEL DIA
		dia.agregarTipoADescuento(Tipo.CARNES, 50.0);
		
//OBTENER FINAL CON DESCUENTO
		Double obtenido= dia.obtenerTotalConDescuento(dia.obtenerCompraXId(01));
		Double esperado= 75.0 + 200.0;
		
		assertEquals(esperado,obtenido);
		
		
		
	}
	
	
	
	
	
	

}

package ar.edu.unlam.Negocio;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ComprasTest {

	@Test
	public void cargarCarrito() {
		Compras c=new Compras(01, "Esteban Barone");
		
		Productos agua=new Productos(01, "Agua", Tipo.BEBIDAS, 75.0);
	    Productos carne=new Productos(02, "Carne", Tipo.CARNES, 400.0);
	    Productos agua2=new Productos(01, "Agua", Tipo.BEBIDAS, 75.0);
	    
	    ArrayList<Productos> esperado=new ArrayList<Productos>();
	    esperado.add(agua);
	    esperado.add(carne);
	    esperado.add(agua);
	    
	    c.agregarACarrito(agua);
	    c.agregarACarrito(carne);
	    c.agregarACarrito(agua);
	    
	    
	    assertEquals(esperado,c.getProductosComprados());
	}
	
	@Test
	public void precioTOTALCarrito() {
		Compras c=new Compras(01, "Esteban Barone");
		
		Productos agua=new Productos(01, "Agua", Tipo.BEBIDAS, 75.0);
	    Productos carne=new Productos(02, "Carne", Tipo.CARNES, 400.0);
	    Productos agua2=new Productos(01, "Agua", Tipo.BEBIDAS, 75.0);
		
	
    	c.agregarACarrito(agua);
		c.agregarACarrito(carne);
		c.agregarACarrito(agua);
		
		Double expected=550.0;
		Double obtenido= c.calcularTotalSINDescuento();
		
		assertEquals(expected, obtenido);
		
	}
	
	@Test
	public void listaCompras() {
		Compras c=new Compras(01, "Esteban Barone");
		
		Productos agua=new Productos(01, "Agua", Tipo.BEBIDAS, 75.0);
	    Productos carne=new Productos(02, "Carne", Tipo.CARNES, 400.0);
	    Productos agua2=new Productos(01, "Agua", Tipo.BEBIDAS, 75.0);
		
	
    	c.agregarACarrito(agua);
		c.agregarACarrito(carne);
		c.agregarACarrito(agua);
		
		System.out.println(c.obtenerListaCompras());
	}

}

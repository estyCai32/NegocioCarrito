package ar.edu.unlam.Negocio;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProductosTest {

	@Test
	public void testIdCarrito() {
		Productos agua=new Productos(01, "Agua", Tipo.BEBIDAS, 75.0);
	    Productos carne=new Productos(02, "Carne", Tipo.CARNES, 400.0);
	    Productos agua2=new Productos(01, "Agua", Tipo.BEBIDAS, 75.0);
	    Productos c2=new Productos(02, "Carne", Tipo.CARNES, 400.0);
	    
	    assertEquals(agua.getIdCarrito(),1,0.0);
	    assertEquals(carne.getIdCarrito(),2,0.0);
	    assertEquals(agua2.getIdCarrito(),3,0.0);
	    assertEquals(c2.getIdCarrito(),4,0.0);
	}

}

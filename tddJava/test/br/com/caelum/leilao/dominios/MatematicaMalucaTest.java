package br.com.caelum.leilao.dominios;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MatematicaMalucaTest {

	private MatematicaMaluca matematicaMaluca;

	@Before
	public void build(){
		matematicaMaluca = new MatematicaMaluca();
	}
	
	@BeforeClass
	public static void testandoBeforeClass() {
	  System.out.println("before class");
	}

	@AfterClass
	public static void testandoAfterClass() {
	  System.out.println("after class");
	}
	
	@Test
	public void testaNumeroMaiorQue30() {
		assertEquals(31*4, matematicaMaluca.contaMaluca(31));
	}
	
	@Test
	public void testaNumeroMaiorQue10EMenorQue30() {
		assertEquals(15*3, matematicaMaluca.contaMaluca(15));
	}
	
	@Test
	public void testaNumeroMenorQue10() {
		assertEquals(5*2, matematicaMaluca.contaMaluca(5));
	}
	
}

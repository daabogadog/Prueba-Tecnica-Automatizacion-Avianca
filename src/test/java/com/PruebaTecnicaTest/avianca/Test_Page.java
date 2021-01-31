package com.PruebaTecnicaTest.avianca;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test_Page {

	private WebDriver driver;
	Consult_Page consult_page;

	//Se usa el driver de chrome y se consulta la pagina de avianca
	@Before	
	public void setUp() throws Exception {

		consult_page = new Consult_Page(driver);
		driver = consult_page.chromeDriverConnection();
		driver.manage().window().maximize();
		driver.get("https://www.avianca.com/co/es/");		
		Thread.sleep(2000);;
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}
	
     
	@Test
	public void test_consulata_vuelo() throws InterruptedException {
		
	    consult_page.Aceptar_cookies(driver);
		consult_page.Desde_Hacia(driver,"Bogota","Cartagena");
		Thread.sleep(2000);
		consult_page.Seleccionar_fecha(driver,"5",8,"15");// 5 corresponde al valor del dia de mes en curso, 8 mes regreso desde el mes de salida, dia de mes de regreso
		consult_page.Seleccionar_pasajeros_Buscar_vuelos(driver);	
		assertTrue(consult_page.Validar_presente_hora(driver));
		assertTrue(consult_page.Validar_presente_precio(driver));
		assertTrue(consult_page.Cantidad_de_resultados (driver));
		consult_page.Ordenar_precio(driver);
	}
	
	

}

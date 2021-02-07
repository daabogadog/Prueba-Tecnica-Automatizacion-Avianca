package com.PruebaTecnicaTest.avianca;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Test_Page {

	WebDriver driver;	
	Consult_Page consult_page;
	
	
	// Se usa el driver de chrome y se consulta la pagina de avianca
	@Before
	public void setUp() throws Exception {

		consult_page = new Consult_Page(driver);
		driver = consult_page.chromeDriverConnection();
		driver.manage().window().maximize();
		driver.get("https://www.avianca.com/co/es/");
		Thread.sleep(2000);
		;
	}

	public String getCellValue(String filepath, String sheetName, int rowNumber, int cellNumber) throws IOException {

		File file = new File(filepath);

		FileInputStream inputStream = new FileInputStream(file);

		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);

		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);

		XSSFRow row = newSheet.getRow(rowNumber);

		XSSFCell cell = row.getCell(cellNumber);

		return cell.getStringCellValue();

	}

	@Test
	public void test_consultar_vuelo() throws InterruptedException, IOException {

		String filepath = "C:\\Users\\Rentadvisor\\Desktop\\Libroprueba.xlsx";
		//String filepath = "./src/test/resources/Libroprueba.xlsx";
		
		String ida ="";
		String regreso ="";
		String fechainicial="";
		int mes = 0;
		String fecharegreso = "";
		
		for(int i=0;i<=0;i++)
		for(int j=0;j<4;) {
		ida =  consult_page.getCellValue_string(filepath, "Hoja1", i, j);j++;
		regreso = consult_page.getCellValue_string(filepath, "Hoja1", i, j);j++;
		fechainicial =String.valueOf(consult_page.getCellValue_int(filepath, "Hoja1",i, j));j++;
		mes = consult_page.getCellValue_int(filepath, "Hoja1", i, j);j++;
		fecharegreso = String.valueOf(consult_page.getCellValue_int(filepath, "Hoja1",i, j));j++;
		}

		consult_page.Aceptar_cookies(driver);
		consult_page.Desde_Hacia(driver, ida, regreso);
		Thread.sleep(2000);
		consult_page.Seleccionar_fecha(driver,fechainicial, mes, fecharegreso);														
		consult_page.Seleccionar_pasajeros_Buscar_vuelos(driver);
		assertTrue(consult_page.Validar_presente_hora(driver));
		assertTrue(consult_page.Validar_presente_precio(driver));
		assertTrue(consult_page.Cantidad_de_resultados(driver));
		assertTrue(consult_page.Ordenar_precio(driver));		
		assertEquals("Selecciona tu vuelo de regreso", consult_page.Seleccionar_vuelo(driver));
	

	}

}

package com.PruebaTecnicaTest.avianca;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Consult_Page extends Base {

	// elementos desde y hacia
	By TextDesde = By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div/div/section/div[3]/div[4]/div[1]/div/form/div/div[2]/div/div/div[1]/fieldset/div/div[1]/div/label/div/input[1]");
	By TextHacia = By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div/div/section/div[3]/div[4]/div[1]/div/form/div/div[2]/div/div/div[1]/fieldset/div/div[3]/div[2]/label/div/input[1]");

	// elementos fecha
	By iconoCalendario = By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div/div/section/div[3]/div[4]/div[1]/div/form/div/div[2]/div/div/div[2]/fieldset/div/div/div[1]/label/div/div/span/i");
	By fechasiguiente = By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div/div/section/div[3]/div[4]/div[1]/div/form/div/div[2]/div/div/div[2]/fieldset/div/div/div[2]/div[1]/table/tbody/tr/td[2]/div[1]/div[2]/i");
	By mes = By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div/div/section/div[3]/div[4]/div[1]/div/form/div/div[2]/div/div/div[2]/fieldset/div/div/div[2]/div[1]/table/tbody/tr/td[2]/div[1]/div[1]");
	
	// elementos pasajeros
	By addpasajeros = By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div/div/section/div[3]/div[4]/div[1]/div/form/div/div[2]/div/div/div[3]/fieldset/div/div[1]/div[1]/label/div/span/i");
	By pasajeros_continuar = By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div/div/section/div[3]/div[4]/div[1]/div/form/div/div[2]/div/div/div[3]/fieldset/div/div[1]/div[2]/button");
	
	// elementos pagina principal
	By Btncookies = By.xpath("/html/body/div[3]/div/div[1]/div[1]/section[1]/div[2]/div/div/div[2]/button");
	By Btnbuscarvuelos = By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div/div/section/div[3]/div[4]/div[1]/div/form/div/div[2]/div/div/div[3]/fieldset/div/div[4]/button");
     
	// elementos booking avianca
	By OrdenarHora = By.xpath("/html/body/app-root/main/div/avail-page/div/div/avail-cont/avail-pres/avail-header-pres/fixed-card-element/div[1]/div/div[1]/div/button[1]/span");
	By OrdenarPrecio = By.xpath("/html/body/app-root/main/div/avail-page/div/div/avail-cont/avail-pres/avail-header-pres/fixed-card-element/div[1]/div/div[1]/div/button[2]/span");
	
	public Consult_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
    //Aceptar cookies
	public void Aceptar_cookies(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Btncookies));

		
		click(Btncookies);
		Thread.sleep(1000);
		Hacer_scroll(driver,TextDesde);
	}
	

	// Metodo para ingresar datos en el campos desde y hasta
	public void Desde_Hacia(WebDriver driver,String destino,String lugar) throws InterruptedException {
     	
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(TextDesde));
		// llena el campo desde
		clear(TextDesde);
		Thread.sleep(2000);
		type(destino, TextDesde);
		WebElement EventoTeclado1 = findElement(TextDesde);
		EventoTeclado1.sendKeys(Keys.DOWN);
		EventoTeclado1.sendKeys(Keys.RETURN);		
		// llena el campo hasta
		clear(TextHacia);
		Thread.sleep(2000);
		type(lugar, TextHacia);
		WebElement EventoTeclado2 = findElement(TextHacia);
		EventoTeclado2.sendKeys(Keys.DOWN);
		EventoTeclado2.sendKeys(Keys.RETURN);
	}

	// Metodo para seleccionar las fechas de ida y salida
	
	  public void Seleccionar_fecha(WebDriver driver,String dia,int mes, String diaregreso) throws InterruptedException {
	  
		  click(iconoCalendario);
		  Thread.sleep(2000);
		  click(fechasiguiente);
		  By diasalida = By.xpath("//*[ @class='intern-day' and text()='"+dia+"']");
		  List<WebElement> elementsalida = driver.findElements(diasalida);
		  elementsalida.get(0).click();	
		  int i=1;
		  while(i!=mes) {
			 			  
			  Thread.sleep(1000);
			  click(fechasiguiente);
			  i++;
		  }
		  By diallegada = By.xpath("//*[ @class='intern-day' and text()='"+diaregreso+"']");
		  List<WebElement> elementsregreso = driver.findElements(diallegada);
		  elementsregreso.get(1).click();	
		  
		  
	  }
	 
	  //Metodo para seleccionar pasajeros y buscar vuelos
	  public void Seleccionar_pasajeros_Buscar_vuelos(WebDriver driver) throws InterruptedException {
		  
		  click(addpasajeros);
		  Thread.sleep(1000);
		 
		  click(pasajeros_continuar);
		  click(Btnbuscarvuelos);
				  
	  }
	  
	  //Validar que esta presenta la hora del vuelo
      public boolean Validar_presente_hora(WebDriver driver) throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver, 10);
  		wait.until(ExpectedConditions.visibilityOfElementLocated(OrdenarHora));  	  
	      return isDisplayed(OrdenarHora);
	  }
	  
      public boolean Validar_presente_precio(WebDriver driver) throws InterruptedException {
     	  
	      return isDisplayed(OrdenarPrecio);
	  }
      //Validar que la cantidad de resultados es igual a la de seleccion
      public boolean Cantidad_de_resultados (WebDriver driver) throws InterruptedException {
    	 
    	  List<WebElement> resultados = driver.findElements(By.xpath("//*[starts-with(@class,'bound-expander no-style ng-tns-c21')]"));	  
    	  List<WebElement> seleccion = driver.findElements(By.xpath("//div[starts-with(@class,'radio-button-unchecked')]"));	  
    	  List<WebElement> detalle = driver.findElements(By.xpath("//div[starts-with(@class,'flight-container')]"));	  
    	  Hacer_scroll(driver,OrdenarPrecio);
    	  if((resultados.size()==detalle.size()) && (seleccion.size()>resultados.size())) {
    		  System.out.println("total resultado: "+resultados.size()+" total detalle: "+seleccion.size()+" total resultados: "+resultados.size());
    		  return true;
    	  }
    		    	  
    	  else
    		  return false;
      }
      
       //Metodo para orden los resultados por precio y validar
      public boolean Ordenar_precio (WebDriver driver) throws InterruptedException {
     	 
    	 By preciomayor = By.xpath("//div[starts-with(@class,'recap-price-value')]");
		 List<WebElement> elementsmayor = driver.findElements(preciomayor);
		 String valormayor =elementsmayor.get(0).getText();  	 
    	 click(OrdenarPrecio);
    	 Thread.sleep(1000);
    	 By preciomenor = By.xpath("//div[starts-with(@class,'recap-price-value')]");
		 List<WebElement> elementsmenor = driver.findElements(preciomenor);
		 String valormenor = elementsmenor.get(0).getText();	
		 System.out.println("1: total mayor: "+valormayor+" total menor: "+valormenor);
		 valormayor = valormayor.substring(1);
		 valormenor = valormenor.substring(1);
		
		 
		 if (Double.parseDouble(valormenor)<Double.parseDouble(valormayor)) {
			 
   		  System.out.println("2: total mayor: "+valormayor+" total menor: "+valormenor);
          return true;
		} else {
			 return false;
		}
    	 
      }
      
     
      
      
	  

}

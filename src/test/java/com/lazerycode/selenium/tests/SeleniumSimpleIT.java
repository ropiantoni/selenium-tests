package com.lazerycode.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.lazerycode.selenium.DriverBase;

public class SeleniumSimpleIT extends DriverBase {
	
    @Test
    public void googleTitleTest() throws Exception {
    	WebDriver driver = getDriver();

        driver.navigate().to("http://www.google.com"); //navega al sitio web de google.
    
        Assert.assertTrue(driver.getTitle().contains("Google")); //chequea que el titulo sea google.
    }
    
    @Test
    public void googleSearchMilk() throws Exception {
    	WebDriver driver = getDriver();

        driver.navigate().to("http://www.google.com");
        
        WebElement searchButton = driver.findElement(By.name("btnK")); //se fija que haya un boton para search
    	WebElement textToSearch = driver.findElement(By.name("q")); //se fija que haya un lugar para ingresar texto
    	
    	textToSearch.sendKeys("Milk"); //cuando encuentra una edit box le escribe milk.
        searchButton.click(); //le hace click al boton para buscar.
        
        WebDriverWait wait = new WebDriverWait(driver, 10, 100); //cre el objeto para a que se cargue la pagina por 10 segundos, pero va a ir chequeando cada tantp para evr si se cargo.
        wait.until(d -> driver.getTitle().toLowerCase().startsWith("Milk".toLowerCase())); //espera a que se cargue y cuando se carga la pagina chequea que el titulo sea milk.
    }    
    
    @Test
    public void googleSearchMeSientoConSuerte() throws Exception {
    	WebDriver driver = getDriver();

        driver.navigate().to("http://www.google.com");
        
        WebElement searchButton = driver.findElement(By.name("btnI")); //se fija que haya un boton para search
    	WebElement textToSearch = driver.findElement(By.name("q")); //by id, y puse el id del espacio de texto insepccionando el codigo fuente de google.
    	
    	textToSearch.sendKeys("Milk"); //cuando encuentra una edit box le escribe milk.
        searchButton.click(); //le hace click al boton para buscar.
        
        WebDriverWait wait = new WebDriverWait(driver, 10, 100); //cre el objeto para a que se cargue la pagina por 10 segundos, pero va a ir chequeando cada tantp para evr si se cargo.
        wait.until(d -> driver.getTitle().toLowerCase().startsWith("Milk".toLowerCase())); //espera a que se cargue y cuando se carga la pagina chequea que el titulo sea milk.
    }    
    
    @Test
    public void googleSearchVerificarBoton() throws Exception {
    	WebDriver driver = getDriver();

        driver.navigate().to("http://www.google.com");        
        WebDriverWait wait = new WebDriverWait(driver, 10, 100); //cre el objeto para a que se cargue la pagina por 10 segundos, pero va a ir chequeando cada tantp para evr si se cargo.
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("hplogo"))); //chequea que el elemento exista
    }    
}

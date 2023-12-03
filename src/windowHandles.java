import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Work\\Calidad de Software\\Automation\\FilesDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //ChromeDriver es la clase que implementa WebDriver Interface	
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.cssSelector(".blinkingText")).click(); //Click en el link que aparece en la esquina de la pagina, el cual abre una nueva ventana en el navegador
		//getWindowHandles() devuelvetodos los Id (hasta 3) de ventanas en el navegador (parentid que es la pagina original, childid que es la pagina que se carga desde el link de la linea anterior y una subchildid en caso necesario)
		Set<String> windows = driver.getWindowHandles();
		//Extraer los valores presentes en el set collection anterior parentId and childId
		Iterator<String> it=windows.iterator();
		//Moviendome hacia la primera ventana, por defecto esoy fuera del conjunto, por tanto hay que posiciuonarse en la primera.
		String parentId = it.next();
		//Moviendome a la ventana hija, s tyviera dos hijas tendra que repetir la siguiente linea.
		String childId =it.next();
		//switchTo() es para cambiar de ventana del driver, window(childId) es para indicar en el argumento la ventana a la cual se desea cambiar 
		driver.switchTo().window(childId);
		//Extrayendo el texo rojo de la nueva pagina que contiene la direccion de email.
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		//Trabajo con cadena para extraer solo el imail del texto anterior
		String emailId=driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		//Moviendo driver desde venbtana hija a ventana principal nuevamente
		driver.switchTo().window(parentId);
		//Definiendo email en campo username de ventana principal
		driver.findElement(By.id("username")).sendKeys(emailId);
	}

}

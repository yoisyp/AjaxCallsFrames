import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment4WindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Work\\Calidad de Software\\Automation\\FilesDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //ChromeDriver es la clase que implementa WebDriver Interface	
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.linkText("Multiple Windows")).click();//Click en link "Multiple Windos" en primera pagina
		driver.findElement(By.cssSelector("a[href='/windows/new']")).click(); //CLick en "Click here" en segunda pagina
		Set<String> windows = driver.getWindowHandles(); //Capturando Id de ventanas
		Iterator<String> it=windows.iterator(); //Extraer parentId and childId
		String parentId = it.next();
		String childId =it.next();
		driver.switchTo().window(childId); //Moviendo a ventana hija
		System.out.println(driver.findElement(By.xpath("//div/h3")).getText()); //Imprimiendo texto "New Window" de la ventana hija. Tambien funciona locator //h3
		driver.switchTo().window(parentId);//Moviendo a ventana inicial
		System.out.println(driver.findElement(By.xpath("//h3")).getText());	//Imprimiendo texto "Open a New Window" de la ventana inicial.
		
	}

}
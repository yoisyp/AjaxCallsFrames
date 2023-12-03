import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Work\\Calidad de Software\\Automation\\FilesDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //ChromeDriver es la clase que implementa WebDriver Interface	
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");

		 //Creando clase Actions para manejar las acciones
		Actions a= new Actions(driver);
		//Creando variable move que contiene el web element que se le aplicara la accion click derecho del mouse.
		WebElement move=driver.findElement(By.cssSelector("a[id='nav-link-accountList']")); 
		
		//Escribiendo hello mayusculas en barra de busqueda. 
		//moveToElement se refiere al evento/accion que se realiza sobre el elemento.
		//keyDown(Keys.SHIFT)permite mantener pulsada la tecla shift para escribir la letra mayuscula
		//build significa que este listo para ejecutarse, perform significa que se ejecute.
		//doubleClick() selecciona el texto escrito en la barra de busqueda
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().perform();
		
		a.moveToElement(move).contextClick().build().perform();
	}

}

package vishal;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class screenshot {
	public static WebDriver driver;
	public static void main(String args[]) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
        // Launch the URL
 driver.get("https://www.facebook.com");
 Thread.sleep(3000);
		BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	    
		// This will store screenshot on Specific location
		
//driver.quit();
		Date d = new Date();
        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy h:mm:ss a");
	String imagedate=format.format(d);
	ImageIO.write(image, "png", new File("F:\\drivers\\CurrentScreenshot"+imagedate+".png")); 
}
}

package importing;

import java.io.File;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Resources;

public class logintest {
	private WebDriver w;
	@BeforeMethod
	public void browserlaunch(ITestContext testContext)throws URISyntaxException 
	{
		String path = null;
		String browser = testContext.getCurrentXmlTest().getParameter("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			path = new File(Resources.getResource("chromedriver.exe").getFile()).getAbsolutePath();
			System.setProperty("webdriver.chrome.driver", path);
			this.w = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			path = new File(Resources.getResource("geckodriver.exe").getFile()).getAbsolutePath();
			System.setProperty("webdriver.gecko.driver", path);
			this.w = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			path = new File(Resources.getResource("IEDriverServer.exe").getFile()).getAbsolutePath();
			System.setProperty("webdriver.ie.driver", path);
			w = new InternetExplorerDriver();
		}
		System.out.println(path);
		this.w.get("https://www.facebook.com/");
		w.manage().window().maximize();// maximizing
		w.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@Test
	public void logging()
	{
	login l=new login(this.w);
	l.loginfb("pathanhaseena758@gmail.com","hello@1234");

}
	@AfterMethod
	public void logout()
	{
		w.close();
		
	}
}

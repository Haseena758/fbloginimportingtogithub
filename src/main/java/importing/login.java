package importing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login {
	public WebDriver web;
public login(WebDriver w)
{
	this.web =w;
}
public void loginfb(String uname,String pwd)
{
	
	this.web.findElement(By.xpath("//input[@id='email']")).sendKeys(uname);
	this.web.findElement(By.xpath("//input[@id='pass']")).sendKeys(pwd);
	this.web.findElement(By.xpath("//input[@data-testid='royal_login_button']")).click();
}
}

package com.login.SDP_OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrangeHrm extends Baseclass {

	public static WebDriver driver = null;

	@BeforeTest
	public void browser_Launch() {

		driver = browserlaunch("chrome");
	}

	@BeforeClass
	@SuppressWarnings("deprecation")
	public void url_Launch() {
		getUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test
	// user name and password
	public void login() throws InterruptedException {
		Homepage h = new Homepage(driver);
		sleep();
		String name = getText(h.getUsername());

		String usernamelogin = "";
		String userpassword = "";
		System.out.println(name);
		String[] split = name.split(":");
		for (int i = 0; i < split.length; i++) {
			System.out.println(split[i]);
			if (i == 1) {

				System.out.println("**************" + split[i]);
				usernamelogin = usernamelogin + split[i].replaceAll(" ", "");
			}
		}
		System.out.println("login user name:" + usernamelogin);

		// password

		String password = getText(h.getPass());

		System.out.println("***************password::" + password);

		System.out.println(password);
		String[] split1 = password.split(":");
		for (int i = 0; i < split1.length; i++) {
			System.out.println(split1[i]);
			if (i == 1) {

				System.out.println("**************" + split1[i]);
				userpassword = userpassword + split1[i].replaceAll(" ", "");
			}
		}
		System.out.println("login password:" + userpassword);

		sleep();

		String attributename1 = getAttributePlaceHolder(h.getPlaceholdername());

		System.out.println("attributename1:" + attributename1);
		if (name.contains(attributename1)) {
			sendKey(h.getPlaceholdername(), usernamelogin);
		}

		String attributepass1 = getAttributePlaceHolder(h.getPlaceholderpass());

		System.out.println("attributepass1:" + attributepass1);

		if (password.contains(attributepass1)) {

			sendKey(h.getPlaceholderpass(), userpassword);

		}

		sleep();

		click(h.getSubmit());

	}

}

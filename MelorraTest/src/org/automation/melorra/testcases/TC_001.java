package org.automation.melorra.testcases;

import org.automation.melorra.base.DriverInstance;
import org.testng.annotations.Test;

public class TC_001 extends DriverInstance{
	
	@Test
	public void TC_001_openURL() {
		driver.get("http://www.melorra.com");
	}

}

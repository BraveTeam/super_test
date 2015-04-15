package com.epam.traning.tds_test.runner.cli.options;

import org.apache.commons.cli.Option;

import com.clioption.ICliOption;
import com.epam.traning.tds_test.runner.cli.FrameworkSettings;
import com.selenium.driver.DriverType;

public class DriverTypeOption implements ICliOption {

	public static final String DEFAULT_BROWSER_TYPE = "FIREFOX";

	@Override
	public void parse(String[] strings) {
		FrameworkSettings.getInstance().setDriverType(DriverType.valueOf(strings[0]));
	}

	@Override
	public Option getOption() {
		return new Option("dt", "driverType", true, "WebDriver type to use");
	}

	@Override
	public String[] getDefaultValue() {
		return new String[] { DEFAULT_BROWSER_TYPE };
	}

}

package com.epam.traning.tds_test.runner.cli.options;

import org.apache.commons.cli.Option;
import com.clioption.ICliOption;

public class DriverTypeOption implements ICliOption {

	public static final String DEFAULT_BROWSER_TYPE = "FIREFOX";

	public void parse(String[] strings) {
		FrameworkSettings.getInstance().setDriverType(DriverType.valueOf(strings[0]));
	}

	public Option getOption() {
		return new Option("dt", "driverType", true, "WebDriver type to use");
	}

	public String[] getDefaultValue() {
		return new String[] { DEFAULT_BROWSER_TYPE };
	}

}

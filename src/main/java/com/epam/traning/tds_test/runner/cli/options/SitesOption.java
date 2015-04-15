package com.epam.traning.tds_test.runner.cli.options;

import org.apache.commons.cli.Option;

import com.clioption.ICliOption;
import com.epam.traning.tds_test.runner.cli.FrameworkSettings;
import com.epam.traning.tds_test.runner.cli.SiteOptions;

public class SitesOption implements ICliOption {
	public static final String DEFAULT_SITE = SiteOptions.ALL.getOption();

	public String[] getDefaultValue() {
		return new String[] { DEFAULT_SITE };
	}

	public Option getOption() {
		return new Option("site", "site", true, "Sites for testing");
	}

	public void parse(String[] values) {
		FrameworkSettings.getInstance().setSites(SiteOptions.valueOf(values[0]));
	}
}
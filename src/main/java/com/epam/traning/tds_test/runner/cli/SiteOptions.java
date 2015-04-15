package com.epam.traning.tds_test.runner.cli;

public enum SiteOptions {

	AFTERELLEN("AFTERELLEN"), MIDNIGHT("MIDNIGHT"), TDS("TDS"), ALL("ALL"), STANDUP("STANDUP"), TCR("TCR"), SPIKE("SPIKE"), CC("CC");

	private String option;

	private SiteOptions(String option) {
		this.option = option;
	}

	public String getOption() {
		return option;
	}
}

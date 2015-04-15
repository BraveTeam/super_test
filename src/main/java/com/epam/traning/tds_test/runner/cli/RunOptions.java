package com.epam.traning.tds_test.runner.cli;

public enum RunOptions {

	REMOTE("REMOTE"), LOCAL("LOCAL"), GRID("GRID"), IPAD("IPAD"), ANDROID("ANDROID");

	private String option;

	private RunOptions(String option) {
		this.option = option;
	}

	public String getOption() {
		return option;
	}
}
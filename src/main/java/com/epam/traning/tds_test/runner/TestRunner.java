package com.epam.traning.tds_test.runner;

import java.util.ArrayList;
import java.util.List;

import com.clioption.CliParser;
import com.morning.common.runner.cli.options.DriverTypeOption;
import com.runner.Runner;

public class TestRunner extends Runner{

	/**
	 * @param args
	 */
	
	public TestRunner(String[] args) {
		super(args);
	}
	
	public void addCommandLineOptions() {
		CliParser.getCmdLineOptions().add(new DriverTypeOption());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

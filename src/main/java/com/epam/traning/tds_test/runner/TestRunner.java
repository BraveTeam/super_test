package com.epam.traning.tds_test.runner;

import com.clioption.CliParser;
import com.epam.traning.tds_test.runner.cli.options.DriverTypeOption;
import com.runner.Runner;

public class TestRunner extends Runner{


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

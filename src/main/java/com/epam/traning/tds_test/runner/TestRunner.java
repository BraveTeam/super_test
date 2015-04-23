package com.epam.traning.tds_test.runner;

import com.clioption.CliParser;
import com.epam.traning.tds_test.runner.cli.options.DriverTypeOption;
import com.runner.Runner;

import java.util.ArrayList;
import java.util.List;

public class TestRunner extends Runner {

	public TestRunner(String[] args) {
		super(args);

		@SuppressWarnings("rawtypes")
		List<Class> listeners = new ArrayList<Class>();
		listeners.add(SuiteListener.class);
		setListeners(listeners);
	}

	public void addCommandLineOptions() {
		super.addCommandLineOptions();
		CliParser.getCmdLineOptions().add(new DriverTypeOption());
	}

	public static void main(String[] args) {

		Runner tr = new TestRunner(args);
		tr.run();
	}
}

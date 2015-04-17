package com.epam.traning.tds_test.runner;

import java.util.ArrayList;
import java.util.List;

import com.clioption.CliParser;
import com.epam.traning.tds_test.runner.cli.options.DriverTypeOption;
import com.runner.Runner;

public class TestRunner extends Runner {

    public TestRunner(String[] args) {
	super(args);

	@SuppressWarnings("rawtypes")
	List<Class> listeners = new ArrayList<Class>();
	listeners.add(SuiteListener.class);
	// setListeners(listeners);
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

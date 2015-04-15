package com.epam.traning.tds_test.runner;

import org.apache.commons.cli.ParseException;
import org.apache.log4j.Logger;

import com.clioption.CliParser;
import com.epam.traning.tds_test.runner.cli.options.DriverTypeOption;
import com.epam.traning.tds_test.runner.cli.options.SitesOption;
import com.runner.Runner;
import com.selenium.driver.DriverManager;

public class TestRunner extends Runner{

	public TestRunner(String[] args) {
		super(args);
		
	}

	private static Logger LOGGER = Logger.getLogger(CliParser.class);
	
	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) {
		try {
			Runner tr = new TestRunner(args);
			tr.run();
		} catch (Exception e) {
			LOGGER.fatal(e.getMessage(), e);
		} finally {
			DriverManager.quitAll();

			int exitCode = BuildResult.getExitResult();
			LOGGER.info("Exit with code : " + exitCode);
			System.exit(exitCode);
		}
	}
	
	public void addCommandLineOptions() {
		super.addCommandLineOptions();
		CliParser.getCmdLineOptions().add(new SitesOption());
		CliParser.getCmdLineOptions().add(new DriverTypeOption());
	}
	


}

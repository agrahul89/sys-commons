package domain.brandname.syscode.commons.configurator;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

public final class Log4jConfigurator extends LoggerConfigurator {

	private long rescanDelay;

	public Log4jConfigurator() {
		this(null);
	}

	public Log4jConfigurator(String logConfigPath) {
		this(logConfigPath, DEFAULT_RELOAD_MS);
	}

	public Log4jConfigurator(String logConfigPath, long rescanDelay) {
		super(logConfigPath);
		this.rescanDelay = rescanDelay;
	}

	@Override
	protected void configureLogger(final String config) {
		if (FilenameUtils.isExtension(config.toUpperCase(), CONFIG_TYP.PROPERTIES.name())) {
			System.out.println("Property Configuration :: " + config);
			PropertyConfigurator.configureAndWatch(config, rescanDelay);
		} else if (FilenameUtils.isExtension(config.toUpperCase(), CONFIG_TYP.XML.name())) {
			System.out.println("XML Configuration :: " + config);
			DOMConfigurator.configureAndWatch(config, rescanDelay);
		} else {
			System.out.println("Falling back to basic Log4j Configuration");
			BasicConfigurator.configure();
		}
	}

	@Override
	protected CONFIG_TYP[] getSupportedConfigurationTypes() {
		return new CONFIG_TYP[] { CONFIG_TYP.PROPERTIES, CONFIG_TYP.XML };
	}

}

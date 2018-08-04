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
		switch (CONFIG_TYP.valueOf(FilenameUtils.getExtension(config).toUpperCase())) {
		case PROPERTIES:
			System.out.println("Property Configuration :: " + config);
			PropertyConfigurator.configureAndWatch(config, this.rescanDelay);
			break;
		case XML:
			System.out.println("XML Configuration :: " + config);
			DOMConfigurator.configureAndWatch(config, this.rescanDelay);
			break;
		default:
			System.out.println("Falling back to basic Log4j Configuration");
			BasicConfigurator.configure();
			break;
		}
		System.out.println("Setup Monitoring interval to " + this.rescanDelay + "ms");
	}

	@Override
	protected CONFIG_TYP[] getSupportedConfigurationTypes() {
		return new CONFIG_TYP[] { CONFIG_TYP.PROPERTIES, CONFIG_TYP.XML };
	}

}

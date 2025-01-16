package io.github.agrahul89.commons.configurator;

import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configurator;

public final class Log4j2Configurator extends LoggerConfigurator {

	private long rescanDelay;

	public Log4j2Configurator() {
		this(null);
	}

	public Log4j2Configurator(String logConfigPath) {
		this(logConfigPath, 180000);
	}

	public Log4j2Configurator(String logConfigPath, long rescanDelay) {
		super(logConfigPath);
		this.rescanDelay = rescanDelay;
	}

	@Override
	public void configureLogger(final String config) {
		System.out.println("Configuring Logger :: " + config);
		final LoggerContext context = Configurator.initialize("log4j2Config", config);
		if (context.getConfiguration().getWatchManager().getIntervalSeconds() <= 0) {
			System.out.println("Setup Monitoring interval to " + rescanDelay + "ms");
			int rescanDelayInSeconds = Long.valueOf(rescanDelay / 1000).intValue();
			context.getConfiguration().getWatchManager().setIntervalSeconds(rescanDelayInSeconds);
		}
	}

	@Override
	protected CONFIG_TYP[] getSupportedConfigurationTypes() {
		return new CONFIG_TYP[] { CONFIG_TYP.PROPERTIES, CONFIG_TYP.YAML, CONFIG_TYP.JSON, CONFIG_TYP.XML };
	}

}

package domain.brandname.syscode.commons.configurator;

import java.io.File;

import org.apache.commons.configuration.AbstractConfiguration;
import org.apache.commons.configuration.CombinedConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.EnvironmentConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import domain.brandname.syscode.commons.utilities.PropertyReader;

public final class PropertyFileConfigurator implements Configurator {
	private static final Logger LOGGER = Logger.getLogger(PropertyFileConfigurator.class);
	private final String filePath;
	private final long refreshDelay;

	public PropertyFileConfigurator() {
		this(null);
	}

	public PropertyFileConfigurator(final String filePath) {
		this(filePath, DEFAULT_RELOAD_MS);
	}

	public PropertyFileConfigurator(final String filePath, long refreshDelay) {
		this.filePath = new String(filePath == null ? "" : filePath);
		this.refreshDelay = refreshDelay;
	}

	@Override
	public void configure() {
		CombinedConfiguration configuration = new CombinedConfiguration();
		configuration.addConfiguration(getPropertyConfiguration());
		configuration.addConfiguration(getEnvironmentConfiguration());
		PropertyReader.setConfiguration(configuration);
	}

	private AbstractConfiguration getEnvironmentConfiguration() {
		return (AbstractConfiguration) new EnvironmentConfiguration().interpolatedConfiguration();
	}

	private AbstractConfiguration getPropertyConfiguration() {
		LOGGER.info("Initializing Property File Configuration");
		LOGGER.info("Property File Path :: " + filePath);
		File configPropFile = FileUtils.getFile(filePath);
		PropertiesConfiguration propertiesConfiguration = null;
		try {
			propertiesConfiguration = new PropertiesConfiguration(configPropFile);
			propertiesConfiguration.setAutoSave(true);
			FileChangedReloadingStrategy fileUpdateStrategy = new FileChangedReloadingStrategy();
			fileUpdateStrategy.setRefreshDelay(refreshDelay);
			propertiesConfiguration.setReloadingStrategy(fileUpdateStrategy);
			LOGGER.info("Property File Configuration was Successful");
		} catch (final ConfigurationException ex) {
			LOGGER.error("Failed to configure Properties File", ex);
		}
		return propertiesConfiguration;
	}

}

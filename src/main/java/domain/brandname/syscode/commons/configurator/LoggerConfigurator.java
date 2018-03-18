package domain.brandname.syscode.commons.configurator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

public abstract class LoggerConfigurator implements Configurator {

	private String logConfigPath;
	private CONFIG_TYP[] supportedConfigurations;

	public LoggerConfigurator(String logConfigPath) {
		this.logConfigPath = logConfigPath == null ? "" : new String(logConfigPath);
		CONFIG_TYP[] supportedConfigs = getSupportedConfigurationTypes();
		this.supportedConfigurations = ArrayUtils.isEmpty(supportedConfigs) ? new CONFIG_TYP[] {} : supportedConfigs;
	}

	@Override
	public void configure() {
		System.out.println("Logger Configuration Initialized");
		String[] supportedConfigs = getSupportedConfigurationNames();
		if (StringUtils.isBlank(logConfigPath)) {
			System.out.println("No Logger Configuration file was provided");
			System.out.println("Provide absolute path to Logger Configuration file in Constructor(logConfigPath)");
			System.out.println("Supported Configuration file types are :: " + Arrays.toString(supportedConfigs));
		} else if (!FilenameUtils.isExtension(logConfigPath.toUpperCase(), supportedConfigs)) {
			System.out.println("Unsupported Configuration File. Supported Configuration file types are :: "
					+ Arrays.toString(supportedConfigs));
		} else {
			configureLogger(logConfigPath);
		}
		System.out.println("Logger Configuration Completed");
	}

	String[] getSupportedConfigurationNames() {
		List<String> output = new ArrayList<>(supportedConfigurations.length);
		Arrays.stream(supportedConfigurations).forEach(config -> output.add(config.name()));
		return output.toArray(new String[output.size()]);
	}

	protected abstract void configureLogger(final String config);

	protected abstract CONFIG_TYP[] getSupportedConfigurationTypes();

}

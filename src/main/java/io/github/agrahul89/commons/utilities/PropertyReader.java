package io.github.agrahul89.commons.utilities;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import io.github.agrahul89.commons.constant.Constants;

public class PropertyReader {
	private static final Logger LOGGER = Logger.getLogger(PropertyReader.class);
	private static Configuration properties = null;

	private PropertyReader() {
		super();
	}

	public static String[] asArray(final String key) {
		String[] values = {};
		if (properties != null) {
			values = properties.getStringArray(key);
		}
		return values;
	}

	public static char asChar(final String key) {
		String temp = get(key);
		char propValue = StringUtils.isEmpty(temp) ? '\0' : temp.charAt(0);
		LOGGER.debug("Key: " + key + ", Value: " + propValue);
		return propValue;
	}

	public static int asInt(final String key) {
		int propValue = 0;
		if (properties != null) {
			propValue = properties.getInt(key);
		}
		LOGGER.debug("Key: " + key + ", Value: " + propValue);
		return propValue;
	}

	public static List<String> asList(final String key) {
		List<Object> temp = properties == null ? Collections.emptyList() : properties.getList(key);
		temp.removeAll(Collections.singleton(null));
		List<String> propValues = new LinkedList<String>();
		for (Object value : temp) {
			propValues.add(String.valueOf(value));
		}
		return Collections.unmodifiableList(propValues);
	}

	public static Map<String, String> asMap(final String key) {
		Map<String, String> values = new LinkedHashMap<String, String>();
		String value = get(key);
		String[] keyValuePairs = {};
		if (StringUtils.isNotBlank(value) && value.charAt(0) == Constants.BRACE_OPEN
				&& value.endsWith(Constants.BRACE_CLOSE.toString())) {
			// Get Value without '{' , '}' & Whitespaces
			String temp = StringUtils.substring(value, 1, value.length() - 1);
			keyValuePairs = StringUtils.split(StringUtils.trimToEmpty(temp), Constants.SEMICOLON);
		} else {
			LOGGER.error("Invalid Map Value in Properties File for Key :: " + key);
		}
		if (keyValuePairs.length > 0) {
			for (String keyValuePair : keyValuePairs) {
				String[] keyValue = StringUtils.split(keyValuePair, Constants.EQUALS);
				if (keyValue.length == 2) {
					values.put(StringUtils.trimToEmpty(keyValue[0]), StringUtils.trimToEmpty(keyValue[1]));
				} else {
					LOGGER.error("Ignored Invalid KeyValue :: " + keyValue);
				}
			}
		}
		return values;
	}

	public static String get(final String key) {
		String propValue = StringUtils.EMPTY;
		if (properties != null) {
			propValue = StringUtils.trimToEmpty(properties.getString(key));
		}
		LOGGER.debug("Key: " + key + ", Value: " + propValue);
		return propValue;
	}

	public static void setConfiguration(final Configuration configuration) {
		PropertyReader.properties = configuration;
	}
}

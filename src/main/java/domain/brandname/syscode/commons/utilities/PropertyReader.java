package domain.brandname.syscode.commons.utilities;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;

import domain.brandname.syscode.commons.constant.Constants;

public class PropertyReader {
	private static final Logger LOGGER = Logger.getLogger(PropertyReader.class);
	private static Configuration properties = null;

	private PropertyReader() {
		super();
	}

	public static String[] asArray(final String key) {
		return properties == null ? new String[] {} : properties.getStringArray(key);
	}

	public static char asChar(final String key) {
		String value = get(key);
		return StringUtils.isEmpty(value) ? '\0' : value.charAt(0);
	}

	public static int asInt(final String key) {
		return properties == null ? 0 : properties.getInt(key);
	}

	public static List<String> asList(final String key) {
		List<String> output = new LinkedList<String>();
		List<Object> temp = properties == null ? Collections.emptyList() : properties.getList(key);
		CommonUtility.removeNull(temp).forEach(value -> output.add(String.valueOf(value)));
		return Collections.unmodifiableList(output);
	}

	public static Map<String, String> asMap(final String key) {
		Map<String, String> values = new LinkedHashMap<String, String>();
		String value = get(key);
		String[] keyValuePairs = {};
		if (StringUtils.isBlank(value)) {
			LOGGER.error("Invalid Map in Properties File for Key :: " + key);
		} else {
			value = StringUtils.replace(value, Constants.BRACE_OPEN.toString(), StringUtils.EMPTY);
			value = StringUtils.replace(value, Constants.BRACE_CLOSE.toString(), StringUtils.EMPTY);
			keyValuePairs = StringUtils.split(StringUtils.trimToEmpty(value), Constants.SEMICOLON);
		}
		if (ArrayUtils.isNotEmpty(keyValuePairs)) {
			for (String keyValuePair : keyValuePairs) {
				String[] keyValue = StringUtils.split(keyValuePair, Constants.EQUALS);
				if (ArrayUtils.isNotEmpty(keyValue) && keyValue.length == 2) {
					values.put(StringUtils.trimToEmpty(keyValue[0]), StringUtils.trimToEmpty(keyValue[1]));
				} else {
					LOGGER.error("Invalid Key-value ignored :: " + keyValue);
				}
			}
		}
		return Collections.unmodifiableMap(values);
	}

	public static Number asNumber(final String key) {
		String value = get(key);
		return NumberUtils.isNumber(value) ? NumberUtils.createNumber(value) : 0;
	}

	public static String get(final String key) {
		return properties == null ? StringUtils.EMPTY
				: StringUtils.trimToEmpty(properties.getString(key, StringUtils.EMPTY));
	}

	public static void setConfiguration(final Configuration configuration) {
		PropertyReader.properties = configuration;
	}
}

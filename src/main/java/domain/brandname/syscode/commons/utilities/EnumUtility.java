package domain.brandname.syscode.commons.utilities;

import org.apache.commons.lang.StringUtils;

public final class EnumUtility {

	private EnumUtility() {
		super();
	}

	public static <T extends Enum<T>> T getEnum(Class<T> enumType, char value) {
		return getEnum(enumType, String.valueOf(value));
	}

	public static <T extends Enum<T>> T getEnum(Class<T> enumType, CharSequence value) {
		T output = null;
		if (enumType != null) {
			String inputValue = String.valueOf(value);
			for (T enumConst : enumType.getEnumConstants()) {
				String enumConstName = enumConst == null ? null : enumConst.name();
				String enumConstValue = enumConst == null ? null : enumConst.toString();
				if (StringUtils.equalsIgnoreCase(enumConstName, inputValue)
						|| StringUtils.equalsIgnoreCase(enumConstValue, inputValue)) {
					output = enumConst;
					break;
				}
			}
		}
		return output;
	}

	public static <T extends Enum<T>> T getEnumFromString(Class<T> enumType, Number value) {
		return getEnum(enumType, String.valueOf(value));
	}

}

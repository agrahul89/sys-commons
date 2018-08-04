package domain.brandname.syscode.commons.utilities;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;

public final class CommonUtility {

	private CommonUtility() {
		super();
	}

	@SafeVarargs
	public static <T extends Object> Collection<T> remove(Collection<T> collection, T... itemsToRemove) {
		Collection<T> output = null;
		if (itemsToRemove == null) {
			output = removeNull(collection);
		} else {
			output = remove(collection, Arrays.asList(itemsToRemove));
		}
		return output;
	}

	public static Collection<String> removeBlank(Collection<String> collection) {
		Collection<String> output = removeNull(collection);
		output = removeEmpty(collection);
		return output;
	}

	public static Collection<String> removeEmpty(Collection<String> collection) {
		Collection<String> remove = Collections.singleton(StringUtils.EMPTY);
		return collection == null ? null : CollectionUtils.removeAll(collection, remove);
	}

	public static <T> Collection<T> removeNull(Collection<T> collection) {
		Collection<String> remove = Collections.singleton(null);
		return collection == null ? null : CollectionUtils.removeAll(collection, remove);
	}

	private static <T extends Object> Collection<T> remove(Collection<T> collection, Iterable<T> itemsToRemove) {
		Collection<T> output = null;
		for (T itemToRemove : itemsToRemove) {
			output = remove(collection, itemToRemove);
		}
		return output;
	}

	private static <T> Collection<T> remove(Collection<T> collection, T itemToRemove) {
		Collection<T> remove = Collections.singleton(itemToRemove);
		return collection == null ? null : CollectionUtils.removeAll(collection, remove);
	}
}

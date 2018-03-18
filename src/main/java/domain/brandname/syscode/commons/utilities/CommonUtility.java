package domain.brandname.syscode.commons.utilities;

import java.util.Collection;
import java.util.Collections;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;

public final class CommonUtility {

	private CommonUtility() {
		super();
	}

	@SuppressWarnings("unchecked")
	public static <T> Collection<T> remove(Collection<T> collection, T... itemsToRemove) {
		Collection<T> output = collection == null ? null : collection;
		if (itemsToRemove == null) {
			output = removeNull(output);
		} else {
			for (T itemToRemove : itemsToRemove) {
				output = remove(output, itemToRemove);
			}
		}
		return output;
	}

	public static Collection<String> removeBlank(Collection<String> collection) {
		return removeEmpty(removeNull(collection));
	}

	public static Collection<String> removeEmpty(Collection<String> collection) {
		Collection<String> remove = Collections.singleton(StringUtils.EMPTY);
		return collection == null ? null : CollectionUtils.removeAll(collection, remove);
	}

	public static <T> Collection<T> removeNull(Collection<T> collection) {
		Collection<String> remove = Collections.singleton(null);
		return collection == null ? null : CollectionUtils.removeAll(collection, remove);
	}

	private static <T> Collection<T> remove(Collection<T> collection, T itemToRemove) {
		Collection<T> remove = Collections.singleton(itemToRemove);
		return collection == null ? null : CollectionUtils.removeAll(collection, remove);
	}
}

package domain.brandname.syscode.commons.utilities;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

@PrepareForTest({ CommonUtility.class })
public class CommonUtilityTest {

	private Collection<String> input;

	@Before
	public void prepareInput() {
		input = new ArrayList<>();
		input.add("this");
		input.add("is");
		input.add("one");
		input.add("test");
		input.add("that");
		input.add("contains");
		input.add("");
		input.add("and");
		input.add(null);
	}

	@Test
	public void removeBlankTestShouldPass() {
		Collection<String> output = CommonUtility.removeBlank(input);
		assertThat(output, not(hasItems(null, "")));

		System.out.println("removeBlankTestShouldPass :: input{" + input + "}, output{" + output + "}");
	}

	@Test
	public void removeEmptyTestShouldPass() {
		Collection<String> output = CommonUtility.removeEmpty(input);
		assertThat(output, not(hasItem("")));

		System.out.println("removeEmptyTestShouldPass :: input{" + input + "}, output{" + output + "}");
	}

	@Test
	public void removeNullTestShouldPass() {
		Collection<String> output = CommonUtility.removeBlank(input);
		assertThat(output, not(hasItem("")));

		System.out.println("removeNullTestShouldPass :: input{" + input + "}, output{" + output + "}");
	}

	@Test
	public void removeTestForEmptyCollectionShouldPass() {
		Collection<String> input = Collections.emptyList();
		Collection<String> output = CommonUtility.remove(input, "non-existing-value");
		assertEquals(Collections.EMPTY_LIST, output);

		System.out.println("removeTestForEmptyCollectionShouldPass :: input{" + input + "}, output{" + output + "}");
	}

	@Test
	public void removeTestForNonEmptyCollectionShouldPass() {
		Collection<String> output = CommonUtility.remove(input, "one");
		assertThat(output, not(hasItem("one")));

		System.out.println("removeTestForNonEmptyCollectionShouldPass :: input{" + input + "}, output{" + output + "}");
	}

	@Test
	public void removeTestForNullCollectionShouldPass() {
		Collection<String> input = null;
		Collection<String> output = CommonUtility.remove(input, "non-existing-value");
		assertNull(output);

		System.out.println("removeTestForNullCollectionShouldPass :: input{" + input + "}, output{" + output + "}");
	}

	@Test
	public void removeTestRemoveMultiple() {
		Collection<String> output = CommonUtility.remove(input, "", null);
		assertThat(output, not(hasItems(null, "")));

		System.out.println("removeTestRemoveMultiple :: input{" + input + "}, output{" + output + "}");
	}

}

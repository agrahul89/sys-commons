package domain.brandname.syscode.commons;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import domain.brandname.syscode.commons.utilities.CommonUtilityTest;
import domain.brandname.syscode.commons.utilities.DateTimeUtilityTest;

@RunWith(Suite.class)
@SuiteClasses({ CommonUtilityTest.class, DateTimeUtilityTest.class })
public class AppTestSuite {
	// A top Level jUnit testSuite. Normally it is to remain empty.
	// In case suite needs to be executed by a runner, see example below

	// public static void main(String[] args) {
	// Class<?>[] classes = new Class[0];
	// Result result = JUnitCore.runClasses(classes);
	// for (Failure failure : result.getFailures()) {
	// System.err.println(failure.toString());
	// }
	// System.out.println(result.wasSuccessful());
	// }
}

package domain.brandname.syscode.commons.utilities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

public class DateTimeUtilityTest {

	private long firstDayOfMonth;
	private long lastDayOfMonth;

	@Test
	public void firstDayOfMonthTest() {
		assertEquals(firstDayOfMonth, DateTimeUtility.firstDayOfMonth());
		assertThat(DateTimeUtility.firstDayOfMonthAsCalendar(), CoreMatchers.instanceOf(Calendar.class));
		assertThat(DateTimeUtility.firstDayOfMonthAsDate(), CoreMatchers.instanceOf(Date.class));
		assertThat(DateTimeUtility.firstDayOfMonthAsSqlDate(), CoreMatchers.instanceOf(java.sql.Date.class));
		assertThat(DateTimeUtility.firstDayOfMonthAsTimestamp(), CoreMatchers.instanceOf(Timestamp.class));
	}

	@Test
	public void lastDayOfMonthTest() {
		assertEquals(lastDayOfMonth, DateTimeUtility.lastDayOfMonth());
		assertThat(DateTimeUtility.lastDayOfMonthAsCalendar(), CoreMatchers.instanceOf(Calendar.class));
		assertThat(DateTimeUtility.lastDayOfMonthAsDate(), CoreMatchers.instanceOf(Date.class));
		assertThat(DateTimeUtility.lastDayOfMonthAsSqlDate(), CoreMatchers.instanceOf(java.sql.Date.class));
		assertThat(DateTimeUtility.lastDayOfMonthAsTimestamp(), CoreMatchers.instanceOf(Timestamp.class));
	}

	@Before
	public void prepare() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("d-M-yyyy");
		dateFormat.setLenient(false);

		Calendar calendar = Calendar.getInstance();
		firstDayOfMonth = dateFormat
				.parse("01-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.YEAR)).getTime();

		lastDayOfMonth = dateFormat.parse(calendar.getActualMaximum(Calendar.DAY_OF_MONTH) + "-"
				+ (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.YEAR)).getTime();
	}
}

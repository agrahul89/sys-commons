package domain.brandname.syscode.commons.utilities;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public final class DateTimeUtility {

	private static final Logger LOGGER = LogManager.getLogger(DateTimeUtility.class);

	private DateTimeUtility() {
		super();
	}

	public static Calendar asCalendar(final int dayOfMonth) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		return truncToDays(calendar);
	}

	public static Date asDate(final int dayOfMonth) {
		return asCalendar(dayOfMonth).getTime();
	}

	public static long asLong(final int dayOfMonth) {
		return asDate(dayOfMonth).getTime();
	}

	public static java.sql.Date asSqlDate(final int dayOfMonth) {
		return new java.sql.Date(asLong(dayOfMonth));
	}

	public static Timestamp asTimestamp(final int dayOfMonth) {
		return new Timestamp(asLong(dayOfMonth));
	}

	public static long firstDayOfMonth() {
		return firstDayOfMonthAsDate().getTime();
	}

	public static Calendar firstDayOfMonthAsCalendar() {
		return truncToMonths(Calendar.getInstance());
	}

	public static Date firstDayOfMonthAsDate() {
		return firstDayOfMonthAsCalendar().getTime();
	}

	public static java.sql.Date firstDayOfMonthAsSqlDate() {
		return new java.sql.Date(firstDayOfMonth());
	}

	public static Timestamp firstDayOfMonthAsTimestamp() {
		return new Timestamp(firstDayOfMonth());
	}

	public static final String format(Calendar calendar, final String format, TimeZone timezone) {
		return calendar == null ? StringUtils.EMPTY : format(calendar.getTime(), format, timezone);
	}

	public static final String format(Date date, final String format, TimeZone timezone) {
		return date == null ? StringUtils.EMPTY : format(date.getTime(), format, timezone);
	}

	public static final String format(long millis, final String format, TimeZone timezone) {
		return DateFormatUtils.format(millis, format, timezone);
	}

	public static final String formatInLocal(Calendar calendar, final String format) {
		return format(calendar, format, TimeZone.getDefault());
	}

	public static final String formatInLocal(Date date, final String format) {
		return format(date, format, TimeZone.getDefault());
	}

	public static final String formatInLocal(long millis, final String format) {
		return format(millis, format, TimeZone.getDefault());
	}

	public static final String formatInUtc(Calendar calendar, final String format) {
		return format(calendar, format, DateUtils.UTC_TIME_ZONE);
	}

	public static final String formatInUtc(Date date, final String format) {
		return format(date, format, DateUtils.UTC_TIME_ZONE);
	}

	public static final String formatInUtc(long millis, final String format) {
		return format(millis, format, DateUtils.UTC_TIME_ZONE);
	}

	public static long lastDayOfMonth() {
		return lastDayOfMonthAsDate().getTime();
	}

	public static Calendar lastDayOfMonthAsCalendar() {
		Calendar calendar = Calendar.getInstance();
		int lastDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, lastDayOfMonth);
		return truncToDays(calendar);
	}

	public static Date lastDayOfMonthAsDate() {
		return lastDayOfMonthAsCalendar().getTime();
	}

	public static java.sql.Date lastDayOfMonthAsSqlDate() {
		return new java.sql.Date(lastDayOfMonth());
	}

	public static Timestamp lastDayOfMonthAsTimestamp() {
		return new Timestamp(lastDayOfMonth());
	}

	public static long parse(final String value, String... format) {
		Date date = parseToDate(value, format);
		return date == null ? 0 : date.getTime();
	}

	public static Calendar parseToCalendar(final String value, String... format) {
		Date date = parseToDate(value, format);
		return date == null ? null : DateUtils.toCalendar(date);
	}

	public static Date parseToDate(final String value, String... format) {
		Date output = null;
		try {
			output = DateUtils.parseDateStrictly(value, format);
		} catch (final ParseException ex) {
			LOGGER.error(ex.getMessage());
			LOGGER.debug(ex.getMessage(), ex);
		}
		return output;
	}

	public static java.sql.Date parseToSqlDate(final String value, String... format) {
		Date date = parseToDate(value, format);
		return date == null ? null : new java.sql.Date(date.getTime());
	}

	public static Timestamp parseToTimestamp(final String value, String... format) {
		Date date = parseToDate(value, format);
		return date == null ? null : new Timestamp(date.getTime());
	}

	public static Calendar truncToDays(Calendar calendar) {
		return calendar == null ? calendar : DateUtils.truncate(calendar, Calendar.DATE);
	}

	public static Date truncToDays(Date date) {
		return date == null ? date : DateUtils.truncate(date, Calendar.DATE);
	}

	public static Calendar truncToHours(Calendar calendar) {
		return calendar == null ? calendar : DateUtils.truncate(calendar, Calendar.HOUR);
	}

	public static Date truncToHours(Date date) {
		return date == null ? date : DateUtils.truncate(date, Calendar.HOUR);
	}

	public static Calendar truncToMins(Calendar calendar) {
		return calendar == null ? calendar : DateUtils.truncate(calendar, Calendar.MINUTE);
	}

	public static Date truncToMins(Date date) {
		return date == null ? date : DateUtils.truncate(date, Calendar.MINUTE);
	}

	public static Calendar truncToMonths(Calendar calendar) {
		return calendar == null ? calendar : DateUtils.truncate(calendar, Calendar.MONTH);
	}

	public static Date truncToMonths(Date date) {
		return date == null ? date : DateUtils.truncate(date, Calendar.MONTH);
	}

}

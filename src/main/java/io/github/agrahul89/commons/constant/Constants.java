package io.github.agrahul89.commons.constant;

import org.apache.commons.lang.StringUtils;

public abstract class Constants {

	public static final String _ENV = System.getProperty("ENV");
	public static final String _ENV_LOWER = StringUtils.lowerCase(_ENV);
	public static final String _ENV_UPPER = StringUtils.upperCase(_ENV);
	public static final Character AMPERSAND = '&';
	public static final Character APOSTROPHE = '\'';
	public static final Character ASTERIX = '*';
	public static final Character AT = '@';
	public static final Character BACKSLASH = '\\';
	public static final Character BANG = '!';
	public static final Character BRACE_CLOSE = '}';
	public static final Character BRACE_OPEN = '{';
	public static final Character BRACKET_CLOSE = ']';
	public static final Character BRACKET_OPEN = '[';
	public static final Character CARET = '^';
	public static final Character COLON = ':';
	public static final Character COMMA = ',';
	public static final Character DASH = '\u2013';
	public static final Character DOLLAR = '$';
	public static final Character DOT = '.';
	public static final Number EIGHT = 8;
	public static final Number EIGHTEEN = 18;
	public static final Number EIGHTY = 80;
	public static final Number ELEVEN = 11;
	public static final Character EQUALS = '=';
	public static final Number FIFTEEN = 15;
	public static final Number FIFTY = 50;
	public static final Number FIVE = 5;
	public static final Number FOUR = 4;
	public static final Number FOURTEEN = 14;
	public static final Number FOURTY = 40;
	public static final Character HASH = '#';
	public static final Number HUNDRED = 100;
	public static final Character HYPHEN = '\u2010';
	public static final Character MINUS = '\u2212';
	public static final Number NINE = 9;
	public static final Number NINETEEN = 19;
	public static final Number NINETY = 90;
	public static final Number ONE = 1;
	public static final Character PARENTHESIS_CLOSE = ')';
	public static final Character PARENTHESIS_OPEN = '(';
	public static final Character PERCENT = '%';
	public static final Character PIPE = '|';
	public static final Character PLUS = '+';
	public static final Character QUESTION = '?';
	public static final Character QUOTE = '"';
	public static final Character SEMICOLON = ';';
	public static final Number SEVEN = 7;
	public static final Number SEVENTEEN = 17;
	public static final Number SEVENTY = 70;
	public static final Number SIX = 6;
	public static final Number SIXTEEN = 16;
	public static final Number SIXTY = 60;
	public static final Character SLASH = '/';
	public static final Character SPACE = ' ';
	public static final Number TEN = 10;
	public static final Number THIRTEEN = 13;
	public static final Number THIRTY = 30;
	public static final Number THOUSAND = 1000;
	public static final Number THREE = 3;
	public static final Character TILDE = '~';
	public static final Number TWELVE = 12;
	public static final Number TWENTY = 20;
	public static final Number TWO = 2;
	public static final Character UNDERSCORE = '_';
	public static final Number ZERO = 0;

	/**
	 * public static final Number MILLION = pow(THOUSAND, TWO); public static
	 * final Number BILLION = mul(THOUSAND, MILLION); public static final Number
	 * TRILLION = mul(THOUSAND, BILLION); public static final Number QUADRILLION
	 * = mul(THOUSAND, TRILLION); public static final Number QUINTILLION =
	 * mul(THOUSAND, QUADRILLION); public static final Number SEXTILLION =
	 * mul(THOUSAND, QUINTILLION); public static final Number SEPTILLION =
	 * mul(THOUSAND, SEXTILLION); public static final Number OCTILLION =
	 * mul(THOUSAND, SEPTILLION); public static final Number NONILLION =
	 * mul(THOUSAND, OCTILLION);
	 *
	 * public static final Number DECILLION = mul(THOUSAND, NONILLION); public
	 * static final Number UNDECILLION = mul(THOUSAND, DECILLION); public static
	 * final Number DUODECILLION = mul(MILLION, DECILLION); public static final
	 * Number TREDECILLION = mul(TRILLION, DECILLION); public static final
	 * Number QUATTTUORDECILLION = mul(QUADRILLION, DECILLION); public static
	 * final Number QUINDECILLION = mul(QUINTILLION, DECILLION); public static
	 * final Number SEXDECILLION = mul(SEXTILLION, DECILLION); public static
	 * final Number SEPTENDECILLION = mul(SEPTILLION, DECILLION); public static
	 * final Number OCTODECILLION = mul(OCTILLION, DECILLION); public static
	 * final Number NOVEMDECILLION = mul(NONILLION, DECILLION);
	 *
	 * public static final Number VIGINTILLION = pow(THOUSAND, add(TWENTY,
	 * ONE)); public static final Number CENTILLION = pow(THOUSAND, add(HUNDRED,
	 * ONE));
	 *
	 * public static final Number GOOGOL = mul(TEN, pow(THOUSAND, add(THIRTY,
	 * THREE))); public static final Number GOOGOLPLEX = pow(TEN, GOOGOL);
	 *
	 * private static Number add(Number...numbers) { Number output = 0;
	 * for(Number number : numbers) { output = Math.addExact(output.longValue(),
	 * number.longValue()); } return output; }
	 *
	 * private static Number mul(Number...numbers) { Number output = 1;
	 * for(Number number : numbers) { output =
	 * Math.multiplyExact(output.longValue(), number.longValue()); } return
	 * output; }
	 *
	 * private static Number pow(Number number, Number pow) { return
	 * Math.pow(number.doubleValue(), pow.doubleValue()); }
	 */
	private Constants() {
		super();
	}
}

/**
 * 
 */
package com.johnredy.arual.util;

/**
 * Constants used for gathering.
 * 
 * @author Pablo
 * 
 */
public final class GathererConstants {

    /**
     * Hidden constructor.
     */
    private GathererConstants() {
	super();
    }

    /** Yahoo finance yql api url. */
    public static final String YAHOO_FINANCE_YQL_API_URL = "https://query.yahooapis.com/v1/public/yql";
    /** Query parameter name. */
    public static final String YAHOO_FINANCE_QUERY_PARAMETER_NAME = "q";
    /** Additional parameters. */
    public static final String YAHOO_FINANCE_ADITIONAL_QUERY_PARAMETERS = "diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";

    /** Historical data table. */
    public final static String HISTORICAL_DATA_TABLE = "yahoo.finance.historicaldata";
    /** Xml response quote tag name */
    public static final String QUOTE_TAG_NAME = "quote";
    /** Xml response Closing price tag name */
    public static final String CLOSE_TAG_NAME = "Close";
    /** Xml response date tag name */
    public static final String DATE_TAG_NAME = "Date";
    /** Xml response Opening price tag name */
    public static final String OPEN_TAG_NAME = "Open";
    /** Xml response Highest price tag name */
    public static final String HIGH_TAG_NAME = "High";
    /** Xml response Lowest price tag name */
    public static final String LOW_TAG_NAME = "Low";
    /** Xml response volume tag name */
    public static final String VOLUME_TAG_NAME = "Volume";
    /** Xml response adjusted close tag name */
    public static final String ADJUSTED_CLOSE_TAG_NAME = "Adj_Close";
    /** Xml response symbol attribute name */
    public static final String SYMBOL_ATTRIBUTE_NAME = "Symbol";
    /** Date format pattern in xml. */
    public static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd";
    /** Url encoding charset. */
    public static final String URL_ENCODING_CHARSET = "ASCII";

}

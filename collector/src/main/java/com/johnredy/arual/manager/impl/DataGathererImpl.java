/**
 * 
 */
package com.johnredy.arual.manager.impl;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.johnredy.arual.manager.IDataGatherer;
import com.johnredy.arual.model.Annotation;
import com.johnredy.arual.util.GathererConstants;
import com.johnredy.arual.util.YahooFinanceQuoteHandler;

/**
 * Request financial data.
 * 
 * @author Pablo
 * 
 */
public class DataGathererImpl implements IDataGatherer {
    /*
     * (non-Javadoc)
     * 
     * @see
     * com.johnredy.arual.manager.IDataGatherer#obtainFinancialDataDaily(java
     * .util.Set, java.util.Date, java.util.Date)
     */
    @Override
    public Map<String, Map<Date, Annotation>> obtainFinancialDataDaily(
	    final Set<String> symbols, final Date fromDate, final Date toDate)
	    throws ParserConfigurationException, SAXException, IOException {
	Map<String, Map<Date, Annotation>> resultMap = null;
	String yqlSentence = buildYqlSentence(symbols, fromDate, toDate);

	String uri = GathererConstants.YAHOO_FINANCE_YQL_API_URL
		+ "?"
		+ GathererConstants.YAHOO_FINANCE_QUERY_PARAMETER_NAME
		+ "="
		+ URLEncoder.encode(yqlSentence,
			GathererConstants.URL_ENCODING_CHARSET) + "&"
		+ GathererConstants.YAHOO_FINANCE_ADITIONAL_QUERY_PARAMETERS;
	SAXParserFactory parserFactor = SAXParserFactory.newInstance();

	URL url = new URL(uri);
	SAXParser parser = parserFactor.newSAXParser();
	YahooFinanceQuoteHandler handler = new YahooFinanceQuoteHandler();
	parser.parse(new InputSource(url.openStream()), handler);

	resultMap = new TreeMap<String, Map<Date, Annotation>>();
	// Printing the list of employees obtained from XML

	for (Annotation quote : handler.getQuotesList()) {
	    // System.out.println(quote);
	    if (resultMap.get(quote.getSymbol()) == null) {
		Map<Date, Annotation> annotationsMap = new TreeMap<Date, Annotation>();
		resultMap.put(quote.getSymbol(), annotationsMap);
	    }
	    resultMap.get(quote.getSymbol()).put(quote.getDate(), quote);
	}

	return resultMap;
    }

    /**
     * Build a yql sentence using the supplied parameters.
     * 
     * @param symbols
     *            set of symbols.
     * @param startDate
     *            start date.
     * @param endDate
     *            end date.
     * @return yql sentence.
     */
    private String buildYqlSentence(final Set<String> symbols,
	    final Date startDate, final Date endDate) {
	SimpleDateFormat formatoDeFecha = new SimpleDateFormat(
		GathererConstants.DATE_FORMAT_PATTERN);
	String sentence = "";
	String symbolsListString = "";
	Iterator<String> it = symbols.iterator();
	while (it.hasNext()) {
	    symbolsListString += "'" + it.next() + "'";
	    if (it.hasNext()) {
		symbolsListString += ", ";
	    }
	}
	sentence = "select * from " + GathererConstants.HISTORICAL_DATA_TABLE
		+ " where " + "symbol in (" + symbolsListString + ") ";
	if (startDate != null) {
	    sentence += "and startDate = " + "'"
		    + formatoDeFecha.format(startDate) + "' ";
	}
	if (endDate != null) {
	    sentence += "and endDate = " + "'" + formatoDeFecha.format(endDate)
		    + "' ";
	}
	return sentence;
    }
}
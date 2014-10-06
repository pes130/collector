package com.johnredy.arual.manager;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.johnredy.arual.model.Annotation;

/**
 * Methods to access quotes data.
 * 
 * @author Pablo
 * 
 */
public interface IDataGatherer {
    /**
     * Get data for a symbol from a given date.
     * 
     * @param symbols
     *            set of symbol to query.
     * @param fromDate
     *            start date.
     * @param toDate
     *            end date.
     * @return map indexed by symbos with quotes for symbols indexed by date.
     * @throws UnsupportedEncodingException
     * @throws MalformedURLException
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    Map<String, Map<Date, Annotation>> obtainFinancialDataDaily(
	    Set<String> symbols, Date fromDate, Date toDate)
	    throws UnsupportedEncodingException, MalformedURLException,
	    ParserConfigurationException, SAXException, IOException;

}

/**
 * 
 */
package com.johnredy.arual.test.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.johnredy.arual.manager.IDataGatherer;
import com.johnredy.arual.manager.impl.DataGathererImpl;
import com.johnredy.arual.model.Annotation;

/**
 * Tests over DataGatherer.
 * 
 * @author Pablo
 * 
 */
public class DataGathererImplTest {
    /** year to make tests. */
    private static final int TEST_YEAR = 2014;
    /** first day in month for tests. */
    private static final int TEST_FIRST_DAY_IN_MONTH = 1;
    /** last day in month for tests. */
    private static final int TEST_LAST_DAY_IN_MONTH = 30;

    /**
     * General purpose test over IDataGatherer results.
     * 
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     * @throws MalformedURLException
     * @throws UnsupportedEncodingException
     */
    @Test
    public void testingDataGatherer() throws UnsupportedEncodingException,
	    MalformedURLException, ParserConfigurationException, SAXException,
	    IOException {
	IDataGatherer dataGatherer = new DataGathererImpl();

	Set<String> symbols = new HashSet<String>();
	Map<String, Map<Date, Annotation>> result = null;
	symbols.add("AXP");
	symbols.add("BA");
	Calendar startDate = Calendar.getInstance();
	startDate.set(Calendar.MONTH, Calendar.JANUARY);
	startDate.set(Calendar.DAY_OF_MONTH, TEST_FIRST_DAY_IN_MONTH);
	startDate.set(Calendar.YEAR, TEST_YEAR);
	Calendar endDate = Calendar.getInstance();

	endDate.set(Calendar.MONTH, Calendar.JANUARY);
	endDate.set(Calendar.DAY_OF_MONTH, TEST_LAST_DAY_IN_MONTH);
	endDate.set(Calendar.YEAR, TEST_YEAR);
	result = dataGatherer.obtainFinancialDataDaily(symbols,
		startDate.getTime(), endDate.getTime());
	assertNotNull(result);
	/* Quotes for 2 symbols. */
	assertEquals(result.size(), 2);

	/* Results for BMW are not null. */
	assertNotNull(result.get("AXP"));
    }

    /**
     * With this test, we want to check that yesterday result is obtained,
     * whenever yesterday was not saturday or sunday.
     * 
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     * @throws MalformedURLException
     * @throws UnsupportedEncodingException
     */
    @Test
    public void checkLastDayResult() throws UnsupportedEncodingException,
	    MalformedURLException, ParserConfigurationException, SAXException,
	    IOException {
	IDataGatherer dataGatherer = new DataGathererImpl();
	Calendar startDate = Calendar.getInstance();
	Calendar endDate = Calendar.getInstance();
	while ((endDate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
		|| (endDate.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)) {
	    endDate.add(Calendar.DAY_OF_YEAR, -1);
	}
	startDate.set(Calendar.DAY_OF_YEAR, endDate.get(Calendar.DAY_OF_YEAR));
	startDate.add(Calendar.DAY_OF_YEAR, -5);
	Set<String> symbols = new HashSet<String>();
	Map<String, Map<Date, Annotation>> result = null;
	symbols.add("AXP");
	result = dataGatherer.obtainFinancialDataDaily(symbols,
		startDate.getTime(), endDate.getTime());

	Calendar dateToCheck = Calendar.getInstance();
	dateToCheck.add(Calendar.DAY_OF_YEAR, -1);
	while ((dateToCheck.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
		|| (dateToCheck.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)) {
	    dateToCheck.add(Calendar.DAY_OF_YEAR, -1);
	}
	List<Annotation> quotesList = new ArrayList<Annotation>(result.get(
		"AXP").values());
	System.out.println("--->"
		+ quotesList.get(quotesList.size() - 1).getDate());
	System.out.println("--->" + dateToCheck.getTime());
	Calendar auxDate = Calendar.getInstance();
	auxDate.setTime(quotesList.get(quotesList.size() - 1).getDate());
	assertEquals(auxDate.get(Calendar.DAY_OF_YEAR),
		dateToCheck.get(Calendar.DAY_OF_YEAR));

    }
}

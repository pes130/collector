package com.johnredy.arual.manager;

import java.util.Date;
import java.util.Map;

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
     * @param symbol
     *            symbol to query.
     * @param fromDate
     *            start date.
     * @return quotes for symbols indexed by date.
     */
    Map<Date, Annotation> obtainFinancialDataDaily(String symbol, Date fromDate);

}

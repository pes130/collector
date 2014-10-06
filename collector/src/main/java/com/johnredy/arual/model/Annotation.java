/**
 * 
 */
package com.johnredy.arual.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Pojo that represents a quote value for certain date.
 * 
 * @author Pablo
 * 
 */
public class Annotation implements Serializable {
    /** Serial version id. */
    private static final long serialVersionUID = 1L;
    /** Symbol id */
    private String symbol;
    /** Registering date. */
    private Date date;
    /** Opening price. */
    private Double open;
    /** Highest price of the day. */
    private Double high;
    /** Lowest price if the day. */
    private Double low;
    /** Closing price. */
    private Double close;
    /** Volume. */
    private Double volume;
    /** Adjusted closing price. */
    private Double adjustedClose;

    /**
     * Get the date value.
     * 
     * @return the date
     */
    public Date getDate() {
	return date;
    }

    /**
     * Get the symbol value.
     * 
     * @return the symbol
     */
    public String getSymbol() {
	return symbol;
    }

    /**
     * Set a new value for the symbol.
     * 
     * @param symbol
     *            the symbol to set
     */
    public void setSymbol(final String symbol) {
	this.symbol = symbol;
    }

    /**
     * Set a new value for the date.
     * 
     * @param date
     *            the date to set
     */
    public void setDate(final Date date) {
	this.date = date;
    }

    /**
     * Get the opening price.
     * 
     * @return the open
     */
    public Double getOpen() {
	return open;
    }

    /**
     * Set a new value for the opening price.
     * 
     * @param open
     *            the open to set
     */
    public void setOpen(final Double open) {
	this.open = open;
    }

    /**
     * Get the highest price.
     * 
     * @return the high
     */
    public Double getHigh() {
	return high;
    }

    /**
     * Set a new value for the highest price.
     * 
     * @param high
     *            the high to set
     */
    public void setHigh(final Double high) {
	this.high = high;
    }

    /**
     * Get the lowest price.
     * 
     * @return the low
     */
    public Double getLow() {
	return low;
    }

    /**
     * Set a new value for the lowest price.
     * 
     * @param low
     *            the low to set
     */
    public void setLow(final Double low) {
	this.low = low;
    }

    /**
     * Get the closing price.
     * 
     * @return the close
     */
    public Double getClose() {
	return close;
    }

    /**
     * Set a new value for the closing price.
     * 
     * @param close
     *            the close to set
     */
    public void setClose(final Double close) {
	this.close = close;
    }

    /**
     * Get the volume.
     * 
     * @return the volume
     */
    public Double getVolume() {
	return volume;
    }

    /**
     * Set a new value for the volume.
     * 
     * @param volume
     *            the volume to set
     */
    public void setVolume(final Double volume) {
	this.volume = volume;
    }

    /**
     * Get the adjusted closing price.
     * 
     * @return the adjustedClose
     */
    public Double getAdjustedClose() {
	return adjustedClose;
    }

    /**
     * Set a new value for the adjusted closing price.
     * 
     * @param adjustedClose
     *            the adjustedClose to set
     */
    public void setAdjustedClose(final Double adjustedClose) {
	this.adjustedClose = adjustedClose;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = (prime * result)
		+ ((adjustedClose == null) ? 0 : adjustedClose.hashCode());
	result = (prime * result) + ((close == null) ? 0 : close.hashCode());
	result = (prime * result) + ((date == null) ? 0 : date.hashCode());
	result = (prime * result) + ((high == null) ? 0 : high.hashCode());
	result = (prime * result) + ((low == null) ? 0 : low.hashCode());
	result = (prime * result) + ((open == null) ? 0 : open.hashCode());
	result = (prime * result) + ((symbol == null) ? 0 : symbol.hashCode());
	result = (prime * result) + ((volume == null) ? 0 : volume.hashCode());
	return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	Annotation other = (Annotation) obj;
	if (adjustedClose == null) {
	    if (other.adjustedClose != null) {
		return false;
	    }
	} else if (!adjustedClose.equals(other.adjustedClose)) {
	    return false;
	}
	if (close == null) {
	    if (other.close != null) {
		return false;
	    }
	} else if (!close.equals(other.close)) {
	    return false;
	}
	if (date == null) {
	    if (other.date != null) {
		return false;
	    }
	} else if (!date.equals(other.date)) {
	    return false;
	}
	if (high == null) {
	    if (other.high != null) {
		return false;
	    }
	} else if (!high.equals(other.high)) {
	    return false;
	}
	if (low == null) {
	    if (other.low != null) {
		return false;
	    }
	} else if (!low.equals(other.low)) {
	    return false;
	}
	if (open == null) {
	    if (other.open != null) {
		return false;
	    }
	} else if (!open.equals(other.open)) {
	    return false;
	}
	if (symbol == null) {
	    if (other.symbol != null) {
		return false;
	    }
	} else if (!symbol.equals(other.symbol)) {
	    return false;
	}
	if (volume == null) {
	    if (other.volume != null) {
		return false;
	    }
	} else if (!volume.equals(other.volume)) {
	    return false;
	}
	return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Annotation [symbol=" + symbol + ", date=" + date + ", open="
		+ open + ", high=" + high + ", low=" + low + ", close=" + close
		+ ", volume=" + volume + ", adjustedClose=" + adjustedClose
		+ "]";
    }

}

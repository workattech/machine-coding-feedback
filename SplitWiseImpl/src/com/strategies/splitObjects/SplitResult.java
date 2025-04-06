package com.strategies.splitObjects;

import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * The Class SplitResult.
 */
public class SplitResult {
	
	/** The owed by. */
	HashMap<String, HashMap<String, Double>> owedBy;
	
	/** The owed to. */
	HashMap<String, HashMap<String, Double>> owedTo;
	
	/** The owed map. */
	HashMap<String, Double> owedMap;
	
	/** The owes map. */
	HashMap<String, Double> owesMap;
	
	

	/**
	 * Instantiates a new split result.
	 */
	public SplitResult() {
		super();
		this.owedBy = new HashMap<String, HashMap<String,Double>>();
		this.owedTo = new HashMap<String, HashMap<String,Double>>();
		this.owedMap = new HashMap<String, Double>();
		this.owesMap = new HashMap<String, Double>();
	}

	/**
	 * Instantiates a new split result.
	 *
	 * @param owedBy the owed by
	 * @param owedTo the owed to
	 * @param owedMap the owed map
	 * @param owesMap the owes map
	 */
	public SplitResult(HashMap<String, HashMap<String, Double>> owedBy, HashMap<String, HashMap<String, Double>> owedTo,
			HashMap<String, Double> owedMap, HashMap<String, Double> owesMap) {
		super();
		this.owedBy = owedBy;
		this.owedTo = owedTo;
		this.owedMap = owedMap;
		this.owesMap = owesMap;
	}

	/**
	 * Gets the owed by.
	 *
	 * @return the owed by
	 */
	public HashMap<String, HashMap<String, Double>> getOwedBy() {
		return owedBy;
	}
	
	/**
	 * Gets the owed to.
	 *
	 * @return the owed to
	 */
	public HashMap<String, HashMap<String, Double>> getOwedTo() {
		return owedTo;
	}
}

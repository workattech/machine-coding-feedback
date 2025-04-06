package com.strategies.splitObjects;

import java.util.List;

import com.strategies.interfaces.ISplitInput;

// TODO: Auto-generated Javadoc
/**
 * The Class SplitInput.
 */
public abstract class SplitInput implements ISplitInput {
	
	/**
	 * Instantiates a new split input.
	 *
	 * @param paidBy the paid by
	 * @param participants the participants
	 * @param paidAmount the paid amount
	 */
	public SplitInput(String paidBy, List<String> participants, double paidAmount) {
		super();
		this.paidBy = paidBy;
		this.participants = participants;
		this.paidAmount = paidAmount;
	}

	/** The paid by. */
	private String paidBy;
	
	/** The participants. */
	private List<String> participants;
	
	/** The paid amount. */
	private double paidAmount;
	
	

	/**
	 * Gets the paid by.
	 *
	 * @return the paid by
	 */
	public String getPaidBy() {
		return paidBy;
	}

	/**
	 * Gets the paid amount.
	 *
	 * @return the paid amount
	 */
	public double getPaidAmount() {
		return paidAmount;
	}

	/**
	 * Sets the paid amount.
	 *
	 * @param paidAmount the new paid amount
	 */
	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	/**
	 * Sets the paid by.
	 *
	 * @param paidBy the new paid by
	 */
	public void setPaidBy(String paidBy) {
		this.paidBy = paidBy;
	}

	/**
	 * Gets the participants.
	 *
	 * @return the participants
	 */
	public List<String> getParticipants() {
		return participants;
	}

	/**
	 * Sets the participants.
	 *
	 * @param participants the new participants
	 */
	public void setParticipants(List<String> participants) {
		this.participants = participants;
	}
	
	
}

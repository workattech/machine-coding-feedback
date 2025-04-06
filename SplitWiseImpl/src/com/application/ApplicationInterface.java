package com.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.enums.InputCommand;
import com.enums.SplitStrategyType;
import com.factory.interfaces.IDataStoreFactory;
import com.factory.interfaces.IStrategyListFactory;
import com.interfaces.IApplication;
import com.interfaces.IApplicationInterface;
import com.ioParser.interfaces.IInputReader;
import com.ioParser.interfaces.IResultFormatter;
import com.strategies.splitObjects.SplitResult;
import com.user.UserDetails;

// TODO: Auto-generated Javadoc
/**
 * The Class ApplicationInterface.
 */
public class ApplicationInterface implements IApplicationInterface {
	
	/** The application. */
	private IApplication application;
	
	
	/** The data store factory. */
	private IDataStoreFactory dataStoreFactory;
	
	/** The strategy list factory. */
	private IStrategyListFactory strategyListFactory;
	
	/** The result formatter. */
	private IResultFormatter resultFormatter;
	
	/** The input reader. */
	private IInputReader inputReader;
	
	
	/**
	 * Instantiates a new application interface.
	 *
	 * @param dataStoreFactory the data store factory
	 * @param strategyListFactory the strategy list factory
	 * @param resultFormatter the result formatter
	 * @param inputReader the input reader
	 */
	public ApplicationInterface(IDataStoreFactory dataStoreFactory, IStrategyListFactory strategyListFactory,
			IResultFormatter resultFormatter, IInputReader inputReader) {
		super();
		this.dataStoreFactory = dataStoreFactory;
		this.strategyListFactory = strategyListFactory;
		this.resultFormatter = resultFormatter;
		this.inputReader = inputReader;
	}

	/**
	 * Instantiate application.
	 */
	@Override
	public void instantiateApplication() {
		this.application = new Application(dataStoreFactory, strategyListFactory, Arrays.asList((String) SplitStrategyType.EQUAL.name(),(String) SplitStrategyType.EXACT.name(), (String)SplitStrategyType.PERCENT.name()));
		
	}

	/**
	 * Run input string.
	 *
	 * @param input the input
	 * @return the list
	 */
	@Override
	public List<String> runInputString(String input) {
		String[] inputArr = input.split(" ");
		
		List<String> inputList = new ArrayList<String>();
		
		int i = 1;
		
		while (i < inputArr.length) {
			inputList.add(inputArr[i]);
			
			i++;
		}
		
		if (InputCommand.EXPENSE == InputCommand.valueOf(inputArr[0])) {
			this.application.addExpense(this.inputReader.parseInput(inputList));
			
			return Arrays.asList();
		}
		
		if (InputCommand.SHOW == InputCommand.valueOf(inputArr[0])) {
			SplitResult splitResult;
			if (inputList.size() == 0) {
				splitResult = this.application.getAllBalances();
			} else {
				splitResult = this.application.getBalanceForUser(inputList.get(0));
			}
			
//			System.out.println("result" + splitResult.getOwedBy() + " " + splitResult.getOwedTo());
			
			return this.resultFormatter.getFormattedResult(splitResult, this.dataStoreFactory.getUserDataStore());
			
		}
		
		return new ArrayList<String>();
		
	}

	/**
	 * Adds the new user.
	 *
	 * @param userDetails the user details
	 * @return true, if successful
	 */
	@Override
	public boolean addNewUser(UserDetails userDetails) {
		return this.dataStoreFactory.getUserDataStore().addNewUser(userDetails);
	}
	
	

}

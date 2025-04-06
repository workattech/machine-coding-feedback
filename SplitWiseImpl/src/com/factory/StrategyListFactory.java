package com.factory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.enums.SplitStrategyType;
import com.factory.interfaces.IStrategyListFactory;
import com.interfaces.IStrategyList;
import com.strategies.equalDivisionStrategy.EqualDivisionSplitStrategy;
import com.strategies.exactDivisionStrategy.ExactDivisionSplitStrategy;
import com.strategies.interfaces.ISplitStrategy;
import com.strategies.percentDivisionStrategy.PercentDivisionSplitStrategy;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating StrategyList objects.
 */
public class StrategyListFactory implements IStrategyListFactory {
	
	/**
	 * Instantiates a new strategy list factory.
	 */
	public StrategyListFactory() {
		this.strategyMap.put(SplitStrategyType.EXACT, new ExactDivisionSplitStrategy());
		this.strategyMap.put(SplitStrategyType.EQUAL, new EqualDivisionSplitStrategy());
		this.strategyMap.put(SplitStrategyType.PERCENT, new PercentDivisionSplitStrategy());
	}



	/** The strategy map. */
	private HashMap<SplitStrategyType, ISplitStrategy> strategyMap = new HashMap<SplitStrategyType, ISplitStrategy>();
	
	

	/**
	 * Gets the strategy list.
	 *
	 * @param strategiesPresent the strategies present
	 * @return the strategy list
	 */
	@Override
	
	public IStrategyList getStrategyList(List<String> strategiesPresent) {
		Map<SplitStrategyType, ISplitStrategy> result = new LinkedHashMap<SplitStrategyType, ISplitStrategy>();
		
		Iterator<String> it = strategiesPresent.listIterator();
		
		while (it.hasNext()) {
			SplitStrategyType next = SplitStrategyType.valueOf(it.next());
			
			if (this.strategyMap.containsKey(next)) {
				result.put(next, this.strategyMap.get(next));
			}
		}
		
		return new IStrategyList() {
			
			@Override
			public Map<SplitStrategyType, ISplitStrategy> getSplitStrategies() {
				// TODO Auto-generated method stub
				return result;
			}
		};
	}

}

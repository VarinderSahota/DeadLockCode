package com.practice.codility.problems;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Weights {
	
	public static int lastStoneWeight(List<Integer> weights) {
	    // Write your code here
		int weight = 0;
		List<Integer> givenWeights = new CopyOnWriteArrayList<Integer>(weights);
	    if(givenWeights.size() == 0)
	    	return weight;
	    
	    if(givenWeights.size() == 1)
	    	return givenWeights.get(0);
	    			
	    			
		while(givenWeights.size() >= 2)
	    {
	    	Integer max1 = Collections.max(givenWeights);
	    	givenWeights.remove(max1);
	    	Integer max2 = Collections.max(givenWeights);
	    	givenWeights.remove(max2);
	    	
	    	if(max1 != max2)
	    	{
	    		weight = Math.abs(max1 - max2);
	    		givenWeights.add(weight);
	    	}
	    	else
	    	{
	    		weight = 0;
	    	}
	    }

	return weight;    
	}

	public static void main(String[] args) {
		

	}

}

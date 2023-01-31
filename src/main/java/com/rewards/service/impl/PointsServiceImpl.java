package com.rewards.service.impl;

import org.springframework.stereotype.Service;

import com.rewards.service.PointsService;

@Service
public class PointsServiceImpl implements PointsService{

    /**
	 * Function to calculate Points based on amount transaction performed for
	 */
    public Integer calculatePoints(Integer amount){
        int points = 0;
		if(amount>100){
			points += (amount-100)*2;
		} 
		if (amount > 50){
			int amountMinus50 = amount - 50;
			//if amount goes beyond 50$ then max points we get for the chunk is 50
			if(amountMinus50> 50){
				points += 50;
			} else { //just use the rest as points since it is indirectly equal to 1 point per 1$
				points += amountMinus50;
			}
		}
		return points;
    }
}
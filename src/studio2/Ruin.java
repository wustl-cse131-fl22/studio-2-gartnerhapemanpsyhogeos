package studio2;

import java.util.Scanner;

public class Ruin 
{

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter an amount of money: ");
		int startAmount = in.nextInt();
		int money = startAmount;
		
		System.out.println("Enter win chance: ");
		double winChance = in.nextDouble();
		
		System.out.println("Enter a win limit: ");
		double winLimit = in.nextDouble();
		
		System.out.println("Enter how many days you want to simulate: ");
		int totalSimulations = in.nextInt();
		
	
		int days = 0;
		int wins = 0;
		int losses = 0;
		
		
	while (days < totalSimulations)
	{
		int count = 0;
		money = startAmount;
		while (money > 0 && money < winLimit) //one day
		{
			if (Math.random() <= winChance)
				{
					money ++;
					
				}
				else 
				{
					money --;
					
					
				}
			count ++;
		}
		days ++;
		System.out.println("You played " + count + " rounds on day number " + days + " today. Cool.");
		if (money == 0)
			{
			System.out.println("LOSER HAHA :)");
			losses ++;
			}
		else
			{
			System.out.println("Day ends in victory");
			wins ++;
			
			
		}
		
	
	}
	double ruinRate = (double) losses / (losses + wins);
	double expectedRuin;
	if (winChance == 0.5)
		{
		expectedRuin = 1 - (startAmount/winLimit);
		}
	else
	{
			double alpha = (1 - winChance) / winChance;
			expectedRuin = (Math.pow(alpha, startAmount) - Math.pow(alpha, winLimit))/(1 - Math.pow(alpha, winLimit));
	}
	System.out.println("Expected ruin rate: " + expectedRuin);
	System.out.println("Actual ruin rate: " + ruinRate);
	
	
	
	
	}
}



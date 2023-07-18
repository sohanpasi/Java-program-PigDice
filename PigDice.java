package com.techlabs.reflection;

import java.util.Random;
import java.util.Scanner;

public class PigDice {
	
	public static void print(int currTurnScore, int prevTurnScore)
	{
		int totalScore=(currTurnScore+prevTurnScore);
		System.out.println("Score for turn: "+currTurnScore);
		System.out.println("Total score: "+totalScore);
	}
	
	public static void rollDice(Scanner scanner) 
	{
		int turn=1, min=1, max=6;
		int currTurnScore=0, prevTurnScore=0, die=0;
		char ch;
		
		while(true) 
		{
			System.out.print("Roll or hold? (r/h): ");
			ch = scanner.next().charAt(0);
			
			if(ch=='r')
			{
				Random random = new Random(); 
				die = random.nextInt(max-min+1)+min;
				System.out.println("Die: "+die);
				
				if(die>1)
				{
					currTurnScore = currTurnScore+die;
				}
				if(die==1)
				{
					turn++;
					currTurnScore=0;
					prevTurnScore=0;
					System.out.println("Turn over. No score.\n\nTURN "+turn);
				}
				if((currTurnScore+prevTurnScore)>=20)
				{
					print(currTurnScore, prevTurnScore);
					System.out.println("\n\nYou finished in "+turn+" turns!");
					System.out.println("\n\nGame over");
					return;
				}
			}
			if(ch=='h')
			{
				turn++;
				print(currTurnScore, prevTurnScore);
				prevTurnScore = prevTurnScore+currTurnScore;
				currTurnScore=0;
				System.out.println("\nTURN "+turn);
			}
		}
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("TURN 1");
		rollDice(scanner);
	}
}

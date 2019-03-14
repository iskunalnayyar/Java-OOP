//package com.first.java;
/*
 * TrollsNCookies.java
 *
 * Versions
 * 		11/05/2017
 *
 * Revisions
 * 		9.2
 */

import java.util.Random;
import java.util.Scanner;


class Game extends Thread
{
	static int sleeptime;

	Game(String s)
	{
		super(s);
		int min = 2000;
		int max = 5000;
		Random random = new Random();
		sleeptime = random.nextInt(max - min + 1) + min;
	}

	public synchronized void run()
	/**
	 * Trolls are initialized here
	 * using threads.
	 */
	{
		try
		{
			System.out.println(" Troll ::" + getName());
			Thread.sleep(sleeptime);
		} catch (Exception e)
		{
			System.out.println();
		}
		setBoard();
	}

	public void setBoard()
	/**
	 * Starts the game, by initializing cookies
	 * by using helper functions
	 */
	{
		for (int j = 0; j < TrollsNCookies.numOfTrolls; j++)
		{
			TrollsNCookies.cookie(TrollsNCookies.numOfTrolls - j, j);
			try
			{
				Thread.sleep(sleeptime);
			} catch (Exception e)
			{
				System.out.println();
			}
			TrollsNCookies.eat();
			try
			{
				Thread.sleep(10000);
			} catch (Exception e)
			{
				System.out.println();
			}
		}
	}
}


public class TrollsNCookies
		/**
		 * Main game class
		 */
{
	static int numOfTrolls;
	static int cookies;
	static TrollsNCookies T = new TrollsNCookies();

	public static void main(String[] args) throws InterruptedException
	{
		/**
		 * Main function, takes user input,
		 * and starts the game for valid input.
		 */
		Scanner Sc = new Scanner(System.in);
		do {
			System.out.println("Enter the number of trolls to start play:");

			while (!Sc.hasNextInt()) {
				System.out.println("Enter positive integers only!");
				Sc.next(); // this is important!
			}
			numOfTrolls = Sc.nextInt();
		} while (numOfTrolls <= 0);
		refresh();
		System.out.println("The Master of Ceremonies will hit the anvil with a hammer in ::" + " " + Game.sleeptime + "milliseconds");
		System.out.println("---Trolls grab a cookie !  :::--->>>");
	}


	public static void refresh()
	/**
	 * Starts threads as per troll count
	 */
	{
		Thread[] threads = new Thread[numOfTrolls];
		for (int i = 0; i < numOfTrolls; i++)
		{
			threads[i] = new Game("Thread #" + i);
			threads[i].start();
		}
	}

	public static void cookie(int n, int j)
	/**
	 * Calculates number of cookies
	 * to be one less than number of trolls
	 */
	{
		int x = 0;
		x = n;
		cookies = x - 1;
		//if (j == 0) {
		//	System.out.println("The number of cookies in this game now is -->" + cookies);
		//}

		System.out.println("Cookies in this game now is -->" + cookies);
	}

	public synchronized static int eat()
	/**
	 * Simulates cookies that are eaten by trolls,
	 * updates its count in the game
	 */

	{
		boolean check = true;

		if (cookies != 0 && check)
		{
			System.out.println("Cookie consumed by Troll :: " + Thread.currentThread().getName());
			cookies = cookies - 1;

			if ((cookies) == 0)
			{
				check = false;
			}

			System.out.println("Cookie/s left : " + cookies);
			return cookies;
		}

		if (cookies == 0 && check)
		{
			return eatCheck();
		} else
		{
			return 0;
		}
	}

	public synchronized static int eatCheck()
	/**
	 * Simulates game for troll left with no cookie
	 */
	{
		String hungryTroll = Thread.currentThread().getName();
		System.out.println("There is no cookie left for Troll::" + " " + Thread.currentThread().getName() + "------------");
		if (hungryTroll == Thread.currentThread().getName())
		{
			try
			{
				Thread.currentThread().join(1000);

			} catch (InterruptedException i)
			{
				System.out.println();
			}
			//System.out.println("Status of Thread :" + Thread.currentThread().getName() + " " + "is" + " " + Thread.currentThread().isAlive());
		}
		return 0;
	}
}


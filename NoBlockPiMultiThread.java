package com.first.java;

/*
 * NoBlockPiMultithread.java
 *
 * Versions
 * 		10/28/2017
 *
 * Revisions
 * 		8.2
 */

import java.io.*;
import java.util.Scanner;

/**
 * NoBlockPiMultithread class will read the files and determine the even and odds
 * based on the multi threads
 *
 * @author Kunal Nayyar
 *
 */

public class NoBlockPiMultiThread extends Thread
{
	private static BufferedReader bufferedReader;
	private static BufferedReader reader;
	private static String nextLine = null;
	private int startIndex;
	private int endIndex;
	private static char[] piArray;
	private double even = 0, odd = 1;
	//private static BufferedWriter bw;
	//private static String writeWish;


	public NoBlockPiMultiThread(int startIndex, int endIndex)
	{
		/**
		 * Constructor class will set the start and end values of the different thread
		 * object
		 * @param startIndex
		 * @param endIndex
		 * */

		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}

	public void run()
	{
		/**
		 * Override run method will be called based on the thread scheduler to determine
		 * even or odds in the file
		 */

		for (int index = startIndex; index <= endIndex; index++)
		{
			if (piArray[index] % 2 == 0)
			{
				even++;
			} else if (piArray[index] % 2 != 0)
			{
				odd++;
			}
		}
	}


	private double getEven()
	{
		return this.even;
	}

	private double getOdd()
	{
		return this.odd;
	}

	/**
	 * This is the main method class
	 *
	 * @param args
	 * @throws InterruptedException
	 */
	public static synchronized void main(String[] args) throws InterruptedException
	{
		NoBlockingIO no = new NoBlockingIO();
		long startTime = System.currentTimeMillis();
		synchronized (no)
		{
			try
			{
				Scanner Sc = new Scanner(System.in);
				System.out.println("Do you wish to write to the file Y/N :");
				//writeWish = Sc.next();
				//reader = new BufferedReader(new FileReader(new File("src/com/first/java/data.txt")), 128);
				//bufferedReader = no.NoBlocking(reader);

				//if (writeWish.equals("Y"))
				//{
				//Thread.currentThread().interrupt();
				//	bw = new BufferedWriter(new FileWriter(new File("src/com/first/java/data.txt"), true));
				//	no.NoBlocking(bw);

				reader = new BufferedReader(new FileReader(new File("src/com/first/java/data.txt")), 128);
				bufferedReader = no.NoBlocking(reader);
				//} else
				//{
				reader = new BufferedReader(new FileReader(new File("src/com/first/java/data.txt")), 128);
				bufferedReader = no.NoBlocking(reader);
				//}

				while ((nextLine = (bufferedReader.readLine())) != null)
				{
					piArray = nextLine.toCharArray();
				}
			} catch (IOException | NullPointerException e)
			{
				e.printStackTrace();
			}
		}

		int length = piArray.length;
		NoBlockPiMultiThread t0 = new NoBlockPiMultiThread(2, (length - 1));

		// start all the threads at the same time to run as multi threads
		t0.start();

		// Waiting for all the threads to finish the job
		t0.join();

		// Getting even and odd counts for all the thread objects
		double totalEvenCount = t0.getEven();
		double totalOddCount = t0.getOdd();
		System.out.println("even = " + (int) totalEvenCount);
		System.out.println("odd = " + (int) totalOddCount);

		double result = totalOddCount / totalEvenCount;

		System.out.println("odd / even = " + result);

		long endTime = System.currentTimeMillis();
		System.out.println("Total time::" + (endTime - startTime) + " ms");
	}
}

class NoBlockingIO
{
	private static BufferedReader br;
	private static BufferedReader buff;
	private static BufferedWriter buffwrite;

	public BufferedReader NoBlocking(BufferedReader breader) throws InterruptedException
	{
		Thread threadReader = new Thread()
		{
			public synchronized void run()
			{
				br = breader;
				buff = new BufferedReader(br);
			}
		};
		threadReader.start();
		threadReader.join();
		return buff;
	}

	//public BufferedWriter NoBlocking(BufferedWriter bwriter) throws InterruptedException
	//{
	//	Thread threadWriter = new Thread()
	//	{
	//		public synchronized void run()
	//		{
	//			buffwrite = bwriter;
	//			try{
	//				buffwrite.write("22222222222222222222");
	//				if(buffwrite!=null)
	//					buffwrite.close();
	//			}catch(Exception ex){
	//				System.out.println("Error in closing the BufferedWriter"+ex);
	//			}
	//		}
	//	};
	//	threadWriter.start();
	//	return buffwrite;
	//}
}

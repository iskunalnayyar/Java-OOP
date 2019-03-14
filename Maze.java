package com.first.java;


/*
 * Maze.java
 *
 * Version:
 * 		09/24/2017
 *
 * Revisions:
 * 		4.1
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {

	/**
	 * Maze.java is the three dimensional program where the program automatically
	 * solves the maze by finding the right path.
	 *
	 * (# = Wall, . = path)
	 *
	 * This Program used a Right Hand Wall Follower Algorithm. Once it finds a dead
	 * end it goes back to the previous position where it contains multiple
	 * directions.
	 *
	 * @author Maha Krishnan Krishnan
	 * @author Kunal Nayyar
	 *
	 */

	static int totalLevels;
	static int columns;
	static int rows;
	static int visited = 1;
	static String direction;
	static String[] directions = { "Right", "Forward", "Left", "Backward", "Up", "Left" };

	/**
	 * THis is the main method class where the user imports a maze file and finds a
	 * right path
	 *
	 * @param args
	 * @throws FileNotFoundException
	 *             :: If the scanner does not read a file it throws an exception
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("src/com/first/java/maze.txt"));
		int count = 0, index = 0, dotLevel = 0, dotRow = 0, dotColumn = 0;

		scanner.useDelimiter(" ");

		// Stores a file content into a single string
		String file = null;
		while (scanner.hasNext()) {
			file = scanner.next();
		}

		// Split each lines into an array
		String lines[] = file.split("\\r?\\n");
		for (int i = 0; i < lines.length; i++) {
			if (lines[i].equals("")) {
				count++;
			}
			index++;
		}

		// Store each character from lines[] into 3d maze character array
		totalLevels = count + 1;
		columns = lines[0].length();
		rows = (index + 1 - count) / totalLevels;
		char[][][] maze = new char[totalLevels][rows][columns];
		int c = 0;
		for (int level = 0; level < totalLevels; level++) {
			for (int row = 0; row <= rows; row++) {
				for (int i = c; i < lines.length;) {
					for (int col = 0; col < columns; col++) {
						if (!lines[c].equals("")) {
							maze[level][row][col] = lines[i].charAt(col);
						}
					}
					c++;
					break;
				}
			}
		}

		// To find starting position in all levels starting from level 0
		// we are assuming that starting points should be in the top rows of every
		// levels
		level: for (int level = 0; level < totalLevels; level++) {
			for (int col = 0; col < columns; col++) {
				if (maze[level][0][col] == '.') {
					maze[level][0][col] = '=';
					dotLevel = level;
					dotRow = 0;
					dotColumn = col;
					break level;
				}
			}
		}

		// Finding the exit points. Once it reached exit points the program terminates
		String[] exitPoints = new String[1000];
		int exitIndex = 0;
		// Rows = 0
		for (int level = 0; level < totalLevels; level++) {
			for (int col = 0; col < columns; col++) {
				if (maze[level][0][col] == '.') {
					exitPoints[exitIndex] = level + "," + 0 + "," + col;
					exitIndex++;
				}
			}
		}

		// last row
		for (int level = 0; level < totalLevels; level++) {
			for (int col = 0; col < columns; col++) {
				if (maze[level][rows - 1][col] == '.') {
					exitPoints[exitIndex] = level + "," + (rows - 1) + "," + col;
					exitIndex++;
				}
			}
		}

		// column = 0
		for (int level = 0; level < totalLevels; level++) {
			for (int row = 0; row < rows; row++) {
				if (maze[level][row][0] == '.') {
					exitPoints[exitIndex] = level + "," + row + "," + 0;
					exitIndex++;
				}
			}
		}

		// last column
		for (int level = 0; level < totalLevels; level++) {
			for (int row = 0; row < rows; row++) {
				if (maze[level][row][columns - 1] == '.') {
					exitPoints[exitIndex] = level + "," + row + "," + (columns - 1);
					exitIndex++;
				}
			}
		}

		int totalChar = totalLevels * rows * columns, storeIndex = 0, fillingIndex = 0, prevCount = 0;
		String[] storePoints = new String[totalChar];
		String[] fillings = new String[totalChar];

		// Maze solving using right hand rule
		System.out.println("solving");
		level: while (totalChar != 0) {
			int multipleCount = 0;
			String[] multipleDirection = checkMultipleDirections(maze, storePoints, dotLevel, dotRow, dotColumn);

			// COmparing whether the point is in the exit points
			for (int i = 0; i < exitPoints.length; i++) {
				if (exitPoints[i] != null) {
					if (exitPoints[i].equalsIgnoreCase(dotLevel + "," + dotRow + "," + dotColumn)) {
						break level;
					}
				}
			}

			for (int i = 0; i < multipleDirection.length; i++) {
				if (multipleDirection[i] != null) {
					multipleCount++;
				}
			}

			// If the particular point has multiple directions then the point is stored into
			// an separate array
			if (multipleCount > 1) {
				storePoints[storeIndex] = dotLevel + "," + dotRow + "," + dotColumn;
				storeIndex++;
			}

			// If point reaches the dead end it will proceed to the latest stored points and
			// start with the directions
			if (multipleCount == 0) {
				String dots = anotherDirection(maze, storePoints, dotLevel, dotRow, dotColumn, storeIndex, prevCount,
						fillings, fillingIndex);
				String[] tempDots = dots.split(",");
				dotLevel = Integer.parseInt(tempDots[0]);
				dotRow = Integer.parseInt(tempDots[1]);
				dotColumn = Integer.parseInt(tempDots[2]);
				prevCount++;
			} else { // It will moves to the based on the right hand wall algorithm
				String dots = move(maze, multipleDirection, dotLevel, dotRow, dotColumn, storePoints, storeIndex);
				fillings[fillingIndex] = dots;
				fillingIndex++;
				String[] tempDots = dots.split(",");
				dotLevel = Integer.parseInt(tempDots[0]);
				dotRow = Integer.parseInt(tempDots[1]);
				dotColumn = Integer.parseInt(tempDots[2]);
			}

			totalChar--;
		}

		// Print the final Maze
		for (int level = 0; level < totalLevels; level++) {
			for (int row = 0; row < rows; row++) {
				for (int col = 0; col < columns; col++) {
					System.out.print(maze[level][row][col]);
				}
				System.out.println();
			}
			System.out.println();
		}

	}

	/**
	 * checkMultipleDirections method will check for which direction the path goes
	 * and stores the direction in the separate array
	 *
	 *
	 * @param maze	:: COntains all walls and path
	 * @param storePoints :: stores which having more than one direction
	 * @param dotLevel	:: checks for path in level wise
	 * @param dotRow :: checks for path in row wise
	 * @param dotColumn :: checks for path in column wise
	 * @return
	 */
	private static String[] checkMultipleDirections(char[][][] maze, String[] storePoints, int dotLevel, int dotRow,
													int dotColumn) {
		String multipleDirection[] = new String[6];
		int multipleIndex = 0;
		if (dotRow + 1 < rows && maze[dotLevel][dotRow + 1][dotColumn] == '.') {
			multipleDirection[multipleIndex] = "Right";
			multipleIndex++;
		}

		if (dotColumn + 1 < columns && maze[dotLevel][dotRow][dotColumn + 1] == '.') {
			multipleDirection[multipleIndex] = "Forward";
			multipleIndex++;
		}

		if (dotRow - 1 >= 0 && maze[dotLevel][dotRow - 1][dotColumn] == '.') {
			multipleDirection[multipleIndex] = "Left";
			multipleIndex++;
		}

		if (dotColumn - 1 >= 0 && maze[dotLevel][dotRow][dotColumn - 1] == '.') {
			multipleDirection[multipleIndex] = "Backward";
			multipleIndex++;
		}

		if (dotLevel + 1 < totalLevels && maze[dotLevel + 1][dotRow][dotColumn] == '.') {
			multipleDirection[multipleIndex] = "Up";
			multipleIndex++;
		}

		if (dotLevel - 1 >= 0 && maze[dotLevel - 1][dotRow][dotColumn] == '.') {
			multipleDirection[multipleIndex] = "Down";
			multipleIndex++;
		}

		return multipleDirection;
	}

	/**
	 * In the previous method the multipleDirection stores one or more directions in
	 * an array in which one direction has an end it will for the another direction
	 *
	 *
	 * @param maze	:: COntains all walls and path
	 * @param storePoints :: stores which having more than one direction
	 * @param dotLevel	:: checks for path in level wise
	 * @param dotRow :: checks for path in row wise
	 * @param dotColumn :: checks for path in column wise
	 * @param storeIndex :: index of the store points array
	 * @param prevCount :: count to find the right store points
	 * @param fillings :: stores each path in an array
	 * @param fillingIndex :: index of the fillings
	 * @return
	 */
	private static String anotherDirection(char[][][] maze, String[] storePoints, int dotLevel, int dotRow,
										   int dotColumn, int storeIndex, int prevCount, String[] fillings, int fillingIndex) {

		System.out.println(prevCount + "," + storeIndex + "," + (storeIndex - prevCount));
		if (storeIndex - prevCount >= 0 && storePoints[storeIndex - prevCount] != null) {

			for (int i = fillingIndex - 1; i >= 0; i--) {
				if (!storePoints[storeIndex - prevCount].equalsIgnoreCase(fillings[i])) {
					String[] fillDots = fillings[i].split(",");
					maze[Integer.parseInt(fillDots[0])][Integer.parseInt(fillDots[1])][Integer
							.parseInt(fillDots[2])] = 'x';
				} else {
					break;
				}
			}

			String[] prev = storePoints[storeIndex - prevCount].split(",");
			dotLevel = Integer.parseInt(prev[0]);
			dotRow = Integer.parseInt(prev[1]);
			dotColumn = Integer.parseInt(prev[2]);
		}
		return dotLevel + "," + dotRow + "," + dotColumn;

	}

	/**
	 * Move method will the character into one point
	 *
	 * @param maze	:: COntains all walls and path
	 * @param storePoints :: stores which having more than one direction
	 * @param dotLevel	:: checks for path in level wise
	 * @param dotRow :: checks for path in row wise
	 * @param dotColumn :: checks for path in column wise
	 * @param storeIndex :: index of the store points array
	 * @return
	 */
	private static String move(char[][][] maze, String[] multipleDirection, int dotLevel, int dotRow, int dotColumn,
							   String[] storePoints, int storeIndex) {
		if (multipleDirection[0] != null) {
			if (multipleDirection[0].equals("Right")) {
				maze[dotLevel][dotRow + 1][dotColumn] = '=';
				dotRow = dotRow + 1;

			} else if (multipleDirection[0].equals("Forward")) {
				maze[dotLevel][dotRow][dotColumn + 1] = '=';
				dotColumn = dotColumn + 1;

			} else if (multipleDirection[0].equals("Left")) {
				maze[dotLevel][dotRow - 1][dotColumn] = '=';
				dotRow = dotRow - 1;

			} else if (multipleDirection[0].equals("Backward")) {
				maze[dotLevel][dotRow][dotColumn - 1] = '=';
				dotColumn = dotColumn - 1;

			} else if (multipleDirection[0].equals("Up")) {
				maze[dotLevel + 1][dotRow][dotColumn] = '=';
				dotLevel = dotLevel + 1;

			} else if (multipleDirection[0].equals("Down")) {
				maze[dotLevel - 1][dotRow][dotColumn] = '=';
				dotLevel = dotLevel - 1;
			}
		}
		return dotLevel + "," + dotRow + "," + dotColumn;
	}
}

package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MazeMaker {

	private static int width;
	private static int height;

	private static Maze maze;

	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();

	public static Maze generateMaze(int w, int h) {
		width = w;
		height = h;
		maze = new Maze(width, height);

		// 4. select a random cell to start
		int randomX = randGen.nextInt(w);
		int randomY = randGen.nextInt(h);

		// 5. call selectNextPath method with the randomly selected cell
		selectNextPath(maze.getCell(randomX, randomY));

		return maze;
	}

	// 6. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {

		// A. mark cell as visited

		// B. check for unvisited neighbors using the cell
		currentCell.setBeenVisited(true);
		ArrayList<Cell> neighbors = getUnvisitedNeighbors(currentCell);
		// C. if has unvisited neighbors,
		if((neighbors.size() > 0)) {
			int num = randGen.nextInt(neighbors.size());
			Cell x = neighbors.get(num);
			uncheckedCells.push(x);		
			removeWalls(x, currentCell);
			x.setBeenVisited(true);
			selectNextPath(x);
		}
		// C1. select one at random.

		// C2. push it to the stack

		// C3. remove the wall between the two cells

		// C4. make the new cell the current cell and mark it as visited

		// C5. call the selectNextPath method with the current cell

		// D. if all neighbors are visited
		else if( !uncheckedCells.isEmpty() ) {
			Cell y = uncheckedCells.pop();
			currentCell = y;
			selectNextPath(y);

		}
		// D1. if the stack is not empty

		// D1a. pop a cell from the stack

		// D1b. make that the current cell

		// D1c. call the selectNextPath method with the current cell

	}

	// 7. Complete the remove walls method.
	// This method will check if c1 and c2 are adjacent.
	// If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {
		if( c1.getY() == c2.getY() )
		{
			if (c1.getX() + 1 == c2.getX()) {
				c1.setEastWall(false);
				c2.setWestWall(false);
			}
			else if (c1.getX() - 1 == c2.getX()) {
				c1.setWestWall(false);
				c2.setEastWall(false);
			}
		}
		else if( c1.getX() == c2.getX() )
		{	
			if (c1.getY() + 1 == c2.getY()) {
				c1.setSouthWall(false);
				c2.setNorthWall(false);
			}
			else if (c1.getY() - 1 == c2.getX()) {
				c1.setNorthWall(false);
				c2.setSouthWall(false);
			}
		}
	}

	// 8. Complete the getUnvisitedNeighbors method
	// Any unvisited neighbor of the passed in cell gets added
	// to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		ArrayList<Cell> neighbors = new ArrayList<>();
		if (c.getX() > 0) {
			Cell leftCell = maze.getCell(c.getX() - 1, c.getY());
			if (!leftCell.hasBeenVisited()) {
				neighbors.add(leftCell);
			}
		}
		if (c.getY() < height-1) {
			Cell bottomCell = maze.getCell(c.getX() , c.getY() + 1);
			if (!bottomCell.hasBeenVisited()) {
				neighbors.add(bottomCell);
			}
		}
		if (c.getX() < width-1) {
			Cell rightCell = maze.getCell(c.getX() + 1, c.getY());
			if (!rightCell.hasBeenVisited()) {
				neighbors.add(rightCell);
			}
		}
		if (c.getY() > 0) {
			Cell topCell = maze.getCell(c.getX() , c.getY() - 1);
			if (!topCell.hasBeenVisited()) {
				neighbors.add(topCell);
			}
		}

		return neighbors;
	}
}

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
		
		ArrayList<Cell> neighbors = new ArrayList<>();
		
		//A. mark cell as visited
		currentCell.hasBeenVisited();
		//B. check for unvisited neighbors using the cell
		if( currentCell.getX() > 0 )
		{
			Cell leftCell = maze.getCell( currentCell.getX() - 1, currentCell.getY() );
			if( !leftCell.hasBeenVisited() )
			{
				neighbors.add( leftCell );
			}
		}
		if( currentCell.getY() > 0 )
		{
			Cell bottomCell = maze.getCell( currentCell.getY() + 1, currentCell.getX() );
			if( !bottomCell.hasBeenVisited() )
			{
				neighbors.add( bottomCell );
			}
		}
		if( currentCell.getX() < width )
		{
			Cell rightCell = maze.getCell( currentCell.getX() + 1, currentCell.getY() );
			if( !rightCell.hasBeenVisited() )
			{
				neighbors.add( rightCell );
			}
		}
		if( currentCell.getY() < height )
		{
			Cell topCell = maze.getCell( currentCell.getY() - 1, currentCell.getX() );
			if( !topCell.hasBeenVisited() )
			{
				neighbors.add( topCell );
			}
		}
		
		
		//C. if has unvisited neighbors,
		if((neighbors.size() > 0)){
			int num = randGen.nextInt(neighbors.size());
			uncheckedCells.push(neighbors.get(num));
		}
			//C1. select one at random.
			
			//C2. push it to the stack
		
			//C3. remove the wall between the two cells

			//C4. make the new cell the current cell and mark it as visited
		
			//C5. call the selectNextPath method with the current cell
			
			
		//D. if all neighbors are visited
		
			//D1. if the stack is not empty
			
				// D1a. pop a cell from the stack
		
				// D1b. make that the current cell
		
				// D1c. call the selectNextPath method with the current cell
				
			
		
	}

	// 7. Complete the remove walls method.
	// This method will check if c1 and c2 are adjacent.
	// If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {

	}

	// 8. Complete the getUnvisitedNeighbors method
	// Any unvisited neighbor of the passed in cell gets added
	// to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		return null;
	}
}

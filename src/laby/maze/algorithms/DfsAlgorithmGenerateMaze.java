package laby.maze.algorithms;

import laby.maze.Cell;
import laby.maze.Maze;
import laby.maze.objects.Cursor;
import laby.maze.objects.MazeObject;

public class DfsAlgorithmGenerateMaze implements IAlgorithm{
	
	@Override
	public void execute(MazeObject obj, Maze maze) {
		// Implementation de l'algorithme Depth First Search
		System.out.println("Executing DFS Algorithm");
		Cursor cursor = (Cursor) obj;
		// Pick up a random cell and set the visited attribute to true
		Cell startingCell = maze.getCell(0, 0);
		startingCell.setVisited(true);
		
		// Initialize the cursor position on the maze and size
		cursor.setCol(startingCell.getCol());
		cursor.setRow(startingCell.getRow());
		cursor.setHeight(startingCell.getHeight());
		cursor.setWidth(startingCell.getWidth());
		
		cursor.addCellToPath(startingCell);
		cursor.initPossibleDirections();
		int dir = cursor.getRandomPossibleDirection();
		while(!cursor.getPath().isEmpty()){
			dir = cursor.getRandomPossibleDirection();
			System.out.println("random direction " + dir);
			cursor.setDirection(dir);
			boolean retVal = cursor.move();
			if(!retVal){
				if(dir == Cursor.NO_DIRECTION_AVAILABLE){
					System.out.println("Cursor back tracking now. No possible directions " + cursor.getRandomPossibleDirection() );
					cursor.backTracking();
				}
				else{
					cursor.deletePossibleDirection(dir);
				}
			}
		}
		
		System.out.println("The path is empty aborting DFS");
		
	}

}

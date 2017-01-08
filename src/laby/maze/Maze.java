package laby.maze;

import laby.maze.exceptions.BuildingMazeException;

public class Maze {
	private Cell[][] maze;
	private final static int SIZE_MIN_LIMIT = 6;
	
	public Maze(int size){
		try{
			buildMaze(size);
		}catch(BuildingMazeException ex){
			System.out.println(ex.toString());
		}
	}
	
	private void buildMaze(int size) throws BuildingMazeException{
		if(size < SIZE_MIN_LIMIT){
			throw new BuildingMazeException("The size must be greater than " + SIZE_MIN_LIMIT);
		}
		else{
			/* Building the maze if the size is correct 
			 * Initializing the cells
			 * */
			for(int i=0; i< size; ++i){
				maze[i] = new Cell[size];
			}
		}
	}
}

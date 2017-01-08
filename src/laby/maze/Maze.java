package laby.maze;

import laby.maze.exceptions.BuildingMazeException;

public class Maze {
	private Cell[][] maze;
	private final static int SIZE_MIN_LIMIT = 6;
	
	/**
	 * constructor
	 * @param size The size of the maze
	 */
	public Maze(int size){
		try{
			buildMaze(size);
		}catch(BuildingMazeException ex){
			System.out.println(ex.getMessage());
		}
	}
	
	/**
	 * Build the maze with the specified size
	 * @param size
	 * @throws BuildingMazeException
	 */
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
			dfs();
		}
	}
	
	/**
	 * Depth first search algorithm implementation
	 */
	private void dfs(){
		
	}
}

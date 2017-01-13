package laby.maze;

import laby.maze.exceptions.BuildingMazeException;

public class Maze {
	private Cell[][] maze;
	private final static int SIZE_MIN_LIMIT = 6;
	private int size = 0;
	private int cellSize;
	/**
	 * constructor
	 * @param size The size of the maze
	 */
	public Maze(int size, int cellSize){
		try{
			buildMaze(size, cellSize);
		}catch(BuildingMazeException ex){
			System.out.println(ex.getMessage());
		}
	}
	
	/**
	 * Build the maze with the specified size
	 * @param size
	 * @throws BuildingMazeException
	 */
	private void buildMaze(int size, int cellSize) throws BuildingMazeException{
		if(size < SIZE_MIN_LIMIT){
			throw new BuildingMazeException("The size must be greater than " + SIZE_MIN_LIMIT);
		}else if(size % 2 == 0){
			throw new BuildingMazeException("The size must be an odd number to generate the maze");
		}
		else{
			/* Building the maze if the size is correct 
			 * Initializing the cells
			 * */
			this.size = size;
			this.cellSize = cellSize;
			
			init(size);
			//dfs();
		}
	}
	
	private void init(int size){
		System.out.println("Init maze");
		maze = new Cell[size][size];
		for(int row=0; row<size; ++row){
			for(int col=0; col<size; ++col){
				maze[row][col] = new Cell(this,row, col, cellSize, cellSize);
			}
		}
	}
	
	public Cell pickRandomCell(){
		int randomRow = (int)(Math.random() * (size)) + 0;
		int randomCol = (int)(Math.random() * (size)) + 0;
		System.out.println("Picking random cell random row " + randomRow + " randomCol: " + randomCol);
		return getCell(randomRow,randomCol);
	}
	
	public Cell getCell(int col, int row){
		return maze[col][row];
	}
	
	public int getSize(){
		return size;
	}
}

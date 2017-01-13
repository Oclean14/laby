package laby.maze.objects;

import laby.Main;
import laby.maze.Maze;
import laby.maze.algorithms.IAlgorithm;

public class MazeObject{
	
	protected int col, row, width, height;
	protected Maze maze;
	
	public MazeObject(Maze maze, int col, int row, int width, int height){
		this.maze = maze;
		this.col = col;
		this.row = row;
		this.width = width;
		this.height = height;
	}
	
	public MazeObject(MazeObject object){
		col = object.col;
		row = object.row;
		width = object.width;
		height = object.height;
	}
	
	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public double getRealHeight(){
		return ((double) height )/ Main.WINDOW_SIZE;
	}
	
	public double getRealWidth(){
		return ((double) width )/ Main.WINDOW_SIZE;
	}
	
	public Maze getMaze() {
		return maze;
	}

	public void setMaze(Maze maze) {
		this.maze = maze;
	}
	
	public void setAlgorithm(IAlgorithm algo){
		algo.execute(this, maze);
	}

}

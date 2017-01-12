package laby.maze.objects;

import laby.maze.Maze;

public class MazeObject {
	
	protected int col, row, width, height;
	protected Maze maze;
	
	public MazeObject(Maze maze, int col, int row, int width, int height){
		this.maze = maze;
		this.col = col;
		this.row = row;
		this.width = width;
		this.height = height;
	}
	
	public Maze getMaze() {
		return maze;
	}

	public void setMaze(Maze maze) {
		this.maze = maze;
	}

	public MazeObject(MazeObject object){
		col = object.col;
		row = object.row;
		width = object.width;
		height = object.height;
	}
}

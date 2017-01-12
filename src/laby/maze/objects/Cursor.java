package laby.maze.objects;

import laby.maze.Maze;
import laby.maze.algorithms.IAlgorithm;

public class Cursor extends MazeObject implements IMoveable{
	
	public Cursor(Maze maze, int row, int col, int width, int height){
		super(maze, row, col, width, height);
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAlgorithm(IAlgorithm algo) {
		// TODO Auto-generated method stub
		algo.execute(this, this.maze);
	}
}

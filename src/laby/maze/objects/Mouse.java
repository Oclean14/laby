package laby.maze.objects;

import java.util.ArrayDeque;
import java.util.ArrayList;

import laby.maze.Cell;
import laby.maze.Maze;
import laby.maze.objects.interfaces.IMoveable;

public class Mouse extends MazeObject implements IMoveable{

	ArrayDeque<Cell> path = new ArrayDeque<Cell>();

	public Mouse(Maze maze, int row, int col, int width, int height) {
		// TODO Auto-generated constructor stub
		super(maze,row,col,width,height);
		}
	
	public Mouse (MazeObject obj){
		super (obj);
	}

	@Override
	public boolean move() {
		// TODO Auto-generated method stub
		if(canMoveLeft()){
			Cell currentCell = this.maze.getCell(col, row);
			currentCell.setVisited(true);
			
			Cell cell1 = this.maze.getCell(col - 1, row);
			cell1.setVisited(true);
			addCellToPath(cell1);
			
			col -= 1;
			return true;
		} 
		
		if (canMoveRight()){
			Cell currentCell = this.maze.getCell(col, row);
			currentCell.setVisited(true);
			
			Cell cell1 = this.maze.getCell(col + 1, row);
			cell1.setVisited(true);
			addCellToPath(cell1);
			
			col -= 1;
			return true;
		}
		
		if (canMoveUp()){
			Cell currentCell = this.maze.getCell(col, row);
			currentCell.setVisited(true);
			
			Cell cell1 = this.maze.getCell(col, row + 1);
			cell1.setVisited(true);
			addCellToPath(cell1);
			
			col -= 1;
			return true;
		}
			
		if (canMoveDown()){
			Cell currentCell = this.maze.getCell(col, row);
			currentCell.setVisited(true);
			
			Cell cell1 = this.maze.getCell(col, row - 1);
			cell1.setVisited(true);
			addCellToPath(cell1);
			
			col -= 1;
			return true;
		}	
		
	
		return false;	
		
	}

	private void addCellToPath(Cell cell) {
		// TODO Auto-generated method stub
		path.add(cell);
		
	}

	@Override
	public boolean canMoveLeft() {
		// TODO Auto-generated method stub
		Cell cell = this.maze.getCell(col, row);
		if(cell.getLeftEdge()){
			return true;
		}
		return false;
	}

	@Override
	public boolean canMoveRight() {
		// TODO Auto-generated method stub
		Cell cell = this.maze.getCell(col, row);
		if(cell.getRightEdge()){
			return true;
		}
		return false;
	}

	@Override
	public boolean canMoveUp() {
		// TODO Auto-generated method stub
		Cell cell = this.maze.getCell(col, row);
		if(cell.getTopEdge()){
			return true;
		}
		return false;
	}

	@Override
	public boolean canMoveDown() {
		// TODO Auto-generated method stub
		Cell cell = this.maze.getCell(col, row);
		if(cell.getBottomEdge()){
			return true;
		}
		return false;
	}

}

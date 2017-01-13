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
			definingExploitibility("LEFT");
			return true;
		} 
		
		if (canMoveRight()){
			Cell currentCell = this.maze.getCell(col, row);
			currentCell.setVisited(true);
			
			Cell cell1 = this.maze.getCell(col + 1, row);
			
			cell1.setVisited(true);
			addCellToPath(cell1);
			col -= 1;
			definingExploitibility("RIGHT");
			return true;
		}
		
		if (canMoveUp()){
			Cell currentCell = this.maze.getCell(col, row);
			currentCell.setVisited(true);
			
			Cell cell1 = this.maze.getCell(col, row + 1);
			
			cell1.setVisited(true);
			addCellToPath(cell1);
			col -= 1;
			definingExploitibility("TOP");
			return true;
		}
			
		if (canMoveDown()){
			Cell currentCell = this.maze.getCell(col, row);
			currentCell.setVisited(true);
			
			Cell cell1 = this.maze.getCell(col, row - 1);
			
			cell1.setVisited(true);
			addCellToPath(cell1);
			col -= 1;
			definingExploitibility("BOTTOM");
			return true;
			
		}	
		
	
		return false;	
		
	}
	
	public boolean isExploitable (Cell cell) {
		if (cell.getLeftExploitability() | cell.getBottomExploitability() |  cell.getRightExploitability() | cell.getTopExploitability()){
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
			Cell cell1 = this.maze.getCell(col - 1, row);
			if (!cell1.getVisited()){
			return true; 
		}
			}
		return false;
	}

	@Override
	public boolean canMoveRight() {
		// TODO Auto-generated method stub
		Cell cell = this.maze.getCell(col, row);
		if(cell.getRightEdge()){
			Cell cell1 = this.maze.getCell(col + 1, row);
			if (!cell1.getVisited()){
			return true;
			}
		}
		return false;
	}

	@Override
	public boolean canMoveUp() {
		// TODO Auto-generated method stub
		Cell cell = this.maze.getCell(col, row);
		if(cell.getTopEdge()){
			Cell cell1 = this.maze.getCell(col, row + 1);
			if (!cell1.getVisited()){
			return true;
			}
		}
		return false;
	}

	@Override
	public boolean canMoveDown() {
		// TODO Auto-generated method stub
		Cell cell = this.maze.getCell(col, row);
		if(cell.getBottomEdge()){
			Cell cell1 = this.maze.getCell(col, row - 1);
			if (!cell1.getVisited()){
			return true;
			}
		}
		return false;
	}
	
	public void definingExploitibility(String edge){
		Cell cell = this.maze.getCell(col, row);
		switch(edge){
		case "LEFT":
			if(canMoveRight())
			{
				cell.setRightExploitability(true);
			}
			if(canMoveUp()){
				cell.setTopExploitability(true);
			}
			if(canMoveDown()){
				cell.setBottomExploitability(true);
			}
		case "RIGHT":
			if(canMoveLeft())
			{
				cell.setLeftExploitability(true);
			}
			if(canMoveUp()){
				cell.setTopExploitability(true);
			}
			if(canMoveDown()){
				cell.setBottomExploitability(true);
			}
		case "TOP":
			if(canMoveRight())
			{
				cell.setRightExploitability(true);
			}
			if(canMoveLeft()){
				cell.setLeftExploitability(true);
			}
			if(canMoveDown()){
				cell.setBottomExploitability(true);
			}
		case "BOTTOM":
			if(canMoveRight())
			{
				cell.setRightExploitability(true);
			}
			if(canMoveUp()){
				cell.setTopExploitability(true);
			}
			if(canMoveLeft()){
				cell.setLeftExploitability(true);
			}
			break;
	}
	
	}

	public void backTracking(){
		
		// Pop le dernier noeud deja teste
		Cell upperCell = path.pop();
		
		while (!isExploitable(upperCell)){
			// Supprimer le dernier noed de la pile
			path.poll();
			// On récupère le dernier noeud de la nouvelle pile
			upperCell = path.pop();
		}
	}

}

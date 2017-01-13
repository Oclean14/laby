package laby.maze.objects;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import laby.maze.Cell;
import laby.maze.Maze;
import laby.maze.objects.interfaces.IMoveable;

public class Cursor extends MazeObject implements IMoveable{
	
	ArrayDeque<Cell> path = new ArrayDeque<Cell>();
    public static int NO_DIRECTION_AVAILABLE = -1;
	private final static int WEST = 0;
	private final static int NORTH = 1;
	private final static int EAST = 2;
	private final static int SOUTH = 3;
	private ArrayList<Integer> possibleDirections = new ArrayList<Integer>();
	private int direction = WEST;

	
	public Cursor(Maze maze, int row, int col, int width, int height){
		super(maze, row, col, width, height);
	}
	
	public Cursor(MazeObject obj){
		super(obj);
	}

	@Override
	public boolean move() {
		switch(direction){
			case WEST:
				System.out.println("Cursor move left");
				if(canMoveLeft())
				{
					Cell currentCell = this.maze.getCell(col, row);
					Cell cell1 = this.maze.getCell(col - 1, row);
					currentCell.setVisited(true);
					cell1.setVisited(true);
					currentCell.openWall(Cell.CELL_LEFT);
					cell1.openWall(Cell.CELL_RIGHT);
					addCellToPath(cell1);
					col -= 1;
					return true;
				}
				return false;
			case NORTH:
				System.out.println("Cursor move up");
				if(canMoveUp()){
					Cell currentCell = this.maze.getCell(col, row);
					Cell cell1 = this.maze.getCell(col, row + 1);
					currentCell.setVisited(true);
					cell1.setVisited(true);
					currentCell.openWall(Cell.CELL_TOP);
					cell1.openWall(Cell.CELL_BOTTOM);
					addCellToPath(cell1);
					row += 1;
					return true;
				}
				return false;
			case EAST:
				if(canMoveRight())
				{	
					Cell currentCell = this.maze.getCell(col, row);
					Cell cell1 = this.maze.getCell(col + 1, row);
					currentCell.setVisited(true);
					cell1.setVisited(true);
					currentCell.openWall(Cell.CELL_RIGHT);
					cell1.openWall(Cell.CELL_LEFT);
					addCellToPath(cell1);
					col += 1;
					return true;
				}
				return false;
			
			case SOUTH:
				System.out.println("Cursor move down");
				if(canMoveDown()){
					Cell currentCell = this.maze.getCell(col, row);
					Cell cell1 = this.maze.getCell(col, row - 1);
					currentCell.setVisited(true);
					cell1.setVisited(true);
					currentCell.openWall(Cell.CELL_BOTTOM);
					cell1.openWall(Cell.CELL_TOP);
					addCellToPath(cell1);
					row -= 1;
					return true;
				}
				break;
		}
		return false;

	}
	
	public void initPossibleDirections(){
		possibleDirections.add(NORTH);
		possibleDirections.add(EAST);
		possibleDirections.add(WEST);
		possibleDirections.add(SOUTH);
	}
	
	@Override
	public boolean canMoveLeft() {
		if(col - 1 < 0)
			return false;
		Cell cell = this.maze.getCell(col - 1, row);
		if(cell.getVisited())
			return false;
		return true;
	}

	@Override
	public boolean canMoveRight() {
		if(col + 1  >= maze.getSize())
			return false;
		Cell cell = this.maze.getCell(col + 1, row);
		if(cell.getVisited())
			return false;
		return true;
	}

	@Override
	public boolean canMoveUp() {
		if(row + 1  >= maze.getSize())
			return false;
		Cell cell = this.maze.getCell(col, row + 1);
		if(cell.getVisited())
			return false;
		return true;
	}

	@Override
	public boolean canMoveDown() {
		if(row - 1  < 0 )
			return false;
		Cell cell = this.maze.getCell(col, row - 1);
		if(cell.getVisited())
			return false;
		return true;
	}
	
	public void addCellToPath(Cell cell){
		path.add(cell);
	}
	
	public void setDirection(int direction){
		this.direction = direction;
	}
	
	public void chooseRandomDirection(){
		setDirection((int)(Math.random() * 4) + 0);
	}
	
	public int getDirection(){
		return direction;
	}
	
	public ArrayDeque<Cell> getPath(){
		return path;
	}
	
	public int getRandomPossibleDirection(){
		if(possibleDirections.size() > 1){
			int randInt = ThreadLocalRandom.current().nextInt(0, possibleDirections.size());
			int dir = possibleDirections.get(randInt);
			return dir;
		}else if(possibleDirections.size() == 1){
			int dirToReturn = possibleDirections.get(0);
			return dirToReturn;
		}else{
			return NO_DIRECTION_AVAILABLE;
		}
	}
	
	public void deletePossibleDirection(int dir){
		possibleDirections.remove(possibleDirections.indexOf(dir));
	}
	
	public void backTracking(){
		
		// Pop le dernier noeud deja teste
		path.pop();
		boolean foundDirection = false;
		while(!path.isEmpty() && !foundDirection){
			initPossibleDirections();
			Cell upperCell = path.pop();
			col = upperCell.col;
			row = upperCell.row;

			while(!possibleDirections.isEmpty()){
				int dir = getRandomPossibleDirection();
				this.setDirection(dir);
				boolean retVal = this.move();
				
				String dirName = "";
				
				switch(dir){
				case WEST:
					dirName = "WEST";
					break;
				case NORTH:
					dirName = "NORTH";
					break;
				case EAST:
					dirName = "EAST";
					break;
				case SOUTH:
					dirName = "SOUTH";
					break;
				}
				
				if(retVal) {
					System.out.println("Change direction to " + dirName);
					foundDirection = true;
					path.push(upperCell);
					break;
				}
				else{
					System.out.println("Impossible to go to this direction " + dirName);
					deletePossibleDirection(dir);
				}
			}
		}
		initPossibleDirections();
	}
	
}

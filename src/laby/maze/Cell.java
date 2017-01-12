package laby.maze;

import laby.maze.objects.MazeObject;

public class Cell extends MazeObject{
	
	private boolean[] edges = new boolean[4];
	public final static int CELL_LEFT = 0;
	public final static int CELL_TOP = 1;
	public final static int CELL_RIGHT = 2;
	public final static int CELL_BOTTOM = 3;
	// The cell is visited or not
	private boolean isVisited = false;
	
	public Cell(Maze maze, int col, int row, int width, int height){
		super(maze, col, row, width, height);
		this.edges[CELL_LEFT] = false;
		this.edges[CELL_TOP] = false;
		this.edges[CELL_RIGHT] = false;
		this.edges[CELL_BOTTOM] = false;
	}
	
	public Cell(Cell cell){
		super(cell);
		this.edges[CELL_LEFT] = getLeftEdge();
		this.edges[CELL_TOP] = getTopEdge();
		this.edges[CELL_RIGHT] = getRightEdge();
		this.edges[CELL_BOTTOM] = getBottomEdge();
	}
	

	
	public boolean getLeftEdge(){
		return this.edges[CELL_LEFT];
	}
	
	public boolean getTopEdge(){
		return this.edges[CELL_TOP];
	}
	
	public boolean getRightEdge(){
		return this.edges[CELL_RIGHT];
	}
	
	public boolean getBottomEdge(){
		return this.edges[CELL_BOTTOM];
	}
	
	public void openWall(final int side){
		this.edges[side] = true;
	}
	
	public void setVisited(final boolean isVisited){
		this.isVisited = isVisited;
	}
	
	public boolean getVisited(){
		return this.isVisited;
	}
}

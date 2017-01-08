package laby.maze;

public class Cell {
	
	private boolean[] edges;
	public final static int CELL_LEFT = 0;
	public final static int CELL_TOP = 1;
	public final static int CELL_RIGHT = 2;
	public final static int CELL_BOTTOM = 3;
	
	public Cell(boolean edgeLeft, boolean edgeTop, boolean edgeRight, boolean edgeBottom){
		this.edges[CELL_LEFT] = edgeLeft;
		this.edges[CELL_TOP] = edgeTop;
		this.edges[CELL_RIGHT] = edgeRight;
		this.edges[CELL_BOTTOM] = edgeBottom;
	}
	
	public Cell(boolean[] edges){
		this.edges = edges;
	}
	
	public Cell(Cell cell){
		this.edges[CELL_LEFT] = getLeftEdge();
		this.edges[CELL_TOP] = getTopEdge();
		this.edges[CELL_RIGHT] = getRightEdge();
		this.edges[CELL_BOTTOM] = getBottomEdge();
	}
	
	public Cell(){
		this.edges[CELL_LEFT] = false;
		this.edges[CELL_TOP] = false;
		this.edges[CELL_RIGHT] = false;
		this.edges[CELL_BOTTOM] = false;
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
	
	public void openWall(int side){
		this.edges[side] = true;
	}
}

package laby.maze;

import java.awt.Color;
import java.nio.charset.MalformedInputException;

import edu.princeton.cs.introcs.StdDraw;
import laby.maze.objects.MazeObject;
import laby.*;
public class Cell extends MazeObject{
	
	private boolean[] edges = new boolean[4];
	private boolean[] exploitability = new boolean[4];
	public final static int CELL_LEFT = 0;
	public final static int CELL_TOP = 1;
	public final static int CELL_RIGHT = 2;
	public final static int CELL_BOTTOM = 3;
	// The cell is visited or not
	private boolean isVisited = false;
	
	public Cell(Maze maze, int col, int row, int width, int height){
		super(maze, col, row, width, height);
		this.edges[CELL_LEFT] = true;
		this.edges[CELL_TOP] = true;
		this.edges[CELL_RIGHT] = true;
		this.edges[CELL_BOTTOM] = true;
		this.exploitability[CELL_LEFT] = false;
		this.exploitability[CELL_RIGHT] = false;
		this.exploitability[CELL_TOP] = false;
		this.exploitability[CELL_BOTTOM] = false;
 		draw();
	}
	
	public Cell(Cell cell){
		super(cell);
		this.edges[CELL_LEFT] = getLeftEdge();
		this.edges[CELL_TOP] = getTopEdge();
		this.edges[CELL_RIGHT] = getRightEdge();
		this.edges[CELL_BOTTOM] = getBottomEdge();
		this.exploitability[CELL_LEFT] = getLeftExploitability();
		this.exploitability[CELL_RIGHT] = getRightExploitability();
		this.exploitability[CELL_TOP] = getTopExploitability();
		this.exploitability[CELL_BOTTOM] = getBottomExploitability();
		draw();
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
	
	public boolean getLeftExploitability(){
		return this.exploitability[CELL_LEFT];
	}
	
	public void setLeftExploitability(boolean  exploitability){
		this.exploitability[CELL_LEFT] = exploitability;
	}
	
	public void setRightExploitability(boolean  exploitability){
		this.exploitability[CELL_RIGHT] = exploitability;
	}
	
	public void setTopExploitability(boolean  exploitability){
		this.exploitability[CELL_TOP] = exploitability;
	}
	
	public void setBottomExploitability(boolean  exploitability){
		this.exploitability[CELL_BOTTOM] = exploitability;
	}
	
	public boolean getRightExploitability(){
		return this.exploitability[CELL_RIGHT];
	}
	
	public boolean getTopExploitability(){
		return this.exploitability[CELL_TOP];
	}
	
	public boolean getBottomExploitability(){
		return this.exploitability[CELL_BOTTOM];
	}
	
	public void openWall(final int side){
		
		System.out.println("Open " + side + " edge" );
		this.edges[side] = false;
		draw();
	}
	
	public void setVisited(final boolean isVisited){
		this.isVisited = isVisited;
	}
	
	public boolean getVisited(){
		return this.isVisited;
	}
	
	public void draw(){
		//StdDraw.clear();
		StdDraw.setPenRadius(0.01);
		Color color = StdDraw.BLACK;
		
		// TOP EDGE
		color = (this.getBottomEdge()) ? StdDraw.BLACK: StdDraw.WHITE;
		StdDraw.setPenColor(color);
		StdDraw.line(col * this.getRealWidth() , row * this.getRealHeight(), col * getRealWidth() + getRealWidth(), row*getRealHeight());
		
	    //RIGHT EDGE
		color = (this.getLeftEdge()) ? StdDraw.BLACK : StdDraw.WHITE;
		StdDraw.setPenColor(color);
		StdDraw.line(col * this.getRealWidth() +  this.getRealWidth(), row * this.getRealHeight(), col * getRealWidth() + this.getRealWidth(), row*getRealHeight() - getRealHeight());
		
	    //BOTTOM EDGE
		color = (this.getTopEdge()) ? StdDraw.BLACK : StdDraw.WHITE;
		StdDraw.setPenColor(color);
		StdDraw.line(col * this.getRealWidth() , row * this.getRealHeight() - getRealHeight(), col * getRealWidth() + getRealWidth(), row*getRealHeight() - getRealHeight());

	    //LEFT EDGE
		color = (this.getRightEdge()) ? StdDraw.BLACK : StdDraw.WHITE;
		StdDraw.setPenColor(color);
		StdDraw.line(col * this.getRealWidth(), row * this.getRealHeight(), col * this.getRealWidth(), row*getRealHeight() - getRealHeight());

	}
	
}

package laby.maze;

import java.awt.Color;
import java.nio.charset.MalformedInputException;

import edu.princeton.cs.introcs.StdDraw;
import laby.maze.objects.MazeObject;
import laby.*;
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
		this.edges[CELL_LEFT] = true;
		this.edges[CELL_TOP] = true;
		this.edges[CELL_RIGHT] = true;
		this.edges[CELL_BOTTOM] = true;
		draw();
	}
	
	public Cell(Cell cell){
		super(cell);
		this.edges[CELL_LEFT] = getLeftEdge();
		this.edges[CELL_TOP] = getTopEdge();
		this.edges[CELL_RIGHT] = getRightEdge();
		this.edges[CELL_BOTTOM] = getBottomEdge();
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
		Color color = StdDraw.BLACK;
		StdDraw.setPenRadius(0.01);
		
		// TOP EDGE
		color = (this.getBottomEdge()) ? StdDraw.MAGENTA : StdDraw.WHITE;
		StdDraw.setPenColor(color);
		StdDraw.line(col * this.getRealWidth() , row * this.getRealHeight(), col * getRealWidth() + getRealWidth(), row*getRealHeight());
	    //RIGHT EDGE
		color = (this.getLeftEdge()) ? StdDraw.GRAY : StdDraw.WHITE;
		StdDraw.setPenColor(color);
		StdDraw.line(col * this.getRealWidth() +  this.getRealWidth(), row * this.getRealHeight(), col * getRealWidth() + this.getRealWidth(), row*getRealHeight() - getRealHeight());
		
	    //BOTTOM EDGE
		color = (this.getTopEdge()) ? StdDraw.RED : StdDraw.WHITE;
		StdDraw.setPenColor(color);
		StdDraw.line(col * this.getRealWidth() , row * this.getRealHeight() - getRealHeight(), col * getRealWidth() + getRealWidth(), row*getRealHeight() - getRealHeight());

	    //LEFT EDGE
		color = (this.getRightEdge()) ? StdDraw.BLUE : StdDraw.WHITE;
		StdDraw.setPenColor(color);
		StdDraw.line(col * this.getRealWidth(), row * this.getRealHeight(), col * this.getRealWidth(), row*getRealHeight() - getRealHeight());

	}
	
}

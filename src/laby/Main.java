package laby;

import edu.princeton.cs.introcs.StdDraw;
import laby.maze.Maze;
import laby.maze.algorithms.DfsAlgorithmGenerateMaze;
import laby.maze.objects.Cursor;

public class Main {
	public final static int CELL_SIZE = 20;
	public final static int NUMBER_OF_CELLS = 51;
	public final static int WINDOW_SIZE = CELL_SIZE*NUMBER_OF_CELLS;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("*************************************************");
		System.out.println("*        STARTING LABY APPLICATION       		*");
		System.out.println("*************************************************");
		
		StdDraw.setCanvasSize(WINDOW_SIZE, WINDOW_SIZE);
        
		Maze labyrinthe = new Maze(NUMBER_OF_CELLS, CELL_SIZE);
		// Generate laby
		Cursor cursor = new Cursor(labyrinthe, 25 ,25, CELL_SIZE, CELL_SIZE);
		cursor.setAlgorithm(new DfsAlgorithmGenerateMaze());
	}

}

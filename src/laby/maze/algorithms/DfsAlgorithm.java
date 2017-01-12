package laby.maze.algorithms;

import java.util.ArrayDeque;

import laby.maze.Cell;
import laby.maze.Maze;
import laby.maze.objects.MazeObject;

public class DfsAlgorithm implements IAlgorithm{
	ArrayDeque<Cell> path = null;
	
	@Override
	public void execute(MazeObject obj, Maze maze) {
		// Implementation de l'algorithme DFS
		path = new ArrayDeque<Cell>();
	}

}

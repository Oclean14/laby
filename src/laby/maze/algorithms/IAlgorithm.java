package laby.maze.algorithms;

import laby.maze.Maze;
import laby.maze.objects.MazeObject;

public interface IAlgorithm {
	void execute(MazeObject obj, Maze maze);
}

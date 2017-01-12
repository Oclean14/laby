package laby.maze.objects;

import laby.maze.algorithms.IAlgorithm;

public interface IMoveable {
	void moveLeft();
	void moveRight();
	void moveUp();
	void moveDown();
	void setAlgorithm(IAlgorithm algo);
}

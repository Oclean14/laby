package laby.maze.objects.interfaces;

public interface IMoveable {
	boolean move();
	boolean canMoveLeft();
	boolean canMoveRight();
	boolean canMoveUp();
	boolean canMoveDown();
}

package game;

public class GameOfLife {

	/* 	 * Conway's Game of Life
	 * * * Given a two-dimensional orthogonal grid of square cells, each of which is in one of two possible states, alive or
	 * * dead. Every cell interacts with its eight neighbours, which are the cells that are horizontally, vertically, or
	 * * diagonally adjacent. At each step in time, the following transitions occur:
	 * *   1. Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
	 * *   2. Any live cell with two or three live neighbours lives on to the next generation.
	 * *   3. Any live cell with more than three live neighbours dies, as if by overpopulation.
	 * *   4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
	 * * 	 * The rules are applied simultaneously to every cell in the seed, births and deaths occur simultaneously,
	 * and the  discrete moment at which this happens is called a tick. 	 * 	 */

	public static boolean[][] tick(boolean[][] universe) {
		boolean[][] result = new boolean[universe.length][universe[0].length];
		for (int j = 0; j < universe.length; j++) {
			for (int i = 0; i < universe[j].length ; i++) {
				int numberOfNeighbours = countNeighbours(j, i, universe);
				if (universe[j][i] && (numberOfNeighbours == 2 || numberOfNeighbours == 3)) {
					result[j][i] = true;
				}  else if (!universe[j][i] && numberOfNeighbours == 3) {
					result[j][i] = true;
				}
				}
		}
		return result;
	}

	private static int countNeighbours(int x, int y, boolean[][] universe) {
		int count = 0;
		if (x > 0 && y > 0 && universe[x - 1][y - 1]) {
			count++;
		}
		if (x > 0 && universe[x - 1][y]) {
			count++;
		}
		if (x > 0 && y < universe[x - 1].length - 1 && universe[x - 1][y + 1]) {
			count++;
		}
		if (y > 0 && universe[x][y - 1]) {
			count++;
		}
		if (y < universe[x].length - 1 && universe[x][y + 1]) {
			count++;
		}
		if (x < universe.length - 1 && y > 0 && universe[x + 1][y - 1]) {
			count++;
		}
		if (x < universe.length - 1 && universe[x + 1][y]) {
			count++;
		}
		if (x < universe.length - 1 && y < universe[x + 1].length - 1 && universe[x + 1][y + 1]) {
			count++;
		}
		return count;
	}
}

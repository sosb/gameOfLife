package game;

public class GameOfLife {

	public static boolean[][] tick(boolean[][] universe) {
		boolean[][] result = new boolean[universe.length][universe[0].length];
		for (int j = 0; j < universe.length; j++) {
			for (int i = 0; i < universe[j].length; i++) {
				int numberOfNeighbours = countNeighbours(j, i, universe);
				if (universe[j][i] && (numberOfNeighbours == 2 || numberOfNeighbours == 3)) {
					result[j][i] = true;
				} else if (!universe[j][i] && numberOfNeighbours == 3) {
					result[j][i] = true;
				}
			}
		}
		return result;
	}

	private static int countNeighbours(int x, int y, boolean[][] universe) {
		return countHorizontally(x, y, universe) + countVertically(x, y, universe) + countDiagonally(x, y, universe);
	}

	private static int countHorizontally(int x, int y, boolean[][] universe) {
		int count = 0;
		if (y > 0 && universe[x][y - 1]) {
			count++;
		}
		if (y < universe[x].length - 1 && universe[x][y + 1]) {
			count++;
		}
		return count;
	}

	private static int countVertically(int x, int y, boolean[][] universe) {
		int count = 0;
		if (x < universe.length - 1 && universe[x + 1][y]) {
			count++;
		}
		if (x > 0 && universe[x - 1][y]) {
			count++;
		}
		return count;
	}

	private static int countDiagonally(int x, int y, boolean[][] universe) {
		int count = 0;
		if (x > 0 && y > 0 && universe[x - 1][y - 1]) {
			count++;
		}

		if (x > 0 && y < universe[x - 1].length - 1 && universe[x - 1][y + 1]) {
			count++;
		}
		if (x < universe.length - 1 && y > 0 && universe[x + 1][y - 1]) {
			count++;
		}

		if (x < universe.length - 1 && y < universe[x + 1].length - 1 && universe[x + 1][y + 1]) {
			count++;
		}
		return count;
	}
}

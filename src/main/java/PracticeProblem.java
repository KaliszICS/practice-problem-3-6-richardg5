public class PracticeProblem {

	public static void main(String args[]) {

	}

	
	public static int searchMazeMoves(String[][] arr) {
		return dfs(arr, arr.length - 1, 0, 0, 0)[0];
	}

	public static int noOfPaths(String[][] arr) {
		return dfs(arr, arr.length - 1, 0, 0, 0)[1];
	}

	public static int[] dfs(String[][] arr, int row, int col, int steps, int pathCount) {
		if (row < 0 || col < 0 || row >= arr.length || col >= arr[row].length || arr[row][col].equals("*")) {
			return new int[]{-1, pathCount};
		} else if (arr[row][col].equals("F")) {
			return new int[]{steps, pathCount + 1};
		}

		int[] up = dfs(arr, row - 1, col, steps + 1, pathCount);
		int[] right = dfs(arr, row, col + 1, steps + 1, pathCount);
		if (up[0] == -1) {
			return right;
		} else if (right[0] == -1) {
			return up;
		}
		return new int[]{Math.min(up[0], right[0]), up[1] + right[1]};
	}
}
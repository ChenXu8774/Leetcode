class Solution {
    // TC: O(m*n). SC: O(min(m, n))
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
		int rows = matrix.length;
		int cols = matrix[0].length;
		helper(matrix, 0, rows, cols, res);
		return res;
    }
	private void helper(int[][] matrix, int offset, int sz1, int sz2, List<Integer> res) {
		if (sz1 == 0 || sz2 == 0) {
			return;
		}
		if (sz1 == 1) {
			for (int i = offset; i < offset + sz2; i++) {
				res.add(matrix[offset][i]);
			}
			return;
		}
		else if (sz2 == 1) {
			for (int i = offset; i < offset + sz1; i++) {
				res.add(matrix[i][offset]);
			}
			return;
		}
		for (int i = offset; i < offset + sz2; i++) {
			res.add(matrix[offset][i]);
		}
		for (int i = offset + 1; i < offset + sz1; i++) {
			res.add(matrix[i][offset + sz2 - 1]);
		}
		for (int i = offset + sz2 - 2; i >= offset; i--) {
			res.add(matrix[offset + sz1 - 1][i]);
		}
		for (int i = offset + sz1 - 2; i > offset; i--) {
			res.add(matrix[i][offset]);
		}
		helper(matrix, offset + 1, sz1 - 2, sz2 - 2, res);
	}
}
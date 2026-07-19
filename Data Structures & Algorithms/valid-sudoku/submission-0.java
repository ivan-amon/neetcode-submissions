class Solution {
    public boolean isValidSudoku(char[][] board) {
        return correctRows(board) && correctCols(board) && correctSqrs(board);
    }

    boolean correctRows(char[][] board) {
        for(int i = 0; i < 9; i++) {
            Set<Integer> row = new HashSet<>();
            for(int j = 0; j < 9; j++) {
                int num = toInt(board[i][j]);
                if(board[i][j] == '.') continue;
                if(row.contains(num)) return false;
                row.add(num);
            }
        }
        return true;
    }

    boolean correctCols(char[][] board) {
        for(int i = 0; i < 9; i++) {
            Set<Integer> col = new HashSet<>();
            for(int j = 0; j < 9; j++) {
                int num = toInt(board[j][i]);
                if(board[j][i] == '.') continue;
                if(col.contains(num)) return false;
                col.add(num);
            }
        }
        return true;
    }

    boolean correctSqrs(char[][] board) {
        Map<List<Integer>, Set<Integer>> sqrs = new HashMap<>();
        for(int i = 0; i <= 2; i++) {
            for(int j = 0; j <= 2; j++) {
                List<Integer> key = List.of(i, j);
                sqrs.put(key, new HashSet<>());
            }
        }

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                List<Integer> key = List.of((i/3), (j/3));
                Set<Integer> sqr = sqrs.get(key);

                int num = toInt(board[i][j]);
                if(board[i][j] == '.') continue;
                if(sqr.contains(num)) return false;
                sqr.add(num);
            }
        }
        return true;
    }

    int toInt(char c) { return c - '0'; }
}

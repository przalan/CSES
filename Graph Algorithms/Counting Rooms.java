import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter pw = new PrintWriter(System.out);

    static int[][] grid;
    static boolean[][] visited;
    static int rows;
    static int cols;
    static int count;

    public static void main(String[] args) {
        rows = scan.nextInt();
        cols = scan.nextInt();
        grid = new int[rows][cols];
        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            String line = scan.nextLine();
            for (int j = 0; j < cols; j++) {
                if (line.charAt(j) == '.') {
                    grid[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                    dfs(i, j);
                }
            }
        }
        pw.println(count);
        pw.close();
    }

    static void dfs(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] != 1 || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        dfs(row - 1, col);
        dfs(row + 1, col);
        dfs(row, col - 1);
        dfs(row, col + 1);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}

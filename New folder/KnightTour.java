class KnightTour {
    static int N = 8;
    static boolean Safe(int x, int y, int sol[][]) {
        return (x >= 0 && x < N && y >= 0 &&
                y < N && sol[x][y] == -1);
    }
    static void printSolution(int sol[][]) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }
    static boolean sKT() {
        int sol[][] = new int[8][8];
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                sol[x][y] = -1;
        int xM[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yM[] = {1, 2, 2, 1, -1, -2, -2, -1};
        sol[0][0] = 0;
        if (!solve(0, 0, 1, sol, xM, yM)) {
            System.out.println("Solution does not exist");
            return false;
        } else
            printSolution(sol);
 
        return true;
    }
    static boolean solve(int x, int y, int mi,
                               int sol[][], int xM[],
                               int yM[]) {
        int k, next_x, next_y;
        if (mi == N * N)
            return true;
        for (k = 0; k < 8; k++) {
            next_x = x + xM[k];
            next_y = y + yM[k];
            if (Safe(next_x, next_y, sol)) {
                sol[next_x][next_y] = mi;
                if (solve(next_x, next_y, mi + 1,
                                sol, xM, yM))
                    return true;
                else
                    sol[next_x][next_y] = -1;
            }
        }
 
        return false;
    }
    public static void main(String args[]) {
        sKT();
    }
}

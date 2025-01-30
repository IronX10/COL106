public class Maze {
    public boolean solve(char[][] maze) {
        int i = 0;
        int j = 0;
        boolean status = true;
        while (!(i >= maze.length || i < 0||j >= maze.length || j < 0)) {
            if (maze[i][j] == '0') {
                return false;
            }
            if (i == maze.length - 1 && j == maze.length - 1) {
                return true;
            }

            if (maze[i][j] == 'L') {
                maze[i][j] = '0';
                j += -1;
                i += 0;
                if (i >= maze.length || i < 0||j >= maze.length || j < 0) {
                return false;
            }
            }
            if (maze[i][j] == 'R') {
                maze[i][j] = '0';
                j += 1;
                i += 0;
                if (i >= maze.length || i < 0||j >= maze.length || j < 0) {
                return false;
            }
            }
            if (maze[i][j] == 'U') {
                maze[i][j] = '0';
                j += 0;
                i += -1;
                if (i >= maze.length || i < 0||j >= maze.length || j < 0) {
                return false;
            }
            }
            if (maze[i][j] == 'D') {
                maze[i][j] = '0';
                j += 0;
                i += 1;
                if (i >= maze.length || i < 0||j >= maze.length || j < 0) {
                return false;
            }
            }
            
        }
        return true;
    }

    public static void main(String[] args){
        char[][] maze = {
            {'R', 'D', 'R', 'R'},
            {'D', 'D', 'L', 'L'},
            {'R', 'R', 'D', 'D'},
            {'U', 'L', 'R', 'D'}
        };
        Maze m = new Maze();
        System.err.println(m.solve(maze));
    }
}
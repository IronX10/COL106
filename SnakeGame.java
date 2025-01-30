import java.util.Random;
import java.util.Scanner;

class node{
    int size;
    

    public node(){
        this.size = 1;
    }
}

public class SnakeGame {
    private int n; // Grid size
    private node snake; // Snake's body
    private int[] apple; // Apple position
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Right, down, left, up
    private int currentDirection = 0; // Start direction (0 = right)

    public SnakeGame(int n) {
        this.n = n;
        // Initialise Snake parameters, and initial apple position
        apple = new int[n];

    }

    

    // Function to generate a random apple position
    private void generateApple() {
        Random rand = new Random();
        int x, y;
        do {
            x = rand.nextInt(n) + 1;
            y = rand.nextInt(n) + 1;
        } while (isOccupiedBySnake(x, y)); // Ensure apple doesn't spawn on the snake
        this.apple = new int[]{x, y};
    }

    // TODO: Check if a position is occupied by the snake
    private boolean isOccupiedBySnake(int x, int y) {
        // Implement this
        if()
        return false;
    }

    // TODO: Implement the function to change the direction of the snake
    public void changeDirection(int newDirection) {
        // Ensure new direction is not directly opposite
        switch (newDirection) {
            case 0:
                
                break;
            default:
                throw new AssertionError();
        }
    }

    // TODO: Implement the function to move the snake
    public boolean moveSnake() {
        // Move the snake, grow if needed, and check for collisions
        return true; // Return false if collision occurs
    }

    // TODO: Implement collision detection logic
    private boolean isCollision(int newX, int newY) {
        // Check for boundary and self-collision
        return false;
    }

    // Print game state for debugging
    public void printState() {
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '.';
            }
        }
        grid[apple[0] - 1][apple[1] - 1] = 'A';
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SnakeGame game = new SnakeGame(5);
        boolean gameState = true;
        game.printState();
        while (gameState) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter direction (0 = right, 1 = down, 2 = left, 3 = up, any other number = exit): ");
            int direction = sc.nextInt();
            if (direction < 0 || direction > 3) {
                gameState = false;
                break;
            }
            game.changeDirection(direction);
            if (!game.moveSnake()) {
                System.out.println("Illegal move! Game Over.");
                gameState = false;
            }
            game.printState();
        }
    }
}

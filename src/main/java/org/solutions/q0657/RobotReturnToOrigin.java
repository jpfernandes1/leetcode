package org.solutions.q0657;

/*
    657. Robot Return to Origin

There is a robot starting at the position (0, 0), the origin, on a 2D plane. Given a sequence of its moves,
judge if this robot ends up at (0, 0) after it completes its moves. You are given a string moves that represents
the move sequence of the robot where moves[i] represents its ith move.

Valid moves are 'R' (right), 'L' (left), 'U' (up), and 'D' (down).

Return true if the robot returns to the origin after it finishes all of its moves, or false otherwise.
Note: The way that the robot is "facing" is irrelevant. 'R' will always make the robot move to the right once,
'L' will always make it move left, etc. Also, assume that the magnitude of the robot's movement is the same for each move.

Example 1:
Input: moves = "UD"
Output: true
Explanation: The robot moves up once, and then down once. All moves have the same magnitude, so it ended up at the origin
where it started. Therefore, we return true.

Example 2:
Input: moves = "LL"
Output: false
Explanation: The robot moves left twice. It ends up two "moves" to the left of the origin. We return false because it is
not at the origin at the end of its moves.

Constraints:
1 <= moves.length <= 2 * 104
moves only contains the characters 'U', 'D', 'L' and 'R'.

 */

public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int y = 0;
        int x = 0;

        for (int i = 0; i < moves.length(); i++){

            char c = moves.charAt(i);
            switch (c){
                case 'R':
                    x++;
                    break;
                case 'L':
                    x--;
                    break;
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
            }
        }
        return y == 0 && x == 0;
    }
}

/**
 *
 *# Intuition
 * The robot starts at the origin (0,0). Each move changes its position by exactly one unit along either the x-axis or the y-axis.
 *
 * To return to the origin:
 *   - Total right moves must cancel left moves.
 *   - Total up moves must cancel down moves.
 *
 * Therefore, instead of simulating the entire path or storing previous positions, we only need to track the net displacement along both axes.
 * If both displacements end at zero, the robot returned to the origin.
 *
 * # Approach
 * 1. Initialize two integer counters:
 * x for horizontal movement.
 * y for vertical movement.
 * 2. Iterate through the string once.
 * 3. For each character:
 * 'R' → increment x
 * 'L' → decrement x
 * 'U' → increment y
 * 'D' → decrement y
 *
 * 4. After processing all moves, check whether both x and y are zero.
 *
 * The solution avoids unnecessary object creation and processes the input in a single pass using primitive char comparisons.
 *
 * # Complexity
 * - Time complexity:
 * &&O(n)&& We traverse the string once, performing constant-time operations for each character.
 *
 * - Space complexity:
 * $$O(1)$$ Only two integer variables are used regardless of input size.
 *
 */

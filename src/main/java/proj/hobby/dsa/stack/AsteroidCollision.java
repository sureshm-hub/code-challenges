package proj.hobby.dsa.stack;
import java.util.*;

/**
 *
 * https://leetcode.com/problems/asteroid-collision/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: Stack
 *
 * Complexity:
 *  Time: O(N)
 *  Space: O(N)
 */
public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> belt = new Stack<>();
        for(int  currSize : asteroids) {
           boolean destroyed = false;
           while(!belt.isEmpty() && currSize < 0 && belt.peek() > 0) {
                int prevSize = belt.pop();
                if(Math.abs(prevSize) == Math.abs(currSize)){
                    destroyed = true;
                    break;
                }
                if(Math.abs(prevSize) > Math.abs(currSize)) {
                    belt.push(prevSize);
                    destroyed = true;
                    break;
                }
            }
            if(!destroyed) {
                belt.push(currSize);
            }
        }
        int[] result = new int[belt.size()];
        for(int i = belt.size()-1; i >= 0; i--) {
            result[i] = belt.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        AsteroidCollision ac = new AsteroidCollision();
        System.out.println("Asteroid Collision: "+Arrays.toString(ac.asteroidCollision(new int[]{5,10,-5})));
        System.out.println("Asteroid Collision: >"+Arrays.toString(ac.asteroidCollision(new int[]{8,-8})));
        System.out.println("Asteroid Collision: "+Arrays.toString(ac.asteroidCollision(new int[]{10,2,-5})));
        System.out.println("Asteroid Collision: "+Arrays.toString(ac.asteroidCollision(new int[]{1,2,2,3,-5,-1,-1,-1,10})));
        System.out.println("Asteroid Collision: "+Arrays.toString(ac.asteroidCollision(new int[]{1,2,2,3,5,10})));
        System.out.println("Asteroid Collision: "+Arrays.toString(ac.asteroidCollision(new int[]{})));
        System.out.println("Asteroid Collision: "+Arrays.toString(ac.asteroidCollision(new int[]{-8,-1,1,8})));
    }

}

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    //Returns the number of numbers that are divisible by "divisibility"
    //Example 1: nums = 1, 2, 3, 5, 6, 7; divisibility = 2; => 2 (2 and 6 are divisible by 2)
    //Example 2: nums = 8, 19, 27, 54, 31, 81; divisibility = 9; => 3

    public static int countMults(int[] nums, int divisibility) {
        int count = 0;
        for(int i=0; i<nums.length;i++) {
            if( nums[i]%divisibility == 0 ) {
                count++;
            }
        }
        return count;
    };

    //Returns true if the array contains three non-adjacent threes and no adjacent 3s
    //Returns false if it detects any adjacent 3s
    //Example 1: nums = 3, 1, 3, 1, 3; => true
    //Example 2: nums = 3, 1, 3, 1; => false
    //Example 3: nums = 3, 1, 3, 3; => false
    public static boolean hasThreeNonAdjacentThrees (int[] nums) {
        int threeCount = 0;

        boolean adjacent3 = false;
        for(int i=0; i<nums.length; i++) {
            if( nums[i] == 3) {
                threeCount++;
                if( i > 0 & i < nums.length-1 ) {
                    // check for 3 adj
                    if( nums[i-1] == 3 | nums[i+1] == 3 ) {
                        // we have an adjacent 3, we're done no matter what
                        return false;
                    }
                }
            }
        }
        if( threeCount == 3 ) {
            return true;
        } else {
            return false;
        }

    }

    //Returns true if all the letters in word are contained in letters
    //Order or frequency doesn't matter
    //Example 1: letters = "azzzaaataaaczzzc", word = "cat" => true
    //Example 2: letters = "abcdefghijklmnopqrstuvwxyz" word is anything => true
    //Example 3: letters = "azzzaaataaazzzzz" word = "cat", => false
    public static boolean containsString (char[] letters, String word) {
        boolean allFound = true;
        for(int i=0; i<word.length();i++) {
            boolean found = false;
            for(int j=0; j<letters.length;j++) {
                if( word.charAt(i) == letters[j] ) {
                    found = true;
                }
            }
            if(found == false) {
                allFound = false;
            }
        }
        return allFound;
    }

    public static void main(String[] args) {
        // TESTS
        int[] myArray = {1,2,3,4,5,6,7,8,9,10};
        if( countMults(myArray, 4) == 2) {
            System.out.println("SUCCESS");
        } else {
            System.out.println("FAILURE");
        }

        int[] arr1 = {3, 1, 3, 1, 3};
        int[] arr2 = {3, 1, 3, 1};
        int[] arr3 = {3, 1, 3, 3};

        System.out.println(hasThreeNonAdjacentThrees(arr1));
        System.out.println(hasThreeNonAdjacentThrees(arr2));
        System.out.println(hasThreeNonAdjacentThrees(arr3));

        char[] letters1 = {'a', 'b', 'c', 'd', 'e'};
        String word1 = "abcd";
        System.out.println(containsString(letters1, word1));

        char[] letters2 = {'a', 'b', 'd', 'd', 'f'};
        String word2 = "abc";
        System.out.println(containsString(letters2, word2));

        char[] letters3 = {'a', 'b', 'c', 'd', 'e'};
        String word3 = "zzzzz";
        System.out.println(containsString(letters3, word3));
    }
}

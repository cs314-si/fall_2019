/*
What are the choices?
What are the cells?

How do you "make a choice"
*/


public class Solution {
    public int[] crackSafe(Safe safe) {
        int[] blah = new int[safe.getPasswordLength()];
        // array list of length passwordLength of all 0's
        List<Integer> solution = Arrays.asList(blah);
        helper(safe, solution, 0);
        return solution;
    }

    public boolean helper(Safe safe, List<Integer> combo, int index) {
        if(safe.unlock()) {
            return true;
        }
        else if(index >= safe.getPasswordLength()) {
            // in this case we never found a password
            return false;
        }
        int maxEntryNumber = safe.getMaxEntryNumber();
        for(num = 0; num <= maxEntryNumber; num++) {
            safe.enterNumber(index, num);
            combo.set(index, num); 
            correctEntry = helper(safe, combo, index + 1);
            if(correctEntry)
                return true;
        }
        //combo.set(index, 0);
        //safe.enterNumber(index, 0);
        return false;
    }
}
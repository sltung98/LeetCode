package org.adamtungleetcode.arrayandhashing;
import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(new ContainsDuplicate().containsDuplicate(new int[]{1, 2, 3, 1}));
    }
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> numsSet = new HashSet<>();
        for (int i : nums) {
            if (numsSet.contains(i)) {
                return true;
            } else {
                numsSet.add(i);
            }
        }
        return false;
    }
}

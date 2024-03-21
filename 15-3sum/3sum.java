import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> triplets = new HashSet<>();

        // O(log n)
        Arrays.sort(nums);

        var positiveStartIndex = -1;
    
        // O(n)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                positiveStartIndex = i;
                break;
            }
        }

        if (positiveStartIndex == -1) {
            return new ArrayList<>();
        }

        // 3 zeros
        if (
            nums.length >= (positiveStartIndex + 3) && 
            nums[positiveStartIndex] == 0 && 
            nums[positiveStartIndex + 1] == 0 && 
            nums[positiveStartIndex + 2] == 0
        ) {
            triplets.add(List.of(0, 0, 0));
        }

        if (positiveStartIndex == 0) {
            return new ArrayList<>(triplets);
        }

        // O(n)
        // npn
        // npp
        // ppp == 000

        for (int i = 0; i < positiveStartIndex; i++) {
            
            final var firstValue = nums[i];

            if (i > 0 && firstValue == nums[i - 1]) {
                continue;
            }

            for (int j = positiveStartIndex; j < nums.length; j++) {
                
                final var secondValue = nums[j];

                if (j > positiveStartIndex && secondValue == nums[j - 1]) {
                    continue;
                }

                final var thirdValue = -(firstValue + secondValue);

                var searchIndexStart = 0;
                var searchIndexEnd = nums.length;

                if (thirdValue > 0) {
                
                    if (thirdValue >= secondValue) {
                        searchIndexStart = j + 1;    
                        searchIndexEnd = nums.length;
                    } else {
                        searchIndexStart = positiveStartIndex;
                        searchIndexEnd = j;
                    }

                    if (searchIndexStart < positiveStartIndex) {
                        continue;
                    }

                } else {

                    if (thirdValue >= firstValue) {
                        searchIndexStart = i + 1;    
                        searchIndexEnd = positiveStartIndex;
                    } else {
                        searchIndexStart = 0;
                        searchIndexEnd = i;
                    }
                }

                final var index = Arrays.binarySearch(nums, searchIndexStart, searchIndexEnd, thirdValue);
                final var thirdValueFound = index >= 0;
                
                if (!thirdValueFound) {
                    continue;
                }

                final var triplet = new ArrayList<Integer>(3);
                triplet.add(firstValue);
                triplet.add(secondValue);
                triplet.add(thirdValue);

                Collections.sort(triplet);

                triplets.add(triplet);
            }            
        }

        return new ArrayList<>(triplets);
    }
}
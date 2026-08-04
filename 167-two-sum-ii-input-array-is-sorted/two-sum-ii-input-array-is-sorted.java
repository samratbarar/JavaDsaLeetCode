class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int start = i + 1, end = numbers.length - 1;
            int firstNum = numbers[i];
            
            while (start <= end) {
                int mid = start + (end - start) / 2;
                int sum = firstNum + numbers[mid];

                if (sum == target && mid != i) {
                    return new int[] {i + 1, mid + 1};
                }

                if (sum > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return new int[] {-1, -1};
    }
}
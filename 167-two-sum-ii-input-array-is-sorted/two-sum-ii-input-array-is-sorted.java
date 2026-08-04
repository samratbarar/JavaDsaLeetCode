class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int firstNum = numbers[i];

            for (int j = i + 1; j < numbers.length; j++) {
                int sum = firstNum + numbers[j];

                if (sum == target) {
                    return new int[] {i + 1, j + 1};
                }

                if (sum > target) {
                    break;
                }
            }
        }

        return new int[] {-1, -1};
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> ans;
    HashMap<List<Integer>, List<TreeNode>> map;

    private void mapping(TreeNode node, int row, int col) {
        if (node == null) {
            return;
        }

        mapping(node.left, row + 1, col - 1);
        mapping(node.right, row + 1, col + 1);

        List<Integer> listK = new ArrayList<>();
        List<TreeNode> listV = new ArrayList<>();
        listK.add(row);
        listK.add(col);

        if (map.containsKey(listK)) {
            listV = map.get(listK);
        }
        listV.add(node);
        map.put(listK, listV);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        ans = new ArrayList<>();
        map = new HashMap<>();

        mapping(root, 0, 0);
        List<int[]> coordinates = new ArrayList<>();

        for (List<Integer> coordinate : map.keySet()) {
            int[] coordinateArr = new int[2];
            coordinateArr[0] = coordinate.get(0);
            coordinateArr[1] = coordinate.get(1);
            coordinates.add(coordinateArr);
        }

        coordinates.sort((a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(a[0], b[0]);
        });

        int prevCol = coordinates.get(0)[1];
        List<Integer> list = new ArrayList<>();

        for (int[] coordinate : coordinates) {
            if (prevCol == coordinate[1]) {
                List<Integer> listCoordinate = new ArrayList<>();
                listCoordinate.add(coordinate[0]);
                listCoordinate.add(coordinate[1]);

                List<TreeNode> listNodes = map.get(listCoordinate);
                listNodes.sort((a, b) -> Integer.compare(a.val, b.val));
                for (TreeNode node : listNodes) {
                    list.add(node.val);
                }
            } else {
                ans.add(list);
                list = new ArrayList<>();
                List<Integer> listCoordinate = new ArrayList<>();
                listCoordinate.add(coordinate[0]);
                listCoordinate.add(coordinate[1]);

                List<TreeNode> listNodes = map.get(listCoordinate);
                listNodes.sort((a, b) -> Integer.compare(a.val, b.val));
                for (TreeNode node : listNodes) {
                    list.add(node.val);
                }
            }

            prevCol = coordinate[1];
        }
        
        ans.add(list);

        return ans;
    }
}
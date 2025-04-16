import java.util.*;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {


        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        helper(root, map, 0, 0);

        List<Integer> columns = new ArrayList<>(map.keySet());
        Collections.sort(columns);

        for(int key: columns){
            List<int[]> elements = map.get(key);
            elements.sort((a,b) -> a[0] == b[0] ? Integer.compare(a[1],b[1]) : Integer.compare(a[0],b[0]));
            List<Integer> temp = new ArrayList<>();
            for(int [] pair : elements){
                temp.add(pair[1]);
            }
            result.add(temp);
        }
        return result;

    }

    private void helper(TreeNode root, HashMap<Integer, List<int[]>> map, int index, int row){
        if(root == null){
            return;
        }
        map.putIfAbsent(index, new ArrayList<>());
        map.get(index).add(new int[]{row, root.val});
        helper(root.left, map, index-1,row+1);
        helper(root.right, map, index+1, row+1);
    }
}

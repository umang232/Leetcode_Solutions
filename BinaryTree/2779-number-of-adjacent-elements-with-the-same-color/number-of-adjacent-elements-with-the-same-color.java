class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int result[] = new int[queries.length];
        int ans = 0;
        int colors[] = new int[n];
        int i=0;
        for(int[] q:queries){
            int index = q[0];
            int color = q[1];
            if(colors[index] == 0){
                colors[index] = color;
                if(index > 0 && colors[index] == colors[index-1]){
                    ans++;
                }
                if(index + 1 < n && colors[index] == colors[index+1]){
                    ans++;
                }
            }else{
                if(index > 0 && colors[index] == colors[index-1]){
                    ans--;
                }
                if(index +1 < n && colors[index] == colors[index+1]){
                    ans--;
                }
                colors[index] = color;
                if(index > 0 && colors[index] == colors[index-1]){
                    ans++;
                }
                if(index +1 < n && colors[index] == colors[index+1]){
                    ans++;
                }
            }
            result[i]= ans;
            i++;
        }
        return result;
    }
}
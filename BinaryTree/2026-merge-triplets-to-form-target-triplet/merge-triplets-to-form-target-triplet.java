class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for(int i=0;i<triplets.length;i++){
            if(triplets[i][0] <= target[0] && triplets[i][1] <= target[1] && triplets[i][2] <= target[2]){
                if(triplets[i][0] == target[0]) count1 =1;
                if(triplets[i][1] == target[1]) count2 =1;
                if(triplets[i][2] == target[2]) count3 =1;
                if(count1 == 1 && count2 ==1 && count3 == 1){
                    return true;
                }
            }
        }
        return false;
    }
}
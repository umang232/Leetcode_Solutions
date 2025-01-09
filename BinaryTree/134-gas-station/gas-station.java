class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totGas = 0;
        int totCost = 0;
        int curGas = 0;
        int start = 0;
        for(int i=0;i<gas.length;i++){
            totGas += gas[i];
            totCost += cost[i];
            curGas += gas[i] - cost[i];
            if(curGas < 0){
                start = i+1;
                curGas = 0;
            }
        }
        return totGas>=totCost ? start:-1;
    }
}
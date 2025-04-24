class Solution {
    public int numberOfMatches(int n) {
        if(n == 1){
            return 0;
        }
        int matches = 0;
        while(n>1){
            if(n%2 == 0){
                matches += n/2;
                n = n/2;
            }else{
                matches += (n-1)/2;
                n = (n+1)/2;
            }
        }
        return matches;
    }
}
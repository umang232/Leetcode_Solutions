class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(true){
            int cur=0;
            while(n!=0){
                int temp = n%10;
                cur += temp*temp;
                n = n/10;
            }
            if(cur == 1){
                return true;
            }else{
                if(set.contains(cur)){
                    return false;
                }else{
                    set.add(cur);
                    n = cur;
                }
            }
            
        }
    }
}
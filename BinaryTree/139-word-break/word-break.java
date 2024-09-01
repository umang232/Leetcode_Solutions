class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length()+1];
        dp[s.length()] = true;
        for(int i = s.length()-1;i>=0;i--){
            for(String word : wordDict){
                System.out.println(s.substring(i,s.length()).length());

                if(s.substring(i,s.length()).length() >= word.length() && s.substring(i,i + word.length()).equals(word)){
                    System.out.println("Here");
                    dp[i] = dp[i+word.length()];
                    if(dp[i]) break;
                }
            }
            System.out.println(dp[i]);
        }
        return dp[0];
    }
}
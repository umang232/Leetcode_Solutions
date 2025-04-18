import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs = new HashSet<>(wordList);
        if(!hs.contains(endWord)){
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        while(!queue.isEmpty()){
            int s = queue.size();
            for(int i=0;i<s;i++){
                String cur_word = queue.poll();
                char[] wordChars = cur_word.toCharArray();
                for(int j=0;j<cur_word.length();j++){
                    char orig = wordChars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordChars[j] = c;
                        String newWord = new String(wordChars);
                        if (newWord.equals(endWord)) return level + 1;
                        if(hs.contains(newWord)){
                            queue.offer(newWord);
                            hs.remove(newWord);
                        }
                    }
                    wordChars[j] = orig;
                }
            }
            level++;
        }
        return 0;

    }
}

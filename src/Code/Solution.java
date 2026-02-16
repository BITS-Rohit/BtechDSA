package Code;

import java.util.Arrays;

class Solution {

    static class Tnode {
        Tnode[] child = new Tnode[26];
        boolean isend = false;
    }

    static class Trie {
        Tnode root = new Tnode();

        void insert(String s) {
            Tnode node = root;
            for (char c : s.toCharArray()) {
                int idx = c - 'a';
                if (node.child[idx] == null) node.child[idx] = new Tnode();
                node = node.child[idx];
            }
            node.isend = true;
        }

        boolean search(String s){
            Tnode node = root;
            if(node.child[s.charAt(0)-'a']==null)return false;
            node=node.child[s.charAt(0)-'a'];
            for(int i =1 ; i< s.length(); i++){
                int idx = s.charAt(i)-'a';
                if(node.child[idx]==null || !node.isend)return false;
                node = node.child[idx];
            }
            return true;
        }
    }

    public String longestWord(String[] words) {
        Trie t = new Trie();

        for(String w : words)t.insert(w);

        Arrays.sort(words, (a, b)-> b.length()-a.length());
        String ans ="";
        for(String w : words){
            if(t.search(w)){
                if(ans.isEmpty())ans = w;
                else {
                    if(ans.length()<w.length())ans=w;
                    else if(ans.length()==w.length()){
                        if(ans.compareTo(w)<0)ans = w;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestWord(new String[]{"w","wo","wor","worl","world"}));
    }
}





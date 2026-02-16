package Code;

import java.util.Arrays;
import java.util.List;

public class L_DP {
    ////////////////////////////
    public int perfectSum(int[] nums, int target) {
        if (nums.length == 1) return target == nums[0] ? 1 : 0;
        return Prec(nums, target, nums.length - 1);
    }

    int Prec(int[] nums, int target, int idx) {
        if (idx == 0) return target == nums[idx] ? 1 : 0;
        if (target == 0) return 1;

        int pick = 0;
        if (nums[idx] <= target) {
            pick = Prec(nums, target - nums[idx], idx - 1);
        }
        int npick = Prec(nums, target, idx - 1);
        return pick + npick;
    }

    ///////////////////////////////////////////
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] prev = new int[amount + 1];
        for (int j = 0; j < amount + 1; j++) {
            if (j % coins[0] == 0) {
                prev[j] = j / coins[0];
            } else prev[j] = (int) (1e9);
        }

        for (int i = 1; i < coins.length; i++) {
            int[] cur = new int[amount + 1];
            for (int j = 0; j < amount + 1; j++) {
                int pick = (int) (1e9);
                if (coins[i] <= j) {
                    pick = 1 + cur[j - coins[i]];
                }
                int npick = prev[j];
                cur[j] = Math.min(pick, npick);
            }
            prev = cur;
        }
        return prev[amount] == (int) (1e9) ? -1 : prev[amount];
    }

    /////////////////////////////////////////////
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) for (int j = 0; j < text2.length(); j++) dp[i][j] = -1;
        return rec(text1, text2, 0, 0, dp);
    }

    int rec(String t1, String t2, int i, int j, int[][] dp) {
        if (i == t1.length() || j == t2.length()) return 0;

        if (dp[i][j] != -1) return dp[i][j];
        int pick = 0;
        if (t1.charAt(i) == t2.charAt(j)) {
            pick = 1 + rec(t1, t2, i + 1, j + 1, dp);
        }
        int npick1 = rec(t1, t2, i + 1, j, dp);
        int npick2 = rec(t1, t2, i, j + 1, dp);
        dp[i][j] = Math.max(npick1, Math.max(pick, npick2));
        return dp[i][j];
    }

    ////////////////////////////////////////
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return nums.length;
        int n = nums.length;
        int[][] dp = new int[n + 1][n];
        return lengthrec(nums, -1, 0, dp);
    }

    private int lengthrec(int[] arr, int previ, int i, int[][] dp) {
        if (i == arr.length) return 0;
        if (dp[previ + 1][i] != 0) return dp[previ + 1][i];
        int pick = 0;
        if (previ == -1 || arr[i] > arr[previ]) pick = 1 + lengthrec(arr, i, i + 1, dp);
        int npick = lengthrec(arr, previ, i + 1, dp);
        dp[previ + 1][i] = Math.max(pick, npick);
        return dp[previ + 1][i];
    }

    //////////////////////////////////////////
    public int maxRepeating(String sequence, String word) {
        StringBuilder s = new StringBuilder(word);
        boolean check = true;
        while (check) {
            s.append(word);
            check = sequence.contains(s.toString());
        }
        return s.length();
    }

    //////////////////////////////////////////////
    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];
        int i = 0;
        int y = s.length() - 1;
        lcs(s, i, y, dp);
        for (int[] ch : dp) System.out.println(Arrays.toString(ch));
        System.out.println("i: " + i + " y: " + y);

        return recons(s, dp);
    }

    private int lcs(String s1, int i, int y, int[][] dp) {
        if (i > y) return 0;
        if (i == y) return 1;

        if (dp[i][y] != 0) return dp[i][y];

        if (s1.charAt(i) == s1.charAt(y)) return 2 + lcs(s1, i + 1, y - 1, dp);
        else dp[i][y] = Math.max(lcs(s1, i + 1, y, dp), lcs(s1, i, y - 1, dp));

        return dp[i][y];
    }

    private String recons(String s, int[][] dp) {
        StringBuilder st = new StringBuilder();
        int i = 0;
        int y = s.length() - 1;
        while (i <= y) {
            if (s.charAt(i) == s.charAt(y)) {
                st.append(s.charAt(i));
                i++;
                y--;
            } else if (dp[i + 1][y] >= dp[i][y - 1]) i++;
            else y--;
        }
        String secondHalf = st.reverse().toString();
        st.reverse();
        if (i - 1 == y) return st + secondHalf.substring(1);
        return st + secondHalf;
    }

    /////////////////////////////////////
    public boolean canJump(int[] nums) {
        return recj(nums, 0);
    }

    boolean recj(int[] nums, int i) {
        if (i == nums.length - 1) return true;
        if (nums[i] == 0) return false;
        boolean c = false;
        for (int y = 1; y <= nums[i]; y++) {
            c = c || recj(nums, i + y);
        }
        return c;
    }
//////////////////////////////////////////
//    public int countDigitOne(int n) {
//        if (n==0|| n==1)return n;
//        int num=n;
//        if(n%2==0)num=n-1;
//        int[][] dp = new int[n+1][String.valueOf(n).length()];
//        for (int i = 0; i < n + 1; i++) {
//            for (int j = 0; j < String.valueOf(n).length(); j++) {
//                dp[i][j]=-1;
//            }
//        }
//        return  n%2==0 ? rc(1,num,dp,1) + getnumcount(n,1) : rc(1,num,dp,1);
//    }

    public int countDigitOne(int n) {
        int count = 0;
        int fac = 1;
        while (fac <= n) {
            int h = n / (fac * 10);
            int c = (n / fac) % 10;
            int l = n % fac;

            if (c == 0) count += h * fac;
            else if (c == 1) count += h * fac + l + 1;
            else count += (h + 1) * fac;

            fac = fac * 10;
        }
        return count;
    }

    private int rc(int s, int e, int[][] dp, int t) {
        if (s == e) {
            dp[s][e] = getnumcount(s, t);
            return dp[s][e];
        }
        if (Math.abs(s - e) == 1) {
            dp[s][e] = getrangecount(s, e, t);
        }

        if (dp[s][e] != -1) return dp[s][e];
        int diff = (e - s) / 2;
        int c1 = rc(s, s + diff, dp, t);
        int c2 = rc(diff + 1, e, dp, t);

        dp[s][e] = c1 + c2;
        return dp[s][e];
    }

    private int getrangecount(int s, int e, int target) {
        int c = 0;
        for (int i = s; i <= e; i++) {
            c += getnumcount(i, target);
        }
        return c;
    }

    private int getnumcount(int num, int target) {
        int c = 0;
        while (num > 0) {
            if (num % 10 == target) c++;
            num /= 10;
        }
        return c;
    }

    ///////////////////////////////
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, checSQ(matrix, i, j, dp));
            }
        }
        return max * max;
    }

    private int checSQ(char[][] matrix, int i, int j, int[][] dp) {
        if (i < 0 || j < 0 || matrix[i][j] == '0') return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int top = checSQ(matrix, i - 1, j, dp);
        int left = checSQ(matrix, i, j - 1, dp);
        int diag = checSQ(matrix, i - 1, j - 1, dp);

        dp[i][j] = 1 + Math.min(top, Math.min(left, diag));
        return dp[i][j];
    }

    //////////////////////////////////
//    public int numDecodings(String s) {
//        return recnum(s,"",0);
//    }

//    private int recnum(String s, String p, int i) {
//        return 0;
//    }

    ///////////////////////////////////
    public int checkRecord(int n) {
        int MOD = 1000000007;
        int[][][] dp = new int[n + 1][2][3];
        dp[0][0][0] = 1;
        for (int len = 0; len < n; len++) {
            for (int ac = 0; ac <= 1; ac++) {
                for (int lc = 0; lc <= 2; lc++) {
                    dp[len + 1][ac][0] = (dp[len + 1][ac][0] + dp[len][ac][lc]) % MOD;
                    if (ac < 1) {
                        dp[len + 1][ac + 1][0] = (dp[len + 1][ac + 1][0] + dp[len][ac][lc]) % MOD;
                    }
                    if (lc < 2) {
                        dp[len + 1][ac][lc + 1] = (dp[len + 1][ac][lc + 1] + dp[len][ac][lc]) % MOD;
                    }
                }
            }
        }
        int count = 0;
        for (int ac = 0; ac <= 1; ac++) {
            for (int lc = 0; lc <= 2; lc++) {
                count = (count + dp[n][ac][lc]) % MOD;
            }
        }
        return count;
    }
    //=================Memoization=============================
//    public int checkRecord(int n) {
//        if (n == 1) return 3;
//        int[][][] dp = new int[n + 1][2][3];
//        final int mod = 1000000007;
//        for (int i = 0; i <= n; i++)
//            for (int j = 0; j < 2; j++)
//                for (int k = 0; k < 3; k++) dp[i][j][k] = -1;
//        return rcheck(0, n, 0, 0, dp, mod);
//    }
//
//    private int rcheck(int len, int n, int ac, int lc, int[][][] dp, int mod) {
//        if (len == n) return (ac == 2 || lc == 3) ? 0 : 1;
//
//        if (dp[len][ac][lc] != -1) return dp[len][ac][lc];
//        int count = 0;
//        count += rcheck(len + 1, n, ac, 0, dp, mod);
//        count%=mod;
//        if (ac < 1) {
//            count += rcheck(len + 1, n, ac + 1, 0, dp, mod);
//            count%=mod;
//        }
//        if (lc < 2){
//            count += rcheck(len + 1, n, ac, lc + 1, dp, mod);
//            count%=mod;
//        }
//        dp[len][ac][lc] = count;
//
//        return count;
//    }

    ///////////////////////////////////
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int min = Integer.MAX_VALUE, max = 0;
        for (int price : prices) {
            if (price < min) min = price;
            if (price - min > max) max = price - min;
        }
        return max;
    }

    ///////////////////////////////////

    //-----------------Tabulation-----------------------------
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==1)return triangle.get(0).get(0);
        int[][]dp= new int[triangle.size()][triangle.size()];
        int n=triangle.size();
        for(int i =0;i<triangle.get(n-1).size(); i++){
            dp[n-1][i]=triangle.get(n-1).get(i);
        }
        for(int i=n-2;i>=0;i--){
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int pick1 =dp[i+1][j];
                int pick2 =dp[i+1][j+1];

                dp[i][j]=triangle.get(i).get(j)+Math.min(pick1,pick2);
            }
        }
        return dp[0][0];
    }

    //-----------------Memoization----------------------------
//    public int minimumTotal(List<List<Integer>> triangle) {
//        if(triangle.size()==1)return triangle.get(0).get(0);
//        int[][]dp= new int[triangle.size()][triangle.size()];
//        return recmini(triangle,0,0,dp);
//    }
//
//    private int recmini(List<List<Integer>> triangle, int r,int j , int[][]dp) {
//        if(r==triangle.size()-1)return triangle.get(r).get(j);
//
//        if(dp[r][j]!=0)return dp[r][j];
//        int pick1 =recmini(triangle,r+1,j,dp);
//        int pick2 =recmini(triangle,r+1,j+1,dp);
//
//        dp[r][j]=triangle.get(r).get(j)+Math.min(pick1,pick2);
//        return dp[r][j];
//    }
    //-----------------Naive Approach-------------------------
//    public int minimumTotal(List<List<Integer>> triangle) {
//        if(triangle.size()==1)return triangle.get(0).get(0);
//        return recmini(triangle,0,0);
//    }
//
//    private int recmini(List<List<Integer>> triangle, int r,int j) {
//        if(r>=triangle.size())return 0;
//        if(j>=triangle.get(r).size())return 0;
//
//        int pick1 =r+1 <triangle.size() ?recmini(triangle,r+1,j) : 0;
//        int pick2 =r+1 <triangle.size() && j+1<triangle.get(r).size() ?recmini(triangle,r+1,j+1) : 0;
//
//        return triangle.get(r).get(j)+Math.min(pick1,pick2);
//    }
    ///////////////////////////////////
//    public int maxCollectedFruits(int[][] fruits) {
//
//    }
    ///////////////////////////////////

    public static void main(String[] args) {
        L_DP dp = new L_DP();
        System.out.println(dp.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
//        System.out.println(dp.checkRecord(10101));
        //183236316
//        System.out.println(dp.countDigitOne(13));
//        int[] arr = {2,3,1,1,4};
//        System.out.println(dp.canJump(arr));
//        System.out.println(dp.longestPalindrome("babad"));
//        System.out.println(dp.lengthOfLIS(arr));
//        System.out.println(dp.longestCommonSubsequence("abc", "abc"));
    }
}

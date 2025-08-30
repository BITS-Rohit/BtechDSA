package btech.CODE;

import java.util.HashMap;
import java.util.Map;

public class NummberofWIningPlayers {
    
    // n = 4 , pick = [ [0,0] , [1,0] , [1,0] , [2,1] , [2,1] , [2,0] ]
    public int winningPlayerCount(int n, int[][] pick) {
        int count  = 0 ;
        HashMap<Integer,Integer> m  =new HashMap<>();
        for (int[] digit : pick){
            m.put(digit[0],m.getOrDefault(digit[0],0)+digit[1]);
        }
        for (Map.Entry<Integer,Integer> map : m.entrySet()){
            if (map.getValue().equals(map.getKey())){
                count++;
            }
        }
        return count;
    }
}

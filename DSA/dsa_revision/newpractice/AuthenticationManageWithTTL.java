package dsa_revision.newpractice;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationManageWithTTL {
     int ttl;
    Map<String,Integer> tokens;

    public AuthenticationManager(int timeToLive) {
        this.ttl = timeToLive;
        tokens = new HashMap<>();
    }
    
    public void generate(String tokenId, int currentTime) {
        tokens.put(tokenId, ttl+currentTime);
    }
    
    public void renew(String tokenId, int currentTime) {
        if(tokens.containsKey(tokenId) && tokens.get(tokenId)>currentTime){
         tokens.put(tokenId, currentTime+ttl);
        }
        // else tokens.remove(tokenId);
    }
    
    public int countUnexpiredTokens(int currentTime) {
        Collection<Integer> set = tokens.values();
        int cnt = 0;
        for(int i : set){
            if(i>currentTime) cnt++;
        }
        return cnt;
    }
}

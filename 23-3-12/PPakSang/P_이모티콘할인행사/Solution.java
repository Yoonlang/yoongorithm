/*
할인율 넘으면 산다
만원 넘으면 가입한다

할인율 조합 -> 비용 계산

*/
class Solution {
    int[] discV = new int[]{10, 20, 30, 40};
    
    int[][] users;
    int[] emoticons;
    
    int answerCnt = 0;
    int answerSell = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        this.users = users;
        this.emoticons = emoticons;
        int[] disc = new int[emoticons.length];
        
        permutation(0, emoticons.length, disc);
        return new int[]{answerCnt, answerSell};
    }
    
    void permutation(int cur, int max, int[] disc) {
        if (cur == max) {
            play(disc);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            disc[cur] = discV[i];
            permutation(cur+1, max, disc);
        }
    }
    
    void play(int[] disc) {
        int[] emoticonsV = new int[emoticons.length];
        for (int i = 0; i < emoticons.length; i++) {
            emoticonsV[i] = emoticons[i]/100 * (100-disc[i]);
        }
        
        int cnt = 0;
        int sell = 0;
        for (int[] user : users) {
            int discU = user[0];
            int priceU = user[1];
            
            int total = 0;
            for (int i = 0; i < emoticons.length; i++) {
                if (disc[i] >= discU) {
                    total += emoticonsV[i];
                }
            }
            
            if (total >= priceU) {
                cnt++;
            } else {
                sell += total;
            }
        }
        
        if (answerCnt < cnt) {
            answerCnt = cnt;
            answerSell = sell;
        } else if (answerCnt == cnt) {
            if (answerSell < sell) {
                answerSell = sell;
            }
        }
    }
}
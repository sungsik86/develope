import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> answerList = new ArrayList<>();
        for (int a : arr){
            for(int i = 0 ; i < a ; i++){
                answerList.add(a);
            }
        }
        
        int[] answer = new int[answerList.size()];
        int k = 0;
        for(int j : answerList){
            answer[k] = j;
            k++;
        }
        return answer;
    }
}

import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> answerList = new ArrayList<>();
        int j =0;
        int i =0;
        
        try {
            for(int a : num_list){
                //if()
                answerList.add(num_list[i]);
                i +=n;
                j++;
            }
        } catch (Exception e) {
            
        }finally{
            int[] answer = new int[j];
            int k= 0;
            for(int a : answerList){
                answer[k]=a;
                k++;
            }
            return answer;    
        }
    }
}

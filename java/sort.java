import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
class Solution {
    public int[] solution(int[] num_list) {
        
        
		ArrayList<Integer> list = new ArrayList<>();
		int[]deleteList = new int[5];
        for (int a : num_list){
            list.add(a);
        }
		
		// 오름차순 정렬
		Collections.sort(list);
		
		// 내림차순 정렬
		//Collections.sort(list, Collections.reverseOrder());
		int q = 0;
        for(int delNum : list){
            if(q == 5){
                break;
            }
            deleteList[q] = delNum;
            q++;
        }
        
        for (int delNum : deleteList){
            list.remove(Integer.valueOf(delNum));
        }

        int[] answer = new int[list.size()];
        
        for(int k = 0; k < answer.length; k++){
            answer[k] = list.get(k);
        }
        return answer;
    }
}

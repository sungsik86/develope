import java.util.*;

class Solution {
    public String[] solution(String[] names) {
        List<String> strList = new ArrayList<>();
        int i = 0;
        for(String a : names){
            if(i == 0 || i%5 == 0 ){
                strList.add(a);
            }
            i++;
        }
        String[] answer = new String[strList.size()];
        answer = strList.toArray(answer);
        return answer;
    }
}

import java.util.*;
//입력된 String 과 index로 문자 재 조합
class Solution {
    public String solution(String my_string, int[] index_list) {
        String answer = "";
        
        char [] myString = new char[my_string.length()];
        for(int i =0 ; i < myString.length ; i++){
            System.out.print(my_string.charAt(i));
            myString[i] = my_string.charAt(i);
        }
        
        for(int a : index_list){
            char k = myString[a];
            answer += k;
        }
        return answer;
    }
}

import java.util.*;

class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = "";
        char[] strToChar = new char[my_string.length()];
        List<Character> charList = new ArrayList<>();
        
        
        for(int i=0;i<my_string.length();i++){
            strToChar[i] = my_string.charAt(i);
        }
        
        for(int j = s; j <= e ; j++){
            charList.add(strToChar[j]);
        }

      //문자열 반전 부분
        Collections.reverse(charList);
        System.out.print(charList);
        
        int q = 0;
        for(int k = s; k <= e ; k++){
            strToChar[k] = charList.get(q);
            q++;
        }

        
        for(char a : strToChar){
            answer += a;
        }
        return answer;
    }
}

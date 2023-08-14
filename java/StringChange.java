class Solution {
    public String solution(String my_string, int n) {
        String answer = my_string.substring(my_string.length()-n, my_string.length());
        return answer;
    }
}

/*
indexOf(String a) = a의 문자의 위치 값을 숫자를 얻는다. 

lastindexOf(String a) =  a 문자를 뒤에서부터 찾아 위치 값 숫자를 얻는다.

subString(a, b) = a부터 b전까지의 위치의 문자열을 가져온다.

String substring(int index) = 문자열 index위치부터 끝까지 문자열.

  EX )    "자바 코딩 배우자". substring(4)  => 배우자

String substrnig(int a, int b) = 현재 문자열 객체에서 a부터 b 직전까지 문자열

Char charAt(int index) = String 문자열에서 index 번째 문자 값 1개를 가져온다.

int indexOf(String str) = 문자열 str를 찾아서 존재하면 첫째 문자 위치 값을 반환, 없으면 -1을 반환한다.
*/

// 구분자로 자르기 .split("")
import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        String[] answer =my_string.split(" ");
        
        return answer;
    }
}

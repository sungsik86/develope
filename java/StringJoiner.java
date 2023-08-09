import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        String[] answer ={};
        //구분자를 이용해서
        StringJoiner sj = new StringJoiner(" ");

        sj.add(first);
        sj.add(second);
        sj.add(third);
        sj.add(fourth);
        sj.add(fifth);
        String sjString = sj.toString();
        System.out.println(sjString);
// first second third ...

        StringJoiner sj = new StringJoiner("-", "[", "]");
        sj.add(first);
        sj.add(second);
        sj.add(third);
        sj.add(fourth);
        sj.add(fifth);
        String sjString = sj.toString();
        System.out.println(sjString);
// [first-second-third...]
        return answer;
    }
}

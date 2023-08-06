class Solution {
    public String solution(String myString) {
        String answer = "";
        char[] a = new char[myString.length()];
        for(int i =0 ; i < myString.length(); i++){
            if('a' == myString.charAt(i) || 'A' == myString.charAt(i)){
                a[i] = Character.toUpperCase(myString.charAt(i));
            }else{
                a[i] = Character.toLowerCase(myString.charAt(i));
            }            
        }
        for(char k : a){
            answer += k;
        }
        
        return answer;
    }
}
/*
내장함수

String 대문자로 변환 : toUpperCase()
String 소문자로 변환 : toLowerCase()
Char 대문자로 변환 : Character.toUpperCase(변환을 원하는 단어)
Char 소문자로 변환 : Character.toLowerCase(변환을 원하는 단어)


*/

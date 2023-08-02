class Solution {
    public int solution(String number) {
        int answer = 0;
        int[] num = new int[number.length()];
        
        for(int i =0 ; i < number.length(); i++){
            //String -> charAt()으로 char 변환
            //Character.getNumericValue()로 integer 변환(그냥 대입시 1 = 49 로변환됨(아스키코드))
          
            num[i] = Character.getNumericValue(number.charAt(i));

        }

        return answer;
    }
}

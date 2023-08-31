class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        String myStringVer2 = "";
        String[] myStringList = myString.split("");
        for(int i = 0; i<myStringList.length; i++){
            if(myStringList[i].equals("A")){
                myStringList[i]="B";
            }
            else if(myStringList[i].equals("B")){
                myStringList[i]="A";
            }
            myStringVer2+=myStringList[i];
        }
        if(myStringVer2.contains(pat)){
            answer = 1;
        }
        return answer;
    }
}

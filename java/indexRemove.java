public static void main(String args[]) {
  String[] strArray = { "10", "20", "30", "40", "50", "60", "70" };

  System.out.println("2번째 인덱스의 요소 삭제 전: " + Arrays.toString(strArray));

  String[] newArray = IntStream.range(0, strArray.length)
                               .filter(idx -> idx != 2)
                               .mapToObj(idx -> strArray[idx])
                               .toArray(String[]::new);

  System.out.println("2번째 인덱스의 요소 삭제 후: " + Arrays.toString(newArray));
}

/*
2번째 인덱스의 요소 삭제 전: [10, 20, 30, 40, 50, 60, 70]
2번째 인덱스의 요소 삭제 후: [10, 20, 40, 50, 60, 70]
*/

public static void main(String args[]) {
  String[] strArray = { "10", "20", "30", "40", "50", "60", "70" };

  System.out.println("2번째 인덱스의 요소 삭제 전: " + Arrays.toString(strArray));

  List<String> strList = new ArrayList<>(Arrays.asList(strArray));
  strList.remove(2);
  strArray = strList.toArray(new String[0]);

  System.out.println("2번째 인덱스의 요소 삭제 후: " + Arrays.toString(strArray));
}

/*
2번째 인덱스의 요소 삭제 전: [10, 20, 30, 40, 50, 60, 70]
2번째 인덱스의 요소 삭제 후: [10, 20, 40, 50, 60, 70]
*/

public static void main(String args[]) {
  String[] srcArray = { "10", "20", "30", "40", "50", "60", "70" };
  String[] destArray = new String[srcArray.length - 1];
  int removeIndex = 2;

  System.out.println("2번째 인덱스의 요소 삭제 전: " + Arrays.toString(srcArray));

  System.arraycopy(srcArray, 0, destArray, 0, removeIndex);
  System.out.println("0부터 2번째 인덱스까지 복사: " + Arrays.toString(destArray));

  System.arraycopy(srcArray, removeIndex + 1, destArray, removeIndex, srcArray.length - removeIndex - 1);
  System.out.println("나머지 값을 복사: " + Arrays.toString(destArray));
}

/*
2번째 인덱스의 요소 삭제 전: [10, 20, 30, 40, 50, 60, 70]
0부터 2번째 인덱스까지 복사: [10, 20, null, null, null, null]
나머지 값을 복사: [10, 20, 40, 50, 60, 70]
*/

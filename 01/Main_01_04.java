public class Main_01_04 {

  // N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
  static String solution(String input) {
    String answer = "";
    
    String[] strArr = input.split("");

    for(int i = strArr.length - 1; i > -1; i--) {
      answer += strArr[i];
    }
    
    return answer;
  }

  // String을 계속 생성하면 메모리를 많이 잡아먹으니까 StringBuilder 사용.
  static String anotherSolution1(String input) {
    return new StringBuilder(input).reverse().toString();
  }
  
  // reverse 직접 구현하기
  // s t u d y 에서 제일 왼쪽 s, 제일 오른쪽 y 를 바꾸며 한쪽식 안으로 들어가는 로직으로 한다..
  static String anotherSolution2(String input) {
    char[] charArr = input.toCharArray();
    int lt = 0;
    int rt = charArr.length - 1;
    char tmp;

    while(lt < rt) {
      tmp = charArr[rt];
      charArr[rt--] = charArr[lt];
      charArr[lt++] = tmp;
    }

    return String.valueOf(charArr);
  }
  
  
  @SuppressWarnings("all")
  public static void main(String[] args){
    
    String[] testCases = {"good", "time", "biG"};
    String[] splitted;
    String s1, s2;

    for(String s : testCases) {
      splitted = s.split(",");
      s1 = splitted[0].trim();
      if(splitted.length > 1) {
        s2 = splitted[1].trim();
      }

      System.out.println(solution(s1)+"");
      System.out.println(anotherSolution1(s1)+"");
      System.out.println(anotherSolution2(s1)+"");
    }
    return ;
  }
}
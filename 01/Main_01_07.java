public class Main_01_07 {

  /*
  앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
  문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
  단 회문을 검사할 때 대소문자를 구분하지 않습니다.
  */
  static String solution(String input) {
    if(input.length() == 0) {
      return "NO";
    }

    char[] charArr = input.toLowerCase().toCharArray();
    int lt = 0, rt = input.length() - 1;


    while(lt < rt) {
      if(charArr[lt++] == charArr[rt--]) {
        continue;
      }
      return "NO";
    }

    return "YES";
  }

  // 직접 index를 따라가면서 바꾸기.
  static String anotherSolution(String input) {
    if(input.length() == 0) {
      return "NO";
    }
    return "YES";
  }
  
  @SuppressWarnings("all")
  public static void main(String[] args){
    
    String[] testCases = {"gooG", "seves", "seven"};
    String[] splitted;
    String s1, s2;

    for(String s : testCases) {
      splitted = s.split(",");
      s1 = splitted[0].trim();
      if(splitted.length > 1) {
        s2 = splitted[1].trim();
      }

      System.out.println(solution(s1)+"");
      System.out.println(anotherSolution(s1)+"");
    }
    return ;
  }
}
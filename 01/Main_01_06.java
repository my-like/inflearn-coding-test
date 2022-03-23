import java.util.Arrays;

public class Main_01_06 {

  /*
  소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
  중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
  ksekkset -> kset
  */
  static String solution(String input) {
    if(input.length() == 0) {
      return "";
    }

    return Arrays.stream(input.split("")).distinct().reduce("", (a, b) -> a.concat(b));
  }

  // 직접 index를 따라가면서 바꾸기.
  static String anotherSolution(String input) {
    if(input.length() == 0) {
      return "";
    }
    String[] charArr = input.split("");
    String answer = "";

    for(String s : charArr) {
      if(answer.indexOf(s) > -1) {
        continue;
      }
      answer += s;
    }

    return answer;
  }
  
  @SuppressWarnings("all")
  public static void main(String[] args){
    
    String[] testCases = {"ksekkset"};
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
import java.util.Arrays;

public class Main_01_10 {

  /*
  한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
  teachermode e -> 1 0 1 2 1 0 1 2 2 1 0
  */
  static String solution(String input1, String input2) {
    if(input1.length() == 0 || input2.length() == 0) {
      return "";
    }
    int[] answer = new int[input1.length()];
    int lt = -1, rt = -1, ld, rd;

    for(int i = 0; i < input1.length(); i++) {
      lt = input1.substring(0, i).lastIndexOf(input2);
      rt = input1.indexOf(input2, i);

      ld = i - lt;
      rd = rt - i;

      if(lt == -1) {
        answer[i] = rd;
        continue;
      }
      
      if (rt == -1) {
        answer[i] = ld;
        continue;
      }
      answer[i] = ld < rd ? ld : rd;
    }

    return Arrays.stream(answer)
                 .mapToObj( a -> String.valueOf(a) )
                 .reduce("", (a, b) -> a.concat(" "+b)).trim();
  }

  // 두 번째 문자와의 왼쪽 거리만 담는 배열을 만들고, (진행 순서: 왼쪽 -> 오른쪽)
  // 오른쪽 거리만 담는 배열을 만든다(진행 순서 : 오른쪽 -> 왼쪽)
  // 오른쪽 거리를 담을 때는 기존 배열과의 크기를 비교한다.
  // Math.min 둘 중에 최소값을 고른다.
  static String anotherSolution(String input1, String input2) {
    if(input1.length() == 0) {
      return "";
    }
    int[] answer = new int[input1.length()];
    int p = 1000;
    char c = input2.charAt(0);

    for(int i = 0; i < input1.length(); i++) {
      if(input1.charAt(i) == c) {
        p = 0;
      } else {
        p++;
      }
      answer[i] = p;
    }

    p = 1000;
    for(int i = input1.length() - 1; i >= 0; i--) {
      if(input1.charAt(i) == c) {
        p = 0;
      } else {
        p++;
        answer[i] = Math.min(answer[i], p);
      }
    }

    return Arrays.stream(answer)
                 .mapToObj( a -> String.valueOf(a) )
                 .reduce("", (a, b) -> a.concat(" "+b)).trim();
  }
  
  @SuppressWarnings("all")
  public static void main(String[] args){
    
    String[] testCases = {"teachermode,e"};
    String[] splitted;
    String s1, s2;

    for(String s : testCases) {
      splitted = s.split(",");
      s1 = splitted[0].trim();
      s2 = splitted[1].trim();

      System.out.println(solution(s1, s2)+"");
      System.out.println(anotherSolution(s1, s2)+"");
    }
    return ;
  }
}
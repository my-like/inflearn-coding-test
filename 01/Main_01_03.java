import java.util.HashMap;
import java.util.Map;

public class Main_01_03 {

  // 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
  // 문장속의 각 단어는 공백으로 구분됩니다.
  // 가장 긴 단어가 중복되면 맨 처음 나온 단어로 합니다.
  static String solution(String input) {
    String answer = "";
    
    if(input.length() == 0) {
      return answer;
    }
    
    String[] strArr = input.split(" ");

    Map<Integer, String> map = new HashMap<>();
    
    for(String s : strArr) {
      map.putIfAbsent(s.length(), s);
    }

    return map.get(map.keySet().stream().max( Integer::compareTo ).get());
  }

  static String anotherSolution(String input) {
    String answer = "";

    String[] strArr = input.split(" ");
    int len = 0;

    for(String s : strArr) {
      if(s.length() > len) {
        len = s.length();
        answer = s;
      }
    }
    return answer;
  }
  
  @SuppressWarnings("all")
  public static void main(String[] args){
    
    String[] testCases = {"abcdef it is time to study Irish", "comPress"};
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
public class Main_01_09 {

  /*
  문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
  만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.
  추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.
  */
  static int solution(String input) {
    if(input.length() == 0) {
      return 0;
    }

    input = input.replaceAll("[^0-9]", "");

    return Integer.parseInt(input);
  }

  // 정규식으로 삭제해본다..
  static String anotherSolution(String input) {
    if(input.length() == 0) {
      return "";
    }

    input = input.replaceAll("[^0-9]", "");

    return input;
  }
  
  @SuppressWarnings("all")
  public static void main(String[] args){
    
    String[] testCases = {"tge0a1h205er"};
    String[] splitted;
    String s1, s2;

    for(String s : testCases) {
      splitted = s.split(",");
      s1 = splitted[0].trim();
      if(splitted.length > 1) {
        s2 = splitted[1].trim();
      }

      System.out.println(solution(s)+"");
      System.out.println(anotherSolution(s)+"");
    }
    return ;
  }
}
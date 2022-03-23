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
  static String anotherSolution(String input) {
    return new StringBuilder(input).reverse().toString();
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
      System.out.println(anotherSolution(s1)+"");
    }
    return ;
  }
}
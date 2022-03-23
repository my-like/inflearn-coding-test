public class Main_01_02 {

  // 문자열 하나를 입력받아, 소문자는 대문자로 대문자는 소문자로 변경하는 코드
  static String solution(String input1) {
    String answer = "";
    
    if(input1.length() == 0) {
      return answer;
    }
    
    char[] charArr = input1.toCharArray();

    for(char c : charArr) {
      answer += Character.isLowerCase(c) ? 
                    Character.toUpperCase(c) : Character.toLowerCase(c);
    }
    
    return answer;
  }

  @SuppressWarnings("all")
  public static void main(String[] args){
    
    String[] testCases = {"sTUdy", "comPress"};
    String[] splitted;
    String s1, s2;

    for(String s : testCases) {
      splitted = s.split(",");
      s1 = splitted[0].trim();
      if(splitted.length > 1) {
        s2 = splitted[1].trim();
      }

      System.out.println(solution(s1)+"");
    }
    return ;
  }
  /*
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    String input1 = in.nextLine();
    System.out.println(solution(input1));
    return ;
  }
  */
}
public class Main_01_01 {

  // 문자열 두 개를 입력받아 첫 번째 문자열에서 두 번째 문자의 개수가 몇 개인지 세는 코드
  static int solution(String input1, String input2) {
    int answer = 0;
    
    if(input1.length() == 0 || input2.length() == 0) {
      return answer;
    }
    
    char[] charArr = input1.toLowerCase().toCharArray();
    char c = input2.toLowerCase().charAt(0);

    for(char s : charArr) {
      if(s == c) {
        answer++;
      }
    }
    
    return answer;
  }
  @SuppressWarnings("all")
  public static void main(String[] args){
    
    String[] testCases = {"Controller, c"};
    String[] splited;
    String s1, s2;

    for(String s : testCases) {
      splited = s.split(",");
      s1 = splited[0].trim();
      s2 = splited[1].trim();

      System.out.println(solution(s1, s2)+"");
    }
    return ;
  }

  /*
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    String input1 = in.nextLine();
    String input2 = in.nextLine();
    System.out.println(solution(input1, input2));
    return ;
  }
  */
}
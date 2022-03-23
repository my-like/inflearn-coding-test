public class Main_01_08 {

  /*
  앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
  문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
  단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
  알파벳 이외의 문자들의 무시합니다.
  found7, time: study; Yduts; emit, 7Dnuof -> YES
  */
  static String solution(String input) {
    if(input.length() == 0) {
      return "NO";
    }

    char[] charArr = input.toLowerCase().toCharArray();
    int lt = 0, rt = input.length() - 1;

    while(lt < rt) {
      if(!Character.isAlphabetic(charArr[lt])) {
        lt++;
        continue;
      }
      if(!Character.isAlphabetic(charArr[rt])) {
        rt--;
        continue;
      }
      if(charArr[lt++] == charArr[rt--]) {
        continue;
      }
      return "NO";
    }

    return "YES";
  }

  // 정규식으로 알파벳을 제외한 나머지를 제거하고 회문을 검사함.
  static String anotherSolution(String input) {
    if(input.length() == 0) {
      return "NO";
    }
    // 정규식 [ ] 안에 ^를 넣으면 not의 의미가 됨.
    input = input.toLowerCase().replaceAll("[^a-z]", "");
    int len = input.length()/2 - 1;

    for(int i = 0; i <= len; i++) {
      if(input.charAt(i) == input.charAt(len-i)) {
        continue;
      }
      return "NO";
    }

    return "YES";
  }
  
  @SuppressWarnings("all")
  public static void main(String[] args){
    
    String[] testCases = {"found7, time: study; Yduts; emit, 7Dnuof"};
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
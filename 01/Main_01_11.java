public class Main_01_11 {

  /*
  현수는 영희에게 알파벳 대문자로 구성된 비밀편지를 매일 컴퓨터를 이용해 보냅니다.
  비밀편지는 알파벳 한 문자마다 # 또는 *이 일곱 개로 구성되어 있습니다.
  비밀편지는 현수와 영희가 서로 약속한 암호로 구성되어 있습니다.
  만약 현수가 “#*****#”으로 구성된 문자를 보냈다면 영희는 현수와 약속한 규칙대로 다음과 같이 해석합니다.
  1. “#*****#”를 일곱자리의 이진수로 바꿉니다. #은 이진수의 1로, *이진수의 0으로 변환합니다. 결과는 “1000001”로 변환됩니다.
  2. 바뀐 2진수를 10진수화 합니다. “1000001”을 10진수화 하면 65가 됩니다.
  3. 아스키 번호가 65문자로 변환합니다. 즉 아스크번호 65는 대문자 'A'입니다.
  참고로 대문자들의 아스키 번호는 'A'는 65번, ‘B'는 66번, ’C'는 67번 등 차례대로 1씩 증가하여 ‘Z'는 90번입니다.
  현수가 4개의 문자를 다음과 같이 신호로 보냈다면
  #****###**#####**#####**##**
  이 신호를 4개의 문자신호로 구분하면
  #****## --> 'C'
  #**#### --> 'O'
  #**#### --> 'O'
  #**##** --> 'L'
  최종적으로 “COOL"로 해석됩니다.
  현수가 보낸 신호를 해석해주는 프로그램을 작성해서 영희를 도와주세요.
  */
  static String solution(int length, String input) {
    if(input.length() == 0) {
      return "";
    }

    String answer = "";
    
    input = input.replaceAll("#", "1").replaceAll("*", "0");

    for(int i = 0; i < length; i++) {
      answer += (char) toDecimal(input.substring(i*7, i*7+7));
    }


    return answer;
  }

  static int toDecimal(String binaryStr) {
    int answer = 0;

    for(int i = binaryStr.length() - 1; i >= 0; i--) {
      //answer += Integer.parseInt(binaryStr.charAt(i))
    }

    return 0;
  }
  
  static String anotherSolution(int length, String input) {
    if(input.length() == 0) {
      return "";
    }
    return input;
  }
      
  @SuppressWarnings("all")
  public static void main(String[] args){
    
    String[] testCases = {"4,#****###**#####**#####**##**"};
    String[] splitted;
    int s1;
    String s2;

    for(String s : testCases) {
      splitted = s.split("");
      s1 = Integer.parseInt(splitted[0].trim());
      s2 = splitted[1].trim();

      System.out.println(solution(s1, s2)+"");
      System.out.println(anotherSolution(s1, s2)+"");
    }
    return ;
  }
}
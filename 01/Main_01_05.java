public class Main_01_05 {

  //영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
  //특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
  // a#b!GE*T@S -> S#T!EG*b@a
  // a@b#c$d%   -> d@c#b$a%
  static String solution(String input) {
    if(input.length() == 0) {
      return "";
    }
    
    char[] charArr = input.toCharArray();
    char[] answerArr = new char[charArr.length];
    int[]  letterArr = input.chars().filter(Character::isLetter).toArray();
    char c;
    int pos = letterArr.length;
    
    // char[] array는 primitive 타입이라 바로 stream으로 만들 수 없다. 
    // 각각의 Wrapper Stream이 있는 int, long, double과는 다름.
    // Arrays.stream(charArr); (불가)
    // https://www.techiedelight.com/create-stream-of-characters-from-char-array-java/
    // 1. string instance 메소드 중에 chars 라는 게 있다. 얘는 charCode를 IntStream으로 변경해줌.
    // int 변수 앞에 (char) 로 캐스팅을 하면 charCode에 해당하는 문자로 변경된다.

    for(int i = 0; i < charArr.length; i++) {
      c = charArr[i];
      if(Character.isLetter(c)) {
        answerArr[i] = (char) letterArr[--pos];
        continue;
      }
      answerArr[i] = c;
    }
    
    return String.valueOf(answerArr);
  }

  // 직접 index를 따라가면서 바꾸기.
  static String anotherSolution(String input) {
    char[] charArr = input.toCharArray();
    int lt = 0;
    int rt = charArr.length - 1;
    char tmp;

    while(lt < rt) {
      
      if(!Character.isLetter(charArr[lt])) {
        lt++;
        continue;
      }

      if(!Character.isLetter(charArr[rt])) {
        rt--;
        continue;
      }

      tmp = charArr[rt];
      charArr[rt--] = charArr[lt];
      charArr[lt++] = tmp;
    }

    return String.valueOf(charArr);
  }
  
  @SuppressWarnings("all")
  public static void main(String[] args){
    
    String[] testCases = {"a#b!GE*T@S", "a@b#c$d%"};
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
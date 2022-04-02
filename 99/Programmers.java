public class Programmers {

  static public int[] solution(int[] lottos, int[] win_nums) {
    int[] answer = new int[2];
    int sameLowCnt = 0;
    int sameHighCnt = 0;
    for (int lotto : lottos) {
      if (lotto == 0) {
        sameHighCnt++;
        continue;
      }
      for (int num : win_nums) {
        if (lotto == num) {
          sameLowCnt++;
          sameHighCnt++;
          break;
        }
      }
    }

    answer[0] = sameHighCnt == 0 ? 6 : 7 - sameHighCnt;
    answer[1] = sameLowCnt == 0 ? 6 : 7 - sameLowCnt;

    return answer;
  }

  static public void main(String[] args) {
    int[] lottos = { 44, 1, 0, 0, 31, 25 };
    // int[] win_nums = { 31, 10, 45, 1, 6, 19 };
    int[] win_nums = {};
    int[] answer = solution(lottos, win_nums);
    System.out.println(answer[0]);
    System.out.println(answer[1]);
  }

}

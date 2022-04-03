public class Programmers6 {

  // 숫자키패드 입력
  static public void main(String[] args) {
    int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
    String hand = "left";
    Programmers6 T = new Programmers6();
    String result = T.solution(numbers, hand);

    System.out.println(result);
    System.out.println("LRLLRRLLLRR");
  }

  private String solution(int[] numbers, String hand) {
    String answer = "";
    int leftPos = 99;
    int rightPos = 100;
    hand = hand.equals("right") ? "R" : "L";

    

    int num;
    for(int i = 0; i < numbers.length; i++) {
      num = numbers[i];

      if(num == 1 || num == 4 || num == 7) {
        leftPos = num;
        answer += "L";
        continue;
      }
      if(num == 3 || num == 6 || num == 9) {
        rightPos = num;
        answer += "R";
        continue;
      }

      int[] leftArr = getPosition(leftPos);
      int[] rightArr = getPosition(rightPos);
      int[] numArr = getPosition(num);

      int leftDist = Math.abs(leftArr[0] - numArr[0]) + Math.abs(leftArr[1] - numArr[1]);
      int rightDist = Math.abs(rightArr[0] - numArr[0]) + Math.abs(rightArr[1] - numArr[1]);

      if(leftDist == rightDist) {
        if(hand.equals("L")) {
          leftPos = num;
        } else {
          rightPos = num;
        }
        answer += hand;
        continue;
      }

      if(leftDist < rightDist) {
        leftPos = num;
        answer += "L";
      } else {
        rightPos = num;
        answer += "R";
      }
      
    }

    return answer;
  }

  private int[] getPosition(int num) {
    int[][] board = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {99, 0, 100}};
    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[i].length; j++) {
        if(board[i][j] == num) {
          return new int[] {i, j};
        }
      }
    }

    return new int[]{-1, -1};
  }
}

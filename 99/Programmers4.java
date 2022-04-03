import java.util.Stack;

public class Programmers4 {

  // Level1 인형 크레인 뽑기
  static public void main(String[] args) {
    int[][] board ={ {0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
    int[] moves = {1,5,3,5,1,2,1,4};
    Programmers4 T = new Programmers4();
    int result = T.solution(board, moves);

    System.out.println(result);
  }

  private int solution(int[][] board, int[] moves) {
    int answer = 0;
    int result;
    Stack<Integer> stack = new Stack<>();
    for(int i = 0; i < moves.length; i++) {
    
      if(stack.size() == 0) {
        stack.push(pop(board, moves[i]));
        System.out.println(stack.peek());
        continue;
      }
      result = pop(board, moves[i]);
      if(result == 0) continue;

      if(stack.peek() == result) { // 같으면
        stack.pop();
        
        answer += 2;
        continue;
      }
      // 다르면
      stack.push(result);
    }
    
    return answer;
  }
  private int pop(int[][] board , int index) {
    int result;
    for(int i = 0; i < board.length; i++) {
        if(board[i][index-1] != 0) {
          result = board[i][index-1];
          board[i][index-1] = 0;
          return result;
        }
    }
    return 0;
  }
}

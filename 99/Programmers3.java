import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Programmers3 {

  // Level3 표편집
  static public void main(String[] args) {
    int n = 8;
    int k = 6;
    // String[] cmd = { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z" };
    // String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
    //String[] cmd = {"D 5", "C", "C", "Z", "Z", "Z", "C"};
    String[] cmd = {"C", "C", "C", "Z", "Z"};
    Programmers3 T = new Programmers3();
    String result = T.solution(n, k, cmd);

    System.out.println(result);
  }

  private String solution(int n, int k, String[] cmd) {
    // String answer = "";
    List<Integer> row = new LinkedList<>();
    Map<Integer, String> org = new HashMap<>();
    Stack<Integer> history = new Stack<Integer>();
    int selectIndex = k;
    int num;
    int pos = -1;

    for (int i = 0; i < n; i++) {
      row.add(i);
      org.put(i, "O");
    }
    for (String value : cmd) {
      if ("C".equals(value)) {
        num = row.remove(selectIndex);
        history.push(num);
        org.put(num, "X");

        if (selectIndex == row.size()) {
          selectIndex--;
        }
        continue;
      }

      if ("Z".equals(value)) {
        if (history.size() == 0) {
          continue;
        }

        num = history.pop();

        pos = -1;
        for(int i=0 ; i < row.size() ; i++){
          if(row.get(i) < num) {
            continue;
          }
          pos = i;
        }
        if(pos == -1) {
          pos = row.size();
        }

        row.add(pos, num);
        if(pos <= selectIndex) {
          selectIndex++;
        }
        org.put(num, "O");
        continue;
      }

      String[] vi = value.split(" ");
      String v = vi[0];
      int i = Integer.parseInt(vi[1]);

      if (v.equals("U")) {
        selectIndex -= i;
        if(selectIndex < 0) {
          selectIndex = 0;
        }
        continue;
      }

      selectIndex += i;
      if(selectIndex >= row.size()) {
        selectIndex = row.size() - 1;
      }
    }

    StringBuilder sb = new StringBuilder();
    for(String s : org.values()) {
      sb.append(s);
    }

    return sb.toString();
  }

}

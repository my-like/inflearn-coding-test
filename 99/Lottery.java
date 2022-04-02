import java.util.LinkedList;

public class Lottery {

  private LinkedList<Lotto> list;
  
  public static void main(String[] args) {

    Lottery L = new Lottery();
    int[] cnt = {10, 90, 900}; // 1등 10명, 2등 90명, 3등 900명
    L.solution(cnt);

    Lotto lotto = L.getLotto();
    System.out.println(lotto.getType().toString());
    System.out.println(lotto.getPrize());
    System.out.println(L.getCount());
  }

  private void solution(int[] cnt) {
    // create token list;
    list = new LinkedList<Lotto>();
    PrizeType type;
    int random;
    Lotto tmp;

    for(int i = 0; i < cnt.length; i++) {
      type = PrizeType.valueOf(i+1);
      for(int j = 0; j < cnt[i]; j++) {
        list.add(new Lotto(type));
      }
    }

    // shuffle
    for(int i = 0; i < list.size(); i++) {
      random = Double.valueOf(Math.random() * 1000).intValue();
      tmp = list.get(random);
      list.set(random, list.get(i));
      list.set(i, tmp);
    }
  } 


  private Lotto getLotto() {
    int random = Double.valueOf(Math.random() * this.getCount()).intValue();
    return this.list.remove(random);
  }

  private int getCount() {
    return this.list.size();
  }

  class Lotto {
    private PrizeType type;
    Lotto(PrizeType type) {
      this.type = type;
    }

    PrizeType getType() {
      return this.type;
    }

    long getPrize() {
      return this.type.prize;
    }
  }
  
  enum PrizeType {
    FIRST(50000),
    SECOND(10000),
    THIRD(1000);
  
    private long prize;
  
    PrizeType(long prize) {
      this.prize = prize;
    }
    
    long getPrize() {
      return this.prize;
    }

    public static PrizeType valueOf(int ordinal) {
      if(ordinal == 3) {
        return PrizeType.THIRD;
      }

      if(ordinal == 2) {
        return PrizeType.SECOND;
      }

      return PrizeType.FIRST;
    }
  }
}


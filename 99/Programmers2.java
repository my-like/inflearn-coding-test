import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Programmers2 {

 
  static public void main(String[] args) {

    String[] lines = { "2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s" };
    // String[] lines = { "2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s" };

    solution(lines);
  }

  private static int solution(String[] lines) {

    if(lines.length == 1) return 1;
    
    long[][] timeLine = new long[lines.length][2];

    for ( int i = 0; i < lines.length; i++) {
      String line = lines[i];
      String[] sp = line.split(" ");
      String finishedTime = sp[0] + " " + sp[1];
      LocalDateTime endTime = LocalDateTime.parse(finishedTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
      // long longEndTime = endTime.to(ZoneOffset.ofHours(0));
      double ss = Double.parseDouble(sp[2].replaceAll("s", ""));
      long longss = (long) ((ss - 0.001) * 1000000000.0);
      LocalDateTime startTime = endTime.minusNanos(longss);

      long longS = startTime.toInstant(ZoneOffset.ofHours(0)).toEpochMilli();
      long longE = endTime.toInstant(ZoneOffset.ofHours(0)).toEpochMilli();

      timeLine[i] = new long[]{longS, longE};

      System.out.println(startTime);
      System.out.println(startTime.toInstant(ZoneOffset.ofHours(0)).toEpochMilli());
      System.out.println(endTime);
      System.out.println(endTime.toInstant(ZoneOffset.ofHours(0)).toEpochMilli());
    }
    //Arrays.sort(timeLine, (a, b) -> Long.compare(a[0], b[0]));                              


    long startTime, endTime;
    long totalStartTime = timeLine[0][0];
    long totalEndTime   = timeLine[timeLine.length - 1][1];
    int maxCnt = 0, cnt;


    for(long i = 0; i < totalEndTime-1000-totalStartTime; i++) {
      startTime = totalStartTime + i;
      endTime = startTime + 1000L;
      cnt = 0;
      for(int j = 0; j < timeLine.length; j++) {
        long start = timeLine[j][0];
        long end = timeLine[j][1];

        if(end < startTime) {
          continue;
        }
        if(start > endTime) {
          continue;
        }
        cnt++;
      }
      if(cnt > maxCnt) {
        maxCnt = cnt;
      }
    }

    System.out.println(maxCnt);
    return maxCnt;
  }
}

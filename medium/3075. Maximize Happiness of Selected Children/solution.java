
// idea: https://youtu.be/xyoEEGLHfmE?si=qqlyl4GAyCIC35X0
import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
  public long maximumHappinessSum(int[] happiness, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int h : happiness) {
      pq.add(h);
    }

    long retVal = 0;
    int cnt = 0;

    while (!pq.isEmpty() && k > 0) {
      int current = pq.poll();
      if (current - cnt > 0) {
        retVal += current - cnt;
      } else {
        break;
      }
      cnt++;
      k--;
    }

    return retVal;
  }
}

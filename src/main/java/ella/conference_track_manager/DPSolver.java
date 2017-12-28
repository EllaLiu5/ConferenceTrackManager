package ella.conference_track_manager;

import java.util.List;

public class DPSolver {
	//passed test
	public boolean[] process(int sessionTime, List<Talk> talks) {
		int N = talks.size();
		int T = sessionTime;
		int[] talkTime = new int[N+1];
		for(int i=1; i<=N;i++) {
			talkTime[i]=talks.get(i-1).getTime();
		}
		
		int[][] value = new int[N+1][T+1];
		boolean[][] select = new boolean[N+1][T+1];
		
		for(int n=1; n<=N; n++) {
			for(int t=1; t<=T; t++) {
				int v1 = value[n-1][t];
				int v2 = Integer.MIN_VALUE;
				if(talkTime[n]<=t) {
					v2 = talkTime[n] + value[n-1][t-talkTime[n]];
				}
				value[n][t] = Math.max(v1, v2);
				select[n][t] = (v2 > v1);
			}
		}
		
		boolean[] take = new boolean[N+1];
		for(int n=N, t=T; n>0; n--) {
			if(select[n][t]) {
				take[n] = true;
				t -= talkTime[n];
			} else {
				take[n] = false;
			}
		}
		return take;
	}
}

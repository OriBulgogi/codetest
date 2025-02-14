import java.util.*;
import java.util.*;
class Solution {
    static int N, M;
    static int[][] visited; 
    static int[] dx = {1, -1, 0 , 0};
    static int[] dy = {0 , 0, 1, -1};
    
    public int solution(String[] board) {
        int answer = 0;
        N = board.length;
        M = board[0].length();
        visited = new int[N][M];
        
        for(int i=0; i<N; i++){
            for(int j =0; j<M; j++){
                if(board[i].charAt(j) =='R'){
                    visited[i][j] = 1;
                    answer = bfs(i,j,board);
                }
            }
        }
        return answer;
    }
    
    public int bfs(int x, int y,String[] board){
        Queue<int[]> que = new LinkedList<int[]>();
        que.add(new int[] {x, y});
        
        while(!que.isEmpty()){
            int[] pos =  que.poll();
            x = pos[0];
            y = pos[1]; 
            
            if(board[x].charAt(y) == 'G'){
                return visited[x][y] -1 ;
            }
            
            for(int i=0; i<4; i++){
                int t=0;
                while(true){
                    int curX = x+ (t*dx[i]);
                    int curY = y+ (t*dy[i]);
                    int postX = x+ ((t+1)*dx[i]);
                    int postY = y+ ((t+1)*dy[i]);
                    
                    if(postX <0 || postX >=N || postY <0|| postY >= M || board[postX].charAt(postY) == 'D') {
                        if(visited[curX][curY] == 0 ){
                            visited[curX][curY]  = visited[x][y]+1;
                            que.add(new int[] {curX, curY}); 
                        }
                        break;
                    }
                    t++;
                }
            }    
        }
        return -1;
    }
}
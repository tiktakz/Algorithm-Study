//package baekjoon;
//import java.util.*;
//import java.io.*;
//
//class BJ4179 {
//    static int n, m;
//    static int[][] graph;
//    static boolean[][] visitedJihun, visitedFire;
//    static Queue<Node> Q1, Q2 = new LinkedList<>();
//    static int[] dx = {1,-1,0,0};
//    static int[] dy = {0,0,-1,1};
//
//    static class Node {
//        int x,y;
//        public Node (int x, int y) {
//            this.x=x;
//            this.y=y;
//        }
//    }
//
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//        graph = new int[n][m];
//        visitedJihun = new boolean[n][m];
//        visitedFire = new boolean[n][m];
//
//        for (int i=0; i<n; i++) {
//            String str = br.readLine();
//            for (int j=0; j<m; j++) {
//                graph[i][j] = str.charAt(j);
//                if (graph[i][j] == 'J') {
//                    graph[i][j] = '.';
//                    Q1.offer(new Node(i,j));
//                    visitedJihun[i][j] = true;
//                }
//                else if (graph[i][j] == 'F') {
//                    Q2.offer(new Node(i,j));
//                    visitedFire[i][j] = true;
//                }
//            }
//        }
//
//        BFS();
//        System.out.println();
//    }
//
//    public static void BFS() {
//        while (!Q1.isEmpty()) {
//            Node cv = Q1.poll();
//            for (int i=0; i<4; i++) {
//                int nx = cv.x + dx[i];
//                int ny = cv.y + dy[i];
//
//                if (nx<0 || nx>=n || ny<0 || ny>=m) continue;
//                if (graph[i][j]);
//            }
//        }
//    }
//}

package book;

public class array_02 {
    public static void main(String[] args) {
        int[] answer= {1,2,3,4,5};
        int[][] patterns =
                {
                        {1,2,3,4,5},
                        {2,1,2,3,2,4,2,6},
                        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
                };
        int[] scroes = new int[3];

        for(int i=0; i<answer.length; i++){
            for(int j=0; j<patterns.length; j++){
                System.out.print(i% patterns[j].length);// 0~4 % 5
            }
            System.out.println("");
        }
    }
}

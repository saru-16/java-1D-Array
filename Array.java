import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game, int position) {  
        int afterWalk = position + 1;
        int afterLeap = position + leap;
        int afterReverse = position - 1;
              
        if (position < 0 || game[position] != 0) {
            return false;
        } else if (afterWalk >= game.length || afterLeap >= game.length) {
            return true;
        }
        game[position] = 1;
        
        return canWin(leap, game, afterWalk) || 
            canWin(leap, game, afterLeap) ||
            canWin(leap, game, afterReverse);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game, 0)) ? "YES" : "NO" );
        }
        scan.close();
    }
}

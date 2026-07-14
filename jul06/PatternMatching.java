import java.util.ArrayList;

public class PatternMatching {

    public static void main(String[] args) {
        
        String text = "abababacadabca";
        String pattern = "ab";
        

        ArrayList<Integer> res = new ArrayList<>();

        res = KMPSearch(text , pattern);


        for(int i = 0 ; i<res.size() ; i++){
            System.out.print(res.get(i)+ " ");
        }
    }
    private static ArrayList<Integer> KMPSearch(String text, String pattern) {

        int n = text.length();
        int m = pattern.length();
        ArrayList<Integer> res = new ArrayList<>();

        int[] lps = new int[pattern.length()];
        lps = ConstructLps(pattern);

        int i=0 , j=0;

        while (i<n) {
            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;

            }

            if(j == m){
                res.add(i-j);
                j = lps[j-1];
            }
            else if(i<n && text.charAt(i)!=pattern.charAt(j)){
                if(j!=0)
                    j = lps[j-1];
                else
                    i++;
            }
        }
        return res;
        
    }
    private static int[] ConstructLps(String pattern) {
        int m = pattern.length();
        int lps[] = new int[m];

        int len = 0 , i = 1;
        lps[0] = 0;

        while (i < m) {
            if(pattern.charAt(i) == pattern.charAt(len)){
                len++;
                lps[i] = len ;
                i++;
            }
            else {
                if(len != 0)
                    len = lps[len - 1];
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

}
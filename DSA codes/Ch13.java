public class Ch13{

    public int BurteForce(char[] T, char[] p){
        int n = T.length;
        int m = p.length;
        for(int i = 0; i < (n-m);i++){ //iterating the text - pattern's length  
            int k = 0;
            while (k < n && p[k] == T[i+k]){ 
                k++; 
                if (k==m){
                    return i;
                }
            }
        }
        return -1;
    }
    
    public int boyerMoore(char[] T,char[]p){
        int m = T.length;
        int n = p.length;
        int i = 0;

        // { Building lastOcuurance() Function/map code goes here }
        while (i <= m-n){
            int j = n-1;
            while(j >= 0 && T[i+j]==p[j]){ //Match Section
                j--;
            }
            if (j<0) 
                return i;
            else{
                int l = lastOccurance(T[i+j]); // returns a value between -1 and p.length-1
                if (l + 1 <= j) i+= (n-l-1);
                else i+=(n-j);
            }
        }
        return -1;
    }

    public int KMP(char[] T,char[] p){

        int[] fail = failureFunction(p);
        int m = T.length;
        int n = p.length;
        int i = 0; // T pointer
        int j = 0; // p pointer
        
        while (j < n){
            if (T[i] == p[j]){
                if (j==n-1) return i;
                j++;
                i++;
            }else if (i>0){i = fail[i-1];}
            else{j++;}
        }
        return -1;
    }

    private static int[] failureFunction(char[] pattern){
        int n = pattern.length;
        int[] fail = new int[n-1];
        fail[0] = 0;
        int j = 1; 
        int k = 0;
        while (j < n){
            if (pattern[j] == pattern[k]){
                fail[j]=k+1;
                j++;
                k++;
            }
            else if(k>0){k = fail[k-1];}
            else{j++;}
        }
        return fail;
    }

    public int[][] matrixChain(int[]d){
        
        return null;
    }

    public static int[][] LCS(char[] A, char[]B){
        int m = A.length;
        int n = B.length;
        int[][] L = new int[m+1][n+1];
        for (int i = 0; i<m; i++){
            for (int j = 0; j<n; j++){
                if(A[i+1]==B[j+1]){
                    L[i+1][j+1] = L[i][j]+1;
                }else{
                    L[i+1][j+1] = Math.max(L[i][j+1],L[i+1][j]);
                }
            }
        }
        return L;
    }

    public static char[] reverseLCS(int[] X, int[] Y, int[][]L){
        int m = X.length;
        int n = Y.length;
        StringBuilder sol = new StringBuilder(); 
        while(L[m][n]>0){
            if(X[m-1]==Y[n-1]){
                sol.append(X[m-1]);
            }
            else if (X[m-1]>=Y[n-1]){
                m--;
            }else n--;
        }
        return sol.reverse().toString().toCharArray(); 
    }
}
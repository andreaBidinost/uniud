
public class Awful2 {
	//IL GIOCO DELLA VITA
	    public static void main(String[] args) 
	    { 
	        int M = 10, N = 10; 
	  
	        int[][] gr = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
	            { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 }, 
	            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, 
	            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
	            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
	            { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 }, 
	            { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 }, 
	            { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 }, 
	            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, 
	            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } 
	        }; 
	  
	        System.out.println("Original Generation"); 
	        for (int i = 0; i < M; i++) 
	        { 
	            for (int j = 0; j < N; j++) 
	            { 
	                if (gr[i][j] == 0) 
	                    System.out.print("."); 
	                else
	                    System.out.print("*"); 
	            } 
	            System.out.println(); 
	        } 
	        System.out.println(); 
	        ng(gr, M, N); 
	    } 
	  
	    static void ng(int gr[][], int M, int N) 
	    { 
	        int[][] f = new int[M][N]; 
	  
	        for (int l = 1; l < M - 1; l++) 
	        { 
	            for (int m = 1; m < N - 1; m++) 
	            { 
	                int an = 0; 
	                for (int i = -1; i <= 1; i++) 
	                    for (int j = -1; j <= 1; j++) 
	                        an += gr[l + i][m + j]; 
	  
	                an -= gr[l][m]; 

	                if ((gr[l][m] == 1) && (an < 2)) 
	                    f[l][m] = 0; 
	  
	                else if ((gr[l][m] == 1) && (an > 3)) 
	                    f[l][m] = 0; 
	  
	                else if ((gr[l][m] == 0) && (an == 3)) 
	                    f[l][m] = 1; 
	  
	                else
	                    f[l][m] = gr[l][m]; 
	            } 
	        } 
	  
	        System.out.println("Next Generation"); 
	        for (int i = 0; i < M; i++) 
	        { 
	            for (int j = 0; j < N; j++) 
	            { 
	                if (f[i][j] == 0) 
	                    System.out.print("."); 
	                else
	                    System.out.print("*"); 
	            } 
	            System.out.println(); 
	        } 
	    } 
	
}

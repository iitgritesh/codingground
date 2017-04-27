// A naive Java based recursive implementation of LIS problem
class abtoctrucations
{
public static final int MAX_LEN = 110;
// To store results of subproblems
private static final int DP[][][] = new int[MAX_LEN][MAX_LEN][MAX_LEN];

// A memoized function find result recursively.
// a, b and c are counts of 'a's, 'b's and
// 'c's in str
static int length(int a, int b, int c)
{
    System.out.println("a:"+a+"b:"+b+"c:"+c);
	// If this subproblem is already evaluated
	if (DP[a][b][c] != -1)
		return DP[a][b][c];
    //System.out.println("2.a:"+a+"b:"+b+"c:"+c);
	// If there is only one type of character
	if (a == 0 && b == 0){
	    //System.out.println("3.a:"+a+"b:"+b+"c:"+c);
	    DP[a][b][c] = c;
		return DP[a][b][c];
	}
	if (a == 0 && c == 0){
	    DP[a][b][c] = b;
		return DP[a][b][c];
	}
	if (b == 0 && c == 0){
	    DP[a][b][c] = a;
		return DP[a][b][c];
	}

	// If only two types of characters are present
	if (a == 0){
	    DP[a][b][c] =
					length(a + 1, b - 1, c - 1);
		return DP[a][b][c];
	}
	if (b == 0){
	    DP[a][b][c] =
					length(a - 1, b + 1, c - 1);
		return DP[a][b][c];
	}
	if (c == 0){
	    //System.out.println("a:"+a+"b:"+b+"c:"+c);
		DP[a][b][c] =
					length(a - 1, b - 1, c + 1);
		return DP[a][b][c];
	    
	}

	// If all types of characters are present.
	// Try combining all pairs.
	DP[a][b][c] =
				Math.min(length(a - 1, b - 1, c + 1),
					Math.min(length(a - 1, b + 1, c - 1),
						length(a + 1, b - 1, c - 1)));
	return DP[a][b][c];
}

// Returns smallest possible length with given
// operation allowed.
static int stringReduction(String str)
{
	int n = str.length();

	// Counting occurrences of three different
	// characters 'a', 'b' and 'c' in str
	int count[] = new int[3];
	for (int i=0; i<n; ++i)
		count[str.charAt(i) -'a']++;

	// Initialize DP[][] entries as -1
	for (int i = 0; i <= count[0]+1; ++i)
		for (int j = 0; j <= count[1]+1; ++j)
			for (int k = 0; k <= count[2]+1; ++k)
				DP[i][j][k] = -1;

	return length(count[0], count[1], count[2]);
}

// Driver program to test the functions above
public static void main(String args[])
{
	String str = "abcbbaacb";
	
	System.out.println("Length after reduction is " + stringReduction(str));
}

} 

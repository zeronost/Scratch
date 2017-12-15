/**
	 * <table BORDER CELLPADDING=3 CELLSPACING=1>
	 * <tr><td>ID</td><td>0003</td></tr>
	 * <tr><td>Name</td><td>Digit Counts</td></tr>
	 * <tr><td>Description</td><td>Count the number of k's between 0 and n. k can be 0 - 9.</td></tr>
	 * <tr><td>Example</td><td><p>if n = 12, k = 1 in</p><p>[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]</p>
	 * <p>we have FIVE 1's (1, 10, 11, 12)</p>
	 * </td></tr>
	 * </table>
	 * @param k
	 * @param n
	 * @return
	 */
	public static int digitCount(int k, int n){
		if(n == 0)
			return k == 0 ? 1 : 0;
		if(k > 9 || k < 0)
			return 0;
		int p = 0;
		int x = 10;
		while(n/x>0){
			p++;
			x *= 10;
		}
		x = x/10;
		int pre = 0;
		double sum = 0;
		for(int i = p; i >= 0; i--){
			if((n/x) % 10 > k ){// if current digits greater than k, than sum the k00...0 to k99...9(10^position)
				if(k != 0 || p != i)//if k == 0 and current position is the top position, ignore it.
					sum += Math.pow(10, i);
			}
			else if((n/x) % 10 == k)// if current digits equals to k, than sum the k00...0 to kab...c(ab...c + 1)
				sum += (n % x + 1);
			sum += pre * Math.pow(10, i);// for digit not in top position
			pre = pre*10 + (n/x) % 10;// recalculate previous digits.
			x = x/10;
		}
		return (int) sum;
	}

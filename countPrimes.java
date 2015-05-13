public class Solution {
    public int countPrimes(int n) {
        if(n <= 2) return 0;
        int res = 0;
        boolean[] primes = new boolean[n];
        for(int i = 2; i < n; i++){
            primes[i] = true;
        }
        for(int i = 2; i < Math.sqrt(n);i++){
            if(primes[i]){
                int j = i + i;
                while(j < n){
                    primes[j] = false;
                    j += i;
                }
            }
        }
        for(int i = 2;i < n; i++){
            if(primes[i]) {
                res++;
            }
        }
        return res;
    }
}
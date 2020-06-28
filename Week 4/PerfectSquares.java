// MULTIPLE SOLUTIONS USING RECURSION ONLY (1) AND OTHERS USING DP(2-TABULATION, 3-MEMOIZATION, 4-MEMOIZATION BUT MORE CONCISE) WITH 4 BEING ACCEPTED.
//SOLTIONS 1,2 AND 3 ALL TIME LIMIT EXCEEDED.

class Solution {
    
    //1. RECURSIVE SOLUTION : TC - exponential
    
    /*
    public int numSquares(int n) {
        //base cases: minimum square sum= (1*1)+(1*1)+...
        if(n<=3)
            return n;
        //else
        //maximum square sum will be (1*1)+(1*1)+...n times
        int res=n;
        //recursively going through all smaller number squares to get min no. of squares required
        for(int x=1;x<=Math.ceil(Math.sqrt(n));++x){
            int temp=x*x;
            if(temp>n)
                break;
            else
                res = Math.min(res, 1+numSquares(n-temp));
        }
        return res;
    }*/
    
    
    //2. DP SOLUTION USING BOTTOM-UP (TABULATION) APPROACH
    
    /*
    public int numSquares(int n){
        //base cases
        if(n<=3)
            return n;
        //else
        //Creating the array to store all smaller values
        int[] dp=new int[n+1];
        
        //stroing values of base cases
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        
        //recursively finding the solution to min squares
        for(int i=4 ; i<=n ; ++i){
            //maximum squares needed for any dp[x]=x as
            //(1*1)+(1*1)+... i times
            dp[i]=i;
            
            //finding the minimum needed recursively
            for(int x=1; x<=Math.ceil(Math.sqrt(i)); ++x){
                int temp=x*x;
                if(temp>i)
                    break;
                else
                    dp[i]=Math.min(dp[i], 1+numSquares(i-temp));
            } 
        }
        //Store answer and free dp[]
        int res=dp[n];
        return res;
    }
    */
    
    //3. DP SOLUTION WITH TOP-DOWN APPROACH (MEMOIZATION)
    
    /*
     public int numSquares(int n){
        //base cases
        if(n<=3)
            return n;
         
         //LOOKUP TABLE
         int[] lookup=new int[n+1];
         
        //stroing values of base cases
        lookup[0]=0;
        lookup[1]=1;
        lookup[2]=2;
        lookup[3]=3;
        
        //intialising all other lookup values to NIL
         final int NIL=-1;
         for(int i=4 ; i<=n ; ++i)
             lookup[i]=NIL;
        
        //maximum square sum case: (1*1)+(1*1)+...n times
        lookup[n]=n;
        
        //recursively finding the minimum
        for(int x=1; x<=Math.ceil(Math.sqrt(n)); ++x){
            int temp=x*x;
            if(temp>n)
                break;
            else{
                if(lookup[n-temp]!=NIL)     //checking if the subproblem solution exists in lookup
                    lookup[n]=Math.min(lookup[n], 1+lookup[n-temp]);
                else
                    lookup[n]=Math.min(lookup[n], 1+numSquares(n-temp));
            }
        }
         
         //Store answer and free dp[]
        int res=lookup[n];
        return res;
     }*/
    
    
    //ACCEPTED SOLUTION
    //4. DP SOLUTION WITH MEMOIZATION - MORE CONCISE THAN 3 USING ANOTHER HELPER METHOD 
    
    public int numSquares(int n) {
      int[]memo = new int[n+1];  
      return helper(n,memo);  
    }
    
    private int helper(int n,int[]memo){
        if(n == 0) 
            return 0;
        if(memo[n] > 0)
            return memo[n];
        
        //maximum is n as (1*1)+(1*1)+...n times
        int min = n;
        for(int i = 1 ;i*i <= n ;i++){
           min = Math.min(min, helper(n - (i*i),memo));
        }
        memo[n] = min+1;
      return min+1;  
    }
}

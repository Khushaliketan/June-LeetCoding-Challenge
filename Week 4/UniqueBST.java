class UniqueBST {
    public int numTrees( int n ) {  
    
        //No. of BST's = catalan_number(n) = 2nCn/(n+1) = (2n)! / ((n + 1)! * n!)
        
        return ( int )Math.round( factorial( 2 * n ) / ( factorial( 1 + n ) * factorial( n ) ) );
    }
    
    static double factorial( double n ) { 
        if ( n <= 0 ) 
            return 1; 
        return n * factorial( n - 1 );
    }
}

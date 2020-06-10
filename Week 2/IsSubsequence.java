class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        // no subsequence
        if(s.length()==0)
            return true;
        
        //no string
        if(t.length()==0)
            return false;
        
        //Same strings or not
        if(s.length()==t.length()){
            if(t.equals(s))
                return true;
            else
                return false;
        }
        
        boolean flag=true;
        int a=t.indexOf(s.charAt(0));
        if(a<0 || a>=t.length())
            return false;
        int y=0;
        for(int i=1; i<s.length();++i){
            y=t.indexOf(s.charAt(i), a+1);
            if(y<0 || y>=t.length()){
                flag=false;
                break;
            }
            else
                a=y;
        }
        return flag;
    }
}

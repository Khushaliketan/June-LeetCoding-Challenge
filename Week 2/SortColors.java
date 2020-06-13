class SortColors {
    public void sortColors(int[] arr) {
        /* BUBBLE SORT
        
        int i, j, temp; 
        boolean swapped;
        int n=arr.length;
        //bubble sort
        for (i = 0; i < n - 1; i++)  
        { 
            swapped = false; 
            for (j = 0; j < n - i - 1; j++)  
            { 
                if (arr[j] > arr[j + 1])  
                { 
                    // swap arr[j] and arr[j+1] 
                    temp = arr[j]; 
                    arr[j] = arr[j + 1]; 
                    arr[j + 1] = temp; 
                    swapped = true; 
                } 
            } 
  
            // IF no two elements were  
            // swapped by inner loop, then break 
            if (swapped == false) 
                break; 
        } 
        */
        
        // Dutch National Flag Algo
        
        int n=arr.length;
        int low=0, mid=0, high=n-1;
        while(mid<=high){
            if(arr[mid]==0){
                int temp=arr[mid];
                arr[mid]=arr[low];
                arr[low]=temp;
                ++low;
                ++mid;
            }
            else if(arr[mid]==1){
                ++mid;
            }
            else if(arr[mid]==2){
                int temp=arr[mid];
                arr[mid]=arr[high];
                arr[high]=temp;
                --high;
            }
        }
    }
}

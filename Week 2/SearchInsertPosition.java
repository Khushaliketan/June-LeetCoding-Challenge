class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(target<=nums[0])
            return 0;
        for(int i=1;i<nums.length;++i){
            if(nums[i]==target)
                return i;
            else{
                if(target<nums[i] && target>nums[i-1])
                    return i;
            }
        }
        return nums.length;       //reached the end of array and haven't found the target, hence postion n.
    }
}

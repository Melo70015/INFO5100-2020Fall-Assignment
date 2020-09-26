package assignment2_2;

public class ArrayMaxSum {

	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) 
			return 0;
		int max = Integer.MIN_VALUE, cur = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (cur <= 0) {
                cur = nums[i];
               
            } else {
                cur += nums[i];
            }
 
            if (cur > max) {
                max = cur;
                
            }
        }
		
        return max;
	}
	
	
    public static void main(String[] args) {
       ArrayMaxSum sum= new ArrayMaxSum();
       int[ ] a={-1,-2,4,-3,4};
       int output = sum.maxSubArray(a);
       System.out.println(output);
    }


}

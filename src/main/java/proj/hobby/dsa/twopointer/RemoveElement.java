package proj.hobby.dsa.twopointer;

/**
 *
 * https://leetcode.com/problems/remove-element/description/
 *
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int[] temp = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length);

        int k=0;
        for(int i=0, j=nums.length-1; i < nums.length; i++) {
            if(temp[i] == val){
                //System.out.println("=="+j);
                while(j >= 0 && temp[j] == val) {
                    //System.out.println(".."+j);
                    j--;
                }
                if(j >= 0) {
                    nums[i] = temp[j];
                    j--;
                }
                //System.out.println("[i,j] >> ["+i+", "+j+"]");
            } else{
                k++;
            }
        }
        //System.out.println(" nums >> "+Arrays.toString(nums));
        return k;
    }
}

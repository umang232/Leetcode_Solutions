class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0){
            return;
        }
        if(m == 0){
            for(int i=0;i<n;i++){
                nums1[i] = nums2[i];
            }
            return;
        }
        int i = m-1;
        int last = m+n-1;
        int j = n-1;
        while(j>=0){
            if(i >= 0 && nums1[i] > nums2[j]){
                nums1[last] = nums1[i];
                i--;
                last--;
            }else{
                nums1[last] = nums2[j];
                j--;
                last--;
            }
        }
    }
}
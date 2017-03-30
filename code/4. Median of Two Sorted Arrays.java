public class Solution {
    public double findKth(int[] nums1, int sa, int ea, int[] nums2, int sb, int eb, int k){
		int m = ea - sa;
		int n = eb - sb;
		if(m > n){
			return findKth(nums2, sb, eb, nums1, sa, ea, k);
		}
		if(m < 0){
			return nums2[sb + k - 1];
		}
		if(k == 1){
			return Math.min(nums1[sa], nums2[sb]);
		}
		int pa = Math.min(k / 2, m + 1);
		int pb = k - pa;
		if(nums1[sa + pa - 1] == nums2[sb + pb - 1]){
			return nums1[sa + pa - 1];
		}
		else if(nums1[sa + pa - 1] < nums2[sb + pb - 1]){
			return findKth(nums1, sa + pa, ea, nums2, sb, eb, k - pa);
		}
		else {
			return findKth(nums1, sa, ea, nums2, sb + pb , eb, k - pb);
		}
	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	    int len1 = nums1.length;
	    int len2 = nums2.length;
	    if((len1 + len2) % 2 == 1){
	    	return findKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, (len1 + len2) / 2 + 1);
	    }
	    else{
	    	double temp1 = findKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, (len1 + len2) / 2);
	    	double temp2 = findKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, (len1 + len2) / 2 + 1);
	    	return (temp1 + temp2) / 2;
	    }
	}
}
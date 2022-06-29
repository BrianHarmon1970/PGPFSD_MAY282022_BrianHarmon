package com.harmonengineering.datastructures;

class RotateArray {
    public void rotate(int[] nums, int k) {
        if(k > nums.length)
            k=k%nums.length;
        int[] result = new int[nums.length];
        if (k >= 0) System.arraycopy(nums, nums.length - k, result, 0, k);
        int j=0;
        for(int i=k; i<nums.length; i++){
            result[i] = nums[j];
            j++;
        }
        System.arraycopy( result, 0, nums, 0, nums.length );
    }
    public static void main(String[] args) {
        RotateArray r = new RotateArray();
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        r.rotate(arr, 5);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}


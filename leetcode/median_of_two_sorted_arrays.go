package main

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	for _,k:=range nums2{
		nums1=append(nums1,k)
	}
x :=len(nums1)
for i:=0;i<x-1;i++{
	for j:=0;j<len(nums1)-1-i;j++{
		if nums1[j]>nums1[j+1]{
			nums1[j],nums1[j+1]=nums1[j+1],nums1[j]
		}
	}
}
var res float64
if(x%2==0){
	y :=x/2
	res =  float64((nums1[y]+nums1[y-1]))/2
}else {
	y:=x/2
	res = float64(nums1[y])
}
return res
}
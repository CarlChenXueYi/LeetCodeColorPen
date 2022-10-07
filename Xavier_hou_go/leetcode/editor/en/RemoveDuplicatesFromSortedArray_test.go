package cn

import (
	"testing"
)

func TestRemoveDuplicatesFromSortedArray(t *testing.T) {
	t.Log(removeDuplicates([]int{0, 0}))
	t.Log(removeDuplicates([]int{0}))
	t.Log(removeDuplicates([]int{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}))
}

//leetcode submit region begin(Prohibit modification and deletion)
func removeDuplicates(nums []int) int {
	slow := 0
	quick := 0

	for slow < len(nums) {

		nums[slow] = nums[quick]

		for nums[quick] == nums[slow] && quick < len(nums) {
			quick++
			if quick == len(nums) {
				//fmt.Println(nums)
				//fmt.Println(slow+1)
				return slow + 1
			}
		}

		slow++
	}

	//fmt.Println(nums)
	//fmt.Println(slow)
	return slow
}

//leetcode submit region end(Prohibit modification and deletion)

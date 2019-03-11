package main
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
 func mergeKLists(lists []*ListNode) *ListNode {
    if l := len(lists); l < 1 {
        return nil
    }else if l == 1 {
        return lists[0]
    }else{
        startList := lists[0]
        for _, list := range lists[1:]{
            startList = merge2Lists(startList, list)
        }
        return startList
    }
    
}

func merge2Lists(l1 *ListNode, l2 *ListNode) *ListNode {
	if nil == l1 {
		return l2
	}
	if nil == l2 {
		return l1
	}

	if l1.Val < l2.Val {
		l1.Next = mergeTwoLists(l1.Next, l2)
		return l1
	} else {
		l2.Next = mergeTwoLists(l1, l2.Next)
		return l2
	}
}

// func merge2Lists(l1, l2 *ListNode) *ListNode {
//     len1, i := len(l1), 0
//     len2, j := len(l2), 0
//     l3 := make([]*ListNode, len1+len2)

//     for k := 0; k < len1+len2; k++ {
//         if i == len1 ||
//             (i < len1 && j < len2 && l1[i] > l2[j]) {
//             res[k] = l2[j]
//             j++
//             continue
//         }

//         if j == len2 ||
//             (i < len1 && j < len2 && l1[i] <= l2[j]) {
//             res[k] = l1[i]
//             i++
//         }
//     }
//     return res
// }
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public var val: Int
 *     public var next: ListNode?
 *     public init() { self.val = 0; self.next = nil; }
 *     public init(_ val: Int) { self.val = val; self.next = nil; }
 *     public init(_ val: Int, _ next: ListNode?) { self.val = val; self.next = next; }
 * }
 */
class Solution {

    func findNextNodeIndex(in lists: [ListNode?]) -> Int? {

        var resultIndex: Int?

        for indexOfList in 0..<lists.count {

            guard let currentNode = lists[indexOfList] else {
                continue
            }

            guard let resultIndexUnwrapped = resultIndex else {
                resultIndex = indexOfList
                continue
            }

            let resultNode = lists[resultIndexUnwrapped]!

            if currentNode.val < resultNode.val {
                resultIndex = indexOfList
            }
        }

        return resultIndex
    }

    func mergeTwoLists(_ list1: ListNode?, _ list2: ListNode?) -> ListNode? {
        
        // 1. Create a variable which will store root node of resulting list
        // 2. Create a variable which will store the last element of resulting list
        // 3. Create a variable which will hold lists in one array
        // 4. Find the node with maximum value
        // 5. Put this node into resulting list
        // 6. Replace this node with next node
        // 7. Repeat loop until all nodes will be nil

        if list1 == nil || list2 == nil {
            return list1 ?? list2
        }

        var rootNode: ListNode?
        var lastNode: ListNode?

        var lists = [list1, list2]

        while true {

            guard let nextNodeIndex = findNextNodeIndex(in: lists) else {
                break
            }

            let nextNode = lists[nextNodeIndex]

            lastNode?.next = nextNode
            lastNode = nextNode

            if rootNode == nil {
                rootNode = nextNode
            }

            if nextNode?.next != nil {
                lists[nextNodeIndex] = nextNode?.next
                continue
            }

            // Optimize++
            lists.remove(at: nextNodeIndex)

            if lists.count == 1 {
                lastNode?.next = lists.first!
                return rootNode
            }
            // Optimize --
        }

        return rootNode
    }
}
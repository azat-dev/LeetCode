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

    private func getMiddleNodeIndex(for length: Int) -> Int {

        return length / 2
    }

    private func move(middleNode: ListNode?, by numberOfSteps: Int) -> ListNode? {

        if numberOfSteps == 0 {
            return middleNode
        }

        var currentMiddleNode = middleNode

        for _ in 0..<numberOfSteps {
            currentMiddleNode = currentMiddleNode?.next
        }

        return currentMiddleNode
    }

    func middleNode(_ head: ListNode?) -> ListNode? {
        
        var length = 0
        
        var currentMiddleNode = head
        var currentMiddleNodeIndex = 0

        var currentNode = head

        while true {

            guard currentNode != nil else {
                break
            }

            length += 1

            let middleNodeIndex = getMiddleNodeIndex(for: length)
            let middleNodeDiff = middleNodeIndex - currentMiddleNodeIndex

            print(middleNodeDiff)
            currentMiddleNode = move(middleNode: currentMiddleNode, by: middleNodeDiff)
            currentMiddleNodeIndex = middleNodeIndex

            currentNode = currentNode?.next
        }

        return currentMiddleNode
    }
}
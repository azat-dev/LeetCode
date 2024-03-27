/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public var val: Int
 *     public var next: ListNode?
 *     public init(_ val: Int) {
 *         self.val = val
 *         self.next = nil
 *     }
 * }е
 */

class Solution {

    func hasCycle(_ head: ListNode?) -> Bool {
        
        var slow: ListNode? = head
        var fast: ListNode? = head?.next

        while fast != nil {

            if slow === fast {
                return true
            }

            slow = slow?.next
            fast = fast?.next?.next
        }

        return false
    }
}
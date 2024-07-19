/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    private static class ListsIterator {
        private final ListNode[] lists;
        private final PriorityQueue<Item> queue;

        ListsIterator(ListNode[] lists) {
            this.lists = lists;
            this.queue = new PriorityQueue(
                IntStream.range(0, lists.length)
                    .mapToObj(listIndex -> {
                        final var node = lists[listIndex];
                        if (node == null) {
                            return null;
                        }

                        return new Item(
                            listIndex,
                            node.val
                        );
                    })
                    .filter(Objects::nonNull)
                    .toList()
            );
        }

        ListNode next() {

            final var nextItem = queue.poll();
            if (nextItem == null) {
                return null;
            }

            final var listIndex = nextItem.listIndex();
            final var nextNode = lists[listIndex];
            lists[listIndex] = nextNode.next;
            
            final var newNode = lists[listIndex];
            if (newNode == null) {
                return nextNode;
            }

            this.queue.offer(
                new Item(
                    listIndex,
                    newNode.val
                )
            );

            return nextNode;
        }

        static record Item(
            int listIndex,
            int val
        ) implements Comparable<Item> {

            @Override
            public int compareTo(Item other) {
                return this.val - other.val;
            }
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        final var iterator = new ListsIterator(lists);

        final var root = iterator.next();
        var currentNode = root;

        while (true) {
            final var nextNode = iterator.next();
            if (nextNode == null) {
                break;
            }

            currentNode.next = nextNode;
            currentNode = nextNode;
        }

        return root;
    }
}
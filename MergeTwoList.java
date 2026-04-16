/**
 * This function merges two sorted linked lists into one sorted list.
 *
 * Imagine you have two lines of people, each already arranged from shortest to tallest.
 * This function combines both lines into a single line, still keeping everyone in order.
 *
 * Each "ListNode" represents one person in line, holding a number (val)
 * and a reference to the next person (next).
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Step 1: Create a temporary starting point (dummy node)
        // This helps us build the new list without worrying about the first element
        ListNode dummy = new ListNode(-1);

        // This pointer will move along and build the merged list
        ListNode current = dummy;

        // Step 2: Compare both lists one node at a time
        // Continue as long as BOTH lists still have elements
        while (list1 != null && list2 != null) {

            // If the current value in list1 is smaller (or equal)
            if (list1.val <= list2.val) {

                // Add list1's current node to the merged list
                current.next = list1;

                // Move list1 forward to the next node
                list1 = list1.next;

            } else {
                // Otherwise, add list2's current node
                current.next = list2;

                // Move list2 forward
                list2 = list2.next;
            }

            // Move the current pointer forward in the merged list
            current = current.next;
        }

        // Step 3: If one list still has remaining elements,
        // just attach them to the end of the merged list

        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // Step 4: Return the merged list
        // We skip the dummy node and return the real start
        return dummy.next;
    }
}

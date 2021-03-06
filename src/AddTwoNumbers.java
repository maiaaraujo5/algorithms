import java.util.List;
import java.util.Objects;

import static jdk.dynalink.linker.support.Guards.isNull;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 =
                new ListNode(2,
                        new ListNode(4));

        ListNode l2 =
                new ListNode(5,
                        new ListNode(6,
                                new ListNode(4)));

        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // First Step: The actual sum has rest? If yes include +1 in then next sum.
        ListNode result = new ListNode();
        int restToAddInTheNext = 0;
        int tempResult;

        while (!Objects.isNull(l1) || !Objects.isNull(l2)) {

            if (Objects.isNull(l1)) {
                l1 = new ListNode(0);
            }

            if (Objects.isNull(l2)) {
                l2 = new ListNode(0);
            }

            if (l1.val + l2.val + restToAddInTheNext > 9) {
                tempResult = (l1.val + l2.val + restToAddInTheNext) - 10;
                restToAddInTheNext = 1;
            } else {
                tempResult = l1.val + l2.val + restToAddInTheNext;
                restToAddInTheNext = 0;
            }

            ListNode lastResultNode = result;
            while (!Objects.isNull(lastResultNode.next)) {
                lastResultNode = lastResultNode.next;
            }
            lastResultNode.val = tempResult;

            if (!Objects.isNull(l1.next) || !Objects.isNull(l2.next)) {
                lastResultNode.next = new ListNode();
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return result;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
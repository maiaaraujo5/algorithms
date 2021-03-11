import java.util.Objects;

public class RemoveKFromList {
    public static void main(String[] args) {
        ListNode l =
                new ListNode(3,
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(3, new ListNode(4, new ListNode(3))))))));

        ListNode listNode = removeKFromList(l, 3);
        System.out.println(listNode);
    }

    public static ListNode removeKFromList(ListNode l, int k) {
        ListNode actual = l;
        while (!Objects.isNull(actual)) {
            if (actual.val == k && !Objects.isNull(actual.next)) {
                actual.val = actual.next.val;
                actual.next = actual.next.next;
            } else if(actual.val == k) {
                actual = null;
            } else {
                actual = actual.next;
            }

        }
        return l;
    }
}

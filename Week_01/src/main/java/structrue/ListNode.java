package structrue;

public class ListNode {
     public int val;
     public ListNode next;
     public ListNode() {}
     public ListNode(int val) { this.val = val; next = null;}
     public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

     public String print() {
          StringBuilder sb = new StringBuilder();
          sb.append(val);
          while (next != null) {
               sb.append(" ");
               sb.append(next.val);
               next = next.next;
          }
          return sb.toString();
     }
 }
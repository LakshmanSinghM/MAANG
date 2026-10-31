class AddTwoNumbersLinkedList {

    // nodes are reused here memorywise best
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(-1);
    ListNode temp = dummy;
    int carry = 0;
    while(l1!=null || l2!=null || carry!=0){
        int sum = carry;
       if(l1!=null){
         sum = sum + l1.val;
         temp.next = l1;
         l1 = l1.next;
       }
       if(l2!=null){
        sum = sum + l2.val;
        temp.next = l2;
        l2 = l2.next;
       }

       if(temp.next==null){
        temp.next = new ListNode(-1);
       }
       if(sum<10){
         temp.next.val = sum;
         carry=0;
       }else {
        temp.next.val = sum%10;
        carry = sum/10;
       }
       temp = temp.next;
       }
       return dummy.next;
    }



    //better new nodes are created here

    // public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // ListNode dummy = new ListNode(-1);
    // ListNode temp = dummy;
    // int carry = 0;
    // while(l1!=null || l2!=null || carry!=0){
    //     int sum = carry;
    //    if(l1!=null){
    //      sum = sum + l1.val;
    //      l1 = l1.next;
    //    }
    //    if(l2!=null){
    //     sum = sum + l2.val;
    //     l2 = l2.next;
    //    }
    //    if(sum<10){
    //      temp.next = new ListNode(sum);
    //      carry=0;
    //    }else {
    //     temp.next = new ListNode(sum%10);
    //     carry = sum/10;
    //    }
    //    temp = temp.next;
    //    }
    //    return dummy.next;

    // }
}
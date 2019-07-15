class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<Integer>();
        int carry = 0;
        while(l1 != null || l2 != null){
            int val1 = 0;
            int val2 = 0;
            if(l1 != null){
                val1 = l1.val;
            }else{
                val1 = 0;
            }
            if(l2 != null){
                val2 = l2.val;
            }else{
                val2 = 0;
            }
            System.out.println("val1 " +val1);
            System.out.println("val2" + val2);
            int sum = val1 + val2 + carry;
            System.out.println(sum);
            System.out.println(carry);
            list.add(sum % 10);
            if(sum >= 10){
                System.out.println("Inside carry");
                carry = 1;
            }else{
                carry = 0;
            }
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        
        if(carry != 0){
            list.add(carry);
        }
        System.out.println(list);
        ListNode newList = null;
        for(int i = 0; i < list.size();i++){
            ListNode n = new ListNode(list.get(i));
            if(newList == null){
                newList = n;
            }else{
                ListNode ptr = newList;
                while(ptr.next != null) {
                    ptr = ptr.next;
                }
                ptr.next = n;
            }
        }
        return newList;
    }
}

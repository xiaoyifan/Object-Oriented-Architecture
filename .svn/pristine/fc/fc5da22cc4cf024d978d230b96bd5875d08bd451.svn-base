public class BondList {
	private ListNode head;
	private int count;
	public BondList(){
		head = null;
		count = 0;
	}
	public BondList(ListNode node){
		head = node;
		count = 1;
	}
	public void add(ListNode node){
		if(count == 0){
			head = node;
		}
		else{
			node.next = head.next;
			head.next = node;
		}
		count++;
	}
	public void remove(Component b){
		if(count == 0){
			System.out.println("BondList is empty!");
		}
		else{
			count--;
			ListNode cur = head;
			ListNode pre = null;
			while(cur != null){
				if(cur.val == b) break;
				pre = cur;
				cur = cur.next;
			}
			if(pre == null){
				head = head.next;
			}
			else if(cur == null){
				System.out.println("Bond not found!");
			}
			else{
				pre.next = cur.next;
			}
		}
	}
	public ListNode getHead(){
		return head;
	}
	
}

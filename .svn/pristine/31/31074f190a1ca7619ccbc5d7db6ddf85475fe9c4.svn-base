public class BondIterator extends Iterator{

	private ListNode current;
	private ListNode first;
	
	public BondIterator(BondList list){
		first = list.getHead();
		current = list.getHead();
	}
	public ListNode getFirst() {
		return first;
	}
	public boolean hasNext() {
		if(current == null) return false;
		return true;
	}
	public ListNode next() {
		ListNode tmp = current;
		current = current.next;
		return tmp;
	}
	public ListNode getCurrent() {
		return current;
	}

}

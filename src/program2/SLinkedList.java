package program2;

public class SLinkedList {
	protected Node head; // head node of the list
	protected long size; // number of nodes in the list
	protected Node tail;

	/** Default constructor that creates an empty list */
	public SLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public void addFirst(Node v) {
		v.setNext(head);
		head = v;
		size++;
	}

	public void addLast(Node v) {
			
		v.setNext(null);
		if(size == 0)
			head = v;
		else
			tail.setNext(v);
		tail = v;
		size++;
	}

	public void removeFirst() {
		if (head == null) {
			String errorMessage = "there's an error";
		}

		Node t = head;
		head = head.getNext();
		t.setNext(null);
		size--;

	}

	// return current list size
	public long getListSize() {
		return size;
	}

	// get the first node in the list
	public Node getFirstNode() {
		return head;
	}

	// get the next node in the list
	public Node getNextNodeInList(Node n) {
		return n.getNext();
	}

	public void updateNodeInList(Node n, String information) {
		n.setElement(information);
	}
}

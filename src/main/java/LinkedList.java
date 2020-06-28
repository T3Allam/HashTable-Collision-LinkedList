public class LinkedList<E> {
    private ListNode<E> head;
    private ListNode<E> tail;
    private int size;

    public LinkedList() {
        this.size = 0;
        this.head = new ListNode<E>(null);
        this.tail = new ListNode<E>(null);
        this.head.element = null;
        this.tail.element = null;
        this.head.next = tail;
        this.tail.prev = head;
    }

    public void append(E element) {
        ListNode<E> newNode = new ListNode<E>(element);
        newNode.prev = tail.prev;
        newNode.next = newNode.prev.next;
        newNode.next.prev = newNode;
        newNode.prev.next = newNode;
        this.size +=1;
    }

    public void addToFront(E element) {
        ListNode<E> newNode = new ListNode<>(element);
        newNode.next = head.next;
        newNode.prev = head;
        newNode.next.prev = newNode;
        newNode.prev.next = newNode;
        size+=1;
    }

    public ListNode<E> get (E element) {
        ListNode<E> i = this.head;
        while (i.next.element!= null) {
            if (i.next.element.equals(element)) {
                return i.next;
            }
            i = i.next;
        }
        return null;
    }

    public void remove(E element) {
        ListNode<E> nodeToBeRemoved = get(element);
        if (nodeToBeRemoved != null) {
            nodeToBeRemoved.next.prev = nodeToBeRemoved.prev;
            nodeToBeRemoved.prev.next = nodeToBeRemoved.next;
            nodeToBeRemoved.prev = null;
            nodeToBeRemoved.next = null;
            this.size-=1;
        } else {
            System.out.println("Element does not exits");
        }
    }

    public void set(E toBeSetElement, E updateElement) {
        ListNode<E> toBeSetNode = get(toBeSetElement);
        if (toBeSetNode != null) {
            toBeSetNode.element = updateElement;
        } else {
            System.out.println("Element you want to set does not exist");
        }
    }

    public void print(){
        ListNode<E> iterator = this.head;
        while (iterator.next.element != null){
            System.out.println(iterator.next.element);
            iterator = iterator.next;
        }
    }

    public int size() {
        return size;
    }

}

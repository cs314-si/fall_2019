import java.util.Set;

public class LinkedList<E> {

	private Node<E> first;

        private static class Node<E> {
            private E data;
            private Node<E> next;
            public E getData() {return data;}
            public Node<E> getNext() {return next;}
        }
    
    public boolean hasCycleNormal() {
        // Really should be using a HashSet but we have not learned this yet. O(N) time and space.
        Map<Node<E>, String> map = new HashMap<>();
        Node<E> temp = this.first;

        // The only case we know that the list does not have a cycle is if we get to a null eventually
        while(temp != null) {
            // This means that the node has been seen before
            if(map.get(temp) != null) {
                return true;
            }
            
            // Save this node since we have seen it
            map.put(temp, "again, this should be a set but we only know maps so we have a dummy string");
            temp = temp.next;
        }

        return false;
    }

    // Same as above but a better solution on an interview as it uses the proper data structure. O(N) time and space.
    public boolean hasCycleSets() {
        Set<Node<E>> set = new HashSet<>();
        Node<E> temp = this.first;

        while(temp != null) {
            if(set.contains(temp)) {
                return true;
            }
            set.add(temp);
            temp = temp.next;
        }

        return false;
    }

    // O(N) time and O(1) space
    public boolean hasCycleBest() {
        Node<E> fast = this.first;
        Node<E> slow = this.first;
        while (fast != null && fast.next != null) {
            if(fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}

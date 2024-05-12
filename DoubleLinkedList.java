package linkedlist;

 public class DoubleLinkedList {
     class Node{
         Object ele;
         Node prev;
         Node next;

         Node(Object e){
             ele = e;
             prev = null;
             next = null;
         }
         Node(Object e, Node p , Node n){
             ele = e;
             prev = p;
             next = n;
         }
     }
    private Node first = null;
    private int count = 0;
    public int size(){
        return count;
    }
    public void add(Object e){
        if (first == null){
            first = new Node(e);
            count++;
            return;
        }
        Node curr = first;
        while (curr.next != null){
            curr = curr.next;
        }
        curr.next = new Node(e,curr,null);
        count++;
    }
    public void add(int index , Object e){
        if (index <= -1 || index >= size())
            throw new IndexOutOfBoundsException();
        if (index == 0){
            first = new Node(e,null,first);
            count++;
            return;
        }
        Node curr = first;
        for (int i = 1; i < index; i++){
            curr = curr.next;
        }
        Node n = new Node(e,curr,curr.next);
        curr.next.prev = n;
        curr.next = n;
        count++;
    }
    public Object get(int index){
        if (index <= -1 || index >= size())
            throw new IndexOutOfBoundsException();

        Node curr = first;
        for (int i = 0; i< index; i++){
            curr = curr.next;
        }
        return curr.ele;
    }
    public void remove(int index){
        if (index <= -1 || index >= size())
            throw new IndexOutOfBoundsException();
        if (index == 0){
            first = first.next;
            count--;
            return;
        }
        Node curr = first;
        for (int i = 1; i <= index; i++){
            curr = curr.next;
        }
        curr.next.prev = curr.prev;
        curr.prev.next = curr.next;
        count--;
    }

    public static void main(String[] args) {
        DoubleLinkedList d = new DoubleLinkedList();
        d.add(10);
        d.add(0,60);
        d.add(20);
        d.add(30);
        d.add(50);
        for (int i = 0; i <d.size(); i++){
            System.out.println(d.get(i));
        }
        d.remove(0);
        d.remove(2);
        System.out.println(d.size());
        for (int i = 0; i <d.size(); i++){
            System.out.println(d.get(i));
        }
        System.out.println("____________________________");
        for (int i = d.size()-1; i >= 0; i--){
            System.out.println(d.get(i));
        }
    }
}

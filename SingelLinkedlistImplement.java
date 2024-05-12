package linkedlist;

class singellinkedlist{
    class node{
        Object ele;
        node next;

        node(Object e){
            ele = e;
            next= null;
        }
        node(Object e ,node n){
            ele = e;
            next = n;
        }
    }
    private int count = 0;
    private node first = null;

    public int size(){
        return count;
    }
    public void add(Object e){
        if (first == null){
            first = new node(e);
            count++;
            return;
        }
        node curr = first;
        while (curr.next != null){
            curr = curr.next;
        }
        curr.next = new node(e);
        count++;
    }
    public void add(Object e ,int index){
        if (index <= -1 || index >= size())
            throw new IndexOutOfBoundsException();
        if (index == 0){
            first = new node(e,first);
            count++;
            return;
        }
        node curr = first;
        for (int i = 1; i < index; i++){
            curr = curr.next;
        }
        curr.next = new node(e,curr.next);
        count++;
    }
    public Object get (int index){
        if (index <= -1 || index >= size())
            throw new IndexOutOfBoundsException();

        node curr = first;
        for (int i = 0; i < index; i++){
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
        node curr = first;
        for (int i = 1; i< index; i++){
            curr = curr.next;
        }
        curr.next = curr.next.next;
        count--;
    }
}
public class SingelLinkedlistImplement {
    public static void main(String[] args) {
        singellinkedlist s = new singellinkedlist();
        s.add(10);
        s.add(20);
        s.add(30);
        s.add(40);
        s.remove(2);
        s.add(50,1);
        System.out.println("size of the single linkedlist is : " +s.size());
        for (int i = 0; i < s.size(); i++){
            System.out.println(s.get(i));
        }
    }
}
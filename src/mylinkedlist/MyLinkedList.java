package mylinkedlist;

public class MyLinkedList {
    private Node head;

    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = newNode;

    }

    public void add(int data, int index){
        Node newNode = new Node(data);
        if(index == 0){
            addFirst(data);
            return;
        } else{
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Node nextNode = temp.next;
            temp.next = newNode;
            newNode.next = nextNode;
        }
    }

    // 1. public int length()
    // 2. public void display()
    // 3. public void deleteFirst()

    public void display(){
        
        System.out.println("do dai la: "+length());
        
        System.out.println("xoa so dau ");
        deleteFirst();
    }

    public int length(){
        int count =0;
        Node temp = head;
        while(temp != null){
            temp=temp.next;
            count++;
        }
        return count;
    }

    public void deleteFirst(){
        if(head!=null){
            head = head.next;
        }
    }
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
      
        //3->2->1
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        //1->2->3
        linkedList.display();
    }

}
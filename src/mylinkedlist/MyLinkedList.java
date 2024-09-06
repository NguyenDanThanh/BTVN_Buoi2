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
        
        if(head == null){
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> " );
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int length(){
        int count = 0;
        Node temp = head;
        while(temp != null){
            temp=temp.next;
            count ++;
        }
        return count;
    }
    public void deleteFirst(){
        head = head.next;
    }

    public void deleteLast(){
        
        if(head == null ){
            return;
        } 

        if(head.next == null){
            deleteFirst();
        }

        Node temp = head;
        Node previous = null;
        while(temp.next != null){
            previous = temp;
            temp = temp.next;
        }
        previous.next = null ;
    }
    public void delete(int index){
        if(index == 0){
            deleteFirst();
            return;
        }
        if(index == length() - 1){
            deleteLast();
            return;
        }
        Node previousNodeDelete = head;
        for (int i = 1; i < index; i++) {
            previousNodeDelete = previousNodeDelete.next;
        }
        previousNodeDelete.next = previousNodeDelete.next.next;
    }

    public void delete1(int index){
        if(index == 0){
            deleteFirst();
            return;
        }
        if(index == length() - 1){
            deleteLast();
            return;
        }
        Node temp = head;
        int count = 1;
        while(temp != null && count < index ){
            count++;
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    public boolean search(int data){
        if(head == null){
            return false;
        }
        Node temp = head;
        while(temp != null ){
            if(temp.getData()==data){
                return true;
            }
        }
        return false;
    }

    public void sort(){
        Node min = head; 
        Node maxNode = min.next;
        for (int i = 0; i < length()-1; i++) {
            if(search(min.getData())==true){
                min = maxNode;
            }
        }
    }
        
    

    public Node searchAtPosition(int index){
        if(index < 0 || index >= length())
            return null;
        Node temp = head;
        for (int i = 0; i <= index; i++) { 
            temp = temp.next;
        }
        return temp;
    }
    // ví dụ list Node là 1>2>3>4 
    // cho index = 2
    // nếu i<index thì temp sẽ = 2
    // nếu i<=index thì temp sẽ =3

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        System.out.println("sau khi add first");
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.display();

        System.out.println("sau khi add last");
        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.addLast(6);
        //1->2->3
        linkedList.display();
        linkedList.deleteFirst();
        System.out.println("xoa node dau");
        linkedList.display();
        
        System.out.println("do dai la: "+linkedList.length());

        linkedList.add(7, 3);
        System.out.println("thay doi node");
        linkedList.display();

        linkedList.deleteLast();
        System.out.println("xoa node cuoi");
        linkedList.display();

        linkedList.delete1(2);
        System.out.println("xoa vi tri index");
        linkedList.display();

        linkedList.sort();
        System.out.println("sap xep node");
        linkedList.display();
        
    }

}
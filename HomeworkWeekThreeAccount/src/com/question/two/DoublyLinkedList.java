package com.question.two;

public class DoublyLinkedList<E> {

	private QNode<E> head;
    private QNode<E> tail;
    private int size;
    
    public DoublyLinkedList() {
        this.size = 0;
    }

    public int size() {
        int listSize = 0;
        QNode tempNode = head;
        while (tempNode != null) {
            listSize++;
            tempNode = tempNode.next;
        }
        return listSize;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addElement(E element) {
        if (head == null)
            head = tail = new QNode<>(element);
        else if (head.element == element) {
            QNode tempNode = new QNode(element);
            tempNode.next = head;
            head.prev = tempNode;
            head = tempNode;
        } else if (tail.element == element) {
            QNode newNode = new QNode(element);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            QNode newNode = new QNode(element);
            QNode temp = head;
            while (temp.next != null && temp.element != element) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next = newNode;
        }
    }

    public void writeListElements() {
        QNode temp = head;
        StringBuilder builder = new StringBuilder();
        while (temp != null) {
            builder.append("Element -> ");
            builder.append(temp.element);
            builder.append(" | ");
            System.out.print(builder.toString());
            temp = temp.next;
        }
        System.out.println();
    }

    public void removeElement(E element) {
        if (head == null)
            head = tail = new QNode<>(element);
        if (head.element == element) {
            head = head.next;
            if (head != null)
                head.prev = null;
        }
       
        else if (tail.element == element) {
            tail = tail.prev;
            if (tail != null)
                tail.next = null;
        } else {
            QNode tempNode = head;
            while (tempNode.next != null && tempNode.next.element != element) {
                tempNode = tempNode.next;
            }
            if (tempNode != null) {
                tempNode.next = tempNode.next;
                tempNode.prev = tempNode;
            }
        }
    }

    public boolean searchElement(E element) {
        QNode tempNode = head;
        while (tempNode != null) {
            if (tempNode.element == element) {
                return true;
            }
            tempNode = tempNode.next;
        }
        return false;
    }
}

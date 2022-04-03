package com.atguigu.linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        // test
        // create nodes
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        // create linked list
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);

        //show
        singleLinkedList.list();

    }
}

// define
class SingleLinkedList {
    // initialize a head node. It doesn't store any data.
    private HeroNode head = new HeroNode(0, "", "");

    // add a node to linked list
    // when not considering the order of numbers
    // 1. find the last node in the current linked list
    // 2. point next of the node to the new node
    public void add(HeroNode heroNode) {

        HeroNode temp = head;
        while (true) {
            // find the last node
            if (temp.next == null) {
                break;
            }
            // move backward if not the last node
            temp = temp.next;
        }
        // when exit from the loop, temp pointing to the last node
        // next of last node pointing to new node
        temp.next = heroNode;
    }

    public void list() {
        // check if the linked list is null
        if (head.next == null) {
            System.out.println("The linked list is null...");
            return;
        }

        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            // print out the node
            System.out.println(temp);
            // move back next
            temp = temp.next;
        }
    }

}


class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    // generator
    public HeroNode(int hNo, String hName, String hNickname) {
        this.no = hNo;
        this.name = hName;
        this.nickname = hNickname;
    }

    // Override to string
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'';
    }


}
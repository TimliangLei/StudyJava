package com.inspur;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Node {
    private int hash = -1;
    private int key = -1;
    private int value = -1;
    private Node next = null;

    public Node() {
    }

    public Node(int hash, int key, int value, Node node) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = node;
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

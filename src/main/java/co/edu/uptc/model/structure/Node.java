package co.edu.uptc.model.structure;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

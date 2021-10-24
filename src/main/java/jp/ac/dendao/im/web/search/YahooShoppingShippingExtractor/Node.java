package jp.ac.dendao.im.web.search.YahooShoppingShippingExtractor;

public class Node {
    private Node next;
    private String data;

    public Node(String data) {
        // TODO:
        this.data = data;
    }

    public Node setNext(Node node) {
        // TODO: setter
        this.next = node;
        return node;
    }

    public Node getNext() {
        // TODO: getter
        return next;
    }

    public String getData() {
        // TODO: getter
        return data;
    }

    @Override
    public String toString() {
        // TODO: data を [] で囲った文字を返す
        return "[" + data + "]";
    }

    public static void main(String[] args) {
        Node alice = new Node("Alice");
        Node bob = new Node("Bob");
        Node charlie = new Node("Charlie");
        Node diana = new Node("Diana");
        Node elmo = new Node("Elmo");
        Node fred = new Node("Fred");
        alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);

        Node p = alice;
        while (p != null) {
            System.out.print(p + " -> ");
            p = p.getNext();
        }
    }
}

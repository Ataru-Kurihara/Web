package jp.ac.dendao.im.web.search.YahooShoppingShippingExtractor;

public class a {
    private Node head;

    public a() {
        head = null;    // 最初は空っぽ
    }

    public Node getTail() {
        // TODO: 末尾のノードを返す
        // 先頭が null の場合は null を返す
        if (head == null) {
            return null;
        }
        Node p = head;
        while (p.getNext() != null) {
            p = p.getNext();
            System.out.println(p+"->");
        }
     return null;
    }

    public void offer(String str) {
        // TODO: 末尾にstrをデータとするノードを追加する


    }

    public String peekFirst() {
        // TODO: 先頭のノードを参照して、データを返す
        // 先頭が null の場合は null を返す
        if (head == null) {
            return null;
        }
        return "";
    }

    public String poll() {
        // 先頭が null の場合は null を返す
        if (head == null) return null;
        String headStr = head.getData();
        head = head.getNext();
        return headStr;
    }

    public String toString() {
        return "キューの中身: " + toString(head);
    }

    public String toString(Node p) {
        if (p == null) {
            return "null";
        }
        return p.toString() + " -> " + toString(p.getNext());
    }

    public static void main(String[] args) {
        a queue = new a();

        System.out.println(queue);
        queue.offer("abc");
        System.out.println(queue);
        queue.offer("def");
        System.out.println(queue);
        queue.offer("ghi");
        System.out.println(queue);
        queue.offer("jkl");
        System.out.println(queue);
        queue.offer("mno");
        System.out.println(queue);
        System.out.println("peek: " + queue.peekFirst());
        System.out.println(queue);
        System.out.println("poll: " + queue.poll());
        System.out.println(queue);
        System.out.println("poll: " + queue.poll());
        System.out.println(queue);
        System.out.println("poll: " + queue.poll());
        System.out.println(queue);
        System.out.println("peek: " + queue.peekFirst());
        System.out.println(queue);
        System.out.println("poll: " + queue.poll());
        System.out.println(queue);
        System.out.println("poll: " + queue.poll());
        System.out.println(queue);
        System.out.println("poll: " + queue.poll());
        System.out.println(queue);
        System.out.println("peek: " + queue.peekFirst());
        System.out.println(queue);
    }
}


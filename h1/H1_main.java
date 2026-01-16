package h1;

public class H1_main {
    public static void main(String[] args) {

        Node e = new Node(null);
        Node d = new Node(e);
        Node c = new Node(d);
        Node b = new Node(c);
        Node a = new Node(b);

        System.out.println(distance(a, e)); // Output = 4   
        System.out.println(distance(a, c)); // Output = 2
        System.out.println(distance(a, a)); // Output = 0

        
    }

    public static int distance(Node x, Node y) {

        if (x == y) {
            return 0;
        
        }

        return 1 + distance(x.getNext(), y);
}

}

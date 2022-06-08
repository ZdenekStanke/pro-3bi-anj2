package cz.spsmb.b3i.w36.graph_traverse;

public class Test {
    public static void main(String[] args) {
        Graph graph = new Graph();
        Node currN = new Node(0);
        Node currN1 = new Node(1);
        Node currN2 = new Node(2);
        Node currN3 = new Node(3);
        Node currN4 = new Node(4);
        Node currN5 = new Node(5);
        Node currN6 = new Node(6);
        Node currN7 = new Node(7);
        Node currN8 = new Node(8);
        Node currN9 = new Node(9);
        Node currN10 = new Node(10);
        Node currN11 = new Node(11);
        Node currN12 = new Node(12);
        Node currN13 = new Node(13);
        Node currN14 = new Node(14);
        Node currN15 = new Node(15);
        Node currN16 = new Node(16);
        Node currN17 = new Node(17, true);
        Node currN18 = new Node(18);



        graph.getHead().nextNodeList.add(currN);

        currN.nextNodeList.add(currN1);
        currN1.nextNodeList.add(currN2);
        currN2.nextNodeList.add(currN3);
        currN2.nextNodeList.add(currN9);
        currN2.nextNodeList.add(currN18);
        currN3.nextNodeList.add(currN4);
        currN4.nextNodeList.add(currN5);
        currN4.nextNodeList.add(currN6);
        currN6.nextNodeList.add(currN7);
        currN7.nextNodeList.add(currN8);
        currN8.nextNodeList.add(currN9);
        currN9.nextNodeList.add(currN10);
        currN10.nextNodeList.add(currN11);
        currN11.nextNodeList.add(currN14);
        currN11.nextNodeList.add(currN12);
        currN12.nextNodeList.add(currN13);
        currN14.nextNodeList.add(currN15);
        currN15.nextNodeList.add(currN16);
        currN16.nextNodeList.add(currN17);



        //currN8.nextNodeList.add(currN3);

        //graph.printGraphDFS(graph.getHead());
        System.out.print(graph.getNodeListDFS());
    }
}

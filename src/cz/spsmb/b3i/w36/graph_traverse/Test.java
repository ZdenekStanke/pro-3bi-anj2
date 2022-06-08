package cz.spsmb.b3i.w36.graph_traverse;

public class Test {
    public static void main(String[] args) {
        Graph graph = new Graph();
        Node currN = new Node(1);
        Node currN2 = new Node(2);
        Node currN3 = new Node(3);
        Node currN4 = new Node(4);
        Node currN5 = new Node(5);
        Node currN6 = new Node(6);
        Node currN7 = new Node(7);
        Node currN8 = new Node(8, true);

        graph.getHead().nextNodeList.add(currN);

        currN.nextNodeList.add(currN2);
        currN.nextNodeList.add(currN4);

        currN4.nextNodeList.add(currN2);
        currN4.nextNodeList.add(currN5);
        currN4.nextNodeList.add(currN6);

        currN2.nextNodeList.add(currN3);

        currN6.nextNodeList.add(currN3);
        currN6.nextNodeList.add(currN7);

        currN3.nextNodeList.add(currN8);

        //currN8.nextNodeList.add(currN3);

        //graph.printGraphDFS(graph.getHead());
        System.out.print(graph.getNodeListDFS());
    }
}

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Integer, Node> nodeMap = new HashMap<>();
        Deque<Node> queue = new ArrayDeque<>();

        if (node == null) return null;

        Node copyRoot = new Node(1);
        nodeMap.put(1, copyRoot);
        queue.add(node);

        while (!queue.isEmpty()) {
            Node root = queue.poll();
            Node copy = nodeMap.get(root.val);

            for (Node connectNode : root.neighbors) {
                Node newNode = nodeMap.getOrDefault(connectNode.val, new Node(connectNode.val));
                
                if (!nodeMap.containsKey(connectNode.val)) {
                    nodeMap.put(newNode.val, newNode);
                    queue.add(connectNode);
                }

                copy.neighbors.add(newNode);
            }
        }

        return copyRoot;
    }
}
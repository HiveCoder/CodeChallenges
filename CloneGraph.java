class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>();

        return dfs(node, map);
    }

    private Node dfs(Node node, HashMap<Node, Node> map) {
        // If we've already cloned this node, return the clone
        if (map.containsKey(node)) {
            return map.get(node);
        }

        // Create a clone of the current node
        Node clone = new Node(node.val);

        // Store it before visiting neighbors
        map.put(node, clone);

        // Clone all neighbors
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, map));
        }

        return clone;
    }
}

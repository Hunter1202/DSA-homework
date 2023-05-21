package homework7.Bai5;

public class KDTree {
    private Node root;

    public KDTree() {
        root = null;
    }

    public void insert(Point point) {
        root = insertNode(root, point, 0);
    }

    private Node insertNode(Node root, Point point, int depth) {
        if (root == null) {
            return new Node(point);
        }

        int currentDepth = depth % 2;

        if (currentDepth == 0) {
            if (point.x < root.point.x) {
                root.left = insertNode(root.left, point, depth + 1);
            } else {
                root.right = insertNode(root.right, point, depth + 1);
            }
        } else {
            if (point.y < root.point.y) {
                root.left = insertNode(root.left, point, depth + 1);
            } else {
                root.right = insertNode(root.right, point, depth + 1);
            }
        }

        return root;
    }

    public Point findNearestNeighbor(Point target) {
        Node nearestNode = findNearestNeighbor(root, target, null, 0);
        return nearestNode != null ? nearestNode.point : null;
    }

    private Node findNearestNeighbor(Node root, Point target, Node nearest, int depth) {
        if (root == null) {
            return nearest;
        }

        if (nearest == null || distance(root.point, target) < distance(nearest.point, target)) {
            nearest = root;
        }

        int currentDepth = depth % 2;

        Node nextBranch = null;
        Node oppositeBranch = null;

        if (currentDepth == 0) {
            if (target.x < root.point.x) {
                nextBranch = root.left;
                oppositeBranch = root.right;
            } else {
                nextBranch = root.right;
                oppositeBranch = root.left;
            }
        } else {
            if (target.y < root.point.y) {
                nextBranch = root.left;
                oppositeBranch = root.right;
            } else {
                nextBranch = root.right;
                oppositeBranch = root.left;
            }
        }

        nearest = findNearestNeighbor(nextBranch, target, nearest, depth + 1);

        if (shouldCheckOppositeSubtree(root, target, nearest, depth)) {
            nearest = findNearestNeighbor(oppositeBranch, target, nearest, depth + 1);
        }

        return nearest;
    }

    private double distance(Point p1, Point p2) {
        int dx = p2.x - p1.x;
        int dy = p2.y - p1.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    private boolean shouldCheckOppositeSubtree(Node node, Point target, Node nearest, int depth) {
        int currentDepth = depth % 2;

        if (currentDepth == 0) {
            double dx = Math.abs(target.x - node.point.x);
            return dx < distance(nearest.point, target);
        } else {
            double dy = Math.abs(target.y - node.point.y);
            return dy < distance(nearest.point, target);
        }
    }

    public static void main(String[] args) {
        KDTree kdTree = new KDTree();

        // Inserting points into the KD tree
        kdTree.insert(new Point(3, 6));
        kdTree.insert(new Point(17, 15));
        kdTree.insert(new Point(13, 15));
        kdTree.insert(new Point(6, 12));
        kdTree.insert(new Point(9, 1));
        kdTree.insert(new Point(2, 7));
        kdTree.insert(new Point(10, 19));

        // Finding the nearest neighbor to a target point
        Point target = new Point(5, 8);
        Point nearestNeighbor = kdTree.findNearestNeighbor(target);

        if (nearestNeighbor != null) {
            System.out.println("Nearest Neighbor: (" + nearestNeighbor.x + ", " + nearestNeighbor.y + ")");
        } else {
            System.out.println("No nearest neighbor found.");
        }
    }
}

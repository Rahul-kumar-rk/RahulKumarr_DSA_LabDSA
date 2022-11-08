package Problem_2;

import java.util.*;

public class Nodes_Sum {

	public static class Node {

		int key;
		Node left, right;

		public Node(int data) {
			this.key = data;
		}
	}

	public Node insertElement(Node root, int x) {
		if (root == null) {
			return (new Node(x));
		}
		if (x < root.key)
			root.left = insertElement(root.left, x);
		else if (x > root.key)
			root.right = insertElement(root.right, x);
		else // Duplicate keys not allowed
			return root;

		return root;
	}

	static Queue<Integer> queue = new LinkedList<>();
	static Queue<Integer> queue1 = new LinkedList<>();

	public void inorderTraversal(Node node) {
		if (node == null)
			return;
		inorderTraversal(node.left);
		queue.add(node.key);
		queue1.add(node.key);
		inorderTraversal(node.right);

	}

	public static void main(String[] args) {
		Nodes_Sum hi = new Nodes_Sum();
		Node root = null;
		int[] arr = { 40, 20, 60, 10, 30, 50, 70 }; // BST
		for (int i : arr) {
			if (root == null) {
				root = hi.insertElement(root, i);
			} else {
				root = hi.insertElement(root, i);
			}
		}
		hi.inorderTraversal(root);

		System.out.println("Give the Input For The Sum");
		Scanner sc = new Scanner(System.in);
		int requiredSum = sc.nextInt();

		Integer node1 = null;
		Integer node2 = null;
		if (!queue.isEmpty()) {
			for (Integer i : queue) {
				boolean b = false;
				int sum = 0;
				for (Integer j : queue1) {
					if (i != j) {
						sum = i + j;
						if (requiredSum == sum) {
							node1 = i;
							node2 = j;
							b = true;
							break;
						}
					}
				}
				if (b)
					break;

			}
		}
		if (node1 != null && node2 != null) {
			System.out.println("Sum = " + requiredSum);
			System.out.println("Pair is(" + node1 + ", " + node2 + " )");
		} else {
			System.out.println("nodes are not found.");
		}
	}
}

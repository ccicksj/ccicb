package com.qkjt.qkkt.common.tree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 多叉树类
 */

public class MultipleTree {

	private Node root = null;

	public MultipleTree(HashMap<String, Node> nodeList) {
		// 构造无序的多叉树
		Set entrySet = nodeList.entrySet();
		for (Iterator it = entrySet.iterator(); it.hasNext();) {
			Node node = (Node) ((Map.Entry) it.next()).getValue();
			if (node.parentId == null || node.parentId.equals("")) {
				root = node;
			} else {
				((Node) nodeList.get(node.parentId)).addChild(node);
			}
		}

	}

	public Node findById(String id) {
		if (root == null || root.getChildren().getSize() == 0)
			return null;

		if (root.id.equals(id)) {
			return root;
		}

		List<Node> list = root.getAllChildren();
		if (list == null) {
			return null;
		} else {
			for (Node n : list) {
				if (n.id.equals(id)) {
					return n;
				}
			}
		}
		return null;
	}

	public Node getRoot() {
		return root;
	}

}

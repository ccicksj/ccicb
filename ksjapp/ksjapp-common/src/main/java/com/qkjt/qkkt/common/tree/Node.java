package com.qkjt.qkkt.common.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 节点类
 */
public class Node {
	/**
	 * 节点编号
	 */
	public String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	/**
	 * 节点内容
	 */
	public String text;
	/**
	 * 节点的内容类
	 */
	public Object bObject;
	/**
	 * 父节点编号
	 */
	public String parentId;
	/**
	 * 孩子节点列表
	 */
	private Children children = new Children();

	// 先序遍历，拼接JSON字符串
	public String toString() {
		String result = "{" + "id : '" + id + "'" + ", text : '" + text + "'";

		if (children != null && children.getSize() != 0) {
			result += ", children : " + children.toString();
		} else {
			result += ", leaf : true";
		}

		return result + "}";
	}

	// 兄弟节点横向排序
	public void sortChildren() {
		if (children != null && children.getSize() != 0) {
			children.sortChildren();
		}
	}

	// 添加孩子节点
	public void addChild(Node node) {
		this.children.addChild(node);
	}

	public Children getChildren() {
		return children;
	}

	public void setChildren(Children children) {
		this.children = children;
	}

	public List<Node> getAllChildren() {
		if (this.children.getSize() == 0)
			return null;

		List<Node> list = new ArrayList<Node>();
		for (Node n : this.children.getList()) {
			list.add(n);
			if (n.getAllChildren() != null) {
				for (Node m : n.getAllChildren()) {
					list.add(m);
				}
			}
		}
		return list;

	}

}

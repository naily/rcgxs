package com.ghy.bean;

import lombok.Data;

public @Data class TreeNode {
	
    private String id;    
	
    private String text;   
    
    private boolean leaf;    
    
    private String cls;
    
    private boolean checked;

    /**
     * 参数次序 ： id ,text , leaf , checked
     * @param id
     * @param text
     * @param leaf
     * @param checked
     */
	public TreeNode(int id, String text, boolean leaf, boolean checked) {
		super();
		this.id = String.valueOf(id);
		this.text = text;
		this.leaf = leaf;
		this.checked = checked;
	}
	public TreeNode(){};
	
	public TreeNode(String id, String text, boolean leaf) {
		super();
		this.id = id;
		this.text = text;
		this.leaf = leaf;
	}
    
}

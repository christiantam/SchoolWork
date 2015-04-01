/**
 * This class represents an ordered dictionary using a binary search tree.
 * @author ctam68
 * @author Student ID: 250679865
 *
 */	
public class BinarySearchTree implements BinarySearchTreeADT{
	private BSTNode root;
	
	/**
	 * Default constructor which creates a tree whose root is a leaf node.
	 */
	public BinarySearchTree(){
		root = null;
	}
	
	/**
	 * Returns the DictEntry storing the given key, if the key is stored in the tree. Returns null otherwise.
	 */
	public DictEntry find (Position key){
		BSTNode temp = findHelper(root, key);
		if(temp.getDictEntry() == null){
			return null;
		}
		else{
			return temp.getDictEntry();
		}
	}
	
	/**
	 * Given a tree and a key, searches through the tree looking for the given key by calling itself recursively.
	 *
	 * @return null - if key is not found in tree, the node where it WOULD be in the tree
	 * @return node - the node which holds the input key
	 */
	private BSTNode findHelper(BSTNode node, Position key){
		if(node.getDictEntry() == null){
			return node;
		}
		int search = key.compareTo(node.getKey());
				
		//checks if the current node holds the key
		if(search == 0){
			return node;
		}
		//compareTo returned -1, which means that the key, if it is in the tree, will be stored somewhere in the left child of node
		else if(search == -1){
			return findHelper(node.getLeft(), key);
		}
		//compareTo returned 1, which means that the key, if it is in the tree, will be stored somewhere in the right child of node
		else{
			return findHelper(node.getRight(), key);
		}
	}
	
	/**
	 * Inserts the given data in the tree if no data item with the same key is already there. If a node already stores
	 * the same key, the algorithm throws a BSTException.
	 */
	public void insert(DictEntry data) throws BSTException{
		//first check if there is a node in the tree
		if(root == null){
			root = new BSTNode(data);
			root.setLeft(new BSTNode(null));
			root.setRight(new BSTNode(null));
		}
		//tree is not empty
		else{
			BSTNode location = findHelper(root, data.getPosition());
			//check for duplicates
			if(location.getDictEntry() != null){
				throw new BSTException("Cannot insert duplicate items.");
			}
			//no duplicates, enter the data into the tree
			else{
				location.setData(data);
				location.setLeft(new BSTNode(null));
				location.setRight(new BSTNode(null));
			}
		}
	}
	
	/**
	 * Removes the data item with the given key, if the key is stored in the tree. Throws a BSTException otherwise.
	 */
	public void remove (Position key) throws BSTException{
		BSTNode location = findHelper(root, key);
		
		//check if key exists in tree
		if(location.getDictEntry() == null){
			throw new BSTException("Cannot remove data item which does not exist in tree.");
		}
		//key exists in tree, so remove it
		//key has no children
		if((location.getLeft().getDictEntry() == null) && (location.getRight().getDictEntry() == null)){
			//check if key is the root
			//key is not the root
			if(location.getKey().compareTo(root.getKey()) != 0){
				//find out whether the key is a left node or right node 
				int search = location.getParent().getKey().compareTo(location.getKey());
				//left child
				if(search == 1){
					location.getParent().setLeft(new BSTNode(null));
				}
				//right child
				else if(search == -1){
					location.getParent().setRight(new BSTNode(null));
				}
			}
			//key is the root
			else{
				root = null;
			}
		}
		//key has left child and no right child
		else if((location.getLeft().getDictEntry() != null) && (location.getRight().getDictEntry() == null)){
			//key is the root
			if(location.getKey().compareTo(root.getKey()) == 0){
				root = root.getLeft();
				root.setParent(null);
			}
			//key is not the root
			else{
				//find out whether the key is a left node or right node 
				int search = location.getParent().getKey().compareTo(location.getKey());
				//left child
				if(search == 1){
					location.getParent().setLeft(location.getLeft());
				}
				//right child
				else if(search == -1){
					location.getParent().setRight(location.getLeft());
				}
			}
		}
		//key has right child and no left child
		else if((location.getLeft().getDictEntry() == null) && (location.getRight().getDictEntry() != null)){
			//key is the root
			if(location.getKey().compareTo(root.getKey()) == 0){
				root = root.getRight();
				root.setParent(null);
			}
			//key is not the root
			else{
				//find out whether the key is a left node or right node 
				int search = location.getParent().getKey().compareTo(location.getKey());
				//left child
				if(search == 1){
					location.getParent().setLeft(location.getRight());
				}
				//right child
				else if(search == -1){
					location.getParent().setRight(location.getRight());
				}
			}
		}
		//key is internal node
		else if((location.getLeft().getDictEntry() != null) && (location.getRight().getDictEntry() != null)){
			//traverse until you get to the left most child of the right child to get the successor
			BSTNode temp = location.getRight();
			
			//location's right child does not have a left child
			if(temp.getLeft().getDictEntry() == null){
				temp.setLeft(location.getLeft());
				
				//key is the root
				if(location.getKey().compareTo(root.getKey()) == 0){
					temp.setParent(null);
					root = temp;
				}
				//key is not the root
				else{
					//find out whether the key is a left node or right node 
					int search = location.getParent().getKey().compareTo(location.getKey());
					//left child
					if(search == 1){
						location.getParent().setLeft(temp);
					}
					//right child
					else if(search == -1){
						location.getParent().setRight(temp);
					}
				}
			}
			//location's right child does have a left child
			else{
				while(temp.getLeft().getDictEntry() != null){
					temp = temp.getLeft();
				}
				
				temp.getParent().setLeft(temp.getRight());
				temp.setLeft(location.getLeft());
				temp.setRight(location.getRight());
				
				//key is the root
				if(location.getKey().compareTo(root.getKey()) == 0){
					temp.setParent(null);
					root = temp;
				}
				//key is not the root
				else{
					//find out whether the key is a left node or right node 
					int search = location.getParent().getKey().compareTo(location.getKey());
					//left child
					if(search == 1){
						location.getParent().setLeft(temp);
					}
					//right child
					else if(search == -1){
						location.getParent().setRight(temp);
					}
				}
			}
		}
	}
	
	/**
	 * Returns the DictEntry with the smallest key larger than the given one (note that the tree does not need to store
	 * a node with the given key). Returns null if the given word key has no successor.
	 */
	public DictEntry successor(Position key){
		//node with the given key is not in the tree
		BSTNode search = findHelper(root,key);
		if(search.getDictEntry() == null){
			//insert the key into the tree
			try {insert(new DictEntry(key, 0));	} catch (BSTException e) {}
			search = findHelper(root,key);
			
			//check if new key is the largest, if it is, it has no successor
			if(largest().getPosition().compareTo(key) == 0){
				try {remove(key);} catch (BSTException e) {}
				return null;
			}
			
			//traverse up the tree until you find a parent whose left child is the node you are looking at
			//i.e. until parent's left child is search
			BSTNode parent = search.getParent();
			while(parent != null){
				if(parent.getKey().compareTo(search.getKey()) == 1){
					try {remove(key);} catch (BSTException e) {}
					return parent.getDictEntry();
				}
				search = parent;
				parent = parent.getParent();
			}
			//if it gets all the way here, the root must be the successor
			try {remove(key);} catch (BSTException e) {}
			return root.getDictEntry();
		}
		//node with the given key is in the tree
		else{
			//check if node is the largest, if it is, it has no successor
			if(largest().getPosition().compareTo(key) == 0){
				return null;
			}
			//node has a right child
			if(search.getRight().getDictEntry() != null){
				//traverse until you get to the left most child of the right child
				BSTNode temp = search.getRight();
				//right child has no left child
				if(temp.getLeft().getDictEntry() == null){
					return temp.getDictEntry();
				}
				//right child has a left child
				while(temp.getLeft().getDictEntry() != null){
					temp = temp.getLeft();
				}
				return temp.getDictEntry();
			}
			//node does not have a right child
			else{
				//traverse up the tree until you find a parent whose left child is the node you are looking at
				//i.e. until parent's left child is search
				BSTNode parent = search.getParent();
				while(parent != null){
					if(parent.getKey().compareTo(search.getKey()) == 1){
						return parent.getDictEntry();
					}
					search = search.getParent();
					parent = parent.getParent();
				}
				//if it gets all the way here, the root must be the successor
				System.out.println("No way");
				return root.getDictEntry();
				
			}
		}
	}
	
	/**
	 * Returns the DictEntry with the largest key smaller than the given one (note that the tree does not need to store
	 * a node with the given key). Returns null if the given word key has no predecessor.
	 */
	public DictEntry predecessor (Position key){
		//node with the given key is not in the tree
		BSTNode search = findHelper(root,key);
		if(search.getDictEntry() == null){
			//insert the key into the tree
			try {insert(new DictEntry(key, 0));	} catch (BSTException e) {}
			search = findHelper(root,key);
			
			//check if new key is the smallest, if it is, it has no predecessor
			if(smallest().getPosition().compareTo(key) == 0){
				try {remove(key);} catch (BSTException e) {}
				return null;
			}
			
			//traverse up the tree until you find a parent whose right child is the node you are looking at
			//i.e. until parent's right child is search
			BSTNode parent = search.getParent();
			while(parent != null){
				if(parent.getKey().compareTo(search.getKey()) == -1){
					try {remove(key);} catch (BSTException e) {}
					return parent.getDictEntry();
				}
				search = parent;
				parent = parent.getParent();
			}
			//if it gets all the way here, the root must be the predecessor
			try {remove(key);} catch (BSTException e) {}
			return root.getDictEntry();
		}
		
		//node with the given key is in the tree
		else{
			//check if node is the smallest, if it is, it has no predecessor
			if(smallest().getPosition().compareTo(key) == 0){
				return null;
			}
			//node has a left child
			if(search.getLeft().getDictEntry() != null){
				//traverse until you get to the right most child of the left child
				BSTNode temp = search.getLeft();
				//left child has no right child
				if(temp.getRight().getDictEntry() == null){
					return temp.getDictEntry();
				}
				//left child has a right child
				while(temp.getRight() != null){
					temp = temp.getRight();
				}
				return temp.getDictEntry();
			}
			//node does not have a left child
			else{
				BSTNode parent = search.getParent();
				while(parent != null){
					if(parent.getKey().compareTo(search.getKey()) == -1){
						return parent.getDictEntry();
					}
					search = parent;
					parent = parent.getParent();
				}
				//if it gets all the way here, the root must be the predecessor
				System.out.println("No way");
				return root.getDictEntry();
			}
		}
	}
	
	/**
	 * Returns the DictEntry with the smallest key. Returns null if the tree is empty.
	 */
	public DictEntry smallest(){
		//check for empty tree
		if(root == null){
			return null;
		}
		else{
			//traverse the leftmost branches of the tree
			BSTNode search = root;
			while(search.getLeft().getDictEntry() != null){
				search = search.getLeft();
			}
			return search.getDictEntry();
		}
	}
	
	/**
	 * Returns the DictEntry with the largest key. Returns null if the tree is empty.
	 */
	public DictEntry largest(){
		//check for empty tree
		if(root == null){
			return null;
		}
		else{
			//traverse the rightmost branches of the tree
			BSTNode search = root;
			while(search.getRight().getDictEntry() != null){
				search = search.getRight();
			}
			return search.getDictEntry();
		}
	}
}

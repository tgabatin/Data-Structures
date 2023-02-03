package edu.ics211.h10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * .
 * 
 * @author Taylor D. Gabatino received help from Michael Kurts. 
 *
 * @param <E> the generic
 */
public class BinarySearchTree<E> implements SearchTree<E>, InOrder<E> {
  private BinaryNode root;
  private Comparator<E> comp;
  protected boolean addRet;
  protected E deleteRet;

  protected boolean successfulRemoval;

  /**
   * Creates a new BinarySearchTree.
   * 
   * @param comp comparator variable.
   */
  public BinarySearchTree(Comparator<E> comp) {
    this.comp = comp;
    this.root = null;

  }


  @Override
  public List<E> inorder() {
    List<E>list = new ArrayList<E>();
    inorder(root, list);
    return list;
  }


  /**
   * A helper class method for inorder.
   * @param root2 the root of the tree.
   * @param list the list of the.
   */
  private void inorder(BinarySearchTree<E>.BinaryNode root2, List<E> list) {
    if (root2 != null) {
      inorder(root2.left, list);
      list.add(root2.item);
      inorder(root2.right, list);
    }
  }


  /**
   * Calls upon the add method and adds the items within the parameters. 
   */
  @Override
  public boolean add(E item) {
    root = add(root, item);
    return addRet;
  }


  /**
   * Recursive add method.
   * 
   * @param root2 the root of the subtree.
   * @param item the object to be inserted.
   * @return the new local root.
   */
  private BinarySearchTree<E>.BinaryNode add(BinarySearchTree<E>.BinaryNode root2, E item) {
    if (root2 == null) {
      addRet = true;
      return new BinaryNode(item, root2, root2);
    } else if (comp.compare(item, root2.item) == 0) {
      addRet = false;
      return root2;
    } else if (comp.compare(item, root2.item) < 0) {
      root2.left = add(root2.left, item);
      return root2;
    } else {
      root2.right = add(root2.right, item);
      return root2;
    }

  }


  /**
   * Calls the find method and searches for the item in parameter.
   */
  @Override
  public boolean contains(E item) {
    return find(item) != null;
  }


  /**
   * Calls the find method and searches for the item in parameters.
   */
  @Override
  public E find(E target) {
    return find(root, target);
  }


  /**
   * Recursive searches for the node.
   * @param root2 subtree root.
   * @param target object being found.
   * @return object if found otherwise null.
   */
  private E find(BinarySearchTree<E>.BinaryNode root2, E target) {
    if (root2 == null) {
      return null;
    }
    int compResult = comp.compare(target, root2.item);
    if (compResult == 0) {
      return root2.item;
    } else if (compResult < 0) {
      return find(root2.left, target);
    } else {
      return find(root2.right, target);
    }
  }


  /**
   * Calls the delete method and deleted items in parameter.
   * @param the target items.
   */
  @Override
  public E delete(E target) {
    root = delete(target, root);
    return deleteRet;
  }


  /**
   * Recursively searches for the node to delete. 
   * @param target The target item to be deleted.
   * @param root2 the root of the BinaryNode.
   * @return the root of the binaryNode.
   */
  private BinarySearchTree<E>.BinaryNode delete(E target, BinarySearchTree<E>.BinaryNode root2) {
    if (root2 == null) {
      deleteRet = null;
      return root2;
    }
    int compResult = comp.compare(target, root2.item);
    if (compResult < 0) {
      root2.left = delete(target, root2.left);
    } else if (compResult > 0) {
      root2.right = delete(target, root2.right);
    } else {
      deleteRet = root2.item;

      if (root2.left == null) {
        return root2.right;
      } else if (root2.right == null) {
        return root2.left;
      } else {
        if (root2.left.right == null) {
          root2.item = root2.left.item;
          root2.left = root2.left.left;
          return root2;
        } else {
          return root2;
        }

      }
    }
    return root2;
  }


  /**
   * Calls upon the remove method and deletes the item in target.
   */
  @Override
  public boolean remove(E target) {
    return delete(target) != null;

  }

  /**
   * A class for the binary nodes.
   * 
   * @author Taylor D. Gabatino
   *
   */
  private class BinaryNode {
    private E item;
    private BinaryNode left;
    private BinaryNode right;

    public BinaryNode(E item, BinaryNode left, BinaryNode right) {
      this.item = item;
      this.left = left;
      this.right = right;
    }
  }
}

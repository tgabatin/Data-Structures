package edu.ics211.h11;

/**
 * A binary tree node for use in a Huffman tree.
 *
 * <p>Each node has both a left or right child, which can be null.
 * 
 * <p>Each node may store data (if a leaf node) or the data field might be 
 * null (for internal nodes).
 * 
 * <p>When building a Huffman tree, it is handy to track to the counts of each 
 * node's contained value or the sum of the values of its subtrees. This count 
 * value defaults to 0. HuffmanNodes can be sorted based on this count value, with
 * smaller counts coming before larger. This count is not self-managing, so it 
 * should be updated manually if any of the node's children change.
 *
 * @author Zach Tomaszewski
 * @param <E> the type of the node.
 */
public class HuffmanNode<E> implements Comparable<HuffmanNode<E>> {

  private E data;
  private int count;
  private HuffmanNode<E> left;
  private HuffmanNode<E> right;


  /**
   * Constructs a new node with the given data, count, and references 
   * to the given left and right nodes.
   * 
   * @param data the data for the node.
   * @param count the count for the node.
   * @param left the left child.
   * @param right the right child.
   */
  public HuffmanNode(E data, int count, HuffmanNode<E> left, HuffmanNode<E> right) {
    this.data = data;
    this.count = count;
    this.left = left;
    this.right = right;
  }


  /**
   * Constructs a new node containing the given data and count. 
   * Its left and right references will be set to null.
   * 
   * @param data the data.
   * @param count the count.
   */
  public HuffmanNode(E data, int count) {
    this(data, count, null, null);
  }


  /**
   * Constructs a new internal node with the given two children. 
   * The new node's data will be null and its count will be
   * the sum of that in its two children.
   * 
   * @param left the left child.
   * @param right the right child.
   */
  public HuffmanNode(HuffmanNode<E> left, HuffmanNode<E> right) {
    this(null, 0, left, right);
    count += (this.getLeft() == null) ? 0 : this.getLeft().getCount();
    count += (this.getRight() == null) ? 0 : this.getRight().getCount();
  }


  /**
   * Constructs a new node with no data, a count of 0, and no children. 
   * Since data is null, this will be an internal node.
   */
  public HuffmanNode() {
    this(null, 0, null, null);
  }


  /** Returns the count stored in this node. 
   * @return the count.
   */
  public int getCount() {
    return count;
  }


  /** Updates the count stored in this node.
   * @param count the new count.
   */
  public void setCount(int count) {
    this.count = count;
  }


  /** Returns the item currently stored in this node. May be null.
   * @return the data.
   */
  public E getData() {
    return data;
  }


  /** Overwrites the item stored in this Node with the given data item.
   * @param data the new data.
   */
  public void setData(E data) {
    this.data = data;
  }


  /**
   * Returns this Node's left child. If there is no left left, returns null.
   * @return the left child.
   */
  public HuffmanNode<E> getLeft() {
    return left;
  }


  /** 
   * Causes this Node to point to the given left child Node.
   * @param left the new left child.
   */
  public void setLeft(HuffmanNode<E> left) {
    this.left = left;
  }


  /**
   * Returns this nodes right child. If there is no right child, returns null.
   * 
   * @return the right child.
   */
  public HuffmanNode<E> getRight() {
    return right;
  }


  /**
   * Causes this Node to point to the given right child Node.
   * 
   * @param right the new right child.
   */
  public void setRight(HuffmanNode<E> right) {
    this.right = right;
  }


  /**
   * True if both of this node's children are null.
   * 
   * @return true if both of this node's children are null.
   */
  public boolean isLeaf() {
    return this.left == null && this.right == null;
  }


  @Override
  public int compareTo(HuffmanNode<E> other) {
    // smaller counts before larger
    return this.count - other.count;
  }


  /**
   * Returns this node's value (if any; "*" if not) and its count 
   * in parentheses. If E is Byte, will also include a
   * 'char' view of any printable byte value.
   */
  @Override
  public String toString() {
    String str = "";
    if (this.data == null) {
      str += "*";
    } else {
      // in standard printable ASCII range
      str += this.data;
      if (this.data instanceof Byte) {
        byte b = (Byte) this.data;
        if (b >= 32 && b < 127) {
          str += " '" + (char) b + "'";
        } else if (b == 9) {
          str += " 'TAB'"; // tab
        } else if (b == 10) {
          str += " 'LF'"; // line feed (\n)
        } else if (b == 13) {
          str += " 'CR'"; // carriage return (\r)
        }
      }
    }
    str += " (x " + this.count + ")";
    return str;
  }


  /**
   * Returns a multi-line string showing this node as the root of a tree. 
   * Each node is on its own line, displayed as per {@link #toString()}, 
   * but preceded by the given prefix. The prefix is extend by "&lt;" for 
   * each recursive call on a left child and by "&gt;" for each call to a right child.
   * 
   * @param prefix The prefix.
   * @return The String representation of this node.
   */
  public String toFullString(String prefix) {
    String str = prefix + this.toString() + "\n";
    if (this.getLeft() != null) {
      str += this.getLeft().toFullString(prefix + "<");
    }
    if (this.getRight() != null) {
      str += this.getRight().toFullString(prefix + ">");
    }
    return str;
  }
}
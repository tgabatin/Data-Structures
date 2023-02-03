package edu.ics211.h04;

import edu.ics211.h02.Beer;

import java.util.Comparator;

/**
 * Represents a SortableBeerList.
 *
 * @author Taylor D. Gabatino received help from Carleton Moore.
 *
 */
public class SortableBeerList implements IList211<Beer> {

  private SortableList<Beer> beers;
  private Comparator<Beer> comp;


  /**
   * A constructor for SortableBeerList.
   * 
   * @param c the beer to be compared.
   */
  public SortableBeerList(Comparator<Beer> c) {
    this.beers = new SortableList<Beer>();
    this.comp = c;
  }


  /**
   * Gets the beer at the index specified.
   */

  @Override
  public Beer get(int index) {
    return beers.get(index);
  }


  /**
   * Sets the element at the specified index.
   */
  @Override
  public Beer set(int index, Beer element) {
    Beer b = beers.set(index, element);
    beers.bubbleSort(this.comp);
    return b;
  }


  /**
   * Returns the index of the object in parameters.
   */
  @Override
  public int indexOf(Object obj) {

    return beers.indexOf(obj);
  }


  /**
   * Returns the size of the list of beers.
   */
  @Override
  public int size() {
    return beers.size();
  }


  /**
   * Adds a beer type to the end of the list.
   */
  @Override
  public boolean add(Beer e) {
    boolean b = beers.add(e);
    beers.bubbleSort(comp);
    return b;
  }


  /**
   * Adds a beer type to the index specified in the list.
   */
  @Override
  public void add(int index, Beer element) {
    beers.add(index, element);
    beers.bubbleSort(comp);
  }


  /**
   * Removes the beer at the specified index.
   */
  @Override
  public Beer remove(int index) {
    return beers.remove(index);
  }

}

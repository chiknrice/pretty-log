package org.chiknrice.log;

/**
 * @author <a href="mailto:chiknrice@gmail.com">Ian Bondoc</a>
 */
public interface Cell {

    boolean hasMoreData();

    String readData(int maxLenght);

}

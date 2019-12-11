/**
 * 
 */
package com.utils;

import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Transformer;

import java.util.*;

/**
 * @author ubuntu
 *
 */
public class ArrayUtils extends org.apache.commons.lang3.ArrayUtils {
	/**
     * Returns a transformed list by the given list.
     * <p>
     * Each object is passed through the transformer as it is added to the
     * List. The original collection is not changed due to the transformation operation.
     *
     * @param source  the collection to predicate, must not be null
     * @param transformer  the transformer for the collection, must not be null
     * @return a transformed collection backed by the given collection
     */
/*    public static <T, V> T[] transformArray( V[] source, T[] destinatioType, Transformer<T,V> transformer) {
    	return transformArray(source, destinatioType, transformer, true);
    }*/
	/**
     * Returns a transformed list by the given list.
     * <p>
     * Each object is passed through the transformer as it is added to the
     * List. The original collection is not changed due to the transformation operation.
     *
     * @param source  the collection to predicate, must not be null
     * @param transformer  the transformer for the collection, must not be null
     * @param ignoreNull - define if <i>null</i> the return value by transformer would be added to the returned array.
     * @return a transformed collection backed by the given collection
     */
/*    public static <T, V> T[] transformArray( V[] source, T[] destinatioType, Transformer<T,V> transformer, boolean ignoreNull) {
    	
    	List<T> result = new ArrayList<>();
    	for( int i=0; i<source.length; i++){
    		T obj = transformer.transform( source[i] );
    		if( !ignoreNull || obj != null ){
    			result.add(obj);
    		}
    	}
    	return result.toArray(destinatioType);
    }*/
    /**
     * Sort the passed array according to the specified comparator
     * @param source - define a source array would be sorted
     * @param comparator - define a comparator would be used to sort the specified array.
     * @return a new sorted array according to the specified comparator.
     */
	public static <T> T[] sort(T[] source, Comparator<T> comparator) {
		SortedSet<T> set = new TreeSet<>( comparator );
		set.addAll( Arrays.asList( source ) );
		return set.toArray( source );
	}
	/** 
     * Executes the given closure on each element in the array.
     * 
     * @param closure  the closure to perform, may be null
     * @param values  the array to get the input from, may be null
     */
	public static <T> void forAllDo(Closure closure, @SuppressWarnings("unchecked") T ... values) {
		for( T value : values ){
			closure.execute(value);
		}
	}
}

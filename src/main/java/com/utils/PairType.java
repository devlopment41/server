package com.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * PairType was created to provide the generic type to include property-value
 * structure.
 *
 * @author vitaly
 * @since 2.4.2 <br>
 * based on JDK 1.7 <br>
 * created at Dec 18, 2013
 */
public class PairType<T, V> {

	protected T left;
	protected V right;

	/**
	 * Used for serialization/deserialization mechanism.
	 * <b>Note: don't use it</b>
	 * Constructor.
	 */
	protected PairType() {}

	/**
	 * Constructor.
	 *
	 * @param property
	 * @param value
	 */
	public PairType(T property, V value) {
		this.left = property;
		this.right = value;
	}

	/**
	 * @return the property
	 */
	@JsonIgnore
	public T getProperty() {
		return left;
	}

	public T getLeft() { return left; }

	/**
	 * @return the value
	 */
	@JsonIgnore
	public V getValue() {
		return right;
	}

	public V getRight() { return right;}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PairType)) {
			return false;
		}
		PairType<?, ?> other = (PairType<?, ?>) obj;
		if (left == null) {
			if (other.left != null) {
				return false;
			}
		} else if (!left.equals(other.left)) {
			return false;
		}
		if (right == null) {
			if (other.right != null) {
				return false;
			}
		} else if (!right.equals(other.right)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "[" + left + "=" + right + "]";
	}

	public static class PairStrings extends PairType<String, String> {

		public PairStrings(String property, String value) {
			super(property, value);
		}

		public PairStrings(String property, String value, String def) {
			super(property, value != null && !value.equals("null") ? value : def);
		}
	}

	public static class MutablePairType<T, V> extends PairType<T, V> {
		/**
		 * Used for serialization/deserialization mechanism.
		 * <b>Note: don't use it</b>
		 * Constructor.
		 */
		public MutablePairType() {
		}

		/**
		 * Constructor.
		 *
		 * @param property
		 * @param value
		 */
		public MutablePairType(T property, V value) {
			super(property, value);
		}

		public void setLeft(T value) { super.left = value; }

		public void setRight(V value) { super.right = value; }
	}
}

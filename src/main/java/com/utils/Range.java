package com.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Range is used to specify an a type safe range of values which can conclude a period and a specific values
 * 
 * @author vitaly
 * @param <T>
 * @since 2.2.5 <br>
 *        based on JDK 1.7 created at Sep 16, 2013
 */
public class Range<T extends Comparable<T>> {

	List<Item<T>> range = new ArrayList<>();

	public List<Item<T>> getRange(){
		return Collections.unmodifiableList(range);
	}
	public Range<T> addValue(T value) {
		range.add(new Item<T>(value));
		return this;
	}

	public Range<T> addValues(@SuppressWarnings("unchecked") T... values) {
		for (T value : values) {
			addValue(value);
		}
		return this;
	}

	public Range<T> addPeriod(T from, T to) {
		range.add(new PeriodItem<T>(from, to));
		return this;
	}

	/**
	 * Check if the passed value is in this specified range.
	 * 
	 * @param value
	 *            - would be checked.
	 * @return <i>true</i> if and only if the passed value equals to one of the
	 *         specified simple values or in range of one of the specified
	 *         periods, otherwise - <i>false</i>.
	 */
	public boolean inRange(T value) {
		for (Item<T> item : range) {
			if (item.compareTo(value) == 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Range:[");
		result.append( StringUtils.join(range, ",") ).append("]");
		return result.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Range<?> range1 = (Range<?>) o;

		return org.apache.commons.collections4.CollectionUtils.isEqualCollection( range, range1.range);

	}

	@Override
	public int hashCode() {
		return range != null ? range.hashCode() : 777;
	}

	static class Item<T extends Comparable<T>> implements Comparable<T> {
		protected T value;

		public Item(T val) {
			value = val;
		}

		@Override
		public int compareTo(T o) {
			return value.compareTo(o);
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
		
		public T getValue(){
			return value;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Item<?> item = (Item<?>) o;

			return value != null ? value.equals(item.value) : item.value == null;

		}

		@Override
		public int hashCode() {
			return value != null ? value.hashCode() : 0;
		}
	}

	static class PeriodItem<T extends Comparable<T>> extends Item<T> {
		protected T to;


		public PeriodItem(T from, T to) {
			super(from);
			this.to = to;
		}
		
		public T getToValue(){
			return to;
		}

		@Override
		public int compareTo(T o) {
			if (value.compareTo(o) <= 0 && to.compareTo(o) >= 0) {
				return 0;
			} else if (value.compareTo(o) > 0) {
				return -1;
			} else {//if (to.compareTo(o) < 0) {
				return 1;
			}
		}

		@Override
		public String toString() {
			return value + "-" + to;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof PeriodItem)) return false;
			if (!super.equals(o)) return false;

			PeriodItem<?> that = (PeriodItem<?>) o;

			return to != null ? to.equals(that.to) : that.to == null;
		}

		@Override
		public int hashCode() {
			int result = super.hashCode();
			result = 31 * result + (to != null ? to.hashCode() : 0);
			return result;
		}
	}

}

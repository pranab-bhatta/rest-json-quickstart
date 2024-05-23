package com.acme;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(includeFieldNames = true)
public class Fruit {

	@Getter
	@Setter
	private long id;
	
	@Getter
	@Setter
	private String fruitName;

	@Getter
	@Setter
	private double cost;
	
	public Fruit(final long id, final String fruitName, final double cost) {
		this.id = id;
		this.fruitName = fruitName;
		this.cost = cost;
	}
}

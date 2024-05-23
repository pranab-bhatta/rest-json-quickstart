package com.acme;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FruitService {

	private Set<Fruit> fruits = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

	public FruitService() {
		fruits.add(new Fruit(1, "Apple", 40.00));
		fruits.add(new Fruit(2, "Pineapple", 100.50));
	}

	public Set<Fruit> list() {
		return fruits;
	}

	public Fruit listOne(long id) {
		return fruits.stream().filter(each -> each.getId() == id).findFirst().orElse(null);
	}

	public Set<Fruit> add(Fruit fruit) {
		fruits.add(fruit);
		return fruits;
	}

	public void delete(long id) {
		fruits.removeIf(existingFruit -> existingFruit.getId() == id);
	}
}
package com.acme;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(includeFieldNames = true)
public class Todos {
	
	@Getter
	@Setter
	private int userId;
	
	@Getter
	@Setter
	private int id;
	
	@Getter
	@Setter
	private String title;
	
	@Getter
	@Setter
	private String completed;

}

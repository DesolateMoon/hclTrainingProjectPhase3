package com.junit.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@EqualsAndHashCode
@Getter
public class User {
	private String userName; 
	private String password;
	private String role;
}

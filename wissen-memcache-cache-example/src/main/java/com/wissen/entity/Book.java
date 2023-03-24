package com.wissen.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3477208752710443516L;

	@Id 
	@GeneratedValue
	private long id;
	
	private String name;
	
	private String desc;
	
	public Book(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}
}

package com.learning.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Id;
@Data
@Entity
@Table(name="Food")
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	@NotBlank
	@Size(max=50)
	private String foodName;
	@NotNull
	private int foodCost;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private FoodType foodType;
	@NotBlank
	@Size(max=50)
	private String description;
	@NotBlank
	private String foodPic;

}

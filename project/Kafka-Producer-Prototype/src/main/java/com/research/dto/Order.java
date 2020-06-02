package com.research.dto;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {
	private String uuid;
	@NotBlank
	@Size(min = 2, max = 5, message = "Name should be min {min} max {max}")
	private String name;
	
	@DecimalMin(value="1")
	private int quantity;
}

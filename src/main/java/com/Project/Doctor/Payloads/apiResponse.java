package com.Project.Doctor.Payloads;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class apiResponse {

	private String message;
	private Boolean success;
	
	
}

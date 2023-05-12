package com.Project.Doctor.Payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class DoctorDTO {
	
 private long id;
	 
	 @NotEmpty
	 @Size(min=4,message="name must be more than 4 characters")
	  private String first_name;
	 
	 @NotEmpty
	 private String last_name;
	 
	 @NotEmpty
	 @Size(min=5,max=10,message="password must be less than 10 chars and more than 5chars")
	 private String password;
	 
	 @NotEmpty
	 private String  address;
	 
	 @Email(message="Entered email address is not valid")
	 private String email;
	 
	 @NotEmpty
	 private String specialization;
	 
	

}

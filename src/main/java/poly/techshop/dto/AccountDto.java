package poly.techshop.dto;


import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto implements Serializable{
	@NotEmpty
	@Length(min = 6)
private String username;
	@NotEmpty
	@Length(min = 6)
private String password;
	private String Fullname;
	private String Email;
	private String photo;
	private Boolean isEdit = false;


}

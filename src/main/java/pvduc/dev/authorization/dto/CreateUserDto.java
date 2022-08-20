package pvduc.dev.authorization.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class CreateUserDto implements Serializable {
	@NotNull
	private final String email;
	private final String firstName;
	private final String lastName;
	private final String avatar;
}

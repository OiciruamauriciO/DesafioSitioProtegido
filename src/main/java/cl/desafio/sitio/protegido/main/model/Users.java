package cl.desafio.sitio.protegido.main.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users implements Serializable {	
	
	private static final long serialVersionUID = 6439058569400379813L;
	private String email;
	private String password;
	private Role role;
	
}

package co.app.splitwise.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	String userId;
	String name;
	String email;
	String mobile;
	
	public boolean equals(User user) {
		return this.userId == user.userId;
	}
}

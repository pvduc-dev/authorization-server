package pvduc.dev.authorization.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(
	name = "users",
	uniqueConstraints = {
		@UniqueConstraint(columnNames = "email")
	}
)
public class User {
	@Id
	@Column(columnDefinition = "UUID default gen_random_uuid()")
	private UUID id;

	@NotNull
	@Column(name = "email", nullable = false)
	private String email;

	private String password;

	@Column(columnDefinition = "boolean default true")
	private Boolean isEnable;

	@Column(columnDefinition = "boolean default false")
	private Boolean isEmailVerified;

	private String firstName;

	private String lastName;

	private String avatarUrl;

	@Column(nullable = false, updatable = false, insertable = false)
	@CreationTimestamp
	private Timestamp createdAt;

	@Column(nullable = false, updatable = false, insertable = false)
	@UpdateTimestamp
	private Timestamp updatedAt;


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		User user = (User) o;
		return id != null && Objects.equals(id, user.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}

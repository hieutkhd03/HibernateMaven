package hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "role", schema = "db_hiberate_advance")
public class Role {
	@Id
	@Column(name = "id", nullable = false)
	private java.lang.Long id;

	@Column(name = "name", length = 265)
	private java.lang.String name;

}
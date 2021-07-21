package the.coyote.cdc.Author;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.URL;

@Entity
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull @URL 
	private String urlGithub;
	
	@PastOrPresent
	private LocalDateTime createAt = LocalDateTime.now();

	public Author(@NotNull String name, @NotNull @URL String urlGithub) {
		this.name = name;
		this.urlGithub = urlGithub;
	}

	@Override
	public String toString() {
		return "Author [name=" + name + ", urlGithub=" + urlGithub + ", createAt=" + createAt + "]";
	}

}

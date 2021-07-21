package the.coyote.cdc.Author;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

public class AuthorForm {

	@NotNull
	private String name;
	
	@NotNull @URL
	private String urlGithub;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrlGithub() {
		return urlGithub;
	}
	public void setUrlGithub(String urlGithub) {
		this.urlGithub = urlGithub;
	}
	
	
	public AuthorForm() {}
	
	public AuthorForm(@NotNull String name, @NotNull @URL String urlGithub) {
		super();
		this.name = name;
		this.urlGithub = urlGithub;
	}
	public Author newAuthor() {
		return new Author(name, urlGithub);
	};
	
	
	
	
}

package the.coyote.cdc.Author;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
	
	private AuthorRepository repository;
	
	@Autowired
	public AuthorController(AuthorRepository repository) {
		super();
		this.repository = repository;
	}



	@PostMapping(value = "/api/Author")
	public String newAuthor(@RequestBody @Valid AuthorForm form) {
		Author newAuthor = form.newAuthor();
		repository.save(newAuthor);
		return "Author registered successfuly";
	}

	
}

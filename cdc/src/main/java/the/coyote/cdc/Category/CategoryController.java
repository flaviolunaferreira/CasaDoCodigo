package the.coyote.cdc.Category;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

	private CategoryRepository repository;
	
	@Autowired
	public CategoryController(CategoryRepository repository) {
		this.repository = repository;
	}

	@InitBinder("categoryForm")
	public void init(WebDataBinder dataBinder) {
		dataBinder.addValidators(new ValidingCategory(repository));
	}
	

	@PostMapping(value = "/api/category")
	public String newCategory(@RequestBody @Valid CategoryForm form) {
		Category newCategory = new Category(form.getName());
		repository.save(newCategory);
		return "Category registered succesfuly";
	}

	
}

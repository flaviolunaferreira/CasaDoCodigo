package the.coyote.cdc.Category;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ValidingCategory implements Validator {

	private CategoryRepository repository;
	
	public ValidingCategory(CategoryRepository categoryRepository) {
		this.repository = categoryRepository;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CategoryForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		CategoryForm form = (CategoryForm) target;
		Optional<Category> possibleCategory = repository.findByName(form.getName());
		if (possibleCategory.isPresent()) {
			errors.rejectValue("name", null, "This Category already exist!");
		}
	}

}

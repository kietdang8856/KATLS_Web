package KALTS.DoAnWebJava.Validator;

import KALTS.DoAnWebJava.Validator.annotation.ValidCategoryId;
import KALTS.DoAnWebJava.entity.Category;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, Category>{
    @Override
            public boolean isValid(Category category, ConstraintValidatorContext context){
        return category != null && category.getId() != null;
    }
}


package br.com.training.annotation;

import br.com.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailNotExistValidation implements ConstraintValidator<EmailNotExist, String> {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isValid(String field, ConstraintValidatorContext constraintValidatorContext) {
        return userRepository.findByEmail(field) == null;
    }

}

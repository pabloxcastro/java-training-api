package br.com.training.annotation;

import br.com.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class KeyUniqueValidation implements ConstraintValidator<KeyUnique, String> {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isValid(String field, ConstraintValidatorContext constraintValidatorContext) {

        if (field.length() > 11) {
            return userRepository.findByEmail(field) == null;
        } else {
            return userRepository.findByCpf(field) == null;
        }

    }

}

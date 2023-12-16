package edu.Sim3LR5.service;

import edu.Sim3LR5.service.Interface.ValidationService;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import edu.Sim3LR5.exception.ValidationFailedException;

@Service
public class RequestValidationService implements ValidationService {
    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult.getFieldError().toString());
        }
    }
}

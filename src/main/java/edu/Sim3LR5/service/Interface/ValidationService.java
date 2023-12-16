package edu.Sim3LR5.service.Interface;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import edu.Sim3LR5.exception.ValidationFailedException;

@Service
public interface ValidationService{
    void isValid(BindingResult bindingResult) throws ValidationFailedException;
}

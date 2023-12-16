package edu.Sim3LR5.service.Interface;

import edu.Sim3LR5.model.Response;
import edu.Sim3LR5.model.Request;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
@Service
public interface ResponseException {
    ResponseEntity<Response> ResponseExceptions(Request request, BindingResult bindingResult);
}

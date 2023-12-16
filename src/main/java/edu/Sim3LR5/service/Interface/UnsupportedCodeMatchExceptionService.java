package edu.Sim3LR5.service.Interface;

import edu.Sim3LR5.exception.UnsupportedCodeException;
import edu.Sim3LR5.model.Request;
import org.springframework.stereotype.Service;

@Service
public interface UnsupportedCodeMatchExceptionService {
    void isUidMatch(Request request) throws UnsupportedCodeException;
}

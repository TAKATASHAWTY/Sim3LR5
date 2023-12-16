package edu.Sim3LR5.service;

import edu.Sim3LR5.model.Request;
import edu.Sim3LR5.exception.UnsupportedCodeException;
import edu.Sim3LR5.service.Interface.UnsupportedCodeMatchExceptionService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RequestUnsupportedCodeMatchExceptionService implements UnsupportedCodeMatchExceptionService {

    @Override
    public void isUidMatch(Request request) throws UnsupportedCodeException {
        if (Objects.equals(request.getUid(), "123")) {
            throw new UnsupportedCodeException("Uid не может быть равно 123");
        }
    }
}

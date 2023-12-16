package edu.Sim3LR5.service.Interface;

import org.springframework.stereotype.Service;
import edu.Sim3LR5.model.Request;

@Service
public interface ModifyRequestService {
    void modify(Request request);
}

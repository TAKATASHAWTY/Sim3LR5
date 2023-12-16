package edu.Sim3LR5.service.Interface;

import edu.Sim3LR5.model.Response;
import org.springframework.stereotype.Service;

@Service
public interface ModifyResponseService {
    Response modify(Response response);
}

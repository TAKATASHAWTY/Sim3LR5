package edu.Sim3LR5.service;

import edu.Sim3LR5.model.Response;
import edu.Sim3LR5.service.Interface.ModifyResponseService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Qualifier("ModifyOperationUidResponseService")
public class ModifyOperationUidResponseService implements ModifyResponseService {
    @Override
    public Response modify(Response response) {
        UUID uuid = UUID.randomUUID();
        response.setOperationUid(uuid.toString());
        return response;
    }
}

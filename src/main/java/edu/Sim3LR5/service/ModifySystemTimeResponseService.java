package edu.Sim3LR5.service;

import edu.Sim3LR5.model.Response;
import edu.Sim3LR5.service.Interface.ModifyResponseService;
import edu.Sim3LR5.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Qualifier("ModifySystemTimeResponseService")
public class ModifySystemTimeResponseService implements ModifyResponseService {
    @Override
    public Response modify(Response response) {
        response.setSystemTime(DateTimeUtil.getCustomFormat().format(new Date()));
        return response;
    }
}

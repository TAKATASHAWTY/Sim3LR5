package edu.Sim3LR5.service;

import edu.Sim3LR5.Enum.Codes;
import edu.Sim3LR5.Enum.ErrorCodes;
import edu.Sim3LR5.Enum.ErrorMessages;
import edu.Sim3LR5.exception.UnsupportedCodeException;
import edu.Sim3LR5.exception.ValidationFailedException;
import edu.Sim3LR5.model.*;
import edu.Sim3LR5.service.Interface.*;
import edu.Sim3LR5.util.DateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
public class ControlMethod implements ResponseException {
    private final ValidationService validationService;
    private final UnsupportedCodeMatchExceptionService unsupportedCodeMatchExceptionService;
    private final ModifyResponseService modifyResponseService;
    private final ModifyRequestService modifyRequestService;

    @Autowired
    public ControlMethod(ValidationService validationService,
                         UnsupportedCodeMatchExceptionService unsupportedCodeMatchExceptionService,
                         @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService,
                         @Qualifier("SystemName") ModifyRequestService modifyRequestService){
        this.validationService = validationService;
        this.unsupportedCodeMatchExceptionService = unsupportedCodeMatchExceptionService;
        this.modifyResponseService = modifyResponseService;
        this.modifyRequestService = modifyRequestService;
    }

    @Override
    public ResponseEntity<Response> ResponseExceptions(Request request, BindingResult bindingResult) {
        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();

        try {
            validationService.isValid(bindingResult);
            unsupportedCodeMatchExceptionService.isUidMatch(request);
        } catch (ValidationFailedException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMessage(ErrorMessages.VALIDATION);
            log.error(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (UnsupportedCodeException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNSUPPORTED);
            log.error(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
        } catch (Exception e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNKNOWN);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        modifyResponseService.modify(response);

        modifyRequestService.modify(request);

        log.info("response:{}", response);

        return new ResponseEntity<>(modifyResponseService.modify(response), HttpStatus.OK);
    }
}

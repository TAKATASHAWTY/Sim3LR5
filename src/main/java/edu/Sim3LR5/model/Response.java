package edu.Sim3LR5.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import edu.Sim3LR5.Enum.Codes;
import edu.Sim3LR5.Enum.ErrorCodes;
import edu.Sim3LR5.Enum.ErrorMessages;

@Data
@Builder
@ToString
public class Response {
    //Уникальный идентификатор сообщения
    private String uid;

    //Уникальный идентификатор операции
    private String operationUid;

    //Время отправки сообщения
    private String systemTime;

    //Код
    private Codes code;

    //Годовой бонус
    private Double annualBonus;

    //Код ошибки
    private ErrorCodes errorCode;

    //Текст ошибки
    private ErrorMessages errorMessage;
}

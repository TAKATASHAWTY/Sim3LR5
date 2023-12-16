package edu.Sim3LR5.model;

import edu.Sim3LR5.Enum.Positions;
import edu.Sim3LR5.Enum.Systems;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import edu.Sim3LR5.util.DateTimeUtil;
import javax.validation.constraints.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class    Request {

    //Уникальный идентификатор сообщения
    @NotBlank(message = "Uid  не может быть пустым ")
    @Size(max = 3, message = "uid должен быть меньше 32 символов")
    private String uid;

    //Уникальный идентификатор операции
    @NotBlank(message = "operationUid не может быть пустым")
    @Size(max = 32, message = "operationUid должен быть меньше 32 символов")
    private String operationUid;

    //Имя системы
    private Systems systemName;

    //Время создания сообщения
    private String systemTime;

    //Имя ресурса
    private String source;

    //Позиция (человека в штате)
    private Positions positions;

    //Заработная плата
    private Double salary;

    //Бонус
    private Double bonus;

    //Колличество рабочих дней
    private Integer workDays;

    //Уникальный идентификатор комуникации
    @Min(value = 1, message = "communicationId не может быть меньше 1")
    @Max(value = 100000, message = "communicationId не может быть больше 100000")
    private int communicationId;

    //Уникальный идентификатор шаблона
    private int templateId;

    //Код продукта
    private int productCode;

    //Код смс
    private int smsCode;

    @Override
    public String toString() {
        return "{" +
                "uid=" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemTime='" + systemTime + '\'' +
                ", source='" + source + '\'' +
                ", communicationId='" + communicationId +
                ", templateId='" + templateId +
                ", productCode='" + productCode +
                ", smsCode='" + smsCode +
                '}';
    }

    public void setSystemTime(String systemTime) {
        if (systemTime.isEmpty()) {
            this.systemTime = DateTimeUtil.getCustomFormat().format(new Date());
        } else {
            this.systemTime = systemTime;
        }
    }
}

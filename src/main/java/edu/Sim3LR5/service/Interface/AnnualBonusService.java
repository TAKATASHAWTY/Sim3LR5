package edu.Sim3LR5.service.Interface;

import edu.Sim3LR5.Enum.Positions;
import org.springframework.stereotype.Service;

@Service
public interface AnnualBonusService {
    double calculate(Positions positions, double salary, double bonus, int workDays);
}

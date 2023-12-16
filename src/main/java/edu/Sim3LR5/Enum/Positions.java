package edu.Sim3LR5.Enum;

import lombok.Getter;

@Getter
public enum Positions {
    DEV(2.2, false),
    HR(1.2, false),
    TL(2.6,false),
    PM(2.3,false),
    St(0.5,false),

    TM(2.5,true),
    MN(1.1,true);

    private final double positionCoefficient;
    private final boolean isManager;

    Positions(double positionCoefficient, boolean isManager){
        this.positionCoefficient = positionCoefficient;
        this.isManager = isManager;
    }
}

package models;

import java.text.DecimalFormat;

public class Pneu {
    private TypePneu type;
    private double pression;

    public Pneu(TypePneu type, double pression) {
        this.type = type;
        this.pression = pression;
    }

    public TypePneu getType() {
        return type;
    }

    public double getPression() {
        return pression;
    }

    @Override
    public String toString() {
        DecimalFormat foramteur = new DecimalFormat("0.0");
        return "[type = " + type + ", pression = " + foramteur.format(pression) + "]";
    }
}

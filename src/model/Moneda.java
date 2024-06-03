package model;

public class Moneda {
    private String monedaBase;
    private Double monedaFinal;
    private String mFinal;

    public Moneda(MonedaER monedaER, String mFinal){
        this.monedaBase = monedaER.base_code();
        this.mFinal = mFinal;
        this.monedaFinal = monedaER.conversion_rates().get(mFinal);
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public void setMonedaBase(String monedaBase) {
        this.monedaBase = monedaBase;
    }

    public Double getMonedaFinal() {
        return monedaFinal;
    }

    public void setMonedaFinal(Double monedaFinal) {
        this.monedaFinal = monedaFinal;
    }

    public String getmFinal() {
        return mFinal;
    }

    public void setmFinal(String mFinal) {
        this.mFinal = mFinal;
    }

    @Override
    public String toString() {
        return "(monedaInicial=" + monedaBase +
                ", monedaFinal=" + mFinal + ": " + monedaFinal + ")";
    }
}

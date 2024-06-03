import model.Moneda;

public class Conversor {
    private Double cantidadMonedaInicial;
    private Double tasaDeCambio;
    private Double resultado;

    public double conversorMoneda(Moneda moneda, double cantidad){
        this.cantidadMonedaInicial = cantidad;
        this.tasaDeCambio = moneda.getMonedaFinal();
        return resultado = cantidadMonedaInicial * tasaDeCambio;
    }
    public Double getCantidadMonedaInicial() {
        return cantidadMonedaInicial;
    }

    public void setCantidadMonedaInicial(Double cantidadMonedaInicial) {
        this.cantidadMonedaInicial = cantidadMonedaInicial;
    }

    public Double getTasaDeCambio() {
        return tasaDeCambio;
    }

    public void setTasaDeCambio(Double tasaDeCambio) {
        this.tasaDeCambio = tasaDeCambio;
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }
}

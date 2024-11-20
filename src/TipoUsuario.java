
public enum TipoUsuario {
    REGULAR(3, 5),
    PREMIUM(Integer.MAX_VALUE, Integer.MAX_VALUE);
	

    private final int renovacionesPermitidas;
    private final int limitePrestamosSimultaneos;

    TipoUsuario(int renovacionesPermitidas, int limitePrestamosSimultaneos) {
        this.renovacionesPermitidas = renovacionesPermitidas;
        this.limitePrestamosSimultaneos = limitePrestamosSimultaneos;
    }

    public int getRenovacionesPermitidas() {
        return renovacionesPermitidas;
    }

    public int getLimitePrestamosSimultaneos() {
        return limitePrestamosSimultaneos;
    }
}


public class CuentaVista extends Cuenta implements Tarjeta{

    CuentaVista(int saldoInicial){
        cuentascounter++;
        this.numeroDeCuenta = cuentascounter;
        this.saldo = saldoInicial;
    }

    @Override
    public void transferir(Cuenta cuenta, int monto){
        retirar(monto);
        cuenta.abonar(monto);
    }
}
public class CuentaCorriente extends Cuenta implements Tarjeta{
    
    public CuentaCorriente(int saldoInicial){
        cuentascounter++;
        this.numeroDeCuenta = cuentascounter;
        this.saldo = saldoInicial;
    }

    //Se sobreescribe el metodo retirar de modo que sea posible que hayan valores negativos en el saldo (ya no pide que monto <= saldo)
    @Override
    public void retirar(int monto){
        saldo = saldo - monto;
    }

    @Override
    public void transferir(Cuenta cuenta, int monto){
        retirar(monto);
        cuenta.abonar(monto);
    }
}
public class CuentaDeAhorro extends Cuenta implements FormaDeAhorro{
    //Indica el crecimiento diario del monto guardado en esta cuenta.
    //Es de tipo final ya que no puede ser modificada una vez creada la cuenta.
    private final float tasa;

    //Días para que esté disponible la opción de retirar dinero.
    //En las cuentas de ahorro, después de retirar dinero, se deben esperar siete días antes de que vuelva a ser posible retirar dinero.
    private int días;

    //Constructor 1
    CuentaDeAhorro(int saldoInicial){
        cuentascounter++;
        this.numeroDeCuenta = cuentascounter;
        this.saldo = saldoInicial;
        this.tasa = 1.0001f;
        this.días = 0;
    }
    //Constructor 2
    CuentaDeAhorro(int saldoInicial, float tasa){
        cuentascounter++;
        this.numeroDeCuenta = cuentascounter;
        this.saldo = saldoInicial;
        this.tasa = tasa;
        this.días = 0;
    }

    public int getMonto(){
        return saldo;
    }

    //Se sobreescribe el metodo retirar para que cuando se realize un retiro, se le asignen 7 días de cooldown a al cuenta para poder volver a retirar dinero.
    @Override
    public void retirar(int monto){
        if (días == 0 && monto <= saldo){
            saldo = saldo - monto;
            días = 7;
        }
        else{
            //Se lanza esta excepción para que el catch del ReadFile la agarre y la maneje.
            throw new NullPointerException();
        }
    }

    public void actualizar(){
        saldoFloat = saldo;
        saldoFloat = saldoFloat * tasa;
        saldo = Math.round(saldoFloat);
        if (días > 0){
            días--;
        }
    }

}
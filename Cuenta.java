public abstract class Cuenta{
    //Indica el orden en que fue creada la cuenta.
    int numeroDeCuenta;
    //Monto disponible en la cuenta.
    int saldo;
    //Variable equivalente en formato float al int saldo, creada para poder multiplicarlo por las tasas de interés.
    float saldoFloat;
    //Contador de cantidad de cuentas para asignar números de cuenta correctamente por orden de creación al crear una cuenta.
    //Es static ya que este valor se debe compartir para todas las instancias de Cuenta que existan. 
    static int cuentascounter;

    //Constructor
    public Cuenta(){
    }

    //Retorna el saldo disponible en la cuenta.
    public int getSaldo(){
        return saldo;
    }

    //Retorna el número que identifica a la cuenta.
    public int getNúmeroDeCuenta(){
        return numeroDeCuenta;
    }

    //Suma el monto indicado al saldo disponible en la cuenta.
    public void abonar(int monto){
        saldo = saldo + monto;
    }


    public void transferir(Cuenta cuenta, int monto){
    }

    //Retira el monto indicado del saldo disponible en la cuenta. Si el monto indicado lo excede lanza una excepción
    public void retirar(int monto){
        if (monto <= saldo){
            saldo = saldo - monto;
        }
        else{
            //Se lanza esta excepción para que el catch del ReadFile la agarre y la maneje.
            throw new NullPointerException();
        }
    }

}
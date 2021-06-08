public class DepósitoAPlazo implements FormaDeAhorro{
    //Cantidad de dinero que tiene la persona ahorrada en ese fondo. Irá variando a medida que pasen los días 
    private int monto;
    private float montoFloat;

    //Días que faltan para retirar el dinero.
    private int días;

    //Tasa de interés del depósito a plazo, corresponde al tercio del creciemiento de la economía.
    //Es de tipo final ya que es fijada una vez que se crea el depósito y no puede ser modificada desde entonces.
    private final float tasa;

    //Cuenta desde la cual se pidió. El monto será depositado en esta cuenta una vez finalice el ahorro.
    private Cuenta cuenta;

    DepósitoAPlazo(int montoInicial, Cuenta cuenta, int días){
        this.monto = montoInicial;
        this.días = días;
        this.tasa = ((FondoMutuo.crecimiento-1)/3)+1;
        this.cuenta = cuenta;
    }
    //Retorna el monto asociado a dicha forma de ahorro.
    public int getMonto(){
        return monto;
    }

    //Actualiza el monto asociado a dicha forma de ahorro, multiplicandolo por su respectiva tasa de interés.
    public void actualizar(){
        try{
            //Cuando faltan días para retirar el dinero
            if (días > 0){
                días--;
                montoFloat = monto;
                montoFloat = montoFloat * tasa;
                monto = Math.round(montoFloat);
            }
            //Cuando el dinero es retirado
            else if (días == 0){
                cuenta.abonar(monto);
                monto = 0;
            }
        }
        catch (NullPointerException nullPointer){
            System.out.println("La cuenta " + cuenta.numeroDeCuenta + " que ha ingresado no existe");
        }
    }
}
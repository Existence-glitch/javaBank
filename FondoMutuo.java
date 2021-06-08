public class FondoMutuo implements FormaDeAhorro{
    //Identificador único de la inversión. Será indicado en la creación del objeto correspondiente. Considere que puede ser cualquier String
    final String ID;

    //Cantidad de dinero que tiene la persona ahorrada en ese fondo.
    //Irá variando a medida que pasen los días
    private int monto;
    private float montoFloat;
    
    //Número de la cuenta desde la cual se pidió. El monto será depositado en esta cuenta una vez finalice el ahorro.
    private Cuenta cuenta;

    //Número que indica el crecimiento diario de la economía.
    //Es de tipo static ya que debe ser compartido para todos los fondos mutuos.
    static float crecimiento;

    FondoMutuo(int monto, Cuenta cuenta, String ID){
        this.monto = monto;
        this.ID = ID;
        this.cuenta = cuenta;
    }

    //Retorna el identificador único del fondo mutuo en cuestión.
    public String getID(){
        return ID;
    }

    //Retorna el monto asociado a dicha forma de ahorro.
    public int getMonto(){
        return monto;
    }

    //Modifica el valor del crecimiento diario de la economía. 
    public static void setCrecimiento(float newPIB){
        crecimiento = newPIB;
    }

    //Retira todo el dinero del fondo mutuo y lo abona a su cuenta asociada. Al retornar este método, el monto que queda debe ser cero.
    public void cobrar(){
        try{
            if (monto > 0){
                cuenta.saldo = cuenta.saldo + monto;
                monto = 0;
            }
            else{
                System.out.println("No se ha podido cobrar el fondo mutuo ya que no hay dinero en la cuenta");
            }
        }
        catch(NullPointerException nullPointer){
            System.out.println("La cuenta no existe, ingrese un número de cuenta válido");
        }
    }

    //Actualiza el monto asociado a dicha forma de ahorro, multiplicandolo por su respectiva tasa de interés.
    public void actualizar(){
        montoFloat = monto;
        montoFloat = montoFloat * crecimiento;
        monto = Math.round(montoFloat);
    }
}
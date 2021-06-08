public interface FormaDeAhorro{
    //Retorna el monto asociado a dicha forma de ahorro.
    public int getMonto();
    //Actualiza el monto asociado a dicha forma de ahorro, multiplicandolo por su respectiva tasa de interés.
    public void actualizar();
}
public class Cuenta extends Banco{
    private String nombre;
    private double saldo;
    private String PIN;
    private int ID;


    public Cuenta(String nombre, double saldo, String PIN) {
        super();
        setNombre(nombre);
        setSaldo(saldo);
        setPIN(PIN);
        setID(Banco.IDGlobal);
    }


    protected String getNombre() {
        return nombre;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    protected double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    protected String getPIN() {
        return PIN;
    }

    protected void setPIN(String PIN) {
        //******    Limitalo a 4 digitos.
        do {
            if (PIN.length() == 4) {
                this.PIN = PIN;
            } else {
                PIN = CapturaEntrada.capturarCadena("Ingrese su PIN de 4 digitos y/o caracteres: ");
            }
        }while(PIN.length() != 4);

    }

    protected int getID() {
        return ID;
    }

    protected void setID(int ID) {
        this.ID = ID;
    }
}

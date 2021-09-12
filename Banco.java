public class Banco {
    //El banco al iniciar el programa tenia 15000 de saldo a favor.
    static double saldo = 15000;
    static int IDGlobal = 0;
    //Se crea un constructor protected para que la clase Banco no se pueda instanciar.
    protected Banco(){
        IDGlobal++;
    }

    public static void validarPIN(Cuenta account, String auxPIN, int auxID){
        if(account.getPIN().equals(auxPIN) && account.getID() == auxID){
            menuDeTransacciones(account);
        }
    }

    private static void impresionDeEstadoDeCuenta(Cuenta account){
        System.out.println("Saldo actual: "+ account.getSaldo());
    }

    private static void retiro(Cuenta account){
        double salida = CapturaEntrada.capturarDoble("Cuanto desea retirar ");
        if(account.getSaldo() < salida)
        {
            System.out.println("No puede sacar el monto por saldo insuficiente");
        }
        else{
            account.setSaldo(account.getSaldo() - salida);
            saldo -= salida;
        }
    }

    private static void deposito(Cuenta account){
        double entrada = CapturaEntrada.capturarDoble("Cuanto desea ingresar ");
        account.setSaldo(entrada + account.getSaldo());
        saldo += entrada;
    }

    private static void menuDeTransacciones(Cuenta account){
        int menu;
        System.out.println("Bienvenido "+ account.getNombre()+"\nQue transaccion desea realizar?");
        do {
            menu = CapturaEntrada.capturarEntero("1)Deposito\t2)Retiro\t3)Estado de cuenta\n");
            switch (menu) {
                case 1:
                    deposito(account);
                    break;
                case 2:
                    retiro(account);
                    break;
                case 3:
                    impresionDeEstadoDeCuenta(account);
                    break;
            }
            menu = CapturaEntrada.capturarEntero("Desea realizar otra transaccion?, presione 0 en caso de que si\n");
        }while(menu == 0);
        System.out.println("Hasta luego "+ account.getNombre());
    }
}

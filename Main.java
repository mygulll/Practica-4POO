import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList <Cuenta> cuentas = new ArrayList<>();
        int menu, auxID;
        String auxPIN;
        do{
            menu = CapturaEntrada.capturarEntero("1) Crear una cuenta\t2)Ingresar a una cuenta existente\t3)Salir\n");
            switch(menu) {
                case 1:
                    cuentas.add(new Cuenta(CapturaEntrada.capturarCadena("Ingrese nombre completo: "),
                            0, CapturaEntrada.capturarCadena("Ingrese su PIN de 4 digitos y/o caracteres: ")));
                    System.out.println("Su ID de usuario es "+ Banco.IDGlobal);
                    break;
                case 2:
                    auxID = CapturaEntrada.capturarEntero("Ingrese su ID de usuario ");
                    auxPIN = CapturaEntrada.capturarCadena("Ingrese su PIN: ");
                    for(int i = 0; i < cuentas.size(); i++)
                    {
                        Banco.validarPIN(cuentas.get(i), auxPIN, auxID);
                    }
                    break;

            }
        }while(menu != 3);

    }
}

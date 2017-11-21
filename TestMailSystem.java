/**
 * Write a description of class TestCalendarioBasico here.
 *
 * @author (David Rodriguez)
 * @version (a version number or a date)
 */
public class TestMailSystem
{
    // Simula un primer usuario de correo.
    private MailClient primerUsuario;
    // Simula un segundo usuario de correo.
    private MailClient segundoUsuario;
    // Simula nuestro servidor de correo.
    private MailServer grupoDServer;

    /**
     * Constructor for objects of class testMailSystem
     */
    public TestMailSystem()
    {
        grupoDServer = new MailServer();
        primerUsuario = new MailClient(grupoDServer,"Agapito");
        segundoUsuario = new MailClient(grupoDServer,"Eutanasia");
    }

    public void realizarTests()
    {
        int numeroDeTests = 0;
        int numeroDeTestsOk = 0;
        int numeroDeTestsFail = 0;
        String proceso = "";

        MailServer grupoDServer = new MailServer();
        MailItem item1 = new MailItem(false,"Agapito","Eutanasia","Hola","Mensaje de prueba aeiou");
        MailItem item2 = new MailItem(true,"Agapito","Eutanasia","Hola","?=? Mensaje de prueba aeiou");
        proceso = "Creando un mail...";

        try{
            if(item1.getMessage().compareTo("Mensaje de prueba aeiou") == 0) {
                System.out.printf("Se esperaba " + "Mensaje de prueba aeiou\n");
                numeroDeTestsOk++;
                System.out.printf("Mensaje sin encriptar OK\n");
            }
            else {
                numeroDeTestsFail++;
                System.out.printf("%-60.60s %-30.30s%n", proceso, "FAIL!\n");
            }
        }
        catch (Exception e) {
            numeroDeTestsFail++;
            System.out.printf("%-60.60s %-30.30s%n", proceso, "FAIL! (error en tiempo de ejecucion)\n");
        }
        numeroDeTests++;

        proceso = "Creando un mail...";
        if(item2.getMessage().compareTo("?=? Mensaje de prueba aeiou") == 0) {
            System.out.printf("Se esperaba " + "?=? Mensaje de prueba aeiou\n");
            numeroDeTestsOk++;
            System.out.printf("Mensaje encriptado OK\n");
        }
        else {
            numeroDeTestsFail++;
            System.out.printf("%-60.60s %-30.30s%n", proceso, "FAIL!\n");
        }

        numeroDeTests = numeroDeTestsOk + numeroDeTestsFail;

        System.out.printf("%-60.60s %2.2s%n", "======", "==");
        System.out.printf("%-60.60s %2.2s%n", "Numero de test realizados:", numeroDeTests);
        System.out.printf("%-60.60s %2.2s%n", "Numero de test pasados correctamente:", numeroDeTestsOk);
        System.out.printf("%-60.60s %2.2s%n", "Numero de test fallados:", numeroDeTestsFail);
    }
}
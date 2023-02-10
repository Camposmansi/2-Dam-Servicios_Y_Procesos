package Trimestre2.OtroMultiHIlo;

public class MainServidor {

    public static void main(String[] args) {
        //Creamos el servidor en el puerto 1234
        Servidor servidor = new Servidor(1234);
        //Lo ponemos a escuchar
        servidor.start();
    }

}

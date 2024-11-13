import Motor.MotorLexicoFortran;

public class App {
    public static void main(String[] args) throws Exception {
        MotorLexicoFortran motor = new MotorLexicoFortran();
        motor.CarregarArquivo("./Fortran/hello.f90");
        motor.ProcessarBufferPrimario();
        motor.ImprimirBufferPrimario();
        motor.ProcessarBufferSecundario();
        motor.ImprimirBufferSecundario();
    }
}

        //motor.CarregarArquivo("./Texto/teste.txt");
        //motor.CarregarArquivo("./Fortran/hello.f90");


        // motor.ProcessarBufferSecundario();
        // motor.ImprimirBufferSecundario();


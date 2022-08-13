import java.util.Scanner


fun main() {

    val idConta_01 = Conta(titular = "Luzinete",numero = 1001);
    val idConta_02 = Conta(titular ="Rodrigo", numero = 1002);


    fun paginaDeEscolha(titular: String, numero: Int, usuario: Conta){

        println("Olá $titular");
        println("Seu saldo R$${usuario.getSaldo()}");
        println("Para começar a usar o Bankotlin");
        println("Digite uma das opções abaixo:");
        println("Deposito | Saque | Tranferencia Bancaria");

        val sistemas = Scanner(System.`in`);
        val sistemaEscolhido = sistemas.nextLine();
        val tratamentoInput = sistemaEscolhido.uppercase()

        when (tratamentoInput){
            "DEPOSITO" -> usuario.depositarDinheiro(usuario)
            "SAQUE" -> usuario.sacarDinheiro(usuario)
            else -> println("Você nao escolheu nenhum opção, tente novamente")
        }

    }

    println("---------|| BanKotlin ||---------");
    println("Seu banco digital!");
    println("Para usar basta digitar sua conta:");



    val digitoConta = Scanner(System.`in`);
    val numeroDigitado = digitoConta.nextInt();

    fun login(){
        when (numeroDigitado) {
            idConta_01.numero -> paginaDeEscolha(idConta_01.titular,idConta_01.numero,idConta_01)

            idConta_02.numero -> paginaDeEscolha(idConta_02.titular,idConta_02.numero,idConta_02)

            else -> println("não é uma conta")
        };
    }
    login()


}


class Conta(var titular: String, var numero: Int) {
    private var saldo = 0.00


    fun deposita(valor: Float){
        if (valor >= 0) {
            this.saldo += valor

        }
    }

    fun getSaldo(): Double {
        return saldo
    }

    fun sacar(valor: Float){
        if (saldo >= valor) {
            this.saldo -= valor
        }
    }

    fun depositarDinheiro(conta: Conta){

        println("Quanto deseja depositar?");

        val valorDeposito = Scanner(System.`in`);
        val deposito = valorDeposito.nextInt();

        conta.deposita(deposito.toFloat());

        println("Você depositou: $deposito");
        println("Saldo atual: ${conta.getSaldo()}");
        println("Deseja voltar para o menu ${conta.titular}?");
        println("sim ou não?");

        val respostaSaida = Scanner(System.`in`);
        val resultadoSaidaDepositar = respostaSaida.nextLine();
        val tratamentoInput = resultadoSaidaDepositar.uppercase()

        if (tratamentoInput == "SIM"){
            return main()
        }

    }

    fun sacarDinheiro(conta: Conta){
        println("Quanto deseja Sacar?");

        val valorSacado = Scanner(System.`in`);
        val saque = valorSacado.nextInt();

        conta.sacar(saque.toFloat());

        println("Você sacou: $saque");
        println("Saldo atual: ${conta.getSaldo()}");
        println("Deseja voltar para o menu ${conta.titular}?");
        println("sim ou não?");

        val respostaSaidaSacar = Scanner(System.`in`);
        val resultadoSaidaSacar = respostaSaidaSacar.nextLine();
        val tratamentoInputSacar = resultadoSaidaSacar.uppercase()

        if (tratamentoInputSacar == "SIM"){
            return main()
        }
    }
}
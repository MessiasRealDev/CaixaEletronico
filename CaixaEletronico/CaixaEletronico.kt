var saldo = 150.00
var extrato = "Depósito inicial: R$ 150.00"
var nomeUsuario = ""
var senhaCorreta = 3589

fun main() {
    nomeUser()
    opcaoCaixa()
}
fun nomeUser(){

    println("Bem vindo ao caixa eletronico")
    print("Digite seu nome: ")
    nomeUsuario = readln()
    println("Olá $nomeUsuario, é um prazer ter você aqui")

}
fun opcaoCaixa(){
    var opcao : Int

    println("Escolha uma opção:")
    println("1. Ver saldo")
    println("2. Ver extrato")
    println("3. Fazer saque")
    println("4. Fazer depósito")
    println("5. Fazer transferência")
    println("6. Sair")
    print("Opção: ")
    opcao = readln().toInt()

    when(opcao){
        1 -> versaldo()
        2 -> verExtrato()
        3 -> fazerSaque()
        4 -> fazerDeposito()
        5 -> fazerTransferencia()
        6 -> sair()
        else -> erro()
    }
}

fun versaldo(){
    if(validarSenha(senhaCorreta)){
        println("Seu saldo atual é: R$$saldo")
    }

}
fun verExtrato(){
    if(validarSenha(senhaCorreta)){
        println("Seu Extrato")
        if (extrato.isNullOrEmpty()){
            println("Extrato vazio")
        }else{
            println(extrato)
        }
        opcaoCaixa()
    }
}
fun fazerSaque(){
    if(validarSenha(senhaCorreta)){
        print("qual valor para saque:")
        var saque = readln().toDouble()

        if(saque <= 0){
            println("Valor invalido")
        }
        else if(saque > saldo){
            println("Saldo insuficiente")
        }
        else{
            saldo -= saque
            extrato += "Saque: R$" + saque
            println("Saque realizado com sucesso!")
            versaldo()
        }
    }
}

fun fazerDeposito(){

    println("Qual o valor do depósito?")
    var deposito = readln().toDouble()

    if(deposito <= 0){
        println("Valor inválido")
    }
    else{
        saldo += deposito
        extrato += "Depósito R$" + deposito
        println("Depósito realizado com sucesso")
        versaldo()
    }
}

fun fazerTransferencia(){
    if(validarSenha(senhaCorreta)){

        print("Infome o número da conta de destino: ")
        var contaDestino = readln().toInt()
        print("qual o valo da transfêrencia: ")
        var valorTranferencia = readln().toDouble()

         if(valorTranferencia <= 0){
             println("Valor invalido")
             fazerTransferencia()
         }
        else if(valorTranferencia > saldo){
            println("Saldo infuficinete")
             fazerTransferencia()
        }
        else{
            saldo -= valorTranferencia
             extrato += "Tranferencia para conta" + contaDestino + ": R$" + valorTranferencia
             println("Tranferencia realizada com sucesso")
             versaldo()
        }
    }
}

fun sair(){
    println("$nomeUsuario foi um prazer ter você aqui! até logo")
}

fun erro(){
    println("Opção invalida!")
    opcaoCaixa()
}

fun validarSenha(senhaCorreta: Int): Boolean {

    print("Digite a senha: ")
    val senha = readln().toIntOrNull() ?: return false

    return if(senha == senhaCorreta){
        true
    }else{
        println("Senha incorreta! tente novamente")
        validarSenha(senhaCorreta)
        false
    }
}

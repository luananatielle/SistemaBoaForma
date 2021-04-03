/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.academia.apresentacao;

import br.edu.ifnmg.poo.academia.controle.AtividadeControlador;
import br.edu.ifnmg.poo.academia.controle.AutenticacaoControlador;
import br.edu.ifnmg.poo.academia.controle.AvaliacaoControlador;
import br.edu.ifnmg.poo.academia.controle.PlanoControlador;
import br.edu.ifnmg.poo.academia.controle.UsuarioControlador;
import br.edu.ifnmg.poo.academia.modelo.Aluno;
import br.edu.ifnmg.poo.academia.modelo.Atividade;
import br.edu.ifnmg.poo.academia.modelo.Avaliacao;
import br.edu.ifnmg.poo.academia.modelo.Funcionario;
import br.edu.ifnmg.poo.academia.modelo.Instrutor;
import br.edu.ifnmg.poo.academia.modelo.Mensalidade;
import br.edu.ifnmg.poo.academia.modelo.PagamentoPorCartao;
import br.edu.ifnmg.poo.academia.modelo.PagamentoPorDinheiro;
import br.edu.ifnmg.poo.academia.modelo.Plano;
import br.edu.ifnmg.poo.academia.modelo.Usuario;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import static java.util.Date.parse;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author luana
 */
public class SistemaAcademia {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException  {
        Scanner scanner= new Scanner(System.in);
        int operacao=0;

        do{
            try{//menu
                System.out.println("\n\n ***Menu***");
                System.out.println("Operação:");
                System.out.println("1- Cadastrar usuário:");
                System.out.println("2-Cadastrar atividade");
                System.out.println("3-Autenticar usuário:");
                System.out.println("4-Fazer avaliação:");
                System.out.println("5-Criar Plano:");
                System.out.println("6-Gerar mensalidade: ");
                System.out.println("7-Relatório de usuários cadastradas: ");
                System.out.println("8-Relatório de atividades cadastradas: ");
                System.out.println("0-Sair");

                operacao= Integer.parseInt(scanner.nextLine());

                switch (operacao) {
                    case 1:
                        cadastrarUsuario(scanner);
                        break;
                    case 2:
                        cadastrarAtividade(scanner);
                        break;
                    case 3:
                        autenticarUsuario(scanner);
                        break;
                    case 4:
                        fazerAvaliacao(scanner);
                        break;
                    case 5:
                        criarPlano(scanner);
                        break;
                    case 6:
                        gerarMensalidade(scanner);
                        break;
                    case 7:
                        buscarUsuarios();
                        break;
                    case 8:
                        buscarAtividades();
                        break;
                    default:
                        break;
                }
            }catch(NumberFormatException e){
                System.out.println("\nValor inválido!Tente novamente\n");
                operacao=-1;

            }catch (NullPointerException e){
                System.out.println("\nUsuário não encontrado! Tente novamente. \n");
                operacao=-1;
            }
        }while(operacao !=0);

    }
    private static void cadastrarUsuario(Scanner scanner) throws ParseException {
        //lê os atributos da classe usuario
        System.out.println("\n\n******Cadastro de Usuários******\n");
        System.out.println("\nCadastrar:\n Aluno (A), Intrutor (I) \n Funcionário (F)");
        char tipoUsuario = scanner.nextLine().charAt(0);
        System.out.println("Nome: ");
        String nome=scanner.nextLine();
        System.out.println("Telefone: ");
        String telefone=scanner.nextLine();
        System.out.println("Endereço: ");
        String endereco=scanner.nextLine();
        System.out.println("CPF: ");
        String cpf=scanner.nextLine();
        System.out.println("Login: ");
        String login=scanner.nextLine();
        System.out.println("Senha: ");
        String senha=scanner.nextLine();

        Usuario usuario=null;
        //verifica o tipo de usuario

        if((tipoUsuario=='A')||(tipoUsuario=='a')){
            int controle=0;
            int matricula=0;
            Date dataNascimento = null;
            do{
                try{
                    System.out.println("Matrícula: ");
                    matricula= Integer.parseInt(scanner.nextLine());
                }catch(NumberFormatException e){
                    System.out.println("Matricula inválida! Digite novamente.\n");
                    controle=1;
                }
            }while(controle==1);

            try{
                dataNascimento=null;
                SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
                System.out.println("Data de nascimento: DD/MM/AA");
                String data=scanner.nextLine();
                dataNascimento=format.parse(data);
            }catch(ParseException e){
                System.out.println("Data inválida! O formato de ser: DD/MM/AA \n");
                controle=1;
            }

            usuario= new Aluno(nome,telefone,endereco,cpf,login,senha,matricula,dataNascimento);
        }
        else if((tipoUsuario=='I')||(tipoUsuario=='i')){
            System.out.println("Especialização: ");
            String especializacao = scanner.nextLine();
            usuario=new Instrutor(nome,telefone,endereco,cpf,login,senha,especializacao);
        }
        else if((tipoUsuario=='F')||(tipoUsuario=='f')){
            System.out.println("Cargo: ");
            String cargo=scanner.nextLine();
            usuario=new Funcionario(nome,telefone,endereco,cpf,login,senha,cargo);
        }
        else System.out.println("Tipo de usuário inválido! Digite novamente.\n");

        UsuarioControlador usuarioControlador= new UsuarioControlador();
        //verifica se foi cadastrado
        if(usuario==null)
            System.out.println("\nErro! Usuário não cadastrado!\n");
        else{
            usuarioControlador.cadastrarUsuario(usuario);
            System.out.println("\nUsuário cadastrado com sucesso!\n");
        }
}


    private static int cadastrarAtividade(Scanner scanner) throws ParseException{
        //lê os atributos da classe atividade
        System.out.println("\n\n******Cadastro de Atividade******\n\n");
        System.out.println("Nome da atividade: ");
        String nomeAtividade=scanner.nextLine();
        System.out.println("Descrição atividade: ");
        String descricao=scanner.nextLine();
        System.out.println("Dias da Semana: ");
        System.out.println("Seg-Segunda\tTer-Terca\tQua-Quarta\tQui-Quinta\tSex-Sexta\tTodos os dias ");
        String diasDaSemana=scanner.nextLine();
        System.out.println("Horário inicial: __:__");
        String horarioInicial=scanner.nextLine();
        System.out.println("Horário final: __:__");
        String horarioFinal=scanner.nextLine();
        float valor;
        do{
            try{//usa excessão para validar se foi informado um preço válido. Obriga digitar um preço valido
                System.out.println("Preço: ");
                valor=Float.parseFloat(scanner.nextLine());
            }catch(NumberFormatException e){
                System.out.println("\nPreço inválido!Tente novamente\n");
                valor=-1;
            }
        }while(valor==-1);

        System.out.println("Possui lotação máxima? 1-sim  2-não");
        int opcao=Integer.parseInt(scanner.nextLine());
        int lotacaoMaxima;
        if(opcao==1){
            System.out.println("Digite o valor: ");
            lotacaoMaxima= Integer.parseInt(scanner.nextLine());
        }else
            lotacaoMaxima=-1;

        //lê um instrutor e busca na base de dados

        Instrutor instrutorVerificado=null;
        int op=0;
        do{
            System.out.println("\nDigite o nome do instrutor:\n");
            String instrutor =scanner.nextLine();
            UsuarioControlador usuarioControlador=new UsuarioControlador();
            instrutorVerificado= usuarioControlador.buscarInstrutor(instrutor);

            //verifica se existe instrutor, se não houver da opção para cadastrar
            if(instrutorVerificado==null){
                System.out.println("Instrutor "+ instrutor+ " não encontrado! Deseja cadastrá-lo? 1-SIM  2-Não 3-Digitar novamente\n");
                op=Integer.parseInt(scanner.nextLine());
                if(op==1){
                    cadastrarUsuario(scanner);
                    cadastrarAtividade(scanner);
                }else if(op==2){
                    System.out.println("Atividade não foi cadastrada, instrutor inválido!");
                    return 0;
                }
            }
        }while(op==3);
        int lotacaoAtual=0;
        //armazena a atividade na base de dados.
        Atividade atividade= new Atividade(nomeAtividade,descricao,diasDaSemana, horarioInicial, horarioFinal, valor,lotacaoAtual,lotacaoMaxima, instrutorVerificado);
        AtividadeControlador atividadeControlador= new AtividadeControlador();
        atividadeControlador.cadastrarAtividade (atividade);
        System.out.println("\nAtividade cadastrado com sucesso!");

        return 0;
    }

    private static Usuario autenticarUsuario(Scanner scanner) {
        //lê os atributos para autenticação
        System.out.println("\n\n******Autenticação******\n\n");
        System.out.println("\nLogin: ");
        String login = scanner.nextLine();
        System.out.println("Senha: ");
        String senha = scanner.nextLine();
        //autentica o login e senha digitados com o da base de dados
        AutenticacaoControlador autenticacaoControlador = new AutenticacaoControlador();
        Usuario usuarioAutenticado = autenticacaoControlador.autenticar(login, senha);
        System.out.printf("Usuario autenticada: Login %s ", usuarioAutenticado.getNome());
        return usuarioAutenticado;
    }

    private static int fazerAvaliacao(Scanner scanner) throws ParseException {
        System.out.println("\n\n******Cadastro de Avaliação******\n\n");

        UsuarioControlador usuarioControlador=new UsuarioControlador();
        Aluno aluno;
        //lê um aluno, verifica se existe em UsuarioDAO, se não houver, da opção para cadastr de aluno.

        System.out.println("Digite o nome do aluno:");
        String nomeAluno = scanner.nextLine();
        aluno = usuarioControlador.buscarAluno(nomeAluno);
        if (aluno == null) {
            System.out.println("Aluno não encontrado: Desaja cadastrá-lo agora? 1-sim 2- não \n");
            int i = Integer.parseInt(scanner.nextLine());
            if (i == 1) {
                cadastrarUsuario(scanner);
                fazerAvaliacao(scanner);
            } else {
                return 0;
            }
        }
        Instrutor instrutor;

        //lê um instrutor, verifica se existe em UsuarioDAO, se não houver, da opção para cadastr de instrutor.
        System.out.println("Digite o nome do instrutor: ");
        String nomeInstrutor = scanner.nextLine();
        instrutor = usuarioControlador.buscarInstrutor(nomeInstrutor);
        if (instrutor == null) {
            System.out.println("Instrutor não encontrado: Desaja cadastrá-lo agora? 1-sim 2-não \n");
            int i = Integer.parseInt(scanner.nextLine());
            if (i == 1) {
                cadastrarUsuario(scanner);
                fazerAvaliacao(scanner);
            } else {
                return 0;
            }
        }

        //lê outros atributos de atividade
        System.out.println("Peso:");
        Float peso=Float.parseFloat(scanner.nextLine());
        System.out.println("Altura:");
        Float altura=Float.parseFloat(scanner.nextLine());
        System.out.println("Observações: ");
        String observacoes=scanner.nextLine();
        Date dataAvaliacao= new Date();
        //armazena a avaliação
        Avaliacao avaliacao=new Avaliacao(peso,altura,dataAvaliacao,instrutor, aluno, observacoes);
        System.out.println("\nAvaliação cadastrada com sucesso!\n");

        //calcula o IMC
        AvaliacaoControlador avaliacaoControlador=new AvaliacaoControlador();
        float imc=avaliacaoControlador.buscarImc(peso, altura, avaliacao);

        System.out.println("\nIMC:");

        if(imc<18.5)
            System.out.println(imc+" Abaixo do peso");
        else if((imc>18.5)&&(imc<24.9))
            System.out.println(imc+" Peso normal");
        else if((imc>25)&&(imc<29.9))
            System.out.println(imc+" Sobrepeso");
        else if((imc>30)&&(imc<34.9))
            System.out.println(imc+" Obesidade grau 1");
        else if((imc>35)&&(imc<39.9))
            System.out.println(imc+" Obesidade grau 2");
        else if(imc<40)
            System.out.println(imc+" Obesidade Mórbida");
        
        System.out.println("Deseja criar plano de atividades agora? 1-sim 2-não");
        int op=Integer.parseInt(scanner.nextLine());
        if(op==1)
            criarPlano(scanner);
        
        return 0;
    }
    private static void buscarUsuarios(){
        System.out.println("Usuários cadastrados: ");
        UsuarioControlador usuarioControlador=new UsuarioControlador();
        List<Usuario> usuarios=usuarioControlador.buscarTodosUsuarios();

        OrdenadorUsuario ordenadorUsuario=new OrdenadorUsuario();
        Collections.sort(usuarios, ordenadorUsuario);

        for(Usuario usuario: usuarios){
            System.out.println(usuario.getNome());
        }
    }
    private static class OrdenadorUsuario implements Comparator<Usuario> {
        @Override
        public int compare(Usuario usuario1,Usuario usuario2){
            return usuario1.getNome().compareToIgnoreCase(usuario2.getNome());
        }
    }

    private static void buscarAtividades(){
        System.out.println("\nAtividades cadastradas\n");
        System.out.println("Atividade \t Dias da Semana \t Horário \t Preço\n");
        AtividadeControlador atividadeControlador= new AtividadeControlador();
        List<Atividade> atividades=atividadeControlador.buscarTodasAtividades();

        OrdenadorAtividade ordenadorAtividade=new OrdenadorAtividade();
        Collections.sort(atividades,ordenadorAtividade);

        for(Atividade atividade:atividades){
            System.out.println(atividade.getNome() + "\t " + atividade.getDiasDaSemana()+ "\t " +
                    atividade.getHorarioInicial()+ "\t"+ atividade.getHorarioFinal()+"\t" + atividade.getValor());
        }
    }
    private static class OrdenadorAtividade implements Comparator<Atividade> {

        @Override
        public int compare(Atividade atividade1, Atividade atividade2){
            return atividade1.getNome().compareToIgnoreCase(atividade2.getNome());
        }

    }
    private static int criarPlano(Scanner scanner){
        System.out.println("\n\n******Plano******\n\n");

        UsuarioControlador usuarioControlador=new UsuarioControlador();
        System.out.println("Nome do aluno:");
        String nomeAluno=scanner.nextLine();
        Aluno aluno= usuarioControlador.buscarAluno(nomeAluno);
        if(aluno==null){
            System.out.println("Aluno não encontrado!");
            return 0;
        }
        int i=0;
        buscarAtividades();
        AtividadeControlador atividadeControlador=new AtividadeControlador();
        List<Atividade> atividades=null;
        do{
            System.out.println("Digite o nome da atividade que deseja matricular:\n");
            String atividade=scanner.nextLine();
            Atividade atividadeRecuperada=atividadeControlador.buscarAtividade(atividade);
            if(atividadeRecuperada==null){
                System.out.println("\nAtividade não encontrada!\n");
                return 0;
            }else {
                int lotacaoAtual=atividadeRecuperada.getLotacaoAtual();
                lotacaoAtual++;
                if((atividadeRecuperada.getLotacaoMaxima()<0)||(atividadeRecuperada.getLotacaoMaxima()>=lotacaoAtual)){
                    atividadeRecuperada.setLotacaoAtual(lotacaoAtual);
                    atividades=atividadeControlador.matriculaAtividade(atividadeRecuperada);
                    System.out.println("Matrícula feita com sucesso! Deseja se matricular em outra atividade: 1-Sim 2-Não");
                    int opcao=Integer.parseInt(scanner.nextLine());
                    if(opcao==1)
                        i=1;
                    else i=0;

                }else{
                    System.out.println("Não foi possivel realizar matrícula! Atividade com lotação máxima atingida");
                    i=0;
                }
            }
        }while(i==1);
        float precoTotal= atividadeControlador.precoAtividadesMatriculadas();
        Plano plano=new Plano(aluno, atividades, precoTotal);
        PlanoControlador planoControlador=new PlanoControlador();
        planoControlador.adicionarPlano(plano);
        System.out.println("Plano criado com sucesso!");
        System.out.println("O valor total do seu plano é: R$"+precoTotal);
        return 0;

    }


    private static int gerarMensalidade(Scanner scanner) throws ParseException{
        System.out.println("Digite o nome do Aluno");
        String nome=scanner.nextLine();
        UsuarioControlador usuarioControlador=new UsuarioControlador();
        Aluno aluno= usuarioControlador.buscarAluno(nome);
        if(aluno==null){
            System.out.println("Aluno não encontrado!");
            return 0;
        }
        PlanoControlador planoControlador=new PlanoControlador();
        Plano plano=planoControlador.buscarPlano(aluno.getNome());
        if(plano==null){
            System.out.println("Plano não encontrado\n");
            return 0;
        }

        System.out.println("Digite a data de vencimento");
        String data=scanner.nextLine();
        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
        Date vencimento=format.parse(data);
        Mensalidade mensalidade=new Mensalidade(vencimento);
        System.out.println("Valor total a pagar: "+ plano.getValorTotal());

        System.out.println("Deseja pagar agora: 1-Sim 2-Não");
        int opcao=Integer.parseInt(scanner.nextLine());
        if(opcao==1){
            mensalidade.alterarStatusPagamento();
            pagamento(scanner,plano.getValorTotal());
        }
        return 0;
    }

    private static void pagamento(Scanner scanner, float total){
        System.out.println("Qual forma de pagamento? 1-cartão 2-dinheiro");
        int opcao=Integer.parseInt(scanner.nextLine());
        Date dataPagamento=new Date();
        if(opcao==1){
            System.out.println("Tipo de pagamento: C-Crédito D-Débito");
            String tipo=scanner.nextLine();
            char tipoPagamento=tipo.charAt(0);
            System.out.println("Bandeira:");
            String bandeira=scanner.nextLine();
            System.out.println("Parcelamento: ");
            int parcelamento=Integer.parseInt(scanner.nextLine());
            PagamentoPorCartao pagamentoCartao=new PagamentoPorCartao(dataPagamento,tipoPagamento,bandeira,parcelamento);
            System.out.println("Pagamento realizado com sucesso!");
        }else if(opcao==2){
            System.out.println("Digite o valor do desconto:");
            float desconto=Float.parseFloat(scanner.nextLine());
            PagamentoPorDinheiro pagamentoDinheiro=new PagamentoPorDinheiro(dataPagamento,desconto);
            System.out.println("Digite valor recebido para calcular troco:");
            Float valorRecebido=Float.parseFloat(scanner.nextLine());
            float troco=pagamentoDinheiro.calcularTroco(total,valorRecebido);
            System.out.println("Troco: R$"+troco);
            PagamentoPorDinheiro pagamentoPorDinheiro=new PagamentoPorDinheiro(dataPagamento,troco,desconto);
            System.out.println("Pagamento realizado com sucesso!");
        }
    }

}





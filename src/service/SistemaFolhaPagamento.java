package service;

import entity.Funcionario;

import java.util.ArrayList;

public class SistemaFolhaPagamento {

    public static boolean cadastrarFuncionario(ArrayList<Funcionario> lista, Funcionario novofuncionario){
        for (Funcionario funcionario : lista){
            if(funcionario.getMatricula() == novofuncionario.getMatricula()){
                return false;
            }
        }
        lista.add(novofuncionario);
        return true;
    }
    public static ArrayList<Funcionario> listarFuncionarios(ArrayList<Funcionario> lista) {
        return lista;
    }

    public static Funcionario buscarPorMatricula(ArrayList<Funcionario> lista, int matricula){
        for (Funcionario funcionario : lista){
            if(funcionario.getMatricula() == matricula){
                return funcionario;
            }
        }
        return null;
    }
    public static boolean editarSalOrName(ArrayList<Funcionario> lista, int matricula, String novoNome, double novoSalarioBase){
        Funcionario funcionario = buscarPorMatricula(lista, matricula);
        if(funcionario != null){
            if (novoNome != null) funcionario.setNome(novoNome);
            if(novoSalarioBase != 0.0) funcionario.setSalarioBase(novoSalarioBase);
            return true;
        }
        return false;
    }


    public static boolean excluirFuncionario(ArrayList<Funcionario> lista, int matricula) {
        Funcionario funcionario = buscarPorMatricula(lista, matricula);
        if (funcionario != null) {
            lista.remove(funcionario);
            return true;
        }
        return false;
    }

    public static double calcularFolhaSalario(ArrayList<Funcionario> lista) {
        double total = 0.0;
        for (Funcionario funcionario : lista) {
            total += funcionario.calcularSalario(); // polimórfico!
        }
        return total;
    }

}

package entity;


public class Gerente extends Funcionario {
    public Gerente(String nome, int matricula, double salarioBase) {
        super(nome, matricula, salarioBase);
    }

    @Override
    public double calcularSalario() {
        return salarioBase * 1.5;
    }
    @Override
    public String toString() {
        return "\nCargo: Gerente" + super.toString();
    }
}
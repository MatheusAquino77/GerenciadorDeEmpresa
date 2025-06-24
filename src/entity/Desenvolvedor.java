package entity;

public class Desenvolvedor extends Funcionario {
    public Desenvolvedor(String nome, int matricula, double salarioBase) {
        super(nome,matricula,salarioBase);
    }
    @Override
    public double calcularSalario() {
        return salarioBase * 1.2;
    }
    @Override
    public String toString() {
        return "\nCargo: Desenvolvedor" + super.toString();
    }
}

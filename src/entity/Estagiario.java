package entity;

public class Estagiario extends Funcionario{
    public Estagiario(String nome, int matricula, double salarioBase) {
        super(nome,matricula,salarioBase);
    }
    @Override
    public double calcularSalario() {
        return salarioBase * 0.8;
    }
    @Override
    public String toString() {
        return "\nCargo: Estagiário" + super.toString();
    }
}

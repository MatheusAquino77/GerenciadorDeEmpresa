package entity;

public abstract class Funcionario {
    protected  String nome;
    protected  int matricula;
    protected  double salarioBase;

    public Funcionario(String nome, int matricula, double salarioBase){
        this.nome = nome;
        this.matricula = matricula;
        this.salarioBase = salarioBase;
    }
    public abstract double calcularSalario();


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
    @Override
    public String toString() {
        return
                "\nNome: " + nome +
                "\nMatrícula: " + matricula +
                "\nSalário base: R$ " + salarioBase;
    }
}






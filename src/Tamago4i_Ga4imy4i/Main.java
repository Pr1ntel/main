package Tamago4i_Ga4imy4i;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Игра тамагочи");
        Build build1 = new Build(100, Build.randNum(), Build.randNum(), Build.randNum(), Build.randNum());
        while (build1.isLife()) {
        build1.printlnMenu();
        }
    }
}

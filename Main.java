/*
2. Crie a classe Shape que represente uma figura e que seja possível obter seu nome, calcular sua área e perímetro. A partir dessa classe, crie as classes Retângulo, Círculo, Losango, Hexagono e pentágono.
*/

import java.util.Scanner;

// Classe Shape
abstract class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    // calcular a área da figura
    public abstract double calculateArea();

    // calcular o perímetro da figura
    public abstract double calculatePerimeter();

    // nome da figura
    public String getName() {
        return name;
    }
}

// retângulo
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        super("Retângulo");
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
}

// círculo
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super("Círculo");
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

// losango
class Rhombus extends Shape {
    private double side;

    public Rhombus(double side) {
        super("Losango");
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side * Math.sqrt(3) / 2;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }
}

// hexágono
class Hexagon extends Shape {
    private double side;

    public Hexagon(double side) {
        super("Hexágono");
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return (3 * Math.sqrt(3) * side * side) / 2;
    }

    @Override
    public double calculatePerimeter() {
        return 6 * side;
    }
}

// pentágono
class Pentagon extends Shape {
    private double side;

    public Pentagon(double side) {
        super("Pentágono");
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return 0.25 * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * side * side;
    }

    @Override
    public double calculatePerimeter() {
        return 5 * side;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita e lê o nome da figura
        System.out.println("Digite o nome da figura (Retângulo, Círculo, Losango, Hexágono ou Pentágono):");
        String name = scanner.nextLine();

        Shape shape = null;

        // Verifica qual figura foi escolhida e instancia a classe correspondente
        switch (name.toLowerCase()) {
            case "retângulo":
                System.out.println("Digite a largura do retângulo:");
                double width = scanner.nextDouble();
                System.out.println("Digite a altura do retângulo:");
                double height = scanner.nextDouble();
                shape = new Rectangle(width, height);
                break;
            case "círculo":
                System.out.println("Digite o raio do círculo:");
                double radius = scanner.nextDouble();
                shape = new Circle(radius);
                break;
            case "losango":
                System.out.println("Digite o lado do losango:");
                double sideRhombus = scanner.nextDouble();
                shape = new Rhombus(sideRhombus);
                break;
            case "hexágono":
                System.out.println("Digite o lado do hexágono:");
                double sideHexagon = scanner.nextDouble();
                shape = new Hexagon(sideHexagon);
                break;
            case "pentágono":
                System.out.println("Digite o lado do pentágono:");
                double sidePentagon = scanner.nextDouble();
                shape = new Pentagon(sidePentagon);
                break;
            default:
                System.out.println("Figura inválida!");
                System.exit(1);
        }

        scanner.close();

        System.out.println("Área de " + shape.getName() + ": " + shape.calculateArea());
        System.out.println("Perímetro de " + shape.getName() + ": " + shape.calculatePerimeter());
    }
}

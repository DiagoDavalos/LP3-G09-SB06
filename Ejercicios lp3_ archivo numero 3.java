// =============================================
// 1. Principio SRP (Single Responsibility Principle)
// =============================================
class Empleado {
    private String nombre;
    private double salario;
    private String departamento;

    public Empleado(String nombre, double salario, String departamento) {
        this.nombre = nombre;
        this.salario = salario;
        this.departamento = departamento;
    }

    public double getSalario() { return salario; }
    public String getNombre() { return nombre; }
}

class CalculadoraPago {
    public double calcularPagoMensual(Empleado emp) {
        return emp.getSalario() / 12;
    }
}

class MainSRP {
    public static void main(String[] args) {
        Empleado e = new Empleado("Diego", 12000, "TI");
        CalculadoraPago calc = new CalculadoraPago();
        System.out.println("Pago mensual: " + calc.calcularPagoMensual(e));
    }
}

// =============================================
// 2. Principio OCP (Open/Closed Principle)
// =============================================
interface Forma {
    void dibujar();
}

class Circulo implements Forma {
    public void dibujar() {
        System.out.println("Dibujando un círculo");
    }
}

class Rectangulo implements Forma {
    public void dibujar() {
        System.out.println("Dibujando un rectángulo");
    }
}

class Triangulo implements Forma {
    public void dibujar() {
        System.out.println("Dibujando un triángulo");
    }
}

class MainOCP {
    public static void main(String[] args) {
        Forma[] formas = { new Circulo(), new Rectangulo(), new Triangulo() };
        for(Forma f : formas) {
            f.dibujar();
        }
    }
}

// =============================================
// 3. Principio LSP (Liskov Substitution Principle)
// =============================================
abstract class Vehiculo {
    public abstract void acelerar();
}

class Coche extends Vehiculo {
    public void acelerar() {
        System.out.println("El coche acelera con motor");
    }
}

class Bicicleta extends Vehiculo {
    public void acelerar() {
        System.out.println("La bicicleta acelera pedaleando");
    }
}

class MainLSP {
    public static void main(String[] args) {
        Vehiculo v1 = new Coche();
        Vehiculo v2 = new Bicicleta();
        v1.acelerar();
        v2.acelerar();
    }
}

// =============================================
// 4. Principio ISP (Interface Segregation Principle)
// =============================================
interface Imprimible {
    void imprimir();
}

interface Escaneable {
    void escanear();
}

class Impresora implements Imprimible {
    public void imprimir() {
        System.out.println("Imprimiendo documento...");
    }
}

class ImpresoraMultifuncional implements Imprimible, Escaneable {
    public void imprimir() {
        System.out.println("Imprimiendo documento...");
    }
    public void escanear() {
        System.out.println("Escaneando documento...");
    }
}

class MainISP {
    public static void main(String[] args) {
        Imprimible impresora = new Impresora();
        impresora.imprimir();

        ImpresoraMultifuncional multi = new ImpresoraMultifuncional();
        multi.imprimir();
        multi.escanear();
    }
}

package Actividades;

//Strategy interface
interface DiscountStrategy {
 double applyDiscount(double price, int quantity);
}

//Concrete strategies
class NoDiscount implements DiscountStrategy {
 public double applyDiscount(double price, int quantity) { return price * quantity; }
}

class TenPercentDiscount implements DiscountStrategy {
 public double applyDiscount(double price, int quantity) { return price * quantity * 0.9; }
}

class SpecialBulkDiscount implements DiscountStrategy {
 // ejemplo: si compra 3 o más, 50% en el producto más barato (simple model: apply 50% off one unit)
 public double applyDiscount(double price, int quantity) {
     if (quantity >= 3) {
         return price * (quantity - 1) + price * 0.5; // 50% off on one unit
     } else {
         return price * quantity;
     }
 }
}

//Context
class PriceCalculator {
 private DiscountStrategy strategy;
 public void setStrategy(DiscountStrategy s) { this.strategy = s; }
 public double calculate(double price, int quantity) {
     if (strategy == null) throw new IllegalStateException("Strategy no configurada");
     return strategy.applyDiscount(price, quantity);
 }
}

public class StrategyDemo {
 public static void main(String[] args) {
     PriceCalculator calc = new PriceCalculator();
     double price = 100.0;

     calc.setStrategy(new NoDiscount());
     System.out.println("Sin descuento: " + calc.calculate(price, 2));

     calc.setStrategy(new TenPercentDiscount());
     System.out.println("10% descuento: " + calc.calculate(price, 2));

     calc.setStrategy(new SpecialBulkDiscount());
     System.out.println("Descuento por volumen (3 unidades): " + calc.calculate(price, 3));
 }
}

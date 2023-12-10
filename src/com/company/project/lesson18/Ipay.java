package com.company.project.lesson18;
@FunctionalInterface
public interface Ipay {
    // Interface: IPay
    // абстрактный boolean pay();
    // default метод IPay additionalPay(IPay pay)
    // альтернативный способ используется,
    // если предыдущий не сработал
    boolean pay(int x);
    default Ipay additionalPay(Ipay another){
       return (x) -> {
           if (!pay(x))
               return another.pay(x);
           return true;
       };
    }

}

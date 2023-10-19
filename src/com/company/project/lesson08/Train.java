package com.company.project.lesson08;

public class Train extends Transport{
    private int countOfWagons;
    private boolean climatControl;

    public Train(String number, int maxSpeed, int countOfWagons, boolean climatControl) {
        super(number, maxSpeed);
        this.countOfWagons = countOfWagons;
        this.climatControl = climatControl;
    }

    public void setCountOfWagons(int countOfWagons) {
        this.countOfWagons = countOfWagons;
    }

    public int getCountOfWagons() {
        return countOfWagons;
    }

    public boolean isClimatControl() {
        return climatControl;
    }
    public void change(){
         climatControl = !climatControl;
    }
    @Override// аннотация времени компиляции
    public void repair() {       // переопределение метода родителя

         if (countOfWagons < 7 && countOfWagons > 0) {//если вагонов до 7. уровень износа уменьшаеться на 2

             if(levelOfWare >= 2)

                 levelOfWare = levelOfWare - 2;
             //else levelOfWare--;// если 7 и более, уровень износа уменьш на 1
         }
         else{// вызов метода родителя
             if (levelOfWare < 0)throw new IllegalArgumentException("Exception:levelOfWare must be > 0");
             super.repair();//if(levelOfWare > 0);
                            //  levelOfWare--;


         }
    }

    @Override
    public void stop() {

    }
}

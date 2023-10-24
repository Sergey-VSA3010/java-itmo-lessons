package com.company.project.lesson11;
// enum могут реализовать интерфейсы
// enum не могут расширять другие классы
// так в enum уже реализовано наследование
public enum Country {// наследование запрещено-имплемент.возможна!
  // элементы перечисления-Экземпляры типа Country
    FRANCE("France",1341244){

      @Override
    public void sout(){
        System.out.println("реализация france");
      }
  },
    USA("Usa",424445345){
      @Override
      public void sout(){
        System.out.println("реализация usa");}
    },
    ITALY("Italy",35445235) {
      @Override
      public void sout() {
        System.out.println("реализация italy");
      }
    }; // Country [FRANCE,USA,ITALY]

  private String name;
  private long population;

  /*privet*/ Country(String name, long population) {
    this.name = name;
    this.population = population;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getPopulation() {
    return population;
  }

  public void setPopulation(long population) {
    this.population = population;

  }
  abstract public void sout();

  @Override
  public String toString() {
    return "Country{" +
            "name='" + name + '\'' +
            ", population=" + population +
            '}';
  }
}

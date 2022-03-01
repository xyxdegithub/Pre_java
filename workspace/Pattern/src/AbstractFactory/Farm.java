package AbstractFactory;

//抽象工厂：农场类
interface Farm
{
  public Animal newAnimal();
  public Plant newPlant();
}
//具体工厂：韶关农场类
class SGfarm implements Farm
{
  public Animal newAnimal()
  {
      System.out.println("新牛出生！");
      return new Cattle();
  }
  public Plant newPlant()
  {
      System.out.println("蔬菜长成！");
      return new Vegetables();
  }
}
//具体工厂：上饶农场类
class SRfarm implements Farm
{
  public Animal newAnimal()
  {
      System.out.println("新马出生！");
      return new Horse();
  }
  public Plant newPlant()
  {
      System.out.println("水果长成！");
      return new Fruitage();
  }
}

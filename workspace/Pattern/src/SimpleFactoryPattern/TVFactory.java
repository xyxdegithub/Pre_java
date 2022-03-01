package SimpleFactoryPattern;

public class TVFactory {
	public static TV creteTV(String brand) throws Exception{
		TV tv=null;
		if(brand.equalsIgnoreCase("海尔")) {
		   tv=new HaierTV();
			System.out.println("工厂生产海尔电视机");
			
		}else if(brand.equalsIgnoreCase("海信")){
			tv=new HisenseTV();
			System.out.println("工厂生产海信电视机");
			
		}else {
			throw new Exception("此品牌电视机暂不能生产");
		}
		return tv;
		       
	}

}

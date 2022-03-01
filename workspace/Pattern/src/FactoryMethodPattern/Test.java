package FactoryMethodPattern;



public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PolicyProducer p1=new BodyInjurePOlicyProduct();
		AutoInsurance  ai=new BodyInjure();
		System.out.println(ai.getInsurDescription());
	}

}

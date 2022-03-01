package BuilderPattern;

abstract class Decorator {
	protected Parlour product = new Parlour();

	public abstract void buildWall();

	public abstract void buildTV();

	public abstract void buildSofa();

	public Parlour getResult() {
		return product;
	}
}	
	
	class ConcreteDecorator1 extends Decorator{

		@Override
		public void buildWall() {
			// TODO Auto-generated method stub
			product.setWall("第一面墙");
		}

		@Override
		public void buildTV() {
			// TODO Auto-generated method stub
			product.setTV("第一台电视");
		}

		@Override
		public void buildSofa() {
			// TODO Auto-generated method stub
			product.setSofa("sofa1");
		}
		
	}
	
	class ConcreteDecorator2 extends Decorator{

		@Override
		public void buildWall() {
			// TODO Auto-generated method stub
			product.setWall("第二面墙");
		}

		@Override
		public void buildTV() {
			// TODO Auto-generated method stub
			product.setTV("第二台电视");
		}

		@Override
		public void buildSofa() {
			// TODO Auto-generated method stub
			product.setSofa("sofa2");
		}
		
	}


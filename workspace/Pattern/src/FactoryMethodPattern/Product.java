package FactoryMethodPattern;

interface AutoInsurance {
	public String getInsurDescription();

	
}

class BodyInjure implements AutoInsurance {

	@Override
	public String getInsurDescription() {
		// TODO Auto-generated method stub	
		
		return "这是人身伤害保险";
	}
}

class CollisionInjure implements AutoInsurance {

	@Override
	public String getInsurDescription() {
		// TODO Auto-generated method stub
		
		return "这是碰撞伤害保险";
	}
}

class ComprehensiveInjure implements AutoInsurance {

	@Override
	public String getInsurDescription() {
		// TODO Auto-generated method stub
		
		return "这是综合伤害保险";
	}
}

class PersonInjure implements AutoInsurance {

	@Override
	public String getInsurDescription() {
		// TODO Auto-generated method stub
		
		return "这是个人伤害保险";
	}
}
class CarInjure implements AutoInsurance {

	@Override
	public String getInsurDescription() {
		// TODO Auto-generated method stub
		
		return "这是车伤害保险";
	}
}

interface PolicyProducer {
	public AutoInsurance getPolicyObj();

	
}

class BodyInjurePOlicyProduct implements PolicyProducer {

	@Override
	public AutoInsurance getPolicyObj() {
		// TODO Auto-generated method stub
		return new BodyInjure();
	}

}

class CollisionPolicyProducer implements PolicyProducer {

	@Override
	public AutoInsurance getPolicyObj() {
		// TODO Auto-generated method stub
		return new CollisionInjure();
	}

}
class ComprehensivePolicyProducer implements PolicyProducer {

	@Override
	public AutoInsurance getPolicyObj() {
		// TODO Auto-generated method stub
		return new ComprehensiveInjure();
	}

}
class PersonInjurePolicyProducer implements PolicyProducer {

	@Override
	public AutoInsurance getPolicyObj() {
		// TODO Auto-generated method stub
		return new PersonInjure();
	}

}
class CarInjurePolicyProducer implements PolicyProducer {

	@Override
	public AutoInsurance getPolicyObj() {
		// TODO Auto-generated method stub
		return new CarInjure();
	}

}
	
	
	
	
	
	


package AbstractFactory;

public class FarmTest {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Farm f;
        Animal a;
        Plant p;
        f=(Farm) ReadXML.getObject();
        a=f.newAnimal();
        p=f.newPlant();
        a.show();
        p.show();
	}

}

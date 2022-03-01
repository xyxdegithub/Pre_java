package BuilderPattern;

public class Client {
	public static void main(String[] args) {
		Decorator d;
		d= (Decorator) ReadXML.getObject();
		ProjectManager m = new ProjectManager(d);
		Parlour p = m.decorator();
		p.show();
	}
}

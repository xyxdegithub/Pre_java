package BuilderPattern;

public class ProjectManager {
private Decorator builder;
public ProjectManager(Decorator builder) {
	this.builder=builder;
}

public Parlour decorator() {
	builder.buildSofa();
	builder.buildTV();
	builder.buildWall();
	return builder.getResult();
}
}

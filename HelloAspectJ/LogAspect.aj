
public aspect LogAspect {
	pointcut message():
		call(void HelloAspectJ.hello());
	
	before(): message() {
		System.out.println("Welcome to AspectJ!");
	}
}

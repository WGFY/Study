package MyInterface;

//接口支持多继承。
public interface MyInterface {
	//接口中只有：常量、抽象方法！
	//一个类可以实现多个接口
	//类可以实现多个接口，接口可以多继承
	/*public static final */int MAX_SPEED = 120;
	String MAX_GREAD ="BOSS";
	//接口方法必须public abstract公开
	public void test01();
	public int test02();
	//接口只能通过子类来使用
	MyInterface s=new stone();
	
}
//接口继承
interface A extends MyInterface {
	

}
//接口的实现
class stone implements MyInterface{

	@Override
	public void test01() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int test02() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
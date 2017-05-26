package InnerClass;

public class Outer {
	public static void main(String[] args){
		Face f= new Face();
		//非静态内部类的创建必须有外部类对象
		Face.Nose n = f.new Nose();
		//静态内部类可以通过外部类直接调用
		Face.ear e =new Face.ear();
	}
}
//外部类不能访问内部类的成员
//内部类可以直接访问外部类成员
class Face{
	int size;
	String type;
	static String color ="red";
	//非静态内部类不能使用静态成员和方法
	class Nose{
		String type;
		void breath(){
			//调用自己的成员
			System.out.println(this.type);
			//调用外部类成员
			System.out.println(Face.this.type);
		}
	}
	
	static class ear{
		
		void listen(){
			//不能调用外部类非静态属性
			//System.out.println(Face.this.type);
			System.out.println(color);
		}
	}
}
package MyInterface;

//�ӿ�֧�ֶ�̳С�
public interface MyInterface {
	//�ӿ���ֻ�У����������󷽷���
	//һ�������ʵ�ֶ���ӿ�
	//�����ʵ�ֶ���ӿڣ��ӿڿ��Զ�̳�
	/*public static final */int MAX_SPEED = 120;
	String MAX_GREAD ="BOSS";
	//�ӿڷ�������public abstract����
	public void test01();
	public int test02();
	//�ӿ�ֻ��ͨ��������ʹ��
	MyInterface s=new stone();
	
}
//�ӿڼ̳�
interface A extends MyInterface {
	

}
//�ӿڵ�ʵ��
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
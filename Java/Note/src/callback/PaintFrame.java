package callback;
//方法框架，模板方法模式
public class PaintFrame {
	public static void drawFrame(IMyFrame f){
		
		f.paint();//hook,通过不同子类对方法重写
	}
}

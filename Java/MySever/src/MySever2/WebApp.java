package MySever2;

import java.util.HashMap;
/**
 * ����urlͬSeverlet�Ķ�Ӧ��ϵ
 * ���ṩͨ��url�ҵ���ӦSeverlet����
 * @author ������
 *
 */
public class WebApp {
	private static SeverletContent slc;
	/**
	 * ��̬����飬�ڵ�����ʱ�Զ�ִ��
	 */
	static{
		slc = new SeverletContent();
		HashMap<String,String> urlMap = (HashMap)slc.getUrlMap();
		HashMap<String,String> sevMap = (HashMap)slc.getSevMap();
		urlMap.put("/log", "login");
		urlMap.put("/login", "login");
		urlMap.put("/reg", "regist");
		urlMap.put("/regist", "regist");
		sevMap.put("login","MySever2.LoginSeverlet");
		sevMap.put("regist","MySever2.RegistSeverlet");
	}
	
	public static Severlet getSeverlet(String url) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		if(null==url||(url.trim()).equals("")){
			return null;
		}
		String name =slc.getSevMap().get(slc.getUrlMap().get(url));
		return (Severlet)Class.forName(name).newInstance();
		
	}
}
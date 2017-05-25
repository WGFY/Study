package mycastle;

import java.util.HashMap;
import java.util.Scanner;

public class Game {
	private Room currentroom ;
	private Water player;
	private HashMap<String ,Handler> handler =new HashMap<String ,Handler>();
	public Game()
	{
		creatRoom();
		handler.put("��", new HandlerGo(this));
		handler.put("��", new HandlerBye(this));
		handler.put("��", new HandlerHelp(this));
		player = new Water(3);
	}
	
	public void creatRoom(){
		Room outside,lobby,hall,study,kitchen,toilet,bedroom,guestroom;
		outside=new Room("�Ǳ���");
		lobby=new Room("����");
		hall=new Room("����");		
		study=new Room("�鷿");
		kitchen=new Room("����");
		toilet=new Room("����");
		bedroom=new Room("����");
		guestroom=new Room("�ͷ�");
		
		outside.setDoor("��", lobby);
		lobby.setDoor("��", hall);
		hall.setDoor("��", lobby);
		hall.setDoor("��", kitchen);
		hall.setDoor("��", toilet);
		hall.setDoor("��", study);
		study.setDoor("��", hall);
		kitchen.setDoor("��", hall);
		toilet.setDoor("��", guestroom);
		toilet.setDoor("��", hall);
		toilet.setDoor("��", bedroom);
		bedroom.setDoor("��", toilet);
		guestroom.setDoor("��", toilet);
		currentroom=outside;
	}
	public void wellcome(){
		System.out.println("��ӭ����Сˮ��ð����Ϸ");
		System.out.println("�㽫���������������ķ��䣬���Լ���ɱ��������سǱ�����ɹ�");
		System.out.println("��ʹ�á������������ټ���");
		this.showprompt();
	}
	public void showprompt(){
		System.out.print("��������"+currentroom.showName()+"��");
		System.out.print("��������"+currentroom.weathers.get(currentroom.showweather())+"��");
		System.out.println("������״̬��"+player.showstatu());
		System.out.println("���ڷ����У�"+currentroom.showDoor());
		System.out.println("��ʹ�÷�������磨�򶫣��ƶ�");
	}
	public void outdoor(String dir){
		if(currentroom.exit(dir)==null){
			System.out.println("�޷���"+dir+"��");
		}
		else{
			this.currentroom = currentroom.exit(dir);
			player.change((this.currentroom.showweather()));
		}
		
		showprompt();
	}
	
	public void start(){
		Scanner in = new Scanner(System.in);
		while(true){
			String[] words = in.nextLine().split("");
			Handler hd =handler.get(words[0]);
			String value ="";
			if (words.length>1){
				value = words[1];
			}
			if(hd!=null){
				hd.doCmd(value);
				if(player.showstatu().equals("��")&&currentroom.showName().equals("�Ǳ���")||hd.bye()){
					if(player.showstatu().equals("��")&&currentroom.showName().equals("�Ǳ���")){
						System.out.println("����ݣ��ɹ���");	
					}
					break;
				}
			}
		}
		System.out.println("��л������Ϸ");	
		in.close();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game g = new Game();
		g.wellcome();
		g.start();
	}

}
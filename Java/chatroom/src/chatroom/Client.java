package chatroom;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
//�û����������߳�����
	public static void main(String[] args) throws UnknownHostException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name=null;
		do{
			System.out.println("��ӭʹ������������û�����");
			name = br.readLine();
		}while(null==name||name.equals(""));
		br.close();
		Socket client = new Socket("localhost",8888);
		new Thread(new Input(client)).start();;
		new Thread(new Output(client,name)).start();;
	}
}
//������Ϣ
class Input implements Runnable{
	private DataInputStream dis;
	private boolean isRunning = true;
	public Input(Socket client) {
		try {
			dis=new DataInputStream(client.getInputStream());
		} catch (IOException e) {
				CloseUtil.Close.closeAll(dis);
				isRunning=false;
		}
	}
	//�ӷ�����������Ϣ
	private String getMsg(){
		String msg=null;
		try {
			msg=dis.readUTF();
		} catch (IOException e) {
			CloseUtil.Close.closeAll(dis);
			isRunning=false;
		}
		return msg;
	}
	//����Ϣ��ӡ������̨
	public void print(){
		String msg = this.getMsg();
		if(msg!=null){
			System.out.println(msg);
		}
		
	}
	@Override
	public void run() {
		while(isRunning){
			print();
		}
	}
	
}

//������Ϣ
class Output implements Runnable{
	private DataOutputStream dos;
	private BufferedReader br;
	private boolean isRunning = true;
	public Output(Socket client,String name) {
		try {
			this.dos = new DataOutputStream(client.getOutputStream());
			this.br = new BufferedReader(new InputStreamReader(System.in));
			this.dos.writeUTF(name);
		} catch (IOException e) {
			CloseUtil.Close.closeAll(dos,br);
			isRunning=false;
		}
		
	}
	//�ӿ���̨������Ϣ
	private String getMsg(){
		String msg = null;
		try {
			msg = br.readLine();
		} catch (IOException e) {
			CloseUtil.Close.closeAll(dos,br);
			isRunning=false;
		}
		return msg;
	}
	//����Ϣ������������
	public void send(){
		String msg = getMsg();
		try {
			if(msg!=null){
				dos.writeUTF(msg);
				dos.flush();
			}
		} catch (IOException e) {
			CloseUtil.Close.closeAll(dos,br);
			isRunning=false;
		}
	}
	
	@Override
	public void run() {
		while(isRunning){	
			send();
		}
		
	}
	
}
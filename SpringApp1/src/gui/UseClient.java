package gui;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseClient {
	public static void main(String[] args) {
		// chatclient�� has a ����� �����ϰ� �ִ� ��ü���� ���� new���� ����
		// �������� ApplicationContext�� �̿��Ͽ� �ν��Ͻ��� ����(=injection)����!!
		ClassPathXmlApplicationContext context=null;
		context = new ClassPathXmlApplicationContext("spring/config/gui-context.xml");
		
		ChatClient chatClient = (ChatClient)context.getBean("chatClient");
		chatClient.init();
	}
}

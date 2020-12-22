package food;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseCook {
	public static void main(String[] args) {
		
		/*//���� �ø���
		FriPan pan = new FriPan();
		Cook cook = new Cook();
		//���� �丮�翡�� ���Խ�Ű��!!
		cook.setPan(pan);
		cook.makeFood();
		*/
		//xml�� ���ϴ� ��ü�� ����ϸ� xml�� �ľ��Ͽ� ��ü�� �ν��Ͻ����� ����
		//�̷��� ������ �����ϴ� ��ü�� ������ .Spring Content��ü�� �Ѵ�
		ClassPathXmlApplicationContext context=null;
		//�ν��Ͻ��� ���� �� �������ش�
		context = new ClassPathXmlApplicationContext("spring/config/context.xml");
		
		//xml�� �̹� ������ �����̹Ƿ� �޸𸮿��� �ν��Ͻ����� ������ ���̰�
		//� �ν��Ͻ��� ���������� getBean�޼���� ��������ȴ�.
		Cook cook = (Cook)context.getBean("cook");
		cook.makeFood();
		

	}

}

/*�丮�縦 �����Ѵ�*/
package food;
public class Cook {
	//�����ڷ������� has a ���踦 ��������� ����?
	//�����ڷ����� �����ǰų� ��ȭ�� ������� ���� Ŭ������ has a ���迡 �ִ�
	//�������� ��ȭȭ���ױ� ������ ������������ ������..
	private Pan pan;
	
	
	//�ܺηκ��� �ʿ��� ��ü�� ���Թޱ� ���� setter�޼���
	public void setPan(Pan pan) {
		this.pan = pan;
	}

	public void makeFood() {
		pan.boil();
	}
}

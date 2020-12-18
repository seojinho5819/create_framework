//�ڹ��� �÷��� ������ ���� ��ü�� �����Ͱ� key-value�� ������ �Ǿ��ִ� ������ �����Ͽ�
//ó���� ���ִ� ��ü�� Properties�� �Ѵ�
//�� ������ ���� ������ ������ ������ ���� key-value�� �� �ָ��� �����Ѵ�

package study;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class propTest {
	public propTest() {
		// �������� �ڹ��ڵ忡�� Ư�� ���丮�� ����ִ� ���������� ���� �����ؾ���
		FileInputStream fis = null;
		Properties props = new Properties();
		try {
			fis = new FileInputStream("C:/javaee_workspace/MVCFramework/WebContent/WEB-INF/mapping/mapping.properties");
			props.load(fis);
			
			//���ݺ��ʹ� Ű������ �˻��� �����ϴ�
			String value = props.getProperty("zerg");
			System.out.println(value);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new propTest();
	}
}


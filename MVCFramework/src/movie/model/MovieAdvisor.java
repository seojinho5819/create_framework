package movie.model;

public class MovieAdvisor {
	public String getAdvice(String movie) {
		String msg = null;
		if (movie.equals("���漭2")) {
			msg = "���漭2";
		} else if (movie.equals("�����̴���3")) {
			msg="�Ź��ΰ�3";
		} else if (movie.equals("����")) {
			msg="��������";
		} else if (movie.equals("�г�������")) {
			msg="�д��� ����";
		}
		return msg;
	}

}

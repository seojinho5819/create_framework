package movie.model;

public class MovieAdvisor {
	public String getAdvice(String movie) {
		String msg = null;
		if (movie.equals("블랙펜서2")) {
			msg = "블랙펜서2";
		} else if (movie.equals("스파이더맨3")) {
			msg="거미인간3";
		} else if (movie.equals("존윅")) {
			msg="종간나윅";
		} else if (movie.equals("분노의질주")) {
			msg="분뇨의 질주";
		}
		return msg;
	}

}

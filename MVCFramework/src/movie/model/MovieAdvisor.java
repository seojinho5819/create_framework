package movie.model;

public class MovieAdvisor {
	public String getAdvice(String movie) {
		String msg = null;
		if (movie.equals("ºí·¢Ææ¼­2")) {
			msg = "ºí·¢Ææ¼­2";
		} else if (movie.equals("½ºÆÄÀÌ´õ¸Ç3")) {
			msg="°Å¹ÌÀÎ°£3";
		} else if (movie.equals("Á¸À¨")) {
			msg="Á¾°£³ªÀ¨";
		} else if (movie.equals("ºÐ³ëÀÇÁúÁÖ")) {
			msg="ºÐ´¢ÀÇ ÁúÁÖ";
		}
		return msg;
	}

}

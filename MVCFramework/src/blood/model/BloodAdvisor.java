package blood.model;

public class BloodAdvisor {
	public String getAdvice(String blood) {
		  String msg = null;
		   
		   if(blood.equals("A")){
		      msg = "꼼꼼하고 세심하다 착하고 솔직하다 때론 소심하다";
		   }else if(blood.equals("B")){
		      msg = "남자는 고집이 쎄다, 여자는 엉뚱하다";
		   }else if(blood.equals("O")){
		      msg = "사교성 있고, 둥글둥글하다 그러나 오지랖이다";
		   }else if(blood.equals("AB")){
		      msg = "결정이 자꾸 바뀐다. 뒤집는다. 4차원적";
		   }
		   return msg;
	}
}

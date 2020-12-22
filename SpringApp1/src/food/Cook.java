/*요리사를 정의한다*/
package food;
public class Cook {
	//상위자료형으로 has a 관계를 명시했을때 장점?
	//하위자료형이 삭제되거나 변화가 생기더라도 현재 클래스와 has a 관계에 있는
	//의존성을 약화화시켰기 떄문에 유지보수성이 좋아짐..
	private Pan pan;
	
	
	//외부로부토 필요한 객체를 주입받기 위한 setter메서드
	public void setPan(Pan pan) {
		this.pan = pan;
	}

	public void makeFood() {
		pan.boil();
	}
}

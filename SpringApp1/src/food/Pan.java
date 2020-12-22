/*
 * 일반 프라이팬이건 전기던 증기던 모두를 가리킬수있는 최상위 인터페이스(추상도 가능하나 다중상속될 우려가있기때문에
 * 사실상 인터페이스가 훨씬 많이쓰인다)
 */
package food;

public interface Pan {
	//구현강제할 메서드
	public void boil();
}

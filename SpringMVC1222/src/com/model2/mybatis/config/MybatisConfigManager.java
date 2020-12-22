/*이 클래스의 목적: 
 * 쿼리문 수행에 피요한 sql세션을 보다 쉽게 얻어 갈수 있도록 재사용성을 고려하여
 * 정의한 객체 특히 이 객체의 인스턴스는 어플리케이션 내에서 1개만 워야 하므로 SingleTon
 * 패턴의로 정의하자!!
 */
package com.model2.mybatis.config;
 

import java.io.InputStream; 

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConfigManager {
	// 2) 생성자를 묶었으므로 현재 클래스에서 인스턴스를 제공하지 않으면 사용할 방법이 없다
	// 따라서 현재 클래스에서 getter을 제공해주자!!
	private static MybatisConfigManager instance;
	InputStream inputStream;
	SqlSessionFactory sqlSessionFactory;

	// 1) 생성자를 묶어서 아무나 new 못하게 만들자!!
	private MybatisConfigManager() {
		String resource = "com/model2/mybatis/config/config.xml";
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 3) getter는 제공했으나 역시 인스턴스 메서드 이므로 new 한 다음에나 호출 가능하기 때문에
	// 그 어떤 객체로 이 메서드를 호출할 수 없다..(new를 막아서..)\
	// 해결책: new 하지 않고도 접근가능하게 하기 위해 static메서드로 정의하자!!
	public static MybatisConfigManager getInstance() {
		// 4) 이 메서드 호출시 instance 변수가 null이라면, 여기서 인스턴스를 생성해서
		// null이 아닌 값을 가져가도록 처리하자!!
		if (instance == null) {
			instance = new MybatisConfigManager();
		}
		return instance;
	}

	// SqlSession얻기!!
	public SqlSession getSqlSession() {
		SqlSession sqlSession = null;
		sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}

	public void close(SqlSession sqlSession) {
		if (sqlSession != null) {
			sqlSession.close();
		}
	}
}

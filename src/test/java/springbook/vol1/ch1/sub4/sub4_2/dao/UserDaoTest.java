package springbook.vol1.ch1.sub4.sub4_2.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import springbook.vol1.ch1.sub4.sub4_2.domain.User;

@DisplayName("1-4-2 UserDaoTest 클래스")
class UserDaoTest {

	UserDao dDao = new UserDaoFactory().userDao();

	@BeforeEach
	void setUp() throws SQLException {
		dDao.clean();
	}

	@Test
	void 다음_유저생성과_조회_성공() throws SQLException {
		User user = new User();
		user.setId("kukim");
		user.setName("쿠킴");
		user.setPassword("1234");
		dDao.add(user);

		User findUser = dDao.get("kukim");

		assertAll(
			() -> assertThat(findUser.getId()).isEqualTo(user.getId()),
			() -> assertThat(findUser.getName()).isEqualTo(user.getName()),
			() -> assertThat(findUser.getPassword()).isEqualTo(user.getPassword())
		);
	}

	@Test
	void 다음_유저_조회_실패() {
		assertThatThrownBy(() ->
			dDao.get("존재하지않는유저아이디"))
			.isInstanceOf(SQLException.class);
	}
}

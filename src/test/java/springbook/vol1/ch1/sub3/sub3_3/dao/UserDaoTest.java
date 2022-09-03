package springbook.vol1.ch1.sub3.sub3_3.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import springbook.vol1.ch1.sub3.sub3_3.domain.User;

@DisplayName("1-3-1 UserDaoTest 클래스")
class UserDaoTest {

	private UserDao nDao = new UserDao(new NConnectionMaker());
	private UserDao dDao = new UserDao(new DConnectionMaker());

	@BeforeEach
	void setUp() throws SQLException {
		nDao.clean();
		dDao.clean();
	}

	@Test
	void 네이버_유저생성과_조회_성공() throws SQLException {
		User user = new User();
		user.setId("kukim");
		user.setName("쿠킴");
		user.setPassword("1234");
		nDao.add(user);

		User findUser = nDao.get("kukim");

		assertAll(
			() -> assertThat(findUser.getId()).isEqualTo(user.getId()),
			() -> assertThat(findUser.getName()).isEqualTo(user.getName()),
			() -> assertThat(findUser.getPassword()).isEqualTo(user.getPassword())
		);
	}

	@Test
	void 네이버_유저_조회_실패() {
		assertThatThrownBy(() ->
			nDao.get("존재하지않는유저아이디"))
			.isInstanceOf(SQLException.class);
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

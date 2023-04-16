package orm.m.a101;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import fa.training.dao.CinemaRoomDao;
import fa.training.dao.CinemaRoomDetailDao;
import fa.training.dao.Dao;
import fa.training.dao.SeatDao;
import fa.training.entities.CinemaRoom;
import fa.training.entities.CinemaRoomDetail;
import fa.training.entities.Seat;
import fa.training.service.ServiceImpl;
import fa.training.utils.HibernateConnection;

class AppTest {
	
	private static SessionFactory sessionFactory;
	private static Session session;
	private static Dao<CinemaRoom> cinemaroom = new CinemaRoomDao();
	private static Dao<CinemaRoomDetail> roomDetail = new CinemaRoomDetailDao();
	private static Dao<Seat> seatDao = new SeatDao();

	@BeforeAll
	public static void setup() {
		sessionFactory = HibernateConnection.getSessionFactory();
		System.out.println("session factory is created");
		ServiceImpl app = new ServiceImpl();
		app.insert();
	}

	@AfterAll
	public static void tearDown() {
		if (sessionFactory != null)
			sessionFactory.close();
		System.out.println("SessionFactory is destroyed");
	}
	//
	@Test
	void getCinemaRoomById() {
		System.out.println("getID");
		Integer id = 1;
		CinemaRoom room = cinemaroom.getById(id);
		assertEquals("CGV", room.getCinemaRoomName());
	}

	@Test
	void getAllCinema() {
		System.out.println("getALL");
		List<CinemaRoom> roomLists = cinemaroom.getAll();
		assertFalse(roomLists.isEmpty());
	}
	@Test
	void updateCinemaById() {
		System.out.println("update");
		Integer id = 1;
		CinemaRoom room = cinemaroom.update(id);
		assertEquals("CGV", room.getCinemaRoomName());
	}
	
	@Test
	@Disabled
	void deleteCinemaById() {
		Integer id = 1;
		System.out.println("deleting...");
		cinemaroom.delete(id);
		CinemaRoom room = cinemaroom.getById(id);
		assertNull(room);
	}
	
	//
	
	@Test
	void getCinemaDetailById() {
		System.out.println("getID");
		Integer id = 101;
		CinemaRoomDetail detail = roomDetail.getById(id);
		assertEquals(5, detail.getRoomRate());
	}

	@Test
	void getAllCinemaDetail() {
		System.out.println("getALL");
		List<CinemaRoomDetail> detailLists = roomDetail.getAll();
		assertFalse(detailLists.isEmpty());
	}
	@Test
	void updateCinemaDetailById() {
		System.out.println("update");
		Integer id = 101;
		CinemaRoomDetail detail = roomDetail.update(id);
		assertEquals("changed", detail.getRoomDescription());
	}
	
	@Test
	@Disabled
	void deleteCinemaDetailById() {
		Integer id = 1;
		System.out.println("deleting...");
		roomDetail.delete(id);
		CinemaRoomDetail detail = roomDetail.getById(id);
		assertNull(detail);
	}
	//
	@Test
	void getSeatById() {
		System.out.println("getID");
		Integer id = 1;
		Seat seat = seatDao.getById(id);
		assertEquals("Booked", seat.getSeatStatus());
	}

	@Test
	void getAllSeat() {
		System.out.println("getALL");
		List<Seat> seat = seatDao.getAll();
		assertFalse(seat.isEmpty());
	}
	@Test
	void updateSeatById() {
		System.out.println("update");
		Integer id = 1;
		Seat seat = seatDao.update(id);
		assertEquals("Booked", seat.getSeatStatus());
	}
	
	@Test
	@Disabled
	void deleteSeatById() {
		Integer id = 1;
		System.out.println("deleting...");
		seatDao.delete(id);
		Seat seat = seatDao.getById(id);
		assertNull(seat);
	}
	//
	@BeforeEach
	public void openSession() {
		session = sessionFactory.openSession();
		System.out.println("session is created");
	}

	@AfterEach
	public void closeSession() {
		if (session != null)
			session.close();
		System.out.println("session is closed\n");
	}
}

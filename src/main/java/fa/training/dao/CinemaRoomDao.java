package fa.training.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

import fa.training.entities.CinemaRoom;
import fa.training.utils.HibernateConnection;

public class CinemaRoomDao implements Dao<CinemaRoom> {
	
	private  Session session = HibernateConnection.getSessionFactory().openSession();
	private CinemaRoom cinema;
	private static final String GET_CINEMA_ROOM = "from CinemaRoom";
	public CinemaRoomDao() {
		cinema = new CinemaRoom("CGV");
	}
	@Override
	public void save(CinemaRoom cinemaroom) {
		session.beginTransaction();
		session.save(cinemaroom);
		session.getTransaction().commit();
		System.out.println("save successfully...");
	}

	@Override
	public CinemaRoom getById(int id) {
		return session.find(CinemaRoom.class, id);
	}

	@Override
	public List<CinemaRoom> getAll() {
		Query<CinemaRoom> query = session.createQuery(GET_CINEMA_ROOM,CinemaRoom.class);
		List<CinemaRoom> lists = query.list();
		return lists;
	}

	@Override
	public CinemaRoom update(int id) {
		if(!session.beginTransaction().isActive()) {
			session.beginTransaction();
		}
		CinemaRoom cinema = session.find(CinemaRoom.class, id);
		cinema.setCinemaRoomName("CGV");
		session.save(cinema);
		session.getTransaction().commit();
		System.out.println("update successfully...");
		return cinema;
	}

	@Override
	public void delete(int id) {
		if(!session.beginTransaction().isActive()) {
			session.beginTransaction();
		}
		CinemaRoom cinema = session.find(CinemaRoom.class, id);
		session.delete(cinema);
		session.getTransaction().commit();
		System.out.println("delete successfully...");
	}
	public CinemaRoom getCinemRoom() {
		return cinema;
	}

}

package fa.training.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import fa.training.entities.CinemaRoomDetail;
import fa.training.utils.HibernateConnection;

public class CinemaRoomDetailDao implements Dao<CinemaRoomDetail> {
	
	private  Session session = HibernateConnection.getSessionFactory().openSession();
	private CinemaRoomDetail detail;
	private static final String GET_CINEMA_ROOM_DETAIL = "from CinemaRoomDetail";

	public CinemaRoomDetailDao() {
		detail = new CinemaRoomDetail(5);
	}
	@Override
	public void save(CinemaRoomDetail cinemadetail) {
		session.beginTransaction();
		session.save(cinemadetail);
		session.getTransaction().commit();
		System.out.println("save successfully...");
	}

	@Override
	public CinemaRoomDetail getById(int id) {
		return session.find(CinemaRoomDetail.class, id);
	}

	@Override
	public List<CinemaRoomDetail> getAll() {
		Query<CinemaRoomDetail> query = session.createQuery(GET_CINEMA_ROOM_DETAIL,CinemaRoomDetail.class);
		List<CinemaRoomDetail> lists = query.list();
		return lists;
	}

	@Override
	public CinemaRoomDetail update(int id) {
		session.beginTransaction();
		CinemaRoomDetail cinemaDetail = session.find(CinemaRoomDetail.class, id);
		cinemaDetail.setRoomDescription("changed");;
		session.save(cinemaDetail);
		session.getTransaction().commit();
		System.out.println("update successfully...");
		return cinemaDetail;
	}

	@Override
	public void delete(int id) {
		session.beginTransaction();
		CinemaRoomDetail cinemadetail = session.find(CinemaRoomDetail.class, id);
		session.delete(cinemadetail);
		session.getTransaction().commit();
		System.out.println("delete successfully...");
	}
	public CinemaRoomDetail getDetail() {
		return detail;
	}
	
}

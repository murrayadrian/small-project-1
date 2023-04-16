package fa.training.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import fa.training.entities.Seat;
import fa.training.utils.HibernateConnection;

public class SeatDao implements Dao<Seat> {

	private  Session session = HibernateConnection.getSessionFactory().openSession();
	private List<Seat> seatLists = new ArrayList<>();
	private static String GET_SEAT ="from Seat";
	
	public SeatDao() {
		seatLists.add(new Seat("Booked","VIP"));
		seatLists.add(new Seat("1","1"));
		seatLists.add(new Seat("Booked","1"));
	}
	
	@Override
	public void save(Seat seat) {
		session.beginTransaction();
		session.save(seat);
		session.getTransaction().commit();
		System.out.println("save successfully...");
	}

	@Override
	public Seat getById(int id) {
		return session.find(Seat.class, id);
	}

	@Override
	public List<Seat> getAll() {
		Query<Seat> query = session.createQuery(GET_SEAT,Seat.class);
		List<Seat> lists = query.list();
		return lists;
	}

	@Override
	public Seat update(int id) {
		session.beginTransaction();
		Seat seat = session.find(Seat.class, id);
		seat.setSeatStatus("Booked");;
		session.save(seat);
		session.getTransaction().commit();
		System.out.println("update successfully...");
		return seat;
	}

	@Override
	public void delete(int id) {
		session.beginTransaction();
		Seat seat = session.find(Seat.class, id);
		session.delete(seat);
		session.getTransaction().commit();
		System.out.println("delete successfully...");
	}

	public List<Seat> getSeatLists() {
		return seatLists;
	}
	
}

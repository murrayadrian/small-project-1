package fa.training.service;

import java.util.List;
import org.hibernate.Session;
import fa.training.dao.CinemaRoomDao;
import fa.training.dao.CinemaRoomDetailDao;
import fa.training.dao.SeatDao;
import fa.training.entities.CinemaRoom;
import fa.training.entities.CinemaRoomDetail;
import fa.training.entities.Seat;
import fa.training.utils.HibernateConnection;

public class ServiceImpl implements Service{
	
	private Session session = HibernateConnection.getSessionFactory().openSession();
		
	@Override
	public void insert() {
		CinemaRoomDao cinemaRoomDao = new CinemaRoomDao();
		CinemaRoomDetailDao detailDao = new CinemaRoomDetailDao();
		SeatDao seatDao = new SeatDao();
		
		CinemaRoom cinemaroom = cinemaRoomDao.getCinemRoom();
		CinemaRoomDetail detail = detailDao.getDetail();
		List<Seat> seatLists = seatDao.getSeatLists();
		
		session.beginTransaction();
		
		cinemaroom.setRoomDetail(detail);
		detail.setCinemaRoomId(cinemaroom);
		
		for(int i =0;i<seatLists.size();i++) {
			cinemaroom.getSeats().add(seatLists.get(i));
			seatLists.get(i).setRoomId(cinemaroom);
			session.save(seatLists.get(i));
		}
		session.save(cinemaroom);
		session.save(detail);
		session.getTransaction().commit();
		session.close();
		System.out.println("insert successfully...");
	}
}

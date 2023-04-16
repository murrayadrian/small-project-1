package fa.training.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import fa.training.entities.CinemaRoom;
import fa.training.entities.CinemaRoomDetail;
import fa.training.entities.Seat;

public class HibernateConnection {
	private static SessionFactory sessionFactory = null;
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			Configuration configuration = new Configuration();
			configuration.configure();
			configuration.addAnnotatedClass(CinemaRoom.class).addAnnotatedClass(CinemaRoomDetail.class).addAnnotatedClass(Seat.class);
			sessionFactory = configuration.buildSessionFactory();
		}
		return sessionFactory;
	}
}

package fa.training.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name= "CINEMA_ROOM")
public class CinemaRoom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CINEMA_ROOM_ID")
	private int id;
	
	@Column(name="CINEMA_ROOM_NAME",unique = true)
	private String cinemaRoomName;
	
	@Column(name="SEAT_QUANTITY")
	private int seatQuantity;
	
	@OneToOne(mappedBy ="cinemaId",cascade = CascadeType.REMOVE)
	private CinemaRoomDetail roomDetail;
	
	@OneToMany(mappedBy="roomId",cascade = CascadeType.ALL)
	private List<Seat> seats = new ArrayList<>();
	
	
	
	public CinemaRoom() {
	}
	public CinemaRoom(String cinemaRoomName) {
		this.cinemaRoomName = cinemaRoomName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCinemaRoomName() {
		return cinemaRoomName;
	}
	public void setCinemaRoomName(String cinemaRoomName) {
		this.cinemaRoomName = cinemaRoomName;
	}
	public int getSeatQuantity() {
		return seatQuantity;
	}
	public void setSeatQuantity(int seatQuantity) {
		this.seatQuantity = seatQuantity;
	}
	
	public CinemaRoomDetail getRoomDetail() {
		return roomDetail;
	}
	public void setRoomDetail(CinemaRoomDetail roomDetail) {
		this.roomDetail = roomDetail;
	}
	
	public List<Seat> getSeats() {
		return seats;
	}
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "CinemaRoom [id=" + id + ", cinemaRoomName=" + cinemaRoomName + ", seatQuantity="
				+ seatQuantity+"]";
	}
	
	
}

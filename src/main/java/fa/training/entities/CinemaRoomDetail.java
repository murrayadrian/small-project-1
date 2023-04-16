package fa.training.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CINEMA_ROOM_DETAIL")
@SequenceGenerator(initialValue =101,allocationSize=1, name = "DETAIL_ID")
public class CinemaRoomDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="DETAIL_ID")
	@Column(name="CINEMA_ROOM_DETAIL_ID")
	private int id;
	
	@Column(name="ROOM_RATE")
	private int roomRate;
	
	@Column(columnDefinition = "DATE",name="ACTIVE_DATE")
	private LocalDate activeDate;
	
	@Column(name="ROOM_DESCRIPTION")
	private String roomDescription;
	
	@OneToOne
	@JoinColumn(name="CINEMA_ROOM_ID")
	private CinemaRoom cinemaId;
	
	
	
	public CinemaRoomDetail() {
		
	}
	
	public CinemaRoomDetail(int roomRate) {
		this.roomRate = roomRate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoomRate() {
		return roomRate;
	}
	public void setRoomRate(int roomRate) {
		this.roomRate = roomRate;
	}
	public LocalDate getActiveDate() {
		return activeDate;
	}
	public void setActiveDate(LocalDate activeDate) {
		this.activeDate = activeDate;
	}
	public String getRoomDescription() {
		return roomDescription;
	}
	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}

	public CinemaRoom getCinemaRoomId() {
		return cinemaId;
	}

	public void setCinemaRoomId(CinemaRoom cinemaId) {
		this.cinemaId = cinemaId;
	}

	@Override
	public String toString() {
		return "CinemaRoomDetail [id=" + id + ", rate=" + roomRate + ", activeDate=" + activeDate
				+ ", description=" + roomDescription+ ", FK="+this.cinemaId.getId()+"]";
	}
	
	
}

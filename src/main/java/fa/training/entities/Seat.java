package fa.training.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SEAT")
public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SEAT_ID")
	private int id;

	@Column(name = "SEAT_COLUMN")
	private String seatColumn;

	@Column(name = "SEAT_ROW")
	private int seatRow;

	@Column(name = "SEAT_STATUS")
	private String seatStatus;

	@Column(name = "SEAT_TYPE")
	private String seatType;

	@ManyToOne
	@JoinColumn(name = "CINEMA_ROOM_ID")
	private CinemaRoom roomId;

	
	public Seat() {
		
	}
	
	public Seat(String seatStatus, String seatType) {
		if ("Not Available".equals(seatStatus) || "Booked".equals(seatStatus)) {
			this.seatStatus = seatStatus;
		} else {
			this.seatStatus = "Available";
		}
		if ("VIP".equals(seatType)) {
			this.seatType = seatType;
		} else {
			this.seatType = "Normal";
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSeatColumn() {
		return seatColumn;
	}

	public void setSeatColumn(String seatColumn) {
		this.seatColumn = seatColumn;
	}

	public int getSeatRow() {
		return seatRow;
	}

	public void setSeatRow(int seatRow) {
		this.seatRow = seatRow;
	}

	public String getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(String seatStatus) {
		if ("Not Available".equals(seatStatus) || "Booked".equals(seatStatus)) {
			this.seatStatus = seatStatus;
		} else {
			this.seatStatus = "Available";
		}
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		if ("VIP".equals(seatType)) {
			this.seatType = seatType;
		} else {
			this.seatType = "Normal";
		}
	}

	public CinemaRoom getRoomId() {
		return roomId;
	}

	public void setRoomId(CinemaRoom roomId) {
		this.roomId = roomId;
	}

	@Override
	public String toString() {
		return "Seat [id=" + id + ", seatColumn=" + seatColumn + ", seatRow=" + seatRow + ", seatStatus=" + seatStatus
				+ ", seatType=" + seatType + ", FK=" + this.roomId.getId() + "]";
	}

}

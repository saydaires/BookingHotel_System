package HotelSystem;
/*Classe Quarto:
- Atributos: número do quarto (int), tipo do quarto (String), preço por noite (double)
status (boolean: disponível ou ocupado).
- Métodos: construtores, getters e setters.
 */
public class Room {
	private final int roomNumber; //I decide to declare 'roomNumber' as a final variable;
	private String roomType;
	private double pricePerNight;
	private boolean status;
	
	public Room(int roomNumber, String roomType, double pricePerNight, boolean status)
	{
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.pricePerNight = pricePerNight;
		this.status = status;
	} // end of Class Constructor of Room Class
	//getters methods
	public int getRoomNumber()
	{
		return roomNumber;
	}
	
	public String getRoomType()
	{
		return roomType;
	}
	
	public double getPricePerNight()
	{
		return pricePerNight;
	}
	
	public boolean getStatus()
	{
		return status;
	}
	//setters methods
	public void setRoomType(String newRoomType)
	{
		this.roomType = newRoomType;
	}
	
	public void setPricePerNight(double newPricePerNight)
	{
		this.pricePerNight = newPricePerNight;
	}
	
	public void setStatus(boolean newStatus)
	{
		this.status = newStatus;
	}
} //end of 'Room' Class
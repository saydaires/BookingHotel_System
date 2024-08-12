package HotelSystem;
/*Classe Reserva:
- Atributos: hóspede (Hóspede), quarto (Quarto), data de entrada (String), data de saída (String), valor total (double).
- Métodos: construtores, getters e setters.*/
public class Booking { //this class booking the hotel book for an guest user;
	private Guest guest;
        private Room room;
        private String inputData;
        private String outputData;
        private final double totalExpenses;
        
        public Booking(Guest guest, Room room, String inData, String outData, double totalExpenses)
        {
            this.guest = guest;
            this.room = room;
            this.inputData = inData;
            this.outputData = outData;
            this.totalExpenses = totalExpenses;
        }
        //getters methods
        public Guest getGuest()
        {
            return guest;
        }
        
        public Room getRoom()
        {
            return room;
        }
        
        public String inputData()
        {
            return inputData;
        }
        
        public String outputData()
        {
            return outputData;
        }
        
        public double getTotalExpenses()
        {
            return totalExpenses;
        }
        //setters methods;
        public void setGuest(Guest newGuestData)
        {
            guest = newGuestData;
        }
        
        public void setRoom(Room newRoomData)
        {
            room = newRoomData;
        }
        
        public void setInputData(String newInputData)
        {
            inputData = newInputData;
        }
        
        public void setOutputData(String newOutputData)
        {
            outputData = newOutputData;
        }
        
}
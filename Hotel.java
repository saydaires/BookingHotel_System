package HotelSystem;
import java.util.ArrayList;
import java.util.Scanner;
public class Hotel {
    private final Scanner scanner = new Scanner(System.in);
    private final ArrayList<Guest> guestList = new ArrayList<Guest>();
    private final ArrayList<Room> roomList = new ArrayList<Room>();
    private final ArrayList<Booking> bookingList = new ArrayList<Booking>();

    public void addGuest()
    {
       do
       {
           System.out.println("Guest Name: ");
           String nameGuest = scanner.nextLine();
           System.out.println("Guest CPF: ");
           String CPFGuest = scanner.nextLine();

           if(verifyCPF(CPFGuest))
           {
               System.out.println("CPF is invalid or already in System.");
               System.out.print("Re-registering the Guest? (1 - Yes, 0 - No)\nOption --> ");
               int option = scanner.nextInt();
               cleanBuffer();

               if(option == 1)
               {
                   //clean console method;
                   continue;
               }
               else
               {
                   //clean console method;
                    break;
               }     
           }

           System.out.println("Guest Phone: ");
           String PhoneGuest = scanner.nextLine();
           Guest guest = new Guest(nameGuest, CPFGuest, PhoneGuest);
           guestList.add(guest);
           // clean console method;
           System.out.println("Finish Register. Press <ENTER> to return menu");
           scanner.nextLine();
           // clean console method;
           break;

       }while(true);    
    }

    //verifications methods;
    public boolean verifyCPF(String cpf)
    {
        for(int index = 0; index < guestList.size(); index++)
        {
            Guest currentGuest = guestList.get(index);

            if(cpf.equals(currentGuest.getCPF()))
                return true; //returns true if CPF already exists;
        }
        return false;
    }

    public boolean verifyRoomNumber(int roomNumber)
    {
        for(int index = 0; index < roomList.size(); index++)
        {
            Room room = roomList.get(index);
            if(roomNumber == room.getRoomNumber())
                return true; //return true if roomNumber already exists;
        }
        return false;
    }

    public boolean verifyRoomStatus(int roomNumber)
    {
        for(int index = 0; index < roomList.size(); index++)
        {
            Room room = roomList.get(index);
            if(roomNumber == room.getRoomNumber())
            {
                if(room.getStatus())
                    return true; //this true return indicates that this room is booked;
                break; //break the 'for' loop, because the boolean status of this room currently is known (is false);
            }
        }
        return false; //this false return indicates that this room is NOT booked;
    }

    //end of verifications methods;

    public void addRoom()
    {
        do
        {
            System.out.println("Room Number: ");
            int roomNumber = scanner.nextInt();
            cleanBuffer();
           if(verifyRoomNumber(roomNumber))
            {
                System.out.println("This Room Numbers already exists in the System!");
                System.out.println("Please, enter other number");
                System.out.println("Press <Enter> to continue");
                scanner.nextLine();
                //clean console method;
                continue;
            }
            System.out.println("Room Type: ");
            String roomType = scanner.nextLine();
            System.out.println("Price Per Night: $ ");
            double pricePerNight = scanner.nextDouble();
            cleanBuffer();
            System.out.println("Status (Booked | Not Booked): ");
            String statusString = scanner.nextLine();
            String statusStringNotUnderline = statusString.trim();
            boolean status = false;
            if(statusStringNotUnderline.compareToIgnoreCase("Booked") == 0)
                status = true;
            else if(statusStringNotUnderline.compareToIgnoreCase("NotBooked") == 0)
                status = false;

            Room room = new Room(roomNumber, roomType, pricePerNight, status);
            roomList.add(room);
            //clean console method;
            System.out.println("Finish Register. Press <ENTER> to return menu");
            scanner.nextLine();
            //clean console method;
            break;
        } while(true); 
    }

    public void makeBooking()
    {
        if(guestList.isEmpty() || roomList.isEmpty())
        {
            System.out.println("First, enter Data in the System.");
            System.out.println("Press <ENTER> to continue");
            scanner.nextLine();
            //clean consolhe method;
            return;
        }
        do
        {
            System.out.println("Enter the desired Room Number: ");
            int roomNumber = scanner.nextInt();
            cleanBuffer();
            if(verifyRoomNumber(roomNumber))
            {
                if(verifyRoomStatus(roomNumber))
                {
                    System.out.println("This room currently has Booked Status.");
                    System.out.println("Press <1> if you want try other rooom");
                    int number = scanner.nextInt();
                    cleanBuffer();
                    //clean console method;
                    if(number == 1)
                        continue;
                    else
                        break;
                }
                //this below instructions will be runs if room is NOT booked (lines 162 - 172);
                /* //           *******************CHECKPOINT*******************
                
                ask the guest CPF, and cheks if this CPF is already exists in ArrayList<Guest>;
                
                if true case, ask the date's of input and output booking, and calculate the booking price
                used 'calcularValorTotalReserva(Quarto quarto, String dataEntrada, String dataSaida'
                
                if false case, ask if the staff wants to add the guest in ArrayList<Guest>, in true case call
                the 'addGuest()' method. In the both cases, uses the 'break' instruction to stop the 'do while' loop.
                */
                
                System.out.println("Guest CPF: ");
                String CPFGuest = scanner.nextLine();
                if(verifyCPF(CPFGuest))
                {
                    System.out.println("Input Date (DD/MM): ");
                    String inputData = scanner.nextLine();
                    System.out.println("Output Date (DD/MM): ");
                    String outputData = scanner.nextLine();
                    //****CHECKPOINT***
                    //calculateTotalExpenses(inputData, outputData);
                }
                //case CPF NOT exists;
            }
            else
            {
                System.out.println("Invalid Room Number!");
                System.out.println("Press <1> if you want try other room");
                int number = scanner.nextInt();
                cleanBuffer();
                //clean console method;
                if(number == 1)
                    continue;
                else
                    break;        
            }
        }while(true);
    }
    /* ********CHEKCPOINT********
    public double calculateTotalExpenses(String inputData, String outputData)
    {
        Irei utilizar métodos String que deverao:
        1. Captar a String antes do / "DD" e captar a String apos o / "MM";
        2. Converter DD em double/int ou MM em double/int
        3. Usar os valores numericos convertidos para calcular totalExpenses;
       
    }*/

    public void cleanBuffer()
    {
        if(scanner.hasNextLine())
            scanner.nextLine();
    }
}
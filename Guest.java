package HotelSystem;
public class Guest {
	private String name; // name of guest user;
	private String CPF; //CPF of guest user;
	private String phone; // phone of guest user;
	
	public Guest(String name, String CPF, String phone) // guest class Constructor;
	{
		this.name = name;
		this.CPF = CPF;
		this.phone = phone;
	}
	//getters methods;
	public String getName()
	{
		return name;
	}
	
	public String getCPF()
	{
		return CPF;
	}
	
	public String getPhone()
	{
		return phone;
	}
	//setters methods;
	public void setName(String newName)
	{
		this.name = newName;
	}
	
	public void setCPF(String newCPF)
	{
		this.CPF = newCPF;
	}
	
	public void setPhone(String newPhone)
	{
		this.phone = newPhone;
	}
} // end of guest class;
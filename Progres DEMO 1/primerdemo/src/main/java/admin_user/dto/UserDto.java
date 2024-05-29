package admin_user.dto;

public class UserDto {
	
	
    private String email;
    private String password;
    private String role;
    private String firstname;
    private String lastname;
    private String phone;
	public UserDto(String email, String password, String role, String firstname, String lastname, String phone) {
		super();
		this.email = email;
		this.password = password;
        this.role = "USER";  // Inicialización en el constructor
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
       
}

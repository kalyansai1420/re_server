package com.realestate.re.payload;

public class UserDto {

    private Long uId;
    private String username;
    private String email;
    private String phonenumber;
    private String password;
    private boolean enabled = true;
    
    public UserDto() {
        super();
        // TODO Auto-generated constructor stub
    }

    public UserDto(Long uId, String username, String email, String phonenumber, String password, boolean enabled) {
        super();
        this.uId = uId;
        this.username = username;
        this.email = email;
        this.phonenumber = phonenumber;
        this.password = password;
        this.enabled = enabled;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    
    

   

    
}

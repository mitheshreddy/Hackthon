package com.excercise.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	private String userId;
	private String userName;
	private String password;
	private String emailId;
	
	public String getUserId()
    {
        return userId;
    }

    public void setUserId(final String userId)
    {
        this.userId = userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setPassword(final String password)
    {
        this.password = password;
    }
    
    public String getPassword()
    {
        return password;
    }

    public void setEmailId(final String emailId)
    {
        this.emailId = emailId;
    }
    
    public String getEmailId()
    {
        return emailId;
    }


    

}

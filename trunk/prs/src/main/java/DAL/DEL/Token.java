/**
 * Entity to represent a login token
 */
package DAL.DEL;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.NaturalId;


@Entity
@Table(name="token")
public class Token implements Serializable
{
	
	private String token;
	private Timestamp issued_time;
	private int mins_valid;	
	private Long id;
	private User user;
	
	public Token(User user){
		setUser(user);		
	}
	
	public Token(){}
	
	
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	public Long getId() 
	{
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) 	{		
		this.id = id;
	}
	
	@NaturalId
	@Column(name = "token")
	public String getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * @return the issued_date_time
	 */
	
	@Column(name="issued_time")
	public Timestamp getIssued_time() {
		return issued_time;
	}
	/**
	 * @param issued_date_time the issued_date_time to set
	 */
	public void setIssued_time(Timestamp issued_time) {
		this.issued_time = issued_time;
	}
	/**
	 * @return the mins_valid
	 */
	@Column(name = "mins_valid")
	public int getMins_valid() {
		return mins_valid;
	}
	/**
	 * @param mins_valid the mins_valid to set
	 */
	public void setMins_valid(int mins_valid) {
		this.mins_valid = mins_valid;
	}
	
	@ManyToOne
	@ForeignKey(name="FK_user")
	public User getUser(){
		return this.user;
	
	}
	public void setUser(User user)
	{
		this.user = user;
	}
	
}

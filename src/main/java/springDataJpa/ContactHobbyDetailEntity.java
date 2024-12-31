package springDataJpa;
import jakarta.persistence.*;
@Entity
@Table(name = "contact_hobby_detail", schema = "", catalog = "SpringDataJpa")
public class ContactHobbyDetailEntity {
	int contactId;
	String hobbyId = new String();//identifier
	ContactEntity contactByContactId = new ContactEntity();//object of contact entity
	public ContactHobbyDetailEntity() { }
	@Id
	@Column(name = "contact_id", nullable = false, insertable = true,
	updatable = true)
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;//contact identifier
	}
	@Id
	@Column(name = "hobby_id", nullable = false, insertable = true,
	updatable = true, length = 20)
	public String getHobbyId() {
		return hobbyId;
	}
	public void setHobbyId(String hobbyId) {
		this.hobbyId = hobbyId;//assigning hobby identifier
	}
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "contact_id", referencedColumnName = "id", nullable = false)
	public ContactEntity getContactByContactId() {
		return contactByContactId;
	}
	public void setContactByContactId(ContactEntity contactByContactId) {
		this.contactByContactId = contactByContactId;//assigning object of contact entity
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ContactHobbyDetailEntity that = (ContactHobbyDetailEntity)o;//changing object type
		if (this.contactId != that.contactId) return false;
		if (this.hobbyId != null ? !this.hobbyId.equals(that
				.hobbyId) : that.hobbyId != null) return false;
		return true;
	}
	@Override
	public int hashCode() {
		int result = this.contactId;//outcome of hash code
		result = 31 * result + (this.hobbyId != null ? this.hobbyId.hashCode() : 0);//adding hobby identifier to hash code
		return result;
	}
	@Override
	public String toString() { return "contactHobbyDetailEntity{" + "contactId=" + this.contactId
			+ ", hobbyId='" + this.hobbyId + '\''
			+ '}'; }//whole information about contact's hobby
}
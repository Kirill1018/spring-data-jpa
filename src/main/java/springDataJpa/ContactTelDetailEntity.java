package springDataJpa;
import jakarta.persistence.*;
@Entity
@Table(name = "contact_tel_detail", schema = "", catalog = "SpringDataJpa")
public class ContactTelDetailEntity {
	Integer id;
	String telType = new String(), telNumber = new String();//telephone information
	int version;
	public ContactTelDetailEntity() { }
	@Id
	@Column(name = "id", nullable = false, insertable = true,
	updatable = true)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;//assigning identifier
	}
	@Basic
	@Column(name = "tel_type", nullable = false, insertable = true,
	updatable = true, length = 20)
	public String getTelType() {
		return telType;
	}
	public void setTelType(String telType) {
		this.telType = telType;//assigning telephone type
	}
	@Basic
	@Column(name = "tel_number", nullable = false, insertable = true,
	updatable = true, length = 20)
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;//assigning telephone number
	}
	@Basic
	@Column(name = "version", nullable = false, insertable = true,
	updatable = true)
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;//assigning version
	}
	ContactEntity contact = new ContactEntity();//object of contact entity
	@ManyToOne
	@JoinColumn(name = "contact_id", referencedColumnName = "id", nullable = false)
	public ContactEntity getContact() {
		return contact;
	}
	public void setContact(ContactEntity contact) {
		this.contact = contact;//assigning contact
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ContactTelDetailEntity that = (ContactTelDetailEntity)o;//changing type of detail entity of contact telephone
		if (this.id != that.id) return false;
		if (this.version != that.version) return false;
		if (this.telType != null ? !this.telType.equals(that
				.telType) : that.telNumber != null) return false;
		if (this.telNumber != null ? !this.telNumber.equals(that
				.telNumber) : that.telNumber != null) return false;
		return true;
	}
	@Override
	public int hashCode() {
		int result = this.id;//outcome of hash code
		result = 31 * result + (this.telType != null ? this.telType.hashCode() : 0);//adding telephone type to hash code
		result = 31 * result + (this.telNumber != null ? this.telNumber.hashCode() : 0);//adding telephone number to hash code
		result = 31 * result + this.version;//adding version to hash code
		return result;
	}
	@Override
	public String toString() { return "contactTelDetailEntity{" + "version=" + this.version
			+ ", telNumber='" + this.telNumber + '\''
			+ ", telType='" + this.telType + '\''
			+ ", id=" + this.id + '}'; }//whole information about contact's telephone
}
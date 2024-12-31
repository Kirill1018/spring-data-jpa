package springDataJpa;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
@Entity
@Table(name = "contact", schema = "", catalog = "SpringDataJpa")
public class ContactEntity {
	int id, version;
	String firstname = new String(), lastName = new String();//behalf & surname
	Date birthDate = new Date();//representation specific instant in time
	public ContactEntity() { }
	@Id
	@Column(name = "id", nullable = false, insertable = true,
	updatable = true)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;//identifier
	}
	@Basic
	@Column(name = "version", nullable = false, insertable = true,
	updatable = true)
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;//release
	}
	@Basic
	@Column(name = "first_name", nullable = false, insertable = true,
	updatable = true, length = 60)
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;//assigning name
	}
	@Basic
	@Column(name = "last_name", nullable = false, insertable = true,
	updatable = true, length = 40)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;//assigning surname
	}
	@Basic
	@Column(name = "birth_date", nullable = true, insertable = true,
	updatable = true)
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;//assigning birth date
	}
	Set<ContactTelDetailEntity> contactTelDetailEntities = new HashSet<ContactTelDetailEntity>();
	@OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<ContactTelDetailEntity> getContactTelDetailEntities() {
		return contactTelDetailEntities;
	}
	public void setContactTelDetailEntities(Set<ContactTelDetailEntity> contactTelDetailEntities) {
		this.contactTelDetailEntities = contactTelDetailEntities;//assigning detail entities of contact telephone 
	}
	Set<HobbyEntity> hobbies = new HashSet<HobbyEntity>();//hobby collection
	@ManyToMany
	@JoinTable(name = "contact_hobby_detail", joinColumns = @JoinColumn(name = "contact_id"), inverseJoinColumns = @JoinColumn(name = "hobby_id"))
	public Set<HobbyEntity> getHobbies() {
		return hobbies;
	}
	public void setHobbies(Set<HobbyEntity> hobbies) {
		this.hobbies = hobbies;//assigning hobbies
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ContactEntity that = (ContactEntity)o;//changing object type
		if (this.id != that.id) return false;
		if (this.version != that.version) return false;
		if (this.firstname != null ? !this.firstname.equals(that
				.firstname) : that.firstname != null) return false;
		if (this.lastName != null ? !this.lastName.equals(that
				.lastName) : that.lastName != null) return false;
		if (this.birthDate != null ? !this.birthDate.equals(that
				.birthDate) : that.birthDate != null) return false;
		return true;
	}
	@Override
	public int hashCode() {
		int result = this.id;//outcome of hash code
		result = 31 * result + (this.firstname != null ? this.firstname.hashCode() : 0);//adding name to hash code
		result = 31 * result + (this.lastName != null ? this.lastName.hashCode() : 0);//adding surname to hash code
		result = 31 * result + (this.birthDate != null ? this.birthDate.hashCode() : 0);//adding birth data to hash code
		result = 31 * result + this.version;//adding version to hash code
		return result;
	}
	@Override
	public String toString() { return "contactEntity{" + "version=" + this.version
			+ ", birthDate=" + this.birthDate + ", lastName='"
			+ this.lastName + '\'' + ", firstName='"
			+ this.firstname + '\'' + ", id="
			+ this.id + '}'; }//whole information about contact
}
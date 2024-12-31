package springDataJpa;
import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;
@Entity
@Table(name = "hobby", schema = "", catalog = "SpringDataJpa")
public class HobbyEntity {
	String hobbyId = new String();//identifier
	public HobbyEntity() { }
	@Id
	@Column(name = "hobby_id", nullable = false, insertable = true,
	updatable = true, length = 20)
	public String getHobbyId() {
		return hobbyId;
	}
	public void setHobbyId(String hobbyId) {
		this.hobbyId = hobbyId;//assigning hobby identifier
	}
	Set<ContactEntity> contacts = new HashSet<ContactEntity>();//contact collection
	@ManyToMany
	@JoinTable(name = "contact_hobby_detail", joinColumns = @JoinColumn(name = "hobby_id"), inverseJoinColumns = @JoinColumn(name = "contact_id"))
	public Set<ContactEntity> getContacts() {
		return contacts;
	}
	public void setContacts(Set<ContactEntity> contacts) {
		this.contacts = contacts;//assigning contacts
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		HobbyEntity that = (HobbyEntity)o;//changing object type
		if (this.hobbyId != null ? !this.hobbyId.equals(that
				.hobbyId) : that.hobbyId != null) return false;
		return true;
	}
	@Override
	public int hashCode() { return this.hobbyId != null ? this.hobbyId.hashCode() : 0; }
	@Override
	public String toString() { return "hobbyEntity{" + "hobbyId='" + this.hobbyId
			+ '\'' + ", contacts=" + this.contacts
			+ '}'; }//whole information about hobby
}
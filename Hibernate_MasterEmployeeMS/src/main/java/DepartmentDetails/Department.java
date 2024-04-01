package DepartmentDetails	;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @Column(name = "id")
    private int id;

   // @Column(name = "name")
    private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

   // @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
  //  private List<Employee> employees;
//

	public Department() {
		
	}
}

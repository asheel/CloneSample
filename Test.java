package com.amazonaws.samples;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Test {

	public static void main(String ar[]) {
		Department d1=new Department("100","IT");
		Employee e1=new Employee("1","Ravi",d1);
		
		// Approach 1
		
		try {
		Employee e2 = (Employee) deepCopy(e1);
			e2.setEid("2");
			e2.setName("Mohan");
			
			e2.setDept(new Department("200","Finance"));
		
			
			System.out.println(e1.toString());
			System.out.println(e2.toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	static public Object deepCopy(Object oldObj) throws Exception
	   {
	      ObjectOutputStream oos = null;
	      ObjectInputStream ois = null;
	      try
	      {
	         ByteArrayOutputStream bos = 
	               new ByteArrayOutputStream(); 
	         oos = new ObjectOutputStream(bos); 
	         // serialize and pass the object
	         oos.writeObject(oldObj);   
	         oos.flush();               
	         ByteArrayInputStream bin = 
	               new ByteArrayInputStream(bos.toByteArray()); 
	         ois = new ObjectInputStream(bin);                  
	         // return the new object
	         return ois.readObject(); 
	      }
	      catch(Exception e)
	      {
	         System.out.println("Exception in ObjectCloner = " + e);
	         throw(e);
	      }
	      finally
	      {
	         oos.close();
	         ois.close();
	      }
}
}
class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3958105578760473307L;
	String name;
	String eid;
	Department dept;
	public Employee(String eid, String name, Department dept) {
		super();
		this.name = name;
		this.eid = eid;
		this.dept = dept;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dept == null) ? 0 : dept.hashCode());
		result = prime * result + ((eid == null) ? 0 : eid.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (dept == null) {
			if (other.dept != null)
				return false;
		} else if (!dept.equals(other.dept))
			return false;
		if (eid == null) {
			if (other.eid != null)
				return false;
		} else if (!eid.equals(other.eid))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", eid=" + eid + ", dept=" + dept + "]";
	}
}
	class Department implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = -8929367374498917391L;
		String id;
		@Override
		public String toString() {
			return "Department [id=" + id + ", name=" + name + "]";
		}
		public Department(String id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			//result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Department other = (Department) obj;
		//	if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
			//	return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		String name;
		/*private Employee getEnclosingInstance() {
			return Employee.this;
		}*/
	}
	

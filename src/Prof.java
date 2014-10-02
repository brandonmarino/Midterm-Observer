/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

//import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

public class Prof extends Observable{
	private String name;
	private Date midtermDate;
	//private ArrayList<Student> students;
	//private TeachingAssistant ta;

	public Prof(String aName) {
		this.name = aName;
		//this.students = new ArrayList<Student>();
	}

	public Date getMidterm() {
		return this.midtermDate;
	}

	public String getName() {
		return this.name;
	}
	/** Predefined function which will wrap important information 
	 *  to study and send it to the user
	 */
	public void setMidterm(Date date) {
		this.midtermDate = date;
		//for(Student s: this.students){
			//s.study(date);
		//}
		//ta.proctor(date);
		String status = "the midterm will cover chapter 3,section 5"; //prompt user
		char upType = 0; //set as postponed
		InformationWrapper wrap = new InformationWrapper(name, status, upType, midtermDate);
		barkWithPurpose(wrap);
	}
	
	/** Predefined function which will wrap important information 
	 *  to postpone the midterm and send it to the user
	 */
	public void postponeMidterm(Date date){
		/*this.midtermDate = date;
		for(Student s: this.students){
			s.party(date);
		}
		ta.postpone(date);*/
		String status = "I'm sick and must postpone"; //prompt user
		char upType = 1; //set as postponed
		InformationWrapper wrap = new InformationWrapper(name, status, upType, midtermDate);
		barkWithPurpose(wrap);
	}
	
	public void setTA(TeachingAssistant theTA){
		//this.ta = theTA;
		addObserver(theTA);  
		
	}
	
	public void addStudent(Student s){
		//this.students.add(s);
		addObserver(s); 
		
	}
	public void bark (){
		setChanged();
		notifyObservers();
	}
	
	
	public void barkWithPurpose(Object args){
		setChanged();
		notifyObservers(args);
	}
	
	public static void main(String[] args) {

		Prof p = new Prof("Babak");
		Student s = new Student("Homer");
		Student s2 = new Student("Bart");
		TeachingAssistant ta = new TeachingAssistant("Michael");
	
	
		p.addStudent(s);
		p.addStudent(s2);
		p.setTA(ta);
	
		Date midterm = new Date();
		p.setMidterm(midterm);
	
		p.postponeMidterm(new Date(midterm.getTime() + 1000000000));
	}

}

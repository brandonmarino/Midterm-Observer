/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class Student implements Observer{
	private String name;
	private Date midterm;
	private InformationWrapper info;
	
	public Student(String aName) {
		this.name = aName;
	}

	public String getName() {
		return this.name;
	}

	public void study(Date date){
		this.midterm = date;
		System.out.println("Update! "+ info.getName()+ " made a midterm! \nHe said: "+info.getStatus());
		System.out.println(name + " : Doh! I have to study hard for my midterm on " + this.midterm +"\n");
	}
	
	public void party(Date date){
		this.midterm = date;
		System.out.println("Update! "+ info.getName()+ " postponed a midterm! \nHe said: "+info.getStatus());
		System.out.println(name + " : Alright! I get to party since my midterm isn't until " + this.midterm +"\n");
	}
	public void update(Observable o, Object arg)  {  
		if ( o instanceof Prof ) {  
			info = (InformationWrapper)arg;
			if (info.getUpType() == 0){
				study(info.getMidtermDate());
			}if (info.getUpType() == 1){
				party(info.getMidtermDate());
			}
		}/* else {  
			  
		}*/
	}
}

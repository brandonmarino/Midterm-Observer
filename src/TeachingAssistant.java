/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class TeachingAssistant implements Observer{
	private String name;
	private Date midterm;
	private InformationWrapper info;
	
	public TeachingAssistant(String aName) {
		// TODO Auto-generated constructor stub
		this.name = aName;
	}

	public String getName() {
		return this.name;
	}

	public void proctor(Date date){
		this.midterm = date;
		System.out.println("Update! "+ info.getName()+ " made a midterm! \nHe said: "+info.getStatus());
		System.out.println(name + " : I have to proctor a midterm on " + this.midterm+"\n");
	}
	
	public void postpone(Date date){
		this.midterm = date;
		System.out.println("Update! "+ info.getName()+ " postponed a midterm! \nHe said: "+info.getStatus());
		System.out.println(name + " : Now the midterm is on " + this.midterm+"\n");
	}
	
	public void update(Observable o, Object arg)  {  
		if ( o instanceof Prof ) {  
			info = (InformationWrapper)arg;
			if (info.getUpType() == 0){
				proctor(info.getMidtermDate());
			}if (info.getUpType() == 1){
				postpone(info.getMidtermDate());
			}
		}/* else {  
			  
		}*/
	}
}

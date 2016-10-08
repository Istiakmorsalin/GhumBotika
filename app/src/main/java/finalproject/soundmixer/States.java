package finalproject.soundmixer;

public class States {

	String code = null;
	String name = null;
	boolean selected = false;

	public States(String name, boolean selected) {
		super();
		
		this.name = name;
		this.selected = selected;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}

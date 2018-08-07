/**
 * Animal Sound Enum class
 * @author User29
 *
 */
public enum AnimalSoundEnum {
	
	LION, BEAR, DOG, MONKEY, CROCODILE, SNAKE, PEACOCK, OWL, CRAWS;
	
	public String getSound() throws NullPointerException{
		
		switch(this) {
		case LION :
			return "roar";
		case BEAR:
			return "growl";
		case DOG:
			return "bark";
		case MONKEY:
			return "chatters";
		case CROCODILE:
			return "hiss";
		case SNAKE:
			return "hiss";
		case PEACOCK:
			return "scream";
		case OWL:
			return "hoots";
		case CRAWS:
			return "cow";
		default :
			return "sound";
		}
	}
	
}

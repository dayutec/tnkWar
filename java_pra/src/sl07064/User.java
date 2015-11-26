package sl07064;

public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.print("choose GIF format\n");
		ImageSave saver = TypeChooser.getSaver("GIF");
		saver.save(); 
		
		System.out.print("choose JPEG format\n");
		saver = TypeChooser.getSaver("JPEG");
		saver.save(); 
		
		System.out.print("choose PNG format\n");
		saver = TypeChooser.getSaver("PNG");
		saver.save(); 
	}

}

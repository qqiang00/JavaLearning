/**
 * 
 */
package Demo;

/**
 * @author qiang
 *
 */
public class FilenameDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String FPATH = "/home/usr/index.html";
		Filename myHomePage = new Filename(FPATH, '/', '.');
		System.out.println("Extension = " + myHomePage.extension());
		System.out.println("Filename = " + myHomePage.filename());
		System.out.println("Path = " + myHomePage.path());
		System.out.println("make some changes to commit to git");
		System.out.println("2nd commit");
	}

}

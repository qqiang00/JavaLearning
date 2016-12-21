/**
 * 
 */
package Demo;

/**
 * @author qiang
 * This class shows how to pick a filename, extension from a full file path
 * in which specific chars are used to indicate separator and extension
 * in this demo, we use lastIndexOf method to slice a full file path string.
 */
public class Filename {
	private String fullPath;
	private char pathSeparator,
				 extensionSeparator;
	
	public Filename(String str, char sep, char ext){
		fullPath = str;
		pathSeparator = sep;
		extensionSeparator = ext;
	}
	
	public String extension(){
		int dot = fullPath.lastIndexOf(extensionSeparator);
		return fullPath.substring(dot+1);
	}
	
	// gets filename without extension
	public String filename(){
		int dot = fullPath.lastIndexOf(extensionSeparator);
		int sep = fullPath.lastIndexOf(pathSeparator);
		return fullPath.substring(sep+1, dot);
	}
	
	public String path() {
		int sep = fullPath.lastIndexOf(pathSeparator);
		return fullPath.substring(0, sep);
	}
}

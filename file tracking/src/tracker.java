import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;//to find the file in system Java.nio is a separate package
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;//A simple visitor of files with default behavior to visit all files and to re-throw I/O errors.
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;
import java.util.EnumSet;
import static java.nio.file.FileVisitOption.*;
public class tracker {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter the file name:");
		Scanner sc=new Scanner(System.in);
		final String input=sc.nextLine();
		Path file=Paths.get("C:\\Users\\hp\\Desktop");
      try {
    	  SimpleFileVisitor<Path> pathVisitor=new SimpleFileVisitor<Path>() {
    	  //method to search the file in all the directory
    		
    		  @Override
    		  public FileVisitResult visitFile(Path file,BasicFileAttributes attr) {
    			  if(file.getFileName().toString().contains(input)) {
        			  System.out.println("File you have searched  "+ file+"  ");
        			  return FileVisitResult.CONTINUE;
        		  }
    			  else {
    				  return FileVisitResult.CONTINUE;
    			  }
    			  
    		  }
    		  //method that report the error and handle them
    		  @Override
    		  public FileVisitResult visitFileFailed(Path p,IOException e) {
    			  System.err.println("error"+e +p);
    			  return FileVisitResult.CONTINUE;
    		  }
    	  };
    	  
    			  
    	  //enum for handling symbolic links in a file\
      EnumSet<FileVisitOption> option=EnumSet.of(FOLLOW_LINKS);
      Files.walkFileTree(file, option, 5, pathVisitor);
    	  
      }
      
      catch(Exception e) {
    	  
      }
      finally {
    	  
      }
      
	}

}

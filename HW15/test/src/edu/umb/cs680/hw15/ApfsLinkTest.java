package edu.umb.cs680.hw15;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;


class ApfsLinkTest {
	LocalDateTime localTime = LocalDateTime.now();
	APFS ApfsFileSystem = APFS.getAPFSFileSystem();
	ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.initFileSystem("Apfs", 500);
	ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, localTime,"ApfsFile",localTime);
	ApfsDirectory home = new ApfsDirectory(root, "home", 0, localTime,"ApfsFile",localTime);
	ApfsDirectory code = new ApfsDirectory(home, "code", 0, localTime,"ApfsFile",localTime);
	ApfsFile a = new ApfsFile(applications, "a", 10, localTime,"ApfsFile",localTime);
	ApfsFile b = new ApfsFile(applications, "b", 15, localTime,"ApfsFile",localTime);
	ApfsFile c = new ApfsFile(home, "c", 20, localTime,"ApfsFile",localTime);
	ApfsFile d = new ApfsFile(home, "d", 50, localTime,"ApfsFile",localTime);
	ApfsFile e = new ApfsFile(code, "e", 10, localTime,"ApfsFile",localTime);
	ApfsFile f = new ApfsFile(code, "f", 20, localTime,"ApfsFile",localTime);
	ApfsLink x = new ApfsLink(home, "x", 0, localTime, "ApfsFile", localTime, applications);
	ApfsLink y = new ApfsLink(code, "y", 0, localTime,"ApfsFile",localTime,b);
	
	
	@Test
	public void testLink() {
		assertTrue(x.isLink());
		assertTrue(y.isLink());
	}
	
	@Test
	public void testSize() {
		assertEquals(0, x.getSize());
		assertEquals(0,y.getSize());
	}
	
	@Test
	public void testLinksInDirectory() {
		assertSame("x", home.getLinks().get(0).getName());
		assertSame("y", code.getLinks().get(0).getName());
			
	}
	    
	@Test
    public void testEqualityOfLinkX() {
		ApfsDirectory expected = applications;
		ApfsElement actual = x.getTarget();
		assertSame(expected, actual);
	}
	  
	@Test
	public void testEqualityOfLinkY() {
		ApfsFile expected = b;
		ApfsElement actual = y.getTarget();
		assertSame(expected, actual);
	}

}

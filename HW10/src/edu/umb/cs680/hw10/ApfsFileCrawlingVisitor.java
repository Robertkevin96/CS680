package edu.umb.cs680.hw10;
import java.util.LinkedList;

public class ApfsFileCrawlingVisitor implements ApfsFSVisitor{
	 private LinkedList<ApfsFile> files = new LinkedList<>();
	@Override
	public void visit(ApfsLink link) {
		
		return;
	}

	@Override
	public void visit(ApfsDirectory dir) {
		
		return;
	}

	@Override
	public void visit(ApfsFile file) {
		
		files.add(file);
	}

	public LinkedList<ApfsFile> getFiles() {
		return files;
	}

	public void setFiles(LinkedList<ApfsFile> files) {
		this.files = files;
	}

}

package Member;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import Member.UserM;
import projectproject.reController;

public class FileSave {
	public void cListWriter(UserM clist) throws IOException {

		OutputStream os = new FileOutputStream("clist.clist");
		ObjectOutputStream out = new ObjectOutputStream(os);

		out.writeObject(clist);

		out.close();
	}

	public UserM cListReader() throws IOException, ClassNotFoundException {

		File f = new File("clist.clist");
		if (f.isFile()) {
			InputStream is = new FileInputStream("clist.clist");
			ObjectInputStream in = new ObjectInputStream(is);

			UserM clist = (UserM) in.readObject();
			in.close();

			return clist;
		} else
			return null;

	}
	public void rListWriter(reController rlist) throws IOException {

		OutputStream os = new FileOutputStream("rlist.rlist");
		ObjectOutputStream out = new ObjectOutputStream(os);

		out.writeObject(rlist);

		out.close();
	}

	public reController rListReader() throws IOException, ClassNotFoundException {

		File f = new File("rlist.rlist");
		if (f.isFile()) {
			InputStream is = new FileInputStream("rlist.rlist");
			ObjectInputStream in = new ObjectInputStream(is);

		 reController rlist = ( reController) in.readObject();
			in.close();

			return rlist;
		} else
			return null;

	}
}

// This class is used to do the marshalling of data.
// It writes data to an OutputStream (of some socket).

import java.io.*;

public class ParseOut {
	// OutputStream to write data to
	private OutputStream os;

	public ParseOut (OutputStream os) {
		this.os = os;
	}
    
	public void putInt (int v) {
		int r = 0;
		byte [] b = new byte[4];

		for (int i = 0; i < 4; i++) {
			b[3-i] = (byte) (v % 256);
			v = v / 256;
		}
		try {
			os.write(b);
		} catch (IOException ioe) {
		}
	}
    
	public void putLong (long v) {
		putInt((int) v);
	}
    
	public void putBool (boolean v) {
		try {
			if (v) {
				// Not equal to 0 is true
				os.write(1);
			} else {
				// 0 is false
				os.write(0);
			}
		} catch (IOException ioe) {
		}
	}
    
	public void putString (String v) {
		byte [] b = v.getBytes();
		// First save its lenght
		putInt(b.length);

		try { 
			os.write(b);
		} catch (IOException ioe) {
		}
	}
    
        public void putObject (Object obj) {
	   System.out.println ("Ojooooo!! : has de implmementar estoooo");
	}

	public void putObjectRef(ObjectRef oref) {
		try {
			// Write the address of the ORB that stores the object
			putString(oref.getHost());
			// Write the port of the ORB that stores the object
			putInt(oref.getPort());
			// Write the object id of the object
			putInt(oref.getOid());
			// Write the interface id of the object
			putInt(oref.getIid());
		} catch (Exception ioe) {
		}
	}
}

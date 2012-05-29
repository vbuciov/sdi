


public class SkeletonB implements Skeleton {
    // Interface identifier for B, ClassB, etc.
    // Each class implementing Skeleton must have a different value!
    // (Ideally, this value is generated by some compiler)
    private String iid = "B";

    public void upcall (ParseIn pin, ParseOut pou, Object obj) {
        // We can assume that obj is an instance of a class
        // that implements B
            B b = (B)obj;

        // Read a number that identifies the method to invoke
        int methodNumber = pin.getInt();

        switch (methodNumber) {
            // By convention, 1 is for "save"
            case 1: {
                String s;
                int i;

                // Read a string ("name" of the integer to save)
                s = pin.getString();
                // Read the integer to save
                i = pin.getInt();

                // Invoke the corresponding method
                b.save(s, i);

                // In this case, it is not necessary
                // to write any value as a return

                break;
            }
            // By convention, 2 is for "load"
            case 2: {
                String s;
                int i;
                // Read a string ("name" of the integer to load)
                s = pin.getString();

                // Invoke the corresponding method
                i = b.load(s);

                // Send back the value, as a result
                pou.putInt(i);

                break;
            }
            case 3: {
                String s,s2;
                int i;
                s = pin.getString();
                s2 = pin.getString();

                // Invoke the corresponding method
                i = b.add(s,s2);

                // Send back the value, as a result
                pou.putInt(i);

                break;
            }
            case 4: {
                String s,s2;
                int i;
                s = pin.getString();
                s2 = pin.getString();

                // Invoke the corresponding method
                i = b.sub(s,s2);

                // Send back the value, as a result
                pou.putInt(i);

                break;
            }
        }
    }

    public String getIid () {
        return iid;
    }

    public Proxy createProxy (ObjectRef oref) {
        return new ProxyB (oref);
    }
}

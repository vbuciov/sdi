public class SkeletonNameService implements Skeleton {
    // Interface identifier for A, ClassA, etc.
    // Each class implementing Skeleton must have a different value!
    // (Ideally, this value is generated by some compiler)
    private int iid = 3;

    public void upcall (ParseIn pin, ParseOut pou, Object obj) {
            NameService NS = (NameService)obj;

        // Read a number that identifies the method to invoke
        int methodNumber = pin.getInt();

        switch (methodNumber) {
            // By convention, 1 is for "bind"
            case 1: {
                String s;
                Object i;

                // Read a string ("name" of the integer to save)
                s = pin.getString();
                // Read the integer to save
                i = pin.getObject();

                // Invoke the corresponding method
                //~ System.out.println("binding: " + s);
                NS.bind(s, i);

                // In this case, it is not necessary
                // to write any value as a return

                break;
            }
            // By convention, 2 is for "resolve"
            case 2: {
                String s;
                Object i;
                // Read a string ("name" of the integer to load)
                s = pin.getString();

                // Invoke the corresponding method
                //~ System.out.println("resolving: " + s);
                i = NS.resolve(s);

                // Send back the value, as a result
                pou.putObject(i);

                break;
            }
        }
    }

    public int getIid () {
        return iid;
    }

    public Proxy createProxy (ObjectRef oref) {
        return new ProxyNameService (oref);
    }
}

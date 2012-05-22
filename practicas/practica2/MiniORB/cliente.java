/*
 * cliente.java
 *
 * Copyright 2012 MAHIQUES CARRASCO, Luis M <luimacar@pc0406>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 *
 *
 */


public class cliente {
    String hostc, hostNS;
    int portc, portNS, oid = 0, iid = 0;
    NameService NS;
    A pA = null;



    public static void main (String args[]) {
        /*for (int i = 0; i<args.length; i++)
        System.err.println(args[i]);*/
        cliente c = new cliente();
        if (! c.parseArgs(args)){
            System.err.println(
                "use:\n\t $ java cliente <hostc> <portc> <hostNS> <portNS> [oid] [iid]"
                );
        }
        else
            c.pruebaProxyByNameService();
    }


    public void pruebaProxyByNameService(){
        NS = new ProxyNameService(new ObjectRef(hostNS, portNS, 1, 3));

        //pA2 = new ProxyA(new ObjectRef("localhost", 5001, 1, 1));
        //~ NS.bind("server",new ProxyB(new ObjectRef("127.0.0.1",5002,2,2)));
        //~ NS.bind("server2",new ProxyB(new ObjectRef("127.0.0.1",5003,2,2)));
        //System.out.println(pB.add("prueba","maspruebas"));
        //~ pB = (B)NS.resolve("server2");
        //pA2.save("prueba", 564);
        //~ pB.save("maspruebas", 8456487);
        //~ System.out.println(pB.load("maspruebas"));
        //System.out.println(pA2.load("prueba"));
        //~ System.out.println(pB.add("prueba","maspruebas"));
        //~ NS.bind("ejemploA",new
        //NS.bind("mientero",new Integer(5));
        //System.out.println(NS.resolve("mientero"));
        System.out.println("antes del resolve");
        System.out.println(NS);
        //NS.bind("pA", pA);
        pA = (A)NS.resolve("ejemploA");
        System.out.println("después del resolve");
        pA.save("cuarentaydos", 42);
        System.out.println("después del save");
        System.out.println("antes del load");
        System.out.println(pA.load("cuarentaydos"));
        System.out.println("despues del load");

    }

    public boolean parseArgs(String args[]){

        if (args.length < 6){
            System.err.println("Invalid argument number: " + args.length);
            return false;
        }

        hostc = args[0];

        try {
            portc = (new Integer(args[1])).intValue();
        } catch (Exception e) {
            System.err.println("Invalid port number: " + args[1]);
            return false;
        }

        hostNS = args[2];

        try {
            portNS = (new Integer(args[3])).intValue();
        } catch (Exception e) {
            System.err.println("Invalid port number: " + args[3]);
            return false;
        }

        //if (args.length > 4)
        try {
            oid = (new Integer(args[4])).intValue();
        } catch (Exception e) {
            System.err.println("Invalid oid number: " + args[4]);
            return false;
        }

        //if (args.length > 5)
        try {
            iid = (new Integer(args[5])).intValue();
        } catch (Exception e) {
            System.err.println("Invalid iid number: " + args[5]);
            return false;
        }

        return true;

    }
}


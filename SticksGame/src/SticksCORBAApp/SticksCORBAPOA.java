package SticksCORBAApp;


/**
* SticksCORBAApp/SticksCORBAPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from SticksCORBA.idl
* 6 ������� 2016 �. 12:53:07 MSK
*/

public abstract class SticksCORBAPOA extends org.omg.PortableServer.Servant
 implements SticksCORBAApp.SticksCORBAOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("clientMove", new java.lang.Integer (0));
    _methods.put ("serverMove", new java.lang.Integer (1));
    _methods.put ("shutdown", new java.lang.Integer (2));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // SticksCORBAApp/SticksCORBA/clientMove
       {
         byte coords[] = SticksCORBAApp.SerializedObjectHelper.read (in);
         this.clientMove (coords);
         out = $rh.createReply();
         break;
       }

       case 1:  // SticksCORBAApp/SticksCORBA/serverMove
       {
         byte $result[] = null;
         $result = this.serverMove ();
         out = $rh.createReply();
         SticksCORBAApp.SerializedObjectHelper.write (out, $result);
         break;
       }

       case 2:  // SticksCORBAApp/SticksCORBA/shutdown
       {
         this.shutdown ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:SticksCORBAApp/SticksCORBA:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public SticksCORBA _this() 
  {
    return SticksCORBAHelper.narrow(
    super._this_object());
  }

  public SticksCORBA _this(org.omg.CORBA.ORB orb) 
  {
    return SticksCORBAHelper.narrow(
    super._this_object(orb));
  }


} // class SticksCORBAPOA
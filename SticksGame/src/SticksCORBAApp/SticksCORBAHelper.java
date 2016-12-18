package SticksCORBAApp;


/**
* SticksCORBAApp/SticksCORBAHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from SticksCORBA.idl
* 6 ������� 2016 �. 12:53:07 MSK
*/

abstract public class SticksCORBAHelper
{
  private static String  _id = "IDL:SticksCORBAApp/SticksCORBA:1.0";

  public static void insert (org.omg.CORBA.Any a, SticksCORBAApp.SticksCORBA that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static SticksCORBAApp.SticksCORBA extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (SticksCORBAApp.SticksCORBAHelper.id (), "SticksCORBA");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static SticksCORBAApp.SticksCORBA read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_SticksCORBAStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, SticksCORBAApp.SticksCORBA value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static SticksCORBAApp.SticksCORBA narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof SticksCORBAApp.SticksCORBA)
      return (SticksCORBAApp.SticksCORBA)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      SticksCORBAApp._SticksCORBAStub stub = new SticksCORBAApp._SticksCORBAStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static SticksCORBAApp.SticksCORBA unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof SticksCORBAApp.SticksCORBA)
      return (SticksCORBAApp.SticksCORBA)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      SticksCORBAApp._SticksCORBAStub stub = new SticksCORBAApp._SticksCORBAStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
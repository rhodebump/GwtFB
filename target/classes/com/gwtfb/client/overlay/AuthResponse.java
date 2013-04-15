package com.gwtfb.client.overlay;


import com.google.gwt.core.client.JavaScriptObject;

/**
 * Created with IntelliJ IDEA.
 * User: prhodes
 * Date: 4/7/13
 * Time: 3:39 PM
 * To change this template use File | Settings | File Templates.
 *
 *
 */
public class AuthResponse extends JavaScriptObject {

    /*
    {
        status: 'connected',
        authResponse: {
            accessToken: '...',
            expiresIn:'...',
            signedRequest:'...',
            userID:'...'
        }
    }

     */

    public static final String STATUS_CONNECTED = "connected";
    public static final String STATUS_NOTCONNECTED = "notConnected";
    public static final String STATUS_UNKNOWN = "unknown";



    public final native String getStatus()
    /*-{
    return this.status;
    }-*/;



    protected AuthResponse() {}

    public final native String getAccessToken() /*-{ return this.accessToken; }-*/;

    public final native String getUserID() /*-{ return this.userID; }-*/;

    public final native String getExpiresIn() /*-{ return this.expiresIn; }-*/;



}

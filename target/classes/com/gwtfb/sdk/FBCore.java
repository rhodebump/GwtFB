package com.gwtfb.sdk;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtfb.client.overlay.AuthResponse;

/**
 * Class that wraps facebook Javascript SDK
 * 
 * @author ola the wrapper
 */
public class FBCore {

	/**
	 * Wrapper method
	 * @see http://developers.facebook.com/docs/reference/javascript/FB.init
	 */
	public native void init (String appId, boolean status, boolean cookie, boolean xfbml) /*-{
		$wnd.FB.init({
			'appId': appId, 
			'status': status,
			'cookie': cookie,
			'xfbml' : xfbml
		});
	}-*/;
	
	
	/**
	 * Wrapper method
	 */
	public native void api (String path, AsyncCallback<JavaScriptObject> callback) /*-{
		var app=this;
		$wnd.FB.api (path, function(response){
	        app.@com.gwtfb.sdk.FBCore::callbackSuccess(Lcom/google/gwt/user/client/rpc/AsyncCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback,response);
		});
	}-*/;

	 public native void api (String path, String params, AsyncCallback<JavaScriptObject> callback) /*-{
       var app=this;
       $wnd.FB.api (path, params, function(response){
           app.@com.gwtfb.sdk.FBCore::callbackSuccess(Lcom/google/gwt/user/client/rpc/AsyncCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback,response);
       });
   }-*/;

	/**
	 * Wrapper method
	 */
	public native void api (String path, JavaScriptObject params, AsyncCallback<JavaScriptObject> callback) /*-{
		var app=this;
		$wnd.FB.api (path, params, function(response){
		    app.@com.gwtfb.sdk.FBCore::callbackSuccess(Lcom/google/gwt/user/client/rpc/AsyncCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback,response);
		});
	}-*/;
	
	/**
	 * Wrapper method
	 */
	public native void api (String path, String method,JavaScriptObject params, AsyncCallback<JavaScriptObject> callback) /*-{
		var app=this;
		$wnd.FB.api (path,method, params, function(response){
		    app.@com.gwtfb.sdk.FBCore::callbackSuccess(Lcom/google/gwt/user/client/rpc/AsyncCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback,response);
		});
	}-*/;
	

	/**
	 * Wrapper method for the OLD REST API
	 */
	public native void api (JavaScriptObject params, AsyncCallback<JavaScriptObject> callback) /*-{
    	var app=this;
    	$wnd.FB.api(params,function(response){
        	app.@com.gwtfb.sdk.FBCore::callbackSuccess(Lcom/google/gwt/user/client/rpc/AsyncCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback,response);
    	});
	}-*/; 
	
	/**
	 * Wrapper method
	 */
	public native void getLoginStatus (AsyncCallback<JavaScriptObject> callback) /*-{
        var app=this;
		$wnd.FB.getLoginStatus(function(response) {
           // var status = response.status;
            $wnd.fbstatus = response.status;
            app.@com.gwtfb.sdk.FBCore::callbackSuccess(Lcom/google/gwt/user/client/rpc/AsyncCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback,response);
		});
		
	}-*/;

      /*
    FB.getLoginStatus(function(response) {
      // this will be called when the roundtrip to Facebook has completed
    }, true);
        */

   /*
   this getLoginStatus can be passed a boolean to make sure we get the current login status
    */
    public native void getLoginStatus (AsyncCallback<JavaScriptObject> callback,boolean refresh) /*-{
           var app=this;
   		$wnd.FB.getLoginStatus(function(response) {
              // var status = response.status;
               $wnd.fbstatus = response.status;
               app.@com.gwtfb.sdk.FBCore::callbackSuccess(Lcom/google/gwt/user/client/rpc/AsyncCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback,response);
   		},refresh);

   	}-*/;



	/**
	 * Wrapper method
	 */
	public native AuthResponse getAuthResponse () /*-{
		return $wnd.FB.getAuthResponse();
	}-*/;


    public native String getStatus () /*-{
   		return $wnd.fbstatus;
   	}-*/;





	/**
	 * Wrapper method
	 */
	public native void login (AsyncCallback<JavaScriptObject> callback) /*-{
		var app=this;
        $wnd.FB.login (function(response){
    	    app.@com.gwtfb.sdk.FBCore::callbackSuccess(Lcom/google/gwt/user/client/rpc/AsyncCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback,response);
		});
	}-*/;
	
	/**
	 * Wrapper method
	 */
	public native void login (AsyncCallback<JavaScriptObject> callback ,String permissions) /*-{
       	var app=this;
        $wnd.FB.login (function(response){
    	    app.@com.gwtfb.sdk.FBCore::callbackSuccess(Lcom/google/gwt/user/client/rpc/AsyncCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback,response);
		},{perms:permissions});
	}-*/;
	
	/**
	 * Wrapper method
	 */
	public native void logout (AsyncCallback<JavaScriptObject> callback) /*-{
		var app=this;
		$wnd.FB.logout(function(response){
    	    app.@com.gwtfb.sdk.FBCore::callbackSuccess(Lcom/google/gwt/user/client/rpc/AsyncCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback,response);
		});
	}-*/;
	
	/**
	 * Wrapper method
	 */
	public native void ui (JavaScriptObject params, AsyncCallback<JavaScriptObject> callback) /*-{
		var app=this;
		$wnd.FB.ui(params,function(response){
    	    app.@com.gwtfb.sdk.FBCore::callbackSuccess(Lcom/google/gwt/user/client/rpc/AsyncCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback,response);
		});
	}-*/;
	
	/*
     * Called when method succeeded.
     */
    protected void callbackSuccess(AsyncCallback<JavaScriptObject> callback, JavaScriptObject obj) {
        callback.onSuccess (obj);
    }


}

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;


public class PhpPostTesting {

	
	String username = "yukki";
	HttpClient httpClient;
	HttpPost httpPost;
	
	
	
  

    
	public void checkDuplicate(){
		
		httpClient = new DefaultHttpClient();
		httpPost = new HttpPost("http://sociamvm-yi1g09.ecs.soton.ac.uk/personels.php");
		
	    MultipartEntityBuilder multipartEntity = MultipartEntityBuilder.create();        
	    multipartEntity.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

	    multipartEntity.addTextBody("username", username);
		
	    httpPost.setEntity(multipartEntity.build());
	    try {
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			
			String str = new BasicResponseHandler().handleResponse(response);
			
			System.out.println(""+str);
			
		    entity.consumeContent();
		    httpClient.getConnectionManager().shutdown(); 
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
		System.out.println();
	}
	
	
	
	public static void main(String[] args) {
		PhpPostTesting mypPhpPostTesting = new PhpPostTesting();
		mypPhpPostTesting.checkDuplicate();
	}
	
}

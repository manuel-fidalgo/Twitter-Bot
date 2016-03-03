import javax.swing.JOptionPane;

//Twitter Imports
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

//Google & YouTube Imports
/* YouTube API unused.
YouTube youtube;
String cliente = "943835581973-aniih2m7q89rc213hgh88b15fnpnql0s.apps.googleusercontent.com";
String secreto = "yGL3TM6HEMomsyjCtB3Z0lCN";
*/
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.java6.auth.oauth2.FileCredentialStore;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.YouTubeRequestInitializer;
import com.google.api.services.youtube.model.Activity;
import com.google.api.services.youtube.model.ActivityContentDetails;
import com.google.api.services.youtube.model.ActivitySnippet;
import com.google.api.services.youtube.model.Channel;
import com.google.api.services.youtube.model.ChannelListResponse;
import com.google.api.services.youtube.model.ResourceId;


@SuppressWarnings({ "deprecation", "unused" })
public class Twitter_Bot{
	public static void main(String ar[]) {
		Twitter twitter;
		Status tweet;
		Video video;
		ConfigurationBuilder cb;
		
		cb = new ConfigurationBuilder(); authenticate(cb);
		twitter = new TwitterFactory(cb.build()).getInstance();
		video = new Video();
		
		while(true){
			try{
				
				tweet = twitter.updateStatus(video.getRandomVideo()); 
				Thread.sleep(3000000); //Correct value 1h: 3.000.000
				//TwitterException
			}catch(InterruptedException e){
				JOptionPane.showMessageDialog(null, "Interrupcion de la espera!");
			}
			catch (TwitterException e) {
				JOptionPane.showMessageDialog(null, "Se ha producido algun error al enviar el tweet!\n"+e.getErrorMessage());
			}
		}

	}

	private static void authenticate(ConfigurationBuilder cb) {
		cb.setDebugEnabled(true);
		cb.setOAuthConsumerKey("XXXXXXXXXX");
		cb.setOAuthConsumerSecret("XXXXXXXXXXXXX");
		cb.setOAuthAccessToken("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		cb.setOAuthAccessTokenSecret("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
	}

}
